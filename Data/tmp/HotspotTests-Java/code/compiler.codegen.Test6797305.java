public class Test6797305 {
	static final byte[] ba = new byte[]{ -1 };

	static final short[] sa = new short[]{ -1 };

	static final int[] ia = new int[]{ -1 };

	static final long[] la = new long[]{ -1 };

	public static void main(java.lang.String[] args) {
		long b = compiler.codegen.Test6797305.loadB(compiler.codegen.Test6797305.ba);
		if (b != (-1)) {
			throw new java.lang.InternalError((("loadB failed: " + b) + " != ") + (-1));
		}
		long b2l = compiler.codegen.Test6797305.loadB2L(compiler.codegen.Test6797305.ba);
		if (b2l != (-1L)) {
			throw new java.lang.InternalError((("loadB2L failed: " + b2l) + " != ") + (-1L));
		}
		int ub = compiler.codegen.Test6797305.loadUB(compiler.codegen.Test6797305.ba);
		if (ub != 0xff) {
			throw new java.lang.InternalError((("loadUB failed: " + ub) + " != ") + 0xff);
		}
		int ubmask = compiler.codegen.Test6797305.loadUBmask(compiler.codegen.Test6797305.ba);
		if (ubmask != 0xfe) {
			throw new java.lang.InternalError((("loadUBmask failed: " + ubmask) + " != ") + 0xfe);
		}
		long ub2l = compiler.codegen.Test6797305.loadUB2L(compiler.codegen.Test6797305.ba);
		if (ub2l != 0xffL) {
			throw new java.lang.InternalError((("loadUB2L failed: " + ub2l) + " != ") + 0xffL);
		}
		int s = compiler.codegen.Test6797305.loadS(compiler.codegen.Test6797305.sa);
		if (s != (-1)) {
			throw new java.lang.InternalError((("loadS failed: " + s) + " != ") + (-1));
		}
		long s2l = compiler.codegen.Test6797305.loadS2L(compiler.codegen.Test6797305.sa);
		if (s2l != (-1L)) {
			throw new java.lang.InternalError((("loadS2L failed: " + s2l) + " != ") + (-1L));
		}
		int us = compiler.codegen.Test6797305.loadUS(compiler.codegen.Test6797305.sa);
		if (us != 0xffff) {
			throw new java.lang.InternalError((("loadUS failed: " + us) + " != ") + 0xffff);
		}
		int usmask = compiler.codegen.Test6797305.loadUSmask(compiler.codegen.Test6797305.sa);
		if (usmask != 0xfffe) {
			throw new java.lang.InternalError((("loadUBmask failed: " + ubmask) + " != ") + 0xfffe);
		}
		long us2l = compiler.codegen.Test6797305.loadUS2L(compiler.codegen.Test6797305.sa);
		if (us2l != 0xffffL) {
			throw new java.lang.InternalError((("loadUS2L failed: " + us2l) + " != ") + 0xffffL);
		}
		int i = compiler.codegen.Test6797305.loadI(compiler.codegen.Test6797305.ia);
		if (i != (-1)) {
			throw new java.lang.InternalError((("loadI failed: " + i) + " != ") + (-1));
		}
		long i2l = compiler.codegen.Test6797305.loadI2L(compiler.codegen.Test6797305.ia);
		if (i2l != (-1L)) {
			throw new java.lang.InternalError((("loadI2L failed: " + i2l) + " != ") + (-1L));
		}
		long ui2l = compiler.codegen.Test6797305.loadUI2L(compiler.codegen.Test6797305.ia);
		if (ui2l != 0xffffffffL) {
			throw new java.lang.InternalError((("loadUI2L failed: " + ui2l) + " != ") + 0xffffffffL);
		}
		long l = compiler.codegen.Test6797305.loadL(compiler.codegen.Test6797305.la);
		if (l != (-1L)) {
			throw new java.lang.InternalError((("loadL failed: " + l) + " != ") + (-1L));
		}
	}

	static int loadB(byte[] ba) {
		return ba[0];
	}

	static long loadB2L(byte[] ba) {
		return ba[0];
	}

	static int loadUB(byte[] ba) {
		return ba[0] & 0xff;
	}

	static int loadUBmask(byte[] ba) {
		return ba[0] & 0xfe;
	}

	static long loadUB2L(byte[] ba) {
		return ba[0] & 0xff;
	}

	static int loadS(short[] sa) {
		return sa[0];
	}

	static long loadS2L(short[] sa) {
		return sa[0];
	}

	static int loadUS(short[] sa) {
		return sa[0] & 0xffff;
	}

	static int loadUSmask(short[] sa) {
		return sa[0] & 0xfffe;
	}

	static long loadUS2L(short[] sa) {
		return sa[0] & 0xffff;
	}

	static int loadI(int[] ia) {
		return ia[0];
	}

	static long loadI2L(int[] ia) {
		return ia[0];
	}

	static long loadUI2L(int[] ia) {
		return ia[0] & 0xffffffffL;
	}

	static long loadL(long[] la) {
		return la[0];
	}
}