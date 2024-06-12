public class Bug4740757 {
	private static boolean err = false;

	public static void main(java.lang.String[] args) {
		java.util.Locale defaultLocale = java.util.Locale.getDefault();
		if (defaultLocale.getLanguage().equals("th")) {
			java.util.Locale.setDefault(java.util.Locale.KOREA);
			javaT.text.BreakIterator.Bug4740757.test4740757();
			java.util.Locale.setDefault(defaultLocale);
		} else {
			javaT.text.BreakIterator.Bug4740757.test4740757();
		}
		if (javaT.text.BreakIterator.Bug4740757.err) {
			throw new java.lang.RuntimeException("Incorrect Line-breaking");
		}
	}

	private static void test4740757() {
		java.lang.String source = "안녕하세요? 좋은 아침, 여보세요! 안녕. End.";
		java.lang.String expected = "안/녕/하/세/요? /좋/은 /아/침, /여/보/세/요! /안/녕. /End./";
		java.text.BreakIterator bi = java.text.BreakIterator.getLineInstance(java.util.Locale.KOREAN);
		bi.setText(source);
		int start = bi.first();
		int end = bi.next();
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (; end != java.text.BreakIterator.DONE; start = end , end = bi.next()) {
			sb.append(source.substring(start, end));
			sb.append('/');
		}
		if (!expected.equals(sb.toString())) {
			java.lang.System.err.println((((((("Failed: Hangul line-breaking failed." + "\n\tExpected: ") + expected) + "\n\tGot:      ") + sb) + "\nin ") + java.util.Locale.getDefault()) + " locale.");
			javaT.text.BreakIterator.Bug4740757.err = true;
		}
	}
}