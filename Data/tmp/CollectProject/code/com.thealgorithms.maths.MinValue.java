public class MinValue {
	public static void main(java.lang.String[] args) {
		java.util.Random rand = new java.util.Random();
		for (int i = 1; i <= 100; ++i) {
			int a = rand.nextInt(100) - 50;
			int b = rand.nextInt(100) - 50;
			assert com.thealgorithms.maths.MinValue.min(a, b) == java.lang.Math.min(a, b);
		}
	}

	public static int min(int a, int b) {
		return a <= b ? a : b;
	}
}