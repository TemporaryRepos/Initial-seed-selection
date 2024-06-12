public class IntlTestDecimalFormatSymbols extends javaT.text.testlib.IntlTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Format.NumberFormat.IntlTestDecimalFormatSymbols().run(args);
	}

	public void TestSymbols() {
		java.text.DecimalFormatSymbols fr = new java.text.DecimalFormatSymbols(java.util.Locale.FRENCH);
		java.text.DecimalFormatSymbols en = new java.text.DecimalFormatSymbols(java.util.Locale.ENGLISH);
		if (en.equals(fr)) {
			errln("ERROR: English DecimalFormatSymbols equal to French");
		}
		char zero = en.getZeroDigit();
		fr.setZeroDigit(zero);
		if (fr.getZeroDigit() != en.getZeroDigit()) {
			errln("ERROR: get/set ZeroDigit failed");
		}
		char group = en.getGroupingSeparator();
		fr.setGroupingSeparator(group);
		if (fr.getGroupingSeparator() != en.getGroupingSeparator()) {
			errln("ERROR: get/set GroupingSeparator failed");
		}
		char decimal = en.getDecimalSeparator();
		fr.setDecimalSeparator(decimal);
		if (fr.getDecimalSeparator() != en.getDecimalSeparator()) {
			errln("ERROR: get/set DecimalSeparator failed");
		}
		char perMill = en.getPerMill();
		fr.setPerMill(perMill);
		if (fr.getPerMill() != en.getPerMill()) {
			errln("ERROR: get/set PerMill failed");
		}
		char percent = en.getPercent();
		fr.setPercent(percent);
		if (fr.getPercent() != en.getPercent()) {
			errln("ERROR: get/set Percent failed");
		}
		char digit = en.getDigit();
		fr.setDigit(digit);
		if (fr.getPercent() != en.getPercent()) {
			errln("ERROR: get/set Percent failed");
		}
		char patternSeparator = en.getPatternSeparator();
		fr.setPatternSeparator(patternSeparator);
		if (fr.getPatternSeparator() != en.getPatternSeparator()) {
			errln("ERROR: get/set PatternSeparator failed");
		}
		java.lang.String infinity = en.getInfinity();
		fr.setInfinity(infinity);
		java.lang.String infinity2 = fr.getInfinity();
		if (!infinity.equals(infinity2)) {
			errln("ERROR: get/set Infinity failed");
		}
		java.lang.String nan = en.getNaN();
		fr.setNaN(nan);
		java.lang.String nan2 = fr.getNaN();
		if (!nan.equals(nan2)) {
			errln("ERROR: get/set NaN failed");
		}
		char minusSign = en.getMinusSign();
		fr.setMinusSign(minusSign);
		if (fr.getMinusSign() != en.getMinusSign()) {
			errln("ERROR: get/set MinusSign failed");
		}
		java.text.DecimalFormatSymbols foo = new java.text.DecimalFormatSymbols();
		en = ((java.text.DecimalFormatSymbols) (fr.clone()));
		if (!en.equals(fr)) {
			errln("ERROR: Clone failed");
		}
	}
}