public class IntegerToRoman {
	private static int[] allArabianRomanNumbers = new int[]{ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	private static java.lang.String[] allRomanNumbers = new java.lang.String[]{ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public static java.lang.String integerToRoman(int num) {
		if (num <= 0) {
			return "";
		}
		java.lang.StringBuilder builder = new java.lang.StringBuilder();
		for (int a = 0; a < com.thealgorithms.conversions.IntegerToRoman.allArabianRomanNumbers.length; a++) {
			int times = num / com.thealgorithms.conversions.IntegerToRoman.allArabianRomanNumbers[a];
			for (int b = 0; b < times; b++) {
				builder.append(com.thealgorithms.conversions.IntegerToRoman.allRomanNumbers[a]);
			}
			num -= times * com.thealgorithms.conversions.IntegerToRoman.allArabianRomanNumbers[a];
		}
		return builder.toString();
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.thealgorithms.conversions.IntegerToRoman.integerToRoman(2131));
	}
}