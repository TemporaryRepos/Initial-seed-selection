public class Test4401726 extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.Test4401726().run(args);
	}

	public void TestSetOffSet() {
		int[] expected = new int[]{ 0, -1, 65536 };
		int[] actual = new int[expected.length];
		try {
			java.lang.String rule = "< a, A < d; D";
			java.text.RuleBasedCollator rbc = new java.text.RuleBasedCollator(rule);
			java.lang.String str = "aD";
			java.text.CollationElementIterator iterator = rbc.getCollationElementIterator(str);
			iterator.setOffset(0);
			actual[0] = iterator.getOffset();
			actual[1] = iterator.previous();
			iterator.setOffset(0);
			actual[2] = iterator.next();
			if (compareArray(expected, actual) == false) {
				errln("Failed.");
			}
			str = "a";
			iterator = rbc.getCollationElementIterator(str);
			iterator.setOffset(0);
			actual[0] = iterator.getOffset();
			actual[1] = iterator.previous();
			iterator.setOffset(0);
			actual[2] = iterator.next();
			if (compareArray(expected, actual) == false) {
				errln("Failed.");
			}
		} catch (java.text.ParseException e) {
			errln("Unexpected ParseException: " + e);
		}
	}

	boolean compareArray(int[] expected, int[] actual) {
		boolean retVal = false;
		if (expected.length == actual.length) {
			int errors = 0;
			for (int x = 0; x < expected.length; ++x) {
				if (expected[x] != actual[x]) {
					++errors;
				}
			}
			if (errors == 0) {
				retVal = true;
			}
		}
		return retVal;
	}
}