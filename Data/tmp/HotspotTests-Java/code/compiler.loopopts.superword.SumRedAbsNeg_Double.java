public class SumRedAbsNeg_Double {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		double[] a = new double[256 * 1024];
		double[] b = new double[256 * 1024];
		double[] c = new double[256 * 1024];
		double[] d = new double[256 * 1024];
		compiler.loopopts.superword.SumRedAbsNeg_Double.sumReductionInit(a, b, c);
		double total = 0;
		double valid = 3.6028590866691944E19;
		for (int j = 0; j < 2000; j++) {
			total = compiler.loopopts.superword.SumRedAbsNeg_Double.sumReductionImplement(a, b, c, d, total);
		}
		if (total == valid) {
			java.lang.System.out.println("Success");
		} else {
			java.lang.System.out.println("Invalid sum of elements variable in total: " + total);
			java.lang.System.out.println("Expected value = " + valid);
			throw new java.lang.Exception("Failed");
		}
	}

	public static void sumReductionInit(double[] a, double[] b, double[] c) {
		for (int j = 0; j < 1; j++) {
			for (int i = 0; i < a.length; i++) {
				a[i] = (i * 1) + j;
				b[i] = (i * 1) - j;
				c[i] = i + j;
			}
		}
	}

	public static double sumReductionImplement(double[] a, double[] b, double[] c, double[] d, double total) {
		for (int i = 0; i < a.length; i++) {
			d[i] = (java.lang.Math.abs((-a[i]) * (-b[i])) + java.lang.Math.abs((-a[i]) * (-c[i]))) + java.lang.Math.abs((-b[i]) * (-c[i]));
			total += d[i];
		}
		return total;
	}
}