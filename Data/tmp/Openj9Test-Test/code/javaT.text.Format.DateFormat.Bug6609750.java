public class Bug6609750 {
	public static void main(java.lang.String[] args) {
		boolean error = false;
		java.util.Locale defaultLocale = java.util.Locale.getDefault();
		java.util.Locale.setDefault(java.util.Locale.US);
		java.util.Date[] dates = new java.util.Date[]{ new java.util.Date(9 - 1900, java.util.Calendar.JUNE, 12), new java.util.Date(99 - 1900, java.util.Calendar.JUNE, 12), new java.util.Date(999 - 1900, java.util.Calendar.JUNE, 12), new java.util.Date(2009 - 1900, java.util.Calendar.JUNE, 12), new java.util.Date(30009 - 1900, java.util.Calendar.JUNE, 12) };
		java.lang.String[] patterns = new java.lang.String[]{ "y", "yy", "yyy", "yyyy", "yyyyy", "yyyyyy" };
		java.lang.String[][] expectedResults = new java.lang.String[][]{ new java.lang.String[]{ "9", "09", "009", "0009", "00009", "000009" }, new java.lang.String[]{ "99", "99", "099", "0099", "00099", "000099" }, new java.lang.String[]{ "999", "99", "999", "0999", "00999", "000999" }, new java.lang.String[]{ "2009", "09", "2009", "2009", "02009", "002009" }, new java.lang.String[]{ "30009", "09", "30009", "30009", "30009", "030009" } };
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat();
		for (int dateNo = 0; dateNo < dates.length; dateNo++) {
			java.util.Date date = dates[dateNo];
			for (int patternNo = 0; patternNo < patterns.length; patternNo++) {
				sdf.applyPattern(patterns[patternNo]);
				java.lang.String got = sdf.format(date);
				if (!expectedResults[dateNo][patternNo].equals(got)) {
					error = true;
					java.lang.System.err.println((((((((("Failed: Unexpected format result: " + "Expected: \"") + expectedResults[dateNo][patternNo]) + "\", Got: \"") + got) + "\" for date ") + date) + " with pattern \"") + patterns[patternNo]) + "\"");
				}
			}
		}
		java.util.Locale.setDefault(defaultLocale);
		if (error) {
			throw new java.lang.RuntimeException("SimpleDateFormat.format() error.");
		}
	}
}