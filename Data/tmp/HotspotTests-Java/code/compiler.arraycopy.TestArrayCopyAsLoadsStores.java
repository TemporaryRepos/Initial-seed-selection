public class TestArrayCopyAsLoadsStores extends compiler.arraycopy.TestArrayCopyUtils {
	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL)
	static compiler.arraycopy.TestArrayCopyUtils.A[] m1() throws java.lang.CloneNotSupportedException {
		return ((compiler.arraycopy.TestArrayCopyUtils.A[]) (compiler.arraycopy.TestArrayCopyUtils.small_a_src.clone()));
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL)
	static int[] m2() throws java.lang.CloneNotSupportedException {
		return ((int[]) (compiler.arraycopy.TestArrayCopyUtils.small_int_src.clone()));
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL)
	static int m3() throws java.lang.CloneNotSupportedException {
		int[] array_clone = ((int[]) (compiler.arraycopy.TestArrayCopyUtils.small_int_src.clone()));
		return (((array_clone[0] + array_clone[1]) + array_clone[2]) + array_clone[3]) + array_clone[4];
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.LARGE)
	static int[] m4() throws java.lang.CloneNotSupportedException {
		return ((int[]) (compiler.arraycopy.TestArrayCopyUtils.large_int_src.clone()));
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.ZERO)
	static int[] m5() throws java.lang.CloneNotSupportedException {
		return ((int[]) (compiler.arraycopy.TestArrayCopyUtils.zero_int_src.clone()));
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.NEW)
	static void m6(int[] src, int[] dest) {
		java.lang.System.arraycopy(src, 0, dest, 0, 5);
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.LARGE, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.NEW)
	static void m7(int[] src, int[] dest) {
		java.lang.System.arraycopy(src, 0, dest, 0, 10);
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL)
	static compiler.arraycopy.TestArrayCopyUtils.A[] m8(compiler.arraycopy.TestArrayCopyUtils.A[] src) {
		src[0] = src[0];
		compiler.arraycopy.TestArrayCopyUtils.A[] dest = new compiler.arraycopy.TestArrayCopyUtils.A[5];
		java.lang.System.arraycopy(src, 0, dest, 0, 5);
		return dest;
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.NEW)
	static void m9(compiler.arraycopy.TestArrayCopyUtils.A[] src, compiler.arraycopy.TestArrayCopyUtils.A[] dest) {
		java.lang.System.arraycopy(src, 0, dest, 0, 5);
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.SRC)
	static void m10(int[] src, int[] dest) {
		java.lang.System.arraycopy(src, 0, dest, 1, 4);
	}

	static boolean m10_check(int[] src, int[] dest) {
		boolean failure = false;
		for (int i = 0; i < 5; i++) {
			int j = java.lang.Math.max(i - 1, 0);
			if (dest[i] != src[j]) {
				java.lang.System.out.println((((((((("Test m10 failed for " + i) + " src[") + j) + "]=") + src[j]) + ", dest[") + i) + "]=") + dest[i]);
				failure = true;
			}
		}
		return failure;
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.SRC)
	static void m11(int[] src, int[] dest) {
		java.lang.System.arraycopy(src, 1, dest, 0, 4);
	}

	static boolean m11_check(int[] src, int[] dest) {
		boolean failure = false;
		for (int i = 0; i < 5; i++) {
			int j = java.lang.Math.min(i + 1, 4);
			if (dest[i] != src[j]) {
				java.lang.System.out.println((((((((("Test m11 failed for " + i) + " src[") + j) + "]=") + src[j]) + ", dest[") + i) + "]=") + dest[i]);
				failure = true;
			}
		}
		return failure;
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.SRC, extra_args = { 0, 1 })
	static void m12(int[] src, int[] dest, int srcPos, int destPos) {
		java.lang.System.arraycopy(src, srcPos, dest, destPos, 4);
	}

	static boolean m12_check(int[] src, int[] dest) {
		boolean failure = false;
		for (int i = 0; i < 5; i++) {
			int j = java.lang.Math.max(i - 1, 0);
			if (dest[i] != src[j]) {
				java.lang.System.out.println((((((((("Test m10 failed for " + i) + " src[") + j) + "]=") + src[j]) + ", dest[") + i) + "]=") + dest[i]);
				failure = true;
			}
		}
		return failure;
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL)
	static int m13(int[] src) {
		int[] dest = new int[5];
		java.lang.System.arraycopy(src, 0, dest, 0, 5);
		return (((dest[0] + dest[1]) + dest[2]) + dest[3]) + dest[4];
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.ZERO, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.NEW)
	static void m14(int[] src, int[] dest) {
		java.lang.System.arraycopy(src, 0, dest, 0, 0);
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL)
	static compiler.arraycopy.TestArrayCopyUtils.A[] m15() {
		return java.util.Arrays.copyOf(compiler.arraycopy.TestArrayCopyUtils.small_a_src, 5, compiler.arraycopy.TestArrayCopyUtils.A[].class);
	}

	static java.lang.Object[] helper16(int i) {
		java.lang.Object[] arr = null;
		if ((i % 2) == 0) {
			arr = compiler.arraycopy.TestArrayCopyUtils.small_a_src;
		} else {
			arr = compiler.arraycopy.TestArrayCopyUtils.small_object_src;
		}
		return arr;
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.NONE, extra_args = { 0 })
	static compiler.arraycopy.TestArrayCopyUtils.A[] m16(compiler.arraycopy.TestArrayCopyUtils.A[] unused_src, int i) {
		java.lang.Object[] arr = compiler.arraycopy.TestArrayCopyAsLoadsStores.helper16(i);
		return java.util.Arrays.copyOf(arr, 5, compiler.arraycopy.TestArrayCopyUtils.A[].class);
	}

	static java.lang.Object[] helper17_1(int i) {
		java.lang.Object[] arr = null;
		if ((i % 2) == 0) {
			arr = compiler.arraycopy.TestArrayCopyUtils.small_a_src;
		} else {
			arr = compiler.arraycopy.TestArrayCopyUtils.small_object_src;
		}
		return arr;
	}

	static compiler.arraycopy.TestArrayCopyUtils.A[] helper17_2(java.lang.Object[] arr) {
		return java.util.Arrays.copyOf(arr, 5, compiler.arraycopy.TestArrayCopyUtils.A[].class);
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.NONE, extra_args = { 0 })
	static compiler.arraycopy.TestArrayCopyUtils.A[] m17(compiler.arraycopy.TestArrayCopyUtils.A[] unused_src, int i) {
		java.lang.Object[] arr = compiler.arraycopy.TestArrayCopyAsLoadsStores.helper17_1(i);
		return compiler.arraycopy.TestArrayCopyAsLoadsStores.helper17_2(arr);
	}

	static java.lang.Object[] helper18_1(int i) {
		java.lang.Object[] arr = null;
		if ((i % 2) == 0) {
			arr = compiler.arraycopy.TestArrayCopyUtils.small_a_src;
		} else {
			arr = compiler.arraycopy.TestArrayCopyUtils.small_object_src;
		}
		return arr;
	}

	static java.lang.Object[] helper18_2(java.lang.Object[] arr) {
		return java.util.Arrays.copyOf(arr, 5, java.lang.Object[].class);
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.NONE, extra_args = { 0 })
	static java.lang.Object[] m18(compiler.arraycopy.TestArrayCopyUtils.A[] unused_src, int i) {
		java.lang.Object[] arr = compiler.arraycopy.TestArrayCopyAsLoadsStores.helper18_1(i);
		return compiler.arraycopy.TestArrayCopyAsLoadsStores.helper18_2(arr);
	}

	static java.lang.Object[] helper19(int i) {
		java.lang.Object[] arr = null;
		if ((i % 2) == 0) {
			arr = compiler.arraycopy.TestArrayCopyUtils.small_a_src;
		} else {
			arr = compiler.arraycopy.TestArrayCopyUtils.small_object_src;
		}
		return arr;
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.NONE, extra_args = { 0 })
	static compiler.arraycopy.TestArrayCopyUtils.A[] m19(compiler.arraycopy.TestArrayCopyUtils.A[] unused_src, int i) {
		java.lang.Object[] arr = compiler.arraycopy.TestArrayCopyAsLoadsStores.helper19(i);
		return java.util.Arrays.copyOf(arr, 5, compiler.arraycopy.TestArrayCopyUtils.A[].class);
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.LARGE)
	static compiler.arraycopy.TestArrayCopyUtils.A[] m20() {
		return java.util.Arrays.copyOf(compiler.arraycopy.TestArrayCopyUtils.large_a_src, 10, compiler.arraycopy.TestArrayCopyUtils.A[].class);
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.ZERO)
	static compiler.arraycopy.TestArrayCopyUtils.A[] m21() {
		return java.util.Arrays.copyOf(compiler.arraycopy.TestArrayCopyUtils.zero_a_src, 0, compiler.arraycopy.TestArrayCopyUtils.A[].class);
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.NEW, extra_args = { 0 })
	static void m22(int[] src, int[] dest, int srcPos) {
		java.lang.System.arraycopy(src, srcPos, dest, 0, 5);
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL)
	static compiler.arraycopy.TestArrayCopyUtils.A[] m23() {
		return java.util.Arrays.copyOfRange(compiler.arraycopy.TestArrayCopyUtils.small_a_src, 1, 4, compiler.arraycopy.TestArrayCopyUtils.A[].class);
	}

	static boolean m23_check(compiler.arraycopy.TestArrayCopyUtils.A[] src, compiler.arraycopy.TestArrayCopyUtils.A[] dest) {
		boolean failure = false;
		for (int i = 0; i < 3; i++) {
			if (src[i + 1] != dest[i]) {
				java.lang.System.out.println((((((((("Test m23 failed for " + i) + " src[") + (i + 1)) + "]=") + dest[i]) + ", dest[") + i) + "]=") + dest[i]);
				failure = true;
			}
		}
		return failure;
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL)
	static compiler.arraycopy.TestArrayCopyUtils.A[] m24(java.lang.Object[] src) {
		src[0] = src[0];
		compiler.arraycopy.TestArrayCopyUtils.A[] dest = new compiler.arraycopy.TestArrayCopyUtils.A[5];
		java.lang.System.arraycopy(src, 0, dest, 0, 5);
		return dest;
	}

	@compiler.arraycopy.TestArrayCopyUtils.Args(src = compiler.arraycopy.TestArrayCopyUtils.ArraySrc.SMALL, dst = compiler.arraycopy.TestArrayCopyUtils.ArrayDst.SRC, extra_args = { 0, 1 })
	static void m25(int[] src, int[] dest, int srcPos, int destPos) {
		java.lang.System.arraycopy(src, srcPos, dest, destPos, 1);
	}

	static boolean m25_check(int[] src, int[] dest) {
		boolean failure = false;
		if (dest[1] != src[0]) {
			java.lang.System.out.println((("Test m10 failed for src[0]=" + src[0]) + ", dest[1]=") + dest[1]);
			return true;
		}
		return false;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		compiler.arraycopy.TestArrayCopyAsLoadsStores test = new compiler.arraycopy.TestArrayCopyAsLoadsStores();
		test.doTest("m1");
		test.doTest("m2");
		test.doTest("m3");
		test.doTest("m4");
		test.doTest("m5");
		test.doTest("m6");
		test.doTest("m7");
		test.doTest("m8");
		test.doTest("m9");
		test.doTest("m10");
		test.doTest("m11");
		test.doTest("m12");
		test.doTest("m13");
		test.doTest("m14");
		test.doTest("m15");
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyAsLoadsStores.helper16(i);
		}
		test.doTest("m16");
		compiler.arraycopy.TestArrayCopyUtils.B b = new compiler.arraycopy.TestArrayCopyUtils.B();
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyAsLoadsStores.helper17_1(i);
		}
		test.doTest("m17");
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyAsLoadsStores.helper18_1(i);
		}
		test.doTest("m18");
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyAsLoadsStores.helper19(i);
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyAsLoadsStores.m19(null, 0);
		}
		boolean m19_exception = false;
		for (int i = 0; i < 10; i++) {
			try {
				compiler.arraycopy.TestArrayCopyAsLoadsStores.m19(null, 1);
			} catch (java.lang.ArrayStoreException ase) {
				m19_exception = true;
			}
		}
		if (!m19_exception) {
			java.lang.System.out.println("Test m19: exception wasn't thrown");
			test.success = false;
		}
		test.doTest("m19");
		test.doTest("m20");
		test.doTest("m21");
		int[] dst = new int[compiler.arraycopy.TestArrayCopyAsLoadsStores.small_int_src.length];
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyAsLoadsStores.m22(compiler.arraycopy.TestArrayCopyUtils.small_int_src, dst, 0);
		}
		for (int i = 0; i < 10; i++) {
			try {
				compiler.arraycopy.TestArrayCopyAsLoadsStores.m22(compiler.arraycopy.TestArrayCopyUtils.small_int_src, dst, 5);
			} catch (java.lang.ArrayIndexOutOfBoundsException aioobe) {
			}
		}
		test.doTest("m22");
		test.doTest("m23");
		test.doTest("m24");
		boolean m24_exception = false;
		try {
			compiler.arraycopy.TestArrayCopyAsLoadsStores.m24(compiler.arraycopy.TestArrayCopyUtils.small_object_src);
		} catch (java.lang.ArrayStoreException ase) {
			m24_exception = true;
		}
		if (!m24_exception) {
			java.lang.System.out.println("Test m24: exception wasn't thrown");
			test.success = false;
		}
		test.doTest("m25");
		if (!test.success) {
			throw new java.lang.RuntimeException("some tests failed");
		}
	}
}