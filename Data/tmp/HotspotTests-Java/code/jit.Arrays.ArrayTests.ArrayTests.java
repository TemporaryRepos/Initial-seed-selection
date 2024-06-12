public class ArrayTests {
	int[] base_array;

	static int the_int_res = 200;

	static int the_char_res = 13041864;

	static int the_byte_res = -312;

	static int n = 400;

	ArrayTests() {
		base_array = new int[jit.Arrays.ArrayTests.ArrayTests.n];
		int start_value = jit.Arrays.ArrayTests.ArrayTests.n / 2;
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			base_array[i] = start_value;
			start_value--;
		}
	}

	void print() {
		for (int i = 0; i < base_array.length; i++) {
			java.lang.System.out.print(" " + base_array[i]);
		}
	}

	boolean with_chars() {
		char[] char_array = new char[jit.Arrays.ArrayTests.ArrayTests.n];
		int res = 0;
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			char_array[i] = ((char) (base_array[i]));
		}
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			res += ((int) (char_array[i]));
		}
		java.lang.System.out.println((("chars " + res) + " == ") + jit.Arrays.ArrayTests.ArrayTests.the_char_res);
		return res == jit.Arrays.ArrayTests.ArrayTests.the_char_res;
	}

	boolean with_bytes() {
		byte[] byte_array = new byte[jit.Arrays.ArrayTests.ArrayTests.n];
		int res = 0;
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			byte_array[i] = ((byte) (base_array[i]));
		}
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			res += ((int) (byte_array[i]));
		}
		java.lang.System.out.println((("bytes " + res) + " == ") + jit.Arrays.ArrayTests.ArrayTests.the_byte_res);
		return res == jit.Arrays.ArrayTests.ArrayTests.the_byte_res;
	}

	boolean with_shorts() {
		short[] short_array = new short[jit.Arrays.ArrayTests.ArrayTests.n];
		int res = 0;
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			short_array[i] = ((short) (base_array[i]));
		}
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			res += ((int) (short_array[i]));
		}
		java.lang.System.out.println((("shorts " + res) + " == ") + jit.Arrays.ArrayTests.ArrayTests.the_int_res);
		return res == jit.Arrays.ArrayTests.ArrayTests.the_int_res;
	}

	boolean with_ints() {
		int res = 0;
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			res += base_array[i];
		}
		return res == jit.Arrays.ArrayTests.ArrayTests.the_int_res;
	}

	boolean with_longs() {
		long[] long_array = new long[jit.Arrays.ArrayTests.ArrayTests.n];
		int res = 0;
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			long_array[i] = ((long) (base_array[i]));
		}
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			res += ((int) (long_array[i]));
		}
		java.lang.System.out.println((("longs " + res) + " == ") + jit.Arrays.ArrayTests.ArrayTests.the_int_res);
		return res == jit.Arrays.ArrayTests.ArrayTests.the_int_res;
	}

	boolean with_floats() {
		float[] float_array = new float[jit.Arrays.ArrayTests.ArrayTests.n];
		int res = 0;
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			float_array[i] = ((float) (base_array[i]));
		}
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			res += ((int) (float_array[i]));
		}
		java.lang.System.out.println((("floats " + res) + " == ") + jit.Arrays.ArrayTests.ArrayTests.the_int_res);
		return res == jit.Arrays.ArrayTests.ArrayTests.the_int_res;
	}

	boolean with_doubles() {
		double[] double_array = new double[jit.Arrays.ArrayTests.ArrayTests.n];
		int res = 0;
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			double_array[i] = ((double) (base_array[i]));
		}
		for (int i = 0; i < jit.Arrays.ArrayTests.ArrayTests.n; i++) {
			res += ((int) (double_array[i]));
		}
		java.lang.System.out.println((("doubles " + res) + " == ") + jit.Arrays.ArrayTests.ArrayTests.the_int_res);
		return res == jit.Arrays.ArrayTests.ArrayTests.the_int_res;
	}

	void check(java.lang.String msg, boolean flag) {
		if (!flag) {
			java.lang.System.out.println("ERROR in " + msg);
		}
	}

	boolean execute() {
		boolean res = true;
		res = res & with_chars();
		check("chars", res);
		res = res & with_shorts();
		check("shorts", res);
		res = res & with_bytes();
		check("bytes", res);
		res = res & with_ints();
		check("ints", res);
		res = res & with_longs();
		check("longs", res);
		res = res & with_floats();
		check("floats", res);
		res = res & with_doubles();
		check("doubles", res);
		return res;
	}

	public static void main(java.lang.String[] s) {
		boolean res = true;
		jit.Arrays.ArrayTests.ArrayTests at = new jit.Arrays.ArrayTests.ArrayTests();
		res = res & at.execute();
		if (res) {
			java.lang.System.out.println("Array read/write testsOK (srm 10/22/96)");
		} else {
			throw new nsk.share.TestFailure("Error in read/write array tests!");
		}
	}
}