public class PublicConstructor {
	public static void main(java.lang.String[] args) {
		java.lang.StackTraceElement ste = new java.lang.StackTraceElement("com.acme.Widget", "frobnicate", "Widget.java", 42);
		if (!(((ste.getClassName().equals("com.acme.Widget") && ste.getFileName().equals("Widget.java")) && ste.getMethodName().equals("frobnicate")) && (ste.getLineNumber() == 42))) {
			throw new java.lang.RuntimeException("1");
		}
		if (ste.isNativeMethod()) {
			throw new java.lang.RuntimeException("2");
		}
		java.lang.StackTraceElement ste2 = new java.lang.StackTraceElement("com.acme.Widget", "frobnicate", "Widget.java", -2);
		if (!ste2.isNativeMethod()) {
			throw new java.lang.RuntimeException("3");
		}
	}
}