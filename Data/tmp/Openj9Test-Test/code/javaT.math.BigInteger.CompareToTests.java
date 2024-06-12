public class CompareToTests {
	private static int compareToTests() {
		int failures = 0;
		final java.math.BigInteger MINUS_ONE = java.math.BigInteger.ONE.negate();
		final java.math.BigInteger TWO_POW_126 = java.math.BigInteger.ONE.shiftLeft(126);
		final java.math.BigInteger TWO_POW_127 = java.math.BigInteger.ONE.shiftLeft(127);
		final java.math.BigInteger TWO_POW_128 = java.math.BigInteger.ONE.shiftLeft(128);
		java.math.BigInteger[][] testCases = new java.math.BigInteger[][]{ new java.math.BigInteger[]{ java.math.BigInteger.valueOf(0), java.math.BigInteger.valueOf(0), java.math.BigInteger.ZERO }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(0), java.math.BigInteger.valueOf(1), MINUS_ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(1), java.math.BigInteger.valueOf(2), MINUS_ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(2), java.math.BigInteger.valueOf(1), java.math.BigInteger.ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(10), java.math.BigInteger.valueOf(10), java.math.BigInteger.ZERO }, new java.math.BigInteger[]{ TWO_POW_127, TWO_POW_127, java.math.BigInteger.ZERO }, new java.math.BigInteger[]{ TWO_POW_127.negate(), TWO_POW_127, MINUS_ONE }, new java.math.BigInteger[]{ TWO_POW_128.or(TWO_POW_126), TWO_POW_128, java.math.BigInteger.ONE }, new java.math.BigInteger[]{ TWO_POW_128.or(TWO_POW_126), TWO_POW_128.negate(), java.math.BigInteger.ONE }, new java.math.BigInteger[]{ TWO_POW_128, TWO_POW_128.or(TWO_POW_126), MINUS_ONE }, new java.math.BigInteger[]{ TWO_POW_128.negate(), TWO_POW_128.or(TWO_POW_126), MINUS_ONE }, new java.math.BigInteger[]{ TWO_POW_127, TWO_POW_128, MINUS_ONE }, new java.math.BigInteger[]{ TWO_POW_127.negate(), TWO_POW_128, MINUS_ONE }, new java.math.BigInteger[]{ TWO_POW_128, TWO_POW_127, java.math.BigInteger.ONE }, new java.math.BigInteger[]{ TWO_POW_128.negate(), TWO_POW_127, MINUS_ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), java.math.BigInteger.ZERO }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE).negate(), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), MINUS_ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE - 1), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), MINUS_ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE - 1).negate(), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), MINUS_ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), MINUS_ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE).negate(), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), java.math.BigInteger.ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE + 1), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), MINUS_ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE + 1).negate(), java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), java.math.BigInteger.ZERO }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE), java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE).negate(), java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE - 1), java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MAX_VALUE - 1).negate(), java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.ZERO }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE).negate(), java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE + 1), java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.ONE }, new java.math.BigInteger[]{ java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE + 1).negate(), java.math.BigInteger.valueOf(java.lang.Long.MIN_VALUE), java.math.BigInteger.ONE } };
		for (java.math.BigInteger[] testCase : testCases) {
			java.math.BigInteger a = testCase[0];
			java.math.BigInteger a_negate = a.negate();
			java.math.BigInteger b = testCase[1];
			java.math.BigInteger b_negate = b.negate();
			int expected = testCase[2].intValue();
			failures += javaT.math.BigInteger.CompareToTests.compareToTest(a, b, expected);
			failures += javaT.math.BigInteger.CompareToTests.compareToTest(a_negate, b_negate, -expected);
		}
		return failures;
	}

	private static int compareToTest(java.math.BigInteger a, java.math.BigInteger b, int expected) {
		int result = a.compareTo(b);
		int failed = (result == expected) ? 0 : 1;
		if (failed == 1) {
			java.lang.System.err.println((((((("(" + a) + ").compareTo(") + b) + ") => ") + result) + "\n\tExpected ") + expected);
		}
		return failed;
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		failures += javaT.math.BigInteger.CompareToTests.compareToTests();
		if (failures > 0) {
			throw new java.lang.RuntimeException(("Incurred " + failures) + " failures while testing exact compareTo.");
		}
	}
}