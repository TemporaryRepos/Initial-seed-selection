public class TrinomialTriangle {
	public static int TrinomialValue(int n, int k) {
		if ((n == 0) && (k == 0)) {
			return 1;
		}
		if ((k < (-n)) || (k > n)) {
			return 0;
		}
		return (com.thealgorithms.maths.TrinomialTriangle.TrinomialValue(n - 1, k - 1) + com.thealgorithms.maths.TrinomialTriangle.TrinomialValue(n - 1, k)) + com.thealgorithms.maths.TrinomialTriangle.TrinomialValue(n - 1, k + 1);
	}

	public static void printTrinomial(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = -i; j <= 0; j++) {
				java.lang.System.out.print(com.thealgorithms.maths.TrinomialTriangle.TrinomialValue(i, j) + " ");
			}
			for (int j = 1; j <= i; j++) {
				java.lang.System.out.print(com.thealgorithms.maths.TrinomialTriangle.TrinomialValue(i, j) + " ");
			}
			java.lang.System.out.println();
		}
	}

	public static void main(java.lang.String[] argc) {
		int n = 6;
		com.thealgorithms.maths.TrinomialTriangle.printTrinomial(n);
	}
}