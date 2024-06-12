public class TestCharShortByteSwap {
	private static short initShort(java.lang.String[] args, short v) {
		if (args.length > 0) {
			try {
				return ((short) (java.lang.Integer.valueOf(args[0]).intValue()));
			} catch (java.lang.NumberFormatException e) {
			}
		}
		return v;
	}

	private static char initChar(java.lang.String[] args, char v) {
		if (args.length > 0) {
			try {
				return ((char) (java.lang.Integer.valueOf(args[0]).intValue()));
			} catch (java.lang.NumberFormatException e) {
			}
		}
		return v;
	}

	private static void testChar(char a, char b) {
		if (a != java.lang.Character.reverseBytes(b)) {
			throw new java.lang.RuntimeException(((("FAIL: " + ((int) (a))) + " != Character.reverseBytes(") + ((int) (b))) + ")");
		}
		if (b != java.lang.Character.reverseBytes(a)) {
			throw new java.lang.RuntimeException(((("FAIL: " + ((int) (b))) + " != Character.reverseBytes(") + ((int) (a))) + ")");
		}
	}

	private static void testShort(short a, short b) {
		if (a != java.lang.Short.reverseBytes(b)) {
			throw new java.lang.RuntimeException(((("FAIL: " + ((int) (a))) + " != Short.reverseBytes(") + ((int) (b))) + ")");
		}
		if (b != java.lang.Short.reverseBytes(a)) {
			throw new java.lang.RuntimeException(((("FAIL: " + ((int) (b))) + " != Short.reverseBytes(") + ((int) (a))) + ")");
		}
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 100000; ++i) {
			char c1 = compiler.c2.TestCharShortByteSwap.initChar(args, ((char) (0x123)));
			char c2 = compiler.c2.TestCharShortByteSwap.initChar(args, ((char) (0x2301)));
			char c3 = compiler.c2.TestCharShortByteSwap.initChar(args, ((char) (0xaabb)));
			char c4 = compiler.c2.TestCharShortByteSwap.initChar(args, ((char) (0xbbaa)));
			short s1 = compiler.c2.TestCharShortByteSwap.initShort(args, ((short) (0x123)));
			short s2 = compiler.c2.TestCharShortByteSwap.initShort(args, ((short) (0x2301)));
			short s3 = compiler.c2.TestCharShortByteSwap.initShort(args, ((short) (0xaabb)));
			short s4 = compiler.c2.TestCharShortByteSwap.initShort(args, ((short) (0xbbaa)));
			compiler.c2.TestCharShortByteSwap.testChar(c1, c2);
			compiler.c2.TestCharShortByteSwap.testChar(c3, c4);
			compiler.c2.TestCharShortByteSwap.testShort(s1, s2);
			compiler.c2.TestCharShortByteSwap.testShort(s3, s4);
		}
	}
}