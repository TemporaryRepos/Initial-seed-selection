public class RoundingModeTests {
	public static void main(java.lang.String[] argv) {
		for (java.math.RoundingMode rm : java.math.RoundingMode.values()) {
			if (rm != java.math.RoundingMode.valueOf(rm.toString())) {
				throw new java.lang.RuntimeException("Bad roundtrip conversion of " + rm.toString());
			}
		}
		if (java.math.RoundingMode.valueOf(java.math.BigDecimal.ROUND_CEILING) != java.math.RoundingMode.CEILING) {
			throw new java.lang.RuntimeException("Bad mapping for ROUND_CEILING");
		}
		if (java.math.RoundingMode.valueOf(java.math.BigDecimal.ROUND_DOWN) != java.math.RoundingMode.DOWN) {
			throw new java.lang.RuntimeException("Bad mapping for ROUND_DOWN");
		}
		if (java.math.RoundingMode.valueOf(java.math.BigDecimal.ROUND_FLOOR) != java.math.RoundingMode.FLOOR) {
			throw new java.lang.RuntimeException("Bad mapping for ROUND_FLOOR");
		}
		if (java.math.RoundingMode.valueOf(java.math.BigDecimal.ROUND_HALF_DOWN) != java.math.RoundingMode.HALF_DOWN) {
			throw new java.lang.RuntimeException("Bad mapping for ROUND_HALF_DOWN");
		}
		if (java.math.RoundingMode.valueOf(java.math.BigDecimal.ROUND_HALF_EVEN) != java.math.RoundingMode.HALF_EVEN) {
			throw new java.lang.RuntimeException("Bad mapping for ROUND_HALF_EVEN");
		}
		if (java.math.RoundingMode.valueOf(java.math.BigDecimal.ROUND_HALF_UP) != java.math.RoundingMode.HALF_UP) {
			throw new java.lang.RuntimeException("Bad mapping for ROUND_HALF_UP");
		}
		if (java.math.RoundingMode.valueOf(java.math.BigDecimal.ROUND_UNNECESSARY) != java.math.RoundingMode.UNNECESSARY) {
			throw new java.lang.RuntimeException("Bad mapping for ROUND_UNNECESARY");
		}
	}
}