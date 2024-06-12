public class Bug7051769 {
	private static boolean err = false;

	public static void main(java.lang.String[] args) {
		javaT.text.Bidi.Bug7051769.testNumericShaping();
		if (javaT.text.Bidi.Bug7051769.err) {
			throw new java.lang.RuntimeException("Failed");
		} else {
			java.lang.System.out.println("Passed.");
		}
	}

	private static void testNumericShaping() {
		java.util.Map attrNS = new java.util.HashMap();
		attrNS.put(java.awt.font.TextAttribute.NUMERIC_SHAPING, java.awt.font.NumericShaper.getContextualShaper(java.awt.font.NumericShaper.ARABIC));
		attrNS.put(java.awt.font.TextAttribute.RUN_DIRECTION, java.awt.font.TextAttribute.RUN_DIRECTION_RTL);
		java.lang.String text = "أكتوبر 10";
		java.lang.String expected = "sun.text.bidi.BidiBase[dir: 2 baselevel: 1 length: 9 runs: [1 1 1 1 1 1 1 2 2] text: [0x623 0x643 0x62a 0x648 0x628 0x631 0x20 0x661 0x660]]";
		java.text.AttributedString as = new java.text.AttributedString(text, attrNS);
		java.text.AttributedCharacterIterator itr = as.getIterator();
		itr.last();
		itr.next();
		java.text.Bidi bidi = new java.text.Bidi(itr);
		java.lang.String got = bidi.toString();
		if (!got.equals(expected)) {
			javaT.text.Bidi.Bug7051769.err = true;
			java.lang.System.err.println(((("Wrong toString() output: " + "\n\tExpected=") + expected) + "\n\tGot=") + got);
		}
	}
}