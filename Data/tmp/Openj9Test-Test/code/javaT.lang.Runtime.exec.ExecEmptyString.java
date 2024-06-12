public class ExecEmptyString {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.lang.Runtime.getRuntime().exec("");
			throw new java.lang.Exception("Expected IllegalArgumentException not thrown");
		} catch (java.lang.IllegalArgumentException e) {
		}
		try {
			java.lang.Runtime.getRuntime().exec(new java.lang.String());
			throw new java.lang.Exception("Expected IllegalArgumentException not thrown");
		} catch (java.lang.IllegalArgumentException e) {
		}
	}
}