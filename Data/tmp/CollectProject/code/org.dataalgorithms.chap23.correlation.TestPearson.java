public class TestPearson {
	public static void main(java.lang.String[] args) {
		org.dataalgorithms.chap23.correlation.TestPearson.test0(args);
		org.dataalgorithms.chap23.correlation.TestPearson.test1(args);
		org.dataalgorithms.chap23.correlation.TestPearson.test2(args);
	}

	public static void test0(java.lang.String[] args) {
		java.util.List<java.lang.Double> X = java.util.Arrays.asList(2.0, 4.0, 45.0, 6.0, 7.0);
		java.util.List<java.lang.Double> Y = java.util.Arrays.asList(23.0, 5.0, 54.0, 6.0, 7.0);
		double n = X.size();
		double corr = org.dataalgorithms.chap23.correlation.Pearson.getCorrelation(X, Y);
		double pvalue = org.dataalgorithms.chap23.correlation.Pearson.getPvalue(corr, n);
		java.lang.System.out.println("corr   = " + corr);
		java.lang.System.out.println("pvalue = " + pvalue);
		java.util.List<java.lang.Double> X2 = java.util.Arrays.asList(12.0, 14.0, 45.0, 6.0, 17.0);
		java.util.List<java.lang.Double> Y2 = java.util.Arrays.asList(3.0, 5.0, 15.0, 16.0, 17.0);
		double n2 = X2.size();
		double corr2 = org.dataalgorithms.chap23.correlation.Pearson.getCorrelation(X2, Y2);
		double pvalue2 = org.dataalgorithms.chap23.correlation.Pearson.getPvalue(corr2, n2);
		java.lang.System.out.println("corr2   = " + corr2);
		java.lang.System.out.println("pvalue2 = " + pvalue2);
	}

	public static void test1(java.lang.String[] args) {
		java.util.List<java.lang.Double> X = java.util.Arrays.asList(2.0, 4.0, 45.0, 6.0, 7.0);
		java.util.List<java.lang.Double> Y = java.util.Arrays.asList(23.0, 5.0, 54.0, 6.0, 7.0);
		double n = 5.0;
		double corr = org.dataalgorithms.chap23.correlation.Pearson.getCorrelation(X, Y);
		double pvalue = org.dataalgorithms.chap23.correlation.Pearson.getPvalue(corr, n);
		java.lang.System.out.println("corr   = " + corr);
		java.lang.System.out.println("pvalue = " + pvalue);
	}

	public static void test2(java.lang.String[] args) {
		java.util.List<java.lang.Double> X = java.util.Arrays.asList(-2.23582587121604, -1.85296859915777, -1.2984667458879, 4.33400363124673, 1.12600971492544, -1.05543924472576, 1.28728316963258);
		java.util.List<java.lang.Double> Y = java.util.Arrays.asList(-7.52686462600734, -8.30573303914744, 5.51558960484512, -10.1470117322862, -8.7196434139086, -23.5494328102242, -9.32157436441666);
		double n = 7.0;
		double corr = org.dataalgorithms.chap23.correlation.Pearson.getCorrelation(X, Y);
		double pvalue = org.dataalgorithms.chap23.correlation.Pearson.getPvalue(corr, n);
		java.lang.System.out.println("corr   = " + corr);
		java.lang.System.out.println("pvalue = " + pvalue);
	}

	public static double[] toDoubleArray(java.util.List<java.lang.Double> list) {
		double[] arr = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
}