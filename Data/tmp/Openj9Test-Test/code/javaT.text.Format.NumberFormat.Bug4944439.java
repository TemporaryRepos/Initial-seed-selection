public class Bug4944439 {
	static boolean err = false;

	static java.text.DecimalFormat df;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Locale defaultLoc = java.util.Locale.getDefault();
		java.util.Locale.setDefault(java.util.Locale.US);
		javaT.text.Format.NumberFormat.Bug4944439.df = new java.text.DecimalFormat();
		java.lang.String s = "-9223372036854775809";
		javaT.text.Format.NumberFormat.Bug4944439.check_Double(s);
		javaT.text.Format.NumberFormat.Bug4944439.test(java.lang.Long.MIN_VALUE, java.lang.Long.MIN_VALUE + 10);
		javaT.text.Format.NumberFormat.Bug4944439.test(-10, 10);
		javaT.text.Format.NumberFormat.Bug4944439.test(java.lang.Long.MAX_VALUE - 10, java.lang.Long.MAX_VALUE - 1);
		s = "9223372036854775807.00";
		javaT.text.Format.NumberFormat.Bug4944439.check_Long(s);
		s = "9223372036854775808";
		javaT.text.Format.NumberFormat.Bug4944439.check_Double(s);
		s = "-0.0";
		javaT.text.Format.NumberFormat.Bug4944439.check_Double(s);
		s = "0.0";
		javaT.text.Format.NumberFormat.Bug4944439.check_Long(s);
		java.util.Locale.setDefault(defaultLoc);
		if (javaT.text.Format.NumberFormat.Bug4944439.err) {
			throw new java.lang.RuntimeException("Wrong parsing with DecimalFormat");
		}
	}

	private static void test(long from, long to) throws java.lang.Exception {
		for (long l = from; l <= to; l++) {
			javaT.text.Format.NumberFormat.Bug4944439.check_Long(java.lang.Long.toString(l) + ".00");
		}
	}

	private static void check_Long(java.lang.String s) throws java.lang.Exception {
		java.lang.Number number = javaT.text.Format.NumberFormat.Bug4944439.df.parse(s);
		if (!(number instanceof java.lang.Long)) {
			javaT.text.Format.NumberFormat.Bug4944439.err = true;
			java.lang.System.err.println((("Failed: DecimalFormat.parse(\"" + s) + "\") should return a Long, but returned a ") + number.getClass().getName());
		}
		int index = s.indexOf('.');
		java.lang.Long l = new java.lang.Long(s.substring(0, index));
		if (!l.equals(number)) {
			javaT.text.Format.NumberFormat.Bug4944439.err = true;
			java.lang.System.err.println((((("Failed: DecimalFormat.parse(" + s) + ") should return a Long(") + l) + "), but returned ") + number);
		}
	}

	private static void check_Double(java.lang.String s) throws java.lang.Exception {
		java.lang.Number number = javaT.text.Format.NumberFormat.Bug4944439.df.parse(s);
		if (!(number instanceof java.lang.Double)) {
			javaT.text.Format.NumberFormat.Bug4944439.err = true;
			java.lang.System.err.println((("Failed: DecimalFormat.parse(\"" + s) + "\") should return a Double, but returned a ") + number.getClass().getName());
		}
		java.lang.Double d = new java.lang.Double(s);
		if (!d.equals(number)) {
			javaT.text.Format.NumberFormat.Bug4944439.err = true;
			java.lang.System.err.println((((("Failed: DecimalFormat.parse(" + s) + ") should return a Double(") + d) + "), but returned ") + number);
		}
	}
}