public class MultiplyTests {
	private static int multiplyTests() {
		int failures = 0;
		java.math.BigDecimal[] bd1 = new java.math.BigDecimal[]{ new java.math.BigDecimal("123456789"), new java.math.BigDecimal("1234567898"), new java.math.BigDecimal("12345678987") };
		java.math.BigDecimal[] bd2 = new java.math.BigDecimal[]{ new java.math.BigDecimal("987654321"), new java.math.BigDecimal("8987654321"), new java.math.BigDecimal("78987654321") };
		java.math.BigDecimal[][] expectedResults = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal("121932631112635269"), new java.math.BigDecimal("1109586943112635269"), new java.math.BigDecimal("9751562173112635269") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("1219326319027587258"), new java.math.BigDecimal("11095869503027587258"), new java.math.BigDecimal("97515622363027587258") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("12193263197189452827"), new java.math.BigDecimal("110958695093189452827"), new java.math.BigDecimal("975156224183189452827") } };
		for (int i = 0; i < bd1.length; i++) {
			for (int j = 0; j < bd2.length; j++) {
				if (!bd1[i].multiply(bd2[j]).equals(expectedResults[i][j])) {
					failures++;
				}
			}
		}
		java.math.BigDecimal x = java.math.BigDecimal.valueOf(8L, 1);
		java.math.BigDecimal xPower = java.math.BigDecimal.valueOf(-1L);
		try {
			for (int i = 0; i < 100; i++) {
				xPower = xPower.multiply(x);
			}
		} catch (java.lang.Exception ex) {
			failures++;
		}
		return failures;
	}

	public static void main(java.lang.String[] args) {
		int failures = 0;
		failures += javaT.math.BigDecimal.MultiplyTests.multiplyTests();
		if (failures > 0) {
			throw new java.lang.RuntimeException(("Incurred " + failures) + " failures while testing multiply.");
		}
	}
}