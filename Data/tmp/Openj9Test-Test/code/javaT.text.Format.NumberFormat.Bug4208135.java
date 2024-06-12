public class Bug4208135 {
	static java.text.DecimalFormat df;

	static boolean err = false;

	public static void main(java.lang.String[] args) {
		java.util.Locale defaultLoc = java.util.Locale.getDefault();
		java.util.Locale.setDefault(java.util.Locale.US);
		javaT.text.Format.NumberFormat.Bug4208135.df = new java.text.DecimalFormat();
		javaT.text.Format.NumberFormat.Bug4208135.df.applyPattern("0.#E0");
		javaT.text.Format.NumberFormat.Bug4208135.df.setDecimalSeparatorAlwaysShown(true);
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(0.0), "0.E0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(10.0), "1.E1");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(1000.0), "1.E3");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(0), "0.E0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(10), "1.E1");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(1000), "1.E3");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("0.0"), "0.E0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("10.0"), "1.E1");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("1000.0"), "1.E3");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("00"), "0.E0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("10"), "1.E1");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("1000"), "1.E3");
		javaT.text.Format.NumberFormat.Bug4208135.df.setDecimalSeparatorAlwaysShown(false);
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(0.0), "0E0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(10.0), "1E1");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(1000.0), "1E3");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(0), "0E0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(10), "1E1");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(1000), "1E3");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("0.0"), "0E0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("10.0"), "1E1");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("1000.0"), "1E3");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("0"), "0E0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("10"), "1E1");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("1000"), "1E3");
		javaT.text.Format.NumberFormat.Bug4208135.df.applyPattern("0.###");
		javaT.text.Format.NumberFormat.Bug4208135.df.setDecimalSeparatorAlwaysShown(true);
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(0.0), "0.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(10.0), "10.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(1000.0), "1000.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(0), "0.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(10), "10.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(1000), "1000.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("0.0"), "0.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("10.0"), "10.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("1000.0"), "1000.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("0"), "0.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("10"), "10.");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("1000"), "1000.");
		javaT.text.Format.NumberFormat.Bug4208135.df.setDecimalSeparatorAlwaysShown(false);
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(0.0), "0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(10.0), "10");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Double(1000.0), "1000");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(0), "0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(10), "10");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.lang.Long(1000), "1000");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("0.0"), "0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("10.0"), "10");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigDecimal("1000.0"), "1000");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("0"), "0");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("10"), "10");
		javaT.text.Format.NumberFormat.Bug4208135.checkFormat(new java.math.BigInteger("1000"), "1000");
		java.util.Locale.setDefault(defaultLoc);
		if (javaT.text.Format.NumberFormat.Bug4208135.err) {
			throw new java.lang.RuntimeException("Wrong format/parse with DecimalFormat");
		}
	}

	static void checkFormat(java.lang.Number num, java.lang.String expected) {
		java.lang.String got = javaT.text.Format.NumberFormat.Bug4208135.df.format(num);
		if (!got.equals(expected)) {
			javaT.text.Format.NumberFormat.Bug4208135.err = true;
			java.lang.System.err.println(((((((((("    DecimalFormat format(" + num.getClass().getName()) + ") error:") + "\n\tnumber:           ") + num) + "\n\tSeparatorShown? : ") + javaT.text.Format.NumberFormat.Bug4208135.df.isDecimalSeparatorAlwaysShown()) + "\n\tgot:              ") + got) + "\n\texpected:         ") + expected);
		}
	}
}