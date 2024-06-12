public class GermanTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.GermanTest().run(args);
	}

	private static final java.lang.String[] testSourceData = new java.lang.String[]{ "Größe", "abc", "Töne", "Töne", "Töne", "äbc", "äbc", "äbc", "Straße", "efg", "äbc", "Straße" };

	private static final java.lang.String[] testTargetData = new java.lang.String[]{ "Grossist", "äbc", "Ton", "Tod", "Tofu", "Äbc", "äbc", "aebc", "Strasse", "efg", "aebc", "Strasse" };

	private static final int[] primaryResults = new int[]{ -1, 0, 1, 1, 1, 0, 0, -1, 0, 0, -1, 0 };

	private static final int[] tertiaryResults = new int[]{ -1, -1, 1, 1, 1, -1, 0, -1, 1, 0, -1, 1 };

	public void TestPrimary() {
		doTest(myCollation, java.text.Collator.PRIMARY, javaT.text.Collator.GermanTest.testSourceData, javaT.text.Collator.GermanTest.testTargetData, javaT.text.Collator.GermanTest.primaryResults);
	}

	public void TestTertiary() {
		doTest(myCollation, java.text.Collator.TERTIARY, javaT.text.Collator.GermanTest.testSourceData, javaT.text.Collator.GermanTest.testTargetData, javaT.text.Collator.GermanTest.tertiaryResults);
	}

	private final java.text.Collator myCollation = java.text.Collator.getInstance(java.util.Locale.GERMAN);
}