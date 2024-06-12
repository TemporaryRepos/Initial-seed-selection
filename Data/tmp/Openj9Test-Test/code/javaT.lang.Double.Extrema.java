public class Extrema {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (java.lang.Double.MIN_VALUE != java.lang.Double.longBitsToDouble(0x1L)) {
			throw new java.lang.RuntimeException("Double.MIN_VALUE is not equal " + "to longBitsToDouble(0x1L).");
		}
		if (java.lang.Double.MIN_NORMAL != java.lang.Double.longBitsToDouble(0x10000000000000L)) {
			throw new java.lang.RuntimeException("Double.MIN_NORMAL is not equal " + "to longBitsToDouble(0x0010000000000000L).");
		}
		if (java.lang.Double.MAX_VALUE != java.lang.Double.longBitsToDouble(0x7fefffffffffffffL)) {
			throw new java.lang.RuntimeException("Double.MAX_VALUE is not equal " + "to longBitsToDouble(0x7fefffffffffffffL).");
		}
	}
}