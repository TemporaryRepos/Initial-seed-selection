public class SumRedAbsNeg_Float {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		float[] a = new float[256 * 1024];
		float[] b = new float[256 * 1024];
		float[] c = new float[256 * 1024];
		float[] d = new float[256 * 1024];
		compiler.loopopts.superword.SumRedAbsNeg_Float.sumReductionInit(a, b, c);
		float total = 0;
		float valid = ((float) (4.611686E18));
		for (int j = 0; j < 2000; j++) {
			total = compiler.loopopts.superword.SumRedAbsNeg_Float.sumReductionImplement(a, b, c, d, total);
		}
		if (total == valid) {
			java.lang.System.out.println("Success");
		} else {
			java.lang.System.out.println("Invalid sum of elements variable in total: " + total);
			java.lang.System.out.println("Expected value = " + valid);
			throw new java.lang.Exception("Failed");
		}
	}

	public static void sumReductionInit(float[] a, float[] b, float[] c) {
		for (int j = 0; j < 1; j++) {
			for (int i = 0; i < a.length; i++) {
				a[i] = (i * 1) + j;
				b[i] = (i * 1) - j;
				c[i] = i + j;
			}
		}
	}

	public static float sumReductionImplement(float[] a, float[] b, float[] c, float[] d, float total) {
		for (int i = 0; i < a.length; i++) {
			d[i] = (java.lang.Math.abs((-a[i]) * (-b[i])) + java.lang.Math.abs((-a[i]) * (-c[i]))) + java.lang.Math.abs((-b[i]) * (-c[i]));
			total += d[i];
		}
		return total;
	}
}