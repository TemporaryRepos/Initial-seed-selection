public class G7Test extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.G7Test().run(args);
	}

	private static final java.lang.String[] testCases = new java.lang.String[]{ "black-birds", "Pat", "péché", "pêche", "pécher", "pêcher", "Tod", "Töne", "Tofu", "blackbirds", "Ton", "PAT", "blackbird", "black-bird", "pat", "czar", "churo", "cat", "darn", "?", "quick", "#", "&", "aardvark", "a-rdvark", "abbot", "coop", "co-p", "cop", "zebra" };

	private static final int[][] G7Results = new int[][]{ new int[]{ 12, 13, 9, 0, 14, 1, 11, 2, 3, 4, 5, 6, 8, 10, 7, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 }, new int[]{ 12, 13, 9, 0, 14, 1, 11, 2, 3, 4, 5, 6, 8, 10, 7, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 }, new int[]{ 12, 13, 9, 0, 14, 1, 11, 2, 3, 4, 5, 6, 8, 10, 7, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 }, new int[]{ 12, 13, 9, 0, 14, 1, 11, 3, 2, 4, 5, 6, 8, 10, 7, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 }, new int[]{ 12, 13, 9, 0, 14, 1, 11, 3, 2, 4, 5, 6, 8, 10, 7, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 }, new int[]{ 12, 13, 9, 0, 14, 1, 11, 2, 3, 4, 5, 6, 8, 10, 7, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 }, new int[]{ 12, 13, 9, 0, 14, 1, 11, 2, 3, 4, 5, 6, 8, 10, 7, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 }, new int[]{ 12, 13, 9, 0, 14, 1, 11, 2, 3, 4, 5, 6, 8, 10, 7, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 } };

	private static final int[] Test1Results = new int[]{ 12, 13, 9, 0, 6, 8, 10, 7, 14, 1, 11, 2, 3, 4, 5, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 };

	private static final int[] Test2Results = new int[]{ 19, 22, 21, 23, 25, 24, 12, 13, 9, 0, 17, 26, 28, 27, 15, 16, 18, 14, 1, 11, 2, 3, 4, 5, 20, 6, 8, 10, 7, 29 };

	private static final int[] Test3Results = new int[]{ 23, 25, 22, 24, 12, 13, 9, 0, 17, 16, 26, 28, 27, 15, 18, 21, 14, 1, 11, 2, 3, 4, 5, 19, 20, 6, 8, 10, 7, 29 };

	private static final int[] Test4Results = new int[]{ 19, 22, 21, 23, 24, 25, 12, 13, 9, 0, 17, 16, 26, 27, 28, 15, 18, 14, 1, 11, 2, 3, 4, 5, 20, 6, 8, 10, 7, 29 };

	public void TestG7Data() {
		for (int i = 0; i < javaT.text.Collator.G7Test.locales.length; i++) {
			java.text.Collator myCollation = null;
			java.text.RuleBasedCollator tblColl1 = null;
			try {
				myCollation = java.text.Collator.getInstance(javaT.text.Collator.G7Test.locales[i]);
				tblColl1 = new java.text.RuleBasedCollator(((java.text.RuleBasedCollator) (myCollation)).getRules());
			} catch (java.lang.Exception foo) {
				errln(((("Exception: " + foo.getMessage()) + " Locale : ") + javaT.text.Collator.G7Test.locales[i].getDisplayName()) + " getRules failed\n");
				continue;
			}
			for (int j = 0; j < javaT.text.Collator.G7Test.FIXEDTESTSET; j++) {
				for (int n = j + 1; n < javaT.text.Collator.G7Test.FIXEDTESTSET; n++) {
					doTest(tblColl1, javaT.text.Collator.G7Test.testCases[javaT.text.Collator.G7Test.G7Results[i][j]], javaT.text.Collator.G7Test.testCases[javaT.text.Collator.G7Test.G7Results[i][n]], -1);
				}
			}
			myCollation = null;
		}
	}

	public void TestDemoTest1() {
		int j = 0;
		final java.text.Collator myCollation = java.text.Collator.getInstance(java.util.Locale.US);
		final java.lang.String defRules = ((java.text.RuleBasedCollator) (myCollation)).getRules();
		java.text.RuleBasedCollator tblColl = null;
		java.lang.String newRules = defRules + " & Z < p, P";
		try {
			tblColl = new java.text.RuleBasedCollator(newRules);
			for (j = 0; j < javaT.text.Collator.G7Test.FIXEDTESTSET; j++) {
				for (int n = j + 1; n < javaT.text.Collator.G7Test.FIXEDTESTSET; n++) {
					doTest(tblColl, javaT.text.Collator.G7Test.testCases[javaT.text.Collator.G7Test.Test1Results[j]], javaT.text.Collator.G7Test.testCases[javaT.text.Collator.G7Test.Test1Results[n]], -1);
				}
			}
			tblColl = null;
		} catch (java.lang.Exception foo) {
			errln(("Exception: " + foo.getMessage()) + "\nDemo Test 1 Table Collation object creation failed.");
		}
	}

	public void TestDemoTest2() {
		final java.text.Collator myCollation = java.text.Collator.getInstance(java.util.Locale.US);
		final java.lang.String defRules = ((java.text.RuleBasedCollator) (myCollation)).getRules();
		java.lang.String newRules = defRules + "& C < ch , cH, Ch, CH";
		try {
			java.text.RuleBasedCollator tblColl = new java.text.RuleBasedCollator(newRules);
			for (int j = 0; j < javaT.text.Collator.G7Test.TOTALTESTSET; j++) {
				for (int n = j + 1; n < javaT.text.Collator.G7Test.TOTALTESTSET; n++) {
					doTest(tblColl, javaT.text.Collator.G7Test.testCases[javaT.text.Collator.G7Test.Test2Results[j]], javaT.text.Collator.G7Test.testCases[javaT.text.Collator.G7Test.Test2Results[n]], -1);
				}
			}
		} catch (java.lang.Exception foo) {
			errln(("Exception: " + foo.getMessage()) + "\nDemo Test 2 Table Collation object creation failed.\n");
		}
	}

	public void TestDemoTest3() {
		final java.text.Collator myCollation = java.text.Collator.getInstance(java.util.Locale.US);
		final java.lang.String defRules = ((java.text.RuleBasedCollator) (myCollation)).getRules();
		java.text.RuleBasedCollator tblColl = null;
		java.lang.String newRules = defRules + "& Question'-'mark ; '?' & Hash'-'mark ; '#' & Ampersand ; '&";
		try {
			tblColl = new java.text.RuleBasedCollator(newRules);
			for (int j = 0; j < javaT.text.Collator.G7Test.TOTALTESTSET; j++) {
				for (int n = j + 1; n < javaT.text.Collator.G7Test.TOTALTESTSET; n++) {
					doTest(tblColl, javaT.text.Collator.G7Test.testCases[javaT.text.Collator.G7Test.Test3Results[j]], javaT.text.Collator.G7Test.testCases[javaT.text.Collator.G7Test.Test3Results[n]], -1);
				}
			}
		} catch (java.lang.Exception foo) {
			errln(("Exception: " + foo.getMessage()) + "\nDemo Test 3 Table Collation object creation failed.");
		}
	}

	public void TestDemoTest4() {
		final java.text.Collator myCollation = java.text.Collator.getInstance(java.util.Locale.US);
		final java.lang.String defRules = ((java.text.RuleBasedCollator) (myCollation)).getRules();
		java.text.RuleBasedCollator tblColl = null;
		java.lang.String newRules = defRules + " & aa ; a'-' & ee ; e'-' & ii ; i'-' & oo ; o'-' & uu ; u'-' ";
		try {
			tblColl = new java.text.RuleBasedCollator(newRules);
			for (int j = 0; j < javaT.text.Collator.G7Test.TOTALTESTSET; j++) {
				for (int n = j + 1; n < javaT.text.Collator.G7Test.TOTALTESTSET; n++) {
					doTest(tblColl, javaT.text.Collator.G7Test.testCases[javaT.text.Collator.G7Test.Test4Results[j]], javaT.text.Collator.G7Test.testCases[javaT.text.Collator.G7Test.Test4Results[n]], -1);
				}
			}
		} catch (java.lang.Exception foo) {
			errln(("Exception: " + foo.getMessage()) + "\nDemo Test 4 Table Collation object creation failed.");
		}
		tblColl = null;
	}

	private static final int FIXEDTESTSET = 15;

	private static final int TOTALTESTSET = 30;

	private static final java.util.Locale[] locales = new java.util.Locale[]{ java.util.Locale.US, java.util.Locale.UK, java.util.Locale.CANADA, java.util.Locale.FRANCE, java.util.Locale.CANADA_FRENCH, java.util.Locale.GERMANY, java.util.Locale.JAPAN, java.util.Locale.ITALY };
}