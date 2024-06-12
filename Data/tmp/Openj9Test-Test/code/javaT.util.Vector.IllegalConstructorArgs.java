public class IllegalConstructorArgs {
	public static void main(java.lang.String[] argv) {
		int testSucceeded = 0;
		try {
			java.util.Vector bad1 = new java.util.Vector(-100, 10);
		} catch (java.lang.IllegalArgumentException e1) {
			testSucceeded = 1;
		} catch (java.lang.NegativeArraySizeException e2) {
			testSucceeded = 0;
		}
		if (testSucceeded == 0) {
			throw new java.lang.RuntimeException("Wrong exception thrown.");
		}
	}
}