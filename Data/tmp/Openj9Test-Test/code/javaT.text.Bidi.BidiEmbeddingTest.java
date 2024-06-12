public class BidiEmbeddingTest {
	public static void main(java.lang.String[] args) {
		if (args.length > 0) {
			java.awt.Frame f = new java.awt.Frame();
			f.setSize(300, 300);
			f.setBackground(java.awt.Color.white);
			f.show();
		}
		javaT.text.Bidi.BidiEmbeddingTest.test1();
		javaT.text.Bidi.BidiEmbeddingTest.test2();
	}

	static void test1() {
		java.lang.String target = "BACK WARDS";
		java.lang.String str = ("If this text is >" + target) + "< the test passed.";
		int start = str.indexOf(target);
		int limit = start + target.length();
		java.lang.System.out.println((("start: " + start) + " limit: ") + limit);
		java.text.AttributedString astr = new java.text.AttributedString(str);
		astr.addAttribute(java.awt.font.TextAttribute.BIDI_EMBEDDING, new java.lang.Integer(-1), start, limit);
		java.text.Bidi bidi = new java.text.Bidi(astr.getIterator());
		for (int i = 0; i < bidi.getRunCount(); ++i) {
			java.lang.System.out.println((((((("run " + i) + " from ") + bidi.getRunStart(i)) + " to ") + bidi.getRunLimit(i)) + " at level ") + bidi.getRunLevel(i));
		}
		java.lang.System.out.println(bidi);
		byte[] embs = new byte[str.length() + 3];
		for (int i = start + 1; i < (limit + 1); ++i) {
			embs[i] = -1;
		}
		java.text.Bidi bidi2 = new java.text.Bidi(str.toCharArray(), 0, embs, 1, str.length(), java.text.Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
		for (int i = 0; i < bidi2.getRunCount(); ++i) {
			java.lang.System.out.println((((((("run " + i) + " from ") + bidi2.getRunStart(i)) + " to ") + bidi2.getRunLimit(i)) + " at level ") + bidi2.getRunLevel(i));
		}
		java.lang.System.out.println(bidi2 + "\n");
		if ((bidi.getRunCount() != 3) || (bidi2.getRunCount() != 3)) {
			throw new java.lang.Error("Bidi run count incorrect");
		} else {
			java.lang.System.out.println("test1() passed.\n");
		}
	}

	static void test2() {
		java.lang.String target = "BACK WARDS";
		java.lang.String str = ("If this text is >" + target) + "< the test passed.";
		int length = str.length();
		int start = str.indexOf(target);
		int limit = start + target.length();
		java.lang.System.out.println((("start: " + start) + " limit: ") + limit);
		java.text.AttributedString astr = new java.text.AttributedString(str);
		astr.addAttribute(java.awt.font.TextAttribute.RUN_DIRECTION, java.awt.font.TextAttribute.RUN_DIRECTION_RTL);
		astr.addAttribute(java.awt.font.TextAttribute.BIDI_EMBEDDING, new java.lang.Integer(-3), start, limit);
		java.text.Bidi bidi = new java.text.Bidi(astr.getIterator());
		for (int i = 0; i < bidi.getRunCount(); ++i) {
			java.lang.System.out.println((((((("run " + i) + " from ") + bidi.getRunStart(i)) + " to ") + bidi.getRunLimit(i)) + " at level ") + bidi.getRunLevel(i));
		}
		java.lang.System.out.println(bidi + "\n");
		if (bidi.getRunCount() != 6) {
			throw new java.lang.Error("Bidi embedding processing failed");
		} else {
			java.lang.System.out.println("test2() passed.\n");
		}
	}
}