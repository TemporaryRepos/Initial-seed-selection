public class Lower {
	public static void main(java.lang.String[] args) {
		java.lang.String[] strings = new java.lang.String[]{ "ABC", "ABC123", "abcABC", "abc123ABC" };
		for (java.lang.String s : strings) {
			assert com.thealgorithms.strings.Lower.toLowerCase(s).equals(s.toLowerCase());
		}
	}

	public static java.lang.String toLowerCase(java.lang.String s) {
		char[] values = s.toCharArray();
		for (int i = 0; i < values.length; ++i) {
			if (java.lang.Character.isLetter(values[i]) && java.lang.Character.isUpperCase(values[i])) {
				values[i] = java.lang.Character.toLowerCase(values[i]);
			}
		}
		return new java.lang.String(values);
	}
}