public class FinnishTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.FinnishTest().run(args);
	}

	private static final java.lang.String[] primarySourceData = new java.lang.String[]{ "Låvi", "wat" };

	private static final java.lang.String[] primaryTargetData = new java.lang.String[]{ "Läwe", "vat" };

	private static final int[] primaryResults = new int[]{ -1, 0 };

	private static final java.lang.String[] tertiarySourceData = new java.lang.String[]{ "wat", "vat", "aübeck" };

	private static final java.lang.String[] tertiaryTargetData = new java.lang.String[]{ "vat", "way", "axbeck" };

	private static final int[] tertiaryResults = new int[]{ 1, -1, 1 };

	public void TestPrimary() {
		doTest(myCollation, java.text.Collator.PRIMARY, javaT.text.Collator.FinnishTest.primarySourceData, javaT.text.Collator.FinnishTest.primaryTargetData, javaT.text.Collator.FinnishTest.primaryResults);
	}

	public void TestTertiary() {
		doTest(myCollation, java.text.Collator.TERTIARY, javaT.text.Collator.FinnishTest.tertiarySourceData, javaT.text.Collator.FinnishTest.tertiaryTargetData, javaT.text.Collator.FinnishTest.tertiaryResults);
	}

	private final java.text.Collator myCollation = java.text.Collator.getInstance(new java.util.Locale("fi", "FI", ""));
}