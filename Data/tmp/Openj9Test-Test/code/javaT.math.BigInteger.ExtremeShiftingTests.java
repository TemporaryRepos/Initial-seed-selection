public class ExtremeShiftingTests {
	public static void main(java.lang.String... args) {
		java.math.BigInteger bi = java.math.BigInteger.ONE.shiftLeft(java.lang.Integer.MIN_VALUE);
		if (!bi.equals(java.math.BigInteger.ZERO)) {
			throw new java.lang.RuntimeException("1 << " + java.lang.Integer.MIN_VALUE);
		}
		bi = java.math.BigInteger.ZERO.shiftLeft(java.lang.Integer.MIN_VALUE);
		if (!bi.equals(java.math.BigInteger.ZERO)) {
			throw new java.lang.RuntimeException("0 << " + java.lang.Integer.MIN_VALUE);
		}
		bi = java.math.BigInteger.valueOf(-1);
		bi = bi.shiftLeft(java.lang.Integer.MIN_VALUE);
		if (!bi.equals(java.math.BigInteger.valueOf(-1))) {
			throw new java.lang.RuntimeException("-1 << " + java.lang.Integer.MIN_VALUE);
		}
		try {
			java.math.BigInteger.ONE.shiftRight(java.lang.Integer.MIN_VALUE);
			throw new java.lang.RuntimeException("1 >> " + java.lang.Integer.MIN_VALUE);
		} catch (java.lang.ArithmeticException ae) {
		}
		bi = java.math.BigInteger.ZERO.shiftRight(java.lang.Integer.MIN_VALUE);
		if (!bi.equals(java.math.BigInteger.ZERO)) {
			throw new java.lang.RuntimeException("0 >> " + java.lang.Integer.MIN_VALUE);
		}
		try {
			java.math.BigInteger.valueOf(-1).shiftRight(java.lang.Integer.MIN_VALUE);
			throw new java.lang.RuntimeException("-1 >> " + java.lang.Integer.MIN_VALUE);
		} catch (java.lang.ArithmeticException ae) {
		}
	}
}