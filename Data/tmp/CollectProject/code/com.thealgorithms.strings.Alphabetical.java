class Alphabetical {
	public static void main(java.lang.String[] args) {
		assert !com.thealgorithms.strings.Alphabetical.isAlphabetical("123abc");
		assert com.thealgorithms.strings.Alphabetical.isAlphabetical("aBC");
		assert com.thealgorithms.strings.Alphabetical.isAlphabetical("abc");
		assert !com.thealgorithms.strings.Alphabetical.isAlphabetical("xyzabc");
		assert com.thealgorithms.strings.Alphabetical.isAlphabetical("abcxyz");
	}

	public static boolean isAlphabetical(java.lang.String s) {
		s = s.toLowerCase();
		for (int i = 0; i < (s.length() - 1); ++i) {
			if ((!java.lang.Character.isLetter(s.charAt(i))) || (!(s.charAt(i) <= s.charAt(i + 1)))) {
				return false;
			}
		}
		return true;
	}
}