public class Word2VecCompress implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(it.cnr.isti.hpc.Word2VecCompress.class);

	private int numWords;

	private int vectorSize;

	private float quantizationFactor;

	private byte[] vectorStreams;

	private it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList endpoints;

	private it.unimi.dsi.fastutil.objects.Object2LongFunction<? extends java.lang.CharSequence> dictionary;

	private int[] golombModuli;

	public Word2VecCompress() {
	}

	public Word2VecCompress(int numWords, int vectorSize, float quantizationFactor, byte[] vectorStreams, it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList endpoints, it.unimi.dsi.fastutil.objects.Object2LongFunction<? extends java.lang.CharSequence> dictionary, int[] golombModuli) {
		this.numWords = numWords;
		this.vectorSize = vectorSize;
		this.quantizationFactor = quantizationFactor;
		this.vectorStreams = vectorStreams;
		this.endpoints = endpoints;
		this.dictionary = dictionary;
		this.golombModuli = golombModuli;
	}

	public int[] getInt(long idx) {
		int[] ret = new int[vectorSize];
		long endpoint = endpoints.get(idx);
		it.cnr.isti.hpc.FastInputBitStream ibs = new it.cnr.isti.hpc.FastInputBitStream(vectorStreams);
		ibs.position(endpoint);
		for (int col = 0; col < vectorSize; ++col) {
			ret[col] = it.unimi.dsi.bits.Fast.nat2int(ibs.readGolomb(golombModuli[col]));
		}
		return ret;
	}

	public int[] getInt(java.lang.String word) {
		java.lang.Long idx = word_id(word);
		if (idx == null) {
			return null;
		}
		return getInt(idx);
	}

	public void get(long idx, float[] result, int offset) {
		long endpoint = endpoints.get(idx);
		it.cnr.isti.hpc.FastInputBitStream ibs = new it.cnr.isti.hpc.FastInputBitStream(vectorStreams);
		ibs.position(endpoint);
		for (int col = 0; col < vectorSize; ++col) {
			int val = it.unimi.dsi.bits.Fast.nat2int(ibs.readGolomb(golombModuli[col]));
			result[offset + col] = (((float) (val)) + (0.5F * java.lang.Integer.signum(val))) / quantizationFactor;
		}
	}

	public float[] get(long idx) {
		float[] ret = new float[vectorSize];
		get(idx, ret, 0);
		return ret;
	}

	public boolean get(java.lang.String word, float[] result, int offset) {
		java.lang.Long idx = word_id(word);
		if (idx == null) {
			return false;
		}
		get(idx, result, offset);
		return true;
	}

	public float[] get(java.lang.String word) {
		java.lang.Long idx = word_id(word);
		if (idx == null) {
			return null;
		}
		return get(idx);
	}

	public java.lang.Long word_id(java.lang.String word) {
		return dictionary.get(word);
	}

	public int size() {
		return numWords;
	}

	public int dimensions() {
		return vectorSize;
	}

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
		int[] entries;
		long[] columnAbsSum;
		it.unimi.dsi.logging.ProgressLogger pl = new it.unimi.dsi.logging.ProgressLogger(it.cnr.isti.hpc.Word2VecCompress.logger);
		try (final java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.FileReader(input_filename))) {
			java.lang.String[] header = lines.readLine().split("\t");
			numWords = java.lang.Integer.parseInt(header[0]);
			vectorSize = java.lang.Integer.parseInt(header[1]);
			quantizationFactor = java.lang.Float.parseFloat(header[2]);
			pl.expectedUpdates = numWords;
			pl.start("Reading the dictionary");
			indexToWord = new java.util.ArrayList<>();
			for (int i = 0; i < numWords; ++i) {
				pl.lightUpdate();
				indexToWord.add(lines.readLine().trim());
			}
			pl.done();
			entries = new int[numWords * vectorSize];
			columnAbsSum = new long[vectorSize];
			pl.expectedUpdates = numWords;
			pl.start("Reading the vectors");
			for (int i = 0; i < numWords; ++i) {
				pl.lightUpdate();
				java.lang.String[] lineEntries = lines.readLine().split(" ");
				for (int col = 0; col < vectorSize; ++col) {
					int entry = java.lang.Integer.parseInt(lineEntries[col]);
					entries[(i * vectorSize) + col] = entry;
					columnAbsSum[col] += it.unimi.dsi.bits.Fast.int2nat(entry) + 1;
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
		it.unimi.dsi.util.ShiftAddXorSignedStringMap dictionaryHash = new it.unimi.dsi.util.ShiftAddXorSignedStringMap(indexToWord.iterator(), new it.unimi.dsi.sux4j.mph.MinimalPerfectHashFunction.Builder<java.lang.CharSequence>().keys(indexToWord).transform(it.unimi.dsi.bits.TransformationStrategies.utf16()).build());
		int[] permutation = new int[numWords];
		for (int i = 0; i < numWords; ++i) {
			int newPos = dictionaryHash.get(indexToWord.get(i)).intValue();
			permutation[newPos] = i;
		}
		it.unimi.dsi.fastutil.io.FastByteArrayOutputStream oa = new it.unimi.dsi.fastutil.io.FastByteArrayOutputStream();
		it.unimi.dsi.io.OutputBitStream obs = new it.unimi.dsi.io.OutputBitStream(oa, 0);
		final it.unimi.dsi.fastutil.longs.LongArrayList endpoints = new it.unimi.dsi.fastutil.longs.LongArrayList();
		pl.expectedUpdates = numWords;
		pl.start("Compressing the vectors");
		for (int i = 0; i < numWords; ++i) {
			pl.lightUpdate();
			endpoints.add(obs.writtenBits());
			int rowStart = permutation[i] * vectorSize;
			for (int col = 0; col < vectorSize; ++col) {
				int entry = entries[rowStart + col];
				obs.writeGolomb(it.unimi.dsi.bits.Fast.int2nat(entry), golombModuli[col]);
			}
		}
		pl.done();
		obs.close();
		while ((oa.length() % 4) != 0) {
			oa.write(0);
		} 
		oa.trim();
		double bps = (8.0 * oa.array.length) / entries.length;
		it.cnr.isti.hpc.Word2VecCompress.logger.info("Overall vector bit streams: {} bytes, {} bps", oa.array.length, bps);
		java.lang.System.out.println(bps);
		it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList efEndpoints = new it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList(endpoints);
		it.cnr.isti.hpc.Word2VecCompress word2vec = new it.cnr.isti.hpc.Word2VecCompress(numWords, vectorSize, quantizationFactor, oa.array, efEndpoints, dictionaryHash, golombModuli);
		if (output_filename != null) {
			it.unimi.dsi.fastutil.io.BinIO.storeObject(word2vec, output_filename);
		}
		if (jsapResult.getBoolean("check")) {
			pl.expectedUpdates = numWords;
			pl.start("Checking the output");
			for (int i = 0; i < numWords; ++i) {
				pl.lightUpdate();
				int[] vec = word2vec.getInt(indexToWord.get(i));
				for (int col = 0; col < vectorSize; ++col) {
					int expected = entries[(i * vectorSize) + col];
					int got = vec[col];
					if (expected != got) {
						it.cnr.isti.hpc.Word2VecCompress.logger.error("Row {}, Column {}: Expected {}, got {}", i, col, expected, got);
						java.lang.System.exit(1);
					}
				}
			}
			pl.done();
		}
	}
}