public class ArrayLength {
	public static void main(java.lang.String[] args) {
		int failed = 0;
		try {
			new java.lang.String[0].getClass().getField("length");
			failed++;
			java.lang.System.out.println("getField(\"length\") should throw NoSuchFieldException");
		} catch (java.lang.NoSuchFieldException e) {
		}
		try {
			new java.lang.String[0].getClass().getDeclaredField("length");
			failed++;
			java.lang.System.out.println("getDeclaredField(\"length\") should throw NoSuchFieldException");
		} catch (java.lang.NoSuchFieldException e) {
		}
		if (new java.lang.String[0].getClass().getFields().length != 0) {
			failed++;
			java.lang.System.out.println("getFields() for an array type should return a zero length array");
		}
		if (new java.lang.String[0].getClass().getDeclaredFields().length != 0) {
			failed++;
			java.lang.System.out.println("getDeclaredFields() for an array type should return a zero length array");
		}
		if (failed != 0) {
			throw new java.lang.RuntimeException("Test failed see log for details");
		}
	}
}