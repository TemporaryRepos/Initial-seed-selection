public class BidiSurrogateTest {
	private static final java.lang.String RTLS = new java.lang.String(java.lang.Character.toChars(0x10800));

	private static final java.lang.String LTRS = new java.lang.String(java.lang.Character.toChars(0x107ff));

	private static final java.lang.String LRE = "‪";

	private static final java.lang.String RLE = "‫";

	private static final java.lang.String PDF = "‬";

	public static void main(java.lang.String[] args) {
		new javaT.text.Bidi.BidiSurrogateTest().test();
	}

	void test() {
		test0();
		test1();
	}

	void test0() {
		testRequiresBidi("?", false);
		testRequiresBidi("?", false);
		testRequiresBidi("??", false);
		testRequiresBidi("a?b?c", false);
		testRequiresBidi(javaT.text.Bidi.BidiSurrogateTest.LTRS, false);
		testRequiresBidi(javaT.text.Bidi.BidiSurrogateTest.RTLS, true);
		testRequiresBidi(("a" + javaT.text.Bidi.BidiSurrogateTest.RTLS) + "b", true);
		testRequiresBidi(javaT.text.Bidi.BidiSurrogateTest.LTRS + javaT.text.Bidi.BidiSurrogateTest.RTLS, true);
		testRequiresBidi(javaT.text.Bidi.BidiSurrogateTest.LRE, false);
		testRequiresBidi(javaT.text.Bidi.BidiSurrogateTest.RLE, true);
		testRequiresBidi(javaT.text.Bidi.BidiSurrogateTest.PDF, false);
	}

	void testRequiresBidi(java.lang.String string, boolean requiresBidi) {
		char[] text = string.toCharArray();
		if (java.text.Bidi.requiresBidi(text, 0, text.length) != requiresBidi) {
			throw new java.lang.RuntimeException((("testRequiresBidi failed with '" + string) + "', ") + requiresBidi);
		}
	}

	void test1() {
		testBidi(("This is a string with " + javaT.text.Bidi.BidiSurrogateTest.LTRS) + " in it.", false);
		testBidi("This is a string with ? in it.", false);
		testBidi("This is a string with ـ in it.", 22, 1);
		testBidi(javaT.text.Bidi.BidiSurrogateTest.RTLS, true);
		testBidi(((("This is a string with " + javaT.text.Bidi.BidiSurrogateTest.RTLS) + javaT.text.Bidi.BidiSurrogateTest.RTLS) + javaT.text.Bidi.BidiSurrogateTest.RTLS) + " in it.", 22, 6);
	}

	void testBidi(java.lang.String string, boolean directionIsRTL) {
		java.text.Bidi bidi = new java.text.Bidi(string, java.text.Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
		if (bidi.isMixed()) {
			throw new java.lang.RuntimeException("bidi is mixed");
		}
		if (bidi.isRightToLeft() != directionIsRTL) {
			throw new java.lang.RuntimeException("bidi is not " + (directionIsRTL ? "rtl" : "ltr"));
		}
	}

	void testBidi(java.lang.String string, int rtlstart, int rtllength) {
		java.text.Bidi bidi = new java.text.Bidi(string, java.text.Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
		for (int i = 0; i < bidi.getRunCount(); ++i) {
			if ((bidi.getRunLevel(i) & 1) != 0) {
				if ((bidi.getRunStart(i) != rtlstart) || (bidi.getRunLimit(i) != (rtlstart + rtllength))) {
					throw new java.lang.RuntimeException((("first rtl run didn't match " + rtlstart) + ", ") + rtllength);
				}
				break;
			}
		}
	}
}