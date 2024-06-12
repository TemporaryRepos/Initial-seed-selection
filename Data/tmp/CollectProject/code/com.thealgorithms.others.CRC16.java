public class CRC16 {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.thealgorithms.others.CRC16.crc16("Hello World!"));
	}

	public static java.lang.String crc16(java.lang.String message) {
		int crc = 0xffff;
		int polynomial = 0x1021;
		byte[] bytes = message.getBytes();
		for (byte b : bytes) {
			for (int i = 0; i < 8; i++) {
				boolean bit = ((b >> (7 - i)) & 1) == 1;
				boolean c15 = ((crc >> 15) & 1) == 1;
				crc <<= 1;
				if (c15 ^ bit) {
					crc ^= polynomial;
				}
			}
		}
		crc &= 0xffff;
		return java.lang.Integer.toHexString(crc).toUpperCase();
	}
}