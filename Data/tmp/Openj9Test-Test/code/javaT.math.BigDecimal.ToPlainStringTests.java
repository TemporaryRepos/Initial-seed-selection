public class ToPlainStringTests {
	public static void main(java.lang.String[] argv) {
		java.lang.String[][] testCases = new java.lang.String[][]{ new java.lang.String[]{ "0", "0" }, new java.lang.String[]{ "1", "1" }, new java.lang.String[]{ "10", "10" }, new java.lang.String[]{ "2e1", "20" }, new java.lang.String[]{ "3e2", "300" }, new java.lang.String[]{ "4e3", "4000" }, new java.lang.String[]{ "5e4", "50000" }, new java.lang.String[]{ "6e5", "600000" }, new java.lang.String[]{ "7e6", "7000000" }, new java.lang.String[]{ "8e7", "80000000" }, new java.lang.String[]{ "9e8", "900000000" }, new java.lang.String[]{ "1e9", "1000000000" }, new java.lang.String[]{ ".0", "0.0" }, new java.lang.String[]{ ".1", "0.1" }, new java.lang.String[]{ ".10", "0.10" }, new java.lang.String[]{ "1e-1", "0.1" }, new java.lang.String[]{ "1e-1", "0.1" }, new java.lang.String[]{ "2e-2", "0.02" }, new java.lang.String[]{ "3e-3", "0.003" }, new java.lang.String[]{ "4e-4", "0.0004" }, new java.lang.String[]{ "5e-5", "0.00005" }, new java.lang.String[]{ "6e-6", "0.000006" }, new java.lang.String[]{ "7e-7", "0.0000007" }, new java.lang.String[]{ "8e-8", "0.00000008" }, new java.lang.String[]{ "9e-9", "0.000000009" }, new java.lang.String[]{ "9000e-12", "0.000000009000" }, new java.lang.String[]{ "9000e-22", "0.0000000000000000009000" }, new java.lang.String[]{ "12345678901234567890", "12345678901234567890" }, new java.lang.String[]{ "12345678901234567890e22", "123456789012345678900000000000000000000000" }, new java.lang.String[]{ "12345678901234567890e-22", "0.0012345678901234567890" } };
		int errors = 0;
		for (java.lang.String[] testCase : testCases) {
			java.math.BigDecimal bd = new java.math.BigDecimal(testCase[0]);
			java.lang.String s;
			if (!(s = bd.toPlainString()).equals(testCase[1])) {
				errors++;
				java.lang.System.err.println((("Unexpected plain result ``" + s) + "'' from BigDecimal ") + bd);
			}
			bd = new java.math.BigDecimal("-" + testCase[0]);
			if ((bd.signum() != 0) && (!(s = bd.toPlainString()).equals("-" + testCase[1]))) {
				errors++;
				java.lang.System.err.println((("Unexpected plain result ``" + s) + "'' from BigDecimal ") + bd);
			}
		}
		if (errors > 0) {
			throw new java.lang.RuntimeException(errors + " errors during run.");
		}
	}
}