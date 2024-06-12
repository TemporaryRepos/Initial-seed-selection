public class exceptionCauseTest {
	public static void main(java.lang.String[] args) {
		java.lang.Throwable cause = new java.lang.Throwable("because");
		java.lang.Throwable par = new java.lang.Throwable(cause);
		java.lang.TypeNotPresentException cnp = new java.lang.TypeNotPresentException("test", par);
		try {
			throw cnp;
		} catch (java.lang.TypeNotPresentException e) {
			if (par != e.getCause()) {
				throw new java.lang.RuntimeException("Unexpected value of cause.");
			}
		}
	}
}