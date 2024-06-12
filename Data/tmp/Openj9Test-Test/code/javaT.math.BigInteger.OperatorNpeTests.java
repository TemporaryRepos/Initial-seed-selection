public class OperatorNpeTests {
	public static void main(java.lang.String... argv) {
		java.math.BigInteger[] specialValues = new java.math.BigInteger[]{ java.math.BigInteger.ZERO, java.math.BigInteger.ONE, java.math.BigInteger.TEN };
		for (java.math.BigInteger bd : specialValues) {
			java.math.BigInteger result;
			try {
				result = bd.multiply(null);
				throw new java.lang.RuntimeException("Instead of NPE got " + result);
			} catch (java.lang.NullPointerException npe) {
			}
			try {
				result = bd.divide(null);
				throw new java.lang.RuntimeException("Instead of NPE got " + result);
			} catch (java.lang.NullPointerException npe) {
			}
			try {
				result = bd.add(null);
				throw new java.lang.RuntimeException("Instead of NPE got " + result);
			} catch (java.lang.NullPointerException npe) {
			}
			try {
				result = bd.subtract(null);
				throw new java.lang.RuntimeException("Instead of NPE got " + result);
			} catch (java.lang.NullPointerException npe) {
			}
		}
	}
}