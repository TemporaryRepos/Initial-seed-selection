public class Upper {
	public static void main(java.lang.String[] args) {
		java.lang.String[] strings = new java.lang.String[]{ "ABC", "ABC123", "abcABC", "abc123ABC" };
		for (java.lang.String s : strings) {
			assert com.thealgorithms.strings.Upper.toUpperCase(s).equals(s.toUpperCase());
		}
	}

	public static java.lang.String toUpperCase(java.lang.String s) {
		if ((s == null) || "".equals(s)) {
			return s;
		}
		char[] values = s.toCharArray();
		for (int i = 0; i < values.length; ++i) {
			if (java.lang.Character.isLetter(values[i]) && java.lang.Character.isLowerCase(values[i])) {
				values[i] = java.lang.Character.toUpperCase(values[i]);
			}
		}
		return new java.lang.String(values);
	}
}