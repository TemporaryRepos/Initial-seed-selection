public class DFSSerialization142 {
	public static void main(java.lang.String[] args) {
		try {
			java.text.DecimalFormatSymbols dfs = new java.text.DecimalFormatSymbols();
			java.lang.System.out.println("Default currency symbol in the default locale : " + dfs.getCurrencySymbol());
			dfs.setCurrencySymbol("*SpecialCurrencySymbol*");
			java.lang.System.out.println("The special currency symbol is set : " + dfs.getCurrencySymbol());
			java.io.FileOutputStream ostream = new java.io.FileOutputStream("DecimalFormatSymbols.142");
			java.io.ObjectOutputStream p = new java.io.ObjectOutputStream(ostream);
			p.writeObject(dfs);
			ostream.close();
			java.lang.System.out.println("DecimalFormatSymbols saved ok.");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}