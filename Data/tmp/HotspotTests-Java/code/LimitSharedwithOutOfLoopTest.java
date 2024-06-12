public class LimitSharedwithOutOfLoopTest {
	public static void main(java.lang.String[] args) {
		boolean[] array1 = new boolean[2001];
		boolean[] array2 = new boolean[2001];
		boolean[] array3 = new boolean[2001];
		array2[1000] = true;
		array3[2000] = true;
		for (int i = 0; i < 20000; i++) {
			if (LimitSharedwithOutOfLoopTest.test(2000, array1)) {
				throw new java.lang.RuntimeException("bad return");
			}
			if (!LimitSharedwithOutOfLoopTest.test(2000, array2)) {
				throw new java.lang.RuntimeException("bad return");
			}
			if (LimitSharedwithOutOfLoopTest.test(2000, array3)) {
				throw new java.lang.RuntimeException("bad return");
			}
		}
	}

	static volatile boolean barrier;

	private static boolean test(int limit, boolean[] array) {
		for (int i = 0; i < limit;) {
			i++;
			if (array[i]) {
				if (i < limit) {
					return true;
				}
				return false;
			}
			LimitSharedwithOutOfLoopTest.barrier = true;
		}
		return false;
	}
}