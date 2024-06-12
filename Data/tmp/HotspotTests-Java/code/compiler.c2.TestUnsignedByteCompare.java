public class TestUnsignedByteCompare {
	static int p;

	static int n;

	static void report(byte[] ba, int i, boolean failed) {
	}

	static void m1(byte[] ba) {
		for (int i = 0; i < ba.length; i++) {
			if ((ba[i] & 0xff) < 0x10) {
				compiler.c2.TestUnsignedByteCompare.p++;
				compiler.c2.TestUnsignedByteCompare.report(ba, i, true);
			} else {
				compiler.c2.TestUnsignedByteCompare.n++;
				compiler.c2.TestUnsignedByteCompare.report(ba, i, false);
			}
		}
	}

	static void m2(byte[] ba) {
		for (int i = 0; i < ba.length; i++) {
			if (((ba[i] & 0xff) & 0x80) < 0) {
				compiler.c2.TestUnsignedByteCompare.p++;
				compiler.c2.TestUnsignedByteCompare.report(ba, i, true);
			} else {
				compiler.c2.TestUnsignedByteCompare.n++;
				compiler.c2.TestUnsignedByteCompare.report(ba, i, false);
			}
		}
	}

	public static void main(java.lang.String[] args) {
		final int tries = 1000;
		final int count = 1000;
		byte[] ba = new byte[count];
		for (int i = 0; i < count; i++) {
			int v = -((i % 126) + 1);
			ba[i] = ((byte) (v));
		}
		for (int t = 0; t < tries; t++) {
			compiler.c2.TestUnsignedByteCompare.m1(ba);
			if (compiler.c2.TestUnsignedByteCompare.p != 0) {
				throw new java.lang.IllegalStateException((("m1 error: p = " + compiler.c2.TestUnsignedByteCompare.p) + ", n = ") + compiler.c2.TestUnsignedByteCompare.n);
			}
		}
		for (int t = 0; t < tries; t++) {
			compiler.c2.TestUnsignedByteCompare.m2(ba);
			if (compiler.c2.TestUnsignedByteCompare.p != 0) {
				throw new java.lang.IllegalStateException((("m2 error: p = " + compiler.c2.TestUnsignedByteCompare.p) + ", n = ") + compiler.c2.TestUnsignedByteCompare.n);
			}
		}
	}
}