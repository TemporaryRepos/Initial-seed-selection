public class URLEncodeDecode {
	static char[] chars = new char[]{ 'H', 'e', 'l', 'l', 'o', ' ', '+', '%', '-', '_', '.', '!', '~', '*', '\'', '(', ')', '@', '®', 'ā', 'Ⴀ' };

	static java.lang.String str = new java.lang.String(javaT.net.URLEncoder.URLEncodeDecode.chars);

	static java.lang.String correctEncodedUTF8 = "Hello+%2B%25-_.%21%7E*%27%28%29%40%C2%AE%C4%81%E1%82%A0";

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.System.out.println("Constructed the string: " + javaT.net.URLEncoder.URLEncodeDecode.str);
		java.lang.System.out.println("The Unicode bytes are: " + javaT.net.URLEncoder.URLEncodeDecode.getHexBytes(javaT.net.URLEncoder.URLEncodeDecode.str));
		java.lang.System.out.println("");
		javaT.net.URLEncoder.URLEncodeDecode.test("UTF-8", javaT.net.URLEncoder.URLEncodeDecode.correctEncodedUTF8);
	}

	private static void test(java.lang.String enc, java.lang.String correctEncoded) throws java.lang.Exception {
		java.lang.String encoded = null;
		java.lang.String outStr = null;
		if (enc == null) {
			encoded = java.net.URLEncoder.encode(javaT.net.URLEncoder.URLEncodeDecode.str);
			outStr = "default";
		} else {
			encoded = java.net.URLEncoder.encode(javaT.net.URLEncoder.URLEncodeDecode.str, enc);
			outStr = enc;
		}
		java.lang.System.out.println((("URLEncode it (" + outStr) + ") : ") + encoded);
		java.lang.System.out.println("The Unicode bytes are: " + javaT.net.URLEncoder.URLEncodeDecode.getHexBytes(encoded));
		if (encoded.equals(correctEncoded)) {
			java.lang.System.out.println("The encoding is correct!");
		} else {
			throw new java.lang.Exception(("The encoding is incorrect!" + " It should be ") + correctEncoded);
		}
		java.lang.System.out.println("");
		java.lang.String decoded = null;
		if (enc == null) {
			decoded = java.net.URLDecoder.decode(encoded);
		} else {
			decoded = java.net.URLDecoder.decode(encoded, enc);
		}
		java.lang.System.out.println((("URLDecode it (" + outStr) + ") : ") + decoded);
		java.lang.System.out.println("The Unicode bytes are: " + javaT.net.URLEncoder.URLEncodeDecode.getHexBytes(decoded));
		if (javaT.net.URLEncoder.URLEncodeDecode.str.equals(decoded)) {
			java.lang.System.out.println("The decoding is correct");
		} else {
			throw new java.lang.Exception("The decoded is not equal to the original");
		}
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