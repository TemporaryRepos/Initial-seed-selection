public class Bug6513074 {
	private static final java.lang.String[][] source = new java.lang.String[][]{ new java.lang.String[]{ "侮僧 響頻", "JIS X 0213 compatibility additions (\\uFA30-\\uFA6A)" } };

	private static final java.lang.String[] expected_line = new java.lang.String[]{ "侮/僧 /響/頻/" };

	private static final java.lang.String[] expected_word = new java.lang.String[]{ "侮僧/ /響頻/" };

	private static final java.lang.String[] expected_char = new java.lang.String[]{ "侮/僧/ /響/頻/" };

	private static boolean err = false;

	public static void main(java.lang.String[] args) {
		java.util.Locale defaultLocale = java.util.Locale.getDefault();
		if (defaultLocale.getLanguage().equals("th")) {
			java.util.Locale.setDefault(java.util.Locale.JAPAN);
			javaT.text.BreakIterator.Bug6513074.test6513074();
			java.util.Locale.setDefault(defaultLocale);
		} else {
			javaT.text.BreakIterator.Bug6513074.test6513074();
		}
		if (javaT.text.BreakIterator.Bug6513074.err) {
			throw new java.lang.RuntimeException("Failed: Incorrect Text-breaking.");
		}
	}

	private static void test6513074() {
		java.text.BreakIterator bi = java.text.BreakIterator.getLineInstance(java.util.Locale.JAPAN);
		for (int i = 0; i < javaT.text.BreakIterator.Bug6513074.source.length; i++) {
			javaT.text.BreakIterator.Bug6513074.testBreakIterator(bi, "Line", javaT.text.BreakIterator.Bug6513074.source[i][0], javaT.text.BreakIterator.Bug6513074.expected_line[i], javaT.text.BreakIterator.Bug6513074.source[i][1]);
		}
		bi = java.text.BreakIterator.getWordInstance(java.util.Locale.JAPAN);
		for (int i = 0; i < javaT.text.BreakIterator.Bug6513074.source.length; i++) {
			javaT.text.BreakIterator.Bug6513074.testBreakIterator(bi, "Word", javaT.text.BreakIterator.Bug6513074.source[i][0], javaT.text.BreakIterator.Bug6513074.expected_word[i], javaT.text.BreakIterator.Bug6513074.source[i][1]);
		}
		bi = java.text.BreakIterator.getCharacterInstance(java.util.Locale.JAPAN);
		for (int i = 0; i < javaT.text.BreakIterator.Bug6513074.source.length; i++) {
			javaT.text.BreakIterator.Bug6513074.testBreakIterator(bi, "Character", javaT.text.BreakIterator.Bug6513074.source[i][0], javaT.text.BreakIterator.Bug6513074.expected_char[i], javaT.text.BreakIterator.Bug6513074.source[i][1]);
		}
	}

	private static void testBreakIterator(java.text.BreakIterator bi, java.lang.String type, java.lang.String source, java.lang.String expected, java.lang.String description) {
		bi.setText(source);
		int start = bi.first();
		int end = bi.next();
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (; end != java.text.BreakIterator.DONE; start = end , end = bi.next()) {
			sb.append(source.substring(start, end));
			sb.append('/');
		}
		if (!expected.equals(sb.toString())) {
			java.lang.System.err.println((((((("Failed: Incorrect " + type) + "-breaking for ") + description) + "\n\tExpected: ") + javaT.text.BreakIterator.Bug6513074.toString(expected)) + "\n\tGot:      ") + javaT.text.BreakIterator.Bug6513074.toString(sb.toString()));
			javaT.text.BreakIterator.Bug6513074.err = true;
		}
	}

	private static java.lang.String toString(java.lang.String s) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append("  0x" + java.lang.Integer.toHexString(s.charAt(i)));
		}
		return sb.toString();
	}
}