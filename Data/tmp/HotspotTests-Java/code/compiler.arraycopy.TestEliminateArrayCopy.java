public class TestEliminateArrayCopy {
	static class CloneTests extends compiler.arraycopy.TestInstanceCloneUtils {
		static void m1(compiler.arraycopy.TestInstanceCloneUtils.E src) throws java.lang.CloneNotSupportedException {
			src.clone();
		}

		static void m2(java.lang.Object dummy) throws java.lang.CloneNotSupportedException {
			compiler.arraycopy.TestInstanceCloneUtils.E src = new compiler.arraycopy.TestInstanceCloneUtils.E(false);
			src.clone();
		}

		static int m3(compiler.arraycopy.TestInstanceCloneUtils.E src) throws java.lang.CloneNotSupportedException {
			compiler.arraycopy.TestInstanceCloneUtils.E dest = ((compiler.arraycopy.TestInstanceCloneUtils.E) (src.clone()));
			return (((((((dest.i1 + dest.i2) + dest.i3) + dest.i4) + dest.i5) + dest.i6) + dest.i7) + dest.i8) + dest.i9;
		}
	}

	static class ArrayCopyTests extends compiler.arraycopy.TestArrayCopyUtils {
		@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.LARGE)
		static int m1() throws java.lang.CloneNotSupportedException {
			int[] array_clone = ((int[]) (compiler.arraycopy.TestArrayCopyUtils.large_int_src.clone()));
			return ((((((((array_clone[0] + array_clone[1]) + array_clone[2]) + array_clone[3]) + array_clone[4]) + array_clone[5]) + array_clone[6]) + array_clone[7]) + array_clone[8]) + array_clone[9];
		}

		@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.LARGE)
		static int m2() {
			int[] dest = new int[10];
			java.lang.System.arraycopy(compiler.arraycopy.TestArrayCopyUtils.large_int_src, 0, dest, 0, 10);
			return ((((((((dest[0] + dest[1]) + dest[2]) + dest[3]) + dest[4]) + dest[5]) + dest[6]) + dest[7]) + dest[8]) + dest[9];
		}

		@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.LARGE)
		static int m3() {
			int[] dest1 = new int[10];
			java.lang.System.arraycopy(compiler.arraycopy.TestArrayCopyUtils.large_int_src, 0, dest1, 0, 10);
			int[] dest2 = new int[10];
			java.lang.System.arraycopy(dest1, 0, dest2, 0, 10);
			return ((((((((dest2[0] + dest2[1]) + dest2[2]) + dest2[3]) + dest2[4]) + dest2[5]) + dest2[6]) + dest2[7]) + dest2[8]) + dest2[9];
		}

		static class m4_class {
			java.lang.Object f;
		}

		static void m4_helper() {
		}

		@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.LARGE)
		static int m4() {
			int[] dest = new int[10];
			compiler.arraycopy.TestEliminateArrayCopy.ArrayCopyTests.m4_class o = new compiler.arraycopy.TestEliminateArrayCopy.ArrayCopyTests.m4_class();
			o.f = dest;
			compiler.arraycopy.TestEliminateArrayCopy.ArrayCopyTests.m4_helper();
			java.lang.System.arraycopy(compiler.arraycopy.TestArrayCopyUtils.large_int_src, 0, o.f, 0, 10);
			return ((((((((dest[0] + dest[1]) + dest[2]) + dest[3]) + dest[4]) + dest[5]) + dest[6]) + dest[7]) + dest[8]) + dest[9];
		}

		static void m5_helper() {
		}

		@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.NEW)
		static void m5(compiler.arraycopy.TestArrayCopyUtils.A[] src, compiler.arraycopy.TestArrayCopyUtils.A[] dest) {
			compiler.arraycopy.TestArrayCopyUtils.A[] temp = new compiler.arraycopy.TestArrayCopyUtils.A[5];
			compiler.arraycopy.TestEliminateArrayCopy.ArrayCopyTests.m5_helper();
			java.lang.System.arraycopy(src, 0, temp, 0, 5);
			dest[0] = temp[0];
			dest[1] = temp[1];
			dest[2] = temp[2];
			dest[3] = temp[3];
			dest[4] = temp[4];
		}

		@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.LARGE)
		static int m6(int[] src) {
			int res = ((((((((src[0] + src[1]) + src[2]) + src[3]) + src[4]) + src[5]) + src[6]) + src[7]) + src[8]) + src[9];
			int[] dest = new int[10];
			java.lang.System.arraycopy(src, 0, dest, 0, 10);
			res += ((((((((dest[0] + dest[1]) + dest[2]) + dest[3]) + dest[4]) + dest[5]) + dest[6]) + dest[7]) + dest[8]) + dest[9];
			return res / 2;
		}

		@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.LARGE)
		static int m7() {
			int[] dest = new int[10];
			dest[0] = compiler.arraycopy.TestArrayCopyUtils.large_int_src[8];
			dest[1] = compiler.arraycopy.TestArrayCopyUtils.large_int_src[9];
			java.lang.System.arraycopy(compiler.arraycopy.TestArrayCopyUtils.large_int_src, 0, dest, 2, 8);
			return ((((((((dest[0] + dest[1]) + dest[2]) + dest[3]) + dest[4]) + dest[5]) + dest[6]) + dest[7]) + dest[8]) + dest[9];
		}
	}

	static final java.lang.Object[] m1_array = new java.lang.Object[10];

	static boolean m1_array_null_element = false;

	static void m1(int i) {
		java.lang.Object[] array_clone = ((java.lang.Object[]) (compiler.arraycopy.TestEliminateArrayCopy.m1_array.clone()));
		if (array_clone[i] == null) {
			compiler.arraycopy.TestEliminateArrayCopy.m1_array_null_element = true;
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		compiler.arraycopy.TestEliminateArrayCopy.CloneTests clone_tests = new compiler.arraycopy.TestEliminateArrayCopy.CloneTests();
		clone_tests.doTest(clone_tests.e, "m1");
		clone_tests.doTest(null, "m2");
		clone_tests.doTest(clone_tests.e, "m3");
		compiler.arraycopy.TestEliminateArrayCopy.ArrayCopyTests ac_tests = new compiler.arraycopy.TestEliminateArrayCopy.ArrayCopyTests();
		ac_tests.doTest("m1");
		ac_tests.doTest("m2");
		ac_tests.doTest("m3");
		ac_tests.doTest("m4");
		ac_tests.doTest("m5");
		ac_tests.doTest("m6");
		ac_tests.doTest("m7");
		if ((!clone_tests.success) || (!ac_tests.success)) {
			throw new java.lang.RuntimeException("some tests failed");
		}
		for (int i = 0; i < 7000; i++) {
			compiler.arraycopy.TestEliminateArrayCopy.m1(0);
		}
		compiler.arraycopy.TestEliminateArrayCopy.m1_array[0] = new java.lang.Object();
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestEliminateArrayCopy.m1(0);
		}
		compiler.arraycopy.TestEliminateArrayCopy.m1_array_null_element = false;
		compiler.arraycopy.TestEliminateArrayCopy.m1(0);
		if (compiler.arraycopy.TestEliminateArrayCopy.m1_array_null_element) {
			throw new java.lang.RuntimeException("OptimizePtrCompare test failed");
		}
	}
}