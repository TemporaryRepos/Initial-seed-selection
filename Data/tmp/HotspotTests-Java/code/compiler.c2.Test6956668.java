public class Test6956668 {
	public static int bitTest() {
		int result = 0;
		int testValue = 73;
		int bitCount = java.lang.Integer.bitCount(testValue);
		if (testValue != 0) {
			int gap = java.lang.Long.numberOfTrailingZeros(testValue);
			testValue >>>= gap;
			while (testValue != 0) {
				result++;
				if ((testValue ^= 0x1) != 0) {
					gap = java.lang.Long.numberOfTrailingZeros(testValue);
					testValue >>>= gap;
				}
			} 
		}
		if (bitCount != result) {
			java.lang.System.out.println((("ERROR: " + bitCount) + " != ") + result);
			java.lang.System.exit(97);
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 100000; i++) {
			int ct = compiler.c2.Test6956668.bitTest();
		}
	}
}