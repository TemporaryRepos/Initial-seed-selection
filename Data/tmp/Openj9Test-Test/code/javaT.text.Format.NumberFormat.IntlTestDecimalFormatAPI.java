public class IntlTestDecimalFormatAPI extends javaT.text.testlib.IntlTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Format.NumberFormat.IntlTestDecimalFormatAPI().run(args);
	}

	public void TestAPI() {
		java.util.Locale reservedLocale = java.util.Locale.getDefault();
		try {
			logln("DecimalFormat API test---");
			logln("");
			java.util.Locale.setDefault(java.util.Locale.ENGLISH);
			logln("Testing DecimalFormat constructors");
			java.text.DecimalFormat def = new java.text.DecimalFormat();
			final java.lang.String pattern = new java.lang.String("#,##0.# FF");
			java.text.DecimalFormat pat = null;
			try {
				pat = new java.text.DecimalFormat(pattern);
			} catch (java.lang.IllegalArgumentException e) {
				errln("ERROR: Could not create DecimalFormat (pattern)");
			}
			java.text.DecimalFormatSymbols symbols = new java.text.DecimalFormatSymbols(java.util.Locale.FRENCH);
			java.text.DecimalFormat cust1 = new java.text.DecimalFormat(pattern, symbols);
			logln("Testing clone() and equality operators");
			java.text.Format clone = ((java.text.Format) (def.clone()));
			if (!def.equals(clone)) {
				errln("ERROR: Clone() failed");
			}
			logln("Testing various format() methods");
			final double d = -10456.0037;
			final long l = 100000000;
			logln(("" + d) + " is the double value");
			java.lang.StringBuffer res1 = new java.lang.StringBuffer();
			java.lang.StringBuffer res2 = new java.lang.StringBuffer();
			java.lang.StringBuffer res3 = new java.lang.StringBuffer();
			java.lang.StringBuffer res4 = new java.lang.StringBuffer();
			java.text.FieldPosition pos1 = new java.text.FieldPosition(0);
			java.text.FieldPosition pos2 = new java.text.FieldPosition(0);
			java.text.FieldPosition pos3 = new java.text.FieldPosition(0);
			java.text.FieldPosition pos4 = new java.text.FieldPosition(0);
			res1 = def.format(d, res1, pos1);
			logln((("" + d) + " formatted to ") + res1);
			res2 = pat.format(l, res2, pos2);
			logln((("" + l) + " formatted to ") + res2);
			res3 = cust1.format(d, res3, pos3);
			logln((("" + d) + " formatted to ") + res3);
			res4 = cust1.format(l, res4, pos4);
			logln((("" + l) + " formatted to ") + res4);
			logln("Testing parse()");
			java.lang.String text = new java.lang.String("-10,456.0037");
			java.text.ParsePosition pos = new java.text.ParsePosition(0);
			java.lang.String patt = new java.lang.String("#,##0.#");
			pat.applyPattern(patt);
			double d2 = pat.parse(text, pos).doubleValue();
			if (d2 != d) {
				errln((((("ERROR: Roundtrip failed (via parse(" + d2) + " != ") + d) + ")) for ") + text);
			}
			logln((text + " parsed into ") + ((long) (d2)));
			logln("Testing getters and setters");
			final java.text.DecimalFormatSymbols syms = pat.getDecimalFormatSymbols();
			def.setDecimalFormatSymbols(syms);
			if (!pat.getDecimalFormatSymbols().equals(def.getDecimalFormatSymbols())) {
				errln("ERROR: set DecimalFormatSymbols() failed");
			}
			java.lang.String posPrefix;
			pat.setPositivePrefix("+");
			posPrefix = pat.getPositivePrefix();
			logln("Positive prefix (should be +): " + posPrefix);
			if (posPrefix != "+") {
				errln("ERROR: setPositivePrefix() failed");
			}
			java.lang.String negPrefix;
			pat.setNegativePrefix("-");
			negPrefix = pat.getNegativePrefix();
			logln("Negative prefix (should be -): " + negPrefix);
			if (negPrefix != "-") {
				errln("ERROR: setNegativePrefix() failed");
			}
			java.lang.String posSuffix;
			pat.setPositiveSuffix("_");
			posSuffix = pat.getPositiveSuffix();
			logln("Positive suffix (should be _): " + posSuffix);
			if (posSuffix != "_") {
				errln("ERROR: setPositiveSuffix() failed");
			}
			java.lang.String negSuffix;
			pat.setNegativeSuffix("~");
			negSuffix = pat.getNegativeSuffix();
			logln("Negative suffix (should be ~): " + negSuffix);
			if (negSuffix != "~") {
				errln("ERROR: setNegativeSuffix() failed");
			}
			long multiplier = 0;
			pat.setMultiplier(8);
			multiplier = pat.getMultiplier();
			logln("Multiplier (should be 8): " + multiplier);
			if (multiplier != 8) {
				errln("ERROR: setMultiplier() failed");
			}
			int groupingSize = 0;
			pat.setGroupingSize(2);
			groupingSize = pat.getGroupingSize();
			logln("Grouping size (should be 2): " + ((long) (groupingSize)));
			if (groupingSize != 2) {
				errln("ERROR: setGroupingSize() failed");
			}
			pat.setDecimalSeparatorAlwaysShown(true);
			boolean tf = pat.isDecimalSeparatorAlwaysShown();
			logln("DecimalSeparatorIsAlwaysShown (should be true) is " + (tf ? "true" : "false"));
			if (tf != true) {
				errln("ERROR: setDecimalSeparatorAlwaysShown() failed");
			}
			java.lang.String funkyPat;
			funkyPat = pat.toPattern();
			logln("Pattern is " + funkyPat);
			java.lang.String locPat;
			locPat = pat.toLocalizedPattern();
			logln("Localized pattern is " + locPat);
			logln("Testing applyPattern()");
			java.lang.String p1 = new java.lang.String("#,##0.0#;(#,##0.0#)");
			logln("Applying pattern " + p1);
			pat.applyPattern(p1);
			java.lang.String s2;
			s2 = pat.toPattern();
			logln("Extracted pattern is " + s2);
			if (!s2.equals(p1)) {
				errln("ERROR: toPattern() result did not match " + "pattern applied");
			}
			java.lang.String p2 = new java.lang.String("#,##0.0# FF;(#,##0.0# FF)");
			logln("Applying pattern " + p2);
			pat.applyLocalizedPattern(p2);
			java.lang.String s3;
			s3 = pat.toLocalizedPattern();
			logln("Extracted pattern is " + s3);
			if (!s3.equals(p2)) {
				errln("ERROR: toLocalizedPattern() result did not match " + "pattern applied");
			}
		} finally {
			java.util.Locale.setDefault(reservedLocale);
		}
	}
}