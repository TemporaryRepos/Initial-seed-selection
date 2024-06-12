public class Extrema {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (java.lang.Float.MIN_VALUE != java.lang.Float.intBitsToFloat(0x1)) {
			throw new java.lang.RuntimeException("Float.MIN_VALUE is not equal " + "to intBitsToFloat(0x1).");
		}
		if (java.lang.Float.MIN_NORMAL != java.lang.Float.intBitsToFloat(0x800000)) {
			throw new java.lang.RuntimeException("Float.MIN_NORMAL is not equal " + "to intBitsToFloat(0x00800000).");
		}
		if (java.lang.Float.MAX_VALUE != java.lang.Float.intBitsToFloat(0x7f7fffff)) {
			throw new java.lang.RuntimeException("Float.MAX_VALUE is not equal " + "to intBitsToFloat(0x7f7fffff).");
		}
	}
}