public class Bug7042148 {
	private static boolean err = false;

	public static void main(java.lang.String[] args) {
		javaT.text.Bidi.Bug7042148.testDirection();
		if (javaT.text.Bidi.Bug7042148.err) {
			throw new java.lang.RuntimeException("Failed");
		} else {
			java.lang.System.out.println("Passed.");
		}
	}

	private static void testDirection() {
		java.util.Map attrLTR = new java.util.HashMap();
		attrLTR.put(java.awt.font.TextAttribute.RUN_DIRECTION, java.awt.font.TextAttribute.RUN_DIRECTION_LTR);
		java.util.Map attrRTL = new java.util.HashMap();
		attrRTL.put(java.awt.font.TextAttribute.RUN_DIRECTION, java.awt.font.TextAttribute.RUN_DIRECTION_RTL);
		java.lang.String str1 = "Aנ";
		java.lang.String str2 = "נB";
		javaT.text.Bidi.Bug7042148.test(str1, attrLTR, java.text.Bidi.DIRECTION_LEFT_TO_RIGHT);
		javaT.text.Bidi.Bug7042148.test(str1, attrRTL, java.text.Bidi.DIRECTION_RIGHT_TO_LEFT);
		javaT.text.Bidi.Bug7042148.test(str2, attrLTR, java.text.Bidi.DIRECTION_LEFT_TO_RIGHT);
		javaT.text.Bidi.Bug7042148.test(str2, attrRTL, java.text.Bidi.DIRECTION_RIGHT_TO_LEFT);
	}

	private static void test(java.lang.String text, java.util.Map attr, int dirFlag) {
		boolean expected = dirFlag == java.text.Bidi.DIRECTION_LEFT_TO_RIGHT;
		java.text.Bidi bidi = new java.text.Bidi(text, dirFlag);
		boolean got = bidi.baseIsLeftToRight();
		if (got != expected) {
			javaT.text.Bidi.Bug7042148.err = true;
			java.lang.System.err.println(((((("wrong Bidi(String, int).baseIsLeftToRight() value: " + "\n\ttext=") + text) + "\n\tExpected=") + expected) + "\n\tGot=") + got);
		}
		java.text.AttributedString as = new java.text.AttributedString(text, attr);
		java.text.AttributedCharacterIterator itr = as.getIterator();
		itr.last();
		itr.next();
		bidi = new java.text.Bidi(itr);
		got = bidi.baseIsLeftToRight();
		if (got != expected) {
			javaT.text.Bidi.Bug7042148.err = true;
			java.lang.System.err.println(((((("Wrong Bidi(AttributedCharacterIterator).baseIsLeftToRight() value: " + "\n\ttext=") + text) + "\n\tExpected=") + expected) + "\n\tGot=") + got);
		}
	}
}