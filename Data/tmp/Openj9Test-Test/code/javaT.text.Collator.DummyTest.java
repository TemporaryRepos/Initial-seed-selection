public class DummyTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.DummyTest().run(args);
	}

	private static final java.lang.String DEFAULTRULES = "=\'​\'=‌=‍=‎=‏" + (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("=\u0000 =\u0001 =\u0002 =\u0003 =\u0004" + "=\u0005 =\u0006 =\u0007 =\b =\'\t\'") + "=\'\u000b\' =\u000e") + "=\u000f =\'\u0010\' =\u0011 =\u0012 =\u0013") + "=\u0014 =\u0015 =\u0016 =\u0017 =\u0018") + "=\u0019 =\u001a =\u001b =\u001c =\u001d") + "=\u001e =\u001f =\u007f") + "=\u0080 =\u0081 =\u0082 =\u0083 =\u0084 =\u0085") + "=\u0086 =\u0087 =\u0088 =\u0089 =\u008a =\u008b") + "=\u008c =\u008d =\u008e =\u008f =\u0090 =\u0091") + "=\u0092 =\u0093 =\u0094 =\u0095 =\u0096 =\u0097") + "=\u0098 =\u0099 =\u009a =\u009b =\u009c =\u009d") + "=\u009e =\u009f") + ";\' \';\' \'") + ";\' \';\' \';\' \';\' \';\' \'") + ";\' \';\' \';\' \';\' \';\' \'") + ";\' \';\'　\';\'﻿\'") + ";\'\r\' ;\'\t\' ;\'\n\';\'\f\';\'\u000b\'") + ";́") + ";̀") + ";̆") + ";̂") + ";̌") + ";̊") + ";̍") + ";̈") + ";̋") + ";̃") + ";̇") + ";̄") + ";̷") + ";̧") + ";̨") + ";̣") + ";̲") + ";̅") + ";̉") + ";̎") + ";̏") + ";̐") + ";̑") + ";̒") + ";̓") + ";̔") + ";̕") + ";̖") + ";̗") + ";̘") + ";̙") + ";̚") + ";̛") + ";̜") + ";̝") + ";̞") + ";̟") + ";̠") + ";̡") + ";̢") + ";̤") + ";̥") + ";̦") + ";̩") + ";̪") + ";̫") + ";̬") + ";̭") + ";̮") + ";̯") + ";̰") + ";̱") + ";̳") + ";̴") + ";̵") + ";̶") + ";̸") + ";̹") + ";̺") + ";̻") + ";̼") + ";̽") + ";̾") + ";̿") + ";̀") + ";́") + ";͂;̓;̈́;ͅ;͠;͡") + ";҃;҄;҅;҆") + ";⃐;⃑;⃒") + ";⃓;⃔;⃕") + ";⃖;⃗;⃘") + ";⃙;⃚;⃛") + ";⃜;⃝;⃞") + ";⃟;⃠;⃡") + ",\'-\';­") + ";‐;‑;‒") + ";–;—;―") + ";−") + "<\'_\'") + "<¯") + "<\',\'") + "<\';\'") + "<\':\'") + "<\'!\'") + "<¡") + "<\'?\'") + "<¿") + "<\'/\'") + "<\'.\'") + "<´") + "<\'`\'") + "<\'^\'") + "<¨") + "<\'~\'") + "<·") + "<¸") + "<\'\'\'") + "<\'\"\'") + "<«") + "<»") + "<\'(\'") + "<\')\'") + "<\'[\'") + "<\']\'") + "<\'{\'") + "<\'}\'") + "<§") + "<¶") + "<©") + "<®") + "<\'@\'") + "<¤") + "<¢") + "<\'$\'") + "<£") + "<¥") + "<\'*\'") + "<\'\\u005c\'") + "<\'&\'") + "<\'#\'") + "<\'%\'") + "<\'+\'") + "<±") + "<÷") + "<×") + "<\'<\'") + "<\'=\'") + "<\'>\'") + "<¬") + "<\'|\'") + "<¦") + "<°") + "<µ") + "<0<1<2<3<4<5<6<7<8<9") + "<¼<½<¾") + "<a,A") + "<b,B") + "<c,C") + "<d,D") + "<ð,Ð") + "<e,E") + "<f,F") + "<g,G") + "<h,H") + "<i,I") + "<j,J") + "<k,K") + "<l,L") + "<m,M") + "<n,N") + "<o,O") + "<p,P") + "<q,Q") + "<r,R") + "<s, S & SS,ß") + "<t,T") + "&th, þ & TH, Þ") + "<u,U") + "<v,V") + "<w,W") + "<x,X") + "<y,Y") + "<z,Z") + "&AE,Æ") + "&AE,æ") + "&OE,Œ") + "&OE,œ");

	private static final java.lang.String[] primarySourceData = new java.lang.String[]{ "pêche", "abc", "abc", "abc", "abc", "abc", "aæc", "acHc", "black" };

	private static final java.lang.String[] primaryTargetData = new java.lang.String[]{ "péché", "abc", "aBC", "abch", "abd", "äbc", "aÆc", "aCHc", "black-bird" };

	private static final int[] primaryResults = new int[]{ 0, 0, 0, -1, -1, 0, 0, 0, -1 };

	private static final java.lang.String[] secondarySourceData = new java.lang.String[]{ "four", "five", "1", "abc", "abc", "abcH", "abc", "acHc" };

	private static final java.lang.String[] secondaryTargetData = new java.lang.String[]{ "4", "5", "one", "abc", "aBc", "abch", "abd", "aCHc" };

	private static final int[] secondaryResults = new int[]{ 0, 0, 0, 0, 0, 0, -1, 0 };

	private static final java.lang.String[] tertiarySourceData = new java.lang.String[]{ "ab'c", "co-op", "ab", "ampersad", "all", "four", "five", "1", "1", "1", "2", "2", "Hello", "a<b", "a<b", "acc", "acHc" };

	private static final java.lang.String[] tertiaryTargetData = new java.lang.String[]{ "abc", "COOP", "abc", "&", "&", "4", "5", "one", "nne", "pne", "two", "uwo", "hellO", "a<=b", "abc", "aCHc", "aCHc" };

	private static final int[] tertiaryResults = new int[]{ -1, 1, -1, -1, -1, -1, -1, 1, 1, -1, 1, -1, 1, 1, -1, -1, -1 };

	private static final java.lang.String[] testData = new java.lang.String[]{ "a", "A", "ä", "Ä", "ae", "aE", "Ae", "AE", "æ", "Æ", "b", "c", "z" };

	public void TestPrimary() {
		doTest(getCollator(), java.text.Collator.PRIMARY, javaT.text.Collator.DummyTest.primarySourceData, javaT.text.Collator.DummyTest.primaryTargetData, javaT.text.Collator.DummyTest.primaryResults);
	}

	public void TestSecondary() {
		doTest(getCollator(), java.text.Collator.SECONDARY, javaT.text.Collator.DummyTest.secondarySourceData, javaT.text.Collator.DummyTest.secondaryTargetData, javaT.text.Collator.DummyTest.secondaryResults);
	}

	public void TestTertiary() {
		java.text.Collator col = getCollator();
		doTest(col, java.text.Collator.TERTIARY, javaT.text.Collator.DummyTest.tertiarySourceData, javaT.text.Collator.DummyTest.tertiaryTargetData, javaT.text.Collator.DummyTest.tertiaryResults);
		for (int i = 0; i < (javaT.text.Collator.DummyTest.testData.length - 1); i++) {
			for (int j = i + 1; j < javaT.text.Collator.DummyTest.testData.length; j++) {
				doTest(col, javaT.text.Collator.DummyTest.testData[i], javaT.text.Collator.DummyTest.testData[j], -1);
			}
		}
	}

	private java.text.RuleBasedCollator myCollation = null;

	private java.text.Collator getCollator() {
		if (myCollation == null) {
			try {
				myCollation = new java.text.RuleBasedCollator(javaT.text.Collator.DummyTest.DEFAULTRULES + "& C < ch, cH, Ch, CH & Five, 5 & Four, 4 & one, 1 & Ampersand; '&' & Two, 2 ");
			} catch (java.lang.Exception foo) {
				errln("Collator creation failed.");
				myCollation = ((java.text.RuleBasedCollator) (java.text.Collator.getInstance()));
			}
		}
		return myCollation;
	}
}