public class NPE {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.System.setIn(new java.io.ByteArrayInputStream(new byte[0]));
		try {
			new com.sun.security.auth.callback.TextCallbackHandler().handle(new javax.security.auth.callback.Callback[]{ new javax.security.auth.callback.NameCallback("Name: ") });
		} catch (java.io.IOException ioe) {
		}
	}
}