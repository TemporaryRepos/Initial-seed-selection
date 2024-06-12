public class SurrogatesTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.SurrogatesTest().run(args);
	}

	private static final java.lang.String[] primarySourceData = new java.lang.String[]{ "A𐀄BCD" };

	private static final java.lang.String[] primaryTargetData = new java.lang.String[]{ "A𐀅BCD" };

	private static final int[] primaryResults = new int[]{ 0 };

	private static final java.lang.String[] tertiarySourceData = new java.lang.String[]{ "ABCD", "ABCD", "A𐀀CD", "WXYZ", "WXYZ", "AFEM", "FGM", "BB", "BB" };

	private static final java.lang.String[] tertiaryTargetData = new java.lang.String[]{ "A𐀀CD", "AB𐀀D", "A𐀁CD", "W𐀊YZ", "W𐀋YZ", "A𐀈M", "𐀈M", "𐀄𐀂", "𐀄𐀅" };

	private static final int[] tertiaryResults = new int[]{ -1, 1, 1, 1, -1, -1, -1, -1, 1 };

	public void TestPrimary() {
		doTest(myCollation, java.text.Collator.PRIMARY, javaT.text.Collator.SurrogatesTest.primarySourceData, javaT.text.Collator.SurrogatesTest.primaryTargetData, javaT.text.Collator.SurrogatesTest.primaryResults);
	}

	public void TestTertiary() {
		doTest(myCollation, java.text.Collator.TERTIARY, javaT.text.Collator.SurrogatesTest.tertiarySourceData, javaT.text.Collator.SurrogatesTest.tertiaryTargetData, javaT.text.Collator.SurrogatesTest.tertiaryResults);
	}

	private java.text.Collator getCollator() {
		java.text.RuleBasedCollator base = ((java.text.RuleBasedCollator) (java.text.Collator.getInstance()));
		java.lang.String rule = base.getRules();
		try {
			return new java.text.RuleBasedCollator(((((((((rule + "&B < 𐀁 < 𐀀") + ", 𐀂, 𐀃") + "; 𐀄, 𐀅") + "< 𐀆 < 𐀇") + "&FE < 𐀈") + "&PE, 𐀉") + "&Z < 𐀊 < 𐀋 < 𐀌") + "&𐀊 < x, X") + "&A < 𐀄𐀅");
		} catch (java.lang.Exception e) {
			errln("Failed to create new RulebasedCollator object");
			return null;
		}
	}

	private java.text.Collator myCollation = getCollator();
}