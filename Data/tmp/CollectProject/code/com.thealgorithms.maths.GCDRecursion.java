public class GCDRecursion {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.thealgorithms.maths.GCDRecursion.gcd(20, 15));
		java.lang.System.out.println(com.thealgorithms.maths.GCDRecursion.gcd(10, 8));
		java.lang.System.out.println(com.thealgorithms.maths.GCDRecursion.gcd(com.thealgorithms.maths.GCDRecursion.gcd(10, 5), com.thealgorithms.maths.GCDRecursion.gcd(5, 10)));
	}

	public static int gcd(int a, int b) {
		if ((a < 0) || (b < 0)) {
			throw new java.lang.ArithmeticException();
		}
		if ((a == 0) || (b == 0)) {
			return java.lang.Math.abs(a - b);
		}
		if ((a % b) == 0) {
			return b;
		} else {
			return com.thealgorithms.maths.GCDRecursion.gcd(b, a % b);
		}
	}
}