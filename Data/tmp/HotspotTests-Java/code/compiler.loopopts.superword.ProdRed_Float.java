public class ProdRed_Float {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		float[] a = new float[256 * 1024];
		float[] b = new float[256 * 1024];
		compiler.loopopts.superword.ProdRed_Float.prodReductionInit(a, b);
		float valid = 2000;
		float total = 0;
		for (int j = 0; j < 2000; j++) {
			total = j + 1;
			total = compiler.loopopts.superword.ProdRed_Float.prodReductionImplement(a, b, total);
		}
		if (total == valid) {
			java.lang.System.out.println("Success");
		} else {
			java.lang.System.out.println("Invalid sum of elements variable in total: " + total);
			java.lang.System.out.println("Expected value = " + valid);
			throw new java.lang.Exception("Failed");
		}
	}

	public static void prodReductionInit(float[] a, float[] b) {
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 2;
			b[i] = i + 1;
		}
	}

	public static float prodReductionImplement(float[] a, float[] b, float total) {
		for (int i = 0; i < a.length; i++) {
			total *= a[i] - b[i];
		}
		return total;
	}
}