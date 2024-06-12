public class Pangram {
	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.strings.Pangram.isPangram("The quick brown fox jumps over the lazy dog");
		assert !com.thealgorithms.strings.Pangram.isPangram("The quick brown fox jumps over the azy dog");
		assert !com.thealgorithms.strings.Pangram.isPangram("+-1234 This string is not alphabetical");
		assert !com.thealgorithms.strings.Pangram.isPangram("\u0000/\\");
	}

	public static boolean isPangramUsingSet(java.lang.String s) {
		java.util.HashSet<java.lang.Character> alpha = new java.util.HashSet<java.lang.Character>();
		s = s.trim().toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				alpha.add(s.charAt(i));
			}
		}
		if (alpha.size() == 26) {
			return true;
		}
		return false;
	}

	public static boolean isPangram(java.lang.String s) {
		boolean[] lettersExisting = new boolean[26];
		for (char c : s.toCharArray()) {
			int letterIndex = c - (java.lang.Character.isUpperCase(c) ? 'A' : 'a');
			if ((letterIndex >= 0) && (letterIndex < lettersExisting.length)) {
				lettersExisting[letterIndex] = true;
			}
		}
		for (boolean letterFlag : lettersExisting) {
			if (!letterFlag) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPangram2(java.lang.String s) {
		if (s.length() < 26) {
			return false;
		}
		s = s.toLowerCase();
		for (char i = 'a'; i <= 'z'; i++) {
			if (s.indexOf(i) == (-1)) {
				return false;
			}
		}
		return true;
	}
}