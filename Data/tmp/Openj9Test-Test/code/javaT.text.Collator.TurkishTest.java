public class TurkishTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.TurkishTest().run(args);
	}

	private static final java.lang.String[] primarySourceData = new java.lang.String[]{ "üoid", "voıd", "idea", "Idea", "İdea" };

	private static final java.lang.String[] primaryTargetData = new java.lang.String[]{ "void", "void", "Idea", "İdea", "ıdea" };

	private static final int[] primaryResults = new int[]{ -1, -1, 1, -1, 1 };

	private static final java.lang.String[] tertiarySourceData = new java.lang.String[]{ "ş", "vät", "old", "üoid", "hĞalt", "stresŞ", "voıd", "idea", "idea", "ıdea" };

	private static final java.lang.String[] tertiaryTargetData = new java.lang.String[]{ "ü", "vbt", "Öay", "void", "halt", "ŞtreŞs", "void", "Idea", "İdea", "Idea" };

	private static final int[] tertiaryResults = new int[]{ -1, -1, -1, -1, 1, -1, -1, 1, -1, -1 };

	public void TestPrimary() {
		doTest(myCollation, java.text.Collator.PRIMARY, javaT.text.Collator.TurkishTest.primarySourceData, javaT.text.Collator.TurkishTest.primaryTargetData, javaT.text.Collator.TurkishTest.primaryResults);
	}

	public void TestTertiary() {
		doTest(myCollation, java.text.Collator.TERTIARY, javaT.text.Collator.TurkishTest.tertiarySourceData, javaT.text.Collator.TurkishTest.tertiaryTargetData, javaT.text.Collator.TurkishTest.tertiaryResults);
	}

	private final java.text.Collator myCollation = java.text.Collator.getInstance(new java.util.Locale("tr", "TR", ""));
}