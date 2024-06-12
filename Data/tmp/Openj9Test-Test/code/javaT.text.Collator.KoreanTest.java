public class KoreanTest {
	static final java.lang.String[][] compData1 = new java.lang.String[][]{ new java.lang.String[]{ "고양이", "猫", "Hangul \"Cat\"(0xACE0 0xC591 0xC774) <---> Chinese Kanji \"Cat\"(0x732B)" }, new java.lang.String[]{ "・", "‥", "Katakana middle dot(0x30FB) <---> Two dot leader(0x2025)" }, new java.lang.String[]{ "±", "≠", "Plus-Minus Sign(0x00B1) <---> Not Equal To(0x2260)" }, new java.lang.String[]{ "】", "≠", "Right Black Lenticular Bracket(0x3011) <---> Not Equal To(0x2260)" }, new java.lang.String[]{ "≠", "℃", "Not Equal To(0x2260) <---> Degree Celsius(0x2103)" }, new java.lang.String[]{ "≠", "☆", "Not Equal To(0x2260) <---> White Star(0x2606)" } };

	static final java.lang.String[][] compData2 = new java.lang.String[][]{ new java.lang.String[]{ "福", "福", "CJK Unified Ideograph \"FUKU\"(0x798F) <---> CJK Compatibility Ideograph \"FUKU\"(0xFA1B)" } };

	java.text.Collator col = java.text.Collator.getInstance(java.util.Locale.KOREA);

	int result = 0;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.KoreanTest().run();
	}

	public void run() {
		doCompare(javaT.text.Collator.KoreanTest.compData1);
		doEquals(javaT.text.Collator.KoreanTest.compData2);
		col.setStrength(java.text.Collator.SECONDARY);
		doCompare(javaT.text.Collator.KoreanTest.compData1);
		doEquals(javaT.text.Collator.KoreanTest.compData2);
		col.setStrength(java.text.Collator.PRIMARY);
		doCompare(javaT.text.Collator.KoreanTest.compData1);
		doEquals(javaT.text.Collator.KoreanTest.compData2);
		if (result != 0) {
			throw new java.lang.RuntimeException("Unexpected results on Korean collation.");
		}
	}

	void doCompare(java.lang.String[][] s) {
		int value;
		for (int i = 0; i < s.length; i++) {
			if ((value = col.compare(s[i][0], s[i][1])) > (-1)) {
				result++;
				java.lang.System.err.println(((("TERTIARY: The first string should be less than the second string:  " + s[i][2]) + "  compare() returned ") + value) + ".");
			}
		}
	}

	void doEquals(java.lang.String[][] s) {
		for (int i = 0; i < s.length; i++) {
			if (!col.equals(s[i][0], s[i][1])) {
				result++;
				java.lang.System.err.println((("TERTIARY: The first string should be equals to the second string:  " + s[i][2]) + "  compare() returned ") + col.compare(s[i][0], s[i][1] + "."));
			}
		}
	}
}