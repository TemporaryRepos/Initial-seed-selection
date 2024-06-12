public class HexaDecimalToBinary {
	private final int LONG_BITS = 8;

	public java.lang.String convert(java.lang.String numHex) {
		int conHex = java.lang.Integer.parseInt(numHex, 16);
		java.lang.String binary = java.lang.Integer.toBinaryString(conHex);
		return completeDigits(binary);
	}

	public java.lang.String completeDigits(java.lang.String binNum) {
		for (int i = binNum.length(); i < LONG_BITS; i++) {
			binNum = "0" + binNum;
		}
		return binNum;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String[] hexNums = new java.lang.String[]{ "1", "A1", "ef", "BA", "AA", "BB", "19", "01", "02", "03", "04" };
		com.thealgorithms.conversions.HexaDecimalToBinary objConvert = new com.thealgorithms.conversions.HexaDecimalToBinary();
		for (java.lang.String num : hexNums) {
			java.lang.System.out.println((num + " = ") + objConvert.convert(num));
		}
	}
}