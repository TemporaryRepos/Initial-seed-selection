public class LongValueExactTests {
	private static int longValueExactTests() {
		int failures = 0;
		java.lang.String[] testStrings = new java.lang.String[]{ "9223372036854775807", "9223372036854775807.0", "9223372036854775807.00", "-9223372036854775808", "-9223372036854775808.0", "-9223372036854775808.00" };
		for (java.lang.String longValue : testStrings) {
			try {
				java.math.BigDecimal bd = new java.math.BigDecimal(longValue);
				long longValueExact = bd.longValueExact();
			} catch (java.lang.Exception e) {
				failures++;
			}
		}
		java.lang.String[] testStrings2 = new java.lang.String[]{ "9223372036854775808", "9223372036854775808.0", "9223372036854775808.00", "-9223372036854775809", "-9223372036854775808.1", "-9223372036854775808.01" };
		for (java.lang.String bigValue : testStrings2) {
			try {
				java.math.BigDecimal bd = new java.math.BigDecimal(bigValue);
				long longValueExact = bd.longValueExact();
				failures++;
			} catch (java.lang.ArithmeticException e) {
			}
		}
		return failures;
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		failures += javaT.math.BigDecimal.LongValueExactTests.longValueExactTests();
		if (failures > 0) {
			throw new java.lang.RuntimeException(("Incurred " + failures) + " failures while testing longValueExact.");
		}
	}
}