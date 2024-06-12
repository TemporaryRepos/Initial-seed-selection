public class Bug4912404 {
	public static void main(java.lang.String[] args) {
		java.text.BreakIterator b = java.text.BreakIterator.getWordInstance();
		b.setText("abc");
		if (b.equals(null)) {
			throw new java.lang.RuntimeException("BreakIterator.equals(null) should return false.");
		}
	}
}