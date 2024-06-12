public class SimpsonIntegration {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.maths.SimpsonIntegration integration = new com.thealgorithms.maths.SimpsonIntegration();
		int N = 16;
		double a = 1;
		double b = 3;
		if ((N % 2) != 0) {
			java.lang.System.out.println("N must be even number for Simpsons method. Aborted");
			java.lang.System.exit(1);
		}
		double h = (b - a) / ((double) (N));
		double integralEvaluation = integration.simpsonsMethod(N, h, a);
		java.lang.System.out.println("The integral is equal to: " + integralEvaluation);
	}

	public double simpsonsMethod(int N, double h, double a) {
		java.util.TreeMap<java.lang.Integer, java.lang.Double> data = new java.util.TreeMap<>();
		double temp;
		double xi = a;
		for (int i = 0; i <= N; i++) {
			temp = f(xi);
			data.put(i, temp);
			xi += h;
		}
		double integralEvaluation = 0;
		for (int i = 0; i < data.size(); i++) {
			if ((i == 0) || (i == (data.size() - 1))) {
				integralEvaluation += data.get(i);
				java.lang.System.out.println(("Multiply f(x" + i) + ") by 1");
			} else if ((i % 2) == 1) {
				integralEvaluation += ((double) (4)) * data.get(i);
				java.lang.System.out.println(("Multiply f(x" + i) + ") by 4");
			} else {
				integralEvaluation += ((double) (2)) * data.get(i);
				java.lang.System.out.println(("Multiply f(x" + i) + ") by 2");
			}
		}
		integralEvaluation = (h / 3) * integralEvaluation;
		return integralEvaluation;
	}

	public double f(double x) {
		return java.lang.Math.exp(-x) * (4 - java.lang.Math.pow(x, 2));
	}
}