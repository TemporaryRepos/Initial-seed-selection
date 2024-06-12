public class QuasiSuccinctEntityHash extends com.yahoo.semsearch.fastlinking.hash.AbstractEntityHash implements java.io.Serializable {
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.class);

	private static final int PER_CANDIDATE_FEATURES = 5;

	private static final int PER_ENTITY_CANDIDATE_FEATURES = 3;

	private static final int PER_ENTITY_FEATURES = 3;

	public static final int ALIASESPERBATCH = 10000000;

	private static final long serialVersionUID = 1L;

	public it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList[] pointers;

	public it.unimi.dsi.sux4j.util.EliasFanoLongBigList[] values;

	public final it.unimi.dsi.sux4j.util.EliasFanoLongBigList entityValues;

	public final it.unimi.dsi.util.FrontCodedStringList entityNames;

	public com.yahoo.semsearch.fastlinking.hash.CountAndRecordStats stats;

	public QuasiSuccinctEntityHash(it.unimi.dsi.fastutil.objects.Object2LongFunction<? extends java.lang.CharSequence> hash, it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList[] pointers, it.unimi.dsi.sux4j.util.EliasFanoLongBigList[] values, it.unimi.dsi.sux4j.util.EliasFanoLongBigList entityValues, it.unimi.dsi.util.FrontCodedStringList frontCodedStringList) {
		super(hash);
		this.pointers = pointers;
		this.values = values;
		this.entityValues = entityValues;
		this.entityNames = frontCodedStringList;
	}

	public com.yahoo.semsearch.fastlinking.view.CandidatesInfo getCandidatesInfo(java.lang.String surfaceForm) {
		final long id = hash.getLong(surfaceForm);
		return id != (-1) ? candidatesInfo(id) : null;
	}

	public com.yahoo.semsearch.fastlinking.view.Entity getEntity(final long id) {
		com.yahoo.semsearch.fastlinking.view.Entity e = new com.yahoo.semsearch.fastlinking.view.Entity();
		long[] u = new long[com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_FEATURES];
		entityValues.get(id * com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_FEATURES, u);
		e.QEF = ((int) (u[0]));
		e.LET = ((int) (u[1]));
		e.type = ((short) (u[2]));
		e.id = ((int) (id));
		return e;
	}

	protected com.yahoo.semsearch.fastlinking.view.CandidatesInfo candidatesInfo(long index) {
		final long[] startEnd = pointers[((int) (index / com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.ALIASESPERBATCH))].get(index % com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.ALIASESPERBATCH, new long[2]);
		final int numEntities = ((int) (((startEnd[1] - startEnd[0]) - com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_CANDIDATE_FEATURES) / com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_CANDIDATE_FEATURES));
		long[] t = values[((int) (index / com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.ALIASESPERBATCH))].get(startEnd[0], new long[((int) (startEnd[1] - startEnd[0]))]);
		long[] u = new long[com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_FEATURES];
		com.yahoo.semsearch.fastlinking.view.Entity[] e = new com.yahoo.semsearch.fastlinking.view.Entity[numEntities];
		for (int i = 0; i < numEntities; i++) {
			e[i] = new com.yahoo.semsearch.fastlinking.view.Entity();
			e[i].id = ((int) (t[com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_CANDIDATE_FEATURES + (i * com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_CANDIDATE_FEATURES)]));
			e[i].LAET = ((int) (t[(com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_CANDIDATE_FEATURES + 1) + (i * com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_CANDIDATE_FEATURES)]));
			e[i].QAEF = ((int) (t[(com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_CANDIDATE_FEATURES + 2) + (i * com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_CANDIDATE_FEATURES)]));
			entityValues.get(e[i].id * com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_FEATURES, u);
			e[i].QEF = ((int) (u[0]));
			e[i].LET = ((int) (u[1]));
			e[i].type = ((short) (u[2]));
		}
		return new com.yahoo.semsearch.fastlinking.view.CandidatesInfo(e, ((int) (t[0])), ((int) (t[1])), ((int) (t[2])), ((int) (t[3])), ((int) (t[4])));
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.class.getName(), "Creates a MPHF from a file with the candidates info", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.FlaggedOption("input", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'i', "input", "Input " + "file"), new com.martiansoftware.jsap.FlaggedOption("entity2id", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'e', "entities", "TAB-separated entity names and corresponding ids"), new com.martiansoftware.jsap.FlaggedOption("wikiThreshold", com.martiansoftware.jsap.JSAP.INTEGER_PARSER, "0", com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'w', "wikiThreshold", "Minimum number of anchors to store a candidate"), new com.martiansoftware.jsap.FlaggedOption("queryThreshold", com.martiansoftware.jsap.JSAP.INTEGER_PARSER, "0", com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'q', "queryThreshold", "Minimum number of clicks to store a candidate"), new com.martiansoftware.jsap.FlaggedOption("output", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'o', "output", "Compressed version") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		final java.lang.Iterable<com.yahoo.semsearch.fastlinking.view.StringAndCandidate> stringAndCandidates = com.yahoo.semsearch.fastlinking.hash.FormatReader.stringAndCandidates(jsapResult.getString("input"), jsapResult.getInt("queryThreshold"), jsapResult.getInt("wikiThreshold"));
		final java.io.BufferedReader linesC = new java.io.BufferedReader(new java.io.FileReader(jsapResult.getString("entity2id")));
		int maxIndex = 0;
		java.lang.String line;
		while ((line = linesC.readLine()) != null) {
			java.lang.String[] parts = line.split("\t");
			int x = java.lang.Integer.parseInt(parts[1]);
			if (x > maxIndex) {
				maxIndex = x;
			}
		} 
		linesC.close();
		final java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.FileReader(jsapResult.getString("entity2id")));
		it.unimi.dsi.fastutil.objects.ObjectArrayList<java.lang.String> entityNames = new it.unimi.dsi.fastutil.objects.ObjectArrayList<>(maxIndex);
		com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.LOGGER.info("Storing entity names");
		while ((line = lines.readLine()) != null) {
			java.lang.String[] parts = line.split("\t");
			try {
				final int index = java.lang.Integer.parseInt(parts[1]);
				if (index >= entityNames.size()) {
					entityNames.size(index + 1);
				}
				final java.lang.String oldValue = entityNames.set(index, parts[0]);
				if (oldValue != null) {
					com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.LOGGER.warn(((((("Duplicate index " + index) + " for names \"") + parts[0]) + "\" and \"") + oldValue) + "\"");
				}
			} catch (java.lang.NumberFormatException e) {
				com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.LOGGER.error("Wrong line (skipping) --> " + line);
			}
		} 
		com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.LOGGER.info("done");
		lines.close();
		for (int i = 0; i < entityNames.size(); i++) {
			if (entityNames.get(i) == null) {
				entityNames.set(i, "");
			}
		}
		java.util.HashMap<java.lang.Integer, java.io.DataOutputStream> valuesArray = new java.util.HashMap<java.lang.Integer, java.io.DataOutputStream>();
		java.util.HashMap<java.lang.Integer, it.unimi.dsi.fastutil.longs.LongArrayList> pointersArray = new java.util.HashMap<java.lang.Integer, it.unimi.dsi.fastutil.longs.LongArrayList>();
		java.util.HashMap<java.lang.Integer, java.io.File> tempFiles = new java.util.HashMap<java.lang.Integer, java.io.File>();
		it.unimi.dsi.fastutil.longs.LongArrayList cutPoints = new it.unimi.dsi.fastutil.longs.LongArrayList();
		java.io.File tempFile = java.io.File.createTempFile("values", "tempfile");
		tempFile.deleteOnExit();
		int batchNumber = 0;
		tempFiles.put(batchNumber, tempFile);
		java.io.DataOutputStream values = new java.io.DataOutputStream(new it.unimi.dsi.fastutil.io.FastBufferedOutputStream(new java.io.FileOutputStream(tempFile)));
		cutPoints.add(0);
		valuesArray.put(batchNumber, values);
		pointersArray.put(batchNumber, cutPoints);
		long valuesSize = 0;
		final it.unimi.dsi.fastutil.ints.IntBigArrayBigList entityValues = new it.unimi.dsi.fastutil.ints.IntBigArrayBigList();
		entityValues.size(entityNames.size() * com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_FEATURES);
		it.unimi.dsi.logging.ProgressLogger pl = new it.unimi.dsi.logging.ProgressLogger(com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.LOGGER);
		pl.itemsName = "aliases";
		int numberOfCandidates = 0;
		for (com.yahoo.semsearch.fastlinking.view.StringAndCandidate sc : stringAndCandidates) {
			pl.lightUpdate();
			if ((numberOfCandidates++) > (com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.ALIASESPERBATCH - 1)) {
				numberOfCandidates = 1;
				batchNumber++;
				tempFile = java.io.File.createTempFile("values", "tempfile");
				tempFile.deleteOnExit();
				values.close();
				values = new java.io.DataOutputStream(new it.unimi.dsi.fastutil.io.FastBufferedOutputStream(new java.io.FileOutputStream(tempFile)));
				cutPoints = new it.unimi.dsi.fastutil.longs.LongArrayList();
				cutPoints.add(0);
				valuesArray.put(batchNumber, values);
				pointersArray.put(batchNumber, cutPoints);
				tempFiles.put(batchNumber, tempFile);
				valuesSize = 0;
			}
			com.yahoo.semsearch.fastlinking.view.CandidatesInfo ci = sc.candidatesInfo;
			values.writeInt(((int) (ci.QAF)));
			values.writeInt(((int) (ci.QAT)));
			values.writeInt(((int) (ci.QAC)));
			values.writeInt(((int) (ci.LAF)));
			values.writeInt(((int) (ci.LAT)));
			valuesSize += com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_CANDIDATE_FEATURES;
			for (com.yahoo.semsearch.fastlinking.view.Entity e : ci.entities) {
				values.writeInt(e.id);
				values.writeInt(((int) (e.LAET)));
				values.writeInt(((int) (e.QAEF)));
				valuesSize += com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_CANDIDATE_FEATURES;
				entityValues.set(e.id * com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_FEATURES, ((int) (e.QEF)));
				entityValues.set((e.id * com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_FEATURES) + 1, ((int) (e.LET)));
				entityValues.set((e.id * com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.PER_ENTITY_FEATURES) + 2, e.type);
			}
			cutPoints.add(valuesSize);
		}
		values.close();
		pl.done();
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
		it.unimi.dsi.sux4j.util.EliasFanoLongBigList[] valuesA = new it.unimi.dsi.sux4j.util.EliasFanoLongBigList[tempFiles.size()];
		it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList[] cutPointsArray = new it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList[tempFiles.size()];
		for (int i = 0; i < tempFiles.size(); i++) {
			final java.io.File xx = tempFiles.get(i);
			it.unimi.dsi.fastutil.longs.LongIterable lI = new it.unimi.dsi.fastutil.longs.LongIterable() {
				public it.unimi.dsi.fastutil.longs.LongIterator iterator() {
					return it.unimi.dsi.fastutil.longs.LongIterators.wrap(it.unimi.dsi.fastutil.io.BinIO.asIntIterable(xx).iterator());
				}
			};
			long lowerBound = java.lang.Long.MAX_VALUE;
			it.unimi.dsi.fastutil.longs.LongIterator iterator = lI.iterator();
			while (iterator.hasNext()) {
				lowerBound = java.lang.Math.min(lowerBound, iterator.nextLong());
			} 
			cutPointsArray[i] = new it.unimi.dsi.sux4j.util.EliasFanoMonotoneLongBigList(pointersArray.get(i));
			valuesA[i] = new it.unimi.dsi.sux4j.util.EliasFanoLongBigList(lI.iterator(), lowerBound, true);
		}
		com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.LOGGER.info("#Batches= " + tempFiles.size());
		com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash quasiSuccinctEntityHash = new com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash(surfaceForm2Position, cutPointsArray, valuesA, new it.unimi.dsi.sux4j.util.EliasFanoLongBigList(entityValues), new it.unimi.dsi.util.FrontCodedStringList(entityNames, 8, true));
		com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.LOGGER.info("Creating stats");
		quasiSuccinctEntityHash.stats = com.yahoo.semsearch.fastlinking.hash.CountAndRecordStats.createStats(quasiSuccinctEntityHash);
		it.unimi.dsi.fastutil.io.BinIO.storeObject(quasiSuccinctEntityHash, jsapResult.getString("output"));
		com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.LOGGER.info("...  done");
		assert com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash.checkMap(jsapResult, stringAndCandidates);
	}

	private static boolean checkMap(com.martiansoftware.jsap.JSAPResult jsapResult, java.lang.Iterable<com.yahoo.semsearch.fastlinking.view.StringAndCandidate> stringAndCandidates) throws java.io.IOException, java.lang.ClassNotFoundException {
		com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash hashCompressor = ((com.yahoo.semsearch.fastlinking.hash.QuasiSuccinctEntityHash) (it.unimi.dsi.fastutil.io.BinIO.loadObject(jsapResult.getString("output"))));
		int i = 0;
		for (com.yahoo.semsearch.fastlinking.view.StringAndCandidate sc : stringAndCandidates) {
			final com.yahoo.semsearch.fastlinking.view.CandidatesInfo original = sc.candidatesInfo;
			final com.yahoo.semsearch.fastlinking.view.CandidatesInfo compressed = hashCompressor.candidatesInfo(i);
			assert original.QAF == compressed.QAF;
			assert original.QAT == compressed.QAT;
			assert original.QAC == compressed.QAC;
			assert original.LAF == compressed.LAF;
			assert original.LAT == compressed.LAT;
			for (int j = 0; j < original.entities.length; j++) {
				assert sc.candidatesInfo.entities[j].id == hashCompressor.candidatesInfo(i).entities[j].id;
				assert sc.candidatesInfo.entities[j].type == hashCompressor.candidatesInfo(i).entities[j].type;
				assert sc.candidatesInfo.entities[j].LAET == hashCompressor.candidatesInfo(i).entities[j].LAET;
				assert sc.candidatesInfo.entities[j].QEF == hashCompressor.candidatesInfo(i).entities[j].QEF;
				assert sc.candidatesInfo.entities[j].QAEF == hashCompressor.candidatesInfo(i).entities[j].QAEF;
				assert sc.candidatesInfo.entities[j].LET == hashCompressor.candidatesInfo(i).entities[j].LET;
			}
			i++;
		}
		return true;
	}

	@java.lang.Override
	public java.lang.CharSequence getEntityName(int id) {
		return entityNames.get(id);
	}
}