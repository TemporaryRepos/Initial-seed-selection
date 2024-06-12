public class Pow {
	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.maths.Pow.pow(2, 0) == java.lang.Math.pow(2, 0);
		assert com.thealgorithms.maths.Pow.pow(0, 2) == java.lang.Math.pow(0, 2);
		assert com.thealgorithms.maths.Pow.pow(2, 10) == java.lang.Math.pow(2, 10);
		assert com.thealgorithms.maths.Pow.pow(10, 2) == java.lang.Math.pow(10, 2);
	}

	public static long pow(int a, int b) {
		long result = 1;
		for (int i = 1; i <= b; i++) {
			result *= a;
		}
		return result;
	}
}