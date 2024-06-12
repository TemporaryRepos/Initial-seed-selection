public class NegateTests {
	static java.math.BigDecimal negateThenRound(java.math.BigDecimal bd, java.math.MathContext mc) {
		return bd.negate().plus(mc);
	}

	static java.math.BigDecimal absThenRound(java.math.BigDecimal bd, java.math.MathContext mc) {
		return bd.abs().plus(mc);
	}

	static int negateTest(java.math.BigDecimal[][] testCases, java.math.MathContext mc) {
		int failures = 0;
		for (java.math.BigDecimal[] testCase : testCases) {
			java.math.BigDecimal bd = testCase[0];
			java.math.BigDecimal neg1 = bd.negate(mc);
			java.math.BigDecimal neg2 = javaT.math.BigDecimal.NegateTests.negateThenRound(bd, mc);
			java.math.BigDecimal expected = testCase[1];
			if (!neg1.equals(expected)) {
				failures++;
				java.lang.System.err.println((((((("(" + bd) + ").negate(") + mc) + ") => ") + neg1) + " != expected ") + expected);
			}
			if (!neg1.equals(neg2)) {
				failures++;
				java.lang.System.err.println((((((("(" + bd) + ").negate(") + mc) + ")  => ") + neg1) + " != ntr ") + neg2);
			}
			java.math.BigDecimal abs = bd.abs(mc);
			java.math.BigDecimal expectedAbs = javaT.math.BigDecimal.NegateTests.absThenRound(bd, mc);
			if (!abs.equals(expectedAbs)) {
				failures++;
				java.lang.System.err.println((((((("(" + bd) + ").abs(") + mc) + ")  => ") + abs) + " != atr ") + expectedAbs);
			}
		}
		return failures;
	}

	static int negateTests() {
		int failures = 0;
		java.math.BigDecimal[][] testCasesCeiling = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal("1.3"), new java.math.BigDecimal("-1") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("-1.3"), new java.math.BigDecimal("2") } };
		failures += javaT.math.BigDecimal.NegateTests.negateTest(testCasesCeiling, new java.math.MathContext(1, java.math.RoundingMode.CEILING));
		java.math.BigDecimal[][] testCasesFloor = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal("1.3"), new java.math.BigDecimal("-2") }, new java.math.BigDecimal[]{ new java.math.BigDecimal("-1.3"), new java.math.BigDecimal("1") } };
		failures += javaT.math.BigDecimal.NegateTests.negateTest(testCasesFloor, new java.math.MathContext(1, java.math.RoundingMode.FLOOR));
		return failures;
	}

	public static void main(java.lang.String[] argv) {
		int failures = 0;
		failures += javaT.math.BigDecimal.NegateTests.negateTests();
		if (failures > 0) {
			throw new java.lang.RuntimeException((("Incurred " + failures) + " failures") + " testing the negate and/or abs.");
		}
	}
}