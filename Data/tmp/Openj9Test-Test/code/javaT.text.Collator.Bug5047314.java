public class Bug5047314 {
	private static java.text.Collator colLao = java.text.Collator.getInstance(new java.util.Locale("lo"));

	private static java.text.Collator colThai = java.text.Collator.getInstance(new java.util.Locale("th"));

	private static java.lang.String[] textLao = new java.lang.String[]{ "ເ", "ແ", "ໂ", "ໃ", "ໄ" };

	private static java.lang.String[] textThai = new java.lang.String[]{ "เ", "แ", "โ", "ใ", "ไ" };

	public static void main(java.lang.String[] args) {
		javaT.text.Collator.Bug5047314.testLao1();
		javaT.text.Collator.Bug5047314.testLao2();
		javaT.text.Collator.Bug5047314.testThai1();
		javaT.text.Collator.Bug5047314.testThai2();
	}

	private static void testLao1() {
		java.lang.System.out.print("Test(Lao 1) .... ");
		for (int i = 0; i < javaT.text.Collator.Bug5047314.textLao.length; i++) {
			javaT.text.Collator.Bug5047314.colLao.compare(javaT.text.Collator.Bug5047314.textLao[i], javaT.text.Collator.Bug5047314.textLao[i]);
		}
		java.lang.System.out.println("Passed.");
	}

	private static void testLao2() {
		java.lang.System.out.print("Test(Lao 2) .... ");
		for (int i = 0; i < javaT.text.Collator.Bug5047314.textLao.length; i++) {
			javaT.text.Collator.Bug5047314.colLao.compare(javaT.text.Collator.Bug5047314.textLao[i], javaT.text.Collator.Bug5047314.textLao[i]);
		}
		java.lang.System.out.println("Passed.");
	}

	private static void testThai1() {
		java.lang.System.out.print("Test(Thai 1) .... ");
		for (int i = 0; i < javaT.text.Collator.Bug5047314.textThai.length; i++) {
			javaT.text.Collator.Bug5047314.colThai.compare(javaT.text.Collator.Bug5047314.textThai[i], javaT.text.Collator.Bug5047314.textThai[i]);
		}
		java.lang.System.out.println("Passed.");
	}

	private static void testThai2() {
		java.lang.System.out.print("Test(Thai 2) .... ");
		for (int i = 0; i < javaT.text.Collator.Bug5047314.textThai.length; i++) {
			javaT.text.Collator.Bug5047314.colThai.getCollationKey(javaT.text.Collator.Bug5047314.textThai[i]);
		}
		java.lang.System.out.println("Passed.");
	}
}