public class TestArrayCopyNoInit {
	static int[] m1(int[] src) {
		int[] dest = new int[10];
		try {
			java.lang.System.arraycopy(src, 0, dest, 0, 10);
		} catch (java.lang.NullPointerException npe) {
		}
		return dest;
	}

	static int[] m2(java.lang.Object src, boolean flag) {
		java.lang.Class tmp = src.getClass();
		if (flag) {
			return null;
		}
		int[] dest = new int[10];
		try {
			java.lang.System.arraycopy(src, 0, dest, 0, 10);
		} catch (java.lang.ArrayStoreException npe) {
		}
		return dest;
	}

	static int[] m3(int[] src, int src_offset) {
		int tmp = src[0];
		int[] dest = new int[10];
		try {
			java.lang.System.arraycopy(src, src_offset, dest, 0, 10);
		} catch (java.lang.IndexOutOfBoundsException npe) {
		}
		return dest;
	}

	static int[] m4(int[] src, int length) {
		int tmp = src[0];
		int[] dest = new int[10];
		try {
			java.lang.System.arraycopy(src, 0, dest, 0, length);
		} catch (java.lang.IndexOutOfBoundsException npe) {
		}
		return dest;
	}

	static compiler.arraycopy.TestArrayCopyNoInit[] m5(java.lang.Object[] src) {
		java.lang.Object tmp = src[0];
		compiler.arraycopy.TestArrayCopyNoInit[] dest = new compiler.arraycopy.TestArrayCopyNoInit[10];
		java.lang.System.arraycopy(src, 0, dest, 0, 10);
		return dest;
	}

	static class A {}

	static class B extends compiler.arraycopy.TestArrayCopyNoInit.A {}

	static class C extends compiler.arraycopy.TestArrayCopyNoInit.B {}

	static class D extends compiler.arraycopy.TestArrayCopyNoInit.C {}

	static class E extends compiler.arraycopy.TestArrayCopyNoInit.D {}

	static class F extends compiler.arraycopy.TestArrayCopyNoInit.E {}

	static class G extends compiler.arraycopy.TestArrayCopyNoInit.F {}

	static class H extends compiler.arraycopy.TestArrayCopyNoInit.G {}

	static class I extends compiler.arraycopy.TestArrayCopyNoInit.H {}

	static compiler.arraycopy.TestArrayCopyNoInit.H[] m6(java.lang.Object[] src) {
		java.lang.Object tmp = src[0];
		compiler.arraycopy.TestArrayCopyNoInit.H[] dest = new compiler.arraycopy.TestArrayCopyNoInit.H[10];
		java.lang.System.arraycopy(src, 0, dest, 0, 10);
		return dest;
	}

	static java.lang.Object m7_src(java.lang.Object src) {
		return src;
	}

	static int[] m7(java.lang.Object src, boolean flag) {
		java.lang.Class tmp = src.getClass();
		if (flag) {
			return null;
		}
		src = compiler.arraycopy.TestArrayCopyNoInit.m7_src(src);
		int[] dest = new int[10];
		try {
			java.lang.System.arraycopy(src, 0, dest, 0, 10);
		} catch (java.lang.ArrayStoreException npe) {
		}
		return dest;
	}

	public static void main(java.lang.String[] args) {
		boolean success = true;
		int[] src = new int[10];
		compiler.arraycopy.TestArrayCopyNoInit[] src2 = new compiler.arraycopy.TestArrayCopyNoInit[10];
		int[] res = null;
		compiler.arraycopy.TestArrayCopyNoInit[] res2 = null;
		java.lang.Object src_obj = new java.lang.Object();
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyNoInit.m1(src);
		}
		res = compiler.arraycopy.TestArrayCopyNoInit.m1(null);
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				success = false;
				java.lang.System.out.println("Uninitialized array following NPE");
				break;
			}
		}
		for (int i = 0; i < 20000; i++) {
			if ((i % 2) == 0) {
				compiler.arraycopy.TestArrayCopyNoInit.m2(src, false);
			} else {
				compiler.arraycopy.TestArrayCopyNoInit.m2(src_obj, true);
			}
		}
		res = compiler.arraycopy.TestArrayCopyNoInit.m2(src_obj, false);
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				success = false;
				java.lang.System.out.println("Uninitialized array following failed array check");
				break;
			}
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyNoInit.m3(src, 0);
		}
		res = compiler.arraycopy.TestArrayCopyNoInit.m3(src, -1);
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				success = false;
				java.lang.System.out.println("Uninitialized array following failed src offset check");
				break;
			}
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyNoInit.m4(src, 0);
		}
		res = compiler.arraycopy.TestArrayCopyNoInit.m4(src, -1);
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				success = false;
				java.lang.System.out.println("Uninitialized array following failed length check");
				break;
			}
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyNoInit.m5(src2);
		}
		res2 = compiler.arraycopy.TestArrayCopyNoInit.m5(new java.lang.Object[10]);
		for (int i = 0; i < res2.length; i++) {
			if (res2[i] != null) {
				success = false;
				java.lang.System.out.println("Uninitialized array following failed type check");
				break;
			}
		}
		compiler.arraycopy.TestArrayCopyNoInit.H[] src3 = new compiler.arraycopy.TestArrayCopyNoInit.H[10];
		compiler.arraycopy.TestArrayCopyNoInit.I b = new compiler.arraycopy.TestArrayCopyNoInit.I();
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestArrayCopyNoInit.m6(src3);
		}
		compiler.arraycopy.TestArrayCopyNoInit.H[] res3 = compiler.arraycopy.TestArrayCopyNoInit.m6(new java.lang.Object[10]);
		for (int i = 0; i < res3.length; i++) {
			if (res3[i] != null) {
				success = false;
				java.lang.System.out.println("Uninitialized array following failed full type check");
				break;
			}
		}
		for (int i = 0; i < 20000; i++) {
			if ((i % 2) == 0) {
				compiler.arraycopy.TestArrayCopyNoInit.m7(src, false);
			} else {
				compiler.arraycopy.TestArrayCopyNoInit.m7(src_obj, true);
			}
		}
		res = compiler.arraycopy.TestArrayCopyNoInit.m7(src_obj, false);
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				success = false;
				java.lang.System.out.println("Uninitialized array following failed type check with return value profiling");
				break;
			}
		}
		if (!success) {
			throw new java.lang.RuntimeException("Some tests failed");
		}
	}
}