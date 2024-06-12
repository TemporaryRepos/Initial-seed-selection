public class TypeLanguageModel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap<java.lang.String, it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>> languageModels;

	public it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> freqs;

	public it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> backgroundModel;

	public int totalFreq;

	public static void main(java.lang.String[] args) throws com.martiansoftware.jsap.JSAPException, java.io.IOException {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(com.yahoo.semsearch.fastlinking.utils.TypeLanguageModel.class.getName(), "Language model for types builder", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.FlaggedOption("input", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'i', "input", "Input file"), new com.martiansoftware.jsap.FlaggedOption("output", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'o', "output", "File to serialize the data structure") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		final java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.FileReader(jsapResult.getString("input")));
		it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap<java.lang.String, it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>> languageModels = new it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap<java.lang.String, it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>>();
		it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> freqs = new it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>();
		it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> background = new it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>();
		int totalFreq = 0;
		java.lang.String line = "";
		while ((line = lines.readLine()) != null) {
			java.lang.String[] parts = line.split("\t");
			it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> typeHash = languageModels.get(parts[0]);
			if (typeHash == null) {
				typeHash = new it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>();
				languageModels.put(parts[0], typeHash);
				freqs.put(parts[0], 0);
			}
			java.lang.String[] scoreAndModifier = parts[1].split(",");
			java.lang.Integer freqI = 0;
			for (java.lang.String s : scoreAndModifier) {
				java.util.regex.Matcher m = java.util.regex.Pattern.compile("(\\()(.+)").matcher(s);
				if (m.find()) {
					java.lang.Double freqD = java.lang.Double.parseDouble(m.group(2));
					freqI = freqD.intValue();
				}
				m = java.util.regex.Pattern.compile("(.+?)(\\))").matcher(s);
				if (m.find()) {
					java.lang.String[] tmpQ = com.yahoo.semsearch.fastlinking.utils.Normalize.normalize(m.group(1)).trim().split("\\s");
					for (java.lang.String queryS : com.yahoo.semsearch.fastlinking.utils.TypeLanguageModel.getTrigrams(tmpQ)) {
						java.lang.Integer freq = typeHash.get(queryS);
						if (freq == null) {
							typeHash.put(queryS, 0);
							background.put(queryS, 0);
						}
						freqs.addTo(parts[0], freqI);
						typeHash.addTo(queryS, freqI);
						background.addTo(queryS, freqI);
						totalFreq += freqI;
					}
				}
			}
		} 
		lines.close();
		com.yahoo.semsearch.fastlinking.utils.TypeLanguageModel model = new com.yahoo.semsearch.fastlinking.utils.TypeLanguageModel();
		model.languageModels = languageModels;
		model.freqs = freqs;
		model.totalFreq = totalFreq;
		model.backgroundModel = background;
		it.unimi.dsi.fastutil.io.BinIO.storeObject(model, jsapResult.getString("output"));
	}

	private static java.util.List<java.lang.String> getTrigrams(java.lang.String[] words) {
		java.util.List<java.lang.String> query = new java.util.ArrayList<java.lang.String>();
		for (int i = 0; i < (words.length - 2); i++) {
			query.add(words[i]);
			query.add((words[i] + "_") + words[i + 1]);
			query.add((((words[i] + "_") + words[i + 1]) + "_") + words[i + 2]);
		}
		if (words.length > 1) {
			query.add((words[words.length - 2] + "_") + words[words.length - 1]);
			query.add(words[words.length - 2]);
		}
		if (words.length > 0) {
			query.add(words[words.length - 1]);
		}
		return query;
	}

	public static java.util.List<java.lang.String> getTrigrams(java.util.List<java.lang.String> words) {
		java.util.List<java.lang.String> query = new java.util.ArrayList<java.lang.String>();
		final int l = words.size();
		for (int i = 0; i < (l - 2); i++) {
			query.add(words.get(i));
			query.add((words.get(i) + "_") + words.get(i + 1));
			query.add((((words.get(i) + "_") + words.get(i + 1)) + "_") + words.get(i + 2));
		}
		if (l > 1) {
			query.add((words.get(l - 2) + "_") + words.get(l - 1));
			query.add(words.get(l - 2));
		}
		if (l > 0) {
			query.add(words.get(l - 1));
		}
		return query;
	}
}