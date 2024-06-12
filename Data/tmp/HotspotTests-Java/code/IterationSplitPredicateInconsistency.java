public class IterationSplitPredicateInconsistency {
	static volatile int barrier;

	static boolean test1_helper(int start, int stop, double[] array1, double[] array2, int exit) {
		for (int i = start; i < stop; i++) {
			array1[i] = array2[i];
			if (i == exit) {
				return true;
			}
			IterationSplitPredicateInconsistency.barrier = 0x42;
		}
		return false;
	}

	static double[] test1(int start, double[] array2, int exit) {
		double[] array1 = new double[10];
		if (IterationSplitPredicateInconsistency.test1_helper(start, 5, array1, array2, exit)) {
			return null;
		}
		return array1;
	}

	static boolean test2_helper(int start, int stop, double[] array1, double[] array2, int exit) {
		for (int i = start - 1; i >= stop; i--) {
			array1[i] = array2[i];
			if (i == exit) {
				return true;
			}
			IterationSplitPredicateInconsistency.barrier = 0x42;
		}
		return false;
	}

	static double[] test2(int start, double[] array2, int exit) {
		double[] array1 = new double[10];
		if (IterationSplitPredicateInconsistency.test2_helper(start, 0, array1, array2, exit)) {
			return null;
		}
		return array1;
	}

	static boolean test3_helper(int start, int stop, double[] array1, double[] array2, int exit) {
		for (int i = start; i < stop; i++) {
			array1[(stop - i) - 1] = array2[(stop - i) - 1];
			if (i == exit) {
				return true;
			}
			IterationSplitPredicateInconsistency.barrier = 0x42;
		}
		return false;
	}

	static double[] test3(int start, double[] array2, int exit) {
		double[] array1 = new double[5];
		if (IterationSplitPredicateInconsistency.test3_helper(start, 5, array1, array2, exit)) {
			return null;
		}
		return array1;
	}

	static boolean test4_helper(int start, int stop, int from, double[] array1, double[] array2, int exit) {
		for (int i = start - 1; i >= stop; i--) {
			array1[(from - i) - 1] = array2[(from - i) - 1];
			if (i == exit) {
				return true;
			}
			IterationSplitPredicateInconsistency.barrier = 0x42;
		}
		return false;
	}

	static double[] test4(int start, double[] array2, int exit) {
		double[] array1 = new double[5];
		if (IterationSplitPredicateInconsistency.test4_helper(start, 0, 5, array1, array2, exit)) {
			return null;
		}
		return array1;
	}

	public static void main(java.lang.String[] args) {
		double[] array2 = new double[10];
		double[] array3 = new double[1000];
		for (int i = 0; i < 20000; i++) {
			IterationSplitPredicateInconsistency.test1_helper(0, 1000, array3, array3, 998);
			IterationSplitPredicateInconsistency.test1(0, array2, 999);
			IterationSplitPredicateInconsistency.test1(0, array2, 4);
			IterationSplitPredicateInconsistency.test2_helper(1000, 0, array3, array3, 1);
			IterationSplitPredicateInconsistency.test2(5, array2, 999);
			IterationSplitPredicateInconsistency.test2(5, array2, 1);
			IterationSplitPredicateInconsistency.test3_helper(0, 1000, array3, array3, 998);
			IterationSplitPredicateInconsistency.test3(0, array2, 999);
			IterationSplitPredicateInconsistency.test3(0, array2, 4);
			IterationSplitPredicateInconsistency.test4_helper(1000, 0, 1000, array3, array3, 1);
			IterationSplitPredicateInconsistency.test4(5, array2, 999);
			IterationSplitPredicateInconsistency.test4(5, array2, 1);
		}
	}
}