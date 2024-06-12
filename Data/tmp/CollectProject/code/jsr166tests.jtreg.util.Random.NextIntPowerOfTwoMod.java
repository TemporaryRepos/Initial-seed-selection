public class NextIntPowerOfTwoMod {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Random r = new java.util.Random(69);
		int total = 0;
		for (int i = 0; i < 1000; i++) {
			total += r.nextInt(16);
		}
		if (total != 7639) {
			throw new java.lang.RuntimeException("Not using correct algorithm.");
		}
	}
}