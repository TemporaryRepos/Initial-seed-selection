public class FrenchTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.FrenchTest().run(args);
	}

	private static final java.lang.String[] tertiarySourceData = new java.lang.String[]{ "abc", "COTE", "pêche", "pêcher", "pécher", "pécher", "Hello" };

	private static final java.lang.String[] tertiaryTargetData = new java.lang.String[]{ "ABC", "côte", "péché", "péché", "pêche", "pêcher", "hellO" };

	private static final int[] tertiaryResults = new int[]{ -1, -1, -1, 1, 1, -1, 1 };

	private static final java.lang.String[] testData = new java.lang.String[]{ "a", "A", "e", "E", "é", "è", "ê", "ë", "ea", "x" };

	public void TestTertiary() {
		doTest(myCollation, java.text.Collator.TERTIARY, javaT.text.Collator.FrenchTest.tertiarySourceData, javaT.text.Collator.FrenchTest.tertiaryTargetData, javaT.text.Collator.FrenchTest.tertiaryResults);
		for (int i = 0; i < (javaT.text.Collator.FrenchTest.testData.length - 1); i++) {
			for (int j = i + 1; j < javaT.text.Collator.FrenchTest.testData.length; j++) {
				doTest(myCollation, javaT.text.Collator.FrenchTest.testData[i], javaT.text.Collator.FrenchTest.testData[j], -1);
			}
		}
	}

	private final java.text.Collator myCollation = java.text.Collator.getInstance(java.util.Locale.FRANCE);
}