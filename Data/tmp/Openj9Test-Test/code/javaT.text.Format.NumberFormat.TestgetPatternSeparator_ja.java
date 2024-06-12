public class TestgetPatternSeparator_ja {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		java.text.DecimalFormat df = ((java.text.DecimalFormat) (java.text.NumberFormat.getInstance(java.util.Locale.JAPAN)));
		java.text.DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
		if (dfs.getPatternSeparator() != ';') {
			throw new java.lang.Exception("DecimalFormatSymbols.getPatternSeparator doesn't return ';' in ja locale");
		}
	}
}