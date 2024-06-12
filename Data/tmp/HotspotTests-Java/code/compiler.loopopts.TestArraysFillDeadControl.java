public class TestArraysFillDeadControl {
	static void dont_inline() {
	}

	static int i = 1;

	public static void main(java.lang.String[] args) {
		for (int j = 0; j < 200000; j++) {
			int[] a = new int[2];
			int b = compiler.loopopts.TestArraysFillDeadControl.i;
			java.util.Arrays.fill(a, 1);
			java.util.Arrays.fill(a, 1 + b);
			compiler.loopopts.TestArraysFillDeadControl.dont_inline();
		}
	}
}