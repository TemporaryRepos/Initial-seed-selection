public class TestSpearman {
	public static void main(java.lang.String[] args) {
		org.dataalgorithms.chap23.correlation.TestSpearman.test0(args);
		org.dataalgorithms.chap23.correlation.TestSpearman.test1(args);
		org.dataalgorithms.chap23.correlation.TestSpearman.test2(args);
	}

	public static void test0(java.lang.String[] args) {
		java.util.List<java.lang.Double> X = java.util.Arrays.asList(2.0, 4.0, 45.0, 6.0, 7.0);
		java.util.List<java.lang.Double> Y = java.util.Arrays.asList(23.0, 5.0, 54.0, 6.0, 7.0);
		double n = X.size();
		double corr = org.dataalgorithms.chap23.correlation.Spearman.getCorrelation(X, Y);
		double pvalue = org.dataalgorithms.chap23.correlation.Spearman.getPvalue(corr, n);
		java.lang.System.out.println("corr   = " + corr);
		java.lang.System.out.println("pvalue = " + pvalue);
		java.util.List<java.lang.Double> X2 = java.util.Arrays.asList(12.0, 14.0, 45.0, 6.0, 17.0);
		java.util.List<java.lang.Double> Y2 = java.util.Arrays.asList(3.0, 5.0, 15.0, 16.0, 17.0);
		double n2 = X2.size();
		double corr2 = org.dataalgorithms.chap23.correlation.Spearman.getCorrelation(X2, Y2);
		double pvalue2 = org.dataalgorithms.chap23.correlation.Spearman.getPvalue(corr2, n2);
		java.lang.System.out.println("corr2   = " + corr2);
		java.lang.System.out.println("pvalue2 = " + pvalue2);
	}

	public static void test1(java.lang.String[] args) {
		java.util.List<java.lang.Double> X = java.util.Arrays.asList(2.0, 4.0, 45.0, 6.0, 7.0);
		java.util.List<java.lang.Double> Y = java.util.Arrays.asList(23.0, 5.0, 54.0, 6.0, 7.0);
		double n = 5.0;
		double corr = org.dataalgorithms.chap23.correlation.Spearman.getCorrelation(X, Y);
		double pvalue = org.dataalgorithms.chap23.correlation.Spearman.getPvalue(corr, n);
		java.lang.System.out.println("corr   = " + corr);
		java.lang.System.out.println("pvalue = " + pvalue);
	}

	public static void test2(java.lang.String[] args) {
		java.util.List<java.lang.Double> X = java.util.Arrays.asList(-2.23582587121604, -1.85296859915777, -1.2984667458879, 4.33400363124673, 1.12600971492544, -1.05543924472576, 1.28728316963258);
		java.util.List<java.lang.Double> Y = java.util.Arrays.asList(1.0, 1.0, 1.0, 1.0, -1.0, -1.0, 1.0);
		double n = 7.0;
		double corr = org.dataalgorithms.chap23.correlation.Spearman.getCorrelation(X, Y);
		double pvalue = org.dataalgorithms.chap23.correlation.Spearman.getPvalue(corr, n);
		java.lang.System.out.println("corr   = " + corr);
		java.lang.System.out.println("pvalue = " + pvalue);
	}
}