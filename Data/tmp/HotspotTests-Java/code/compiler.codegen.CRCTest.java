public class CRCTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		byte[] b = compiler.codegen.CRCTest.initializedBytes(4096 * 4096);
		{
			java.util.zip.CRC32 crc1 = new java.util.zip.CRC32();
			java.util.zip.CRC32 crc2 = new java.util.zip.CRC32();
			java.util.zip.CRC32 crc3 = new java.util.zip.CRC32();
			java.util.zip.CRC32 crc4 = new java.util.zip.CRC32();
			crc1.update(b, 0, b.length);
			compiler.codegen.CRCTest.updateSerial(crc2, b, 0, b.length);
			compiler.codegen.CRCTest.updateDirect(crc3, b, 0, b.length);
			compiler.codegen.CRCTest.updateSerialSlow(crc4, b, 0, b.length);
			compiler.codegen.CRCTest.check(crc1, crc2);
			compiler.codegen.CRCTest.check(crc3, crc4);
			compiler.codegen.CRCTest.check(crc1, crc3);
			crc1.update(17);
			crc2.update(17);
			crc3.update(17);
			crc4.update(17);
			crc1.update(b, 1, b.length - 2);
			compiler.codegen.CRCTest.updateSerial(crc2, b, 1, b.length - 2);
			compiler.codegen.CRCTest.updateDirect(crc3, b, 1, b.length - 2);
			compiler.codegen.CRCTest.updateSerialSlow(crc4, b, 1, b.length - 2);
			compiler.codegen.CRCTest.check(crc1, crc2);
			compiler.codegen.CRCTest.check(crc3, crc4);
			compiler.codegen.CRCTest.check(crc1, crc3);
			compiler.codegen.CRCTest.report("finished huge crc", crc1, crc2, crc3, crc4);
			for (int i = 0; i < 256; i++) {
				for (int j = 0; j < 256; j += 1) {
					crc1.update(b, i, j);
					compiler.codegen.CRCTest.updateSerial(crc2, b, i, j);
					compiler.codegen.CRCTest.updateDirect(crc3, b, i, j);
					compiler.codegen.CRCTest.updateSerialSlow(crc4, b, i, j);
					compiler.codegen.CRCTest.check(crc1, crc2);
					compiler.codegen.CRCTest.check(crc3, crc4);
					compiler.codegen.CRCTest.check(crc1, crc3);
				}
			}
			compiler.codegen.CRCTest.report("finished small survey crc", crc1, crc2, crc3, crc4);
		}
	}

	private static void report(java.lang.String s, java.util.zip.Checksum crc1, java.util.zip.Checksum crc2, java.util.zip.Checksum crc3, java.util.zip.Checksum crc4) {
		java.lang.System.out.println((((((((s + ", crc1 = ") + crc1.getValue()) + ", crc2 = ") + crc2.getValue()) + ", crc3 = ") + crc3.getValue()) + ", crc4 = ") + crc4.getValue());
	}

	private static void check(java.util.zip.Checksum crc1, java.util.zip.Checksum crc2) throws java.lang.Exception {
		if (crc1.getValue() != crc2.getValue()) {
			java.lang.String s = (("value 1 = " + crc1.getValue()) + ", value 2 = ") + crc2.getValue();
			java.lang.System.err.println(s);
			throw new java.lang.Exception(s);
		}
	}

	private static byte[] initializedBytes(int M) {
		byte[] bytes = new byte[M];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = ((byte) (i));
		}
		return bytes;
	}

	private static void updateSerial(java.util.zip.Checksum crc, byte[] b, int start, int length) {
		for (int i = 0; i < length; i++) {
			crc.update(b[i + start]);
		}
	}

	private static void updateSerialSlow(java.util.zip.Checksum crc, byte[] b, int start, int length) {
		for (int i = 0; i < length; i++) {
			crc.update(b[i + start]);
		}
		crc.getValue();
	}

	private static void updateDirect(java.util.zip.CRC32 crc3, byte[] b, int start, int length) {
		java.nio.ByteBuffer buf = java.nio.ByteBuffer.allocateDirect(length);
		buf.put(b, start, length);
		buf.flip();
		crc3.update(buf);
	}
}