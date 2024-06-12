public class Test8000805 {
	static long loadS2LmaskFF(short[] sa) {
		return sa[0] & 0xff;
	}

	static long _loadS2LmaskFF(short[] sa) {
		return sa[0] & 0xff;
	}

	static long loadS2Lmask16(short[] sa) {
		return sa[0] & 0xfffe;
	}

	static long _loadS2Lmask16(short[] sa) {
		return sa[0] & 0xfffe;
	}

	static long loadS2Lmask13(short[] sa) {
		return sa[0] & 0xfff;
	}

	static long _loadS2Lmask13(short[] sa) {
		return sa[0] & 0xfff;
	}

	static int loadUS_signExt(char[] ca) {
		return (ca[0] << 16) >> 16;
	}

	static int _loadUS_signExt(char[] ca) {
		return (ca[0] << 16) >> 16;
	}

	static long loadB2L_mask8(byte[] ba) {
		return ba[0] & 0x55;
	}

	static long _loadB2L_mask8(byte[] ba) {
		return ba[0] & 0x55;
	}

	public static void main(java.lang.String[] args) {
		for (int i = java.lang.Byte.MIN_VALUE; i < java.lang.Byte.MAX_VALUE; i++) {
			byte[] ba = new byte[]{ ((byte) (i)) };
			{
				long v1 = compiler.c2.Test8000805.loadB2L_mask8(ba);
				long v2 = compiler.c2.Test8000805._loadB2L_mask8(ba);
				if (v1 != v2) {
					throw new java.lang.InternalError(java.lang.String.format("loadB2L_mask8 failed: %x != %x", v1, v2));
				}
			}
		}
		for (int i = java.lang.Short.MIN_VALUE; i < java.lang.Short.MAX_VALUE; i++) {
			short[] sa = new short[]{ ((short) (i)) };
			char[] ca = new char[]{ ((char) (i)) };
			{
				long v1 = compiler.c2.Test8000805.loadS2LmaskFF(sa);
				long v2 = compiler.c2.Test8000805._loadS2LmaskFF(sa);
				if (v1 != v2) {
					throw new java.lang.InternalError(java.lang.String.format("loadS2LmaskFF failed: %x != %x", v1, v2));
				}
			}
			{
				long v1 = compiler.c2.Test8000805.loadS2Lmask16(sa);
				long v2 = compiler.c2.Test8000805._loadS2Lmask16(sa);
				if (v1 != v2) {
					throw new java.lang.InternalError(java.lang.String.format("loadS2Lmask16 failed: %x != %x", v1, v2));
				}
			}
			{
				long v1 = compiler.c2.Test8000805.loadS2Lmask13(sa);
				long v2 = compiler.c2.Test8000805._loadS2Lmask13(sa);
				if (v1 != v2) {
					throw new java.lang.InternalError(java.lang.String.format("loadS2Lmask13 failed: %x != %x", v1, v2));
				}
			}
			{
				int v1 = compiler.c2.Test8000805.loadUS_signExt(ca);
				int v2 = compiler.c2.Test8000805._loadUS_signExt(ca);
				if (v1 != v2) {
					throw new java.lang.InternalError(java.lang.String.format("loadUS_signExt failed: %x != %x", v1, v2));
				}
			}
		}
		java.lang.System.out.println("TEST PASSED.");
	}
}