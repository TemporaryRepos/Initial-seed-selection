public class ByteSwap {
	public static void main(java.lang.String[] args) {
		if (java.lang.Short.reverseBytes(((short) (0xaabb))) != ((short) (0xbbaa))) {
			throw new java.lang.RuntimeException("short");
		}
		if (java.lang.Character.reverseBytes(((char) (0xaabb))) != ((char) (0xbbaa))) {
			throw new java.lang.RuntimeException("char");
		}
	}
}