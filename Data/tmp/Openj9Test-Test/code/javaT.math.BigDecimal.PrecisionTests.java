public class PrecisionTests {
	private static java.math.BigDecimal NINE = java.math.BigDecimal.valueOf(9);

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		java.math.BigDecimal[] testValues = new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1), java.math.BigDecimal.valueOf(9) };
		failures += javaT.math.BigDecimal.PrecisionTests.testPrecision(new java.math.BigDecimal(0), 1);
		for (int i = 1; i < 100; i++) {
			for (java.math.BigDecimal bd : testValues) {
				failures += javaT.math.BigDecimal.PrecisionTests.testPrecision(bd, i);
				failures += javaT.math.BigDecimal.PrecisionTests.testPrecision(bd.negate(), i);
			}
			testValues[0] = testValues[0].multiply(java.math.BigDecimal.TEN);
			testValues[1] = testValues[1].multiply(java.math.BigDecimal.TEN).add(javaT.math.BigDecimal.PrecisionTests.NINE);
		}
		java.math.BigDecimal[] randomTestValues = new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(2147483648L), java.math.BigDecimal.valueOf(-2147483648L), java.math.BigDecimal.valueOf(98893745455L), java.math.BigDecimal.valueOf(3455436789887L), java.math.BigDecimal.valueOf(140737488355328L), java.math.BigDecimal.valueOf(-140737488355328L), java.math.BigDecimal.valueOf(7564232235739573L), java.math.BigDecimal.valueOf(25335434990002322L), java.math.BigDecimal.valueOf(9223372036854775807L), java.math.BigDecimal.valueOf(-9223372036854775807L) };
		int[] expectedPrecision = new int[]{ 10, 10, 11, 13, 15, 15, 16, 17, 19, 19 };
		for (int i = 0; i < randomTestValues.length; i++) {
			failures += javaT.math.BigDecimal.PrecisionTests.testPrecision(randomTestValues[i], expectedPrecision[i]);
		}
		if (failures > 0) {
			throw new java.lang.RuntimeException(("Incurred " + failures) + " failures while testing precision.");
		}
	}

	private static int testPrecision(java.math.BigDecimal bd, int expected) {
		int precision = bd.precision();
		if (precision != expected) {
			java.lang.System.err.printf("For (%s).precision expected %d, got %d%n", bd, expected, precision);
			return 1;
		}
		return 0;
	}
}