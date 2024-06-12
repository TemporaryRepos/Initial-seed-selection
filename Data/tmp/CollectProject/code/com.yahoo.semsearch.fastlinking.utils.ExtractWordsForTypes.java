public class ExtractWordsForTypes {
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(com.yahoo.semsearch.fastlinking.utils.ExtractWordsForTypes.class);

	public static void main(java.lang.String[] args) throws com.martiansoftware.jsap.JSAPException, java.lang.ClassNotFoundException, java.io.IOException {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(com.yahoo.semsearch.fastlinking.utils.ExtractWordsForTypes.class.getName(), "Creates a file with the most frequent words per-type", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.FlaggedOption("input", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'i', "input", "Input file"), new com.martiansoftware.jsap.FlaggedOption("hash", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'h', "hash", "Hash file"), new com.martiansoftware.jsap.FlaggedOption("map", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'm', "map", "Entity 2 type mapping "), new com.martiansoftware.jsap.FlaggedOption("output", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'o', "output", "Out file") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		int numberOfPhrases;
		it.unimi.dsi.logging.ProgressLogger pl = new it.unimi.dsi.logging.ProgressLogger(com.yahoo.semsearch.fastlinking.utils.ExtractWordsForTypes.LOGGER);
		com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash hash = ((com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash) (it.unimi.dsi.fastutil.io.BinIO.loadObject(jsapResult.getString("hash"))));
		numberOfPhrases = ((int) (hash.stats.phrases));
		it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>> wordMap = new it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>>();
		it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>> wordMapB = new it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>>();
		java.lang.Iterable<com.yahoo.semsearch.fastlinking.view.StringAndCandidate> stringAndCandidates2 = com.yahoo.semsearch.fastlinking.hash.FormatReader.stringAndCandidates(jsapResult.getString("input"), 0, 0);
		java.util.HashMap<java.lang.String, java.lang.String> id2Type = com.yahoo.semsearch.fastlinking.EntityContextFastEntityLinker.readEntity2IdFile(jsapResult.getString("map"));
		it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap<java.lang.String> entityTypes = new it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap<java.lang.String>();
		for (java.lang.String typeName : id2Type.values()) {
			wordMap.put(typeName, new it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>());
			wordMap.get(typeName).defaultReturnValue(0);
			wordMapB.put(typeName, new it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>());
			wordMapB.get(typeName).defaultReturnValue(0);
		}
		for (int i = 0; i < hash.entityNames.size(); i++) {
			it.unimi.dsi.lang.MutableString name = hash.entityNames.get(i);
			if (!name.isEmpty()) {
				java.lang.String newType = id2Type.get(name.toString());
				if (newType != null) {
					entityTypes.put(i, newType);
				}
			}
		}
		pl.set(numberOfPhrases);
		pl.start("Extracting words");
		for (com.yahoo.semsearch.fastlinking.view.StringAndCandidate sc : stringAndCandidates2) {
			java.lang.String[] words = sc.surfaceForm.split("\\s+");
			for (com.yahoo.semsearch.fastlinking.view.Entity e : sc.candidatesInfo.entities) {
				java.lang.String newType = entityTypes.get(e.id);
				if (newType != null) {
					it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> wordsForType = wordMap.get(newType);
					it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> bigramsForType = wordMapB.get(newType);
					wordsForType.addTo(words[0], ((int) (e.QAEF)));
					for (int i = 1; i < words.length; i++) {
						java.lang.String pre = (words[i - 1] + "_") + words[i];
						wordsForType.addTo(words[0], ((int) (e.QAEF)));
						bigramsForType.addTo(pre, ((int) (e.QAEF)));
					}
				}
			}
			pl.lightUpdate();
		}
		pl.stop();
		pl.start("Writting out");
		java.io.FileWriter fw = new java.io.FileWriter(jsapResult.getString("output"));
		for (java.lang.String type : wordMap.keySet()) {
			fw.write(type + "\t");
			it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> wordsForType = wordMap.get(type);
			for (java.lang.String word : wordsForType.keySet()) {
				fw.write(((word + "\u0001") + wordsForType.get(word)) + "\t");
			}
			wordsForType = wordMapB.get(type);
			for (java.lang.String word : wordsForType.keySet()) {
				fw.write(((word + "\u0001") + wordsForType.get(word)) + "\t");
			}
			fw.write("\n");
		}
		pl.stop();
		fw.close();
	}
}