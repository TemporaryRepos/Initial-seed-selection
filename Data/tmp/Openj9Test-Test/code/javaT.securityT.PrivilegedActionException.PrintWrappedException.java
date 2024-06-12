public class PrintWrappedException {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.io.FileInputStream fis = ((java.io.FileInputStream) (java.security.AccessController.doPrivileged(new java.security.PrivilegedExceptionAction() {
				public java.lang.Object run() throws java.io.FileNotFoundException {
					return new java.io.FileInputStream("someFile");
				}
			})));
		} catch (java.security.PrivilegedActionException e) {
			java.lang.String msg = e.toString();
			if (msg.indexOf("FileNotFoundException") == (-1)) {
				throw new java.lang.Exception("Wrapped exception not printed");
			}
		}
	}
}