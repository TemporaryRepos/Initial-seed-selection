public class Builder {
	public static final long MAX_HEAP_FOR_PRESORT = (2048L * 1024) * 1024;

	public static final long MIN_HEAP_FOR_PRESORT = (10L * 1024) * 1024;

	private java.lang.String parse(java.lang.String filepath) {
		java.io.File in = new java.io.File(filepath);
		java.io.File out = new java.io.File(in.getParentFile(), "out.data");
		try (final java.io.BufferedReader ir = com.google.common.io.Files.newReader(in, com.google.common.base.Charsets.UTF_8);final java.io.BufferedWriter ow = com.google.common.io.Files.newWriter(out, com.google.common.base.Charsets.UTF_8)) {
			java.lang.String line = null;
			while (null != (line = ir.readLine())) {
				java.lang.String[] seg = line.split(",");
				java.lang.StringBuilder bui = new java.lang.StringBuilder();
				for (int i = 6; i < seg.length; ++i) {
					bui.append(seg[i]);
				}
				bui.append("\n");
				ow.write(bui.toString());
			} 
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return out.getAbsolutePath();
	}

	private java.lang.String reverse(java.lang.String raw) {
		java.lang.StringBuilder bui = new java.lang.StringBuilder();
		for (int i = raw.length() - 1; i >= 0; --i) {
			bui.append(raw.charAt(i));
		}
		return bui.toString();
	}

	public void sortFile(java.io.File in, java.io.File out, java.util.Comparator<java.lang.String> cmp) {
		try {
			long availMem = java.lang.Runtime.getRuntime().maxMemory() - ((2048 * 1024) * 1024);
			long maxMem = availMem >> 1;
			if (maxMem > dict.build.Builder.MAX_HEAP_FOR_PRESORT) {
				maxMem = dict.build.Builder.MAX_HEAP_FOR_PRESORT;
			} else if (maxMem < dict.build.Builder.MIN_HEAP_FOR_PRESORT) {
				maxMem = dict.build.Builder.MIN_HEAP_FOR_PRESORT;
			}
			final com.fasterxml.sort.std.TextFileSorter sorter = new com.fasterxml.sort.std.TextFileSorter(new com.fasterxml.sort.SortConfig().withMaxMemoryUsage(maxMem));
			sorter.sort(new java.io.FileInputStream(in), new java.io.PrintStream(out));
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public java.lang.String genLeft(java.lang.String rawTextFile, int maxLen, int memSize) {
		java.io.File rawFile = new java.io.File(rawTextFile);
		java.io.File dir = rawFile.getParentFile();
		java.io.File ngramFile = new java.io.File(dir, "ngram_left.data");
		java.io.File ngramSort = new java.io.File(dir, "sort_ngram_left.data");
		java.io.File ngramfreq = new java.io.File(dir, "freq_ngram_left.data");
		java.io.File ngramFreqSort = new java.io.File(dir, "freq_ngram_left_sort.data");
		try (final java.io.BufferedReader breader = com.google.common.io.Files.newReader(rawFile, com.google.common.base.Charsets.UTF_8);final java.io.BufferedWriter writer = com.google.common.io.Files.newWriter(ngramFile, com.google.common.base.Charsets.UTF_8);final java.io.BufferedWriter freqWriter = com.google.common.io.Files.newWriter(ngramfreq, com.google.common.base.Charsets.UTF_8)) {
			java.lang.String line = null;
			while (null != (line = breader.readLine())) {
				line = line.replaceAll("\\p{Punct}", " ").replaceAll("\\pP", " ").replaceAll("　", " ").replaceAll("\\p{Blank}", " ").replaceAll("\\p{Space}", " ").replaceAll("\\p{Cntrl}", " ").replaceAll("[的很了么呢是嘛]", " ");
				for (java.lang.String sen : com.google.common.base.Splitter.on(" ").omitEmptyStrings().splitToList(line)) {
					sen = reverse(sen.trim());
					sen = ("$" + sen) + "$";
					java.lang.System.out.println(sen);
					java.lang.System.out.println(sen.length());
					for (int i = 0; i < sen.length(); ++i) {
						for (int j = i + 1; (j < ((i + maxLen) + 1)) && (j <= sen.length()); ++j) {
							java.lang.String w = sen.substring(i, j);
							writer.write(w + "\n");
						}
					}
				}
			} 
			sortFile(ngramFile, ngramSort, new java.util.Comparator<java.lang.String>() {
				@java.lang.Override
				public int compare(java.lang.String o1, java.lang.String o2) {
					return o1.compareTo(o2);
				}
			});
			try (final java.io.BufferedReader nsr = com.google.common.io.Files.newReader(ngramSort, com.google.common.base.Charsets.UTF_8)) {
				java.lang.String ngram = null;
				java.lang.String curr = null;
				java.util.List<java.lang.String> sameWord = com.google.common.collect.Lists.newLinkedList();
				boolean pause = false;
				while (pause || (null != (curr = nsr.readLine()))) {
					if (null == ngram) {
						sameWord.add(curr);
						ngram = curr;
					} else if (curr.startsWith(ngram)) {
						sameWord.add(curr);
						pause = false;
					} else {
						if (sameWord.isEmpty()) {
							pause = false;
							sameWord.add(curr);
							ngram = curr;
							continue;
						}
						dict.build.CounterMap right = new dict.build.CounterMap();
						int freq = 0;
						for (java.lang.String w : sameWord) {
							if (!w.startsWith(ngram)) {
								break;
							}
							if (w.equals(ngram)) {
								continue;
							}
							++freq;
							right.incr(w.substring(ngram.length()));
						}
						double re = 0.0;
						for (java.lang.String t : right.countAll().keySet()) {
							double p = (right.get(t) * 1.0) / freq;
							re += ((-1) * p) * java.lang.Math.log(p);
						}
						freqWriter.write(((reverse(ngram) + "\t") + re) + "\n");
						java.util.List<java.lang.String> newlist = com.google.common.collect.Lists.newLinkedList();
						for (java.lang.String w : sameWord) {
							if (!w.equals(ngram)) {
								newlist.add(w);
							}
						}
						sameWord = newlist;
						if (sameWord.isEmpty()) {
							pause = false;
							sameWord.add(curr);
							ngram = curr;
							continue;
						}
						ngram = sameWord.get(0);
						if (curr.startsWith(ngram)) {
							sameWord.add(curr);
							pause = false;
						} else {
							pause = true;
						}
					}
				} 
			}
			sortFile(ngramfreq, ngramFreqSort, new java.util.Comparator<java.lang.String>() {
				@java.lang.Override
				public int compare(java.lang.String o1, java.lang.String o2) {
					return o1.compareTo(o2);
				}
			});
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return ngramFreqSort.getAbsolutePath();
	}

	public java.lang.String genFreqRight(java.lang.String rawTextFile, int maxLen, int memSize) {
		java.io.File rawFile = new java.io.File(rawTextFile);
		java.io.File dir = rawFile.getParentFile();
		java.io.File ngramFile = new java.io.File(dir, "ngram.data");
		java.io.File ngramSort = new java.io.File(dir, "ngram_sort.data");
		java.io.File ngramfreq = new java.io.File(dir, "freq_ngram.data");
		java.io.File ngramfreqSort = new java.io.File(dir, "freq_ngram_sort.data");
		try (final java.io.BufferedReader breader = com.google.common.io.Files.newReader(rawFile, com.google.common.base.Charsets.UTF_8);final java.io.BufferedWriter writer = com.google.common.io.Files.newWriter(ngramFile, com.google.common.base.Charsets.UTF_8);final java.io.BufferedWriter freqWriter = com.google.common.io.Files.newWriter(ngramfreq, com.google.common.base.Charsets.UTF_8)) {
			java.lang.String line = null;
			while (null != (line = breader.readLine())) {
				line = line.replaceAll("\\p{Punct}", " ").replaceAll("\\pP", " ").replaceAll("　", " ").replaceAll("\\p{Blank}", " ").replaceAll("\\p{Space}", " ").replaceAll("\\p{Cntrl}", " ").replaceAll("[的很了么呢是嘛]", " ");
				for (java.lang.String sen : com.google.common.base.Splitter.on(" ").omitEmptyStrings().splitToList(line)) {
					sen = sen.trim();
					sen = ("$" + sen) + "$";
					java.lang.System.out.println(sen);
					java.lang.System.out.println(sen.length());
					for (int i = 0; i < sen.length(); ++i) {
						for (int j = i + 1; (j < ((i + maxLen) + 1)) && (j <= sen.length()); ++j) {
							java.lang.String w = sen.substring(i, j);
							writer.write(w + "\n");
						}
					}
				}
			} 
			java.lang.System.out.println("gen sorting...");
			sortFile(ngramFile, ngramSort, new java.util.Comparator<java.lang.String>() {
				@java.lang.Override
				public int compare(java.lang.String o1, java.lang.String o2) {
					return o1.compareTo(o2);
				}
			});
			try (final java.io.BufferedReader nsr = com.google.common.io.Files.newReader(ngramSort, com.google.common.base.Charsets.UTF_8)) {
				java.lang.String ngram = null;
				java.lang.String curr = null;
				java.util.List<java.lang.String> sameWord = com.google.common.collect.Lists.newLinkedList();
				boolean pause = false;
				while (pause || (null != (curr = nsr.readLine()))) {
					if (null == ngram) {
						sameWord.add(curr);
						ngram = curr;
					} else if (curr.startsWith(ngram)) {
						sameWord.add(curr);
					} else {
						if (sameWord.isEmpty()) {
							pause = false;
							sameWord.add(curr);
							ngram = curr;
							continue;
						}
						dict.build.CounterMap right = new dict.build.CounterMap();
						int freq = 0;
						for (java.lang.String w : sameWord) {
							if (!w.startsWith(ngram)) {
								break;
							}
							if (w.equals(ngram)) {
								continue;
							}
							++freq;
							right.incr(w.substring(ngram.length()));
						}
						double re = 0.0;
						for (java.lang.String t : right.countAll().keySet()) {
							double p = (right.get(t) * 1.0) / freq;
							re += ((-1) * p) * java.lang.Math.log(p);
						}
						freqWriter.write(((((ngram + "\t") + freq) + "\t") + re) + "\n");
						java.util.List<java.lang.String> newlist = com.google.common.collect.Lists.newLinkedList();
						for (java.lang.String w : sameWord) {
							if (!w.equals(ngram)) {
								newlist.add(w);
							}
						}
						sameWord = newlist;
						if (sameWord.isEmpty()) {
							pause = false;
							sameWord.add(curr);
							ngram = curr;
							continue;
						}
						ngram = sameWord.get(0);
						if (curr.startsWith(ngram)) {
							sameWord.add(curr);
						} else {
							pause = true;
						}
					}
				} 
			}
			sortFile(ngramfreq, ngramfreqSort, new java.util.Comparator<java.lang.String>() {
				@java.lang.Override
				public int compare(java.lang.String o1, java.lang.String o2) {
					return o1.compareTo(o2);
				}
			});
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return ngramfreqSort.getAbsolutePath();
	}

	public java.lang.String mergeEntropy(java.lang.String freqRight, java.lang.String left) {
		java.io.File frFile = new java.io.File(freqRight);
		java.io.File lFile = new java.io.File(left);
		java.io.File mergeTmp = new java.io.File(frFile.getParentFile(), "merge.tmp");
		java.io.File mergeTmp2 = new java.io.File(frFile.getParentFile(), "merge.tmp2");
		java.io.File mergeFile = new java.io.File(frFile.getParentFile(), "merge_entropy.data");
		try (final java.io.BufferedReader rr = com.google.common.io.Files.newReader(frFile, com.google.common.base.Charsets.UTF_8);final java.io.BufferedReader lr = com.google.common.io.Files.newReader(lFile, com.google.common.base.Charsets.UTF_8);final java.io.BufferedWriter mw = com.google.common.io.Files.newWriter(mergeTmp, com.google.common.base.Charsets.UTF_8);final java.io.BufferedWriter mf = com.google.common.io.Files.newWriter(mergeFile, com.google.common.base.Charsets.UTF_8)) {
			java.lang.String line = null;
			while (null != (line = rr.readLine())) {
				mw.write(line + "\n");
			} 
			line = null;
			while (null != (line = lr.readLine())) {
				mw.write(line + "\n");
			} 
			sortFile(mergeTmp, mergeTmp2, new java.util.Comparator<java.lang.String>() {
				@java.lang.Override
				public int compare(java.lang.String o1, java.lang.String o2) {
					return o1.compareTo(o2);
				}
			});
			java.io.BufferedReader br = com.google.common.io.Files.newReader(mergeTmp2, com.google.common.base.Charsets.UTF_8);
			java.lang.String line1 = null;
			java.lang.String line2 = null;
			line1 = br.readLine();
			line2 = br.readLine();
			while (true) {
				if ((null == line1) || (null == line2)) {
					break;
				}
				java.lang.String[] seg1 = line1.split("\t");
				java.lang.String[] seg2 = line2.split("\t");
				if (!seg1[0].equals(seg2[0])) {
					line1 = new java.lang.String(line2.getBytes());
					line2 = br.readLine();
					continue;
				}
				if (seg1.length < 2) {
					line1 = new java.lang.String(line2.getBytes());
					line2 = br.readLine();
					continue;
				}
				double le = (seg1.length == 2) ? java.lang.Double.parseDouble(seg1[1]) : java.lang.Double.parseDouble(seg2[1]);
				double re = (seg1.length == 3) ? java.lang.Double.parseDouble(seg1[2]) : java.lang.Double.parseDouble(seg2[2]);
				int freq = (seg1.length == 3) ? java.lang.Integer.parseInt(seg1[1]) : java.lang.Integer.parseInt(seg2[1]);
				double e = java.lang.Math.min(le, re);
				mf.write(((((seg1[0] + "\t") + freq) + "\t") + e) + "\n");
				line1 = br.readLine();
				line2 = br.readLine();
			} 
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return mergeFile.toString();
	}

	public void extractWords(java.lang.String freqFile, java.lang.String entropyFile) {
		java.util.TreeMap<java.lang.String, java.lang.Integer> freq = new java.util.TreeMap<>();
		java.io.File ffile = new java.io.File(freqFile);
		java.io.File efile = new java.io.File(entropyFile);
		java.io.File wfile = new java.io.File(efile.getParentFile(), "words.data");
		try (final java.io.BufferedReader fr = com.google.common.io.Files.newReader(ffile, com.google.common.base.Charsets.UTF_8);final java.io.BufferedReader er = com.google.common.io.Files.newReader(efile, com.google.common.base.Charsets.UTF_8);final java.io.BufferedWriter ww = com.google.common.io.Files.newWriter(wfile, com.google.common.base.Charsets.UTF_8)) {
			java.lang.String line = null;
			while (null != (line = fr.readLine())) {
				java.lang.String[] seg = line.split("\t");
				if (seg.length < 3) {
					continue;
				}
				freq.put(seg[0], java.lang.Integer.parseInt(seg[1]));
			} 
			line = null;
			while (null != (line = er.readLine())) {
				java.lang.String[] seg = line.split("\t");
				if (3 != seg.length) {
					continue;
				}
				java.lang.String w = seg[0];
				int f = java.lang.Integer.parseInt(seg[1]);
				double e = java.lang.Double.parseDouble(seg[2]);
				long max = -1;
				for (int s = 1; s < w.length(); ++s) {
					java.lang.String lw = w.substring(0, s);
					java.lang.String rw = w.substring(s);
					if ((!freq.containsKey(lw)) || (!freq.containsKey(rw))) {
						continue;
					}
					long ff = freq.get(lw) * freq.get(rw);
					if (ff > max) {
						max = ff;
					}
				}
				double pf = (f * 2000000.0) / max;
				if ((pf < 10) || (e < 2)) {
					continue;
				}
				ww.write(((((w + "\t") + pf) + "\t") + e) + "\n");
			} 
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(java.lang.String[] args) {
		dict.build.Builder builder = new dict.build.Builder();
		java.lang.String rawpath = builder.parse("/Users/zhangcheng/Downloads/comment/test/all.csv");
		java.lang.String freqRight = builder.genFreqRight(rawpath, 5, 1024);
		java.lang.String left = builder.genLeft(rawpath, 5, 1024);
		java.lang.String entropyfile = builder.mergeEntropy(freqRight, left);
		builder.extractWords(freqRight, entropyfile);
	}
}