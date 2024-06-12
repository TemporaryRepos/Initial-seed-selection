public class TestAdler32 {
	public static void main(java.lang.String[] args) {
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
			compiler.intrinsics.zip.TestAdler32.test_multi(warmupIters);
			return;
		}
		java.lang.System.out.println(" offset = " + offset);
		java.lang.System.out.println(("msgSize = " + msgSize) + " bytes");
		java.lang.System.out.println("  iters = " + iters);
		byte[] b = compiler.intrinsics.zip.TestAdler32.initializedBytes(msgSize, offset);
		java.util.zip.Adler32 adler0 = new java.util.zip.Adler32();
		java.util.zip.Adler32 adler1 = new java.util.zip.Adler32();
		java.util.zip.Adler32 adler2 = new java.util.zip.Adler32();
		adler0.update(b, offset, msgSize);
		java.lang.System.out.println("-------------------------------------------------------");
		for (int i = 0; i < warmupIters; i++) {
			adler1.reset();
			adler1.update(b, offset, msgSize);
		}
		for (int i = 0; i < iters; i++) {
			adler1.reset();
			adler1.update(b, offset, msgSize);
		}
		for (int i = 0; i < iters; i++) {
			adler1.reset();
			adler1.update(b, offset, msgSize);
			if (!compiler.intrinsics.zip.TestAdler32.check(adler0, adler1)) {
				break;
			}
		}
		compiler.intrinsics.zip.TestAdler32.report("Adlers", adler0, adler1);
		java.lang.System.out.println("-------------------------------------------------------");
		java.nio.ByteBuffer buf = java.nio.ByteBuffer.allocateDirect(msgSize);
		buf.put(b, offset, msgSize);
		buf.flip();
		for (int i = 0; i < warmupIters; i++) {
			adler2.reset();
			adler2.update(buf);
			buf.rewind();
		}
		for (int i = 0; i < iters; i++) {
			adler2.reset();
			adler2.update(buf);
			buf.rewind();
		}
		for (int i = 0; i < iters; i++) {
			adler2.reset();
			adler2.update(buf);
			buf.rewind();
			if (!compiler.intrinsics.zip.TestAdler32.check(adler0, adler2)) {
				break;
			}
		}
		compiler.intrinsics.zip.TestAdler32.report("Adlers", adler0, adler1);
		java.lang.System.out.println("-------------------------------------------------------");
	}

	private static void report(java.lang.String s, java.util.zip.Checksum adler0, java.util.zip.Checksum adler1) {
		java.lang.System.out.printf("%s: adler0 = %08x, adler1 = %08x\n", s, adler0.getValue(), adler1.getValue());
	}

	private static boolean check(java.util.zip.Checksum adler0, java.util.zip.Checksum adler1) {
		if (adler0.getValue() != adler1.getValue()) {
			java.lang.System.err.printf("ERROR: adler0 = %08x, adler1 = %08x\n", adler0.getValue(), adler1.getValue());
			return false;
		}
		return true;
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

	private static void test_multi(int iters) {
		int len1 = 8;
		int len2 = 32;
		int len3 = 4096;
		byte[] b = compiler.intrinsics.zip.TestAdler32.initializedBytes(len3 * 16, 0);
		int[] offsets = new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 16, 32, 64, 128, 256, 512 };
		int[] sizes = new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, len1, len1 + 1, len1 + 2, len1 + 3, len1 + 4, len1 + 5, len1 + 6, len1 + 7, len1 * 2, (len1 * 2) + 1, (len1 * 2) + 3, (len1 * 2) + 5, (len1 * 2) + 7, len2, len2 + 1, len2 + 3, len2 + 5, len2 + 7, len2 * 2, len2 * 4, len2 * 8, len2 * 16, len2 * 32, len2 * 64, len3, len3 + 1, len3 + 3, len3 + 5, len3 + 7, len3 * 2, len3 * 4, len3 * 8, len1 + len2, (len1 + len2) + 1, (len1 + len2) + 3, (len1 + len2) + 5, (len1 + len2) + 7, len1 + len3, (len1 + len3) + 1, (len1 + len3) + 3, (len1 + len3) + 5, (len1 + len3) + 7, len2 + len3, (len2 + len3) + 1, (len2 + len3) + 3, (len2 + len3) + 5, (len2 + len3) + 7, (len1 + len2) + len3, ((len1 + len2) + len3) + 1, ((len1 + len2) + len3) + 3, ((len1 + len2) + len3) + 5, ((len1 + len2) + len3) + 7, ((len1 + len2) + len3) * 2, (((len1 + len2) + len3) * 2) + 1, (((len1 + len2) + len3) * 2) + 3, (((len1 + len2) + len3) * 2) + 5, (((len1 + len2) + len3) * 2) + 7, ((len1 + len2) + len3) * 3, (((len1 + len2) + len3) * 3) - 1, (((len1 + len2) + len3) * 3) - 3, (((len1 + len2) + len3) * 3) - 5, (((len1 + len2) + len3) * 3) - 7 };
		java.util.zip.Adler32[] adler0 = new java.util.zip.Adler32[offsets.length * sizes.length];
		java.util.zip.Adler32[] adler1 = new java.util.zip.Adler32[offsets.length * sizes.length];
		int i;
		int j;
		int k;
		java.lang.System.out.printf("testing %d cases ...\n", offsets.length * sizes.length);
		for (i = 0; i < offsets.length; i++) {
			for (j = 0; j < sizes.length; j++) {
				adler0[(i * sizes.length) + j] = new java.util.zip.Adler32();
				adler1[(i * sizes.length) + j] = new java.util.zip.Adler32();
				adler0[(i * sizes.length) + j].update(b, offsets[i], sizes[j]);
			}
		}
		for (k = 0; k < iters; k++) {
			for (i = 0; i < offsets.length; i++) {
				for (j = 0; j < sizes.length; j++) {
					adler1[(i * sizes.length) + j].reset();
					adler1[(i * sizes.length) + j].update(b, offsets[i], sizes[j]);
				}
			}
		}
		for (i = 0; i < offsets.length; i++) {
			for (j = 0; j < sizes.length; j++) {
				if (!compiler.intrinsics.zip.TestAdler32.check(adler0[(i * sizes.length) + j], adler1[(i * sizes.length) + j])) {
					java.lang.System.out.printf("offsets[%d] = %d", i, offsets[i]);
					java.lang.System.out.printf("\tsizes[%d] = %d\n", j, sizes[j]);
				}
			}
		}
	}
}