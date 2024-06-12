public class Bug4932583 {
	public static void main(java.lang.String[] args) {
		java.text.BreakIterator iterator = java.text.BreakIterator.getCharacterInstance();
		iterator.setText("󠏿");
		int boundary = iterator.next();
	}
}