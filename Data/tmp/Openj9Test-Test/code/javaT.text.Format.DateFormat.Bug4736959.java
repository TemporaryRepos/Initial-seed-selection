public class Bug4736959 {
	public static void main(java.lang.String[] args) {
		java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("a", java.util.Locale.US);
		java.util.Date d1 = f.parse("AM", new java.text.ParsePosition(0));
		java.lang.System.out.println("d1: " + d1);
		if (d1.getHours() != 0) {
			throw new java.lang.RuntimeException("Parsing \"AM\": expected 0 (midnight), got " + d1.getHours());
		}
		java.util.Date d2 = f.parse("PM", new java.text.ParsePosition(0));
		java.lang.System.out.println("d2: " + d2);
		if (d2.getHours() != 12) {
			throw new java.lang.RuntimeException("Parsing \"PM\": expected 12 (noon), got " + d2.getHours());
		}
	}
}