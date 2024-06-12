public class SurrogatePairs {
	static java.lang.String[] testStrings = new java.lang.String[]{ "𐀀", "𐏿", "􏰀", "􏿿", "1􏰀", "@􏰀", "􏰀1", "􏰀@", "ā􏰀", "􏰀ā" };

	static java.lang.String[] correctEncodings = new java.lang.String[]{ "%F0%90%80%80", "%F0%90%8F%BF", "%F4%8F%B0%80", "%F4%8F%BF%BF", "1%F4%8F%B0%80", "%40%F4%8F%B0%80", "%F4%8F%B0%801", "%F4%8F%B0%80%40", "%C4%81%F4%8F%B0%80", "%F4%8F%B0%80%C4%81" };

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (int i = 0; i < javaT.net.URLEncoder.SurrogatePairs.testStrings.length; i++) {
			javaT.net.URLEncoder.SurrogatePairs.test(javaT.net.URLEncoder.SurrogatePairs.testStrings[i], javaT.net.URLEncoder.SurrogatePairs.correctEncodings[i]);
		}
	}

	private static void test(java.lang.String str, java.lang.String correctEncoding) throws java.lang.Exception {
		java.lang.System.out.println("Unicode bytes of test string are: " + javaT.net.URLEncoder.SurrogatePairs.getHexBytes(str));
		java.lang.String encoded = java.net.URLEncoder.encode(str, "UTF-8");
		java.lang.System.out.println("URLEncoding is: " + encoded);
		if (encoded.equals(correctEncoding)) {
			java.lang.System.out.println("The encoding is correct!");
		} else {
			throw new java.lang.Exception(("The encoding is incorrect!" + " It should be ") + correctEncoding);
		}
		java.lang.String decoded = java.net.URLDecoder.decode(encoded, "UTF-8");
		java.lang.System.out.println("Unicode bytes for URLDecoding are: " + javaT.net.URLEncoder.SurrogatePairs.getHexBytes(decoded));
		if (str.equals(decoded)) {
			java.lang.System.out.println("The decoding is correct");
		} else {
			throw new java.lang.Exception("The decoded is not equal to the original");
		}
		java.lang.System.out.println("---");
	}

	private static java.lang.String getHexBytes(java.lang.String s) throws java.lang.Exception {
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			int a = s.charAt(i);
			int b1 = (a >> 8) & 0xff;
			int b2 = ((byte) (a));
			int b11 = (b1 >> 4) & 0xf;
			int b12 = b1 & 0xf;
			int b21 = (b2 >> 4) & 0xf;
			int b22 = b2 & 0xf;
			sb.append(java.lang.Integer.toHexString(b11));
			sb.append(java.lang.Integer.toHexString(b12));
			sb.append(java.lang.Integer.toHexString(b21));
			sb.append(java.lang.Integer.toHexString(b22));
			sb.append(' ');
		}
		return sb.toString();
	}
}