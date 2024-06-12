public class MovieRecommender {
	protected java.lang.String baseFilename;

	protected int nShards;

	protected int D;

	protected static java.util.logging.Logger logger = edu.cmu.graphchi.ChiLogger.getLogger("movie-recommender");

	public MovieRecommender(java.lang.String baseFilename, int nShards, int D) {
		this.baseFilename = baseFilename;
		this.nShards = nShards;
		this.D = D;
	}

	protected void execute() throws java.lang.Exception {
		edu.cmu.graphchi.apps.ALSMatrixFactorization als = edu.cmu.graphchi.apps.ALSMatrixFactorization.computeALS(baseFilename, nShards, D, 5);
		edu.cmu.graphchi.apps.recommendations.MovieRecommender.logger.info("Computed ALS, now random walks");
		edu.cmu.graphchi.walks.DrunkardMobEngine<java.lang.Integer, java.lang.Float> drunkardMobEngine = new edu.cmu.graphchi.walks.DrunkardMobEngine<java.lang.Integer, java.lang.Float>(baseFilename, nShards, new edu.cmu.graphchi.walks.IntDrunkardFactory());
		edu.cmu.graphchi.walks.DrunkardJob positiveJob = drunkardMobEngine.addJob("positive", edu.cmu.graphchi.EdgeDirection.IN_AND_OUT_EDGES, new edu.cmu.graphchi.apps.recommendations.MovieRecommender.PositiveWalkUpdate(), new edu.cmu.graphchi.walks.distributions.IntDrunkardCompanion(2, java.lang.Runtime.getRuntime().maxMemory() / 8));
		edu.cmu.graphchi.walks.DrunkardJob negativeJob = drunkardMobEngine.addJob("negative", edu.cmu.graphchi.EdgeDirection.IN_AND_OUT_EDGES, new edu.cmu.graphchi.apps.recommendations.MovieRecommender.NegativeWalkUpdate(), new edu.cmu.graphchi.walks.distributions.IntDrunkardCompanion(2, java.lang.Runtime.getRuntime().maxMemory() / 8));
		drunkardMobEngine.setEdataConverter(new edu.cmu.graphchi.datablocks.FloatConverter());
		edu.cmu.graphchi.apps.ALSMatrixFactorization.BipartiteGraphInfo graphInfo = als.getGraphInfo();
		edu.cmu.graphchi.preprocessing.VertexIdTranslate vertexIdTranslate = drunkardMobEngine.getVertexIdTranslate();
		java.util.ArrayList<java.lang.Integer> userVertices = new java.util.ArrayList<java.lang.Integer>(graphInfo.getNumLeft());
		int numUsers = 50000;
		int walksPerSource = 1000;
		if (numUsers > graphInfo.getNumLeft()) {
			graphInfo.getNumLeft();
		}
		edu.cmu.graphchi.apps.recommendations.MovieRecommender.logger.info(("Compute predictions for first " + numUsers) + " users");
		for (int i = 0; i < numUsers; i++) {
			userVertices.add(vertexIdTranslate.forward(i));
		}
		positiveJob.configureWalkSources(userVertices, walksPerSource);
		negativeJob.configureWalkSources(userVertices, walksPerSource);
		drunkardMobEngine.run(6);
		for (int i = 0; i < 500; i++) {
			int userId = vertexIdTranslate.forward(i);
			edu.cmu.graphchi.util.IdCount[] posTop = positiveJob.getCompanion().getTop(userId, 20);
			edu.cmu.graphchi.util.IdCount[] negTop = negativeJob.getCompanion().getTop(userId, 20);
			double sumEstimatePos = 0.0;
			double sumEstimateNeg = 0.0;
			int n = java.lang.Math.min(posTop.length, negTop.length);
			for (int j = 0; j < n; j++) {
				sumEstimatePos += als.predict(userId, posTop[j].id);
				sumEstimateNeg += als.predict(userId, negTop[j].id);
			}
			long t = java.lang.System.currentTimeMillis();
			double allSum = 0;
			int numMovies = graphInfo.getNumRight();
			for (int m = 0; m < numMovies; m++) {
				int movieId = vertexIdTranslate.forward(graphInfo.getNumLeft() + m);
				allSum += als.predict(userId, movieId);
			}
			java.lang.System.out.println(((((((((((i + " avg pos: ") + (sumEstimatePos / n)) + "; avg neg: ") + (sumEstimateNeg / n)) + "; all=") + (allSum / graphInfo.getNumRight())) + " (") + (java.lang.System.currentTimeMillis() - t)) + " ms for ") + numMovies) + " movies");
		}
	}

	protected static class PositiveWalkUpdate implements edu.cmu.graphchi.walks.WalkUpdateFunction<java.lang.Integer, java.lang.Float> {
		@java.lang.Override
		public void processWalksAtVertex(edu.cmu.graphchi.walks.WalkArray walkArray, edu.cmu.graphchi.ChiVertex<java.lang.Integer, java.lang.Float> vertex, edu.cmu.graphchi.walks.DrunkardContext drunkardContext, java.util.Random randomGenerator) {
			int[] walks = ((edu.cmu.graphchi.walks.IntWalkArray) (walkArray)).getArray();
			edu.cmu.graphchi.apps.recommendations.MovieRecommender.PositiveWalkUpdate.hopToHighRatings(walks, vertex, ((edu.cmu.graphchi.walks.IntDrunkardContext) (drunkardContext)), randomGenerator);
		}

		private static final float[] weightedRating = new float[]{ 0.0F, 1.0E-5F, 1.0E-5F, 1.0E-4F, 100.0F, 1000.0F };

		protected static void hopToHighRatings(int[] walks, edu.cmu.graphchi.ChiVertex<java.lang.Integer, java.lang.Float> vertex, edu.cmu.graphchi.walks.IntDrunkardContext drunkardContext, java.util.Random randomGenerator) {
			int[] hops = edu.cmu.graphchi.walks.WeightedHopper.generateRandomHopsAliasMethod(randomGenerator, vertex, walks.length, edu.cmu.graphchi.EdgeDirection.IN_AND_OUT_EDGES, new edu.cmu.graphchi.walks.WeightedHopper.EdgeWeightMap() {
				@java.lang.Override
				public float map(float x) {
					int r = ((int) (x));
					return edu.cmu.graphchi.apps.recommendations.MovieRecommender.PositiveWalkUpdate.weightedRating[r];
				}
			});
			for (int i = 0; i < walks.length; i++) {
				drunkardContext.forwardWalkTo(walks[i], vertex.edge(hops[i]).getVertexId(), vertex.numOutEdges() > 0);
			}
		}

		@java.lang.Override
		public int[] getNotTrackedVertices(edu.cmu.graphchi.ChiVertex<java.lang.Integer, java.lang.Float> vertex) {
			int[] notCounted = new int[1 + vertex.numOutEdges()];
			for (int i = 0; i < vertex.numOutEdges(); i++) {
				notCounted[i + 1] = vertex.getOutEdgeId(i);
			}
			notCounted[0] = vertex.getId();
			return notCounted;
		}
	}

	protected class NegativeWalkUpdate extends edu.cmu.graphchi.apps.recommendations.MovieRecommender.PositiveWalkUpdate {
		@java.lang.Override
		public void processWalksAtVertex(edu.cmu.graphchi.walks.WalkArray walkArray, edu.cmu.graphchi.ChiVertex<java.lang.Integer, java.lang.Float> vertex, edu.cmu.graphchi.walks.DrunkardContext drunkardContext_, java.util.Random randomGenerator) {
			int[] walks = ((edu.cmu.graphchi.walks.IntWalkArray) (walkArray)).getArray();
			edu.cmu.graphchi.walks.IntDrunkardContext drunkardContext = ((edu.cmu.graphchi.walks.IntDrunkardContext) (drunkardContext_));
			if ((vertex.numInEdges() > 0) || (drunkardContext.getIteration() > 0)) {
				edu.cmu.graphchi.apps.recommendations.MovieRecommender.PositiveWalkUpdate.hopToHighRatings(walks, vertex, drunkardContext, randomGenerator);
			} else {
				java.util.ArrayList<java.lang.Integer> forwardToPositive = new java.util.ArrayList<java.lang.Integer>();
				for (int w : walks) {
					if (!drunkardContext.isWalkStartedFromVertex(w)) {
						forwardToPositive.add(w);
					}
				}
				if (forwardToPositive.size() > 0) {
					int[] fwd = new int[forwardToPositive.size()];
					for (int i = 0; i < fwd.length; i++) {
						fwd[i] = forwardToPositive.get(i);
					}
					edu.cmu.graphchi.apps.recommendations.MovieRecommender.PositiveWalkUpdate.hopToHighRatings(fwd, vertex, drunkardContext, randomGenerator);
				}
				java.util.ArrayList<java.lang.Integer> badlyRated = new java.util.ArrayList<java.lang.Integer>();
				for (int i = 0; i < vertex.numOutEdges(); i++) {
					if (vertex.getOutEdgeValue(i) < 2) {
						badlyRated.add(vertex.getOutEdgeId(i));
					}
				}
				if (badlyRated.size() == 0) {
					edu.cmu.graphchi.apps.recommendations.MovieRecommender.logger.info("No badly rated movies for user " + drunkardContext.getVertexIdTranslate().backward(vertex.getId()));
					return;
				}
				for (int w : walks) {
					if (drunkardContext.isWalkStartedFromVertex(w)) {
						int randomBadRating = badlyRated.get(randomGenerator.nextInt(badlyRated.size()));
						drunkardContext.forwardWalkTo(w, randomBadRating, true);
						if (vertex.getId() == 0) {
							for (int i = 0; i < vertex.numOutEdges(); i++) {
								if (vertex.getOutEdgeId(i) == randomBadRating) {
									java.lang.System.out.println((("BAD ====> " + randomBadRating) + "; ") + vertex.getOutEdgeValue(i));
								}
							}
						}
					}
				}
			}
		}
	}

	public static void main(java.lang.String[] args) {
		org.apache.commons.cli.Options cmdLineOptions = new org.apache.commons.cli.Options();
		cmdLineOptions.addOption("g", "graph", true, "graph file name");
		cmdLineOptions.addOption("n", "nshards", true, "number of shards");
		cmdLineOptions.addOption("d", "als_dimension", true, "ALS dimensionality (default 20)");
		try {
			org.apache.commons.cli.CommandLineParser parser = new org.apache.commons.cli.PosixParser();
			org.apache.commons.cli.CommandLine cmdLine = parser.parse(cmdLineOptions, args);
			java.lang.String baseFilename = cmdLine.getOptionValue("graph");
			int nShards = java.lang.Integer.parseInt(cmdLine.getOptionValue("nshards"));
			int D = java.lang.Integer.parseInt(cmdLine.hasOption("als_dimension") ? cmdLine.getOptionValue("als_dimension") : "5");
			edu.cmu.graphchi.apps.recommendations.MovieRecommender recommender = new edu.cmu.graphchi.apps.recommendations.MovieRecommender(baseFilename, nShards, D);
			recommender.execute();
		} catch (java.lang.Exception err) {
			err.printStackTrace();
			org.apache.commons.cli.HelpFormatter formatter = new org.apache.commons.cli.HelpFormatter();
			formatter.printHelp("MovieRecommender", cmdLineOptions);
		}
	}
}