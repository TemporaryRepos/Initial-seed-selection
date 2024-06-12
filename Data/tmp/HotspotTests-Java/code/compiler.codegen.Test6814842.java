public class Test6814842 {
	static final short[] sa = new short[]{ ((short) (0xf1f2)) };

	static final char[] ca = new char[]{ ((char) (0xf3f4)) };

	static final int[] ia = new int[]{ 0xf1f2f3f4 };

	public static void main(java.lang.String[] args) {
		byte s2b = compiler.codegen.Test6814842.loadS2B(compiler.codegen.Test6814842.sa);
		if (s2b != ((byte) (0xf2))) {
			throw new java.lang.InternalError((("loadS2B failed: " + s2b) + " != ") + ((byte) (0xf2)));
		}
		byte s2bmask255 = compiler.codegen.Test6814842.loadS2Bmask255(compiler.codegen.Test6814842.sa);
		if (s2bmask255 != ((byte) (0xf2))) {
			throw new java.lang.InternalError((("loadS2Bmask255 failed: " + s2bmask255) + " != ") + ((byte) (0xf2)));
		}
		byte us2b = compiler.codegen.Test6814842.loadUS2B(compiler.codegen.Test6814842.ca);
		if (us2b != ((byte) (0xf4))) {
			throw new java.lang.InternalError((("loadUS2B failed: " + us2b) + " != ") + ((byte) (0xf4)));
		}
		byte us2bmask255 = compiler.codegen.Test6814842.loadUS2Bmask255(compiler.codegen.Test6814842.ca);
		if (us2bmask255 != ((byte) (0xf4))) {
			throw new java.lang.InternalError((("loadUS2Bmask255 failed: " + us2bmask255) + " != ") + ((byte) (0xf4)));
		}
		byte i2b = compiler.codegen.Test6814842.loadI2B(compiler.codegen.Test6814842.ia);
		if (i2b != ((byte) (0xf4))) {
			throw new java.lang.InternalError((("loadI2B failed: " + i2b) + " != ") + ((byte) (0xf4)));
		}
		byte i2bmask255 = compiler.codegen.Test6814842.loadI2Bmask255(compiler.codegen.Test6814842.ia);
		if (i2bmask255 != ((byte) (0xf4))) {
			throw new java.lang.InternalError((("loadI2Bmask255 failed: " + i2bmask255) + " != ") + ((byte) (0xf4)));
		}
		short i2s = compiler.codegen.Test6814842.loadI2S(compiler.codegen.Test6814842.ia);
		if (i2s != ((short) (0xf3f4))) {
			throw new java.lang.InternalError((("loadI2S failed: " + i2s) + " != ") + ((short) (0xf3f4)));
		}
		short i2smask255 = compiler.codegen.Test6814842.loadI2Smask255(compiler.codegen.Test6814842.ia);
		if (i2smask255 != ((short) (0xf4))) {
			throw new java.lang.InternalError((("loadI2Smask255 failed: " + i2smask255) + " != ") + ((short) (0xf4)));
		}
		short i2smask65535 = compiler.codegen.Test6814842.loadI2Smask65535(compiler.codegen.Test6814842.ia);
		if (i2smask65535 != ((short) (0xf3f4))) {
			throw new java.lang.InternalError((("loadI2Smask65535 failed: " + i2smask65535) + " != ") + ((short) (0xf3f4)));
		}
		char i2us = compiler.codegen.Test6814842.loadI2US(compiler.codegen.Test6814842.ia);
		if (i2us != ((char) (0xf3f4))) {
			throw new java.lang.InternalError((("loadI2US failed: " + ((int) (i2us))) + " != ") + ((char) (0xf3f4)));
		}
		char i2usmask255 = compiler.codegen.Test6814842.loadI2USmask255(compiler.codegen.Test6814842.ia);
		if (i2usmask255 != ((char) (0xf4))) {
			throw new java.lang.InternalError((("loadI2USmask255 failed: " + ((int) (i2usmask255))) + " != ") + ((char) (0xf4)));
		}
		char i2usmask65535 = compiler.codegen.Test6814842.loadI2USmask65535(compiler.codegen.Test6814842.ia);
		if (i2usmask65535 != ((char) (0xf3f4))) {
			throw new java.lang.InternalError((("loadI2USmask65535 failed: " + ((int) (i2usmask65535))) + " != ") + ((char) (0xf3f4)));
		}
	}

	static byte loadS2B(short[] sa) {
		return ((byte) (sa[0]));
	}

	static byte loadS2Bmask255(short[] sa) {
		return ((byte) (sa[0] & 0xff));
	}

	static byte loadUS2B(char[] ca) {
		return ((byte) (ca[0]));
	}

	static byte loadUS2Bmask255(char[] ca) {
		return ((byte) (ca[0] & 0xff));
	}

	static byte loadI2B(int[] ia) {
		return ((byte) (ia[0]));
	}

	static byte loadI2Bmask255(int[] ia) {
		return ((byte) (ia[0] & 0xff));
	}

	static short loadI2S(int[] ia) {
		return ((short) (ia[0]));
	}

	static short loadI2Smask255(int[] ia) {
		return ((short) (ia[0] & 0xff));
	}

	static short loadI2Smask65535(int[] ia) {
		return ((short) (ia[0] & 0xffff));
	}

	static char loadI2US(int[] ia) {
		return ((char) (ia[0]));
	}

	static char loadI2USmask255(int[] ia) {
		return ((char) (ia[0] & 0xff));
	}

	static char loadI2USmask65535(int[] ia) {
		return ((char) (ia[0] & 0xffff));
	}
}