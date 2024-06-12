public class ProbablePrime {
	public static void main(java.lang.String[] argv) {
		java.math.BigInteger num = new java.math.BigInteger("4");
		int[] certainties = new int[]{ -1, 0, 1, 2, 100, java.lang.Integer.MAX_VALUE - 1, java.lang.Integer.MAX_VALUE };
		boolean[] expectations = new boolean[]{ true, true, false, false, false, false, false };
		for (int i = 0; i < certainties.length; i++) {
			boolean b;
			if ((b = num.isProbablePrime(certainties[i])) != expectations[i]) {
				throw new java.lang.RuntimeException((("Unexpected answer " + b) + " for certainty ") + certainties[i]);
			}
		}
	}
}