public class IntegralDivisionTests {
	static int dividetoIntegralValueTests() {
		int failures = 0;
		java.math.BigDecimal[][] moreTestCases = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal("11003"), new java.math.BigDecimal("10"), new java.math.BigDecimal("1100") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("11003"), new java.math.BigDecimal("1e1"), new java.math.BigDecimal("1100.0") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("1e9"), new java.math.BigDecimal("1"), new java.math.BigDecimal("1e9") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("1e9"), new java.math.BigDecimal("1.00"), new java.math.BigDecimal("1e9") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("1e9"), new java.math.BigDecimal("0.1"), new java.math.BigDecimal("1e10") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("10e8"), new java.math.BigDecimal("0.1"), new java.math.BigDecimal("10e9") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("400e1"), new java.math.BigDecimal("5"), new java.math.BigDecimal("80e1") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("400e1"), new java.math.BigDecimal("4.999999999"), new java.math.BigDecimal("8e2") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("40e2"), new java.math.BigDecimal("5"), new java.math.BigDecimal("8e2") }, new java.math.BigDecimal[]{ java.math.BigDecimal.valueOf(1, java.lang.Integer.MIN_VALUE), java.math.BigDecimal.valueOf(1, -(java.lang.Integer.MAX_VALUE & 0x7fffff00)), java.math.BigDecimal.valueOf(1, -256) } };
		for (java.math.BigDecimal[] testCase : moreTestCases) {
			java.math.BigDecimal quotient;
			if (!(quotient = testCase[0].divideToIntegralValue(testCase[1])).equals(testCase[2])) {
				failures++;
				java.lang.System.err.println();
				java.lang.System.err.println((("dividend  = " + testCase[0]) + " scale = ") + testCase[0].scale());
				java.lang.System.err.println((("divisor   = " + testCase[1]) + " scale = ") + testCase[1].scale());
				java.lang.System.err.println((("quotient  = " + quotient) + " scale = ") + quotient.scale());
				java.lang.System.err.println((("expected  = " + testCase[2]) + " scale = ") + testCase[2].scale());
			}
		}
		return failures;
	}

	static int dividetoIntegralValueRoundedTests() {
		int failures = 0;
		java.math.BigDecimal dividend = new java.math.BigDecimal("11003");
		java.math.BigDecimal divisor = new java.math.BigDecimal("10");
		java.math.BigDecimal[] quotients = new java.math.BigDecimal[]{ new java.math.BigDecimal("1100"), null, new java.math.BigDecimal("11e2"), new java.math.BigDecimal("110e1"), new java.math.BigDecimal("1100") };
		failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTestPrecs(dividend, divisor, quotients);
		dividend = new java.math.BigDecimal("11003");
		divisor = new java.math.BigDecimal("1e1");
		java.math.BigDecimal[] quotients2 = new java.math.BigDecimal[]{ new java.math.BigDecimal("1100.0"), null, new java.math.BigDecimal("11e2"), new java.math.BigDecimal("110e1"), new java.math.BigDecimal("1100"), new java.math.BigDecimal("1100.0") };
		failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTestPrecs(dividend, divisor, quotients2);
		dividend = new java.math.BigDecimal("1230000");
		divisor = new java.math.BigDecimal("100");
		java.math.BigDecimal[] quotients3 = new java.math.BigDecimal[]{ new java.math.BigDecimal("12300"), null, null, new java.math.BigDecimal("123e2"), new java.math.BigDecimal("1230e1"), new java.math.BigDecimal("12300") };
		failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTestPrecs(dividend, divisor, quotients3);
		dividend = new java.math.BigDecimal("33");
		divisor = new java.math.BigDecimal("3");
		java.math.BigDecimal[] quotients4 = new java.math.BigDecimal[]{ new java.math.BigDecimal("11"), null, new java.math.BigDecimal("11"), new java.math.BigDecimal("11") };
		failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTestPrecs(dividend, divisor, quotients4);
		dividend = new java.math.BigDecimal("34");
		divisor = new java.math.BigDecimal("3");
		java.math.BigDecimal[] quotients5 = new java.math.BigDecimal[]{ new java.math.BigDecimal("11"), null, new java.math.BigDecimal("11"), new java.math.BigDecimal("11") };
		failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTestPrecs(dividend, divisor, quotients5);
		return failures;
	}

	static int divideContextTestPrecs(java.math.BigDecimal dividend, java.math.BigDecimal divisor, java.math.BigDecimal[] quotients) {
		int failures = 0;
		for (int i = 0; i < quotients.length; i++) {
			java.math.BigDecimal result = null;
			java.math.BigDecimal quotient = quotients[i];
			try {
				result = dividend.divideToIntegralValue(divisor, new java.math.MathContext(i, java.math.RoundingMode.DOWN));
			} catch (java.lang.ArithmeticException e) {
				if (quotient != null) {
					failures++;
					java.lang.System.err.println();
					java.lang.System.err.println("Unexpected exception:");
					java.lang.System.err.println((("dividend  = " + dividend) + " scale = ") + dividend.scale());
					java.lang.System.err.println((("divisor   = " + divisor) + " scale = ") + divisor.scale());
					java.lang.System.err.println((("expected  = " + quotient) + " scale = ") + quotient.scale());
				}
			}
			if (quotient != null) {
				if (!result.equals(quotient)) {
					failures++;
					java.lang.System.err.println();
					java.lang.System.err.println("Unexpected result:");
					java.lang.System.err.println((("dividend  = " + dividend) + " scale = ") + dividend.scale());
					java.lang.System.err.println((("divisor   = " + divisor) + " scale = ") + divisor.scale());
					java.lang.System.err.println((("quotient  = " + result) + " scale = ") + result.scale());
					java.lang.System.err.println((("expected  = " + quotient) + " scale = ") + quotient.scale());
					java.lang.System.err.println("precision = " + i);
				}
			} else if (result != null) {
				failures++;
				java.lang.System.err.println();
				java.lang.System.err.println("Unexpected unexceptional result:");
				java.lang.System.err.println((("dividend  = " + dividend) + " scale = ") + dividend.scale());
				java.lang.System.err.println((("divisor   = " + divisor) + " scale = ") + divisor.scale());
				java.lang.System.err.println((("quotient  = " + result) + " scale = ") + result.scale());
				java.lang.System.err.println("precision = " + i);
			}
		}
		return failures;
	}

	static int divideContextTests(java.math.BigDecimal dividend, java.math.BigDecimal divisor, java.math.BigDecimal expected, java.math.MathContext mc) {
		int failures = 0;
		failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTest(dividend, divisor, expected, mc);
		failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTest(dividend.negate(), divisor.negate(), expected, mc);
		if (expected != null) {
			failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTest(dividend.negate(), divisor, expected.negate(), mc);
			failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTest(dividend, divisor.negate(), expected.negate(), mc);
		}
		return failures;
	}

	static int divideContextTest(java.math.BigDecimal dividend, java.math.BigDecimal divisor, java.math.BigDecimal expected, java.math.MathContext mc) {
		int failures = 0;
		java.math.BigDecimal result = null;
		try {
			result = dividend.divideToIntegralValue(divisor, mc);
		} catch (java.lang.ArithmeticException e) {
			if (expected != null) {
				failures++;
				java.lang.System.err.println();
				java.lang.System.err.println("Unexpected exception:");
				java.lang.System.err.println((("dividend  = " + dividend) + " scale = ") + dividend.scale());
				java.lang.System.err.println((("divisor   = " + divisor) + " scale = ") + divisor.scale());
				java.lang.System.err.println((("expected  = " + expected) + " scale = ") + expected.scale());
				java.lang.System.err.println("MathContext  = " + mc);
			}
		}
		if (expected != null) {
			if (!result.equals(expected)) {
				failures++;
				java.lang.System.err.println();
				java.lang.System.err.println("Unexpected result:");
				java.lang.System.err.println((("dividend  = " + dividend) + " scale = ") + dividend.scale());
				java.lang.System.err.println((("divisor   = " + divisor) + " scale = ") + divisor.scale());
				java.lang.System.err.println((("expected  = " + expected) + " scale = ") + expected.scale());
				java.lang.System.err.println((("result    = " + result) + " scale = ") + result.scale());
				java.lang.System.err.println("MathContext  = " + mc);
			}
		} else if (result != null) {
			failures++;
			java.lang.System.err.println();
			java.lang.System.err.println("Unexpected unexceptional result:");
			java.lang.System.err.println((("dividend  = " + dividend) + " scale = ") + dividend.scale());
			java.lang.System.err.println((("divisor   = " + divisor) + " scale = ") + divisor.scale());
			java.lang.System.err.println((("quotient  = " + result) + " scale = ") + result.scale());
			java.lang.System.err.println("MathConext = " + mc);
		}
		return failures;
	}

	static int dividetoIntegralValueScalingTests() {
		int failures = 0;
		java.math.BigDecimal dividend = new java.math.BigDecimal("123456789000");
		java.math.BigDecimal divisor = java.math.BigDecimal.ONE;
		java.math.BigDecimal expected = new java.math.BigDecimal("123456789e3");
		java.math.MathContext mc = new java.math.MathContext(9, java.math.RoundingMode.DOWN);
		failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTests(dividend, divisor, expected, mc);
		int[] precisions = new int[]{ 0, 2, 3, 4 };
		dividend = new java.math.BigDecimal(100);
		divisor = new java.math.BigDecimal(3);
		expected = new java.math.BigDecimal(33);
		for (java.math.RoundingMode rm : java.math.RoundingMode.values()) {
			for (int precision : precisions) {
				failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTests(dividend, divisor, expected, new java.math.MathContext(precision, rm));
			}
		}
		dividend = new java.math.BigDecimal(123000);
		divisor = new java.math.BigDecimal(10);
		int[] precisions1 = new int[]{ 0, 1, 2, 3, 4, 5 };
		java.math.BigDecimal[] expected1 = new java.math.BigDecimal[]{ new java.math.BigDecimal("12300"), null, null, new java.math.BigDecimal("123e2"), new java.math.BigDecimal("1230e1"), new java.math.BigDecimal("12300") };
		for (java.math.RoundingMode rm : java.math.RoundingMode.values()) {
			for (int i = 0; i < precisions1.length; i++) {
				failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTests(dividend, divisor, expected1[i], new java.math.MathContext(precisions1[i], rm));
			}
		}
		dividend = new java.math.BigDecimal("123e3");
		divisor = new java.math.BigDecimal(10);
		int[] precisions2 = new int[]{ 0, 1, 2, 3, 4, 5 };
		java.math.BigDecimal[] expected2 = new java.math.BigDecimal[]{ new java.math.BigDecimal("123e2"), null, null, new java.math.BigDecimal("123e2"), new java.math.BigDecimal("123e2"), new java.math.BigDecimal("123e2") };
		for (java.math.RoundingMode rm : java.math.RoundingMode.values()) {
			for (int i = 0; i < precisions2.length; i++) {
				failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTests(dividend, divisor, expected2[i], new java.math.MathContext(precisions2[i], rm));
			}
		}
		dividend = new java.math.BigDecimal("123000");
		divisor = new java.math.BigDecimal("1e1");
		int[] precisions3 = new int[]{ 0, 1, 2, 3, 4, 5, 6 };
		java.math.BigDecimal[] expected3 = new java.math.BigDecimal[]{ new java.math.BigDecimal("12300.0"), null, null, new java.math.BigDecimal("123e2"), new java.math.BigDecimal("1230e1"), new java.math.BigDecimal("12300"), new java.math.BigDecimal("12300.0") };
		for (java.math.RoundingMode rm : java.math.RoundingMode.values()) {
			for (int i = 0; i < precisions3.length; i++) {
				failures += javaT.math.BigDecimal.IntegralDivisionTests.divideContextTests(dividend, divisor, expected3[i], new java.math.MathContext(precisions3[i], rm));
			}
		}
		return failures;
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		failures += javaT.math.BigDecimal.IntegralDivisionTests.dividetoIntegralValueTests();
		failures += javaT.math.BigDecimal.IntegralDivisionTests.dividetoIntegralValueRoundedTests();
		failures += javaT.math.BigDecimal.IntegralDivisionTests.dividetoIntegralValueScalingTests();
		if (failures > 0) {
			java.lang.System.err.println(("Encountered " + failures) + " failures while testing integral division.");
			throw new java.lang.RuntimeException();
		}
	}
}