public class FilterWordsFromType {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(com.yahoo.semsearch.fastlinking.utils.FilterWordsFromType.class.getName(), "Filters a type-to-word file", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.FlaggedOption("input", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'i', "input", "type to words file"), new com.martiansoftware.jsap.FlaggedOption("type", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 't', "type", "type id mapping file") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.FileReader(jsapResult.getString("type")));
		java.lang.String line = null;
		java.util.HashMap<java.lang.Integer, java.lang.String> typeMap = new java.util.HashMap<java.lang.Integer, java.lang.String>();
		while ((line = lines.readLine()) != null) {
			if (line.isEmpty()) {
				continue;
			}
			java.lang.String[] parts = line.split("\t");
			typeMap.put(java.lang.Integer.parseInt(parts[0]), parts[2].trim());
		} 
		lines.close();
		lines = new java.io.BufferedReader(new java.io.FileReader(jsapResult.getString("input")));
		line = null;
		while ((line = lines.readLine()) != null) {
			if (line.isEmpty()) {
				continue;
			}
			java.lang.String[] parts = line.split("\t");
			java.lang.String typeID = typeMap.get(java.lang.Integer.parseInt(parts[0])).trim();
			final int l = parts.length - 1;
			java.lang.Integer[] idx = new java.lang.Integer[l];
			java.lang.String[] wordsArray = new java.lang.String[l];
			int[] freqs = new int[l];
			for (int i = 1; i < parts.length; i++) {
				java.lang.String[] words = parts[i].split("\u0001");
				int freq = java.lang.Integer.parseInt(words[1]);
				idx[i - 1] = i - 1;
				freqs[i - 1] = freq;
				wordsArray[i - 1] = words[0];
			}
			final int[] fFreq = freqs;
			java.util.Arrays.sort(idx, new java.util.Comparator<java.lang.Integer>() {
				public int compare(java.lang.Integer i1, java.lang.Integer i2) {
					return -java.lang.Integer.compare(fFreq[i1], fFreq[i2]);
				}
			});
			int index = 0;
			java.lang.System.out.print(typeID + "\t");
			for (int i = 0; i < 5000; i++) {
				if (i == l) {
					break;
				}
				if (wordsArray[idx[i]].contains("_")) {
					index = i;
					break;
				}
				java.lang.System.out.print(((wordsArray[idx[i]] + "\t") + fFreq[idx[i]]) + "\t");
			}
			for (int i = index; i < 5000; i++) {
				if (i == l) {
					break;
				}
				java.lang.System.out.print(((wordsArray[idx[i]] + "\t") + fFreq[idx[i]]) + "\t");
			}
			java.lang.System.out.println();
		} 
		lines.close();
	}
}