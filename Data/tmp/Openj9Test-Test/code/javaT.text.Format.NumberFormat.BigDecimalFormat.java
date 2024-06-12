public class BigDecimalFormat extends javaT.text.testlib.IntlTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Format.NumberFormat.BigDecimalFormat().run(args);
	}

	static final java.lang.String nonsep_int = "123456789012345678901234567890123456789012345678901234567890" + (((("123456789012345678901234567890123456789012345678901234567890" + "123456789012345678901234567890123456789012345678901234567890") + "123456789012345678901234567890123456789012345678901234567890") + "123456789012345678901234567890123456789012345678901234567890") + "123456789012345678901234567890123456789012345678901234567890");

	static final java.lang.String sep_int = "123,456,789,012,345,678,901,234,567,890," + (((((((((("123,456,789,012,345,678,901,234,567,890," + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890,") + "123,456,789,012,345,678,901,234,567,890");

	static final java.lang.String nonsep_zero = "000000000000000000000000000000000000000000000000000000000000" + (((("000000000000000000000000000000000000000000000000000000000000" + "000000000000000000000000000000000000000000000000000000000000") + "000000000000000000000000000000000000000000000000000000000000") + "000000000000000000000000000000000000000000000000000000000000") + "000000000000000000000000000000000000000000000000000000000000");

	static final java.lang.String sep_zero = "000,000,000,000,000,000,000,000,000,000," + (((((((((("000,000,000,000,000,000,000,000,000,000," + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000,") + "000,000,000,000,000,000,000,000,000,000");

	static final java.lang.String fra = "012345678901234567890123456789012345678901234567890123456789" + (((("012345678901234567890123456789012345678901234567890123456789" + "012345678901234567890123456789012345678901234567890123456789") + "012345678901234567890123456789012345678901234567890123456789") + "012345678901234567890123456789012345678901234567890123456789") + "012345678901234567890123456789012345678901234567890123456789");

	java.lang.StringBuffer formatted = new java.lang.StringBuffer(1000);

	java.text.FieldPosition fp;

	void test_Format_in_NumberFormat_BigDecimal() {
		java.lang.String from;
		java.lang.String to;
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.US);
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 0);
		formatted.setLength(0);
		from = ("0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + "123456789";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, from, ((java.text.DecimalFormat) (nf)).getMultiplier());
		fp = new java.text.FieldPosition(java.text.NumberFormat.Field.SIGN);
		formatted.setLength(0);
		from = ("-0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + "123456789";
		nf.format(new java.math.BigDecimal(from), formatted, fp);
		checkFormat(from, formatted, from, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 0, 1);
		fp = new java.text.FieldPosition(java.text.DecimalFormat.INTEGER_FIELD);
		formatted.setLength(0);
		from = (javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = (javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		nf.format(new java.math.BigDecimal(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 0, 479);
		fp = new java.text.FieldPosition(java.text.DecimalFormat.FRACTION_FIELD);
		formatted.setLength(0);
		from = (("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = (("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		nf.format(new java.math.BigDecimal(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 481, 841);
		formatted.setLength(0);
		from = (((javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = ((((javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int + ",") + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = (((("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = ((((("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int) + ",") + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = (javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int + ",") + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = ("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = (("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int) + ",") + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = ((javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = (javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int + ",") + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = ((("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = (("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int) + ",") + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "0";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = "-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "0";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero + "1234";
		to = "1,234";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		fp = new java.text.FieldPosition(java.text.NumberFormat.Field.GROUPING_SEPARATOR);
		formatted.setLength(0);
		from = ("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + "1234";
		to = "-1,234";
		nf.format(new java.math.BigDecimal(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 2, 3);
		formatted.setLength(0);
		from = (javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "0";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.0");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 1);
		formatted.setLength(0);
		from = (("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "0.0";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = ((javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = (javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = ((("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = (("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("0.###E0");
		setDigits(nf, 1, 1, java.lang.Integer.MAX_VALUE, 0);
		fp = new java.text.FieldPosition(java.text.NumberFormat.Field.EXPONENT);
		formatted.setLength(0);
		from = (("1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = (("1." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E360";
		nf.format(new java.math.BigDecimal(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 723, 726);
		formatted.setLength(0);
		from = (("-1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = (("-1." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E360";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("0.###E0");
		setDigits(nf, 1, 1, java.lang.Integer.MAX_VALUE, 0);
		formatted.setLength(0);
		from = (("0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + "1") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = ("1." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E-361";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = (("-0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + "1") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = ("-1." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E-361";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = ((("1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = (("1." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E360";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		fp = new java.text.FieldPosition(java.text.NumberFormat.Field.EXPONENT_SYMBOL);
		formatted.setLength(0);
		from = ((("-1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = (("-1." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E360";
		nf.format(new java.math.BigDecimal(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 723, 724);
		fp = new java.text.FieldPosition(java.text.NumberFormat.Field.EXPONENT_SIGN);
		formatted.setLength(0);
		from = ((("0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + "1") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = ("1." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E-361";
		nf.format(new java.math.BigDecimal(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 363, 364);
		formatted.setLength(0);
		from = ((("-0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + "1") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = ("-1." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E-361";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted = new java.lang.StringBuffer("ABC");
		from = (("1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = (("ABC1." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E360";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		fp = new java.text.FieldPosition(java.text.NumberFormat.Field.DECIMAL_SEPARATOR);
		formatted = new java.lang.StringBuffer("ABC");
		from = (("-1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = (("ABC-1." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E360";
		nf.format(new java.math.BigDecimal(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 5, 6);
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, 726, 0);
		formatted.setLength(0);
		from = (("0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = (("0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "012346";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, 723, 0);
		formatted.setLength(0);
		from = (("-0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = (("-0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "012";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("00000.###E0");
		setDigits(nf, 5, 5, 370, 0);
		formatted.setLength(0);
		from = ("1234567890." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "0123456789";
		to = ("12345.67890" + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "01235E5";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("0.###E0");
		setDigits(nf, 1, 1, 364, 0);
		formatted.setLength(0);
		from = ((("-0." + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + "1") + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "0123456789";
		to = ("-1." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "0123E-361";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("0.###E0");
		setDigits(nf, 1, 1, 366, 0);
		formatted.setLength(0);
		from = ("1" + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "0123456789";
		to = ("1." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "012346E370";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("0.###E0");
		setDigits(nf, 1, 1, 363, 0);
		formatted.setLength(0);
		from = ("-1" + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "0123456789";
		to = ("-1." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "012E370";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 720);
		formatted.setLength(0);
		from = (((javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = ((((javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int + ",") + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = (((("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = ((((("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int) + ",") + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
	}

	void test_Format_in_NumberFormat_BigDecimal_usingMultiplier() {
		java.lang.String from;
		java.lang.String to;
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.US);
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 0);
		((java.text.DecimalFormat) (nf)).setMultiplier(250000000);
		((java.text.DecimalFormat) (nf)).setDecimalSeparatorAlwaysShown(true);
		formatted.setLength(0);
		from = (("1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = ("250,000,000," + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero) + ".";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).setDecimalSeparatorAlwaysShown(false);
		formatted.setLength(0);
		from = (("-1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "-250,000,000," + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 0);
		((java.text.DecimalFormat) (nf)).setMultiplier(-250000000);
		((java.text.DecimalFormat) (nf)).setDecimalSeparatorAlwaysShown(true);
		formatted.setLength(0);
		from = (("1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = ("-250,000,000," + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero) + ".";
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).setDecimalSeparatorAlwaysShown(false);
		formatted.setLength(0);
		from = (("-1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "250,000,000," + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero;
		nf.format(new java.math.BigDecimal(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
	}

	void test_Format_in_NumberFormat_BigInteger() {
		java.lang.String from;
		java.lang.String to;
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.US);
		if (!(nf instanceof java.text.DecimalFormat)) {
			throw new java.lang.RuntimeException("Couldn't get DecimalFormat instance.");
		}
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 0);
		formatted.setLength(0);
		from = javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int;
		to = javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int;
		nf.format(new java.math.BigInteger(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		fp = new java.text.FieldPosition(java.text.DecimalFormat.INTEGER_FIELD);
		formatted.setLength(0);
		from = "-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int;
		to = "-" + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int;
		nf.format(new java.math.BigInteger(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 1, 480);
		formatted.setLength(0);
		from = javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int;
		to = javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int;
		nf.format(new java.math.BigInteger(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		fp = new java.text.FieldPosition(java.text.NumberFormat.Field.SIGN);
		formatted.setLength(0);
		from = ("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_int;
		to = "-" + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_int;
		nf.format(new java.math.BigInteger(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 0, 1);
		formatted.setLength(0);
		from = javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "0";
		nf.format(new java.math.BigInteger(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.0");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 1);
		fp = new java.text.FieldPosition(java.text.NumberFormat.Field.DECIMAL_SEPARATOR);
		formatted.setLength(0);
		from = "-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "0.0";
		nf.format(new java.math.BigInteger(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 1, 2);
		((java.text.DecimalFormat) (nf)).applyPattern("0.###E0");
		setDigits(nf, 1, 1, java.lang.Integer.MAX_VALUE, 0);
		fp = new java.text.FieldPosition(java.text.NumberFormat.Field.EXPONENT);
		formatted.setLength(0);
		from = "1" + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = ("1." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E360";
		nf.format(new java.math.BigInteger(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 363, 366);
		formatted.setLength(0);
		from = "-1" + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = ("-1." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E360";
		nf.format(new java.math.BigInteger(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("00000.###E0");
		setDigits(nf, 5, 5, java.lang.Integer.MAX_VALUE, 720);
		fp = new java.text.FieldPosition(java.text.NumberFormat.Field.EXPONENT);
		formatted.setLength(0);
		from = ("12345" + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = (("12345." + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero) + "E720";
		nf.format(new java.math.BigInteger(from), formatted, fp);
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		checkFieldPosition(from, fp, 727, 730);
		((java.text.DecimalFormat) (nf)).applyPattern("00000.###E0");
		setDigits(nf, 5, 5, java.lang.Integer.MAX_VALUE, 365);
		formatted.setLength(0);
		from = "-1234567890" + javaT.text.Format.NumberFormat.BigDecimalFormat.fra;
		to = ("-12345.67890" + javaT.text.Format.NumberFormat.BigDecimalFormat.fra) + "E365";
		nf.format(new java.math.BigInteger(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
	}

	void test_Format_in_NumberFormat_BigInteger_usingMultiplier() {
		java.lang.String from;
		java.lang.String to;
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.US);
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		((java.text.DecimalFormat) (nf)).setMultiplier(250000000);
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 0);
		formatted.setLength(0);
		from = "1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "250,000,000," + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero;
		nf.format(new java.math.BigInteger(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = "-1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "-250,000,000," + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero;
		nf.format(new java.math.BigInteger(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		((java.text.DecimalFormat) (nf)).setMultiplier(-250000000);
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 0);
		formatted.setLength(0);
		from = "1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "-250,000,000," + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero;
		nf.format(new java.math.BigInteger(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		formatted.setLength(0);
		from = "-1" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero;
		to = "250,000,000," + javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero;
		nf.format(new java.math.BigInteger(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
	}

	void test_Format_in_NumberFormat_Long_checkDigits() {
		java.lang.String from;
		java.lang.String to;
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.US);
		if (!(nf instanceof java.text.DecimalFormat)) {
			throw new java.lang.RuntimeException("Couldn't get DecimalFormat instance.");
		}
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 360, java.lang.Integer.MAX_VALUE, 0);
		formatted.setLength(0);
		from = "123456789";
		to = javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero.substring(0, 399) + ",123,456,789";
		nf.format(new java.lang.Long(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("##0.###");
		((java.text.DecimalFormat) (nf)).setMultiplier(-1);
		setDigits(nf, java.lang.Integer.MAX_VALUE, 360, java.lang.Integer.MAX_VALUE, 360);
		formatted.setLength(0);
		from = "123456789";
		to = (("-" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero.substring(0, 300)) + "123456789.") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero.substring(0, 340);
		nf.format(new java.lang.Long(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		((java.text.DecimalFormat) (nf)).setMultiplier(java.lang.Integer.MAX_VALUE);
		setDigits(nf, java.lang.Integer.MAX_VALUE, 360, java.lang.Integer.MAX_VALUE, 0);
		formatted.setLength(0);
		from = java.lang.Long.toString(java.lang.Long.MAX_VALUE);
		to = javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero.substring(0, 373) + "19,807,040,619,342,712,359,383,728,129";
		nf.format(new java.lang.Long(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("0.###E0");
		((java.text.DecimalFormat) (nf)).setMultiplier(java.lang.Integer.MIN_VALUE);
		setDigits(nf, 1, 1, java.lang.Integer.MAX_VALUE, 360);
		formatted.setLength(0);
		from = java.lang.Long.toString(java.lang.Long.MAX_VALUE);
		to = ("-1.9807040628566084396238503936" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero.substring(0, 312)) + "E28";
		nf.format(new java.lang.Long(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("##0.###E0");
		((java.text.DecimalFormat) (nf)).setMultiplier(java.lang.Integer.MAX_VALUE);
		setDigits(nf, java.lang.Integer.MAX_VALUE, 360, java.lang.Integer.MAX_VALUE, 360);
		formatted.setLength(0);
		from = java.lang.Long.toString(java.lang.Long.MIN_VALUE);
		to = ((("-19807040619342712361531211776" + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero.substring(0, 280)) + ".") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero.substring(0, 340)) + "E-280";
		nf.format(new java.lang.Long(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		((java.text.DecimalFormat) (nf)).setMultiplier(java.lang.Integer.MIN_VALUE);
		setDigits(nf, java.lang.Integer.MAX_VALUE, 360, java.lang.Integer.MAX_VALUE, 360);
		formatted.setLength(0);
		from = java.lang.Long.toString(java.lang.Long.MIN_VALUE);
		to = (javaT.text.Format.NumberFormat.BigDecimalFormat.sep_zero.substring(0, 373) + "19,807,040,628,566,084,398,385,987,584.") + javaT.text.Format.NumberFormat.BigDecimalFormat.nonsep_zero.substring(0, 340);
		nf.format(new java.lang.Long(from), formatted, new java.text.FieldPosition(0));
		checkFormat(from, formatted, to, ((java.text.DecimalFormat) (nf)).getMultiplier());
	}

	void test_Format_in_NumberFormat_SpecialNumber() {
		java.lang.String from;
		java.lang.String to;
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.US);
		if (!(nf instanceof java.text.DecimalFormat)) {
			throw new java.lang.RuntimeException("Couldn't get DecimalFormat instance.");
		}
		((java.text.DecimalFormat) (nf)).applyPattern("#,##0.###");
		setDigits(nf, java.lang.Integer.MAX_VALUE, 1, java.lang.Integer.MAX_VALUE, 0);
		double[] numbers = new double[]{ -0.0, 0.0, java.lang.Double.NaN, java.lang.Double.POSITIVE_INFINITY, 5.1, 5.0, java.lang.Double.NEGATIVE_INFINITY, -5.1, -5.0 };
		int[] multipliers = new int[]{ 0, 5, -5 };
		java.lang.String[][] expected = new java.lang.String[][]{ new java.lang.String[]{ "-0", "0", "�", "�", "0", "0", "�", "-0", "-0" }, new java.lang.String[]{ "-0", "0", "�", "∞", "25.5", "25", "-∞", "-25.5", "-25" }, new java.lang.String[]{ "0", "-0", "�", "-∞", "-25.5", "-25", "∞", "25.5", "25" } };
		for (int i = 0; i < multipliers.length; i++) {
			((java.text.DecimalFormat) (nf)).setMultiplier(multipliers[i]);
			for (int j = 0; j < numbers.length; j++) {
				formatted.setLength(0);
				from = java.lang.String.valueOf(numbers[j]);
				nf.format(numbers[j], formatted, new java.text.FieldPosition(0));
				checkFormat(from, formatted, expected[i][j], ((java.text.DecimalFormat) (nf)).getMultiplier());
			}
		}
	}

	void test_Format_in_NumberFormat_Other() {
		java.lang.String from;
		java.lang.String to;
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance(java.util.Locale.US);
		if (!(nf instanceof java.text.DecimalFormat)) {
			throw new java.lang.RuntimeException("Couldn't get DecimalFormat instance.");
		}
		long[] numbers = new long[]{ java.lang.Long.MIN_VALUE };
		int[] multipliers = new int[]{ 1, -1 };
		java.lang.String[][] expected = new java.lang.String[][]{ new java.lang.String[]{ "-9,223,372,036,854,775,808" }, new java.lang.String[]{ "9,223,372,036,854,775,808" } };
		for (int i = 0; i < multipliers.length; i++) {
			((java.text.DecimalFormat) (nf)).setMultiplier(multipliers[i]);
			for (int j = 0; j < numbers.length; j++) {
				formatted.setLength(0);
				from = java.lang.String.valueOf(numbers[j]);
				nf.format(numbers[j], formatted, new java.text.FieldPosition(0));
				checkFormat(from, formatted, expected[i][j], ((java.text.DecimalFormat) (nf)).getMultiplier());
			}
		}
	}

	void test_Format_in_MessageFormat() {
		java.text.MessageFormat mf = new java.text.MessageFormat("  {0, number}\n" + (((((((("  {0, number, integer}\n" + "  {0, number, currency}\n") + "  {0, number, percent}\n") + "  {0, number,0.###########E0}\n") + "  {1, number}\n") + "  {1, number, integer}\n") + "  {1, number, currency}\n") + "  {1, number, percent}\n") + "  {1, number,0.#######E0}\n"), java.util.Locale.US);
		java.lang.Object[] testArgs = new java.lang.Object[]{ new java.math.BigInteger("9876543210987654321098765432109876543210"), new java.math.BigDecimal("-12345678901234567890.98765432109876543210987654321") };
		java.lang.String expected = "  9,876,543,210,987,654,321,098,765,432,109,876,543,210\n" + (((((((("  9,876,543,210,987,654,321,098,765,432,109,876,543,210\n" + "  $9,876,543,210,987,654,321,098,765,432,109,876,543,210.00\n") + "  987,654,321,098,765,432,109,876,543,210,987,654,321,000%\n") + "  9.87654321099E39\n") + "  -12,345,678,901,234,567,890.988\n") + "  -12,345,678,901,234,567,891\n") + "  ($12,345,678,901,234,567,890.99)\n") + "  -1,234,567,890,123,456,789,099%\n") + "  -1.2345679E19\n");
		if (!expected.equals(mf.format(testArgs))) {
			errln((("Wrong format.\n      got:\n" + mf.format(testArgs)) + "     expected:\n") + expected);
		}
	}

	private void setDigits(java.text.NumberFormat nf, int i_max, int i_min, int f_max, int f_min) {
		nf.setMaximumIntegerDigits(i_max);
		nf.setMinimumIntegerDigits(i_min);
		nf.setMaximumFractionDigits(f_max);
		nf.setMinimumFractionDigits(f_min);
	}

	private void checkFormat(java.lang.String orig, java.lang.StringBuffer got, java.lang.String expected, int multiplier) {
		if (!expected.equals(new java.lang.String(got))) {
			errln((((((((("Formatting... failed." + "\n   original:   ") + orig) + "\n   multiplier: ") + multiplier) + "\n   formatted:  ") + got) + "\n   expected:   ") + expected) + "\n");
		}
	}

	private void checkFieldPosition(java.lang.String orig, java.text.FieldPosition fp, int begin, int end) {
		int position;
		if ((position = fp.getBeginIndex()) != begin) {
			errln((((((((("Formatting... wrong Begin index returned for " + fp.getFieldAttribute()) + ".") + "\n   original: ") + orig) + "\n   got:      ") + position) + "\n   expected: ") + begin) + "\n");
		}
		if ((position = fp.getEndIndex()) != end) {
			errln((((((((("Formatting... wrong End index returned for " + fp.getFieldAttribute()) + ".") + "\n   original: ") + orig) + "\n   got:      ") + position) + "\n   expected: ") + end) + "\n");
		}
	}
}