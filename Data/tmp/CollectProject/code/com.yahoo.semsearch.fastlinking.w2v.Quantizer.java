public class Quantizer {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(com.yahoo.semsearch.fastlinking.w2v.Quantizer.class);

	public class ErrorHolder {
		public int words;

		public double error;

		public ErrorHolder(int words, double error) {
			this.words = words;
			this.error = error;
		}
	}

	public double golombBits(float[] v) {
		double[] nat_v = new double[v.length];
		float abs_sum = 0;
		for (int i = 0; i < v.length; i++) {
			nat_v[i] += (v[i] >= 0) ? 2 * v[i] : -((2 * v[i]) + 1);
			abs_sum += nat_v[i];
		}
		if (abs_sum == 0) {
			return 0.0F;
		}
		double f = ((float) (v.length)) / abs_sum;
		double m = java.lang.Math.ceil(java.lang.Math.log(2 - f) / (-java.lang.Math.log(1 - f)));
		double b = java.lang.Math.ceil(java.lang.Math.log(m));
		double acc = 0;
		double ex = java.lang.Math.pow(2, b);
		for (int i = 0; i < v.length; i++) {
			double vv = (nat_v[i] < (ex - m)) ? b - 1 : b;
			acc += ((nat_v[i] / m) + 1) + vv;
		}
		return acc;
	}

	public void serialize(java.lang.String modelFile, java.lang.String outputFile, int q, int numberOfWords, boolean hashheader) throws java.io.IOException {
		com.yahoo.semsearch.fastlinking.w2v.Quantizer.log.info((("Serializing quantized model to " + outputFile) + " using q = ") + q);
		java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(outputFile), "UTF-8"));
		java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(new java.io.File(modelFile))));
		java.lang.String line = null;
		if (hashheader) {
			br.readLine();
		}
		line = br.readLine();
		int len = line.split("\\s+").length - 1;
		bw.write((((numberOfWords + "\t") + len) + "\t") + q);
		bw.write("\n");
		br.close();
		br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(modelFile), "UTF-8"));
		if (hashheader) {
			br.readLine();
		}
		while ((line = br.readLine()) != null) {
			java.lang.String[] parts = line.split("\\s+");
			bw.write(parts[0] + "\n");
		} 
		br.close();
		br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(new java.io.File(modelFile))));
		if (hashheader) {
			br.readLine();
		}
		while ((line = br.readLine()) != null) {
			java.lang.String[] parts = line.split("\\s+");
			for (int i = 1; i < parts.length; i++) {
				java.lang.Double ff = new java.lang.Double(parts[i]);
				int qa = ((int) (((int) (java.lang.Math.abs(ff) * q)) * java.lang.Math.signum(ff)));
				bw.write(qa + " ");
			}
			bw.write("\n");
		} 
		br.close();
		bw.close();
	}

	public void serializeW2VFormat(java.lang.String modelFile, java.lang.String outputFile, int q, int numberOfWords, boolean hasheader) throws java.io.IOException {
		com.yahoo.semsearch.fastlinking.w2v.Quantizer.log.info((("Serializing quantized model to " + outputFile) + " using q = ") + q);
		java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(outputFile), "UTF-8"));
		java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(new java.io.File(modelFile))));
		java.lang.String line = null;
		if (hasheader) {
			br.readLine();
		}
		line = br.readLine();
		int len = line.split("\\s+").length - 1;
		bw.write((((numberOfWords + "\t") + len) + "\t") + q);
		bw.write("\n");
		br.close();
		br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(modelFile), "UTF-8"));
		if (hasheader) {
			br.readLine();
		}
		while ((line = br.readLine()) != null) {
			java.lang.String[] parts = line.split("\\s+");
			bw.write(parts[0] + " ");
			for (int i = 1; i < parts.length; i++) {
				java.lang.Double ff = new java.lang.Double(parts[i]);
				int qa = ((int) (((int) (java.lang.Math.abs(ff) * q)) * java.lang.Math.signum(ff)));
				bw.write(qa + " ");
			}
		} 
		br.close();
		bw.close();
	}

	public com.yahoo.semsearch.fastlinking.w2v.Quantizer.ErrorHolder quantizeArray(java.lang.String modelFile, int q) throws java.io.IOException {
		final java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(new java.io.File(modelFile))));
		java.lang.String line = null;
		double error = 0;
		int items = 0;
		while ((line = br.readLine()) != null) {
			java.lang.String[] parts = line.split("\\s+");
			double norm = 0;
			items++;
			double wordError = 0;
			double[] v = new double[parts.length];
			for (int i = 1; i < parts.length; i++) {
				v[i] = new java.lang.Double(parts[i]);
				norm += v[i] * v[i];
			}
			norm = java.lang.Math.sqrt(norm);
			for (int i = 1; i < parts.length; i++) {
				int qa = ((int) (((int) (java.lang.Math.abs(v[i]) * q)) * java.lang.Math.signum(v[i])));
				double dqa = (qa + (0.5 * java.lang.Math.signum(qa))) / q;
				wordError += (v[i] - dqa) * (v[i] - dqa);
			}
			error += java.lang.Math.sqrt(wordError) / norm;
		} 
		br.close();
		return new com.yahoo.semsearch.fastlinking.w2v.Quantizer.ErrorHolder(items - 1, error / items);
	}

	public void quantizeSinglePass(java.lang.String inputFile, java.lang.String outputFile, int q, boolean hasheader, boolean w2vFormat) throws java.io.IOException {
		if (!w2vFormat) {
			serialize(inputFile, outputFile, q, countWords(inputFile, hasheader), hasheader);
		} else {
			serializeW2VFormat(inputFile, outputFile, q, countWords(inputFile, hasheader), hasheader);
		}
	}

	public int countWords(java.lang.String inputfile, boolean hasHeader) throws java.io.IOException {
		int items = 0;
		java.lang.String line = null;
		final java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(new java.io.File(inputfile))));
		if (hasHeader) {
			br.readLine();
		}
		while ((line = br.readLine()) != null) {
			items++;
		} 
		java.lang.System.out.println(("Found [" + items) + "] words ");
		return items;
	}

	public void quantize(java.lang.String inputFile, java.lang.String outputFile, double targetError, boolean hasheader, boolean w2vFormat) throws java.io.IOException {
		int low = 1;
		int high = 128;
		int bestQ = 0;
		int nWords = 0;
		while ((high - low) > 1) {
			bestQ = (high + low) / 2;
			com.yahoo.semsearch.fastlinking.w2v.Quantizer.ErrorHolder err = quantizeArray(inputFile, bestQ);
			nWords = err.words;
			com.yahoo.semsearch.fastlinking.w2v.Quantizer.log.info((("Binary search: q=" + bestQ) + " err= ") + err.error);
			if (err.error > targetError) {
				low = bestQ;
			} else {
				high = bestQ;
			}
		} 
		if (!w2vFormat) {
			serialize(inputFile, outputFile, bestQ, nWords, hasheader);
		} else {
			serializeW2VFormat(inputFile, outputFile, bestQ, nWords, hasheader);
		}
	}

	public static void main(java.lang.String[] args) throws java.io.IOException, com.martiansoftware.jsap.JSAPException {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(com.yahoo.semsearch.fastlinking.w2v.Quantizer.class.getName(), "Learns entity embeddings", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.FlaggedOption("input", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'i', "input", "Entity description files"), new com.martiansoftware.jsap.Switch("direct", 'd', "direct", "use a direct quantizer and not binary search"), new com.martiansoftware.jsap.Switch("hashheader", 'h', "hashheader", "if the embeddings file has a header present (will skip it)"), new com.martiansoftware.jsap.FlaggedOption("quantizer", com.martiansoftware.jsap.JSAP.STRING_PARSER, "10", com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'q', "quantizer", "Quantizer value"), new com.martiansoftware.jsap.FlaggedOption("error", com.martiansoftware.jsap.JSAP.STRING_PARSER, "0.35", com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'e', "error", "Error rate"), new com.martiansoftware.jsap.Switch("w2v", 'w', "w2v", "Serialize the quantized vectors using the original w2v format. If you want to compress the vectors later, you must -not- use this option"), new com.martiansoftware.jsap.FlaggedOption("output", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'o', "output", "Compressed version") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		com.yahoo.semsearch.fastlinking.w2v.Quantizer q = new com.yahoo.semsearch.fastlinking.w2v.Quantizer();
		if (jsapResult.getBoolean("direct")) {
			java.lang.System.out.println(("Using as a quantizer " + jsapResult.getString("quantizer")) + " (won't attempt to search for a better one) ");
			q.quantizeSinglePass(jsapResult.getString("input"), jsapResult.getString("output"), java.lang.Integer.parseInt(jsapResult.getString("quantizer")), jsapResult.getBoolean("hashheader"), jsapResult.getBoolean("w2v"));
		} else {
			q.quantize(jsapResult.getString("input"), jsapResult.getString("output"), java.lang.Double.parseDouble(jsapResult.getString("error")), jsapResult.getBoolean("hashheader"), jsapResult.getBoolean("w2v"));
		}
	}
}