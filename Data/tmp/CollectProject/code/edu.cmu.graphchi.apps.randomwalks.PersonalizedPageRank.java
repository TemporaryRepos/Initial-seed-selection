public class PersonalizedPageRank implements edu.cmu.graphchi.walks.WalkUpdateFunction<edu.cmu.graphchi.EmptyType, edu.cmu.graphchi.EmptyType> {
	private static double RESET_PROBABILITY = 0.15;

	private static java.util.logging.Logger logger = edu.cmu.graphchi.ChiLogger.getLogger("personalized-pagerank");

	private edu.cmu.graphchi.walks.DrunkardMobEngine<edu.cmu.graphchi.EmptyType, edu.cmu.graphchi.EmptyType> drunkardMobEngine;

	private java.lang.String baseFilename;

	private int firstSource;

	private int numSources;

	private int numWalksPerSource;

	private java.lang.String companionUrl;

	public PersonalizedPageRank(java.lang.String companionUrl, java.lang.String baseFilename, int nShards, int firstSource, int numSources, int walksPerSource) throws java.lang.Exception {
		this.baseFilename = baseFilename;
		this.drunkardMobEngine = new edu.cmu.graphchi.walks.DrunkardMobEngine<edu.cmu.graphchi.EmptyType, edu.cmu.graphchi.EmptyType>(baseFilename, nShards, new edu.cmu.graphchi.walks.IntDrunkardFactory());
		this.companionUrl = companionUrl;
		this.firstSource = firstSource;
		this.numSources = numSources;
		this.numWalksPerSource = walksPerSource;
	}

	private void execute(int numIters) throws java.lang.Exception {
		java.io.File graphFile = new java.io.File(baseFilename);
		edu.cmu.graphchi.walks.distributions.RemoteDrunkardCompanion companion;
		if (companionUrl.equals("local")) {
			companion = new edu.cmu.graphchi.walks.distributions.IntDrunkardCompanion(4, java.lang.Runtime.getRuntime().maxMemory() / 3);
		} else {
			companion = ((edu.cmu.graphchi.walks.distributions.RemoteDrunkardCompanion) (java.rmi.Naming.lookup(companionUrl)));
		}
		edu.cmu.graphchi.walks.DrunkardJob drunkardJob = this.drunkardMobEngine.addJob("personalizedPageRank", edu.cmu.graphchi.EdgeDirection.OUT_EDGES, this, companion);
		drunkardJob.configureSourceRangeInternalIds(firstSource, numSources, numWalksPerSource);
		drunkardMobEngine.run(numIters);
		int nTop = 100;
		companion.outputDistributions((((((baseFilename + "_ppr_") + firstSource) + "_") + ((firstSource + numSources) - 1)) + ".top") + nTop, nTop);
		edu.cmu.graphchi.preprocessing.VertexIdTranslate vertexIdTranslate = this.drunkardMobEngine.getVertexIdTranslate();
		edu.cmu.graphchi.util.IdCount[] topForFirst = companion.getTop(firstSource, 10);
		java.lang.System.out.println(((("Top visits from source vertex " + vertexIdTranslate.forward(firstSource)) + " (internal id=") + firstSource) + ")");
		for (edu.cmu.graphchi.util.IdCount idc : topForFirst) {
			java.lang.System.out.println((vertexIdTranslate.backward(idc.id) + ": ") + idc.count);
		}
		if (companion instanceof edu.cmu.graphchi.walks.distributions.DrunkardCompanion) {
			((edu.cmu.graphchi.walks.distributions.DrunkardCompanion) (companion)).close();
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
				if (randomGenerator.nextDouble() < edu.cmu.graphchi.apps.randomwalks.PersonalizedPageRank.RESET_PROBABILITY) {
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
		int[] notCounted = new int[1 + vertex.numOutEdges()];
		for (int i = 0; i < vertex.numOutEdges(); i++) {
			notCounted[i + 1] = vertex.getOutEdgeId(i);
		}
		notCounted[0] = vertex.getId();
		return notCounted;
	}

	protected static edu.cmu.graphchi.preprocessing.FastSharder createSharder(java.lang.String graphName, int numShards) throws java.io.IOException {
		return new edu.cmu.graphchi.preprocessing.FastSharder<edu.cmu.graphchi.EmptyType, edu.cmu.graphchi.EmptyType>(graphName, numShards, null, null, null, null);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
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
				edu.cmu.graphchi.preprocessing.FastSharder sharder = edu.cmu.graphchi.apps.randomwalks.PersonalizedPageRank.createSharder(baseFilename, nShards);
				sharder.shard(java.lang.System.in, fileType);
			} else {
				edu.cmu.graphchi.preprocessing.FastSharder sharder = edu.cmu.graphchi.apps.randomwalks.PersonalizedPageRank.createSharder(baseFilename, nShards);
				if (!new java.io.File(edu.cmu.graphchi.ChiFilenames.getFilenameIntervals(baseFilename, nShards)).exists()) {
					sharder.shard(new java.io.FileInputStream(new java.io.File(baseFilename)), fileType);
				} else {
					edu.cmu.graphchi.apps.randomwalks.PersonalizedPageRank.logger.info("Found shards -- no need to pre-process");
				}
			}
			int firstSource = java.lang.Integer.parseInt(cmdLine.getOptionValue("firstsource"));
			int numSources = java.lang.Integer.parseInt(cmdLine.getOptionValue("nsources"));
			int walksPerSource = java.lang.Integer.parseInt(cmdLine.getOptionValue("walkspersource"));
			int nIters = java.lang.Integer.parseInt(cmdLine.getOptionValue("niters"));
			java.lang.String companionUrl = (cmdLine.hasOption("companion")) ? cmdLine.getOptionValue("companion") : "local";
			edu.cmu.graphchi.apps.randomwalks.PersonalizedPageRank pp = new edu.cmu.graphchi.apps.randomwalks.PersonalizedPageRank(companionUrl, baseFilename, nShards, firstSource, numSources, walksPerSource);
			pp.execute(nIters);
		} catch (java.lang.Exception err) {
			err.printStackTrace();
			org.apache.commons.cli.HelpFormatter formatter = new org.apache.commons.cli.HelpFormatter();
			formatter.printHelp("PersonalizedPageRank", cmdLineOptions);
		}
	}
}