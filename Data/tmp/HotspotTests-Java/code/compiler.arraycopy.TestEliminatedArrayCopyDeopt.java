public class TestEliminatedArrayCopyDeopt {
	static class A implements java.lang.Cloneable {
		int f0;

		int f1;

		int f2;

		int f3;

		int f4;

		int f5;

		int f6;

		int f7;

		int f8;

		int f9;

		int f10;

		int f11;

		int f12;

		int f13;

		int f14;

		int f15;

		public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
			return super.clone();
		}
	}

	static boolean m1(compiler.arraycopy.TestEliminatedArrayCopyDeopt.A a, boolean flag) throws java.lang.CloneNotSupportedException {
		compiler.arraycopy.TestEliminatedArrayCopyDeopt.A c = ((compiler.arraycopy.TestEliminatedArrayCopyDeopt.A) (a.clone()));
		if (flag) {
			if (c.f0 != 0x42) {
				return false;
			}
		}
		return true;
	}

	static int[] m2_src = null;

	static boolean m2(boolean flag) throws java.lang.CloneNotSupportedException {
		int[] src = new int[10];
		compiler.arraycopy.TestEliminatedArrayCopyDeopt.m2_src = src;
		for (int i = 0; i < src.length; i++) {
			src[i] = 0x42 + i;
		}
		int[] c = ((int[]) (src.clone()));
		if (flag) {
			for (int i = 0; i < c.length; i++) {
				if (c[i] != src[i]) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean m3(int[] src, boolean flag) {
		int[] dst = new int[10];
		java.lang.System.arraycopy(src, 0, dst, 0, 10);
		if (flag) {
			for (int i = 0; i < dst.length; i++) {
				if (dst[i] != src[i]) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean m4(int[] src, boolean flag) {
		int[] dst = new int[10];
		dst[0] = 0x42;
		dst[1] = 0x42 - 1;
		dst[2] = 0x42 - 2;
		dst[8] = 0x42 - 8;
		dst[9] = 0x42 - 9;
		int src_off = 2;
		int dst_off = 3;
		int len = 5;
		java.lang.System.arraycopy(src, src_off, dst, dst_off, len);
		if (flag) {
			for (int i = 0; i < dst.length; i++) {
				if ((i >= dst_off) && (i < (dst_off + len))) {
					if (dst[i] != src[(i - dst_off) + src_off]) {
						return false;
					}
				} else if (dst[i] != (0x42 - i)) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean m5(int[] src, boolean flag1, boolean flag2) {
		int[] dst = new int[10];
		if (flag1) {
			java.lang.System.arraycopy(src, 0, dst, 0, 10);
		}
		if (flag2) {
			for (int i = 0; i < dst.length; i++) {
				if (dst[i] != src[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		boolean success = true;
		compiler.arraycopy.TestEliminatedArrayCopyDeopt.A a = new compiler.arraycopy.TestEliminatedArrayCopyDeopt.A();
		a.f0 = 0x42;
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestEliminatedArrayCopyDeopt.m1(a, false);
		}
		if (!compiler.arraycopy.TestEliminatedArrayCopyDeopt.m1(a, true)) {
			java.lang.System.out.println("m1 failed");
			success = false;
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestEliminatedArrayCopyDeopt.m2(false);
		}
		if (!compiler.arraycopy.TestEliminatedArrayCopyDeopt.m2(true)) {
			java.lang.System.out.println("m2 failed");
			success = false;
		}
		int[] src = new int[10];
		for (int i = 0; i < src.length; i++) {
			src[i] = 0x42 + i;
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestEliminatedArrayCopyDeopt.m3(src, false);
		}
		if (!compiler.arraycopy.TestEliminatedArrayCopyDeopt.m3(src, true)) {
			java.lang.System.out.println("m3 failed");
			success = false;
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestEliminatedArrayCopyDeopt.m4(src, false);
		}
		if (!compiler.arraycopy.TestEliminatedArrayCopyDeopt.m4(src, true)) {
			java.lang.System.out.println("m4 failed");
			success = false;
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestEliminatedArrayCopyDeopt.m5(src, (i % 2) == 0, false);
		}
		if (!compiler.arraycopy.TestEliminatedArrayCopyDeopt.m5(src, true, true)) {
			java.lang.System.out.println("m4 failed");
			success = false;
		}
		if (!success) {
			throw new java.lang.RuntimeException("Test failed");
		}
	}
}