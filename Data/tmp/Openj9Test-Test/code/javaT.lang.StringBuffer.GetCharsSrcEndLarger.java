public class GetCharsSrcEndLarger {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		boolean exceptionOccurred = false;
		try {
			new java.lang.StringBuffer("abc").getChars(1, 0, new char[10], 0);
		} catch (java.lang.StringIndexOutOfBoundsException sioobe) {
			exceptionOccurred = true;
		}
		if (!exceptionOccurred) {
			throw new java.lang.Exception("StringBuffer.getChars() must throw" + " an exception if srcBegin > srcEnd");
		}
	}
}