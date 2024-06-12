public class bug4099975 {
	public static void main(java.lang.String[] args) {
		java.text.DateFormatSymbols symbols = new java.text.DateFormatSymbols();
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("E hh:mm", symbols);
		java.lang.System.out.println(df.toLocalizedPattern());
		symbols.setLocalPatternChars("abcdefghijklmonpqr");
		java.lang.System.out.println(df.toLocalizedPattern());
	}
}