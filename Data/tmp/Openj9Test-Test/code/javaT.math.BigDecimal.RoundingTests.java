public class RoundingTests {
	private static int roundingTests() {
		int failures = 0;
		java.math.BigDecimal bd1 = java.math.BigDecimal.valueOf(11, java.lang.Integer.MIN_VALUE);
		java.math.BigDecimal bd2 = null;
		java.math.MathContext mc = new java.math.MathContext(1);
		try {
			bd2 = bd1.round(mc);
			failures++;
			java.lang.System.err.printf("Did not get expected overflow rounding %s to %d digits, got %s%n", bd1, mc.getPrecision(), bd2);
		} catch (java.lang.ArithmeticException e) {
		}
		return failures;
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		failures += javaT.math.BigDecimal.RoundingTests.roundingTests();
		if (failures > 0) {
			java.lang.System.err.println(("Encountered " + failures) + " failures while testing rounding.");
			throw new java.lang.RuntimeException();
		}
	}
}