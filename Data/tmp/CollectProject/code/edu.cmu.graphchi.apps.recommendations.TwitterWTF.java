public class TwitterWTF implements edu.cmu.graphchi.walks.WalkUpdateFunction<edu.cmu.graphchi.EmptyType, edu.cmu.graphchi.EmptyType> {
	private static double RESET_PROBABILITY = 0.15;

	private static java.util.logging.Logger logger = edu.cmu.graphchi.ChiLogger.getLogger("twitter-wtf");

	private edu.cmu.graphchi.walks.DrunkardMobEngine<edu.cmu.graphchi.EmptyType, edu.cmu.graphchi.EmptyType> drunkardMobEngine;

	private java.lang.String baseFilename;

	private int firstSource;

	private int numSources;

	private int numShards;

	private int numWalksPerSource;

	private int salsaCacheSize = java.lang.Integer.parseInt(java.lang.System.getProperty("salsacache", "100000"));

	private java.lang.String companionUrl;

	public TwitterWTF(java.lang.String companionUrl, java.lang.String baseFilename, int nShards, int firstSource, int numSources, int walksPerSource) throws java.lang.Exception {
		this.baseFilename = baseFilename;
		this.drunkardMobEngine = new edu.cmu.graphchi.walks.DrunkardMobEngine<edu.cmu.graphchi.EmptyType, edu.cmu.graphchi.EmptyType>(baseFilename, nShards, new edu.cmu.graphchi.walks.IntDrunkardFactory());
		this.numShards = nShards;
		this.companionUrl = companionUrl;
		this.firstSource = firstSource;
		this.numSources = numSources;
		this.numWalksPerSource = walksPerSource;
	}

	private void execute(int numIters) throws java.lang.Exception {
		java.io.File graphFile = new java.io.File(baseFilename);
		final edu.cmu.graphchi.walks.distributions.RemoteDrunkardCompanion companion;
		if (companionUrl.equals("local")) {
			companion = new edu.cmu.graphchi.walks.distributions.IntDrunkardCompanion(4, java.lang.Runtime.getRuntime().maxMemory() / 3);
		} else {
			companion = ((edu.cmu.graphchi.walks.distributions.RemoteDrunkardCompanion) (java.rmi.Naming.lookup(companionUrl)));
		}
		edu.cmu.graphchi.walks.DrunkardJob drunkardJob = this.drunkardMobEngine.addJob("twitterwtf", edu.cmu.graphchi.EdgeDirection.OUT_EDGES, this, companion);
		drunkardJob.configureSourceRangeInternalIds(firstSource, numSources, numWalksPerSource);
		drunkardMobEngine.run(numIters);
		this.drunkardMobEngine = null;
		drunkardJob = null;
		final int circleOfTrustSize = 200;
		final long startTime = java.lang.System.currentTimeMillis();
		final java.util.concurrent.atomic.AtomicInteger numRecs = new java.util.concurrent.atomic.AtomicInteger();
		final java.util.concurrent.atomic.AtomicInteger pending = new java.util.concurrent.atomic.AtomicInteger();
		java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(4);
		edu.cmu.graphchi.apps.recommendations.TwitterWTF.logger.info("Started 4 threads");
		final java.lang.ThreadLocal<edu.cmu.graphchi.queries.VertexQuery> queryService = new java.lang.ThreadLocal<edu.cmu.graphchi.queries.VertexQuery>() {
			@java.lang.Override
			protected edu.cmu.graphchi.queries.VertexQuery initialValue() {
				try {
					return new edu.cmu.graphchi.queries.VertexQuery(baseFilename, numShards);
				} catch (java.io.IOException ioe) {
					ioe.printStackTrace();
					throw new java.lang.RuntimeException(ioe);
				}
			}
		};
		long t = java.lang.System.currentTimeMillis();
		for (int vertexId = firstSource; vertexId < (firstSource + numSources); vertexId++) {
			final int _vertexId = vertexId;
			pending.incrementAndGet();
			executor.execute(new java.lang.Runnable() {
				@java.lang.Override
				public void run() {
					try {
						edu.cmu.graphchi.apps.recommendations.CircleOfTrustSalsa csalsa = new edu.cmu.graphchi.apps.recommendations.CircleOfTrustSalsa(queryService.get(), salsaCacheSize);
						computeRecs(companion, circleOfTrustSize, startTime, csalsa, numRecs, _vertexId);
					} catch (java.lang.Exception err) {
						err.printStackTrace();
					}
					pending.decrementAndGet();
				}
			});
		}
		while (pending.get() > 0) {
			try {
				java.lang.Thread.sleep(10000);
			} catch (java.lang.InterruptedException ie) {
				ie.printStackTrace();
			}
			java.lang.System.out.println("Pending WTF queries: " + pending.get());
		} 
		java.lang.System.out.println("WTF-recs," + (java.lang.System.currentTimeMillis() - t));
	}

	private void computeRecs(edu.cmu.graphchi.walks.distributions.RemoteDrunkardCompanion companion, int circleOfTrustSize, long startTime, edu.cmu.graphchi.apps.recommendations.CircleOfTrustSalsa csalsa, java.util.concurrent.atomic.AtomicInteger numRecs, int vertexId) throws java.io.IOException {
		edu.cmu.graphchi.util.IdCount[] topVisits = companion.getTop(vertexId, circleOfTrustSize);
		java.util.HashSet<java.lang.Integer> circleOfTrust = new java.util.HashSet<java.lang.Integer>(topVisits.length);
		for (edu.cmu.graphchi.util.IdCount idc : topVisits) {
			circleOfTrust.add(idc.id);
		}
		csalsa.initializeGraph(circleOfTrust);
		csalsa.computeSALSA(4);
		java.util.HashSet<java.lang.Integer> doNotRecommend = csalsa.getQueryService().queryOutNeighbors(vertexId);
		doNotRecommend.add(vertexId);
		java.util.ArrayList<edu.cmu.graphchi.apps.recommendations.CircleOfTrustSalsa.SalsaVertex> recommendations = csalsa.topAuthorities(10, doNotRecommend);
		int numRecsNow = numRecs.incrementAndGet();
		if ((numRecsNow % 100) == 0) {
			long t = java.lang.System.currentTimeMillis() - startTime;
			edu.cmu.graphchi.apps.recommendations.TwitterWTF.logger.info(((("Computed recommendations for " + numRecsNow) + " users in ") + t) + "ms");
			edu.cmu.graphchi.apps.recommendations.TwitterWTF.logger.info(("Average: " + (((double) (t)) / ((vertexId - firstSource) + 1))) + "ms");
		}
	}

	@java.lang.Override
	public void processWalksAtVertex(edu.cmu.graphchi.walks.WalkArray walkArray, edu.cmu.graphchi.ChiVertex<edu.cmu.graphchi.EmptyType, edu.cmu.graphchi.EmptyType> vertex, edu.cmu.graphchi.walks.DrunkardContext drunkardContext_, java.util.Random randomGenerator) {
		int[] walks = ((edu.cmu.graphchi.walks.IntWalkArray) (walkArray)).getArray();
		edu.cmu.graphchi.walks.IntDrunkardContext drunkardContext = ((edu.cmu.graphchi.walks.IntDrunkardContext) (drunkardContext_));
		int numWalks = walks.length;
		int numOutEdges = vertex.numOutEdges();
		if (numOutEdges > 0) {
			for (int i = 0; i < numWalks; i++) {
				int walk = walks[i];
				if (randomGenerator.nextDouble() < edu.cmu.graphchi.apps.recommendations.TwitterWTF.RESET_PROBABILITY) {
					drunkardContext.resetWalk(walk, false);
				} else {
					int nextHop = vertex.getOutEdgeId(randomGenerator.nextInt(numOutEdges));
					boolean shouldTrack = !drunkardContext.isWalkStartedFromVertex(walk);
					drunkardContext.forwardWalkTo(walk, nextHop, shouldTrack);
				}
			}
		} else {
			for (int i = 0; i < numWalks; i++) {
				drunkardContext.resetWalk(walks[i], false);
			}
		}
	}

	@java.lang.Override
	public int[] getNotTrackedVertices(edu.cmu.graphchi.ChiVertex<edu.cmu.graphchi.EmptyType, edu.cmu.graphchi.EmptyType> vertex) {
		int[] notCounted = new int[1];
		notCounted[0] = vertex.getId();
		return notCounted;
	}

	protected static edu.cmu.graphchi.preprocessing.FastSharder createSharder(java.lang.String graphName, int numShards) throws java.io.IOException {
		return new edu.cmu.graphchi.preprocessing.FastSharder<edu.cmu.graphchi.EmptyType, edu.cmu.graphchi.EmptyType>(graphName, numShards, null, null, null, null);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		long t = java.lang.System.currentTimeMillis();
		org.apache.commons.cli.Options cmdLineOptions = new org.apache.commons.cli.Options();
		cmdLineOptions.addOption("g", "graph", true, "graph file name");
		cmdLineOptions.addOption("n", "nshards", true, "number of shards");
		cmdLineOptions.addOption("t", "filetype", true, "filetype (edgelist|adjlist)");
		cmdLineOptions.addOption("f", "firstsource", true, "id of the first source vertex (internal id)");
		cmdLineOptions.addOption("s", "nsources", true, "number of sources");
		cmdLineOptions.addOption("w", "walkspersource", true, "number of walks to start from each source");
		cmdLineOptions.addOption("i", "niters", true, "number of iterations");
		cmdLineOptions.addOption("u", "companion", true, "RMI url to the DrunkardCompanion or 'local' (default)");
		try {
			org.apache.commons.cli.CommandLineParser parser = new org.apache.commons.cli.PosixParser();
			org.apache.commons.cli.CommandLine cmdLine = parser.parse(cmdLineOptions, args);
			java.lang.String baseFilename = cmdLine.getOptionValue("graph");
			int nShards = java.lang.Integer.parseInt(cmdLine.getOptionValue("nshards"));
			java.lang.String fileType = (cmdLine.hasOption("filetype")) ? cmdLine.getOptionValue("filetype") : null;
			if (baseFilename.equals("pipein")) {
				edu.cmu.graphchi.preprocessing.FastSharder sharder = edu.cmu.graphchi.apps.recommendations.TwitterWTF.createSharder(baseFilename, nShards);
				sharder.shard(java.lang.System.in, fileType);
			} else {
				edu.cmu.graphchi.preprocessing.FastSharder sharder = edu.cmu.graphchi.apps.recommendations.TwitterWTF.createSharder(baseFilename, nShards);
				if (!new java.io.File(edu.cmu.graphchi.ChiFilenames.getFilenameIntervals(baseFilename, nShards)).exists()) {
					sharder.shard(new java.io.FileInputStream(new java.io.File(baseFilename)), fileType);
				} else {
					edu.cmu.graphchi.apps.recommendations.TwitterWTF.logger.info("Found shards -- no need to pre-process");
				}
			}
			int firstSource = java.lang.Integer.parseInt(cmdLine.getOptionValue("firstsource"));
			int numSources = java.lang.Integer.parseInt(cmdLine.getOptionValue("nsources"));
			int walksPerSource = java.lang.Integer.parseInt(cmdLine.getOptionValue("walkspersource"));
			int nIters = java.lang.Integer.parseInt(cmdLine.getOptionValue("niters"));
			java.lang.String companionUrl = (cmdLine.hasOption("companion")) ? cmdLine.getOptionValue("companion") : "local";
			edu.cmu.graphchi.apps.recommendations.TwitterWTF pp = new edu.cmu.graphchi.apps.recommendations.TwitterWTF(companionUrl, baseFilename, nShards, firstSource, numSources, walksPerSource);
			pp.execute(nIters);
			java.lang.System.out.println((((((((("WTF-log," + (java.lang.System.currentTimeMillis() - t)) + ",") + firstSource) + ",") + ((firstSource + numSources) - 1)) + ",") + walksPerSource) + ",") + nIters);
			java.lang.System.exit(0);
		} catch (java.lang.Exception err) {
			err.printStackTrace();
			org.apache.commons.cli.HelpFormatter formatter = new org.apache.commons.cli.HelpFormatter();
			formatter.printHelp("TwitterWTF", cmdLineOptions);
		}
	}
}