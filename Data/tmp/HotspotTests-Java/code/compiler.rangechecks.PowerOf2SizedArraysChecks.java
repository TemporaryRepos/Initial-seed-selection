public class PowerOf2SizedArraysChecks {
	static void check_result(java.lang.String name, int x, int m, boolean expected, boolean res) {
		if (expected != res) {
			throw new java.lang.RuntimeException((((((((("Bad result in " + name) + " for x =  ") + x) + " m = ") + m) + " expected ") + expected) + " got ") + res);
		}
	}

	static void helper(java.lang.String name, java.util.function.BiFunction<java.lang.Integer, int[], java.lang.Boolean> test, int[] x_values, int[] m_values, boolean[][] expected) {
		for (int i = 0; i < x_values.length; i++) {
			int x = x_values[i];
			for (int j = 0; j < m_values.length; j++) {
				int m = m_values[j];
				int[] array = new int[m];
				boolean res = test.apply(x, array);
				compiler.rangechecks.PowerOf2SizedArraysChecks.check_result(name, x, m, expected[i][j], res);
			}
		}
	}

	static void check_result(java.lang.String name, int m, boolean expected, boolean res) {
		if (expected != res) {
			throw new java.lang.RuntimeException((((((("Bad result in " + name) + " for m = ") + m) + " expected ") + expected) + " got ") + res);
		}
	}

	static void helper2(java.lang.String name, java.util.function.Function<int[], java.lang.Boolean> test, int[] m_values, boolean[] expected) {
		for (int j = 0; j < m_values.length; j++) {
			int m = m_values[j];
			int[] array = new int[m];
			boolean res = test.apply(array);
			compiler.rangechecks.PowerOf2SizedArraysChecks.check_result(name, m, expected[j], res);
		}
	}

	static boolean test1(int x, int[] array) {
		int m = array.length;
		if (((x & m) < 0) || ((x & m) > m)) {
			return false;
		}
		return true;
	}

	static boolean test2(int x, int[] array) {
		int m = array.length;
		if (((x & (m - 1)) < 0) || ((x & (m - 1)) >= m)) {
			return false;
		}
		return true;
	}

	static boolean test3(int x, int[] array) {
		try {
			int v = array[x & (array.length - 1)];
		} catch (java.lang.ArrayIndexOutOfBoundsException aioobe) {
			return false;
		}
		return true;
	}

	static boolean test4(int[] array) {
		if (array.length <= 0) {
			return false;
		}
		return true;
	}

	static boolean test5(int[] array) {
		if (array.length == 0) {
			return false;
		}
		return true;
	}

	static boolean test6(int[] array) {
		if (array.length != 0) {
			return false;
		}
		return true;
	}

	public static void main(java.lang.String[] args) {
		int[] x_values = new int[]{ -10, -5, 0, 5, 8, 16, 100 };
		int[] m_values = new int[]{ 16, 10, 0 };
		boolean[][] test1_expected = new boolean[x_values.length][m_values.length];
		for (int i = 0; i < x_values.length; i++) {
			for (int j = 0; j < m_values.length; j++) {
				test1_expected[i][j] = true;
			}
		}
		boolean[][] test2_expected = new boolean[x_values.length][m_values.length];
		for (int i = 0; i < x_values.length; i++) {
			for (int j = 0; j < m_values.length; j++) {
				test2_expected[i][j] = m_values[j] > 0;
			}
		}
		boolean[] test4_expected = new boolean[m_values.length];
		for (int i = 0; i < m_values.length; i++) {
			test4_expected[i] = m_values[i] > 0;
		}
		boolean[] test5_expected = new boolean[m_values.length];
		for (int i = 0; i < m_values.length; i++) {
			test5_expected[i] = m_values[i] != 0;
		}
		boolean[] test6_expected = new boolean[m_values.length];
		for (int i = 0; i < m_values.length; i++) {
			test6_expected[i] = m_values[i] == 0;
		}
		for (int i = 0; i < 20000; i++) {
			compiler.rangechecks.PowerOf2SizedArraysChecks.helper("test1", compiler.rangechecks.PowerOf2SizedArraysChecks::test1, x_values, m_values, test1_expected);
			compiler.rangechecks.PowerOf2SizedArraysChecks.helper("test2", compiler.rangechecks.PowerOf2SizedArraysChecks::test2, x_values, m_values, test2_expected);
			compiler.rangechecks.PowerOf2SizedArraysChecks.helper("test3", compiler.rangechecks.PowerOf2SizedArraysChecks::test3, x_values, m_values, test2_expected);
			compiler.rangechecks.PowerOf2SizedArraysChecks.helper2("test4", compiler.rangechecks.PowerOf2SizedArraysChecks::test4, m_values, test4_expected);
			compiler.rangechecks.PowerOf2SizedArraysChecks.helper2("test5", compiler.rangechecks.PowerOf2SizedArraysChecks::test5, m_values, test5_expected);
			compiler.rangechecks.PowerOf2SizedArraysChecks.helper2("test6", compiler.rangechecks.PowerOf2SizedArraysChecks::test6, m_values, test6_expected);
		}
	}
}