public class TestRound {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 10000; i++) {
			java.lang.Math.round(java.lang.Double.NaN);
		}
		if (java.lang.Math.round(1.0) != 1) {
			throw new java.lang.AssertionError("TEST FAILED");
		}
		java.lang.System.out.println("Test passed.");
	}
}