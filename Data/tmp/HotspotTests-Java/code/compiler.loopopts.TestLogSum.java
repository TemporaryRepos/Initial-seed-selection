public class TestLogSum {
	public static void main(java.lang.String[] args) {
		double sum;
		for (int i = 0; i < 6; i++) {
			for (int n = 2; n < 30; n++) {
				for (int j = 1; j <= n; j++) {
					for (int k = 1; k <= j; k++) {
						sum = compiler.loopopts.TestLogSum.computeSum(k, j);
					}
				}
			}
		}
	}

	private static java.util.Map<java.util.List<java.lang.Integer>, java.lang.Double> cache = new java.util.HashMap<java.util.List<java.lang.Integer>, java.lang.Double>();

	public static double computeSum(int x, int y) {
		java.util.List<java.lang.Integer> key = java.util.Arrays.asList(new java.lang.Integer[]{ x, y });
		if (!compiler.loopopts.TestLogSum.cache.containsKey(key)) {
			compiler.loopopts.TestLogSum.LogSumArray toReturn = new compiler.loopopts.TestLogSum.LogSumArray(x);
			for (int z = 1; z < (x + 1); z++) {
				double logSummand = java.lang.Math.log((z + x) + y);
				toReturn.addLogSummand(logSummand);
			}
			compiler.loopopts.TestLogSum.cache.put(key, toReturn.retrieveLogSum());
		}
		return compiler.loopopts.TestLogSum.cache.get(key);
	}

	private static class LogSumArray {
		private double[] logSummandArray;

		private int currSize;

		private double maxLogSummand;

		public LogSumArray(int maxEntries) {
			this.logSummandArray = new double[maxEntries];
			this.currSize = 0;
			this.maxLogSummand = java.lang.Double.NEGATIVE_INFINITY;
		}

		public void addLogSummand(double logSummand) {
			logSummandArray[currSize] = logSummand;
			currSize++;
			maxLogSummand = java.lang.Math.max(maxLogSummand, logSummand);
		}

		public double retrieveLogSum() {
			if (maxLogSummand == java.lang.Double.NEGATIVE_INFINITY) {
				return java.lang.Double.NEGATIVE_INFINITY;
			}
			assert currSize <= logSummandArray.length;
			double factorSum = 0;
			for (int i = 0; i < currSize; i++) {
				factorSum += java.lang.Math.exp(logSummandArray[i] - maxLogSummand);
			}
			return java.lang.Math.log(factorSum) + maxLogSummand;
		}
	}
}