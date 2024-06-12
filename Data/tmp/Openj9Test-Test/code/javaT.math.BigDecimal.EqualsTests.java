public class EqualsTests {
	public static void main(java.lang.String[] argv) {
		int failures = 0;
		java.math.BigDecimal[][] testValues = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ java.math.BigDecimal.ZERO, java.math.BigDecimal.ZERO }, new java.math.BigDecimal[]{ java.math.BigDecimal.ONE, java.math.BigDecimal.TEN }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Integer.MAX_VALUE), java.math.BigDecimal.valueOf(java.lang.Integer.MAX_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE), java.math.BigDecimal.valueOf(-java.lang.Long.MAX_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(12345678), java.math.BigDecimal.valueOf(12345678) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(123456789), java.math.BigDecimal.valueOf(123456788) }, new java.math.BigDecimal[]{ new java.math.BigDecimal("123456789123456789123"), new java.math.BigDecimal(new java.math.BigInteger("123456789123456789123")) }, new java.math.BigDecimal[]{ new java.math.BigDecimal("123456789123456789123"), new java.math.BigDecimal(new java.math.BigInteger("123456789123456789124")) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Long.MIN_VALUE), new java.math.BigDecimal("-9223372036854775808") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("9223372036854775808"), java.math.BigDecimal.valueOf(java.lang.Long.MAX_VALUE) }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(java.lang.Math.round(java.lang.Math.pow(2, 10))), new java.math.BigDecimal("1024") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("1020"), java.math.BigDecimal.valueOf(java.lang.Math.pow(2, 11)) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(java.math.BigInteger.valueOf(2).pow(65)), new java.math.BigDecimal("36893488147419103232") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("36893488147419103231.81"), new java.math.BigDecimal("36893488147419103231.811") } };
		boolean expected = java.lang.Boolean.TRUE;
		for (java.math.BigDecimal[] testValuePair : testValues) {
			failures += javaT.math.BigDecimal.EqualsTests.equalsTest(testValuePair[0], testValuePair[1], expected);
			expected = !expected;
		}
		if (failures > 0) {
			throw new java.lang.RuntimeException(("Inccured " + failures) + " failures while testing equals.");
		}
	}

	private static int equalsTest(java.math.BigDecimal l, java.math.BigDecimal r, boolean expected) {
		boolean result = l.equals(r);
		int failed = (result == expected) ? 0 : 1;
		if (failed == 1) {
			java.lang.System.err.println((((((l + " .equals(") + r) + ") => ") + result) + "\n\tExpected ") + expected);
		}
		return failed;
	}
}