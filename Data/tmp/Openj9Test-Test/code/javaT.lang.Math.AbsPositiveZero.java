public class AbsPositiveZero {
	private static boolean isPositiveZero(float f) {
		return java.lang.Float.floatToIntBits(f) == java.lang.Float.floatToIntBits(0.0F);
	}

	private static boolean isPositiveZero(double d) {
		return java.lang.Double.doubleToLongBits(d) == java.lang.Double.doubleToLongBits(0.0);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (!javaT.lang.Math.AbsPositiveZero.isPositiveZero(java.lang.Math.abs(-0.0))) {
			throw new java.lang.Exception("abs(-0.0d) failed");
		}
		if (!javaT.lang.Math.AbsPositiveZero.isPositiveZero(java.lang.Math.abs(+0.0))) {
			throw new java.lang.Exception("abs(+0.0d) failed");
		}
		if (java.lang.Math.abs(java.lang.Double.POSITIVE_INFINITY) != java.lang.Double.POSITIVE_INFINITY) {
			throw new java.lang.Exception("abs(+Inf) failed");
		}
		if (java.lang.Math.abs(java.lang.Double.NEGATIVE_INFINITY) != java.lang.Double.POSITIVE_INFINITY) {
			throw new java.lang.Exception("abs(-Inf) failed");
		}
		double dnanval = java.lang.Math.abs(java.lang.Double.NaN);
		if (dnanval == dnanval) {
			throw new java.lang.Exception("abs(NaN) failed");
		}
		if (!javaT.lang.Math.AbsPositiveZero.isPositiveZero(java.lang.Math.abs(-0.0F))) {
			throw new java.lang.Exception("abs(-0.0f) failed");
		}
		if (!javaT.lang.Math.AbsPositiveZero.isPositiveZero(java.lang.Math.abs(+0.0F))) {
			throw new java.lang.Exception("abs(+0.0f) failed");
		}
		if (java.lang.Math.abs(java.lang.Float.POSITIVE_INFINITY) != java.lang.Float.POSITIVE_INFINITY) {
			throw new java.lang.Exception("abs(+Inf) failed");
		}
		if (java.lang.Math.abs(java.lang.Float.NEGATIVE_INFINITY) != java.lang.Float.POSITIVE_INFINITY) {
			throw new java.lang.Exception("abs(-Inf) failed");
		}
		float fnanval = java.lang.Math.abs(java.lang.Float.NaN);
		if (fnanval == fnanval) {
			throw new java.lang.Exception("abs(NaN) failed");
		}
	}
}