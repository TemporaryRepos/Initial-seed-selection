public class EfficientWord2VecCompress extends it.cnr.isti.hpc.Word2VecCompress {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(com.yahoo.semsearch.fastlinking.w2v.EfficientWord2VecCompress.class);

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(it.cnr.isti.hpc.Word2VecCompress.class.getName(), "Creates a compressed representation of quantized word2vec vectors", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.UnflaggedOption("input", com.martiansoftware.jsap.JSAP.STRING_PARSER, true, "Input file"), new com.martiansoftware.jsap.UnflaggedOption("output", com.martiansoftware.jsap.JSAP.STRING_PARSER, false, "Compressed version"), new com.martiansoftware.jsap.Switch("check", com.martiansoftware.jsap.JSAP.NO_SHORTFLAG, "check", "Check correctness of output") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		java.lang.String input_filename = jsapResult.getString("input");
		java.lang.String output_filename = jsapResult.getString("output", null);
		int numWords;
		int vectorSize;
		float quantizationFactor;
		java.util.List<java.lang.String> indexToWord;
		long size;
		long[] columnAbsSum;
		it.unimi.dsi.logging.ProgressLogger pl = new it.unimi.dsi.logging.ProgressLogger(com.yahoo.semsearch.fastlinking.w2v.EfficientWord2VecCompress.logger);
		try (final java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(input_filename), "UTF-8"))) {
			java.lang.String[] header = lines.readLine().split("\t");
			numWords = java.lang.Integer.parseInt(header[0]);
			vectorSize = java.lang.Integer.parseInt(header[1]);
			quantizationFactor = java.lang.Float.parseFloat(header[2]);
			pl.expectedUpdates = numWords;
			pl.start("Reading the dictionary");
			indexToWord = new java.util.ArrayList<>();
			it.unimi.dsi.fastutil.objects.ObjectOpenHashSet<java.lang.String> stringSet = new it.unimi.dsi.fastutil.objects.ObjectOpenHashSet<java.lang.String>();
			java.util.Random r = new java.util.Random();
			for (int i = 0; i < numWords; ++i) {
				pl.lightUpdate();
				java.lang.String s = lines.readLine();
				if (s.length() > 0) {
					if (s.charAt(s.length() - 1) == '\n') {
						s = s.substring(0, s.length() - 2);
					}
					if (!stringSet.contains(s)) {
						indexToWord.add(s);
						stringSet.add(s);
					} else {
						java.lang.System.out.println((("dup <" + s) + "> line ") + i);
						indexToWord.add(s + r.nextDouble());
					}
				} else {
					indexToWord.add("<<<<<<VOID>>>>>" + r.nextDouble());
				}
			}
			pl.done();
			columnAbsSum = new long[vectorSize];
			size = ((long) (numWords)) * vectorSize;
			pl.expectedUpdates = numWords;
			pl.start("Reading the vectors");
			java.lang.String preLin = "";
			for (int i = 0; i < numWords; ++i) {
				pl.lightUpdate();
				java.lang.String line = lines.readLine();
				try {
					java.lang.String[] lineEntries = line.split(" ");
					for (int col = 0; col < vectorSize; ++col) {
						int entry = java.lang.Integer.parseInt(lineEntries[col]);
						columnAbsSum[col] += it.unimi.dsi.bits.Fast.int2nat(entry) + 1;
					}
				} catch (java.lang.Exception e) {
					java.lang.System.err.println((((("[ERROR] at line " + i) + " : ") + line) + " word ") + indexToWord.get(i));
					e.printStackTrace();
					java.lang.System.exit(-1);
				}
			}
			pl.done();
		}
		int[] golombModuli = new int[vectorSize];
		for (int col = 0; col < vectorSize; ++col) {
			int m = 0;
			if (columnAbsSum[col] > numWords) {
				double f = ((double) (numWords)) / columnAbsSum[col];
				m = ((int) (java.lang.Math.ceil(java.lang.Math.log(2.0 - f) / (-java.lang.Math.log(1.0 - f)))));
			}
			golombModuli[col] = m;
		}
		it.unimi.dsi.big.util.ShiftAddXorSignedStringMap dictionaryHash = new it.unimi.dsi.big.util.ShiftAddXorSignedStringMap(indexToWord.iterator(), new it.unimi.dsi.sux4j.mph.MinimalPerfectHashFunction.Builder<java.lang.CharSequence>().keys(indexToWord).transform(it.unimi.dsi.bits.TransformationStrategies.utf16()).build());
		int[] permutation = new int[numWords];
		for (int i = 0; i < numWords; ++i) {
			int newPos = dictionaryHash.get(indexToWord.get(i)).intValue();
			permutation[newPos] = i;
		}
		it.unimi.dsi.fastutil.io.FastByteArrayOutputStream oa = new it.unimi.dsi.fastutil.io.FastByteArrayOutputStream();
		it.unimi.dsi.io.OutputBitStream obs = new it.unimi.dsi.io.OutputBitStream(oa, 0);
		it.unimi.dsi.fastutil.longs.LongArrayList endpoints = new it.unimi.dsi.fastutil.longs.LongArrayList();
		pl.expectedUpdates = numWords;
		pl.start("First-pass compressing the vectors");
		try (final java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(input_filename), "UTF-8"))) {
			lines.readLine();
			for (int i = 0; i < numWords; ++i) {
				lines.readLine();
			}
			for (int i = 0; i < numWords; ++i) {
				pl.lightUpdate();
				endpoints.add(obs.writtenBits());
				java.lang.String line = lines.readLine();
				java.lang.String[] lineEntries = line.split(" ");
				for (int col = 0; col < vectorSize; ++col) {
					int entry = java.lang.Integer.parseInt(lineEntries[col]);
					obs.writeGolomb(it.unimi.dsi.bits.Fast.int2nat(entry), golombModuli[col]);
				}
			}
			pl.done();
			obs.close();
			while ((oa.length() % 4) != 0) {
				oa.write(0);
			} 
			oa.trim();
		}
		double bps = (8.0 * oa.array.length) / size;
		com.yahoo.semsearch.fastlinking.w2v.EfficientWord2VecCompress.logger.info("Overall vector bit streams: {} bytes, {} bps", oa.array.length, bps);
		it.unimi.dsi.fastutil.io.FastByteArrayOutputStream noa = new it.unimi.dsi.fastutil.io.FastByteArrayOutputStream();
		it.unimi.dsi.io.OutputBitStream nobs = new it.unimi.dsi.io.OutputBitStream(noa, 0);
		pl.expectedUpdates = numWords;
		pl.start("Second pass re-compressing the vectors");
		final it.unimi.dsi.fastutil.longs.LongArrayList nendpoints = new it.unimi.dsi.fastutil.longs.LongArrayList();
		it.cnr.isti.hpc.FastInputBitStream ibs = new it.cnr.isti.hpc.FastInputBitStream(oa.array);
		for (int i = 0; i < numWords; i++) {
			pl.lightUpdate();
			nendpoints.add(nobs.writtenBits());
			long endpoint = endpoints.get(permutation[i]);
			ibs.position(endpoint);
			for (int col = 0; col < vectorSize; ++col) {
				int val = it.unimi.dsi.bits.Fast.nat2int(ibs.readGolomb(golombModuli[col]));
				nobs.writeGolomb(it.unimi.dsi.bits.Fast.int2nat(val), golombModuli[col]);
			}
		}
		pl.done();
		nobs.close();
		while ((noa.length() % 4) != 0) {
			noa.write(0);
		} 
		noa.trim();
		endpoints = nendpoints;
		oa = noa;
		it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList efEndpoints = new it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList(endpoints);
		it.cnr.isti.hpc.Word2VecCompress word2vec = new it.cnr.isti.hpc.Word2VecCompress(numWords, vectorSize, quantizationFactor, oa.array, efEndpoints, dictionaryHash, golombModuli);
		if (output_filename != null) {
			it.unimi.dsi.fastutil.io.BinIO.storeObject(word2vec, output_filename);
		}
		if (jsapResult.getBoolean("check")) {
			pl.expectedUpdates = numWords;
			pl.start("Checking the output");
			try (final java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(input_filename), "UTF-8"))) {
				lines.readLine();
				for (int i = 0; i < numWords; ++i) {
					lines.readLine();
				}
				for (int i = 0; i < numWords; ++i) {
					pl.lightUpdate();
					int[] vec = word2vec.getInt(indexToWord.get(i));
					java.lang.String line = lines.readLine();
					java.lang.String[] lineEntries = line.split(" ");
					for (int col = 0; col < vectorSize; ++col) {
						int expected = java.lang.Integer.parseInt(lineEntries[col]);
						int got = vec[col];
						if (expected != got) {
							com.yahoo.semsearch.fastlinking.w2v.EfficientWord2VecCompress.logger.error("Row {}, Column {}: Expected {}, got {}", i, col, expected, got);
							java.lang.System.exit(1);
						}
					}
				}
				pl.done();
			}
		}
	}
}