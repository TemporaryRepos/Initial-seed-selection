public static class ModTester {
	public static void main(java.lang.String[] args) {
		java.math.BigInteger two = java.math.BigInteger.valueOf(2);
		java.math.BigInteger four = java.math.BigInteger.valueOf(4);
		two.modPow(two, java.math.BigInteger.valueOf(4));
		two.modPow(two, java.math.BigInteger.valueOf(8));
		two.modPow(four, java.math.BigInteger.valueOf(8));
		java.lang.System.out.println("success");
	}
}