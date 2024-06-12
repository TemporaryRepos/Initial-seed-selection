public class GuassLegendre {
	public static void main(java.lang.String[] args) {
		for (int i = 1; i <= 3; ++i) {
			java.lang.System.out.println(com.thealgorithms.others.GuassLegendre.pi(i));
		}
	}

	static double pi(int l) {
		double a = 1;
		double b = java.lang.Math.pow(2, -0.5);
		double t = 0.25;
		double p = 1;
		for (int i = 0; i < l; ++i) {
			double[] temp = com.thealgorithms.others.GuassLegendre.update(a, b, t, p);
			a = temp[0];
			b = temp[1];
			t = temp[2];
			p = temp[3];
		}
		return java.lang.Math.pow(a + b, 2) / (4 * t);
	}

	static double[] update(double a, double b, double t, double p) {
		double[] values = new double[4];
		values[0] = (a + b) / 2;
		values[1] = java.lang.Math.sqrt(a * b);
		values[2] = t - (p * java.lang.Math.pow(a - values[0], 2));
		values[3] = 2 * p;
		return values;
	}
}