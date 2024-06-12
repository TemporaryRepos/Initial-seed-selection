public class ParseDouble {
	private static final java.math.BigDecimal HALF = java.math.BigDecimal.valueOf(0.5);

	private static void fail(java.lang.String val, double n) {
		throw new java.lang.RuntimeException((("Double.parseDouble failed. String:" + val) + " Result:") + n);
	}

	private static void check(java.lang.String val) {
		double n = java.lang.Double.parseDouble(val);
		boolean isNegativeN = (n < 0) || ((n == 0) && ((1 / n) < 0));
		double na = java.lang.Math.abs(n);
		java.lang.String s = val.trim().toLowerCase();
		switch (s.charAt(s.length() - 1)) {
			case 'd' :
			case 'f' :
				s = s.substring(0, s.length() - 1);
				break;
		}
		boolean isNegative = false;
		if (s.charAt(0) == '+') {
			s = s.substring(1);
		} else if (s.charAt(0) == '-') {
			s = s.substring(1);
			isNegative = true;
		}
		if (s.equals("nan")) {
			if (!java.lang.Double.isNaN(n)) {
				javaT.lang.Double.ParseDouble.fail(val, n);
			}
			return;
		}
		if (java.lang.Double.isNaN(n)) {
			javaT.lang.Double.ParseDouble.fail(val, n);
		}
		if (isNegativeN != isNegative) {
			javaT.lang.Double.ParseDouble.fail(val, n);
		}
		if (s.equals("infinity")) {
			if (na != java.lang.Double.POSITIVE_INFINITY) {
				javaT.lang.Double.ParseDouble.fail(val, n);
			}
			return;
		}
		java.math.BigDecimal bd;
		if (s.startsWith("0x")) {
			s = s.substring(2);
			int indP = s.indexOf('p');
			long exp = java.lang.Long.parseLong(s.substring(indP + 1));
			int indD = s.indexOf('.');
			java.lang.String significand;
			if (indD >= 0) {
				significand = s.substring(0, indD) + s.substring(indD + 1, indP);
				exp -= 4 * ((indP - indD) - 1);
			} else {
				significand = s.substring(0, indP);
			}
			bd = new java.math.BigDecimal(new java.math.BigInteger(significand, 16));
			if (exp >= 0) {
				bd = bd.multiply(java.math.BigDecimal.valueOf(2).pow(((int) (exp))));
			} else {
				bd = bd.divide(java.math.BigDecimal.valueOf(2).pow(((int) (-exp))));
			}
		} else {
			bd = new java.math.BigDecimal(s);
		}
		java.math.BigDecimal l;
		java.math.BigDecimal u;
		if (java.lang.Double.isInfinite(na)) {
			l = new java.math.BigDecimal(java.lang.Double.MAX_VALUE).add(new java.math.BigDecimal(java.lang.Math.ulp(java.lang.Double.MAX_VALUE)).multiply(javaT.lang.Double.ParseDouble.HALF));
			u = null;
		} else {
			l = new java.math.BigDecimal(na).subtract(new java.math.BigDecimal(java.lang.Math.ulp(java.lang.Math.nextUp(-na))).multiply(javaT.lang.Double.ParseDouble.HALF));
			u = new java.math.BigDecimal(na).add(new java.math.BigDecimal(java.lang.Math.ulp(n)).multiply(javaT.lang.Double.ParseDouble.HALF));
		}
		int cmpL = bd.compareTo(l);
		int cmpU = (u != null) ? bd.compareTo(u) : -1;
		if ((java.lang.Double.doubleToLongBits(n) & 1) != 0) {
			if ((cmpL <= 0) || (cmpU >= 0)) {
				javaT.lang.Double.ParseDouble.fail(val, n);
			}
		} else if ((cmpL < 0) || (cmpU > 0)) {
			javaT.lang.Double.ParseDouble.fail(val, n);
		}
	}

	private static void check(java.lang.String val, double expected) {
		double n = java.lang.Double.parseDouble(val);
		if (n != expected) {
			javaT.lang.Double.ParseDouble.fail(val, n);
		}
		javaT.lang.Double.ParseDouble.check(val);
	}

	private static void rudimentaryTest() {
		javaT.lang.Double.ParseDouble.check(new java.lang.String("" + java.lang.Double.MIN_VALUE), java.lang.Double.MIN_VALUE);
		javaT.lang.Double.ParseDouble.check(new java.lang.String("" + java.lang.Double.MAX_VALUE), java.lang.Double.MAX_VALUE);
		javaT.lang.Double.ParseDouble.check("10", ((double) (10.0)));
		javaT.lang.Double.ParseDouble.check("10.0", ((double) (10.0)));
		javaT.lang.Double.ParseDouble.check("10.01", ((double) (10.01)));
		javaT.lang.Double.ParseDouble.check("-10", ((double) (-10.0)));
		javaT.lang.Double.ParseDouble.check("-10.00", ((double) (-10.0)));
		javaT.lang.Double.ParseDouble.check("-10.01", ((double) (-10.01)));
	}

	static java.lang.String[] badStrings = new java.lang.String[]{ "", "+", "-", "+e", "-e", "+e170", "-e170", "1234   e10", "-1234   e10", "1\u0007e1", "1e\u00071", "NaNf", "NaNF", "NaNd", "NaND", "-NaNf", "-NaNF", "-NaNd", "-NaND", "+NaNf", "+NaNF", "+NaNd", "+NaND", "Infinityf", "InfinityF", "Infinityd", "InfinityD", "-Infinityf", "-InfinityF", "-Infinityd", "-InfinityD", "+Infinityf", "+InfinityF", "+Infinityd", "+InfinityD", "NaNe10", "-NaNe10", "+NaNe10", "Infinitye10", "-Infinitye10", "+Infinitye10", "١e١", "۱e۱", "१e१", ".", "e42", ".e42", "d", ".d", "e42d", ".e42d", "1A01.01125e-10d", "2;3.01125e-10d", "1_34.01125e-10d", "202..01125e-10d", "202,01125e-10d", "202.03b4e-10d", "202.06_3e-10d", "202.01125e-f0d", "202.01125e_3d", "202.01125e -5d", "202.01125e-10r", "202.01125e-10ff", "1234L.01", "12ee-2", "12e-2.2.2", "12.01e+", "12.01E", "00x1.0p1", "1.0p1", "00010p1", "deadbeefp1", "0x1.0p", "0x1.0", "0x1.0pa", "0x1.0pf", "0x1.0e22", "0x1.0e22", "0xp22" };

	static java.lang.String[] goodStrings = new java.lang.String[]{ "NaN", "+NaN", "-NaN", "Infinity", "+Infinity", "-Infinity", "1.1e-23f", ".1e-23f", "1e-23", "1f", "0", "-0", "+0", "00", "00", "-00", "+00", "0000000000", "-0000000000", "+0000000000", "1", "2", "1234", "-1234", "+1234", "2147483647", "2147483648", "-2147483648", "-2147483649", "16777215", "16777216", "16777217", "-16777215", "-16777216", "-16777217", "9007199254740991", "9007199254740992", "9007199254740993", "-9007199254740991", "-9007199254740992", "-9007199254740993", "9223372036854775807", "9223372036854775808", "9223372036854775809", "-9223372036854775808", "-9223372036854775809", "-9223372036854775810", "54.07140d", "7.01e-324d", "2147483647.01d", "1.2147483647f", "000000000000000000000000001.F", "1.00000000000000000000000000e-2F", "2.", ".0909", "122112217090.0", "7090e-5", "2.E-20", ".0909e42", "122112217090.0E+100", "7090f", "2.F", ".0909d", "122112217090.0D", "7090e-5f", "2.E-20F", ".0909e42d", "122112217090.0E+100D", "5149236780.1102E-209D", "1290873.12301e100", "1.1E-10f", "0.0E-10", "1E10", "0.f", "1f", "0.F", "1F", "0.12d", "1e-0d", "12.e+1D", "0e-0D", "12.e+01", "1e-01", "0x1p1", "0X1p1", "0x1P1", "0X1P1", "0x1p1f", "0X1p1f", "0x1P1f", "0X1P1f", "0x1p1F", "0X1p1F", "0x1P1F", "0X1P1F", "0x1p1d", "0X1p1d", "0x1P1d", "0X1P1d", "0x1p1D", "0X1p1D", "0x1P1D", "0X1P1D", "-0x1p1", "-0X1p1", "-0x1P1", "-0X1P1", "-0x1p1f", "-0X1p1f", "-0x1P1f", "-0X1P1f", "-0x1p1F", "-0X1p1F", "-0x1P1F", "-0X1P1F", "-0x1p1d", "-0X1p1d", "-0x1P1d", "-0X1P1d", "-0x1p1D", "-0X1p1D", "-0x1P1D", "-0X1P1D", "0x1p-1", "0X1p-1", "0x1P-1", "0X1P-1", "0x1p-1f", "0X1p-1f", "0x1P-1f", "0X1P-1f", "0x1p-1F", "0X1p-1F", "0x1P-1F", "0X1P-1F", "0x1p-1d", "0X1p-1d", "0x1P-1d", "0X1P-1d", "0x1p-1D", "0X1p-1D", "0x1P-1D", "0X1P-1D", "-0x1p-1", "-0X1p-1", "-0x1P-1", "-0X1P-1", "-0x1p-1f", "-0X1p-1f", "-0x1P-1f", "-0X1P-1f", "-0x1p-1F", "-0X1p-1F", "-0x1P-1F", "-0X1P-1F", "-0x1p-1d", "-0X1p-1d", "-0x1P-1d", "-0X1P-1d", "-0x1p-1D", "-0X1p-1D", "-0x1P-1D", "-0X1P-1D", "0xap1", "0xbp1", "0xcp1", "0xdp1", "0xep1", "0xfp1", "0x1p1", "0x.1p1", "0x1.1p1", "0x001p23", "0x00.1p1", "0x001.1p1", "0x100p1", "0x.100p1", "0x1.100p1", "0x00100p1", "0x00.100p1", "0x001.100p1", "1.7976931348623157E308", "4.9e-324", "2.2250738585072014e-308", "2.2250738585072012e-308" };

	static java.lang.String[] paddedBadStrings;

	static java.lang.String[] paddedGoodStrings;

	static {
		java.lang.String pad = " \t\n\r\f\u0001\u000b\u001f";
		paddedBadStrings = new java.lang.String[javaT.lang.Double.ParseDouble.badStrings.length];
		for (int i = 0; i < javaT.lang.Double.ParseDouble.badStrings.length; i++) {
			paddedBadStrings[i] = (pad + badStrings[i]) + pad;
		}
		paddedGoodStrings = new java.lang.String[javaT.lang.Double.ParseDouble.goodStrings.length];
		for (int i = 0; i < javaT.lang.Double.ParseDouble.goodStrings.length; i++) {
			paddedGoodStrings[i] = (pad + goodStrings[i]) + pad;
		}
	}

	private static void testParsing(java.lang.String[] input, boolean exceptionalInput) {
		for (int i = 0; i < input.length; i++) {
			double d;
			try {
				d = java.lang.Double.parseDouble(input[i]);
				javaT.lang.Double.ParseDouble.check(input[i]);
			} catch (java.lang.NumberFormatException e) {
				if (!exceptionalInput) {
					throw new java.lang.RuntimeException((("Double.parseDouble rejected " + "good string `") + input[i]) + "'.");
				}
				break;
			}
			if (exceptionalInput) {
				throw new java.lang.RuntimeException((("Double.parseDouble accepted " + "bad string `") + input[i]) + "'.");
			}
		}
	}

	private static void testRegex(java.lang.String[] input, boolean exceptionalInput) {
		final java.lang.String Digits = "(\\p{Digit}+)";
		final java.lang.String HexDigits = "(\\p{XDigit}+)";
		final java.lang.String Exp = "[eE][+-]?" + Digits;
		final java.lang.String fpRegex = ((((((((((((((((((((((((("[\\x00-\\x20]*" + ((("[+-]?(" + "NaN|") + "Infinity|") + "((((")) + Digits) + "(\\.)?(") + Digits) + "?)(") + Exp) + ")?)|") + "(\\.(") + Digits) + ")(") + Exp) + ")?))|") + "((") + "(0[xX]") + HexDigits) + "(\\.)?)|") + "(0[xX]") + HexDigits) + "?(\\.)") + HexDigits) + ")") + ")[pP][+-]?") + Digits) + "))") + "[fFdD]?))") + "[\\x00-\\x20]*";
		java.util.regex.Pattern fpPattern = java.util.regex.Pattern.compile(fpRegex);
		for (int i = 0; i < input.length; i++) {
			java.util.regex.Matcher m = fpPattern.matcher(input[i]);
			if (m.matches() != (!exceptionalInput)) {
				throw new java.lang.RuntimeException(((("Regular expression " + (exceptionalInput ? "accepted bad" : "rejected good")) + " string `") + input[i]) + "'.");
			}
		}
	}

	private static void testSubnormalPowers() {
		boolean failed = false;
		java.math.BigDecimal TWO = java.math.BigDecimal.valueOf(2);
		java.math.BigDecimal ulp_BD = new java.math.BigDecimal(java.lang.Double.MIN_VALUE);
		for (int i = -1073; i <= (-1022); i++) {
			double d = java.lang.Math.scalb(1.0, i);
			java.math.BigDecimal d_BD = new java.math.BigDecimal(d);
			java.math.BigDecimal lowerBound = d_BD.subtract(ulp_BD.divide(TWO));
			java.math.BigDecimal upperBound = d_BD.add(ulp_BD.divide(TWO));
			double convertedLowerBound = java.lang.Double.parseDouble(lowerBound.toString());
			double convertedUpperBound = java.lang.Double.parseDouble(upperBound.toString());
			if (convertedLowerBound != d) {
				failed = true;
				java.lang.System.out.printf("2^%d lowerBound converts as %a %s%n", i, convertedLowerBound, lowerBound);
			}
			if (convertedUpperBound != d) {
				failed = true;
				java.lang.System.out.printf("2^%d upperBound converts as %a %s%n", i, convertedUpperBound, upperBound);
			}
		}
		java.math.BigDecimal minValue = new java.math.BigDecimal(java.lang.Double.MIN_VALUE);
		if (java.lang.Double.parseDouble(minValue.multiply(new java.math.BigDecimal(0.5)).toString()) != 0.0) {
			failed = true;
			java.lang.System.out.printf("0.5*MIN_VALUE doesn't convert 0%n");
		}
		if (java.lang.Double.parseDouble(minValue.multiply(new java.math.BigDecimal(0.50000000001)).toString()) != java.lang.Double.MIN_VALUE) {
			failed = true;
			java.lang.System.out.printf("0.50000000001*MIN_VALUE doesn't convert to MIN_VALUE%n");
		}
		if (java.lang.Double.parseDouble(minValue.multiply(new java.math.BigDecimal(1.49999999999)).toString()) != java.lang.Double.MIN_VALUE) {
			failed = true;
			java.lang.System.out.printf("1.49999999999*MIN_VALUE doesn't convert to MIN_VALUE%n");
		}
		if (java.lang.Double.parseDouble(minValue.multiply(new java.math.BigDecimal(1.5)).toString()) != (2 * java.lang.Double.MIN_VALUE)) {
			failed = true;
			java.lang.System.out.printf("1.5*MIN_VALUE doesn't convert to 2*MIN_VALUE%n");
		}
		if (failed) {
			throw new java.lang.RuntimeException("Inconsistent conversion");
		}
	}

	private static void testPowers() {
		for (int i = -1074; i <= (+1023); i++) {
			double d = java.lang.Math.scalb(1.0, i);
			java.math.BigDecimal d_BD = new java.math.BigDecimal(d);
			java.math.BigDecimal lowerBound = d_BD.subtract(new java.math.BigDecimal(java.lang.Math.ulp(java.lang.Math.nextUp(-d))).multiply(javaT.lang.Double.ParseDouble.HALF));
			java.math.BigDecimal upperBound = d_BD.add(new java.math.BigDecimal(java.lang.Math.ulp(d)).multiply(javaT.lang.Double.ParseDouble.HALF));
			javaT.lang.Double.ParseDouble.check(lowerBound.toString());
			javaT.lang.Double.ParseDouble.check(upperBound.toString());
		}
		javaT.lang.Double.ParseDouble.check(new java.math.BigDecimal(java.lang.Double.MAX_VALUE).add(new java.math.BigDecimal(java.lang.Math.ulp(java.lang.Double.MAX_VALUE)).multiply(javaT.lang.Double.ParseDouble.HALF)).toString());
	}

	private static void testStrictness() {
		final double expected = 0x0.0000008p-1022;
		boolean failed = false;
		double conversion = 0.0;
		double sum = 0.0;
		java.lang.String decimal = "6.631236871469758276785396630275967243399099947355303144249971758736286630139265439618068200788048744105960420552601852889715006376325666595539603330361800519107591783233358492337208057849499360899425128640718856616503093444922854759159988160304439909868291973931426625698663157749836252274523485312442358651207051292453083278116143932569727918709786004497872322193856150225415211997283078496319412124640111777216148110752815101775295719811974338451936095907419622417538473679495148632480391435931767981122396703443803335529756003353209830071832230689201383015598792184172909927924176339315507402234836120730914783168400715462440053817592702766213559042115986763819482654128770595766806872783349146967171293949598850675682115696218943412532098591327667236328125E-316";
		for (int i = 0; i <= 12000; i++) {
			conversion = java.lang.Double.parseDouble(decimal);
			sum += conversion;
			if (conversion != expected) {
				failed = true;
				java.lang.System.out.printf("Iteration %d converts as %a%n", i, conversion);
			}
		}
		java.lang.System.out.println("Sum = " + sum);
		if (failed) {
			throw new java.lang.RuntimeException("Inconsistent conversion");
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.Double.ParseDouble.rudimentaryTest();
		javaT.lang.Double.ParseDouble.testParsing(javaT.lang.Double.ParseDouble.goodStrings, false);
		javaT.lang.Double.ParseDouble.testParsing(javaT.lang.Double.ParseDouble.paddedGoodStrings, false);
		javaT.lang.Double.ParseDouble.testParsing(javaT.lang.Double.ParseDouble.badStrings, true);
		javaT.lang.Double.ParseDouble.testParsing(javaT.lang.Double.ParseDouble.paddedBadStrings, true);
		javaT.lang.Double.ParseDouble.testRegex(javaT.lang.Double.ParseDouble.goodStrings, false);
		javaT.lang.Double.ParseDouble.testRegex(javaT.lang.Double.ParseDouble.paddedGoodStrings, false);
		javaT.lang.Double.ParseDouble.testRegex(javaT.lang.Double.ParseDouble.badStrings, true);
		javaT.lang.Double.ParseDouble.testRegex(javaT.lang.Double.ParseDouble.paddedBadStrings, true);
		javaT.lang.Double.ParseDouble.testSubnormalPowers();
		javaT.lang.Double.ParseDouble.testPowers();
		javaT.lang.Double.ParseDouble.testStrictness();
	}
}