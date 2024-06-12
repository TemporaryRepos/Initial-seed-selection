public class DFSExponential extends javaT.text.testlib.IntlTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Format.NumberFormat.DFSExponential().run(args);
	}

	public void DFSExponenTest() throws java.lang.Exception {
		java.text.DecimalFormatSymbols sym = new java.text.DecimalFormatSymbols(java.util.Locale.US);
		java.lang.String[] pat = new java.lang.String[]{ "0.####E0", "00.000E00", "##0.####E000", "0.###E0;[0.###E0]" };
		double[] val = new double[]{ 0.01234, 123456789, 1.23E300, -3.141592653E-271 };
		long[] lval = new long[]{ 0, -1, 1, 123456789 };
		java.lang.String[][] valFormat = new java.lang.String[][]{ new java.lang.String[]{ "1.234x10^-2", "1.2346x10^8", "1.23x10^300", "-3.1416x10^-271" }, new java.lang.String[]{ "12.340x10^-03", "12.346x10^07", "12.300x10^299", "-31.416x10^-272" }, new java.lang.String[]{ "12.34x10^-003", "123.4568x10^006", "1.23x10^300", "-314.1593x10^-273" }, new java.lang.String[]{ "1.234x10^-2", "1.235x10^8", "1.23x10^300", "[3.142x10^-271]" } };
		int ival = 0;
		int ilval = 0;
		logln("Default exponent separator: " + sym.getExponentSeparator());
		try {
			sym.setExponentSeparator("x10^");
		} catch (java.lang.NullPointerException e) {
			errln("null String was passed to set an exponent separator symbol");
			throw new java.lang.RuntimeException("Test Malfunction: null String was passed to set an exponent separator symbol");
		}
		logln("Current exponent separator: " + sym.getExponentSeparator());
		for (int p = 0; p < pat.length; ++p) {
			java.text.DecimalFormat fmt = new java.text.DecimalFormat(pat[p], sym);
			logln("     Pattern: " + fmt.toPattern());
			java.lang.String locPattern = fmt.toLocalizedPattern();
			logln("     Localized pattern: " + locPattern);
			for (int v = 0; v < val.length; ++v) {
				java.lang.String s = fmt.format(val[v]);
				logln((("         " + val[v]) + " --> ") + s);
				if (valFormat[p][v].equals(s)) {
					logln(": Passed");
				} else {
					errln(((" Failed: Should be formatted as " + valFormat[p][v]) + "but got ") + s);
					throw new java.lang.RuntimeException(((" Failed: Should be formatted as " + valFormat[p][v]) + "but got ") + s);
				}
			}
		}
	}
}