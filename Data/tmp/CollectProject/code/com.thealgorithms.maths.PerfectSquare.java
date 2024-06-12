public class PerfectSquare {
	public static void main(java.lang.String[] args) {
		assert !com.thealgorithms.maths.PerfectSquare.isPerfectSquare(-1);
		assert !com.thealgorithms.maths.PerfectSquare.isPerfectSquare(3);
		assert !com.thealgorithms.maths.PerfectSquare.isPerfectSquare(5);
		assert com.thealgorithms.maths.PerfectSquare.isPerfectSquare(9);
		assert com.thealgorithms.maths.PerfectSquare.isPerfectSquare(100);
	}

	public static boolean isPerfectSquare(int number) {
		int sqrt = ((int) (java.lang.Math.sqrt(number)));
		return (sqrt * sqrt) == number;
	}
}