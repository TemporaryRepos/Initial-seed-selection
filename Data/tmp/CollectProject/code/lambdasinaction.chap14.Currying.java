public class Currying {
	public static void main(java.lang.String[] args) {
		java.util.function.DoubleUnaryOperator convertCtoF = lambdasinaction.chap14.Currying.curriedConverter(9.0 / 5, 32);
		java.util.function.DoubleUnaryOperator convertUSDtoGBP = lambdasinaction.chap14.Currying.curriedConverter(0.6, 0);
		java.util.function.DoubleUnaryOperator convertKmtoMi = lambdasinaction.chap14.Currying.curriedConverter(0.6214, 0);
		java.lang.System.out.println(convertCtoF.applyAsDouble(24));
		java.lang.System.out.println(convertUSDtoGBP.applyAsDouble(100));
		java.lang.System.out.println(convertKmtoMi.applyAsDouble(20));
		java.util.function.DoubleUnaryOperator convertFtoC = lambdasinaction.chap14.Currying.expandedCurriedConverter(-32, 5.0 / 9, 0);
		java.lang.System.out.println(convertFtoC.applyAsDouble(98.6));
	}

	static double converter(double x, double y, double z) {
		return (x * y) + z;
	}

	static java.util.function.DoubleUnaryOperator curriedConverter(double y, double z) {
		return (double x) -> (x * y) + z;
	}

	static java.util.function.DoubleUnaryOperator expandedCurriedConverter(double w, double y, double z) {
		return (double x) -> ((x + w) * y) + z;
	}
}