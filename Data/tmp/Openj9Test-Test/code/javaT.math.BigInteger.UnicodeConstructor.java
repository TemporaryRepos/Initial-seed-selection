public class UnicodeConstructor {
	public static void main(java.lang.String[] args) {
		try {
			java.math.BigInteger b1 = new java.math.BigInteger("０");
			java.lang.System.err.println(b1.toString());
			java.math.BigInteger b2 = new java.math.BigInteger("１０１０");
			java.lang.System.err.println(b2.toString());
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			throw new java.lang.RuntimeException("BigInteger is not accepting unicode initializers.");
		}
	}
}