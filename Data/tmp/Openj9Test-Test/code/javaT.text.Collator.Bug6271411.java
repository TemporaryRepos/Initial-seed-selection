public class Bug6271411 extends javaT.text.testlib.IntlTest {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		javaT.text.Collator.Bug6271411 test = new javaT.text.Collator.Bug6271411();
		test.run(argv);
	}

	static final java.lang.String rule = "< c, C < d; D";

	static final java.lang.String[] values = new java.lang.String[]{ "", "c", "cH522Yd", "Hi, high school", "abcchCHidD" };

	public void Test_CollationElementIterator0007() throws java.lang.Exception {
		int[] offsets = new int[]{ java.lang.Integer.MIN_VALUE, java.lang.Integer.MIN_VALUE + 1, -10000, -2, -1, 100, 101, 12345, java.lang.Integer.MAX_VALUE - 1, java.lang.Integer.MAX_VALUE };
		boolean err = false;
		java.text.RuleBasedCollator rbc = new java.text.RuleBasedCollator(javaT.text.Collator.Bug6271411.rule);
		java.text.CollationElementIterator iterator = rbc.getCollationElementIterator("");
		for (int i = 0; i < javaT.text.Collator.Bug6271411.values.length; i++) {
			java.lang.String source = javaT.text.Collator.Bug6271411.values[i];
			iterator.setText(source);
			int len = source.length();
			offsets[5] = len + 1;
			offsets[6] = len + 2;
			for (int j = 0; j < offsets.length; j++) {
				try {
					iterator.setOffset(offsets[j]);
					java.lang.System.out.println(((("IllegalArgumentException should be thrown for setOffset(" + offsets[j]) + ") for <") + source) + ">.");
					err = true;
				} catch (java.lang.IllegalArgumentException e) {
				}
			}
		}
		if (err) {
			errln("CollationElementIterator.setOffset() didn't throw an expected IllegalArguemntException.");
		}
	}

	public void Test_CollationElementIterator0010() throws java.lang.Exception {
		java.lang.String prefix = "xyz abc";
		java.lang.String suffix = "1234567890";
		int begin = prefix.length();
		int[] offsets = new int[]{ java.lang.Integer.MIN_VALUE, java.lang.Integer.MIN_VALUE + 1, -10000, -2, -1, 0, 1, begin - 2, begin - 1, 9, 10, 11, 12, 13, 14, 15, 12345, java.lang.Integer.MAX_VALUE - 1, java.lang.Integer.MAX_VALUE };
		boolean err = false;
		java.text.RuleBasedCollator rbc = new java.text.RuleBasedCollator(javaT.text.Collator.Bug6271411.rule);
		java.text.CollationElementIterator iterator = rbc.getCollationElementIterator("");
		for (int i = 0; i < javaT.text.Collator.Bug6271411.values.length; i++) {
			java.lang.String str = (prefix + javaT.text.Collator.Bug6271411.values[i]) + suffix;
			int len = str.length();
			int end = len - suffix.length();
			java.text.CharacterIterator source = new java.text.StringCharacterIterator(str, begin, end, begin);
			iterator.setText(source);
			offsets[9] = end + 1;
			offsets[10] = end + 2;
			offsets[11] = (end + len) / 2;
			offsets[12] = len - 1;
			offsets[13] = len;
			offsets[14] = len + 1;
			offsets[15] = len + 2;
			for (int j = 0; j < offsets.length; j++) {
				try {
					iterator.setOffset(offsets[j]);
					java.lang.System.out.println(((("IllegalArgumentException should be thrown for setOffset(" + offsets[j]) + ") for <") + str) + ">.");
					err = true;
				} catch (java.lang.IllegalArgumentException e) {
				}
			}
		}
		if (err) {
			errln("CollationElementIterator.setOffset() didn't throw an expected IllegalArguemntException.");
		}
	}

	public void Test_CollationElementIterator0011() throws java.lang.Exception {
		java.lang.String prefix = "xyz abc";
		java.lang.String suffix = "1234567890";
		int begin = prefix.length();
		int[] offsets = new int[]{ begin, begin + 1, 2, 3, 4 };
		java.text.RuleBasedCollator rbc = new java.text.RuleBasedCollator(javaT.text.Collator.Bug6271411.rule);
		java.text.CollationElementIterator iterator = rbc.getCollationElementIterator("");
		for (int i = 0; i < javaT.text.Collator.Bug6271411.values.length; i++) {
			java.lang.String str = (prefix + javaT.text.Collator.Bug6271411.values[i]) + suffix;
			int len = str.length();
			int end = len - suffix.length();
			java.text.CharacterIterator source = new java.text.StringCharacterIterator(str, begin, end, begin);
			iterator.setText(source);
			offsets[2] = (end + len) / 2;
			offsets[3] = len - 1;
			offsets[4] = len;
			for (int j = 0; j < offsets.length; j++) {
				int offset = offsets[j];
				if ((offset < begin) || (offset > end)) {
					break;
				}
				iterator.setOffset(offset);
				int newOffset = iterator.getOffset();
				if (newOffset != offset) {
					throw new java.lang.RuntimeException(((((("setOffset() didn't set a correct offset. Got: " + newOffset) + " Expected: ") + offset) + " for <") + str) + ">.");
				}
			}
		}
	}
}