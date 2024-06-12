public class Bug7041232 {
	public static void main(java.lang.String[] args) {
		java.lang.String UnicodeChars;
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		for (int i = 0x2000; i < 0x2100; i++) {
			sb.append(((char) (i)));
		}
		UnicodeChars = sb.toString();
		java.text.Bidi bidi = new java.text.Bidi(UnicodeChars, java.text.Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
		bidi.createLineBidi(0, UnicodeChars.length());
	}
}