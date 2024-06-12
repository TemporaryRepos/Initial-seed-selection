public class EulerMethod {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("example 1:");
		java.util.function.BiFunction<java.lang.Double, java.lang.Double, java.lang.Double> exampleEquation1 = ( x, y) -> x;
		java.util.ArrayList<double[]> points1 = com.thealgorithms.maths.EulerMethod.eulerFull(0, 4, 0.1, 0, exampleEquation1);
		assert points1.get(points1.size() - 1)[1] == 7.800000000000003;
		points1.forEach(( point) -> java.lang.System.out.printf("x: %1$f; y: %2$f%n", point[0], point[1]));
		java.lang.System.out.println("\n\nexample 2:");
		java.util.function.BiFunction<java.lang.Double, java.lang.Double, java.lang.Double> exampleEquation2 = ( x, y) -> y;
		java.util.ArrayList<double[]> points2 = com.thealgorithms.maths.EulerMethod.eulerFull(0, 4, 0.1, 1, exampleEquation2);
		assert points2.get(points2.size() - 1)[1] == 45.25925556817596;
		points2.forEach(( point) -> java.lang.System.out.printf("x: %1$f; y: %2$f%n", point[0], point[1]));
		java.lang.System.out.println("\n\nexample 3:");
		java.util.function.BiFunction<java.lang.Double, java.lang.Double, java.lang.Double> exampleEquation3 = ( x, y) -> (x + y) + (x * y);
		java.util.ArrayList<double[]> points3 = com.thealgorithms.maths.EulerMethod.eulerFull(0, 0.1, 0.025, 1, exampleEquation3);
		assert points3.get(points3.size() - 1)[1] == 1.1116729841674804;
		points3.forEach(( point) -> java.lang.System.out.printf("x: %1$f; y: %2$f%n", point[0], point[1]));
	}

	public static double eulerStep(double xCurrent, double stepSize, double yCurrent, java.util.function.BiFunction<java.lang.Double, java.lang.Double, java.lang.Double> differentialEquation) {
		if (stepSize <= 0) {
			throw new java.lang.IllegalArgumentException("stepSize should be greater than zero");
		}
		return yCurrent + (stepSize * differentialEquation.apply(xCurrent, yCurrent));
	}

	public static java.util.ArrayList<double[]> eulerFull(double xStart, double xEnd, double stepSize, double yStart, java.util.function.BiFunction<java.lang.Double, java.lang.Double, java.lang.Double> differentialEquation) {
		if (xStart >= xEnd) {
			throw new java.lang.IllegalArgumentException("xEnd should be greater than xStart");
		}
		if (stepSize <= 0) {
			throw new java.lang.IllegalArgumentException("stepSize should be greater than zero");
		}
		java.util.ArrayList<double[]> points = new java.util.ArrayList<double[]>();
		double[] firstPoint = new double[]{ xStart, yStart };
		points.add(firstPoint);
		double yCurrent = yStart;
		double xCurrent = xStart;
		while (xCurrent < xEnd) {
			yCurrent = com.thealgorithms.maths.EulerMethod.eulerStep(xCurrent, stepSize, yCurrent, differentialEquation);
			xCurrent += stepSize;
			double[] point = new double[]{ xCurrent, yCurrent };
			points.add(point);
		} 
		return points;
	}
}