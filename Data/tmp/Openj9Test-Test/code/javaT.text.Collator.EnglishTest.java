public class EnglishTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.EnglishTest().run(args);
	}

	private static final java.lang.String[] primarySourceData = new java.lang.String[]{ "pêche", "abc", "abc", "abc", "aæc" };

	private static final java.lang.String[] primaryTargetData = new java.lang.String[]{ "péché", "aBC", "abd", "äbc", "aÆc" };

	private static final int[] primaryResults = new int[]{ 0, 0, -1, 0, 0 };

	private static final java.lang.String[] secondarySourceData = new java.lang.String[]{ "abc", "abc", "aæc", "abc", "abc", "péché" };

	private static final java.lang.String[] secondaryTargetData = new java.lang.String[]{ "aBd", "äbc", "aÆc", "aBd", "äbc", "pêche" };

	private static final int[] secondaryResults = new int[]{ -1, -1, 0, -1, -1, -1 };

	private static final java.lang.String[] tertiarySourceData = new java.lang.String[]{ "ab", "black-bird", "black bird", "black-bird", "Hello", "ABC", "abc", "blackbird", "black-bird", "black-bird", "pêche", "péché", "ÄB̈C̈", "äbc", "pécher", "roles", "abc", "A", "A", "ab", "tcompareplain", "ab", "a#b", "a#b", "abc", "Abcda", "abcda", "abcda", "æbcda", "äbcda", "abc", "abc", "abc", "abc", "abc", "acHc", "äbc", "thîs" };

	private static final java.lang.String[] tertiaryTargetData = new java.lang.String[]{ "abc", "blackbird", "black-bird", "black", "hello", "ABC", "ABC", "blackbirds", "blackbirds", "blackbird", "péché", "pécher", "ÄB̈C̈", "Äbc", "péche", "rôle", "Aácd", "Aácd", "abc", "abc", "TComparePlain", "aBc", "a#B", "a&b", "a#c", "abcda", "Äbcda", "äbcda", "Äbcda", "Äbcda", "ab#c", "abc", "ab=c", "abd", "äbc", "aCHc", "äbc", "thîs" };

	private static final int[] tertiaryResults = new int[]{ -1, 1, -1, 1, 1, 0, -1, -1, -1, 1, 1, -1, 0, -1, 1, 1, 1, -1, -1, -1, -1, -1, -1, 1, 1, 1, -1, -1, 1, -1, 1, 0, 1, -1, -1, -1, 0, 0 };

	private static final java.lang.String[] testData = new java.lang.String[]{ "a", "A", "e", "E", "é", "è", "ê", "ë", "ea", "x" };

	public void TestPrimary() {
		doTest(myCollation, java.text.Collator.PRIMARY, javaT.text.Collator.EnglishTest.primarySourceData, javaT.text.Collator.EnglishTest.primaryTargetData, javaT.text.Collator.EnglishTest.primaryResults);
	}

	public void TestSecondary() {
		doTest(myCollation, java.text.Collator.SECONDARY, javaT.text.Collator.EnglishTest.secondarySourceData, javaT.text.Collator.EnglishTest.secondaryTargetData, javaT.text.Collator.EnglishTest.secondaryResults);
	}

	public void TestTertiary() {
		doTest(myCollation, java.text.Collator.TERTIARY, javaT.text.Collator.EnglishTest.tertiarySourceData, javaT.text.Collator.EnglishTest.tertiaryTargetData, javaT.text.Collator.EnglishTest.tertiaryResults);
		for (int i = 0; i < (javaT.text.Collator.EnglishTest.testData.length - 1); i++) {
			for (int j = i + 1; j < javaT.text.Collator.EnglishTest.testData.length; j++) {
				doTest(myCollation, javaT.text.Collator.EnglishTest.testData[i], javaT.text.Collator.EnglishTest.testData[j], -1);
			}
		}
	}

	private final java.text.Collator myCollation = java.text.Collator.getInstance(java.util.Locale.ENGLISH);
}