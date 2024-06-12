public class PowTests {
	static int zeroAndOneTests() {
		int failures = 0;
		java.math.BigDecimal[][] testCases = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(0, java.lang.Integer.MAX_VALUE), new java.math.BigDecimal(0), java.math.BigDecimal.valueOf(1, 0) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(0, java.lang.Integer.MAX_VALUE), new java.math.BigDecimal(1), java.math.BigDecimal.valueOf(0, java.lang.Integer.MAX_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(0, java.lang.Integer.MAX_VALUE), new java.math.BigDecimal(2), java.math.BigDecimal.valueOf(0, java.lang.Integer.MAX_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(0, java.lang.Integer.MAX_VALUE), new java.math.BigDecimal(999999999), java.math.BigDecimal.valueOf(0, java.lang.Integer.MAX_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(0, java.lang.Integer.MIN_VALUE), new java.math.BigDecimal(0), java.math.BigDecimal.valueOf(1, 0) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(0, java.lang.Integer.MIN_VALUE), new java.math.BigDecimal(1), java.math.BigDecimal.valueOf(0, java.lang.Integer.MIN_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(0, java.lang.Integer.MIN_VALUE), new java.math.BigDecimal(2), java.math.BigDecimal.valueOf(0, java.lang.Integer.MIN_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(0, java.lang.Integer.MIN_VALUE), new java.math.BigDecimal(999999999), java.math.BigDecimal.valueOf(0, java.lang.Integer.MIN_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, java.lang.Integer.MAX_VALUE), new java.math.BigDecimal(0), java.math.BigDecimal.valueOf(1, 0) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, java.lang.Integer.MAX_VALUE), new java.math.BigDecimal(1), java.math.BigDecimal.valueOf(1, java.lang.Integer.MAX_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, java.lang.Integer.MAX_VALUE), new java.math.BigDecimal(2), null }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, java.lang.Integer.MAX_VALUE), new java.math.BigDecimal(999999999), null }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, java.lang.Integer.MIN_VALUE), new java.math.BigDecimal(0), java.math.BigDecimal.valueOf(1, 0) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, java.lang.Integer.MIN_VALUE), new java.math.BigDecimal(1), java.math.BigDecimal.valueOf(1, java.lang.Integer.MIN_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, java.lang.Integer.MIN_VALUE), new java.math.BigDecimal(2), null }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, java.lang.Integer.MIN_VALUE), new java.math.BigDecimal(999999999), null } };
		for (java.math.BigDecimal[] testCase : testCases) {
			int exponent = testCase[1].intValueExact();
			java.math.BigDecimal result;
			try {
				result = testCase[0].pow(exponent);
				if (!result.equals(testCase[2])) {
					failures++;
					java.lang.System.err.println(((((((("Unexpected result while raising " + testCase[0]) + " to the ") + exponent) + " power; expected ") + testCase[2]) + ", got ") + result) + ".");
				}
			} catch (java.lang.ArithmeticException e) {
				if (testCase[2] != null) {
					failures++;
					java.lang.System.err.println(((("Unexpected exception while raising " + testCase[0]) + " to the ") + exponent) + " power.");
				}
			}
		}
		return failures;
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		failures += javaT.math.BigDecimal.PowTests.zeroAndOneTests();
		if (failures > 0) {
			throw new java.lang.RuntimeException(("Incurred " + failures) + " failures while testing pow methods.");
		}
	}
}