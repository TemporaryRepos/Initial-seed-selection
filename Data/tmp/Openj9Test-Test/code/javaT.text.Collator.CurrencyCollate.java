public class CurrencyCollate {
	static java.text.Collator myCollation = java.text.Collator.getInstance(java.util.Locale.US);

	public static void main(java.lang.String[] args) {
		java.lang.String[] DATA = new java.lang.String[]{ "€", ">", "$", "€", "<", "£", "¤", "<", "฿", "฿", "<", "¢", "¢", "<", "₡", "₡", "<", "₢", "₢", "<", "$", "$", "<", "₫", "₫", "<", "₣", "₣", "<", "₤", "₤", "<", "₥", "₥", "<", "₦", "₦", "<", "₧", "₧", "<", "£", "£", "<", "₨", "₨", "<", "₪", "₪", "<", "₩", "₩", "<", "¥" };
		for (int i = 0; i < DATA.length; i += 3) {
			int expected = (DATA[i + 1].equals(">")) ? 1 : DATA[i + 1].equals("<") ? -1 : 0;
			int actual = javaT.text.Collator.CurrencyCollate.myCollation.compare(DATA[i], DATA[i + 2]);
			if (actual != expected) {
				throw new java.lang.RuntimeException((((((("Collation of " + DATA[i]) + " vs. ") + DATA[i + 2]) + " yields ") + actual) + "; expected ") + expected);
			}
		}
		java.lang.System.out.println("Ok");
	}
}