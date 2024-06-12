public class SpanishTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.SpanishTest().run(args);
	}

	private static final java.lang.String[] primarySourceData = new java.lang.String[]{ "alias", "acHc", "acc", "Hello" };

	private static final java.lang.String[] primaryTargetData = new java.lang.String[]{ "allias", "aCHc", "aCHc", "hellO" };

	private static final int[] primaryResults = new int[]{ -1, 0, -1, 0 };

	private static final java.lang.String[] tertiarySourceData = new java.lang.String[]{ "alias", "Elliot", "Hello", "acHc", "acc" };

	private static final java.lang.String[] tertiaryTargetData = new java.lang.String[]{ "allias", "Emiot", "hellO", "aCHc", "aCHc" };

	private static final int[] tertiaryResults = new int[]{ -1, -1, 1, -1, -1 };

	public void TestPrimary() {
		doTest(myCollation, java.text.Collator.PRIMARY, javaT.text.Collator.SpanishTest.primarySourceData, javaT.text.Collator.SpanishTest.primaryTargetData, javaT.text.Collator.SpanishTest.primaryResults);
	}

	public void TestTertiary() {
		doTest(myCollation, java.text.Collator.TERTIARY, javaT.text.Collator.SpanishTest.tertiarySourceData, javaT.text.Collator.SpanishTest.tertiaryTargetData, javaT.text.Collator.SpanishTest.tertiaryResults);
	}

	private final java.text.Collator myCollation = java.text.Collator.getInstance(new java.util.Locale("es", "ES", ""));
}