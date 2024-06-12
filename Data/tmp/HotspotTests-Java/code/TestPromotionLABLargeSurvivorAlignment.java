public class TestPromotionLABLargeSurvivorAlignment {
	public static void main(java.lang.String[] args) {
		java.lang.Object[] garbage = new java.lang.Object[1000000];
		for (int i = 0; i < garbage.length; i++) {
			garbage[i] = new byte[0];
		}
		for (int i = 0; i < 2; i++) {
			java.lang.System.gc();
		}
	}
}