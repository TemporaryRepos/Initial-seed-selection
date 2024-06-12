public class WordVectorsUtils {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.martiansoftware.jsap.SimpleJSAP jsap = new com.martiansoftware.jsap.SimpleJSAP(com.yahoo.semsearch.fastlinking.w2v.WordVectorsUtils.class.getName(), "Provides an interface for reading word vectors from a serialized word vector file", new com.martiansoftware.jsap.Parameter[]{ new com.martiansoftware.jsap.FlaggedOption("input", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'i', "input", "Input words to cluster"), new com.martiansoftware.jsap.FlaggedOption("words", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.REQUIRED, 'v', "words", "Words vectors file"), new com.martiansoftware.jsap.FlaggedOption("cluster", com.martiansoftware.jsap.JSAP.INTEGER_PARSER, "100", com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'k', "cluster", "Number of clusters"), new com.martiansoftware.jsap.FlaggedOption("original", com.martiansoftware.jsap.JSAP.STRING_PARSER, com.martiansoftware.jsap.JSAP.NO_DEFAULT, com.martiansoftware.jsap.JSAP.NOT_REQUIRED, 'o', "Words in the original centroids", "File with the words corresponding to the original clusters") });
		com.martiansoftware.jsap.JSAPResult jsapResult = jsap.parse(args);
		if (jsap.messagePrinted()) {
			return;
		}
		com.yahoo.semsearch.fastlinking.w2v.WordVectorsUtils reader = new com.yahoo.semsearch.fastlinking.w2v.WordVectorsUtils();
		java.util.ArrayList<java.lang.String> words = reader.readWordsFromFile(jsapResult.getString("input"));
		it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry> clusters = null;
		if (jsapResult.getString("original") != null) {
			com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors map = com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors.read(jsapResult.getString("input"));
			clusters = reader.assignClosest(map, reader.readWordsFromFile(jsapResult.getString("original")));
		} else {
			com.yahoo.semsearch.fastlinking.w2v.CompressedW2V unigrams = new com.yahoo.semsearch.fastlinking.w2v.CompressedW2V(jsapResult.getString("words"));
			com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors map = new com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors();
			map.N = unigrams.getVectorLength();
			it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, float[]> vectors = new it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, float[]>();
			map.vectors = vectors;
			for (java.lang.String w : words) {
				float[] vv = unigrams.getVectorOf(w);
				if (vv != null) {
					vectors.put(w, vv);
				}
			}
			clusters = reader.cluster(jsapResult.getInt("cluster"), map);
		}
		reader.printClusters(clusters);
	}

	public void printClusters(it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry> cluster) {
		int k = -1;
		for (com.yahoo.semsearch.fastlinking.view.ClusterEntry jj : cluster.values()) {
			if (jj.cluster > k) {
				k = jj.cluster;
			}
		}
		k++;
		for (int i = 0; i < k; i++) {
			for (java.lang.String s : cluster.keySet()) {
				if (cluster.get(s).cluster == i) {
					java.lang.System.out.println((((s + "\t") + i) + "\t") + cluster.get(s).score);
				}
			}
		}
	}

	public java.util.HashMap<java.lang.Integer, float[]> calculateCentroids(com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors map, it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry> clusters) {
		java.util.HashMap<java.lang.Integer, float[]> centroids = new java.util.HashMap<>();
		it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap wordsPerCluster = new it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap();
		for (java.lang.String word : clusters.keySet()) {
			float[] vectorOf = map.getVectorOf(word);
			if (vectorOf != null) {
				final int c = clusters.get(word).cluster;
				float[] partial = centroids.get(c);
				if (partial == null) {
					partial = new float[map.N];
				}
				for (int i = 0; i < map.N; i++) {
					partial[i] += vectorOf[i];
				}
				centroids.put(c, partial);
				wordsPerCluster.addTo(c, 1);
			}
		}
		for (java.lang.Integer i : centroids.keySet()) {
			float[] c = centroids.get(i);
			int nw = wordsPerCluster.get(i);
			for (int j = 0; j < map.N; j++) {
				c[j] /= nw;
			}
			centroids.put(i, c);
		}
		return centroids;
	}

	public it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry> clusterWithOriginalCentroids(java.lang.String originalCentroidsFile, com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors map) throws java.io.IOException {
		java.util.ArrayList<java.lang.String> words = readWordsFromFile(originalCentroidsFile);
		java.lang.String[] order = createStringArray(map);
		it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> wordMap = createWordMap(order);
		int[] originalAssign = originalAssignment(map, words, wordMap);
		return cluster(words.size(), map, originalAssign, order);
	}

	public java.lang.String[] createStringArray(com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors map) {
		java.lang.String[] mapS = new java.lang.String[map.getVectorLength()];
		int z = 0;
		for (java.lang.String s : map.vectors.keySet()) {
			mapS[z++] = s;
		}
		return mapS;
	}

	private it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> createWordMap(java.lang.String[] x) {
		it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> map = new it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String>();
		for (int i = 0; i < x.length; i++) {
			map.put(x[i], i);
		}
		return map;
	}

	public java.util.ArrayList<java.lang.String> readWordsFromFile(java.lang.String input) throws java.io.IOException {
		final java.io.BufferedReader lines = new java.io.BufferedReader(new java.io.FileReader(input));
		java.lang.String line;
		java.util.ArrayList<java.lang.String> words = new java.util.ArrayList<java.lang.String>();
		while ((line = lines.readLine()) != null) {
			java.lang.String nLine = line.trim();
			if (!nLine.isEmpty()) {
				words.add(line.trim());
			}
		} 
		lines.close();
		return words;
	}

	public int[] originalAssignment(final com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors map, java.util.ArrayList<java.lang.String> words, it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<java.lang.String> order) {
		final int len = map.vectors.entrySet().size();
		int[] original = new int[len];
		java.util.Random r = new java.util.Random();
		for (int i = 0; i < len; i++) {
			original[i] = r.nextInt(words.size());
		}
		int j = 0;
		for (java.lang.String s : words) {
			original[order.get(s)] = j++;
		}
		return original;
	}

	public it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry> cluster(final int k, final com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors map) {
		final int len = map.vectors.keySet().size();
		int[] original = new int[len];
		java.util.Random r = new java.util.Random();
		for (int i = 0; i < k; i++) {
			original[i] = i;
		}
		for (int i = k + 1; i < len; i++) {
			original[i] = r.nextInt(k);
		}
		java.lang.String[] words = new java.lang.String[map.vectors.keySet().size()];
		int z = 0;
		for (java.lang.String s : map.vectors.keySet()) {
			words[z++] = s;
		}
		return cluster(k, map, original, words);
	}

	public it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry> assignClosest(final com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors map, java.util.ArrayList<java.lang.String> words) {
		final int d = map.getVectorLength();
		it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry> assignment = new it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry>();
		for (java.lang.String w : map.vectors.keySet()) {
			float maxSim = -1;
			int bestWord = -1;
			for (int j = 0; j < words.size(); j++) {
				final float s = com.yahoo.semsearch.fastlinking.w2v.WordVectorsUtils.sim(map.vectors.get(w), map.vectors.get(words.get(j)), d);
				if (s > maxSim) {
					maxSim = s;
					bestWord = j;
				}
			}
			com.yahoo.semsearch.fastlinking.view.ClusterEntry e = new com.yahoo.semsearch.fastlinking.view.ClusterEntry();
			e.cluster = bestWord;
			e.score = maxSim;
			assignment.put(w, e);
		}
		return assignment;
	}

	public it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry> cluster(final int k, final com.yahoo.semsearch.fastlinking.w2v.UncompressedWordVectors map, int[] originalAssigment, java.lang.String[] words) {
		final int N = words.length;
		int z = 0;
		final int d = map.N;
		float[][] x = new float[N][];
		for (z = 0; z < N; z++) {
			x[z] = map.vectors.get(words[z]);
		}
		final int maxiter = 100;
		it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry> clusters = new it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<java.lang.String, com.yahoo.semsearch.fastlinking.view.ClusterEntry>();
		float[][] centroids = computeCentroids(x, k, d, N, originalAssigment);
		int[] assignment = new int[N];
		boolean done = false;
		int iterations = 0;
		while (!done) {
			boolean change = false;
			int[] newAssignment = new int[N];
			for (int i = 0; i < N; i++) {
				float maxSim = -1;
				int bestCentroid = 0;
				for (int j = 0; j < k; j++) {
					final float s = com.yahoo.semsearch.fastlinking.w2v.WordVectorsUtils.sim(centroids[j], x[i], d);
					if (s > maxSim) {
						maxSim = s;
						bestCentroid = j;
					}
				}
				newAssignment[i] = bestCentroid;
				if (bestCentroid != assignment[i]) {
					change = true;
				}
			}
			assignment = newAssignment;
			if (((iterations++) > maxiter) || (!change)) {
				done = true;
			}
			centroids = computeCentroids(x, k, d, N, newAssignment);
		} 
		for (int i = 0; i < N; i++) {
			com.yahoo.semsearch.fastlinking.view.ClusterEntry e = new com.yahoo.semsearch.fastlinking.view.ClusterEntry();
			e.cluster = assignment[i];
			e.score = com.yahoo.semsearch.fastlinking.w2v.WordVectorsUtils.sim(centroids[assignment[i]], x[i], d);
			clusters.put(words[i], e);
		}
		return clusters;
	}

	public float[][] computeCentroids(float[][] x, int k, int d, int N, int[] assignment) {
		float[][] centroids = new float[k][d];
		int[] elementsInCluster = new int[k];
		for (int z = 0; z < N; z++) {
			for (int p = 0; p < d; p++) {
				centroids[assignment[z]][p] += x[z][p];
			}
			elementsInCluster[assignment[z]]++;
		}
		for (int z = 0; z < k; z++) {
			for (int p = 0; p < d; p++) {
				centroids[z][p] /= elementsInCluster[z];
			}
		}
		return centroids;
	}

	public static float[] centroid(java.util.Collection<java.lang.String> words, int N, com.yahoo.semsearch.fastlinking.w2v.WordVectors vectors) {
		float[] acum = new float[N];
		int wordsWithFeatures = 0;
		for (java.lang.String w : words) {
			float[] v = vectors.getVectorOf(w);
			if (v != null) {
				wordsWithFeatures++;
				for (int i = 0; i < N; i++) {
					acum[i] += v[i];
				}
			}
		}
		if (wordsWithFeatures == 0) {
			return acum;
		}
		for (int i = 0; i < N; i++) {
			acum[i] /= wordsWithFeatures;
		}
		return acum;
	}

	public static float sim(float[] v, float[] w, int N) {
		float score = 0;
		float la = 0;
		float lb = 0;
		for (int i = 0; i < N; i++) {
			score += v[i] * w[i];
			la += w[i] * w[i];
			lb += v[i] * v[i];
		}
		if ((la == 0) || (lb == 0)) {
			return 0;
		}
		return ((float) (score / (java.lang.Math.sqrt(la) * java.lang.Math.sqrt(lb))));
	}

	public static float[] queryCentroid(java.lang.String query, int N, com.yahoo.semsearch.fastlinking.w2v.WordVectors vectors) {
		java.util.ArrayList<java.lang.String> words = new java.util.ArrayList<java.lang.String>();
		java.lang.String[] chunks = com.yahoo.semsearch.fastlinking.w2v.WordVectorsUtils.chunk(query);
		for (java.lang.String s : chunks) {
			words.add(s);
		}
		return com.yahoo.semsearch.fastlinking.w2v.WordVectorsUtils.centroid(words, N, vectors);
	}

	private static java.lang.String[] chunk(java.lang.String query) {
		return query.split("\\s");
	}
}