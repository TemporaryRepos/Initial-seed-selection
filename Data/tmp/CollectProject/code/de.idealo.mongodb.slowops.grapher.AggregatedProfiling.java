public class AggregatedProfiling {
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(de.idealo.mongodb.slowops.grapher.Grapher.class);

	private de.idealo.mongodb.slowops.grapher.AggregatedProfilingId _id;

	private int count;

	private long millis;

	private double avgMs;

	private double minMs;

	private double maxMs;

	private double stdDevMs;

	private double nRet;

	private double avgRet;

	private double minRet;

	private double maxRet;

	private double stdDevRet;

	private double len;

	private double avgLen;

	private double minLen;

	private double maxLen;

	private double stdDevLen;

	private java.util.Date firstts;

	private long keys;

	private long docs;

	private long del;

	private long ins;

	private long mod;

	private java.util.HashSet<java.lang.Boolean> sortstages;

	private AggregatedProfiling() {
	}

	public de.idealo.mongodb.slowops.grapher.AggregatedProfilingId getId() {
		return _id;
	}

	public int getCount() {
		return count;
	}

	public long getMillis() {
		return millis;
	}

	public double getAvgMs() {
		return avgMs;
	}

	public double getMinMs() {
		return minMs;
	}

	public double getMaxMs() {
		return maxMs;
	}

	public double getStdDevMs() {
		return stdDevMs;
	}

	public double getNRet() {
		return nRet;
	}

	public double getAvgRet() {
		return avgRet;
	}

	public double getMinRet() {
		return minRet;
	}

	public double getMaxRet() {
		return maxRet;
	}

	public double getStdDevRet() {
		return stdDevRet;
	}

	public double getLen() {
		return len;
	}

	public double getAvgLen() {
		return avgLen;
	}

	public double getMinLen() {
		return minLen;
	}

	public double getMaxLen() {
		return maxLen;
	}

	public double getStdDevLen() {
		return stdDevLen;
	}

	public java.util.Date getFirstts() {
		return firstts;
	}

	public long getKeys() {
		return keys;
	}

	public long getDocs() {
		return docs;
	}

	public boolean hasSortStage() {
		return sortstages.contains(java.lang.Boolean.TRUE);
	}

	public long getDel() {
		return del;
	}

	public long getIns() {
		return ins;
	}

	public long getMod() {
		return mod;
	}

	public long getDocsWrittenCount() {
		return (del + ins) + mod;
	}

	public java.util.HashSet<java.lang.Boolean> getSortstages() {
		return sortstages;
	}

	public void combine(de.idealo.mongodb.slowops.grapher.AggregatedProfiling entry) {
		if (entry != null) {
			if (entry.getMinMs() < minMs) {
				minMs = entry.getMinMs();
			}
			if (entry.getMaxMs() > maxMs) {
				maxMs = entry.getMaxMs();
			}
			stdDevMs = combineStdDev(new de.idealo.mongodb.slowops.grapher.AggregatedProfiling.Triplet(millis, stdDevMs, count), new de.idealo.mongodb.slowops.grapher.AggregatedProfiling.Triplet(entry.getMillis(), entry.getStdDevMs(), entry.getCount()));
			if (entry.getMinRet() < minRet) {
				minRet = entry.getMinRet();
			}
			if (entry.getMaxRet() > maxRet) {
				maxRet = entry.getMaxRet();
			}
			stdDevRet = combineStdDev(new de.idealo.mongodb.slowops.grapher.AggregatedProfiling.Triplet(nRet, stdDevRet, count), new de.idealo.mongodb.slowops.grapher.AggregatedProfiling.Triplet(entry.getNRet(), entry.getStdDevRet(), entry.getCount()));
			if (entry.getMinLen() < minLen) {
				minLen = entry.getMinLen();
			}
			if (entry.getMaxLen() > maxLen) {
				maxLen = entry.getMaxLen();
			}
			stdDevLen = combineStdDev(new de.idealo.mongodb.slowops.grapher.AggregatedProfiling.Triplet(len, stdDevLen, count), new de.idealo.mongodb.slowops.grapher.AggregatedProfiling.Triplet(entry.getLen(), entry.getStdDevLen(), entry.getCount()));
			if (entry.getFirstts().before(firstts)) {
				firstts = entry.getFirstts();
			}
			keys += entry.getKeys();
			docs += entry.getDocs();
			del += entry.getDel();
			ins += entry.getIns();
			mod += entry.getMod();
			sortstages.addAll(entry.getSortstages());
			nRet += entry.getNRet();
			len += entry.getLen();
			millis += entry.getMillis();
			count += entry.getCount();
		}
	}

	private double combineStdDev(de.idealo.mongodb.slowops.grapher.AggregatedProfiling.Triplet t1, de.idealo.mongodb.slowops.grapher.AggregatedProfiling.Triplet t2) {
		double bothAvg = (t1.value + t2.value) / (t1.count + t2.count);
		return java.lang.Math.sqrt(((((java.lang.Math.pow(((t1.value / t1.count) + t1.stdDev) - bothAvg, 2.0) * (t1.count / 2.0)) + (java.lang.Math.pow(((t1.value / t1.count) - t1.stdDev) - bothAvg, 2.0) * (t1.count / 2.0))) + (java.lang.Math.pow(((t2.value / t2.count) + t2.stdDev) - bothAvg, 2.0) * (t2.count / 2.0))) + (java.lang.Math.pow(((t2.value / t2.count) - t2.stdDev) - bothAvg, 2.0) * (t2.count / 2.0))) / (t1.count + t2.count));
	}

	@java.lang.Override
	protected de.idealo.mongodb.slowops.grapher.AggregatedProfiling clone() {
		final de.idealo.mongodb.slowops.grapher.AggregatedProfiling result = new de.idealo.mongodb.slowops.grapher.AggregatedProfiling();
		result._id = getId();
		result.count = getCount();
		result.millis = getMillis();
		result.avgMs = getAvgMs();
		result.minMs = getMinMs();
		result.maxMs = getMaxMs();
		result.stdDevMs = getStdDevMs();
		result.nRet = getNRet();
		result.avgRet = getAvgRet();
		result.minRet = getMinRet();
		result.maxRet = getMaxRet();
		result.stdDevRet = getStdDevRet();
		result.len = getLen();
		result.avgLen = getAvgLen();
		result.minLen = getMinLen();
		result.maxLen = getMaxLen();
		result.stdDevLen = getStdDevLen();
		result.firstts = ((java.util.Date) (getFirstts().clone()));
		result.keys = getKeys();
		result.docs = getDocs();
		result.del = getDel();
		result.ins = getIns();
		result.mod = getMod();
		result.sortstages = getSortstages();
		return result;
	}

	private class Triplet {
		final double value;

		final double stdDev;

		final double count;

		public Triplet(double value, double stdDev, double count) {
			this.value = value;
			this.stdDev = stdDev;
			this.count = count;
		}
	}

	public static void main(java.lang.String[] args) {
		int[][] samples = new int[][]{ new int[]{ 2, 4, 4, 4, 5, 5, 7, 9 }, new int[]{ 20, 40, 40, 40, 50, 50, 70, 90 }, new int[]{ 2, 4, 4, 4, 5, 5, 7, 9, 20, 40, 40, 40, 50, 50, 70, 90 } };
		int[] sum = new int[]{ 0, 0, 0 };
		int[] avg = new int[]{ 0, 0, 0 };
		for (int s = 0; s < sum.length; s++) {
			for (int i = 0; i < samples[s].length; i++) {
				sum[s] += samples[s][i];
			}
			java.lang.System.out.println((("sum[" + s) + "]=") + sum[s]);
			avg[s] += ((double) (sum[s])) / ((double) (samples[s].length));
			java.lang.System.out.println((("avg[" + s) + "]=") + avg[s]);
		}
		int[] sumSig = new int[]{ 0, 0, 0 };
		double[] sigma = new double[]{ 0, 0, 0 };
		for (int s = 0; s < sumSig.length; s++) {
			for (int i = 0; i < samples[s].length; i++) {
				sumSig[s] += java.lang.Math.pow(samples[s][i] - avg[s], 2.0);
			}
			java.lang.System.out.println((("sumSig[" + s) + "]=") + sumSig[s]);
			sigma[s] += java.lang.Math.sqrt(((double) (sumSig[s])) / ((double) (samples[s].length)));
			java.lang.System.out.println((("Sigma[" + s) + "]=") + sigma[s]);
		}
		double sample1Odd = ((samples[0].length % 2) == 0) ? 0 : java.lang.Math.pow(avg[0] - avg[2], 2.0);
		double sample2Odd = ((samples[1].length % 2) == 0) ? 0 : java.lang.Math.pow(avg[1] - avg[2], 2.0);
		double sample1Len = ((samples[0].length % 2) == 0) ? samples[0].length / 2.0 : (samples[0].length - 1) / 2.0;
		double sample2Len = ((samples[1].length % 2) == 0) ? samples[1].length / 2.0 : (samples[1].length - 1) / 2.0;
		double sumBoth = (((((java.lang.Math.pow((avg[0] + sigma[0]) - avg[2], 2.0) * sample1Len) + (java.lang.Math.pow((avg[0] - sigma[0]) - avg[2], 2.0) * sample1Len)) + sample1Odd) + (java.lang.Math.pow((avg[1] + sigma[1]) - avg[2], 2.0) * sample2Len)) + (java.lang.Math.pow((avg[1] - sigma[1]) - avg[2], 2.0) * sample2Len)) + sample2Odd;
		java.lang.System.out.println("SumBoth=" + sumBoth);
		double sigmaBoth = java.lang.Math.sqrt(sumBoth / samples[2].length);
		java.lang.System.out.println("foo: " + sample1Odd);
		java.lang.System.out.println("bar: " + sample2Odd);
		java.lang.System.out.println("Sigma both samples=" + sigmaBoth);
		if ((sigmaBoth - sigma[2]) == 0) {
			java.lang.System.out.println("Combined stdev of both samples are equal to stddev of merged samples.");
		} else {
			java.lang.System.out.println("Combined stddev of both samples are not equal to stddev of merged samples, but should. Diff: " + (sigmaBoth - sigma[2]));
		}
	}
}