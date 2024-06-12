public class InsertMaxValue {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		java.lang.StringBuffer sb = new java.lang.StringBuffer("");
		java.lang.StringBuffer sb1 = new java.lang.StringBuffer("Some test StringBuffer");
		try {
			sb.insert(0, new char[5], 1, java.lang.Integer.MAX_VALUE);
			throw new java.lang.RuntimeException("Exception expected");
		} catch (java.lang.StringIndexOutOfBoundsException sobe) {
		} catch (java.lang.OutOfMemoryError oome) {
			throw new java.lang.RuntimeException("Wrong exception thrown.");
		}
		try {
			sb1.insert(2, new char[25], 5, java.lang.Integer.MAX_VALUE);
			throw new java.lang.RuntimeException("Exception expected");
		} catch (java.lang.StringIndexOutOfBoundsException sobe) {
		} catch (java.lang.ArrayIndexOutOfBoundsException aioe) {
			throw new java.lang.RuntimeException("Wrong exception thrown.");
		}
	}
}