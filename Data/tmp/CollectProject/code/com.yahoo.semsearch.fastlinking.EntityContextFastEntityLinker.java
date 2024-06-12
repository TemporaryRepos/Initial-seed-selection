public class EntityContextFastEntityLinker extends com.yahoo.semsearch.fastlinking.FastEntityLinker {
	public EntityContextFastEntityLinker(com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash hash, com.yahoo.semsearch.fastlinking.view.EntityContext queryContext) {
		super(hash, queryContext);
		this.ranker = new com.yahoo.semsearch.fastlinking.entityranker.ContextualRanker(hash);
	}

	public EntityContextFastEntityLinker(com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash hash, com.yahoo.semsearch.fastlinking.hash.CountAndRecordStats stats, com.yahoo.semsearch.fastlinking.view.EntityContext queryContext) {
		super(hash, stats, queryContext);
		this.ranker = new com.yahoo.semsearch.fastlinking.entityranker.ContextualRanker(hash);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(com.yahoo.semsearch.fastlinking.EntityContextFastEntityLinker.class.getName(), "Interactive mode for entity linking", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.FlaggedOption("hash", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'h', "hash", "quasi succint hash"), new com.martiansoftware.jsap.FlaggedOption("vectors", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'v', "vectors", "Word vectors file"), new com.martiansoftware.jsap.FlaggedOption("labels", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'l', "labels", "File containing query2entity labels"), new com.martiansoftware.jsap.FlaggedOption("id2type", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'i', "id2type", "File with the id2type mapping"), new com.martiansoftware.jsap.Switch("centroid", 'c', "centroid", "Use centroid-based distances and not LR"), new com.martiansoftware.jsap.FlaggedOption("map", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'm', "map", "Entity 2 type mapping "), new com.martiansoftware.jsap.FlaggedOption("threshold", com.martiansoftware.jsap.JSAP.STRING_PARSER, "-20", com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'd', "threshold", "Score threshold value "), new com.martiansoftware.jsap.FlaggedOption("entities", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'e', "entities", "Entities word vectors file") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		double threshold = java.lang.Double.parseDouble(jsapResult.getString("threshold"));
		com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash hash = ((com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash) (it.unimi.dsi.fastutil.io.BinIO.loadObject(jsapResult.getString("hash"))));
		com.yahoo.semsearch.fastlinking.view.EntityContext queryContext;
		if (!jsapResult.getBoolean("centroid")) {
			queryContext = new com.yahoo.semsearch.fastlinking.w2v.LREntityContext(jsapResult.getString("vectors"), jsapResult.getString("entities"), hash);
		} else {
			queryContext = new com.yahoo.semsearch.fastlinking.w2v.CentroidEntityContext(jsapResult.getString("vectors"), jsapResult.getString("entities"), hash);
		}
		java.util.HashMap<java.lang.String, java.util.ArrayList<com.yahoo.semsearch.fastlinking.entityranker.EntityRelevanceJudgment>> labels = null;
		if (jsapResult.getString("labels") != null) {
			labels = com.yahoo.semsearch.fastlinking.FastEntityLinker.readTrainingData(jsapResult.getString("labels"));
		}
		java.lang.String map = jsapResult.getString("map");
		java.util.HashMap<java.lang.String, java.lang.String> entities2Type = null;
		if (map != null) {
			entities2Type = com.yahoo.semsearch.fastlinking.EntityContextFastEntityLinker.readEntity2IdFile(map);
		}
		com.yahoo.semsearch.fastlinking.EntityContextFastEntityLinker linker = new com.yahoo.semsearch.fastlinking.EntityContextFastEntityLinker(hash, queryContext);
		final java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.System.in));
		java.lang.String q;
		for (; ;) {
			java.lang.System.out.print(">");
			q = br.readLine();
			if (q == null) {
				java.lang.System.err.println();
				break;
			}
			if (q.length() == 0) {
				continue;
			}
			long time = -java.lang.System.nanoTime();
			try {
				java.util.List<com.yahoo.semsearch.fastlinking.FastEntityLinker.EntityResult> results = linker.getResults(q, threshold);
				for (com.yahoo.semsearch.fastlinking.FastEntityLinker.EntityResult er : results) {
					if (entities2Type != null) {
						java.lang.String name = er.text.toString().trim();
						java.lang.String newType = entities2Type.get(name);
						if (newType == null) {
							newType = "NF";
						}
						java.lang.System.out.println((((((((((((q + "\t span: \u001b[1m [") + er.text) + "] \u001b[0m eId: ") + er.id) + " ( t= ") + newType) + ")") + "  score: ") + er.score) + " ( ") + er.s.span) + " ) ");
						break;
					} else if (labels == null) {
						java.lang.System.out.println((((q + "\t") + er.text) + "\t") + er.score);
					} else {
						java.util.ArrayList<com.yahoo.semsearch.fastlinking.entityranker.EntityRelevanceJudgment> jds = labels.get(q);
						java.lang.String label = "NF";
						if (jds != null) {
							com.yahoo.semsearch.fastlinking.entityranker.EntityRelevanceJudgment relevanceOfEntity = com.yahoo.semsearch.fastlinking.FastEntityLinker.relevanceOfEntity(er.text, jds);
							label = relevanceOfEntity.label;
						}
						java.lang.System.out.println((((((q + "\t") + er.text) + "\t") + label) + "\t") + er.score);
						break;
					}
					java.lang.System.out.println();
				}
				time += java.lang.System.nanoTime();
				java.lang.System.out.println(("Time to rank and print the candidates:" + (time / 1000000.0)) + " ms");
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static java.util.HashMap<java.lang.Short, java.lang.String> readTypeMapping(java.lang.String types) throws java.io.IOException {
		java.util.HashMap<java.lang.Short, java.lang.String> typeMapping = new java.util.HashMap<>();
		final java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.FileReader(types));
		java.lang.String line;
		while ((line = lines.readLine()) != null) {
			java.lang.String[] parts = line.split("\t");
			try {
				typeMapping.put(new java.lang.Short(parts[1]), parts[0]);
			} catch (java.lang.NumberFormatException e) {
				java.lang.System.out.println("Wrong line: " + line);
				e.printStackTrace();
			}
		} 
		lines.close();
		return typeMapping;
	}

	public static java.util.HashMap<java.lang.String, java.lang.String> readEntity2IdFile(java.lang.String entities) throws java.io.IOException {
		java.util.HashMap<java.lang.String, java.lang.String> entity2Id = new java.util.HashMap<>();
		final java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.FileReader(entities));
		java.lang.String line;
		while ((line = lines.readLine()) != null) {
			java.lang.String[] parts = line.split("\t");
			try {
				java.lang.String name = parts[2].replaceAll(" ", "_");
				entity2Id.put(name, parts[3]);
			} catch (java.lang.NumberFormatException e) {
				java.lang.System.out.println("Wrong line: " + line);
			}
		} 
		lines.close();
		return entity2Id;
	}

	@java.lang.Override
	public void setContext(com.yahoo.semsearch.fastlinking.view.Span[] parts, int left, int right) {
		java.util.ArrayList<java.lang.String> ctxWords = new java.util.ArrayList<>();
		for (com.yahoo.semsearch.fastlinking.view.Span p : parts) {
			ctxWords.add(p.getSpan());
		}
		context.setContextWords(ctxWords);
	}

	@java.lang.Override
	public void setContext(java.lang.String[] parts, int left, int right) {
		java.util.ArrayList<java.lang.String> ctxWords = new java.util.ArrayList<>();
		for (java.lang.String p : parts) {
			ctxWords.add(p);
		}
		context.setContextWords(ctxWords);
	}
}