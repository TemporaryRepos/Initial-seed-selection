public class AnyBaseToDecimal {
	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.conversions.AnyBaseToDecimal.convertToDecimal("1010", 2) == java.lang.Integer.valueOf("1010", 2);
		assert com.thealgorithms.conversions.AnyBaseToDecimal.convertToDecimal("777", 8) == java.lang.Integer.valueOf("777", 8);
		assert com.thealgorithms.conversions.AnyBaseToDecimal.convertToDecimal("999", 10) == java.lang.Integer.valueOf("999", 10);
		assert com.thealgorithms.conversions.AnyBaseToDecimal.convertToDecimal("ABCDEF", 16) == java.lang.Integer.valueOf("ABCDEF", 16);
		assert com.thealgorithms.conversions.AnyBaseToDecimal.convertToDecimal("XYZ", 36) == java.lang.Integer.valueOf("XYZ", 36);
	}

	public static int convertToDecimal(java.lang.String s, int radix) {
		int num = 0;
		int pow = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			int digit = com.thealgorithms.conversions.AnyBaseToDecimal.valOfChar(s.charAt(i));
			if (digit >= radix) {
				throw new java.lang.NumberFormatException("For input string " + s);
			}
			num += com.thealgorithms.conversions.AnyBaseToDecimal.valOfChar(s.charAt(i)) * pow;
			pow *= radix;
		}
		return num;
	}

	public static int valOfChar(char c) {
		if (!(java.lang.Character.isUpperCase(c) || java.lang.Character.isDigit(c))) {
			throw new java.lang.NumberFormatException("invalid character :" + c);
		}
		return java.lang.Character.isDigit(c) ? c - '0' : (c - 'A') + 10;
	}
}