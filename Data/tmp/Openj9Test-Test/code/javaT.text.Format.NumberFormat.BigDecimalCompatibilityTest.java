public class BigDecimalCompatibilityTest {
	static boolean err = false;

	static final java.lang.String[] input_data = new java.lang.String[]{ "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" };

	static final java.lang.String[] exponents = new java.lang.String[]{ "E-100", "E100", "E-900", "E900", "" };

	static final int[] multipliers = new int[]{ -1, 1, -100, 100, -9999, 9999 };

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Locale loc = java.util.Locale.getDefault();
		java.util.Locale.setDefault(java.util.Locale.US);
		javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.testBigDecimal();
		javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.testBigInteger();
		java.util.Locale.setDefault(loc);
		if (javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.err) {
			throw new java.lang.RuntimeException("Error: Unexpected value");
		}
	}

	private static void testBigDecimal() {
		java.text.DecimalFormat df = new java.text.DecimalFormat();
		df.setParseBigDecimal(true);
		df.setMaximumFractionDigits(java.lang.Integer.MAX_VALUE);
		for (int i = 0; i < javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data.length; i++) {
			for (int j = 0; j < javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data.length; j++) {
				for (int k = 0; k < javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data.length; k++) {
					for (int l = 0; l < javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data.length; l++) {
						for (int m = 0; m < javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.exponents.length; m++) {
							java.lang.String s = ((((javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data[i] + javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data[j]) + '.') + javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data[k]) + javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data[l]) + javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.exponents[m];
							for (int n = 0; n < javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.multipliers.length; n++) {
								javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.test(df, s, javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.multipliers[n]);
								javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.test(df, '-' + s, javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.multipliers[n]);
							}
						}
					}
				}
			}
		}
	}

	private static void testBigInteger() {
		java.text.DecimalFormat df = new java.text.DecimalFormat();
		df.setParseBigDecimal(true);
		df.setMaximumFractionDigits(java.lang.Integer.MAX_VALUE);
		for (int i = 0; i < javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data.length; i++) {
			for (int j = 0; j < javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data.length; j++) {
				java.lang.String s = javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data[i] + javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.input_data[j];
				for (int k = 0; k < javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.multipliers.length; k++) {
					javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.test(df, s, javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.multipliers[k]);
					javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.test(df, '-' + s, javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.multipliers[k]);
				}
			}
		}
	}

	static void test(java.text.DecimalFormat df, java.lang.String s, int multiplier) {
		df.setMultiplier(multiplier);
		java.lang.Number num = null;
		try {
			num = df.parse(s);
		} catch (java.text.ParseException e) {
			javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.err = true;
			java.lang.System.err.println("Failed: Exception occurred: " + e.getMessage());
			return;
		}
		java.math.BigDecimal bd = new java.math.BigDecimal(s);
		try {
			bd = bd.divide(new java.math.BigDecimal(multiplier));
		} catch (java.lang.ArithmeticException e) {
			bd = bd.divide(new java.math.BigDecimal(multiplier), java.math.BigDecimal.ROUND_HALF_EVEN);
		}
		javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.check(num, bd, multiplier);
	}

	static void check(java.lang.Number got, java.math.BigDecimal expected, int multiplier) {
		if (!got.equals(expected)) {
			javaT.text.Format.NumberFormat.BigDecimalCompatibilityTest.err = true;
			java.lang.System.err.println((((("Failed: got:" + got) + ", expected: ") + expected) + ", multiplier=") + multiplier);
		}
	}
}