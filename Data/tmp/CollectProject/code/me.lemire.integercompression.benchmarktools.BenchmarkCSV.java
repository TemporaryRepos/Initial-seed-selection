public class BenchmarkCSV {
	static me.lemire.integercompression.differential.IntegratedIntegerCODEC[] codecs = new me.lemire.integercompression.differential.IntegratedIntegerCODEC[]{ new me.lemire.integercompression.differential.IntegratedComposition(new me.lemire.integercompression.differential.IntegratedBinaryPacking(), new me.lemire.integercompression.differential.IntegratedVariableByte()) };

	static me.lemire.integercompression.differential.IntegratedByteIntegerCODEC[] bcodecs = new me.lemire.integercompression.differential.IntegratedByteIntegerCODEC[]{ new me.lemire.integercompression.differential.IntegratedVariableByte() };

	static me.lemire.integercompression.IntegerCODEC[] regcodecs = new me.lemire.integercompression.IntegerCODEC[]{ new me.lemire.integercompression.Composition(new me.lemire.integercompression.FastPFOR128(), new me.lemire.integercompression.VariableByte()), new me.lemire.integercompression.Composition(new me.lemire.integercompression.FastPFOR(), new me.lemire.integercompression.VariableByte()), new me.lemire.integercompression.Composition(new me.lemire.integercompression.BinaryPacking(), new me.lemire.integercompression.VariableByte()) };

	static me.lemire.integercompression.ByteIntegerCODEC[] regbcodecs = new me.lemire.integercompression.ByteIntegerCODEC[]{ new me.lemire.integercompression.VariableByte() };

	private static java.util.ArrayList<int[]> loadIntegers(final java.lang.String filename, final me.lemire.integercompression.benchmarktools.BenchmarkCSV.Format f) throws java.io.IOException {
		int misparsed = 0;
		if (f == me.lemire.integercompression.benchmarktools.BenchmarkCSV.Format.ONEARRAYPERLINE) {
			java.util.ArrayList<int[]> answer = new java.util.ArrayList<int[]>();
			java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(filename));
			java.lang.String s;
			while ((s = br.readLine()) != null) {
				java.lang.String[] numbers = s.split("[,;;]");
				int[] a = new int[numbers.length];
				for (int k = 0; k < numbers.length; ++k) {
					try {
						a[k] = java.lang.Integer.parseInt(numbers[k].trim());
					} catch (java.lang.NumberFormatException nfe) {
						if (misparsed == 0) {
							java.lang.System.err.println(nfe);
						}
						++misparsed;
					}
				}
				answer.add(a);
			} 
			if (misparsed > 0) {
				java.lang.System.out.println(("Failed to parse " + misparsed) + " entries");
			}
			br.close();
			return answer;
		} else if (f == me.lemire.integercompression.benchmarktools.BenchmarkCSV.Format.ONEARRAYPERFILE) {
			java.util.ArrayList<java.lang.Integer> answer = new java.util.ArrayList<java.lang.Integer>();
			java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(filename));
			java.lang.String s;
			while ((s = br.readLine()) != null) {
				java.lang.String[] numbers = s.split("[,;;]");
				for (int k = 0; k < numbers.length; ++k) {
					try {
						answer.add(java.lang.Integer.parseInt(numbers[k].trim()));
					} catch (java.lang.NumberFormatException nfe) {
						if (misparsed == 0) {
							java.lang.System.err.println(nfe);
						}
						++misparsed;
					}
				}
			} 
			int[] actualanswer = new int[answer.size()];
			for (int i = 0; i < answer.size(); ++i) {
				actualanswer[i] = answer.get(i);
			}
			java.util.ArrayList<int[]> wrap = new java.util.ArrayList<int[]>();
			wrap.add(actualanswer);
			if (misparsed > 0) {
				java.lang.System.out.println(("Failed to parse " + misparsed) + " entries");
			}
			br.close();
			return wrap;
		} else {
			java.util.ArrayList<java.lang.Integer> answer = new java.util.ArrayList<java.lang.Integer>();
			java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(filename));
			java.lang.String s;
			while ((s = br.readLine()) != null) {
				try {
					answer.add(java.lang.Integer.parseInt(s.trim()));
				} catch (java.lang.NumberFormatException nfe) {
					if (misparsed == 0) {
						java.lang.System.err.println(nfe);
					}
					++misparsed;
				}
			} 
			int[] actualanswer = new int[answer.size()];
			for (int i = 0; i < answer.size(); ++i) {
				actualanswer[i] = answer.get(i);
			}
			java.util.ArrayList<int[]> wrap = new java.util.ArrayList<int[]>();
			wrap.add(actualanswer);
			if (misparsed > 0) {
				java.lang.System.out.println(("Failed to parse " + misparsed) + " entries");
			}
			br.close();
			return wrap;
		}
	}

	private enum Format {

		ONEARRAYPERLINE,
		ONEARRAYPERFILE,
		ONEINTPERLINE;}

	private enum CompressionMode {

		AS_IS,
		DELTA;}

	public static void main(final java.lang.String[] args) throws java.io.IOException {
		me.lemire.integercompression.benchmarktools.BenchmarkCSV.Format myformat = me.lemire.integercompression.benchmarktools.BenchmarkCSV.Format.ONEARRAYPERLINE;
		me.lemire.integercompression.benchmarktools.BenchmarkCSV.CompressionMode cm = me.lemire.integercompression.benchmarktools.BenchmarkCSV.CompressionMode.DELTA;
		java.util.ArrayList<java.lang.String> files = new java.util.ArrayList<java.lang.String>();
		for (java.lang.String s : args) {
			if (s.startsWith("-")) {
				if (s.equals("--onearrayperfile")) {
					myformat = me.lemire.integercompression.benchmarktools.BenchmarkCSV.Format.ONEARRAYPERFILE;
				} else if (s.equals("--nodelta")) {
					cm = me.lemire.integercompression.benchmarktools.BenchmarkCSV.CompressionMode.AS_IS;
				} else if (s.equals("--oneintperline")) {
					myformat = me.lemire.integercompression.benchmarktools.BenchmarkCSV.Format.ONEINTPERLINE;
				} else {
					throw new java.lang.RuntimeException("I don't understand: " + s);
				}
			} else {
				files.add(s);
			}
		}
		if (myformat == me.lemire.integercompression.benchmarktools.BenchmarkCSV.Format.ONEARRAYPERFILE) {
			java.lang.System.out.println("Treating each file as one array.");
		} else if (myformat == me.lemire.integercompression.benchmarktools.BenchmarkCSV.Format.ONEARRAYPERLINE) {
			java.lang.System.out.println("Each line of each file is an array: use --onearrayperfile or --oneintperline to change.");
		} else if (myformat == me.lemire.integercompression.benchmarktools.BenchmarkCSV.Format.ONEINTPERLINE) {
			java.lang.System.out.println("Treating each file as one array, with one integer per line.");
		}
		if (cm == me.lemire.integercompression.benchmarktools.BenchmarkCSV.CompressionMode.AS_IS) {
			java.lang.System.out.println("Compressing the integers 'as is' (no differential coding)");
		} else {
			java.lang.System.out.println("Using differential coding (arrays will be sorted): use --nodelta to prevent sorting");
		}
		java.util.ArrayList<int[]> data = new java.util.ArrayList<int[]>();
		for (java.lang.String fn : files) {
			for (int[] x : me.lemire.integercompression.benchmarktools.BenchmarkCSV.loadIntegers(fn, myformat)) {
				data.add(x);
			}
		}
		java.lang.System.out.println(("Loaded " + data.size()) + " array(s)");
		if (cm == me.lemire.integercompression.benchmarktools.BenchmarkCSV.CompressionMode.DELTA) {
			java.lang.System.out.println("Sorting the arrray(s) because you are using differential coding");
			for (int[] x : data) {
				java.util.Arrays.sort(x);
			}
		}
		me.lemire.integercompression.benchmarktools.BenchmarkCSV.bench(data, cm, false);
		me.lemire.integercompression.benchmarktools.BenchmarkCSV.bench(data, cm, false);
		me.lemire.integercompression.benchmarktools.BenchmarkCSV.bench(data, cm, true);
		me.lemire.integercompression.benchmarktools.BenchmarkCSV.bytebench(data, cm, false);
		me.lemire.integercompression.benchmarktools.BenchmarkCSV.bytebench(data, cm, false);
		me.lemire.integercompression.benchmarktools.BenchmarkCSV.bytebench(data, cm, true);
	}

	private static void bench(java.util.ArrayList<int[]> postings, me.lemire.integercompression.benchmarktools.BenchmarkCSV.CompressionMode cm, boolean verbose) {
		int maxlength = 0;
		for (int[] x : postings) {
			if (maxlength < x.length) {
				maxlength = x.length;
			}
		}
		if (verbose) {
			java.lang.System.out.println("Max array length: " + maxlength);
		}
		int[] compbuffer = new int[(2 * maxlength) + 1024];
		int[] decompbuffer = new int[maxlength];
		if (verbose) {
			java.lang.System.out.println("Scheme -- bits/int -- speed (mis)");
		}
		for (me.lemire.integercompression.IntegerCODEC c : cm == me.lemire.integercompression.benchmarktools.BenchmarkCSV.CompressionMode.DELTA ? me.lemire.integercompression.benchmarktools.BenchmarkCSV.codecs : me.lemire.integercompression.benchmarktools.BenchmarkCSV.regcodecs) {
			long bef = 0;
			long aft = 0;
			long decomptime = 0;
			long volumein = 0;
			long volumeout = 0;
			int[][] compdata = new int[postings.size()][];
			for (int k = 0; k < postings.size(); ++k) {
				int[] in = postings.get(k);
				me.lemire.integercompression.IntWrapper inpos = new me.lemire.integercompression.IntWrapper(0);
				me.lemire.integercompression.IntWrapper outpos = new me.lemire.integercompression.IntWrapper(0);
				c.compress(in, inpos, in.length, compbuffer, outpos);
				int clength = outpos.get();
				inpos = new me.lemire.integercompression.IntWrapper(0);
				outpos = new me.lemire.integercompression.IntWrapper(0);
				c.uncompress(compbuffer, inpos, clength, decompbuffer, outpos);
				volumein += in.length;
				volumeout += clength;
				if (outpos.get() != in.length) {
					throw new java.lang.RuntimeException("bug");
				}
				for (int z = 0; z < in.length; ++z) {
					if (in[z] != decompbuffer[z]) {
						throw new java.lang.RuntimeException("bug");
					}
				}
				compdata[k] = java.util.Arrays.copyOf(compbuffer, clength);
			}
			bef = java.lang.System.nanoTime();
			for (int[] cin : compdata) {
				me.lemire.integercompression.IntWrapper inpos = new me.lemire.integercompression.IntWrapper(0);
				me.lemire.integercompression.IntWrapper outpos = new me.lemire.integercompression.IntWrapper(0);
				c.uncompress(cin, inpos, cin.length, decompbuffer, outpos);
				if (inpos.get() != cin.length) {
					throw new java.lang.RuntimeException("bug");
				}
			}
			aft = java.lang.System.nanoTime();
			decomptime += aft - bef;
			double bitsPerInt = (volumeout * 32.0) / volumein;
			double decompressSpeed = (volumein * 1000.0) / decomptime;
			if (verbose) {
				java.lang.System.out.println((c.toString() + "\t") + java.lang.String.format("\t%1$.2f\t%2$.2f", bitsPerInt, decompressSpeed));
			}
		}
	}

	private static void bytebench(java.util.ArrayList<int[]> postings, me.lemire.integercompression.benchmarktools.BenchmarkCSV.CompressionMode cm, boolean verbose) {
		int maxlength = 0;
		for (int[] x : postings) {
			if (maxlength < x.length) {
				maxlength = x.length;
			}
		}
		if (verbose) {
			java.lang.System.out.println("Max array length: " + maxlength);
		}
		byte[] compbuffer = new byte[6 * (maxlength + 1024)];
		int[] decompbuffer = new int[maxlength];
		if (verbose) {
			java.lang.System.out.println("Scheme -- bits/int -- speed (mis)");
		}
		for (me.lemire.integercompression.ByteIntegerCODEC c : cm == me.lemire.integercompression.benchmarktools.BenchmarkCSV.CompressionMode.DELTA ? me.lemire.integercompression.benchmarktools.BenchmarkCSV.bcodecs : me.lemire.integercompression.benchmarktools.BenchmarkCSV.regbcodecs) {
			long bef = 0;
			long aft = 0;
			long decomptime = 0;
			long volumein = 0;
			long volumeout = 0;
			byte[][] compdata = new byte[postings.size()][];
			for (int k = 0; k < postings.size(); ++k) {
				int[] in = postings.get(k);
				me.lemire.integercompression.IntWrapper inpos = new me.lemire.integercompression.IntWrapper(0);
				me.lemire.integercompression.IntWrapper outpos = new me.lemire.integercompression.IntWrapper(0);
				c.compress(in, inpos, in.length, compbuffer, outpos);
				int clength = outpos.get();
				inpos = new me.lemire.integercompression.IntWrapper(0);
				outpos = new me.lemire.integercompression.IntWrapper(0);
				c.uncompress(compbuffer, inpos, clength, decompbuffer, outpos);
				volumein += in.length;
				volumeout += clength;
				if (outpos.get() != in.length) {
					throw new java.lang.RuntimeException("bug");
				}
				for (int z = 0; z < in.length; ++z) {
					if (in[z] != decompbuffer[z]) {
						throw new java.lang.RuntimeException("bug");
					}
				}
				compdata[k] = java.util.Arrays.copyOf(compbuffer, clength);
			}
			bef = java.lang.System.nanoTime();
			for (byte[] cin : compdata) {
				me.lemire.integercompression.IntWrapper inpos = new me.lemire.integercompression.IntWrapper(0);
				me.lemire.integercompression.IntWrapper outpos = new me.lemire.integercompression.IntWrapper(0);
				c.uncompress(cin, inpos, cin.length, decompbuffer, outpos);
				if (inpos.get() != cin.length) {
					throw new java.lang.RuntimeException("bug");
				}
			}
			aft = java.lang.System.nanoTime();
			decomptime += aft - bef;
			double bitsPerInt = (volumeout * 8.0) / volumein;
			double decompressSpeed = (volumein * 1000.0) / decomptime;
			if (verbose) {
				java.lang.System.out.println((c.toString() + "\t") + java.lang.String.format("\t%1$.2f\t%2$.2f", bitsPerInt, decompressSpeed));
			}
		}
	}
}