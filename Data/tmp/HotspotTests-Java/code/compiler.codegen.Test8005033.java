public class Test8005033 {
	public static int MINUS_ONE = -1;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("EXECUTING test.");
		java.lang.Integer.bitCount(1);
		int expectedBitCount = 0;
		int calculatedBitCount = compiler.codegen.Test8005033.testBitCount();
		if (expectedBitCount != calculatedBitCount) {
			throw new java.lang.InternalError((("got " + calculatedBitCount) + " but expected ") + expectedBitCount);
		}
		java.lang.System.out.println("SUCCESSFULLY passed test.");
	}

	private static int testBitCount() {
		return java.lang.Integer.bitCount(compiler.codegen.Test8005033.MINUS_ONE + 1);
	}
}