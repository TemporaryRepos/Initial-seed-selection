public class MaxValue {
	public static void main(java.lang.String[] args) {
		java.util.Random rand = new java.util.Random();
		for (int i = 1; i <= 100; ++i) {
			int a = rand.nextInt(100) - 50;
			int b = rand.nextInt(100) - 50;
			assert com.thealgorithms.maths.MaxValue.max(a, b) == java.lang.Math.max(a, b);
		}
	}

	public static int max(int a, int b) {
		return a >= b ? a : b;
	}
}