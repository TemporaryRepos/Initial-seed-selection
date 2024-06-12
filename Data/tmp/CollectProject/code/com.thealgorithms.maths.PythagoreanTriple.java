public class PythagoreanTriple {
	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.maths.PythagoreanTriple.isPythagTriple(3, 4, 5);
		assert com.thealgorithms.maths.PythagoreanTriple.isPythagTriple(5, 12, 13);
		assert com.thealgorithms.maths.PythagoreanTriple.isPythagTriple(6, 8, 10);
		assert !com.thealgorithms.maths.PythagoreanTriple.isPythagTriple(10, 20, 30);
		assert !com.thealgorithms.maths.PythagoreanTriple.isPythagTriple(6, 8, 100);
		assert !com.thealgorithms.maths.PythagoreanTriple.isPythagTriple(-1, -1, 1);
	}

	public static boolean isPythagTriple(int a, int b, int c) {
		if (((a <= 0) || (b <= 0)) || (c <= 0)) {
			return false;
		} else {
			return ((a * a) + (b * b)) == (c * c);
		}
	}
}