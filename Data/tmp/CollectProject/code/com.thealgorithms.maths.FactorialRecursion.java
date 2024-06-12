public class FactorialRecursion {
	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.maths.FactorialRecursion.factorial(0) == 1;
		assert com.thealgorithms.maths.FactorialRecursion.factorial(1) == 1;
		assert com.thealgorithms.maths.FactorialRecursion.factorial(2) == 2;
		assert com.thealgorithms.maths.FactorialRecursion.factorial(3) == 6;
		assert com.thealgorithms.maths.FactorialRecursion.factorial(5) == 120;
	}

	public static long factorial(int n) {
		if (n < 0) {
			throw new java.lang.IllegalArgumentException("number is negative");
		}
		return (n == 0) || (n == 1) ? 1 : n * com.thealgorithms.maths.FactorialRecursion.factorial(n - 1);
	}
}