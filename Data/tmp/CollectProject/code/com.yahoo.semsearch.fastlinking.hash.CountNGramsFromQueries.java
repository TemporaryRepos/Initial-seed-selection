public class CountNGramsFromQueries {
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(com.yahoo.semsearch.fastlinking.hash.CountNGramsFromQueries.class);

	public static void main(java.lang.String[] args) throws com.martiansoftware.jsap.JSAPException, java.lang.ClassNotFoundException, java.io.IOException {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.class.getName(), "Creates a MPHF from a file with the candidates info", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.FlaggedOption("input", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'i', "input", "Input file"), new com.martiansoftware.jsap.FlaggedOption("hash", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'h', "hash", "Hash file"), new com.martiansoftware.jsap.FlaggedOption("output", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'o', "output", "Compressed version") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		int numberOfPhrases;
		it.unimi.dsi.fastutil.objects.Object2LongFunction<? extends java.lang.CharSequence> f;
		it.unimi.dsi.logging.ProgressLogger pl = new it.unimi.dsi.logging.ProgressLogger(com.yahoo.semsearch.fastlinking.hash.CountNGramsFromQueries.LOGGER);
		if (jsapResult.getString("hash") != null) {
			com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash hash = ((com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash) (it.unimi.dsi.fastutil.io.BinIO.loadObject(jsapResult.getString("hash"))));
			numberOfPhrases = ((int) (hash.stats.phrases));
			f = hash.hash;
		} else {
			final java.lang.Iterable<com.yahoo.semsearch.fastlinking.view.StringAndCandidate> stringAndCandidates = com.yahoo.semsearch.fastlinking.hash.FormatReader.stringAndCandidates(jsapResult.getString("input"), 0, 0);
			java.lang.Iterable<java.lang.CharSequence> surfaceForms = new java.lang.Iterable<java.lang.CharSequence>() {
				@java.lang.Override
				public java.util.Iterator<java.lang.CharSequence> iterator() {
					return new it.unimi.dsi.fastutil.objects.AbstractObjectIterator<java.lang.CharSequence>() {
						java.util.Iterator<com.yahoo.semsearch.fastlinking.view.StringAndCandidate> i = stringAndCandidates.iterator();

						@java.lang.Override
						public boolean hasNext() {
							return i.hasNext();
						}

						@java.lang.Override
						public java.lang.String next() {
							return i.next().surfaceForm;
						}
					};
				}
			};
			it.unimi.dsi.util.ShiftAddXorSignedStringMap surfaceForm2Position = new it.unimi.dsi.util.ShiftAddXorSignedStringMap(surfaceForms.iterator(), new it.unimi.dsi.sux4j.mph.MWHCFunction.Builder<java.lang.CharSequence>().keys(surfaceForms).transform(it.unimi.dsi.bits.TransformationStrategies.utf16()).build());
			f = surfaceForm2Position;
			numberOfPhrases = surfaceForm2Position.size();
		}
		java.lang.Iterable<com.yahoo.semsearch.fastlinking.view.StringAndCandidate> stringAndCandidates2 = com.yahoo.semsearch.fastlinking.hash.FormatReader.stringAndCandidates(jsapResult.getString("input"), 0, 0);
		long[] counts = new long[numberOfPhrases];
		pl.set(numberOfPhrases);
		pl.start("Counting n-grams");
		for (com.yahoo.semsearch.fastlinking.view.StringAndCandidate sc : stringAndCandidates2) {
			java.lang.String[] words = sc.surfaceForm.split("\\s+");
			for (int i = 0; i < words.length; i++) {
				java.lang.StringBuilder sb = new java.lang.StringBuilder();
				for (int j = i; j < words.length; j++) {
					sb.append(words[j]);
					java.lang.String ss = sb.toString();
					java.lang.Long l = f.get(ss);
					if (l != null) {
						counts[l.intValue()] += sc.candidatesInfo.QAT;
					}
					sb.append(" ");
				}
			}
			pl.lightUpdate();
		}
		pl.stop();
		pl.start("Flushing new datapack into " + jsapResult.getString("output"));
		stringAndCandidates2 = com.yahoo.semsearch.fastlinking.hash.FormatReader.stringAndCandidates(jsapResult.getString("input"), 0, 0);
		java.io.Writer fw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(jsapResult.getString("output")), "UTF-8"));
		for (com.yahoo.semsearch.fastlinking.view.StringAndCandidate sc : stringAndCandidates2) {
			fw.write((((((((((((((((sc.surfaceForm + "\u0001") + com.yahoo.semsearch.fastlinking.hash.CountNGramsFromQueries.toInt(sc.candidatesInfo.QAF)) + "\u0001") + com.yahoo.semsearch.fastlinking.hash.CountNGramsFromQueries.toInt(sc.candidatesInfo.QAC)) + "\u0001") + counts[((java.lang.Long) (f.get(sc.surfaceForm))).intValue()]) + "\u0001") + 1) + "\u0001") + 1) + "\u0001") + com.yahoo.semsearch.fastlinking.hash.CountNGramsFromQueries.toInt(sc.candidatesInfo.LAF)) + "\u0001") + com.yahoo.semsearch.fastlinking.hash.CountNGramsFromQueries.toInt(sc.candidatesInfo.LAT)) + "\u0001") + sc.candidatesInfo.entities.length);
			for (com.yahoo.semsearch.fastlinking.view.Entity e : sc.candidatesInfo.entities) {
				fw.write((((((((((((((("\t" + e.id) + "\u0001") + e.type) + "\u0001") + com.yahoo.semsearch.fastlinking.hash.CountNGramsFromQueries.toInt(e.QEF)) + "\u0001") + com.yahoo.semsearch.fastlinking.hash.CountNGramsFromQueries.toInt(e.QAEF)) + "\u0001") + "1") + "\u0001") + "1") + "\u0001") + com.yahoo.semsearch.fastlinking.hash.CountNGramsFromQueries.toInt(e.LET)) + "\u0001") + com.yahoo.semsearch.fastlinking.hash.CountNGramsFromQueries.toInt(e.LAET));
			}
			fw.write("\n");
			pl.lightUpdate();
		}
		pl.stop();
		fw.close();
	}

	public static int toInt(double d) {
		return new java.lang.Double(d).intValue();
	}
}