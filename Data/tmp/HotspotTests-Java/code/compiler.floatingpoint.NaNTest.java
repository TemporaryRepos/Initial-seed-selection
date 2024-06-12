public class NaNTest {
	static void testFloat() {
		int originalValue = 0x7f800001;
		int readBackValue = java.lang.Float.floatToRawIntBits(java.lang.Float.intBitsToFloat(originalValue));
		if (originalValue != readBackValue) {
			java.lang.String errorMessage = java.lang.String.format("Original and read back float values mismatch\n0x%X 0x%X\n", originalValue, readBackValue);
			throw new java.lang.RuntimeException(errorMessage);
		} else {
			java.lang.System.out.printf("Written and read back float values match\n0x%X 0x%X\n", originalValue, readBackValue);
		}
	}

	static void testDouble() {
		long originalValue = 0xfff0000000000001L;
		long readBackValue = java.lang.Double.doubleToRawLongBits(java.lang.Double.longBitsToDouble(originalValue));
		if (originalValue != readBackValue) {
			java.lang.String errorMessage = java.lang.String.format("Original and read back double values mismatch\n0x%X 0x%X\n", originalValue, readBackValue);
			throw new java.lang.RuntimeException(errorMessage);
		} else {
			java.lang.System.out.printf("Written and read back double values match\n0x%X 0x%X\n", originalValue, readBackValue);
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("### NanTest started");
		compiler.floatingpoint.NaNTest.testFloat();
		compiler.floatingpoint.NaNTest.testDouble();
		java.lang.System.out.println("### NanTest ended");
	}
}