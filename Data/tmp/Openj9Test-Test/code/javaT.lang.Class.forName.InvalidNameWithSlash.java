public class InvalidNameWithSlash {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		boolean exceptionOccurred = false;
		try {
			java.lang.Class c = java.lang.Class.forName("java/lang.Object");
		} catch (java.lang.Exception e) {
			exceptionOccurred = true;
		}
		if (!exceptionOccurred) {
			throw new java.lang.Exception("forName accepting names with slashes?");
		}
	}
}