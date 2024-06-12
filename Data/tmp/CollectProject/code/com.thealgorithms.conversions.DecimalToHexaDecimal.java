class DecimalToHexaDecimal {
	private static final int sizeOfIntInHalfBytes = 8;

	private static final int numberOfBitsInAHalfByte = 4;

	private static final int halfByte = 0xf;

	private static final char[] hexDigits = new char[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static java.lang.String decToHex(int dec) {
		java.lang.StringBuilder hexBuilder = new java.lang.StringBuilder(com.thealgorithms.conversions.DecimalToHexaDecimal.sizeOfIntInHalfBytes);
		hexBuilder.setLength(com.thealgorithms.conversions.DecimalToHexaDecimal.sizeOfIntInHalfBytes);
		for (int i = com.thealgorithms.conversions.DecimalToHexaDecimal.sizeOfIntInHalfBytes - 1; i >= 0; --i) {
			int j = dec & com.thealgorithms.conversions.DecimalToHexaDecimal.halfByte;
			hexBuilder.setCharAt(i, com.thealgorithms.conversions.DecimalToHexaDecimal.hexDigits[j]);
			dec >>= com.thealgorithms.conversions.DecimalToHexaDecimal.numberOfBitsInAHalfByte;
		}
		return hexBuilder.toString().toLowerCase();
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Test...");
		int dec = 305445566;
		java.lang.String libraryDecToHex = java.lang.Integer.toHexString(dec);
		java.lang.String decToHex = com.thealgorithms.conversions.DecimalToHexaDecimal.decToHex(dec);
		java.lang.System.out.println("Result from the library : " + libraryDecToHex);
		java.lang.System.out.println("Result decToHex method : " + decToHex);
	}
}