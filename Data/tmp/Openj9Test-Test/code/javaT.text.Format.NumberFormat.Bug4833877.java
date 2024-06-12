public class Bug4833877 {
	static java.text.DecimalFormat df;

	static boolean err = false;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Locale defaultLoc = java.util.Locale.getDefault();
		java.util.Locale.setDefault(java.util.Locale.US);
		javaT.text.Format.NumberFormat.Bug4833877.df = new java.text.DecimalFormat();
		javaT.text.Format.NumberFormat.Bug4833877.df.setMaximumFractionDigits(50);
		javaT.text.Format.NumberFormat.Bug4833877.df.setMultiplier(4);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(252.5252525252525), "1,010.10101010101");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-1,010.10101010101", new java.lang.Double(-252.5252525252525));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(-2222.2222), "-8,888.8888");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("8888.8888", new java.lang.Double(2222.2222));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(1000), "4,000");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-4,000", new java.lang.Long(-1000));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(-250), "-1,000");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("1000", new java.lang.Long(250));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseBigDecimal(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("22222.222222222222222222222"), "88,888.888888888888888888888");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-88,888.888888888888888888888", new java.math.BigDecimal("-22222.222222222222222222222"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("-1111111111111111111.111111111111111111"), "-4,444,444,444,444,444,444.444444444444444444");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("4444444444444444444.444444444444444444", new java.math.BigDecimal("1111111111111111111.111111111111111111"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("22222222222222222222222222"), "88,888,888,888,888,888,888,888,888");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-88,888,888,888,888,888,888,888,888", new java.math.BigDecimal("-22222222222222222222222222"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("-1111111111111111111111111"), "-4,444,444,444,444,444,444,444,444");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("4444444444444444444444444", new java.math.BigDecimal("1111111111111111111111111"));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseBigDecimal(false);
		javaT.text.Format.NumberFormat.Bug4833877.df.setMultiplier(-4);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(252.5252525252525), "-1,010.10101010101");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-1,010.10101010101", new java.lang.Double(252.5252525252525));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(-2222.2222), "8,888.8888");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("8888.8888", new java.lang.Double(-2222.2222));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(1000), "-4,000");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-4,000", new java.lang.Long(1000));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(-250), "1,000");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("1000", new java.lang.Long(-250));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseBigDecimal(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("22222.222222222222222222222"), "-88,888.888888888888888888888");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-88,888.888888888888888888888", new java.math.BigDecimal("22222.222222222222222222222"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("-1111111111111111111.111111111111111111"), "4,444,444,444,444,444,444.444444444444444444");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("4444444444444444444.444444444444444444", new java.math.BigDecimal("-1111111111111111111.111111111111111111"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("22222222222222222222222222"), "-88,888,888,888,888,888,888,888,888");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-88,888,888,888,888,888,888,888,888", new java.math.BigDecimal("22222222222222222222222222"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("-1111111111111111111111111"), "4,444,444,444,444,444,444,444,444");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("4444444444444444444444444", new java.math.BigDecimal("-1111111111111111111111111"));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseBigDecimal(false);
		javaT.text.Format.NumberFormat.Bug4833877.df.setMultiplier(-3);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(3333.3333333), "-9,999.9999999");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-10,000.00000000000", new java.lang.Double(3333.3333333333335));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(-3333.3333333), "9,999.9999999");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("10,000.00000000000", new java.lang.Long(-3333));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(false);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(-3333.3333333), "9,999.9999999");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("10,000.00000000000", new java.lang.Double(-3333.3333333333335));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(3333), "-9,999");
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-10,000", new java.lang.Long(3333));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(false);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-10000", new java.lang.Double(3333.3333333333335));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(-3333), "9,999");
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("10,000", new java.lang.Long(-3333));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(false);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("10000", new java.lang.Double(-3333.3333333333335));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseBigDecimal(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("33333.333333333333333333333"), "-99,999.999999999999999999999");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-100,000.000000000000000000000", new java.math.BigDecimal("33333.333333333333333333333"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("-33333.333333333333333333333"), "99,999.999999999999999999999");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("100,000.000000000000000000000", new java.math.BigDecimal("-33333.333333333333333333333"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("33333333333333333333333333"), "-99,999,999,999,999,999,999,999,999");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-100,000,000,000,000,000,000,000,000", new java.math.BigDecimal("33333333333333333333333333"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("-33333333333333333333333333"), "99,999,999,999,999,999,999,999,999");
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("100,000,000,000,000,000,000,000,000.000", new java.math.BigDecimal("-33333333333333333333333333"));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(false);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("100,000,000,000,000,000,000,000,000.000", new java.math.BigDecimal("-33333333333333333333333333.333"));
		javaT.text.Format.NumberFormat.Bug4833877.df = new java.text.DecimalFormat("0.#E0;-0.#E0");
		javaT.text.Format.NumberFormat.Bug4833877.df.setMaximumFractionDigits(50);
		javaT.text.Format.NumberFormat.Bug4833877.df.setMultiplier(4);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(252.5252525252525), "1.01010101010101E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-1.01010101010101E3", new java.lang.Double(-252.5252525252525));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(-2222.2222), "-8.8888888E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("8888.8888", new java.lang.Double(2222.2222));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(1000), "4E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-4E3", new java.lang.Long(-1000));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(-250), "-1E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("1000", new java.lang.Long(250));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseBigDecimal(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("22222.222222222222222222222"), "8.8888888888888888888888888E4");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-8.8888888888888888888888888E4", new java.math.BigDecimal("-2.2222222222222222222222222E4"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("-1111111111111111111.111111111111111111"), "-4.444444444444444444444444444444444444E18");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("4444444444444444444.444444444444444444", new java.math.BigDecimal("1111111111111111111.111111111111111111"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("22222222222222222222222222"), "8.8888888888888888888888888E25");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-8.8888888888888888888888888E25", new java.math.BigDecimal("-22222222222222222222222222"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("-1111111111111111111111111"), "-4.444444444444444444444444E24");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("4444444444444444444444444", new java.math.BigDecimal("1111111111111111111111111"));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseBigDecimal(false);
		javaT.text.Format.NumberFormat.Bug4833877.df.setMultiplier(-4);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(252.5252525252525), "-1.01010101010101E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-1.01010101010101E3", new java.lang.Double(252.5252525252525));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(-2222.2222), "8.8888888E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("8888.8888", new java.lang.Double(-2222.2222));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(1000), "-4E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-4E3", new java.lang.Long(1000));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(-250), "1E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("1000", new java.lang.Long(-250));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseBigDecimal(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("22222.222222222222222222222"), "-8.8888888888888888888888888E4");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-8.8888888888888888888888888E4", new java.math.BigDecimal("2.2222222222222222222222222E4"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("-1111111111111111111.111111111111111111"), "4.444444444444444444444444444444444444E18");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("4444444444444444444.444444444444444444", new java.math.BigDecimal("-1111111111111111111.111111111111111111"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("22222222222222222222222222"), "-8.8888888888888888888888888E25");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-8.8888888888888888888888888E25", new java.math.BigDecimal("22222222222222222222222222"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("-1111111111111111111111111"), "4.444444444444444444444444E24");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("4444444444444444444444444", new java.math.BigDecimal("-1111111111111111111111111"));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseBigDecimal(false);
		javaT.text.Format.NumberFormat.Bug4833877.df.setMultiplier(-3);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(3333.3333333), "-9.9999999999E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-1.00000000000000E3", new java.lang.Double(333.3333333333333));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(-3333.3333333), "9.9999999999E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("10.00000000000000E3", new java.lang.Long(-3));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(false);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Double(-3333.3333333), "9.9999999999E3");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("10.00000000000000E3", new java.lang.Double(-3333.3333333333335));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(3333), "-9.999E3");
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-1.0E4", new java.lang.Long(0));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(false);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-1.0E4", new java.lang.Double(3333.3333333333335));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.lang.Long(-3333), "9.999E3");
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("10.0E4", new java.lang.Long(-3));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(false);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("10.0E4", new java.lang.Double(-33333.333333333336));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseBigDecimal(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("333.333333333333333333333333"), "-9.99999999999999999999999999E2");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-1.0000000000000000000000000E3", new java.math.BigDecimal("3.333333333333333333333333E2"));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("-333.333333333333333333333333"), "9.99999999999999999999999999E2");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("10.0000000000000000000000000E3", new java.math.BigDecimal("-3"));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(false);
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigDecimal("-333.333333333333333333333333"), "9.99999999999999999999999999E2");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("1.0000000000000000000000000E3", new java.math.BigDecimal("-3.333333333333333333333333E2"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("33333333333333333333333333"), "-9.9999999999999999999999999E25");
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("-100000000000000000000000000", new java.math.BigDecimal("33333333333333333333333333"));
		javaT.text.Format.NumberFormat.Bug4833877.checkFormat(new java.math.BigInteger("-33333333333333333333333333"), "9.9999999999999999999999999E25");
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(true);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("100000000000000000000000000000", new java.math.BigDecimal("-33333333333333333333333333333"));
		javaT.text.Format.NumberFormat.Bug4833877.df.setParseIntegerOnly(false);
		javaT.text.Format.NumberFormat.Bug4833877.checkParse("100000000000000000000000000.000", new java.math.BigDecimal("-33333333333333333333333333.333"));
		java.util.Locale.setDefault(defaultLoc);
		if (javaT.text.Format.NumberFormat.Bug4833877.err) {
			throw new java.lang.RuntimeException("Wrong format/parse with DecimalFormat");
		}
	}

	static void checkFormat(java.lang.Number num, java.lang.String expected) {
		java.lang.String got = javaT.text.Format.NumberFormat.Bug4833877.df.format(num);
		if (!got.equals(expected)) {
			javaT.text.Format.NumberFormat.Bug4833877.err = true;
			java.lang.System.err.println(((((((((((("    DecimalFormat format(" + num.getClass().getName()) + ") error:") + "\n\tnumber:     ") + num) + "\n\tpattern:    ") + javaT.text.Format.NumberFormat.Bug4833877.df.toPattern()) + "\n\tmultiplier: ") + javaT.text.Format.NumberFormat.Bug4833877.df.getMultiplier()) + "\n\tgot:        ") + got) + "\n\texpected:   ") + expected);
		}
	}

	static void checkParse(java.lang.String text, java.lang.Double expected) {
		java.lang.Double got = ((java.lang.Double) (javaT.text.Format.NumberFormat.Bug4833877.df.parse(text, new java.text.ParsePosition(0))));
		if (!got.equals(expected)) {
			javaT.text.Format.NumberFormat.Bug4833877.err = true;
			java.lang.System.err.println(((((((((("    DecimalFormat parse(double) error:" + "\n\ttext:       ") + text) + "\n\tpattern:    ") + javaT.text.Format.NumberFormat.Bug4833877.df.toPattern()) + "\n\tmultiplier: ") + javaT.text.Format.NumberFormat.Bug4833877.df.getMultiplier()) + "\n\tgot:        ") + got) + "\n\texpected:   ") + expected);
		}
	}

	static void checkParse(java.lang.String text, java.lang.Long expected) {
		java.lang.Long got = ((java.lang.Long) (javaT.text.Format.NumberFormat.Bug4833877.df.parse(text, new java.text.ParsePosition(0))));
		if (!got.equals(expected)) {
			javaT.text.Format.NumberFormat.Bug4833877.err = true;
			java.lang.System.err.println(((((((((("    DecimalFormat parse(long) error:" + "\n\ttext:       ") + text) + "\n\tpattern:    ") + javaT.text.Format.NumberFormat.Bug4833877.df.toPattern()) + "\n\tmultiplier: ") + javaT.text.Format.NumberFormat.Bug4833877.df.getMultiplier()) + "\n\tgot:        ") + got) + "\n\texpected:   ") + expected);
		}
	}

	static void checkParse(java.lang.String text, java.math.BigDecimal expected) {
		java.math.BigDecimal got = ((java.math.BigDecimal) (javaT.text.Format.NumberFormat.Bug4833877.df.parse(text, new java.text.ParsePosition(0))));
		if (!got.equals(expected)) {
			javaT.text.Format.NumberFormat.Bug4833877.err = true;
			java.lang.System.err.println(((((((((("    DecimalFormat parse(BigDecimal) error:" + "\n\ttext:       ") + text) + "\n\tpattern:    ") + javaT.text.Format.NumberFormat.Bug4833877.df.toPattern()) + "\n\tmultiplier: ") + javaT.text.Format.NumberFormat.Bug4833877.df.getMultiplier()) + "\n\tgot:        ") + got) + "\n\texpected:   ") + expected);
		}
	}
}