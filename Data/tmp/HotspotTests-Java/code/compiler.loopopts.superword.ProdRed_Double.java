public class ProdRed_Double {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		double[] a = new double[256 * 1024];
		double[] b = new double[256 * 1024];
		compiler.loopopts.superword.ProdRed_Double.prodReductionInit(a, b);
		double valid = 2000;
		double total = 0;
		for (int j = 0; j < 2000; j++) {
			total = j + 1;
			total = compiler.loopopts.superword.ProdRed_Double.prodReductionImplement(a, b, total);
		}
		if (total == valid) {
			java.lang.System.out.println("Success");
		} else {
			java.lang.System.out.println("Invalid sum of elements variable in total: " + total);
			java.lang.System.out.println("Expected value = " + valid);
			throw new java.lang.Exception("Failed");
		}
	}

	public static void prodReductionInit(double[] a, double[] b) {
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 2;
			b[i] = i + 1;
		}
	}

	public static double prodReductionImplement(double[] a, double[] b, double total) {
		for (int i = 0; i < a.length; i++) {
			total *= a[i] - b[i];
		}
		return total;
	}
}