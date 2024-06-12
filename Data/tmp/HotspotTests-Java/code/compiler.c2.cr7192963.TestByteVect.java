public class TestByteVect {
	private static final int ARRLEN = 997;

	private static final int ITERS = 11000;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Byte vectors");
		int errn = compiler.c2.cr7192963.TestByteVect.test();
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test() {
		byte[] a0 = new byte[compiler.c2.cr7192963.TestByteVect.ARRLEN];
		byte[] a1 = new byte[compiler.c2.cr7192963.TestByteVect.ARRLEN];
		for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ARRLEN; i++) {
			a1[i] = ((byte) (i));
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ITERS; i++) {
			compiler.c2.cr7192963.TestByteVect.test_init(a0);
			compiler.c2.cr7192963.TestByteVect.test_addi(a0, a1);
			compiler.c2.cr7192963.TestByteVect.test_lsai(a0, a1);
			compiler.c2.cr7192963.TestByteVect.test_unrl_init(a0);
			compiler.c2.cr7192963.TestByteVect.test_unrl_addi(a0, a1);
			compiler.c2.cr7192963.TestByteVect.test_unrl_lsai(a0, a1);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.c2.cr7192963.TestByteVect.test_init(a0);
			for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestByteVect.verify("test_init: ", i, a0[i], ((byte) (i & 3)));
			}
			compiler.c2.cr7192963.TestByteVect.test_addi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestByteVect.verify("test_addi: ", i, a0[i], ((byte) (i + (i & 3))));
			}
			compiler.c2.cr7192963.TestByteVect.test_lsai(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestByteVect.verify("test_lsai: ", i, a0[i], ((byte) (i << (i & 3))));
			}
			compiler.c2.cr7192963.TestByteVect.test_unrl_init(a0);
			for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestByteVect.verify("test_unrl_init: ", i, a0[i], ((byte) (i & 3)));
			}
			compiler.c2.cr7192963.TestByteVect.test_unrl_addi(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestByteVect.verify("test_unrl_addi: ", i, a0[i], ((byte) (i + (i & 3))));
			}
			compiler.c2.cr7192963.TestByteVect.test_unrl_lsai(a0, a1);
			for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ARRLEN; i++) {
				errn += compiler.c2.cr7192963.TestByteVect.verify("test_unrl_lsai: ", i, a0[i], ((byte) (i << (i & 3))));
			}
		}
		if (errn > 0) {
			return errn;
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ITERS; i++) {
			compiler.c2.cr7192963.TestByteVect.test_init(a0);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ITERS; i++) {
			compiler.c2.cr7192963.TestByteVect.test_addi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ITERS; i++) {
			compiler.c2.cr7192963.TestByteVect.test_lsai(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ITERS; i++) {
			compiler.c2.cr7192963.TestByteVect.test_unrl_init(a0);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ITERS; i++) {
			compiler.c2.cr7192963.TestByteVect.test_unrl_addi(a0, a1);
		}
		for (int i = 0; i < compiler.c2.cr7192963.TestByteVect.ITERS; i++) {
			compiler.c2.cr7192963.TestByteVect.test_unrl_lsai(a0, a1);
		}
		return errn;
	}

	static void test_init(byte[] a0) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((byte) (i & 3));
		}
	}

	static void test_addi(byte[] a0, byte[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((byte) (a1[i] + (i & 3)));
		}
	}

	static void test_lsai(byte[] a0, byte[] a1) {
		for (int i = 0; i < a0.length; i += 1) {
			a0[i] = ((byte) (a1[i] << (i & 3)));
		}
	}

	static void test_unrl_init(byte[] a0) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = 0;
			a0[i + 1] = 1;
			a0[i + 2] = 2;
			a0[i + 3] = 3;
		}
		for (; i < a0.length; i++) {
			a0[i] = ((byte) (i & 3));
		}
	}

	static void test_unrl_addi(byte[] a0, byte[] a1) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = ((byte) (a1[i + 0] + 0));
			a0[i + 1] = ((byte) (a1[i + 1] + 1));
			a0[i + 2] = ((byte) (a1[i + 2] + 2));
			a0[i + 3] = ((byte) (a1[i + 3] + 3));
		}
		for (; i < a0.length; i++) {
			a0[i] = ((byte) (a1[i] + (i & 3)));
		}
	}

	static void test_unrl_lsai(byte[] a0, byte[] a1) {
		int i = 0;
		for (; i < (a0.length - 4); i += 4) {
			a0[i + 0] = ((byte) (a1[i + 0] << 0));
			a0[i + 1] = ((byte) (a1[i + 1] << 1));
			a0[i + 2] = ((byte) (a1[i + 2] << 2));
			a0[i + 3] = ((byte) (a1[i + 3] << 3));
		}
		for (; i < a0.length; i++) {
			a0[i] = ((byte) (a1[i] << (i & 3)));
		}
	}

	static int verify(java.lang.String text, int i, byte elem, byte val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}