public class TestRangeCheckSmearingLoopOpts {
	static int dummy;

	static int m1(int[] array, int i) {
		for (; ;) {
			for (; ;) {
				if (array[i] < 0) {
					break;
				}
				i++;
			}
			if ((i % 2) == 0) {
				if ((array[i] % 2) == 0) {
					compiler.rangechecks.TestRangeCheckSmearingLoopOpts.dummy = i;
				}
			}
			if (array[i - 1] == 9) {
				int res = array[i - 3];
				res += array[i];
				res += array[i - 2];
				return res;
			}
			i++;
		}
	}

	public static void main(java.lang.String[] args) {
		int[] array = new int[]{ 0, 1, 2, -3, 4, 5, -2, 7, 8, 9, -1 };
		for (int i = 0; i < 20000; i++) {
			compiler.rangechecks.TestRangeCheckSmearingLoopOpts.m1(array, 0);
		}
		array[0] = -1;
		try {
			compiler.rangechecks.TestRangeCheckSmearingLoopOpts.m1(array, 0);
		} catch (java.lang.ArrayIndexOutOfBoundsException aioobe) {
		}
	}
}