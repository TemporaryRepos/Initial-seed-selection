public class DanishTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.DanishTest().run(args);
	}

	private static final java.lang.String[] primarySourceData = new java.lang.String[]{ "Lvi", "Lävi", "Lübeck", "ANDRÉ", "ANDRE", "ANNONCERER" };

	private static final java.lang.String[] primaryTargetData = new java.lang.String[]{ "Lwi", "Löwi", "Lybeck", "ANDRé", "ANDRÉ", "ANNÓNCERER" };

	private static final int[] primaryResults = new int[]{ -1, -1, 0, 0, 0, 0 };

	private static final java.lang.String[] tertiarySourceData = new java.lang.String[]{ "Luc", "luck", "Lübeck", "Lävi", "Löww" };

	private static final java.lang.String[] tertiaryTargetData = new java.lang.String[]{ "luck", "Lübeck", "lybeck", "Löwe", "mast" };

	private static final int[] tertiaryResults = new int[]{ -1, -1, 1, -1, -1 };

	private static final java.lang.String[] testData = new java.lang.String[]{ "A/S", "ANDRE", "ANDRÉ", "ANDRÈ", "ANDRé", "ANDRê", "Andre", "André", "ÁNDRE", "ÀNDRE", "andre", "ándre", "àndre", "ANDREAS", "ANNONCERER", "ANNÓNCERER", "annoncerer", "annóncerer", "AS", "AæRO", "CA", "ÇA", "CB", "ÇC", "D.S.B.", "DA", "DB", "ÐORA", "DSB", "ÐSB", "DSC", "EKSTRA_ARBEJDE", "EKSTRABUD", "HØST", "HAAG", "HÅNDBOG", "HAANDVÆRKSBANKEN", "INTERNETFORBINDELSE", "Internetforbindelse", "ÍNTERNETFORBINDELSE", "internetforbindelse", "ínternetforbindelse", "Karl", "karl", "NIELSEN", "NIELS JØRGEN", "NIELS-JØRGEN", "OERVAL", "ŒRVAL", "œRVAL", "RÉE, A", "REE, B", "RÉE, L", "REE, V", "SCHYTT, B", "SCHYTT, H", "SCHÜTT, H", "SCHYTT, L", "SCHÜTT, M", "SS", "ss", "ß", "SSA", "ßA", "STOREKÆR", "STORE VILDMOSE", "STORMLY", "STORM PETERSEN", "THORVALD", "THORVARDUR", "ÞORVARĐUR", "THYGESEN", "VESTERGÅRD, A", "VESTERGAARD, A", "VESTERGÅRD, B", "Westmalle", "YALLE", "Yderligere", "Ýderligere", "Üderligere", "ýderligere", "üderligere", "Üruk-hai", "ZORO", "ÆBLE", "æBLE", "ÄBLE", "äBLE", "ØBERG", "øBERG", "ÖBERG", "öBERG" };

	public void TestPrimary() {
		doTest(myCollation, java.text.Collator.PRIMARY, javaT.text.Collator.DanishTest.primarySourceData, javaT.text.Collator.DanishTest.primaryTargetData, javaT.text.Collator.DanishTest.primaryResults);
	}

	public void TestTertiary() {
		doTest(myCollation, java.text.Collator.TERTIARY, javaT.text.Collator.DanishTest.tertiarySourceData, javaT.text.Collator.DanishTest.tertiaryTargetData, javaT.text.Collator.DanishTest.tertiaryResults);
		for (int i = 0; i < (javaT.text.Collator.DanishTest.testData.length - 1); i++) {
			for (int j = i + 1; j < javaT.text.Collator.DanishTest.testData.length; j++) {
				doTest(myCollation, javaT.text.Collator.DanishTest.testData[i], javaT.text.Collator.DanishTest.testData[j], -1);
			}
		}
	}

	private final java.text.Collator myCollation = java.text.Collator.getInstance(new java.util.Locale("da", "", ""));
}