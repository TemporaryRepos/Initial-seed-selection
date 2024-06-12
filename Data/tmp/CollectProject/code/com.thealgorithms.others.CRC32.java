public class CRC32 {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(java.lang.Integer.toHexString(com.thealgorithms.others.CRC32.crc32("Hello World")));
	}

	public static int crc32(java.lang.String str) {
		return com.thealgorithms.others.CRC32.crc32(str.getBytes());
	}

	public static int crc32(byte[] data) {
		java.util.BitSet bitSet = java.util.BitSet.valueOf(data);
		int crc32 = 0xffffffff;
		for (int i = 0; i < (data.length * 8); i++) {
			if (((crc32 >>> 31) & 1) != (bitSet.get(i) ? 1 : 0)) {
				crc32 = (crc32 << 1) ^ 0x4c11db7;
			} else {
				crc32 = crc32 << 1;
			}
		}
		crc32 = java.lang.Integer.reverse(crc32);
		return crc32 ^ 0xffffffff;
	}
}