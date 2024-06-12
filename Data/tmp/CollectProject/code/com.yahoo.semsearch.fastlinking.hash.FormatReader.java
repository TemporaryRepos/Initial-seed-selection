public class FormatReader {
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(com.yahoo.semsearch.fastlinking.hash.FormatReader.class);

	public static java.lang.Iterable<com.yahoo.semsearch.fastlinking.view.StringAndCandidate> stringAndCandidates(final java.lang.String input, final int queryThreshold, final int wikiThreshold) {
		return new java.lang.Iterable<com.yahoo.semsearch.fastlinking.view.StringAndCandidate>() {
			@java.lang.Override
			public java.util.Iterator<com.yahoo.semsearch.fastlinking.view.StringAndCandidate> iterator() {
				try {
					return new it.unimi.dsi.fastutil.objects.AbstractObjectIterator<com.yahoo.semsearch.fastlinking.view.StringAndCandidate>() {
						it.unimi.dsi.io.LineIterator lineIterator = new it.unimi.dsi.io.LineIterator(new it.unimi.dsi.io.FastBufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(input), com.google.common.base.Charsets.UTF_8)));

						@java.lang.Override
						public boolean hasNext() {
							return lineIterator.hasNext();
						}

						@java.lang.Override
						public com.yahoo.semsearch.fastlinking.view.StringAndCandidate next() {
							if (!hasNext()) {
								throw new java.util.NoSuchElementException();
							}
							com.yahoo.semsearch.fastlinking.view.StringAndCandidate c;
							while ((c = com.yahoo.semsearch.fastlinking.hash.FormatReader.parseLine(lineIterator.next().toString(), queryThreshold, wikiThreshold)) == null) {
								if (!lineIterator.hasNext()) {
									com.yahoo.semsearch.fastlinking.view.StringAndCandidate sc = new com.yahoo.semsearch.fastlinking.view.StringAndCandidate();
									sc.candidatesInfo = new com.yahoo.semsearch.fastlinking.view.CandidatesInfo(new com.yahoo.semsearch.fastlinking.view.Entity[0], 0, 0, 0, 0, 0);
									sc.surfaceForm = "<FOO-FOO>";
									return sc;
								}
							} 
							return c;
						}
					};
				} catch (java.io.FileNotFoundException e) {
					throw new java.lang.RuntimeException(e.getMessage(), e);
				}
			}
		};
	}

	public static com.yahoo.semsearch.fastlinking.view.StringAndCandidate parseLine(java.lang.String line, int queryThreshold, int wikiThreshold) {
		com.yahoo.semsearch.fastlinking.view.StringAndCandidate candidate = new com.yahoo.semsearch.fastlinking.view.StringAndCandidate();
		java.lang.String[] parts = line.split("\t+");
		java.lang.String[] kk = parts[0].split("\u0001");
		candidate.surfaceForm = kk[0];
		java.util.ArrayList<com.yahoo.semsearch.fastlinking.view.Entity> ents = new java.util.ArrayList<com.yahoo.semsearch.fastlinking.view.Entity>();
		int QAF = java.lang.Integer.parseInt(kk[1]);
		int QAC = java.lang.Integer.parseInt(kk[2]);
		int QAT = java.lang.Integer.parseInt(kk[3]);
		int LAF = java.lang.Integer.parseInt(kk[6]);
		int LAT = java.lang.Integer.parseInt(kk[7]);
		for (int i = 1; i < parts.length; i++) {
			java.lang.String[] moreParts = parts[i].trim().split("\u0001");
			for (int j = 0; j < moreParts.length; j++) {
				com.yahoo.semsearch.fastlinking.view.Entity entity = new com.yahoo.semsearch.fastlinking.view.Entity();
				entity.id = java.lang.Integer.parseInt(moreParts[j++]);
				entity.type = ((short) (java.lang.Integer.parseInt(moreParts[j++])));
				entity.QEF = java.lang.Integer.parseInt(moreParts[j++]);
				entity.QAEF = java.lang.Integer.parseInt(moreParts[j++]);
				entity.MET = java.lang.Integer.parseInt(moreParts[j++]);
				entity.MAET = java.lang.Integer.parseInt(moreParts[j++]);
				entity.LET = java.lang.Integer.parseInt(moreParts[j++]);
				entity.LAET = java.lang.Integer.parseInt(moreParts[j++]);
				ents.add(entity);
			}
		}
		if (ents.size() > 0) {
			double maxQAEF = -java.lang.Double.MAX_VALUE;
			com.yahoo.semsearch.fastlinking.view.Entity max = null;
			for (com.yahoo.semsearch.fastlinking.view.Entity e : ents) {
				if (e.QAEF > maxQAEF) {
					max = e;
					maxQAEF = e.QAEF;
				}
			}
			java.util.ArrayList<com.yahoo.semsearch.fastlinking.view.Entity> newE = new java.util.ArrayList<com.yahoo.semsearch.fastlinking.view.Entity>();
			newE.add(max);
			for (com.yahoo.semsearch.fastlinking.view.Entity e : ents) {
				if (((e.LAET >= wikiThreshold) || (e.QAEF >= queryThreshold)) && (!e.equals(max))) {
					newE.add(e);
				} else if (!e.equals(max)) {
					com.yahoo.semsearch.fastlinking.hash.FormatReader.LOGGER.info((((((((((((("removing " + e) + " laet? ") + e.LAET) + ">= ") + wikiThreshold) + "?") + (e.LAET >= wikiThreshold)) + " qaef?") + (e.QAEF >= queryThreshold)) + " wikT ") + wikiThreshold) + " qT ") + queryThreshold);
				}
			}
			candidate.candidatesInfo = new com.yahoo.semsearch.fastlinking.view.CandidatesInfo(ents.toArray(new com.yahoo.semsearch.fastlinking.view.Entity[newE.size()]), QAF, QAT, QAC, LAF, LAT);
		} else {
			com.yahoo.semsearch.fastlinking.hash.FormatReader.LOGGER.error(" no entities for alias " + candidate.surfaceForm);
			return null;
		}
		return candidate;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(com.yahoo.semsearch.fastlinking.hash.FormatReader.class.getName(), "Tests the reading format", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.FlaggedOption("input", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'i', "input", "Input file") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		final java.lang.Iterable<com.yahoo.semsearch.fastlinking.view.StringAndCandidate> stringAndCandidates = com.yahoo.semsearch.fastlinking.hash.FormatReader.stringAndCandidates(jsapResult.getString("input"), 0, 0);
		int bogus = 0;
		int numberOfCandidates = 0;
		for (com.yahoo.semsearch.fastlinking.view.StringAndCandidate sc : stringAndCandidates) {
			com.yahoo.semsearch.fastlinking.view.CandidatesInfo ci = sc.candidatesInfo;
			if (((((ci.QAF == 0) && (ci.LAF == 0)) && (ci.LAT == 0)) && (ci.QAC == 0)) && (ci.QAT == 0)) {
				bogus++;
			}
			numberOfCandidates++;
			if (sc.surfaceForm.contains("brad pitt")) {
				java.lang.System.out.println((sc.surfaceForm + "\n") + ci);
			}
		}
		com.yahoo.semsearch.fastlinking.hash.FormatReader.LOGGER.info("Candidates with all zeros : " + bogus);
		com.yahoo.semsearch.fastlinking.hash.FormatReader.LOGGER.info("Number of candidates:" + numberOfCandidates);
	}
}