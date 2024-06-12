public class CharactersSame {
	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.strings.CharactersSame.isAllCharactersSame("");
		assert !com.thealgorithms.strings.CharactersSame.isAllCharactersSame("aab");
		assert com.thealgorithms.strings.CharactersSame.isAllCharactersSame("aaa");
		assert com.thealgorithms.strings.CharactersSame.isAllCharactersSame("11111");
	}

	public static boolean isAllCharactersSame(java.lang.String s) {
		for (int i = 1, length = s.length(); i < length; ++i) {
			if (s.charAt(i) != s.charAt(0)) {
				return false;
			}
		}
		return true;
	}
}