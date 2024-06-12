public class Test6982370 {
	public static void main(java.lang.String[] args) {
		compiler.intrinsics.Test6982370.test_byte();
		compiler.intrinsics.Test6982370.test_char();
		compiler.intrinsics.Test6982370.test_short();
		compiler.intrinsics.Test6982370.test_int();
		compiler.intrinsics.Test6982370.test_float();
	}

	public static void test_int() {
		int[] a = new int[16];
		for (int i = 0; i < 200000; i++) {
			int start = i & 7;
			int end = start + ((i >> 4) & 7);
			int value = i;
			if ((i & 1) == 1) {
				value = -value;
			}
			java.util.Arrays.fill(a, start, end, value);
			boolean error = false;
			for (int j = start; j < end; j++) {
				if (a[j] != value) {
					java.lang.System.err.println((((((("a[" + j) + "] = ") + a[j]) + " != ") + value) + " for ") + a.length);
					error = true;
				}
			}
			if (error) {
				throw new java.lang.InternalError();
			}
		}
	}

	public static void test_float() {
		float[] a = new float[16];
		for (int i = 0; i < 200000; i++) {
			int start = i & 7;
			int end = start + ((i >> 4) & 7);
			float value = ((float) (i));
			if ((i & 1) == 1) {
				value = -value;
			}
			java.util.Arrays.fill(a, start, end, value);
			boolean error = false;
			for (int j = start; j < end; j++) {
				if (a[j] != value) {
					java.lang.System.err.println((((((("a[" + j) + "] = ") + a[j]) + " != ") + value) + " for ") + a.length);
					error = true;
				}
			}
			if (error) {
				throw new java.lang.InternalError();
			}
		}
	}

	public static void test_char() {
		char[] a = new char[16];
		for (int i = 0; i < 200000; i++) {
			int start = i & 7;
			int end = start + ((i >> 4) & 7);
			char value = ((char) (i));
			java.util.Arrays.fill(a, start, end, value);
			boolean error = false;
			for (int j = start; j < end; j++) {
				if (a[j] != value) {
					java.lang.System.err.println((((((("a[" + j) + "] = ") + a[j]) + " != ") + value) + " for ") + a.length);
					error = true;
				}
			}
			if (error) {
				throw new java.lang.InternalError();
			}
		}
	}

	public static void test_short() {
		short[] a = new short[16];
		for (int i = 0; i < 200000; i++) {
			int start = i & 7;
			int end = start + ((i >> 4) & 7);
			short value = ((short) (i));
			if ((i & 1) == 1) {
				value = ((short) (-value));
			}
			java.util.Arrays.fill(a, start, end, value);
			boolean error = false;
			for (int j = start; j < end; j++) {
				if (a[j] != value) {
					java.lang.System.err.println((((((("a[" + j) + "] = ") + a[j]) + " != ") + value) + " for ") + a.length);
					error = true;
				}
			}
			if (error) {
				throw new java.lang.InternalError();
			}
		}
	}

	public static void test_byte() {
		for (int i = 0; i < 200000; i++) {
			byte[] a = new byte[16];
			int start = i & 7;
			int end = start + ((i >> 4) & 7);
			byte value = ((byte) (i));
			if ((i & 1) == 1) {
				value = ((byte) (-value));
			}
			java.util.Arrays.fill(a, start, end, value);
			boolean error = false;
			for (int j = start; j < end; j++) {
				if (a[j] != value) {
					java.lang.System.err.println((((((("a[" + j) + "] = ") + a[j]) + " != ") + value) + " for ") + a.length);
					error = true;
				}
			}
			if (error) {
				throw new java.lang.InternalError();
			}
		}
	}
}