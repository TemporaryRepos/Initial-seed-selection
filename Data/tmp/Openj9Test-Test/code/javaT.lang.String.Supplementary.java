public class Supplementary {
	public static void main(java.lang.String[] args) {
		javaT.lang.String.Supplementary.test1();
		javaT.lang.String.Supplementary.test2();
		javaT.lang.String.Supplementary.test3();
		javaT.lang.String.Supplementary.test4();
		javaT.lang.String.Supplementary.test5();
		javaT.lang.String.Supplementary.test6();
		javaT.lang.String.Supplementary.test7();
		javaT.lang.String.Supplementary.test8();
		javaT.lang.String.Supplementary.test9();
		javaT.lang.String.Supplementary.test10();
	}

	static final java.lang.String[] input = new java.lang.String[]{ "abc𐀀def??ab𐀀cdefa?bcdef", "?defg?hij𐀀klm?nop??rt?", "?abcd􏿿efgh𐀀9ik??lm?no?", "𐀀!#$?%&𐀀;+?<>;=^?\\@𐀀", "󠈀abc??de󠈂f󠈃ghi󠈂", "𐀀𐀁𐀂𐀃𐀄𐀅" + ("𐀆𐀇𐀈𐀈𐀉𐀊" + "𐀋𐀌𐀍𐀊𐀏𐀐") };

	static final int[][] golden1 = new int[][]{ new int[]{ 'a', 0xd800, 0xdc00, 0x10000, 0xe0200, 0x10000 }, new int[]{ 0xd800, 0x10000, 'g', 0xdc00, 0xe0202, 0xdc04 }, new int[]{ 'f', 0xdc00, 0xd800, 0xdc00, 0xde02, 0xdc10 }, new int[]{ 'f', 'p', 0xdc00, '^', 0xe0202, 0xdc08 } };

	static void test1() {
		for (int i = 0; i < javaT.lang.String.Supplementary.input.length; i++) {
			java.lang.String s = javaT.lang.String.Supplementary.input[i];
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.At, s, 0, javaT.lang.String.Supplementary.golden1[0][i]);
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.At, s, 9, javaT.lang.String.Supplementary.golden1[1][i]);
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.At, s, s.length() - 1, javaT.lang.String.Supplementary.golden1[2][i]);
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.At, s.substring(17), 0, javaT.lang.String.Supplementary.golden1[3][i]);
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.At, s, -1);
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.At, s, s.length());
		}
	}

	static final int[][] golden2 = new int[][]{ new int[]{ 'a', 0xd800, 0xdc00, 0xd800, 0xdb40, 0xd800 }, new int[]{ 0xd800, 'l', 0x10000, 0xdc00, 0xdb40, 0xd800 }, new int[]{ 'f', 0xdc00, 0xd800, 0x10000, 0xe0202, 0x10010 }, new int[]{ 'b', 'd', 'a', 0xdc00, 0xde00, 0xdc00 } };

	static void test2() {
		for (int i = 0; i < javaT.lang.String.Supplementary.input.length; i++) {
			java.lang.String s = javaT.lang.String.Supplementary.input[i];
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.Before, s, 1, javaT.lang.String.Supplementary.golden2[0][i]);
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.Before, s, 13, javaT.lang.String.Supplementary.golden2[1][i]);
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.Before, s, s.length(), javaT.lang.String.Supplementary.golden2[2][i]);
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.Before, s.substring(1), 1, javaT.lang.String.Supplementary.golden2[3][i]);
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.Before, s, 0);
			javaT.lang.String.Supplementary.testCodePoint(javaT.lang.String.Supplementary.Before, s, s.length() + 1);
		}
	}

	static final int[][] golden3 = new int[][]{ new int[]{ 'b', -1, 1, 11, 20, -1 }, new int[]{ 0xd800, -1, 0, 5, 9, 19, -1 }, new int[]{ 0xdc00, -1, 0, 12, 16, 17, 20, -1 }, new int[]{ 0x10000, -1, 0, 8, 21, -1 }, new int[]{ 0xe0202, -1, 9, 17, -1 }, new int[]{ 0x1000a, -1, 22, 30, -1 } };

	static void test3() {
		for (int i = 0; i < javaT.lang.String.Supplementary.input.length; i++) {
			java.lang.String s = javaT.lang.String.Supplementary.input[i];
			javaT.lang.String.Supplementary.testIndexOf(s, javaT.lang.String.Supplementary.golden3[i][0], javaT.lang.String.Supplementary.golden3[i][2]);
			javaT.lang.String.Supplementary.testIndexOf(s, 'Z', -1);
			javaT.lang.String.Supplementary.testIndexOf(s, 0xdb98, -1);
			javaT.lang.String.Supplementary.testIndexOf(s, 0xde76, -1);
			javaT.lang.String.Supplementary.testIndexOf(s, 0x12345, -1);
			javaT.lang.String.Supplementary.testIndexOf(s, -1, -1);
			javaT.lang.String.Supplementary.testIndexOf(s, 0x110000, -1);
		}
	}

	static void test4() {
		for (int i = 0; i < javaT.lang.String.Supplementary.input.length; i++) {
			java.lang.String s = javaT.lang.String.Supplementary.input[i];
			int ch = javaT.lang.String.Supplementary.golden3[i][0];
			int fromIndex = 0;
			for (int j = 2; j < javaT.lang.String.Supplementary.golden3[i].length; j++) {
				fromIndex = javaT.lang.String.Supplementary.testIndexOf(s, fromIndex, ch, javaT.lang.String.Supplementary.golden3[i][j]) + 1;
			}
			javaT.lang.String.Supplementary.testIndexOf(s, -1, ch, javaT.lang.String.Supplementary.golden3[i][2]);
			javaT.lang.String.Supplementary.testIndexOf(s, s.length(), ch, javaT.lang.String.Supplementary.golden3[i][javaT.lang.String.Supplementary.golden3[i].length - 1]);
			javaT.lang.String.Supplementary.testIndexOf(s, 0, 'Z', -1);
			javaT.lang.String.Supplementary.testIndexOf(s, 0, 0xdb98, -1);
			javaT.lang.String.Supplementary.testIndexOf(s, 0, 0xde76, -1);
			javaT.lang.String.Supplementary.testIndexOf(s, 0, 0x12345, -1);
			javaT.lang.String.Supplementary.testIndexOf(s, 0, -1, -1);
			javaT.lang.String.Supplementary.testIndexOf(s, 0, 0x110000, -1);
		}
	}

	static void test5() {
		for (int i = 0; i < javaT.lang.String.Supplementary.input.length; i++) {
			java.lang.String s = javaT.lang.String.Supplementary.input[i];
			javaT.lang.String.Supplementary.testLastIndexOf(s, javaT.lang.String.Supplementary.golden3[i][0], javaT.lang.String.Supplementary.golden3[i][javaT.lang.String.Supplementary.golden3[i].length - 2]);
			javaT.lang.String.Supplementary.testLastIndexOf(s, 'Z', -1);
			javaT.lang.String.Supplementary.testLastIndexOf(s, 0xdb98, -1);
			javaT.lang.String.Supplementary.testLastIndexOf(s, 0xde76, -1);
			javaT.lang.String.Supplementary.testLastIndexOf(s, 0x12345, -1);
			javaT.lang.String.Supplementary.testLastIndexOf(s, -1, -1);
			javaT.lang.String.Supplementary.testLastIndexOf(s, 0x110000, -1);
		}
	}

	static void test6() {
		for (int i = 0; i < javaT.lang.String.Supplementary.input.length; i++) {
			java.lang.String s = javaT.lang.String.Supplementary.input[i];
			int ch = javaT.lang.String.Supplementary.golden3[i][0];
			int len = s.length();
			int fromIndex = len - 1;
			for (int j = javaT.lang.String.Supplementary.golden3[i].length - 2; j > 0; j--) {
				fromIndex = javaT.lang.String.Supplementary.testLastIndexOf(s, fromIndex, ch, javaT.lang.String.Supplementary.golden3[i][j]) - 1;
			}
			javaT.lang.String.Supplementary.testLastIndexOf(s, -1, ch, javaT.lang.String.Supplementary.golden3[i][1]);
			javaT.lang.String.Supplementary.testLastIndexOf(s, len, ch, javaT.lang.String.Supplementary.golden3[i][javaT.lang.String.Supplementary.golden3[i].length - 2]);
			javaT.lang.String.Supplementary.testLastIndexOf(s, len, 'Z', -1);
			javaT.lang.String.Supplementary.testLastIndexOf(s, len, 0xdb98, -1);
			javaT.lang.String.Supplementary.testLastIndexOf(s, len, 0xde76, -1);
			javaT.lang.String.Supplementary.testLastIndexOf(s, len, 0x12345, -1);
			javaT.lang.String.Supplementary.testLastIndexOf(s, len, -1, -1);
			javaT.lang.String.Supplementary.testLastIndexOf(s, len, 0x110000, -1);
		}
	}

	static void test7() {
		for (int i = 0; i < javaT.lang.String.Supplementary.input.length; i++) {
			java.lang.String s = javaT.lang.String.Supplementary.input[i];
			int nCodePoints = 0;
			int c;
			for (int j = 0; j < s.length(); j += java.lang.Character.charCount(c)) {
				c = s.codePointAt(j);
				nCodePoints++;
			}
			int[] codePoints = new int[nCodePoints];
			int count = 0;
			int mid = 0;
			int offset = 0;
			for (int j = 0; j < s.length(); j += java.lang.Character.charCount(c)) {
				if ((mid == 0) && (j >= (s.length() / 2))) {
					mid = j;
					offset = count;
				}
				c = s.codePointAt(j);
				codePoints[count++] = c;
			}
			java.lang.String cps = new java.lang.String(codePoints, 0, count);
			javaT.lang.String.Supplementary.check(!s.equals(cps), ("new String(int[]...) with input[" + i) + "]");
			cps = new java.lang.String(codePoints, 0, offset);
			javaT.lang.String.Supplementary.check(!s.substring(0, mid).equals(cps), ("first half: new String(int[]...) with input[" + i) + "]");
			cps = new java.lang.String(codePoints, offset, count - offset);
			javaT.lang.String.Supplementary.check(!s.substring(mid).equals(cps), ("second half: new String(int[]...) with input[" + i) + "]");
			javaT.lang.String.Supplementary.testNewString(null, 0, count, java.lang.NullPointerException.class);
			javaT.lang.String.Supplementary.testNewString(codePoints, -1, count, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.String.Supplementary.testNewString(codePoints, 0, count + 1, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.String.Supplementary.testNewString(codePoints, offset, count, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.String.Supplementary.testNewString(codePoints, offset, -1, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.String.Supplementary.testNewString(codePoints, count, 1, java.lang.IndexOutOfBoundsException.class);
			codePoints[offset] = -1;
			javaT.lang.String.Supplementary.testNewString(codePoints, 0, count, java.lang.IllegalArgumentException.class);
			codePoints[offset] = java.lang.Character.MAX_CODE_POINT + 1;
			javaT.lang.String.Supplementary.testNewString(codePoints, 0, count, java.lang.IllegalArgumentException.class);
		}
		{
			int[] x = new int[java.lang.Character.MAX_CODE_POINT];
			for (int i = 0; i < x.length; i++) {
				if (i != 0xdbff) {
					x[i] = i;
				}
			}
			final java.lang.String s = new java.lang.String(x, 0, x.length);
			javaT.lang.String.Supplementary.check(s.codePointCount(0, s.length()) != x.length, "s.codePointCount(0, s.length()) != x.length");
			javaT.lang.String.Supplementary.check(s.length() <= x.length, "s.length() <= x.length");
			for (int i = 0, j = 0; i < x.length; i++) {
				int c = s.codePointAt(j);
				javaT.lang.String.Supplementary.check(c != x[i], "c != x[i]");
				j += java.lang.Character.charCount(c);
			}
		}
	}

	static void test8() {
		for (int i = 0; i < javaT.lang.String.Supplementary.input.length; i++) {
			java.lang.String str = javaT.lang.String.Supplementary.input[i];
			int length = str.length();
			for (int j = 0; j <= length; j++) {
				int result = str.codePointCount(j, length);
				int expected = java.lang.Character.codePointCount(str, j, length);
				javaT.lang.String.Supplementary.check(result != expected, ((((("codePointCount(input[" + i) + "], ") + j) + ", ") + length) + ")", result, expected);
				java.lang.String substr = str.substring(j, length);
				result = substr.codePointCount(0, substr.length());
				javaT.lang.String.Supplementary.check(result != expected, ((((("substring:codePointCount(input[" + i) + "], ") + j) + ", ") + length) + ")", result, expected);
			}
			for (int j = length; j >= 0; j--) {
				int result = str.codePointCount(0, j);
				int expected = java.lang.Character.codePointCount(str, 0, j);
				javaT.lang.String.Supplementary.check(result != expected, ((("codePointCount(input[" + i) + "], 0, ") + j) + ")", result, expected);
				java.lang.String substr = str.substring(0, j);
				result = substr.codePointCount(0, substr.length());
				javaT.lang.String.Supplementary.check(result != expected, ((("substring:codePointCount(input[" + i) + "], 0, ") + j) + ")", result, expected);
			}
			javaT.lang.String.Supplementary.testCodePointCount(null, 0, 0, java.lang.NullPointerException.class);
			javaT.lang.String.Supplementary.testCodePointCount(str, -1, length, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.String.Supplementary.testCodePointCount(str, 0, length + 1, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.String.Supplementary.testCodePointCount(str, length, length - 1, java.lang.IndexOutOfBoundsException.class);
		}
	}

	static void test9() {
		for (int i = 0; i < javaT.lang.String.Supplementary.input.length; i++) {
			java.lang.String str = javaT.lang.String.Supplementary.input[i];
			int length = str.length();
			for (int j = 0; j <= length; j++) {
				int nCodePoints = java.lang.Character.codePointCount(str, j, length);
				int result = str.offsetByCodePoints(j, nCodePoints);
				javaT.lang.String.Supplementary.check(result != length, ((((("offsetByCodePoints(input[" + i) + "], ") + j) + ", ") + nCodePoints) + ")", result, length);
				result = str.offsetByCodePoints(length, -nCodePoints);
				int expected = j;
				if ((j > 0) && (j < length)) {
					int cp = str.codePointBefore(j + 1);
					if (java.lang.Character.isSupplementaryCodePoint(cp)) {
						expected--;
					}
				}
				javaT.lang.String.Supplementary.check(result != expected, ((((("offsetByCodePoints(input[" + i) + "], ") + j) + ", ") + (-nCodePoints)) + ")", result, expected);
			}
			for (int j = length; j >= 0; j--) {
				int nCodePoints = java.lang.Character.codePointCount(str, 0, j);
				int result = str.offsetByCodePoints(0, nCodePoints);
				int expected = j;
				if ((j > 0) && (j < length)) {
					int cp = str.codePointAt(j - 1);
					if (java.lang.Character.isSupplementaryCodePoint(cp)) {
						expected++;
					}
				}
				javaT.lang.String.Supplementary.check(result != expected, ((("offsetByCodePoints(input[" + i) + "], 0, ") + nCodePoints) + ")", result, expected);
				result = str.offsetByCodePoints(j, -nCodePoints);
				javaT.lang.String.Supplementary.check(result != 0, ((((("offsetByCodePoints(input[" + i) + "], ") + j) + ", ") + (-nCodePoints)) + ")", result, 0);
			}
			javaT.lang.String.Supplementary.testOffsetByCodePoints(null, 0, 0, java.lang.NullPointerException.class);
			javaT.lang.String.Supplementary.testOffsetByCodePoints(str, -1, length, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.String.Supplementary.testOffsetByCodePoints(str, 0, length + 1, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.String.Supplementary.testOffsetByCodePoints(str, 1, -2, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.String.Supplementary.testOffsetByCodePoints(str, length, length - 1, java.lang.IndexOutOfBoundsException.class);
			javaT.lang.String.Supplementary.testOffsetByCodePoints(str, length, -(length + 1), java.lang.IndexOutOfBoundsException.class);
		}
	}

	static void test10() {
		java.lang.String header = "H?e?a􏰀der<";
		for (int i = 0; i < javaT.lang.String.Supplementary.input.length; i++) {
			java.lang.String wholeString = header + javaT.lang.String.Supplementary.input[i];
			java.lang.String str = wholeString.substring(header.length());
			int length = str.length();
			for (int j = 0; j <= length; j++) {
				int nCodePoints = java.lang.Character.codePointCount(str, j, length);
				int result = str.offsetByCodePoints(j, nCodePoints);
				javaT.lang.String.Supplementary.check(result != length, ((((("offsetByCodePoints(input[" + i) + "], ") + j) + ", ") + nCodePoints) + ")", result, length);
				result = str.offsetByCodePoints(length, -nCodePoints);
				int expected = j;
				if ((j > 0) && (j < length)) {
					int cp = str.codePointBefore(j + 1);
					if (java.lang.Character.isSupplementaryCodePoint(cp)) {
						expected--;
					}
				}
				javaT.lang.String.Supplementary.check(result != expected, ((((("offsetByCodePoints(input[" + i) + "], ") + j) + ", ") + (-nCodePoints)) + ")", result, expected);
			}
			for (int j = length; j >= 0; j--) {
				int nCodePoints = java.lang.Character.codePointCount(str, 0, j);
				int result = str.offsetByCodePoints(0, nCodePoints);
				int expected = j;
				if ((j > 0) && (j < length)) {
					int cp = str.codePointAt(j - 1);
					if (java.lang.Character.isSupplementaryCodePoint(cp)) {
						expected++;
					}
				}
				javaT.lang.String.Supplementary.check(result != expected, ((("offsetByCodePoints(input[" + i) + "], 0, ") + nCodePoints) + ")", result, expected);
				result = str.offsetByCodePoints(j, -nCodePoints);
				javaT.lang.String.Supplementary.check(result != 0, ((((("offsetByCodePoints(input[" + i) + "], ") + j) + ", ") + (-nCodePoints)) + ")", result, 0);
			}
		}
	}

	static final boolean At = true;

	static final boolean Before = false;

	static final boolean FIRST = true;

	static final boolean LAST = false;

	static void testCodePoint(boolean isAt, java.lang.String s, int index, int expected) {
		int c = (isAt) ? s.codePointAt(index) : s.codePointBefore(index);
		javaT.lang.String.Supplementary.check(c != expected, ((((("codePoint" + (isAt ? "At" : "Before")) + "(") + index) + ") for <") + s) + ">", c, expected);
	}

	static void testCodePoint(boolean isAt, java.lang.String s, int index) {
		boolean exceptionOccurred = false;
		try {
			int c = (isAt) ? s.codePointAt(index) : s.codePointBefore(index);
		} catch (java.lang.StringIndexOutOfBoundsException e) {
			exceptionOccurred = true;
		}
		javaT.lang.String.Supplementary.check(!exceptionOccurred, ((((("codePoint" + (isAt ? "At" : "Before")) + "(") + index) + ") for <") + s) + "> should throw StringIndexOutOfBoundsPointerException.");
	}

	static void testIndexOf(java.lang.String s, int c, int expected) {
		javaT.lang.String.Supplementary.testIndexOf2(s, c, expected);
		if (s.indexOf(c) != (-1)) {
			javaT.lang.String.Supplementary.testIndexOf2(s + ((char) (c)), c, expected);
			if (java.lang.Character.isSupplementaryCodePoint(c)) {
				char[] surrogates = java.lang.Character.toChars(c);
				javaT.lang.String.Supplementary.testIndexOf2(s + new java.lang.String(surrogates), c, expected);
				javaT.lang.String.Supplementary.testIndexOf2(s + surrogates[0], c, expected);
				javaT.lang.String.Supplementary.testIndexOf2(s + surrogates[1], c, expected);
				javaT.lang.String.Supplementary.testIndexOf2(new java.lang.String(surrogates) + s, c, 0);
				javaT.lang.String.Supplementary.testIndexOf2(surrogates[0] + s, c, expected + 1);
				javaT.lang.String.Supplementary.testIndexOf2(surrogates[1] + s, c, expected + 1);
			}
		}
	}

	static void testIndexOf2(java.lang.String s, int c, int expected) {
		int index = s.indexOf(c);
		javaT.lang.String.Supplementary.check(index != expected, ((("indexOf(" + javaT.lang.String.Supplementary.toHexString(c)) + ") for <") + s) + ">", index, expected);
	}

	static void testLastIndexOf(java.lang.String s, int c, int expected) {
		javaT.lang.String.Supplementary.testLastIndexOf2(s, c, expected);
		if (s.lastIndexOf(c) != (-1)) {
			javaT.lang.String.Supplementary.testLastIndexOf2(((char) (c)) + s, c, expected + 1);
			if (java.lang.Character.isSupplementaryCodePoint(c)) {
				char[] surrogates = java.lang.Character.toChars(c);
				javaT.lang.String.Supplementary.testLastIndexOf2(s + new java.lang.String(surrogates), c, s.length());
				javaT.lang.String.Supplementary.testLastIndexOf2(s + surrogates[0], c, expected);
				javaT.lang.String.Supplementary.testLastIndexOf2(s + surrogates[1], c, expected);
				javaT.lang.String.Supplementary.testLastIndexOf2(new java.lang.String(surrogates) + s, c, expected + 2);
				javaT.lang.String.Supplementary.testLastIndexOf2(surrogates[0] + s, c, expected + 1);
				javaT.lang.String.Supplementary.testLastIndexOf2(surrogates[1] + s, c, expected + 1);
			}
		}
	}

	static void testLastIndexOf2(java.lang.String s, int c, int expected) {
		int index = s.lastIndexOf(c);
		javaT.lang.String.Supplementary.check(index != expected, ((("lastIndexOf(" + javaT.lang.String.Supplementary.toHexString(c)) + ") for <") + s) + ">", index, expected);
	}

	static int testIndexOf(java.lang.String s, int fromIndex, int c, int expected) {
		int index = s.indexOf(c, fromIndex);
		javaT.lang.String.Supplementary.check(index != expected, ((((("indexOf(" + javaT.lang.String.Supplementary.toHexString(c)) + ", ") + fromIndex) + ") for <") + s) + ">", index, expected);
		return index;
	}

	static int testLastIndexOf(java.lang.String s, int fromIndex, int c, int expected) {
		int index = s.lastIndexOf(c, fromIndex);
		javaT.lang.String.Supplementary.check(index != expected, ((((("lastIndexOf(" + javaT.lang.String.Supplementary.toHexString(c)) + ", ") + fromIndex) + ") for <") + s) + ">", index, expected);
		return index;
	}

	static void testNewString(int[] codePoints, int offset, int count, java.lang.Class expectedException) {
		try {
			java.lang.String s = new java.lang.String(codePoints, offset, count);
		} catch (java.lang.Exception e) {
			if (expectedException.isInstance(e)) {
				return;
			}
			throw new java.lang.RuntimeException("Error: Unexpected exception", e);
		}
		javaT.lang.String.Supplementary.check(true, "new String(int[]...) didn't throw " + expectedException.getName());
	}

	static void testCodePointCount(java.lang.String str, int beginIndex, int endIndex, java.lang.Class expectedException) {
		try {
			int n = str.codePointCount(beginIndex, endIndex);
		} catch (java.lang.Exception e) {
			if (expectedException.isInstance(e)) {
				return;
			}
			throw new java.lang.RuntimeException("Error: Unexpected exception", e);
		}
		javaT.lang.String.Supplementary.check(true, "codePointCount() didn't throw " + expectedException.getName());
	}

	static void testOffsetByCodePoints(java.lang.String str, int index, int offset, java.lang.Class expectedException) {
		try {
			int n = str.offsetByCodePoints(index, offset);
		} catch (java.lang.Exception e) {
			if (expectedException.isInstance(e)) {
				return;
			}
			throw new java.lang.RuntimeException("Error: Unexpected exception", e);
		}
		javaT.lang.String.Supplementary.check(true, "offsetByCodePoints() didn't throw " + expectedException.getName());
	}

	static void check(boolean err, java.lang.String msg) {
		if (err) {
			throw new java.lang.RuntimeException("Error: " + msg);
		}
	}

	static void check(boolean err, java.lang.String s, int got, int expected) {
		if (err) {
			throw new java.lang.RuntimeException((((("Error: " + s) + " returned an unexpected value. got ") + javaT.lang.String.Supplementary.toHexString(got)) + ", expected ") + javaT.lang.String.Supplementary.toHexString(expected));
		}
	}

	private static java.lang.String toHexString(int c) {
		return "0x" + java.lang.Integer.toHexString(c);
	}
}