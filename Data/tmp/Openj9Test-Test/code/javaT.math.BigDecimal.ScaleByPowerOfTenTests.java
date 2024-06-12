public class ScaleByPowerOfTenTests {
	public static void main(java.lang.String[] argv) {
		for (int i = -10; i < 10; i++) {
			java.math.BigDecimal bd = java.math.BigDecimal.ONE.scaleByPowerOfTen(i);
			java.math.BigDecimal expected;
			if (!bd.equals(expected = new java.math.BigDecimal(java.math.BigInteger.ONE, -i))) {
				throw new java.lang.RuntimeException((("Unexpected result " + bd.toString()) + "; expected ") + expected.toString());
			}
			bd = java.math.BigDecimal.ONE.negate().scaleByPowerOfTen(i);
			if (!bd.equals(expected = new java.math.BigDecimal(java.math.BigInteger.ONE.negate(), -i))) {
				throw new java.lang.RuntimeException((("Unexpected result " + bd.toString()) + "; expected ") + expected.toString());
			}
		}
	}
}