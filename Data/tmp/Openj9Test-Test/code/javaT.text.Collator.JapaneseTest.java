public class JapaneseTest {
	static final int[][] results1 = new int[][]{ new int[]{ -1, -1, -1 }, new int[]{ -1, -1, -1 }, new int[]{ -1, -1, -1 } };

	static final java.lang.String[][] compData1 = new java.lang.String[][]{ new java.lang.String[]{ "や", "ユ", "Hiragana \"YA\"(0x3084) <---> Katakana \"YU\"(0x30E6)" }, new java.lang.String[]{ "ユ", "よ", "Katakana \"YU\"(0x30E6) <---> Hiragana \"YO\"(0x3088)" }, new java.lang.String[]{ "±", "≠", "Plus-Minus Sign(0x00B1) <---> Not Equal To(0x2260)" }, new java.lang.String[]{ "】", "≠", "Right Black Lenticular Bracket(0x3011) <---> Not Equal To(0x2260)" }, new java.lang.String[]{ "≠", "℃", "Not Equal To(0x2260) <---> Degree Celsius(0x2103)" }, new java.lang.String[]{ "≠", "☆", "Not Equal To(0x2260) <---> White Star(0x2606)" }, new java.lang.String[]{ "ヽ", "ゞ", "Katakana Iteration Mark(0x30FD) <---> Hiragana Voiced Iteration Mark(0x309E)" }, new java.lang.String[]{ "すゝ", "すゞ", "Hiragana \"SU\"(0x3059)Hiragana Iteration Mark(0x309D) <---> Hiragana \"SU\"(0x3059)Hiragana Voiced Iteration Mark(0x309E)" }, new java.lang.String[]{ "舞", "福", "CJK Unified Ideograph(0x821E) <---> CJK Unified Ideograph(0x798F)" }, new java.lang.String[]{ "≠", "≟", "Not Equal To(0x2260) <---> Questioned Equal To(0x225F)" }, new java.lang.String[]{ "≮", "≠", "Not Less-than(0x226E) <---> Not Equal To(0x2260)" }, new java.lang.String[]{ "≮", "≭", "Not Less-than(0x226E) <---> Not Equivalent To(0x226D)" } };

	static final int[][] results2 = new int[][]{ new int[]{ 0, 0, 0 }, new int[]{ -1, -1, -1 }, new int[]{ -1, -1, -1 } };

	static final java.lang.String[][] compData2 = new java.lang.String[][]{ new java.lang.String[]{ "゙", "゚", "Combining Katakana-Hiragana Voiced Sound Mark(0x3099) <---> Combining Katakana-Hiragana Semi-voiced Sound Mark(0x309A)" }, new java.lang.String[]{ "こうとう", "こうどう", "Hiragana \"KOUTOU\"(0x3053 0x3046 0x3068 0x3046) <---> Hiragana \"KOUTO\"(0x3053 0x3046 0x3068)Combining Katakana-Hiragana Voiced Sound Mark(0X3099)\"U\"(0x3046)" }, new java.lang.String[]{ "こうとう", "こうどう", "Hiragana \"KOUTOU\"(0x3053 0x3046 0x3068 0x3046) <---> Hiragana \"KOUDOU\"(0x3053 0x3046 0x3069 0x3046)" }, new java.lang.String[]{ "こうどう", "ごうとう", "Hiragana \"KOUTOU\"(0x3053 0x3046 0x3069 0x3046) <---> Hiragana \"GOUTOU\"(0x3054 0x3046 0x3068 0x3046)" }, new java.lang.String[]{ "ごうとう", "ごうどう", "Hiragana \"GOUTOU\"(0x3054 0x3046 0x3068 0x3046) <---> Hiragana \"GOUDOU\"(0x3054 0x3046 0x3069 0x3046)" } };

	static final int[][] results3 = new int[][]{ new int[]{ 0, 0, 0 }, new int[]{ 0, 0, 0 }, new int[]{ -1, -1, -1 } };

	static final java.lang.String[][] compData3 = new java.lang.String[][]{ new java.lang.String[]{ "あ", "ぁ", "Hiragana \"A\"(0x3042) <---> Hiragana \"a\"(0x3041)" }, new java.lang.String[]{ "ぁ", "ア", "Hiragana \"a\"(0x3041) <---> Katakana \"A\"(0x30A2)" }, new java.lang.String[]{ "ア", "ァ", "Katakana \"A\"(0x30A2) <---> Katakana \"a\"(0x30A1)" }, new java.lang.String[]{ "ゔ", "ヴ", "Hiragana \"VU\"(0x3094) <---> Katakana \"VU\"(0x30F4)" }, new java.lang.String[]{ "ゔ", "ヴ", "Hiragana \"VU\"(0x3094) <---> Katakana \"U\"(0x30A6)Combining Katakana-Hiragana Voiced Sound Mark(0x3099)" }, new java.lang.String[]{ "ゔ", "ヴ", "Hiragana \"U\"(0x3046)Combining Katakana-Hiragana Voiced Sound Mark(0x3099) <---> Katakana \"VU\"(0x30F4)" }, new java.lang.String[]{ "ゔ", "ヴ", "Hiragana \"U\"(0x3046)Combining Katakana-Hiragana Voiced Sound Mark(0x3099) <---> Katakana \"U\"(0x30A6)Combining Katakana-Hiragana Voiced Sound Mark(0x3099)" }, new java.lang.String[]{ "カア", "カー", "Katakana \"KAA\"(0x30AB 0x30A2) <---> Katakana \"KA-\"(0x30AB 0x30FC)" }, new java.lang.String[]{ "ニァア", "ニァー", "Katakana \"NyaA\"(0x30CB 0x30A1 0x30A2) <---> Katakana \"Nya-\"(0x30CB 0x30A1 0x30FC)" }, new java.lang.String[]{ "コオヒイ", "コーヒー", "Katakana \"KOOHII\"(0x30B3 0x30AA 0x30D2 0x30A4) <---> Katakana \"KO-HI-\"(0x30B3 0x30FC 0x30D2 0x30FC)" }, new java.lang.String[]{ "りよう", "りょう", "Hiragana \"RIYOU\"(0x308A 0x3088 0x3046) <---> Hiragana \"Ryou\"(0x308A 0x3087 0x3046)" }, new java.lang.String[]{ "めつき", "めっき", "Hiragana \"METSUKI\"(0x3081 0x3064 0x304D) <---> Hiragana \"MEKKI\"(0x3081 0x3063 0x304D)" }, new java.lang.String[]{ "ふあん", "ファン", "Hiragana \"FUAN\"(0x3075 0x3042 0x3093) <---> Katakana \"FUaN\"(0x30D5 0x30A1 0x30F3)" }, new java.lang.String[]{ "ふぁん", "フアン", "Hiragana \"FUaN\"(0x3075 0x3041 0x3093) <---> Katakana \"FUAN\"(0x30D5 0x30A2 0x30F3)" }, new java.lang.String[]{ "フアン", "ファン", "Katakana \"FUAN\"(0x30D5 0x30A2 0x30F3) <---> Katakana \"FUaN\"(0x30D5 0x30A1 0x30F3)" } };

	static final int[][] results4 = new int[][]{ new int[]{ 0, 0, 0 }, new int[]{ 0, 0, 0 }, new int[]{ 0, 0, 0 } };

	static final java.lang.String[][] compData4 = new java.lang.String[][]{ new java.lang.String[]{ "ゞ", "ゞ", "Hiragana Voiced Iteration Mark(0x309E) <---> Hiragana Iteration Mark(0x309D)Combining Katakana-Hiragana Voiced Sound Mark(0x3099)" }, new java.lang.String[]{ "ヾ", "ヾ", "Katakana Voiced Iteration Mark(0x30FE) <---> Katakana iteration mark(0x30FD)Combining Katakana-Hiragana Voiced Sound Mark(0x3099)" }, new java.lang.String[]{ "ば", "ば", "Hiragana \"HA\"(0x306F)Combining Katakana-Hiragana Voiced Sound Mark(0x3099) <---> Hiragana \"BA\"(0x3070)" }, new java.lang.String[]{ "ぱ", "ぱ", "Hiragana \"HA\"(0x306F)Combining Katakana-Hiragana Semi-voiced Sound Mark(0x309A) <---> Hiragana \"PA\"(0x3071)" }, new java.lang.String[]{ "ヷ", "ヷ", "Katakana \"WA\"(0x306F)Combining Katakana-Hiragana Voiced Sound Mark(0x3099) <---> Katakana \"VA\"(0x30F7)" }, new java.lang.String[]{ "ヸ", "ヸ", "Katakana \"WI\"(0x30F0)Combining Katakana-Hiragana Voiced Sound Mark(0x3099) <---> Katakana \"VI\"(0x30F8)" }, new java.lang.String[]{ "ヹ", "ヹ", "Katakana \"WE\"(0x30F1)Combining Katakana-Hiragana Voiced Sound Mark(0x3099) <---> Katakana \"VE\"(0x30F9)" }, new java.lang.String[]{ "ヺ", "ヺ", "Katakana \"WO\"(0x30F2)Combining Katakana-Hiragana Voiced Sound Mark(0x3099) <---> Katakana \"VO\"(0x30FA)" }, new java.lang.String[]{ "ゔ", "ゔ", "Hiragana \"U\"(0x3046)Combining Katakana-Hiragana Voiced Sound Mark(0x3099) <---> Hiragana \"VU\"(0x3094)" }, new java.lang.String[]{ "ヴ", "ヴ", "Katakana \"U\"(0x30A6)Combining Katakana-Hiragana Voiced Sound Mark(0x3099) <---> Katakana \"VU\"(0x30F4)" }, new java.lang.String[]{ "≠", "≠", "Not Equal To(0x2260) <---> Equal(0x003D)Combining Long Solidus Overlay(0x0338)" }, new java.lang.String[]{ "≢", "≢", "Not Identical To(0x2262) <---> Identical To(0x2261)Combining Long Solidus Overlay(0x0338)" }, new java.lang.String[]{ "≮", "≮", "Not Less-than(0x226E) <---> Less-than Sign(0x003C)Combining Long Solidus Overlay(0x0338)" }, new java.lang.String[]{ "福", "福", "CJK Unified Ideograph \"FUKU\"(0x798F) <---> CJK Compatibility Ideograph \"FUKU\"(0xFA1B)" } };

	static final int[][] results5 = new int[][]{ new int[]{ 1, 0, 0 }, new int[]{ 1, 0, 0 }, new int[]{ 1, 0, 0 } };

	static final java.lang.String[][] compData5 = new java.lang.String[][]{ new java.lang.String[]{ "≭", "≭", "Not Equivalent To(0x226D) <---> Equivalent To(0x224D)Combining Long Solidus Overlay(0x0338)" } };

	static final int[][] results6 = new int[][]{ new int[]{ 1, -1, -1 }, new int[]{ 1, -1, -1 }, new int[]{ 1, -1, -1 } };

	static final java.lang.String[][] compData6 = new java.lang.String[][]{ new java.lang.String[]{ "≭", "≬", "Not Equivalent To(0x226D) <---> Between(0x226C)" }, new java.lang.String[]{ "≭", "≟", "Not Equivalent To(0x226D) <---> Questioned Equal To(0x225F)" } };

	static final java.lang.String[][] compData0 = new java.lang.String[][]{ new java.lang.String[]{ "みみ", "みゝ", "Hiragana \"MIMI\"(0x307F 0x307F) <---> Hiragana \"MI\"(0x307F)Hiragana Iteration Mark(0x309D)" }, new java.lang.String[]{ "いすず", "いすゞ", "Hiragana \"ISUZU\"(0x3044 0x3059 0x305A) <---> Hiragana \"ISU\"(0x3044 0x3059)Hiragana Voiced Iteration Mark(0x309E)" }, new java.lang.String[]{ "ミミ", "ミヽ", "Katakana \"MIMI\"(0x30DF 0x30DF) <---> Katakana \"MI\"(0x30DF)Katakana Iteration Mark(0x30FD)" }, new java.lang.String[]{ "イスズ", "イスヾ", "Katakana \"ISUZU\"(0x30A4 0x30B9 0x30BA) <---> Katakana \"ISU\"(0x30A4 0x30B9)Katakana Voiced Iteration Mark(0x30FE)" } };

	static final java.lang.String[] decomp_name = new java.lang.String[]{ "NO_DECOMP", "CANONICAL_DECOMP", "FULL_DECOMP" };

	static final java.lang.String[] strength_name = new java.lang.String[]{ "PRIMARY", "SECONDARY", "TERTIARY" };

	java.text.Collator col = java.text.Collator.getInstance(java.util.Locale.JAPAN);

	int result = 0;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.JapaneseTest().run();
	}

	public void run() {
		java.util.Locale[] locales = new java.util.Locale[]{ java.util.Locale.getDefault() };
		for (int l = 0; l < locales.length; l++) {
			java.util.Locale.setDefault(locales[l]);
			for (int decomp = 0; decomp < 3; decomp++) {
				col.setDecomposition(decomp);
				for (int strength = 0; strength < 3; strength++) {
					col.setStrength(strength);
					doCompare(javaT.text.Collator.JapaneseTest.compData1, javaT.text.Collator.JapaneseTest.results1[strength][decomp], strength, decomp);
					doCompare(javaT.text.Collator.JapaneseTest.compData2, javaT.text.Collator.JapaneseTest.results2[strength][decomp], strength, decomp);
					doCompare(javaT.text.Collator.JapaneseTest.compData3, javaT.text.Collator.JapaneseTest.results3[strength][decomp], strength, decomp);
					doCompare(javaT.text.Collator.JapaneseTest.compData4, javaT.text.Collator.JapaneseTest.results4[strength][decomp], strength, decomp);
					doCompare(javaT.text.Collator.JapaneseTest.compData5, javaT.text.Collator.JapaneseTest.results5[strength][decomp], strength, decomp);
					doCompare(javaT.text.Collator.JapaneseTest.compData6, javaT.text.Collator.JapaneseTest.results6[strength][decomp], strength, decomp);
				}
			}
		}
		if (result != 0) {
			throw new java.lang.RuntimeException("Unexpected results on Japanese collation.");
		}
	}

	void doCompare(java.lang.String[][] s, int expectedValue, int strength, int decomp) {
		int value;
		for (int i = 0; i < s.length; i++) {
			if ((value = col.compare(s[i][0], s[i][1])) != expectedValue) {
				result++;
				java.lang.System.err.println((((((((javaT.text.Collator.JapaneseTest.strength_name[strength] + ": compare() returned unexpected value.(") + value) + ") on ") + javaT.text.Collator.JapaneseTest.decomp_name[decomp]) + "     Expected(") + expectedValue) + ") for ") + s[i][2]);
			}
		}
	}
}