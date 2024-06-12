public class BigDecimalParse extends javaT.text.testlib.IntlTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Locale loc = java.util.Locale.getDefault();
		try {
			java.util.Locale.setDefault(java.util.Locale.US);
			new javaT.text.Format.NumberFormat.BigDecimalParse().run(args);
		} finally {
			java.util.Locale.setDefault(loc);
		}
	}

	static final java.lang.String nonsep_int = "123456789012345678901234567890123456789012345678901234567890" + (((("123456789012345678901234567890123456789012345678901234567890" + "123456789012345678901234567890123456789012345678901234567890") + "123456789012345678901234567890123456789012345678901234567890") + "123456789012345678901234567890123456789012345678901234567890") + "123456789012345678901234567890123456789012345678901234567890");

	static final java.lang.String sep_int = "123,456,789,012,345,678,901,234,567,890," + (((((((((("123,456,789,012,345,678,901,234,567,890," + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890");

	static final java.lang.String nonsep_zero = "000000000000000000000000000000000000000000000000000000000000" + (((("000000000000000000000000000000000000000000000000000000000000" + "000000000000000000000000000000000000000000000000000000000000") + "000000000000000000000000000000000000000000000000000000000000") + "000000000000000000000000000000000000000000000000000000000000") + "000000000000000000000000000000000000000000000000000000000000");

	static final java.lang.String sep_zero = "000,000,000,000,000,000,000,000,000,000," + (((((((((("000,000,000,000,000,000,000,000,000,000," + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000");

	static final java.lang.String fra = "012345678901234567890123456789012345678901234567890123456789" + (((("012345678901234567890123456789012345678901234567890123456789" + "012345678901234567890123456789012345678901234567890123456789") + "012345678901234567890123456789012345678901234567890123456789") + "012345678901234567890123456789012345678901234567890123456789") + "012345678901234567890123456789012345678901234567890123456789");

	java.lang.Number parsed = null;

	java.text.ParsePosition pp;

	boolean exceptionOccurred;

	java.lang.String msg;

	java.text.DecimalFormat df;

	void test_Parse_in_DecimalFormat_BigDecimal() {
		df = new java.text.DecimalFormat();
		df.setParseBigDecimal(true);
		check((javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.fra, new java.math.BigDecimal((javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.fra));
		check((("-" + javaT.text.Format.NumberFormat.BigDecimalParse.sep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.fra, new java.math.BigDecimal((("-" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.fra));
		check((javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero, new java.math.BigDecimal((javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero));
		check((("0.0000000000" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalParse.fra) + "E370", new java.math.BigDecimal((("0.0000000000" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalParse.fra) + "E370"));
		check(("0.1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int) + "E-360", new java.math.BigDecimal(("0.1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int) + "E-360"));
		check(((javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int, new java.math.BigDecimal(((javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int));
		check(("0." + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int) + "E360", new java.math.BigDecimal(("0." + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int) + "E360"));
	}

	void test_Parse_in_DecimalFormat_BigDecimal_usingMultiplier() {
		df = new java.text.DecimalFormat();
		df.setParseBigDecimal(true);
		df.setMultiplier(250000000);
		check((("250,000,000," + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero, new java.math.BigDecimal((("1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero));
		check((("-250,000,000," + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero, new java.math.BigDecimal((("-1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero));
		df.setMultiplier(-250000000);
		check((("250,000,000," + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero, new java.math.BigDecimal((("-1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero));
		check((("-250,000,000," + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero, new java.math.BigDecimal((("1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero));
		df.setMultiplier(3);
		check("1000.000", new java.math.BigDecimal("333.333"));
		df.setMultiplier(33);
		check("10000.0000", new java.math.BigDecimal("303.0303"));
	}

	void test_Parse_in_DecimalFormat_BigDecimal_DivisionByZero() {
		df = new java.text.DecimalFormat();
		df.setParseBigDecimal(true);
		df.setMultiplier(0);
		check("1000.000", new java.lang.Double(java.lang.Double.POSITIVE_INFINITY));
		check("-1000", new java.lang.Double(java.lang.Double.NEGATIVE_INFINITY));
		check("-0.00", new java.lang.Double(java.lang.Double.NaN));
	}

	void test_Parse_in_DecimalFormat_Double_DivisionByZero() {
		df = new java.text.DecimalFormat();
		df.setParseBigDecimal(false);
		df.setMultiplier(0);
		check("1000.000", new java.lang.Double(java.lang.Double.POSITIVE_INFINITY));
		check("-1000.000", new java.lang.Double(java.lang.Double.NEGATIVE_INFINITY));
		check("0.0", new java.lang.Double(java.lang.Double.NaN));
		check("-0.0", new java.lang.Double(java.lang.Double.NaN));
		check("�", new java.lang.Double(java.lang.Double.NaN));
		check("∞", new java.lang.Double(java.lang.Double.POSITIVE_INFINITY));
		check("-∞", new java.lang.Double(java.lang.Double.NEGATIVE_INFINITY));
	}

	void test_Parse_in_DecimalFormat_Long_DivisionByZero() {
		df = new java.text.DecimalFormat();
		df.setParseBigDecimal(false);
		df.setMultiplier(0);
		check("1000", new java.lang.Double(java.lang.Double.POSITIVE_INFINITY));
		check("-1000", new java.lang.Double(java.lang.Double.NEGATIVE_INFINITY));
		check("-000", new java.lang.Double(java.lang.Double.NaN));
	}

	void test_Parse_in_DecimalFormat_BigInteger() {
		df = new java.text.DecimalFormat();
		df.setParseBigDecimal(true);
		check(javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int, new java.math.BigDecimal(javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int));
		check((javaT.text.Format.NumberFormat.BigDecimalParse.sep_int + ",") + javaT.text.Format.NumberFormat.BigDecimalParse.sep_int, new java.math.BigDecimal(javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int));
		check(("-" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int, new java.math.BigDecimal("-" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int));
		check((("-" + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero) + ",") + javaT.text.Format.NumberFormat.BigDecimalParse.sep_int, new java.math.BigDecimal("-" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_int));
	}

	void test_Parse_in_DecimalFormat_BigInteger_usingMultiplier() {
		df = new java.text.DecimalFormat();
		df.setParseBigDecimal(true);
		df.setMultiplier(250000000);
		check("250,000,000," + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero, new java.math.BigDecimal("1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero));
		check("-250,000,000," + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero, new java.math.BigDecimal("-1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero));
		df.setMultiplier(-250000000);
		check("250,000,000," + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero, new java.math.BigDecimal("-1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero));
		check("-250,000,000," + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero, new java.math.BigDecimal("1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero));
		check(((("250,000,000," + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero) + ",") + javaT.text.Format.NumberFormat.BigDecimalParse.sep_zero) + "E-360", new java.math.BigDecimal((("-1" + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalParse.nonsep_zero));
		df.setMultiplier(3);
		check("1000", new java.math.BigDecimal("333"));
	}

	void test_Parse_in_DecimalFormat_SpecialNumber() {
		df = new java.text.DecimalFormat();
		df.setParseBigDecimal(true);
		java.lang.String[] numbers = new java.lang.String[]{ "0", "0.0", "25", "25.0", "25.5", "∞", "�", "-0", "-0.0", "-25", "-25.0", "-25.5", "-∞" };
		int[] multipliers = new int[]{ 5, -5 };
		java.lang.Number[][] expected = new java.lang.Number[][]{ new java.lang.Number[]{ new java.math.BigDecimal("0"), new java.math.BigDecimal("0.0"), new java.math.BigDecimal("5"), new java.math.BigDecimal("5.0"), new java.math.BigDecimal("5.1"), new java.lang.Double(java.lang.Double.POSITIVE_INFINITY), new java.lang.Double(java.lang.Double.NaN), new java.math.BigDecimal("0"), new java.math.BigDecimal("0.0"), new java.math.BigDecimal("-5"), new java.math.BigDecimal("-5.0"), new java.math.BigDecimal("-5.1"), new java.lang.Double(java.lang.Double.NEGATIVE_INFINITY), new java.lang.Double(java.lang.Double.NaN) }, new java.lang.Number[]{ new java.math.BigDecimal("0"), new java.math.BigDecimal("0.0"), new java.math.BigDecimal("-5"), new java.math.BigDecimal("-5.0"), new java.math.BigDecimal("-5.1"), new java.lang.Double(java.lang.Double.NEGATIVE_INFINITY), new java.lang.Double(java.lang.Double.NaN), new java.math.BigDecimal("0"), new java.math.BigDecimal("0.0"), new java.math.BigDecimal("5"), new java.math.BigDecimal("5.0"), new java.math.BigDecimal("5.1"), new java.lang.Double(java.lang.Double.POSITIVE_INFINITY) } };
		for (int i = 0; i < multipliers.length; i++) {
			df.setMultiplier(multipliers[i]);
			for (int j = 0; j < numbers.length; j++) {
				check(java.lang.String.valueOf(numbers[j]), expected[i][j]);
			}
		}
	}

	void test_Parse_in_DecimalFormat_Other() {
		df = new java.text.DecimalFormat();
		df.setParseBigDecimal(true);
		java.lang.String[] numbers = new java.lang.String[]{ "-9223372036854775808" };
		int[] multipliers = new int[]{ 1, -1 };
		java.lang.String[][] expected = new java.lang.String[][]{ new java.lang.String[]{ "-9223372036854775808" }, new java.lang.String[]{ "9223372036854775808" } };
		for (int i = 0; i < multipliers.length; i++) {
			df.setMultiplier(multipliers[i]);
			for (int j = 0; j < numbers.length; j++) {
				check(java.lang.String.valueOf(numbers[j]), new java.math.BigDecimal(expected[i][j]));
			}
		}
	}

	static final java.lang.String[] patterns = new java.lang.String[]{ "  {0, number}  ", "  {0, number}  ", "  {0, number, currency}  ", "  {0, number, currency}  ", "  {0, number, percent}  ", "  {0, number, percent}  ", "  {0, number,#,##0.###E0}  ", "  {0, number,#,##0.###E0}  ", "  {0, number}  ", "  {0, number}  ", "  {0, number, integer}  ", "  {0, number, integer}  ", "  {0, number, currency}  ", "  {0, number, currency}  ", "  {0, number, percent}  ", "  {0, number, percent}  ", "  {0, number,#,##0.###E0}  ", "  {0, number,#,##0.###E0}  " };

	static final java.lang.String[] from = new java.lang.String[]{ "  12,345,678,901,234,567,890.98765432109876543210987654321  ", "  -12,345,678,901,234,567,890.98765432109876543210987654321  ", "  $12,345,678,901,234,567,890.98765432109876543210987654321  ", "  ($12,345,678,901,234,567,890.98765432109876543210987654321)  ", "  1,234,567,890,123,456,789,098.76543210987654321098765432100%  ", "  -1,234,567,890,123,456,789,098.76543210987654321098765432100%  ", "  12,345,678,901,234,567,890.98765432109876543210987654321E-20  ", "  -12,345,678,901,234,567,890.98765432109876543210987654321E-20  ", "  9,876,543,210,987,654,321,098,765,432,109,876,543,210  ", "  -9,876,543,210,987,654,321,098,765,432,109,876,543,210  ", "  9,876,543,210,987,654,321,098,765,432,109,876,543,210E5  ", "  -9,876,543,210,987,654,321,098,765,432,109,876,543,210E-5  ", "  $9,876,543,210,987,654,321,098,765,432,109,876,543,210.00  ", "  ($9,876,543,210,987,654,321,098,765,432,109,876,543,210.00)  ", "  987,654,321,098,765,432,109,876,543,210,987,654,321,012%  ", "  -987,654,321,098,765,432,109,876,543,210,987,654,321,012%  ", "  98,765,432,109,876,543,210.98765432109876543210E20  ", "  -987,654,321,098,765,432,109,876,543,210,987,654,321,000,000,000,000,000,000,000E-20  " };

	static final java.lang.String[] expected1 = new java.lang.String[]{ "12345678901234567890.98765432109876543210987654321", "-12345678901234567890.98765432109876543210987654321", "12345678901234567890.98765432109876543210987654321", "-12345678901234567890.98765432109876543210987654321", "12345678901234567890.98765432109876543210987654321", "-12345678901234567890.98765432109876543210987654321", "0.1234567890123456789098765432109876543210987654321", "-0.1234567890123456789098765432109876543210987654321", "9876543210987654321098765432109876543210", "-9876543210987654321098765432109876543210", "9.876543210987654321098765432109876543210E44", "-98765432109876543210987654321098765.43210", "9876543210987654321098765432109876543210.00", "-9876543210987654321098765432109876543210.00", "9876543210987654321098765432109876543210.12", "-9876543210987654321098765432109876543210.12", "9876543210987654321098765432109876543210", "-9876543210987654321098765432109876543210.00000000000000000000" };

	static final int[] parsePosition1 = new int[]{ 60, 61, 61, 63, 64, 65, 64, 65, 57, 58, 59, 61, 61, 63, 60, 61, 54, 88 };

	void test_Parse_in_MessageFormat_NotParseIntegerOnly() {
		for (int i = 0; i < javaT.text.Format.NumberFormat.BigDecimalParse.patterns.length; i++) {
			pp = new java.text.ParsePosition(0);
			java.lang.Object[] parsed = null;
			try {
				java.text.MessageFormat mf = new java.text.MessageFormat(javaT.text.Format.NumberFormat.BigDecimalParse.patterns[i]);
				java.text.Format[] formats = mf.getFormats();
				for (int j = 0; j < formats.length; j++) {
					((java.text.DecimalFormat) (formats[j])).setParseBigDecimal(true);
				}
				parsed = mf.parse(javaT.text.Format.NumberFormat.BigDecimalParse.from[i], pp);
				if (pp.getErrorIndex() != (-1)) {
					errln((((("Case" + (i + 1)) + ": getErrorIndex() returns wrong value. expected:-1, got:") + pp.getErrorIndex()) + " for ") + javaT.text.Format.NumberFormat.BigDecimalParse.from[i]);
				}
				if (pp.getIndex() != javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition1[i]) {
					errln((((((("Case" + (i + 1)) + ": getIndex() returns wrong value. expected:") + javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition1[i]) + ", got:") + pp.getIndex()) + " for ") + javaT.text.Format.NumberFormat.BigDecimalParse.from[i]);
				}
			} catch (java.lang.Exception e) {
				errln("Unexpected exception: " + e.getMessage());
			}
			checkType(javaT.text.Format.NumberFormat.BigDecimalParse.from[i], getType(new java.math.BigDecimal(javaT.text.Format.NumberFormat.BigDecimalParse.expected1[i])), getType(((java.lang.Number) (parsed[0]))));
			checkParse(javaT.text.Format.NumberFormat.BigDecimalParse.from[i], new java.math.BigDecimal(javaT.text.Format.NumberFormat.BigDecimalParse.expected1[i]), ((java.lang.Number) (parsed[0])));
		}
	}

	static final java.lang.String[] expected2 = new java.lang.String[]{ "12345678901234567890", "-12345678901234567890", "12345678901234567890", "-12345678901234567890", "12345678901234567890", "-12345678901234567890", "0", "0", "9876543210987654321098765432109876543210", "-9876543210987654321098765432109876543210", "9.876543210987654321098765432109876543210E44", "-98765432109876543210987654321098765.43210", "9876543210987654321098765432109876543210", "-9876543210987654321098765432109876543210", "9876543210987654321098765432109876543210.12", "-9876543210987654321098765432109876543210.12", "9876543210987654321098765432109876543210", "-9876543210987654321098765432109876543210.00000000000000000000" };

	static final int[][] parsePosition2 = new int[][]{ new int[]{ 28, 0 }, new int[]{ 29, 0 }, new int[]{ 29, 0 }, new int[]{ 2, 0 }, new int[]{ 2, 0 }, new int[]{ 2, 0 }, new int[]{ 28, 0 }, new int[]{ 29, 0 }, new int[]{ -1, 57 }, new int[]{ -1, 58 }, new int[]{ -1, 59 }, new int[]{ -1, 61 }, new int[]{ 56, 0 }, new int[]{ 2, 0 }, new int[]{ -1, 60 }, new int[]{ -1, 61 }, new int[]{ 28, 0 }, new int[]{ -1, 88 } };

	void test_Parse_in_MessageFormat_ParseIntegerOnly() {
		for (int i = 0; i < javaT.text.Format.NumberFormat.BigDecimalParse.patterns.length; i++) {
			pp = new java.text.ParsePosition(0);
			java.lang.Object[] parsed = null;
			try {
				java.text.MessageFormat mf = new java.text.MessageFormat(javaT.text.Format.NumberFormat.BigDecimalParse.patterns[i]);
				java.text.Format[] formats = mf.getFormats();
				for (int j = 0; j < formats.length; j++) {
					((java.text.DecimalFormat) (formats[j])).setParseBigDecimal(true);
					((java.text.DecimalFormat) (formats[j])).setParseIntegerOnly(true);
				}
				parsed = mf.parse(javaT.text.Format.NumberFormat.BigDecimalParse.from[i], pp);
				if (pp.getErrorIndex() != javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition2[i][0]) {
					errln((((((("Case" + (i + 1)) + ": getErrorIndex() returns wrong value. expected:") + javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition2[i][0]) + ", got:") + pp.getErrorIndex()) + " for ") + javaT.text.Format.NumberFormat.BigDecimalParse.from[i]);
				}
				if (pp.getIndex() != javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition2[i][1]) {
					errln((((((("Case" + (i + 1)) + ": getIndex() returns wrong value. expected:") + javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition2[i][1]) + ", got:") + pp.getIndex()) + " for ") + javaT.text.Format.NumberFormat.BigDecimalParse.from[i]);
				}
			} catch (java.lang.Exception e) {
				errln("Unexpected exception: " + e.getMessage());
			}
			if (javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition2[i][0] == (-1)) {
				checkType(javaT.text.Format.NumberFormat.BigDecimalParse.from[i], getType(new java.math.BigDecimal(javaT.text.Format.NumberFormat.BigDecimalParse.expected2[i])), getType(((java.lang.Number) (parsed[0]))));
				checkParse(javaT.text.Format.NumberFormat.BigDecimalParse.from[i], new java.math.BigDecimal(javaT.text.Format.NumberFormat.BigDecimalParse.expected2[i]), ((java.lang.Number) (parsed[0])));
			}
		}
	}

	static final java.lang.String[] from3 = new java.lang.String[]{ "12,345,678,901,234,567,890.98765432109876543210987654321", "-12,345,678,901,234,567,890.98765432109876543210987654321", "9,876,543,210,987,654,321,098,765,432,109,876,543,210", "-9,876,543,210,987,654,321,098,765,432,109,876,543,210", "1234556790000E-8" };

	static final java.lang.String[] expected3 = new java.lang.String[]{ "12345678901234567890", "-12345678901234567890", "9876543210987654321098765432109876543210", "-9876543210987654321098765432109876543210", "12345.56790000" };

	static final int[][] parsePosition3 = new int[][]{ new int[]{ -1, 26 }, new int[]{ -1, 27 }, new int[]{ -1, 53 }, new int[]{ -1, 54 }, new int[]{ -1, 16 } };

	void test_Parse_in_DecimalFormat_ParseIntegerOnly() {
		java.text.DecimalFormat df = ((java.text.DecimalFormat) (java.text.NumberFormat.getIntegerInstance()));
		df.setParseBigDecimal(true);
		for (int i = 0; i < javaT.text.Format.NumberFormat.BigDecimalParse.from3.length; i++) {
			pp = new java.text.ParsePosition(0);
			java.lang.Number parsed = null;
			try {
				parsed = df.parse(javaT.text.Format.NumberFormat.BigDecimalParse.from3[i], pp);
				if (pp.getErrorIndex() != javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition3[i][0]) {
					errln((((((("Case" + (i + 1)) + ": getErrorIndex() returns wrong value. expected:") + javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition3[i][0]) + ", got:") + pp.getErrorIndex()) + " for ") + javaT.text.Format.NumberFormat.BigDecimalParse.from3[i]);
				}
				if (pp.getIndex() != javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition3[i][1]) {
					errln((((((("Case" + (i + 1)) + ": getIndex() returns wrong value. expected:") + javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition3[i][1]) + ", got:") + pp.getIndex()) + " for ") + javaT.text.Format.NumberFormat.BigDecimalParse.from3[i]);
				}
			} catch (java.lang.Exception e) {
				errln("Unexpected exception: " + e.getMessage());
			}
			if (javaT.text.Format.NumberFormat.BigDecimalParse.parsePosition3[i][0] == (-1)) {
				checkType(javaT.text.Format.NumberFormat.BigDecimalParse.from3[i], getType(new java.math.BigDecimal(javaT.text.Format.NumberFormat.BigDecimalParse.expected3[i])), getType(parsed));
				checkParse(javaT.text.Format.NumberFormat.BigDecimalParse.from3[i], new java.math.BigDecimal(javaT.text.Format.NumberFormat.BigDecimalParse.expected3[i]), parsed);
			}
		}
	}

	protected void check(java.lang.String from, java.lang.Number to) {
		pp = new java.text.ParsePosition(0);
		try {
			parsed = df.parse(from, pp);
		} catch (java.lang.Exception e) {
			exceptionOccurred = true;
			errln(e.getMessage());
		}
		if (!exceptionOccurred) {
			checkParse(from, to, parsed);
			checkType(from, getType(to), getType(parsed));
			checkParsePosition(from, from.length(), pp.getIndex());
		}
	}

	private void checkParse(java.lang.String orig, java.lang.Number expected, java.lang.Number got) {
		if (!expected.equals(got)) {
			errln((((((("Parsing... failed." + "\n   original: ") + orig) + "\n   parsed:   ") + got) + "\n   expected: ") + expected) + "\n");
		}
	}

	private void checkType(java.lang.String orig, java.lang.String expected, java.lang.String got) {
		if (!expected.equals(got)) {
			errln((((((("Parsing... unexpected Class returned." + "\n   original: ") + orig) + "\n   got:      ") + got) + "\n   expected: ") + expected) + "\n");
		}
	}

	private void checkParsePosition(java.lang.String orig, int expected, int got) {
		if (expected != got) {
			errln((((((("Parsing... wrong ParsePosition returned." + "\n   original: ") + orig) + "\n   got:      ") + got) + "\n   expected: ") + expected) + "\n");
		}
	}

	private java.lang.String getType(java.lang.Number number) {
		return number.getClass().getName();
	}
}