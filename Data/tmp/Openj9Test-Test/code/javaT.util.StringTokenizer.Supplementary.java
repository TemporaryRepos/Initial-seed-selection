public class Supplementary {
	public static void main(java.lang.String[] args) {
		java.lang.String text = "ab𐀀𐀁cd𐀀?xy 𐐀z\t123?456";
		java.lang.String delims = " \t\r\n\f.𐀀,:;";
		java.lang.String[] expected = new java.lang.String[]{ "ab", "𐀁cd", "?xy", "𐐀z", "123?456" };
		javaT.util.StringTokenizer.Supplementary.testTokenizer(text, delims, expected);
		delims = " \t\r\n\f.,:;?";
		expected = new java.lang.String[]{ "ab𐀀𐀁cd𐀀?xy", "𐐀z", "123", "456" };
		javaT.util.StringTokenizer.Supplementary.testTokenizer(text, delims, expected);
		delims = "?";
		expected = new java.lang.String[]{ "ab𐀀𐀁cd𐀀", "xy 𐐀z\t123?456" };
		javaT.util.StringTokenizer.Supplementary.testTokenizer(text, delims, expected);
	}

	static void testTokenizer(java.lang.String text, java.lang.String delims, java.lang.String[] expected) {
		java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(text, delims);
		int n = tokenizer.countTokens();
		if (n != expected.length) {
			throw new java.lang.RuntimeException((("countToken(): wrong value " + n) + ", expected ") + expected.length);
		}
		int i = 0;
		while (tokenizer.hasMoreTokens()) {
			java.lang.String token = tokenizer.nextToken();
			if (!token.equals(expected[i++])) {
				throw new java.lang.RuntimeException((("nextToken(): wrong token. got \"" + token) + "\", expected \"") + expected[i - 1]);
			}
		} 
		if (i != expected.length) {
			throw new java.lang.RuntimeException((("unexpected the number of tokens: " + i) + ", expected ") + expected.length);
		}
	}
}