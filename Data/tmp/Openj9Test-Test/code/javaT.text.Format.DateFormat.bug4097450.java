public class bug4097450 {
	public static void main(java.lang.String[] args) {
		java.lang.String[] dstring = new java.lang.String[]{ "97", "1997", "97", "1997", "01", "2001", "01", "2001", "1", "1", "11", "11", "111", "111" };
		java.lang.String[] dformat = new java.lang.String[]{ "yy", "yy", "yyyy", "yyyy", "yy", "yy", "yyyy", "yyyy", "yy", "yyyy", "yy", "yyyy", "yy", "yyyy" };
		boolean[] dresult = new boolean[]{ true, false, false, true, true, false, false, true, false, false, true, false, false, false };
		java.text.SimpleDateFormat formatter;
		java.text.SimpleDateFormat resultFormatter = new java.text.SimpleDateFormat("yyyy");
		java.lang.System.out.println("Format\tSource\tResult");
		java.lang.System.out.println("-------\t-------\t-------");
		for (int i = 0; i < dstring.length; i++) {
			java.lang.System.out.print(((dformat[i] + "\t") + dstring[i]) + "\t");
			formatter = new java.text.SimpleDateFormat(dformat[i]);
			try {
				java.lang.System.out.print(resultFormatter.format(formatter.parse(dstring[i])));
			} catch (java.text.ParseException exception) {
				java.lang.System.out.print("exception --> " + exception);
			}
			java.lang.System.out.println();
		}
	}
}