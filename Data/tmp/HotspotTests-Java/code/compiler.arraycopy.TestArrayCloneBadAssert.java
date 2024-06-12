public class TestArrayCloneBadAssert {
	static final int[] array = new int[5];

	static int[] m(int[] arr) {
		int i = 0;
		for (; i < 2; i++) {
		}
		if (i == 2) {
			arr = compiler.arraycopy.TestArrayCloneBadAssert.array;
		}
		return arr.clone();
	}

	public static void main(java.lang.String[] args) {
		int[] arr = new int[5];
		compiler.arraycopy.TestArrayCloneBadAssert.m(arr);
	}
}