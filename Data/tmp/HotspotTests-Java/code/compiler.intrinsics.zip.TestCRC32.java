public class TestCRC32 {
	static final long polyBits = ((((((((((((((1L << (32 - 32)) + (1L << (32 - 26))) + (1L << (32 - 23))) + (1L << (32 - 22))) + (1L << (32 - 16))) + (1L << (32 - 12))) + (1L << (32 - 11))) + (1L << (32 - 10))) + (1L << (32 - 8))) + (1L << (32 - 7))) + (1L << (32 - 5))) + (1L << (32 - 4))) + (1L << (32 - 2))) + (1L << (32 - 1))) + (1L << (32 - 0));

	static final long polyBitsShifted = compiler.intrinsics.zip.TestCRC32.polyBits >> 1;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int offset = java.lang.Integer.getInteger("offset", 0);
		int msgSize = java.lang.Integer.getInteger("msgSize", 512);
		boolean multi = false;
		int iters = 20000;
		int warmupIters = 20000;
		if (args.length > 0) {
			if (args[0].equals("-m")) {
				multi = true;
			} else {
				iters = java.lang.Integer.valueOf(args[0]);
			}
			if (args.length > 1) {
				warmupIters = java.lang.Integer.valueOf(args[1]);
			}
		}
		if (multi) {
			compiler.intrinsics.zip.TestCRC32.test_multi(warmupIters);
			return;
		}
		java.lang.System.out.println(" offset = " + offset);
		java.lang.System.out.println(("msgSize = " + msgSize) + " bytes");
		java.lang.System.out.println("  iters = " + iters);
		byte[] b = compiler.intrinsics.zip.TestCRC32.initializedBytes(msgSize, offset);
		final long crcReference = compiler.intrinsics.zip.TestCRC32.update_byteLoop(0, b, offset);
		java.util.zip.CRC32 crc0 = new java.util.zip.CRC32();
		java.util.zip.CRC32 crc1 = new java.util.zip.CRC32();
		java.util.zip.CRC32 crc2 = new java.util.zip.CRC32();
		crc0.update(b, offset, msgSize);
		compiler.intrinsics.zip.TestCRC32.check(crc0, crcReference);
		java.lang.System.out.println("-------------------------------------------------------");
		for (int i = 0; i < warmupIters; i++) {
			crc1.reset();
			crc1.update(b, offset, msgSize);
			compiler.intrinsics.zip.TestCRC32.check(crc1, crcReference);
		}
		for (int i = 0; i < iters; i++) {
			crc1.reset();
			crc1.update(b, offset, msgSize);
			compiler.intrinsics.zip.TestCRC32.check(crc1, crcReference);
		}
		compiler.intrinsics.zip.TestCRC32.report("CRCs", crc1, crcReference);
		for (int i = 0; i < iters; i++) {
			crc1.reset();
			crc1.update(b, offset, msgSize);
		}
		compiler.intrinsics.zip.TestCRC32.report("CRCs", crc1, crcReference);
		java.lang.System.out.println("-------------------------------------------------------");
		java.nio.ByteBuffer buf = java.nio.ByteBuffer.allocateDirect(msgSize);
		buf.put(b, offset, msgSize);
		buf.flip();
		for (int i = 0; i < warmupIters; i++) {
			crc2.reset();
			crc2.update(buf);
			buf.rewind();
			compiler.intrinsics.zip.TestCRC32.check(crc2, crcReference);
		}
		for (int i = 0; i < iters; i++) {
			crc2.reset();
			crc2.update(buf);
			buf.rewind();
			compiler.intrinsics.zip.TestCRC32.check(crc2, crcReference);
		}
		compiler.intrinsics.zip.TestCRC32.report("CRCs", crc2, crcReference);
		for (int i = 0; i < iters; i++) {
			crc2.reset();
			crc2.update(buf);
			buf.rewind();
		}
		compiler.intrinsics.zip.TestCRC32.report("CRCs", crc2, crcReference);
		java.lang.System.out.println("-------------------------------------------------------");
	}

	public static long update_byteLoop(long crc, byte[] buf, int offset) {
		return compiler.intrinsics.zip.TestCRC32.update_byteLoop(crc, buf, offset, buf.length - offset);
	}

	public static long update_byteLoop(long crc, byte[] buf, int offset, int length) {
		int end = length + offset;
		for (int i = offset; i < end; i++) {
			crc = compiler.intrinsics.zip.TestCRC32.update_singlebyte(crc, compiler.intrinsics.zip.TestCRC32.polyBitsShifted, buf[i]);
		}
		return crc;
	}

	public static long update_singlebyte(long crc, long polynomial, int val) {
		crc = (crc ^ (-1L)) & 0xffffffffL;
		crc = crc ^ (val & 0xff);
		for (int i = 0; i < 8; i++) {
			boolean bitset = (crc & 0x1L) != 0;
			crc = crc >> 1;
			if (bitset) {
				crc = crc ^ polynomial;
				crc = crc & 0xffffffffL;
			}
		}
		crc = (crc ^ (-1L)) & 0xffffffffL;
		return crc;
	}

	private static void report(java.lang.String s, java.util.zip.Checksum crc, long crcReference) {
		java.lang.System.out.printf("%s: crc = %08x, crcReference = %08x\n", s, crc.getValue(), crcReference);
	}

	private static void check(java.util.zip.Checksum crc, long crcReference) throws java.lang.Exception {
		if (crc.getValue() != crcReference) {
			java.lang.System.err.printf("ERROR: crc = %08x, crcReference = %08x\n", crc.getValue(), crcReference);
			throw new java.lang.Exception("TestCRC32 Error");
		}
	}

	private static byte[] initializedBytes(int M, int offset) {
		byte[] bytes = new byte[M + offset];
		for (int i = 0; i < offset; i++) {
			bytes[i] = ((byte) (i));
		}
		for (int i = offset; i < bytes.length; i++) {
			bytes[i] = ((byte) (i - offset));
		}
		return bytes;
	}

	private static void test_multi(int iters) throws java.lang.Exception {
		int len1 = 8;
		int len2 = 32;
		int len3 = 4096;
		byte[] b = compiler.intrinsics.zip.TestCRC32.initializedBytes(len3 * 16, 0);
		int[] offsets = new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 16, 32, 64, 128, 256, 512 };
		int[] sizes = new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, len1, len1 + 1, len1 + 2, len1 + 3, len1 + 4, len1 + 5, len1 + 6, len1 + 7, len1 * 2, (len1 * 2) + 1, (len1 * 2) + 3, (len1 * 2) + 5, (len1 * 2) + 7, len2, len2 + 1, len2 + 3, len2 + 5, len2 + 7, len2 * 2, len2 * 4, len2 * 8, len2 * 16, len2 * 32, len2 * 64, len3, len3 + 1, len3 + 3, len3 + 5, len3 + 7, len3 * 2, len3 * 4, len3 * 8, len1 + len2, (len1 + len2) + 1, (len1 + len2) + 3, (len1 + len2) + 5, (len1 + len2) + 7, len1 + len3, (len1 + len3) + 1, (len1 + len3) + 3, (len1 + len3) + 5, (len1 + len3) + 7, len2 + len3, (len2 + len3) + 1, (len2 + len3) + 3, (len2 + len3) + 5, (len2 + len3) + 7, (len1 + len2) + len3, ((len1 + len2) + len3) + 1, ((len1 + len2) + len3) + 3, ((len1 + len2) + len3) + 5, ((len1 + len2) + len3) + 7, ((len1 + len2) + len3) * 2, (((len1 + len2) + len3) * 2) + 1, (((len1 + len2) + len3) * 2) + 3, (((len1 + len2) + len3) * 2) + 5, (((len1 + len2) + len3) * 2) + 7, ((len1 + len2) + len3) * 3, (((len1 + len2) + len3) * 3) - 1, (((len1 + len2) + len3) * 3) - 3, (((len1 + len2) + len3) * 3) - 5, (((len1 + len2) + len3) * 3) - 7 };
		java.util.zip.CRC32[] crc1 = new java.util.zip.CRC32[offsets.length * sizes.length];
		long[] crcReference = new long[offsets.length * sizes.length];
		int i;
		int j;
		int k;
		java.lang.System.out.printf("testing %d cases ...\n", offsets.length * sizes.length);
		for (i = 0; i < offsets.length; i++) {
			for (j = 0; j < sizes.length; j++) {
				crc1[(i * sizes.length) + j] = new java.util.zip.CRC32();
				crcReference[(i * sizes.length) + j] = compiler.intrinsics.zip.TestCRC32.update_byteLoop(0, b, offsets[i], sizes[j]);
			}
		}
		for (k = 0; k < iters; k++) {
			for (i = 0; i < offsets.length; i++) {
				for (j = 0; j < sizes.length; j++) {
					crc1[(i * sizes.length) + j].reset();
					crc1[(i * sizes.length) + j].update(b, offsets[i], sizes[j]);
					compiler.intrinsics.zip.TestCRC32.check(crc1[(i * sizes.length) + j], crcReference[(i * sizes.length) + j]);
				}
			}
		}
	}
}