public class CompareToTests {
	private static int compareToTests() {
		int failures = 0;
		final java.math.BigDecimal MINUS_ONE = java.math.BigDecimal.ONE.negate();
		java.math.BigDecimal[][] testCases = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(0), java.math.BigDecimal.valueOf(0), java.math.BigDecimal.ZERO }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(0), java.math.BigDecimal.valueOf(1), MINUS_ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1), java.math.BigDecimal.valueOf(2), MINUS_ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(2), java.math.BigDecimal.valueOf(1), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(10), java.math.BigDecimal.valueOf(10), java.math.BigDecimal.ZERO }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(2, 1), java.math.BigDecimal.valueOf(2), MINUS_ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(2, -1), java.math.BigDecimal.valueOf(2), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, 1), java.math.BigDecimal.valueOf(2), MINUS_ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, -1), java.math.BigDecimal.valueOf(2), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(5, -1), java.math.BigDecimal.valueOf(2), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), java.math.BigDecimal.ZERO }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE).negate(), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), MINUS_ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE - 1), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), MINUS_ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE - 1).negate(), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), MINUS_ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), MINUS_ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE).negate(), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE + 1), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), MINUS_ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE + 1).negate(), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), java.math.BigDecimal.ZERO }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE).negate(), java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE - 1), java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE - 1).negate(), java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), java.math.BigDecimal.ZERO }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE).negate(), java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE + 1), java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), java.math.BigDecimal.ONE }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE + 1).negate(), java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), java.math.BigDecimal.ONE } };
		for (java.math.BigDecimal[] testCase : testCases) {
			java.math.BigDecimal a = testCase[0];
			java.math.BigDecimal a_negate = a.negate();
			java.math.BigDecimal b = testCase[1];
			java.math.BigDecimal b_negate = b.negate();
			int expected = testCase[2].intValue();
			failures += javaT.math.BigDecimal.CompareToTests.compareToTest(a, b, expected);
			failures += javaT.math.BigDecimal.CompareToTests.compareToTest(a_negate, b_negate, -expected);
		}
		return failures;
	}

	private static int compareToTest(java.math.BigDecimal a, java.math.BigDecimal b, int expected) {
		int result = a.compareTo(b);
		int failed = (result == expected) ? 0 : 1;
		if (failed == 1) {
			java.lang.System.err.println((((((("(" + a) + ").compareTo(") + b) + ") => ") + result) + "\n\tExpected ") + expected);
		}
		return failed;
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		failures += javaT.math.BigDecimal.CompareToTests.compareToTests();
		if (failures > 0) {
			throw new java.lang.RuntimeException(("Incurred " + failures) + " failures while testing exact compareTo.");
		}
	}
}