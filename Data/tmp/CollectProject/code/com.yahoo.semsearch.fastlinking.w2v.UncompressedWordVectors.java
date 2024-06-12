public class UncompressedWordVectors implements java.io.Serializable , com.yahoo.semsearch.fastlinking.w2v.WordVectors {
	private static final long serialVersionUID = 1L;

	public it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, float[]> vectors;

	public int N;

	@java.lang.Override
	public int getVectorLength() {
		return N;
	}

	@java.lang.Override
	public float[] getVectorOf(java.lang.String word) {
		return vectors.get(word);
	}

	public static com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors read(java.lang.String file) throws java.io.IOException {
		it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, float[]> map = new it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, float[]>();
		final java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.FileReader(file));
		java.lang.String line;
		while ((line = lines.readLine()) != null) {
			java.lang.String[] parts = line.split("\t");
			float[] values = new float[parts.length - 1];
			for (int i = 1; i < parts.length; i++) {
				values[i - 1] = java.lang.Float.parseFloat(parts[i]);
			}
			map.put(parts[0], values);
		} 
		lines.close();
		com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors vector = new com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors();
		vector.vectors = map;
		return vector;
	}

	public static void main(java.lang.String[] args) throws com.martiansoftware.jsap.JSAPException, java.io.IOException {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors.class.getName(), "Creates a Word Vector representation from a string file", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.FlaggedOption("input", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'i', "input", "Vector file"), new com.martiansoftware.jsap.FlaggedOption("output", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'o', "output", "Output file name") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors vec = com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors.read(jsapResult.getString("input"));
		vec.N = vec.vectors.get(vec.vectors.keySet().iterator().next()).length;
		it.unimi.dsi.fastutil.io.BinIO.storeObject(vec, jsapResult.getString("output"));
	}
}