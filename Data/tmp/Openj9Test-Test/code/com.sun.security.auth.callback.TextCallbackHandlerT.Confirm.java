public class Confirm {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes()));
		new com.sun.security.auth.callback.TextCallbackHandler().handle(new javax.security.auth.callback.Callback[]{ new javax.security.auth.callback.ConfirmationCallback("Prince", javax.security.auth.callback.ConfirmationCallback.INFORMATION, new java.lang.String[]{ "To be", "Not to be" }, 0) });
	}
}