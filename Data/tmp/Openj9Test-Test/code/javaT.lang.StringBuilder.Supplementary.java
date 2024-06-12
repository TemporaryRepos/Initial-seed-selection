public class Supplementary {
	public static void main(java.lang.String[] args) {
		javaT.lang.StringBuilder.Supplementary.test1();
		javaT.lang.StringBuilder.Supplementary.test2();
		javaT.lang.StringBuilder.Supplementary.test3();
		javaT.lang.StringBuilder.Supplementary.test4();
		javaT.lang.StringBuilder.Supplementary.test5();
		javaT.lang.StringBuilder.Supplementary.test6();
		javaT.lang.StringBuilder.Supplementary.testDontReadOutOfBoundsTrailingSurrogate();
	}

	static final java.lang.String[] input = new java.lang.String[]{ "abc𐀀def??ab𐀀cdefa?bcdef", "?defg?hij𐀀klm?nop??rt?", "?abcd􏿿efgh𐀀9ik??lm?no?", "𐀀!#$?%&𐀀;+?<>;=^?\\@𐀀", "󠈀abc??de󠈂f󠈃ghi󠈂" };

	static final int[][] golden1 = new int[][]{ new int[]{ 'a', 0xd800, 0xdc00, 0x10000, 0xe0200 }, new int[]{ 0xd800, 0x10000, 'g', 0xdc00, 0xe0202 }, new int[]{ 'f', 0xdc00, 0xd800, 0xdc00, 0xde02 } };

	static void test1() {
		for (int i = 0; i < javaT.lang.StringBuilder.Supplementary.input.length; i++) {
			java.lang.StringBuilder sb = new java.lang.StringBuilder(javaT.lang.StringBuilder.Supplementary.input[i]);
			javaT.lang.StringBuilder.Supplementary.testCodePoint(javaT.lang.StringBuilder.Supplementary.At, sb, 0, javaT.lang.StringBuilder.Supplementary.golden1[0][i]);
			javaT.lang.StringBuilder.Supplementary.testCodePoint(javaT.lang.StringBuilder.Supplementary.At, sb, 9, javaT.lang.StringBuilder.Supplementary.golden1[1][i]);
			javaT.lang.StringBuilder.Supplementary.testCodePoint(javaT.lang.StringBuilder.Supplementary.At, sb, sb.length() - 1, javaT.lang.StringBuilder.Supplementary.golden1[2][i]);
			javaT.lang.StringBuilder.Supplementary.testCodePoint(javaT.lang.StringBuilder.Supplementary.At, sb, -1);
			javaT.lang.StringBuilder.Supplementary.testCodePoint(javaT.lang.StringBuilder.Supplementary.At, sb, sb.length());
		}
	}

	static final int[][] golden2 = new int[][]{ new int[]{ 'a', 0xd800, 0xdc00, 0xd800, 0xdb40 }, new int[]{ 0xd800, 'l', 0x10000, 0xdc00, 0xdb40 }, new int[]{ 'f', 0xdc00, 0xd800, 0x10000, 0xe0202 } };

	static void test2() {
		for (int i = 0; i < javaT.lang.StringBuilder.Supplementary.input.length; i++) {
			java.lang.StringBuilder sb = new java.lang.StringBuilder(javaT.lang.StringBuilder.Supplementary.input[i]);
			javaT.lang.StringBuilder.Supplementary.testCodePoint(javaT.lang.StringBuilder.Supplementary.Before, sb, 1, javaT.lang.StringBuilder.Supplementary.golden2[0][i]);
			javaT.lang.StringBuilder.Supplementary.testCodePoint(javaT.lang.StringBuilder.Supplementary.Before, sb, 13, javaT.lang.StringBuilder.Supplementary.golden2[1][i]);
			javaT.lang.StringBuilder.Supplementary.testCodePoint(javaT.lang.StringBuilder.Supplementary.Before, sb, sb.length(), javaT.lang.StringBuilder.Supplementary.golden2[2][i]);
			javaT.lang.StringBuilder.Supplementary.testCodePoint(javaT.lang.StringBuilder.Supplementary.Before, sb, 0);
			javaT.lang.StringBuilder.Supplementary.testCodePoint(javaT.lang.StringBuilder.Supplementary.Before, sb, sb.length() + 1);
		}
	}

	static final java.lang.String[] golden3 = new java.lang.String[]{ "fedcb?afedc𐀀ba??fed𐀀cba", "?tr𐀀pon?mlk𐀀jih?gfed?", "?on?ml??ki9𐀀hgfe􏿿dcba?", "𐀀@\\?^=;><?+;𐀀&%?$#!𐀀", "󠈂ihg󠈃f󠈂ed󠈁cba󠈀" };

	static final java.lang.String[][] testdata1 = new java.lang.String[][]{ new java.lang.String[]{ "a𐀀", "𐀀a" }, new java.lang.String[]{ "a??", "𐀀a" }, new java.lang.String[]{ "𐀀a", "a𐀀" }, new java.lang.String[]{ "??a", "a𐀀" }, new java.lang.String[]{ "???", "?𐀀" }, new java.lang.String[]{ "?𐀁", "𐀁?" }, new java.lang.String[]{ "?𐀀", "𐀀?" }, new java.lang.String[]{ "𐀁?", "?𐀁" }, new java.lang.String[]{ "𐀀??", "𐐁𐀀" } };

	static void test3() {
		for (int i = 0; i < javaT.lang.StringBuilder.Supplementary.input.length; i++) {
			java.lang.StringBuilder sb = new java.lang.StringBuilder(javaT.lang.StringBuilder.Supplementary.input[i]).reverse();
			javaT.lang.StringBuilder.Supplementary.check(!javaT.lang.StringBuilder.Supplementary.golden3[i].equals(sb.toString()), ("reverse() for <" + javaT.lang.StringBuilder.Supplementary.toHexString(javaT.lang.StringBuilder.Supplementary.input[i])) + ">", sb, javaT.lang.StringBuilder.Supplementary.golden3[i]);
		}
		for (int i = 0; i < javaT.lang.StringBuilder.Supplementary.testdata1.length; i++) {
			java.lang.StringBuilder sb = new java.lang.StringBuilder(javaT.lang.StringBuilder.Supplementary.testdata1[i][0]).reverse();
			javaT.lang.StringBuilder.Supplementary.check(!javaT.lang.StringBuilder.Supplementary.testdata1[i][1].equals(sb.toString()), ("reverse() for <" + javaT.lang.StringBuilder.Supplementary.toHexString(javaT.lang.StringBuilder.Supplementary.testdata1[i][0])) + ">", sb, javaT.lang.StringBuilder.Supplementary.testdata1[i][1]);
		}
	}

	static void test4() {
		for (int i = 0; i < javaT.lang.StringBuilder.Supplementary.input.length; i++) {
			java.lang.String s = javaT.lang.StringBuilder.Supplementary.input[i];
			java.lang.StringBuilder sb = new java.lang.StringBuilder();
			int c;
			for (int j = 0; j < s.length(); j += java.lang.Character.charCount(c)) {
				c = s.codePointAt(j);
				java.lang.StringBuilder rsb = sb.appendCodePoint(c);
				javaT.lang.StringBuilder.Supplementary.check(sb != rsb, "appendCodePoint returned a wrong object");
				int sbc = sb.codePointAt(j);
				javaT.lang.StringBuilder.Supplementary.check(sbc != c, ("appendCodePoint(" + j) + ") != c", sbc, c);
			}
			javaT.lang.StringBuilder.Supplementary.check(!s.equals(sb.toString()), ("appendCodePoint() produced a wrong result with input[" + i) + "]");
		}
		javaT.lang.StringBuilder.Supplementary.testAppendCodePoint(-1, java.lang.IllegalArgumentException.class);
		javaT.lang.StringBuilder.Supplementary.testAppendCodePoint(java.lang.Character.MAX_CODE_POINT + 1, java.lang.IllegalArgumentException.class);
	}

	static void test5() {
		for (int i = 0; i < javaT.lang.StringBuilder.Supplementary.input.length; i++) {
			java.lang.String s = javaT.lang.StringBuilder.Supplementary.input[i];
			java.lang.StringBuilder sb = new java.lang.StringBuilder(s);
			int length = sb.length();
			for (int j = 0; j <= length; j++) {
				int result = sb.codePointCount(j, length);
				int expected = java.lang.Character.codePointCount(sb, j, length);
				javaT.lang.StringBuilder.Supplementary.check(result != expected, ((((("codePointCount(input[" + i) + "], ") + j) + ", ") + length) + ")", result, expected);
			}
			for (int j = length; j >= 0; j--) {
				int result = sb.codePointCount(0, j);
				int expected = java.lang.Character.codePointCount(sb, 0, j);
				javaT.lang.StringBuilder.Supplementary.check(result != expected, ((("codePointCount(input[" + i) + "], 0, ") + j) + ")", result, expected);
			}
			javaT.lang.StringBuilder.Supplementary.testCodePointCount(null, 0, 0, java.lang.NullPointerException.class);
			javaT.lang.StringBuilder.Supplementary.testCodePointCount(sb, -1, length, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.StringBuilder.Supplementary.testCodePointCount(sb, 0, length + 1, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.StringBuilder.Supplementary.testCodePointCount(sb, length, length - 1, java.lang.IndexOutOfBoundsException.class);
		}
	}

	static void test6() {
		for (int i = 0; i < javaT.lang.StringBuilder.Supplementary.input.length; i++) {
			java.lang.String s = javaT.lang.StringBuilder.Supplementary.input[i];
			java.lang.StringBuilder sb = new java.lang.StringBuilder(s);
			int length = s.length();
			for (int j = 0; j <= length; j++) {
				int nCodePoints = java.lang.Character.codePointCount(sb, j, length);
				int result = sb.offsetByCodePoints(j, nCodePoints);
				javaT.lang.StringBuilder.Supplementary.check(result != length, ((((("offsetByCodePoints(input[" + i) + "], ") + j) + ", ") + nCodePoints) + ")", result, length);
				result = sb.offsetByCodePoints(length, -nCodePoints);
				int expected = j;
				if ((j > 0) && (j < length)) {
					int cp = sb.codePointBefore(j + 1);
					if (java.lang.Character.isSupplementaryCodePoint(cp)) {
						expected--;
					}
				}
				javaT.lang.StringBuilder.Supplementary.check(result != expected, ((((("offsetByCodePoints(input[" + i) + "], ") + j) + ", ") + (-nCodePoints)) + ")", result, expected);
			}
			for (int j = length; j >= 0; j--) {
				int nCodePoints = java.lang.Character.codePointCount(sb, 0, j);
				int result = sb.offsetByCodePoints(0, nCodePoints);
				int expected = j;
				if ((j > 0) && (j < length)) {
					int cp = sb.codePointAt(j - 1);
					if (java.lang.Character.isSupplementaryCodePoint(cp)) {
						expected++;
					}
				}
				javaT.lang.StringBuilder.Supplementary.check(result != expected, ((("offsetByCodePoints(input[" + i) + "], 0, ") + nCodePoints) + ")", result, expected);
				result = sb.offsetByCodePoints(j, -nCodePoints);
				javaT.lang.StringBuilder.Supplementary.check(result != 0, ((((("offsetBycodePoints(input[" + i) + "], ") + j) + ", ") + (-nCodePoints)) + ")", result, 0);
			}
			javaT.lang.StringBuilder.Supplementary.testOffsetByCodePoints(null, 0, 0, java.lang.NullPointerException.class);
			javaT.lang.StringBuilder.Supplementary.testOffsetByCodePoints(sb, -1, length, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.StringBuilder.Supplementary.testOffsetByCodePoints(sb, 0, length + 1, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.StringBuilder.Supplementary.testOffsetByCodePoints(sb, 1, -2, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.StringBuilder.Supplementary.testOffsetByCodePoints(sb, length, length - 1, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.StringBuilder.Supplementary.testOffsetByCodePoints(sb, length, -(length + 1), java.lang.IndexOutOfBoundsException.class);
		}
	}

	static void testDontReadOutOfBoundsTrailingSurrogate() {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		int suppl = java.lang.Character.MIN_SUPPLEMENTARY_CODE_POINT;
		sb.appendCodePoint(suppl);
		javaT.lang.StringBuilder.Supplementary.check(sb.codePointAt(0) != ((int) (suppl)), "codePointAt(0)", sb.codePointAt(0), suppl);
		javaT.lang.StringBuilder.Supplementary.check(sb.length() != 2, "sb.length()");
		sb.setLength(1);
		javaT.lang.StringBuilder.Supplementary.check(sb.length() != 1, "sb.length()");
		javaT.lang.StringBuilder.Supplementary.check(sb.codePointAt(0) != java.lang.Character.highSurrogate(suppl), "codePointAt(0)", sb.codePointAt(0), java.lang.Character.highSurrogate(suppl));
	}

	static final boolean At = true;

	static final boolean Before = false;

	static void testCodePoint(boolean isAt, java.lang.StringBuilder sb, int index, int expected) {
		int c = (isAt) ? sb.codePointAt(index) : sb.codePointBefore(index);
		javaT.lang.StringBuilder.Supplementary.check(c != expected, ((((("codePoint" + (isAt ? "At" : "Before")) + "(") + index) + ") for <") + sb) + ">", c, expected);
	}

	static void testCodePoint(boolean isAt, java.lang.StringBuilder sb, int index) {
		boolean exceptionOccurred = false;
		try {
			int c = (isAt) ? sb.codePointAt(index) : sb.codePointBefore(index);
		} catch (java.lang.StringIndexOutOfBoundsException e) {
			exceptionOccurred = true;
		}
		javaT.lang.StringBuilder.Supplementary.check(!exceptionOccurred, ((((("codePoint" + (isAt ? "At" : "Before")) + "(") + index) + ") for <") + sb) + "> should throw StringIndexOutOfBoundsPointerException.");
	}

	static void testAppendCodePoint(int codePoint, java.lang.Class expectedException) {
		try {
			new java.lang.StringBuilder().appendCodePoint(codePoint);
		} catch (java.lang.Exception e) {
			if (expectedException.isInstance(e)) {
				return;
			}
			throw new java.lang.RuntimeException("Error: Unexpected exception", e);
		}
		javaT.lang.StringBuilder.Supplementary.check(true, (("appendCodePoint(" + javaT.lang.StringBuilder.Supplementary.toHexString(codePoint)) + ") didn't throw ") + expectedException.getName());
	}

	static void testCodePointCount(java.lang.StringBuilder sb, int beginIndex, int endIndex, java.lang.Class expectedException) {
		try {
			int n = sb.codePointCount(beginIndex, endIndex);
		} catch (java.lang.Exception e) {
			if (expectedException.isInstance(e)) {
				return;
			}
			throw new java.lang.RuntimeException("Error: Unexpected exception", e);
		}
		javaT.lang.StringBuilder.Supplementary.check(true, "codePointCount() didn't throw " + expectedException.getName());
	}

	static void testOffsetByCodePoints(java.lang.StringBuilder sb, int index, int offset, java.lang.Class expectedException) {
		try {
			int n = sb.offsetByCodePoints(index, offset);
		} catch (java.lang.Exception e) {
			if (expectedException.isInstance(e)) {
				return;
			}
			throw new java.lang.RuntimeException("Error: Unexpected exception", e);
		}
		javaT.lang.StringBuilder.Supplementary.check(true, "offsetByCodePoints() didn't throw " + expectedException.getName());
	}

	static void check(boolean err, java.lang.String msg) {
		if (err) {
			throw new java.lang.RuntimeException("Error: " + msg);
		}
	}

	static void check(boolean err, java.lang.String s, int got, int expected) {
		if (err) {
			throw new java.lang.RuntimeException((((("Error: " + s) + " returned an unexpected value. got ") + javaT.lang.StringBuilder.Supplementary.toHexString(got)) + ", expected ") + javaT.lang.StringBuilder.Supplementary.toHexString(expected));
		}
	}

	static void check(boolean err, java.lang.String s, java.lang.StringBuilder got, java.lang.String expected) {
		if (err) {
			throw new java.lang.RuntimeException(((((("Error: " + s) + " returned an unexpected value. got <") + javaT.lang.StringBuilder.Supplementary.toHexString(got.toString())) + ">, expected <") + javaT.lang.StringBuilder.Supplementary.toHexString(expected)) + ">");
		}
	}

	private static java.lang.String toHexString(int c) {
		return "0x" + java.lang.Integer.toHexString(c);
	}

	private static java.lang.String toHexString(java.lang.String s) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			sb.append(" 0x");
			if (c < 0x10) {
				sb.append('0');
			}
			if (c < 0x100) {
				sb.append('0');
			}
			if (c < 0x1000) {
				sb.append('0');
			}
			sb.append(java.lang.Integer.toHexString(c));
		}
		sb.append(' ');
		return sb.toString();
	}
}