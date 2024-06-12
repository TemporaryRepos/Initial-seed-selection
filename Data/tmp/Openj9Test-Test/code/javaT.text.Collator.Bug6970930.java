public class Bug6970930 {
	private static boolean err = false;

	public static void main(java.lang.String[] args) {
		javaT.text.Collator.Bug6970930.test1(null, null);
		javaT.text.Collator.Bug6970930.test1("\"foo\"", null);
		javaT.text.Collator.Bug6970930.test1(null, "\"bar\"");
		if (javaT.text.Collator.Bug6970930.err) {
			throw new java.lang.RuntimeException("Failed.");
		} else {
			java.lang.System.out.println("Passed.");
		}
	}

	private static void test1(java.lang.String s1, java.lang.String s2) {
		java.text.RuleBasedCollator col = null;
		try {
			col = new java.text.RuleBasedCollator("< a < b");
		} catch (java.text.ParseException e) {
			javaT.text.Collator.Bug6970930.err = true;
			java.lang.System.err.println(e);
		}
		try {
			col.compare("foo", "bar");
			col.compare(s1, s2);
			javaT.text.Collator.Bug6970930.err = true;
			java.lang.System.err.println(((("No exception was thrown for compare(" + s1) + ", ") + s2) + ").");
		} catch (java.lang.NullPointerException e) {
			java.lang.System.out.println(((("NPE was thrown as expected for compare(" + s1) + ", ") + s2) + ").");
		} catch (java.lang.Exception e) {
			javaT.text.Collator.Bug6970930.err = true;
			java.lang.System.err.println((((("Unexpected exception was thrown for compare(" + s1) + ", ") + s2) + "): ") + e);
		}
	}
}