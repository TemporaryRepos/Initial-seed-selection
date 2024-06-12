public class TestMultiplyToLenReturnProfile {
	static java.math.BigInteger m(java.math.BigInteger i1, java.math.BigInteger i2) {
		java.math.BigInteger res = java.math.BigInteger.valueOf(0);
		for (int i = 0; i < 100; i++) {
			res.add(i1.multiply(i2));
		}
		return res;
	}

	public static void main(java.lang.String[] args) {
		java.math.BigInteger v = java.math.BigInteger.valueOf(java.lang.Integer.MAX_VALUE).pow(2);
		for (int i = 0; i < 20000; i++) {
			compiler.intrinsics.bigInteger.TestMultiplyToLenReturnProfile.m(v, v.add(java.math.BigInteger.valueOf(1)));
		}
	}
}