public class ParseFloat {
	private static final java.math.BigDecimal HALF = java.math.BigDecimal.valueOf(0.5);

	private static void fail(java.lang.String val, float n) {
		throw new java.lang.RuntimeException((("Float.parseFloat failed. String:" + val) + " Result:") + n);
	}

	private static void check(java.lang.String val) {
		float n = java.lang.Float.parseFloat(val);
		boolean isNegativeN = (n < 0) || ((n == 0) && ((1 / n) < 0));
		float na = java.lang.Math.abs(n);
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
			if (!java.lang.Float.isNaN(n)) {
				javaT.lang.Float.ParseFloat.fail(val, n);
			}
			return;
		}
		if (java.lang.Float.isNaN(n)) {
			javaT.lang.Float.ParseFloat.fail(val, n);
		}
		if (isNegativeN != isNegative) {
			javaT.lang.Float.ParseFloat.fail(val, n);
		}
		if (s.equals("infinity")) {
			if (na != java.lang.Float.POSITIVE_INFINITY) {
				javaT.lang.Float.ParseFloat.fail(val, n);
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
		if (java.lang.Float.isInfinite(na)) {
			l = new java.math.BigDecimal(java.lang.Float.MAX_VALUE).add(new java.math.BigDecimal(java.lang.Math.ulp(java.lang.Float.MAX_VALUE)).multiply(javaT.lang.Float.ParseFloat.HALF));
			u = null;
		} else {
			l = new java.math.BigDecimal(na).subtract(new java.math.BigDecimal(java.lang.Math.ulp(-java.lang.Math.nextUp(-na))).multiply(javaT.lang.Float.ParseFloat.HALF));
			u = new java.math.BigDecimal(na).add(new java.math.BigDecimal(java.lang.Math.ulp(n)).multiply(javaT.lang.Float.ParseFloat.HALF));
		}
		int cmpL = bd.compareTo(l);
		int cmpU = (u != null) ? bd.compareTo(u) : -1;
		if ((java.lang.Float.floatToIntBits(n) & 1) != 0) {
			if ((cmpL <= 0) || (cmpU >= 0)) {
				javaT.lang.Float.ParseFloat.fail(val, n);
			}
		} else if ((cmpL < 0) || (cmpU > 0)) {
			javaT.lang.Float.ParseFloat.fail(val, n);
		}
	}

	private static void check(java.lang.String val, float expected) {
		float n = java.lang.Float.parseFloat(val);
		if (n != expected) {
			javaT.lang.Float.ParseFloat.fail(val, n);
		}
		javaT.lang.Float.ParseFloat.check(val);
	}

	private static void rudimentaryTest() {
		javaT.lang.Float.ParseFloat.check(new java.lang.String("" + java.lang.Float.MIN_VALUE), java.lang.Float.MIN_VALUE);
		javaT.lang.Float.ParseFloat.check(new java.lang.String("" + java.lang.Float.MAX_VALUE), java.lang.Float.MAX_VALUE);
		javaT.lang.Float.ParseFloat.check("10", ((float) (10.0)));
		javaT.lang.Float.ParseFloat.check("10.0", ((float) (10.0)));
		javaT.lang.Float.ParseFloat.check("10.01", ((float) (10.01)));
		javaT.lang.Float.ParseFloat.check("-10", ((float) (-10.0)));
		javaT.lang.Float.ParseFloat.check("-10.00", ((float) (-10.0)));
		javaT.lang.Float.ParseFloat.check("-10.01", ((float) (-10.01)));
		javaT.lang.Float.ParseFloat.check("144115196665790480", 0x1.000002p57F);
		javaT.lang.Float.ParseFloat.check("144115196665790481", 0x1.000002p57F);
		javaT.lang.Float.ParseFloat.check("0.050000002607703203", 0.05F);
		javaT.lang.Float.ParseFloat.check("0.050000002607703204", 0.05F);
		javaT.lang.Float.ParseFloat.check("0.050000002607703205", 0.05F);
		javaT.lang.Float.ParseFloat.check("0.050000002607703206", 0.05F);
		javaT.lang.Float.ParseFloat.check("0.050000002607703207", 0.05F);
		javaT.lang.Float.ParseFloat.check("0.050000002607703208", 0.05F);
		javaT.lang.Float.ParseFloat.check("0.050000002607703209", 0.050000004F);
	}

	static java.lang.String[] badStrings = new java.lang.String[]{ "", "+", "-", "+e", "-e", "+e170", "-e170", "1234   e10", "-1234   e10", "1\u0007e1", "1e\u00071", "NaNf", "NaNF", "NaNd", "NaND", "-NaNf", "-NaNF", "-NaNd", "-NaND", "+NaNf", "+NaNF", "+NaNd", "+NaND", "Infinityf", "InfinityF", "Infinityd", "InfinityD", "-Infinityf", "-InfinityF", "-Infinityd", "-InfinityD", "+Infinityf", "+InfinityF", "+Infinityd", "+InfinityD", "NaNe10", "-NaNe10", "+NaNe10", "Infinitye10", "-Infinitye10", "+Infinitye10", "١e١", "۱e۱", "१e१" };

	static java.lang.String[] goodStrings = new java.lang.String[]{ "NaN", "+NaN", "-NaN", "Infinity", "+Infinity", "-Infinity", "1.1e-23f", ".1e-23f", "1e-23", "1f", "1", "2", "1234", "-1234", "+1234", "2147483647", "2147483648", "-2147483648", "-2147483649", "16777215", "16777216", "16777217", "-16777215", "-16777216", "-16777217", "9007199254740991", "9007199254740992", "9007199254740993", "-9007199254740991", "-9007199254740992", "-9007199254740993", "9223372036854775807", "9223372036854775808", "9223372036854775809", "-9223372036854775808", "-9223372036854775809", "-9223372036854775810" };

	static java.lang.String[] paddedBadStrings;

	static java.lang.String[] paddedGoodStrings;

	static {
		java.lang.String pad = " \t\n\r\f\u0001\u000b\u001f";
		paddedBadStrings = new java.lang.String[javaT.lang.Float.ParseFloat.badStrings.length];
		for (int i = 0; i < javaT.lang.Float.ParseFloat.badStrings.length; i++) {
			paddedBadStrings[i] = (pad + badStrings[i]) + pad;
		}
		paddedGoodStrings = new java.lang.String[javaT.lang.Float.ParseFloat.goodStrings.length];
		for (int i = 0; i < javaT.lang.Float.ParseFloat.goodStrings.length; i++) {
			paddedGoodStrings[i] = (pad + goodStrings[i]) + pad;
		}
	}

	private static void testParsing(java.lang.String[] input, boolean exceptionalInput) {
		for (int i = 0; i < input.length; i++) {
			double d;
			try {
				d = java.lang.Float.parseFloat(input[i]);
				javaT.lang.Float.ParseFloat.check(input[i]);
			} catch (java.lang.NumberFormatException e) {
				if (!exceptionalInput) {
					throw new java.lang.RuntimeException((("Float.parseFloat rejected " + "good string `") + input[i]) + "'.");
				}
				break;
			}
			if (exceptionalInput) {
				throw new java.lang.RuntimeException((("Float.parseFloat accepted " + "bad string `") + input[i]) + "'.");
			}
		}
	}

	private static void testPowers() {
		for (int i = -149; i <= (+127); i++) {
			float f = java.lang.Math.scalb(1.0F, i);
			java.math.BigDecimal f_BD = new java.math.BigDecimal(f);
			java.math.BigDecimal lowerBound = f_BD.subtract(new java.math.BigDecimal(java.lang.Math.ulp(-java.lang.Math.nextUp(-f))).multiply(javaT.lang.Float.ParseFloat.HALF));
			java.math.BigDecimal upperBound = f_BD.add(new java.math.BigDecimal(java.lang.Math.ulp(f)).multiply(javaT.lang.Float.ParseFloat.HALF));
			javaT.lang.Float.ParseFloat.check(lowerBound.toString());
			javaT.lang.Float.ParseFloat.check(upperBound.toString());
		}
		javaT.lang.Float.ParseFloat.check(new java.math.BigDecimal(java.lang.Float.MAX_VALUE).add(new java.math.BigDecimal(java.lang.Math.ulp(java.lang.Float.MAX_VALUE)).multiply(javaT.lang.Float.ParseFloat.HALF)).toString());
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.Float.ParseFloat.rudimentaryTest();
		javaT.lang.Float.ParseFloat.testParsing(javaT.lang.Float.ParseFloat.goodStrings, false);
		javaT.lang.Float.ParseFloat.testParsing(javaT.lang.Float.ParseFloat.paddedGoodStrings, false);
		javaT.lang.Float.ParseFloat.testParsing(javaT.lang.Float.ParseFloat.badStrings, true);
		javaT.lang.Float.ParseFloat.testParsing(javaT.lang.Float.ParseFloat.paddedBadStrings, true);
		javaT.lang.Float.ParseFloat.testPowers();
	}
}