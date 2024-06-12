public class Exceptions {
	private static boolean ok = true;

	int f0;

	public int f1;

	private int f2;

	protected int f4;

	private static final java.lang.String[] npe = new java.lang.String[]{ null };

	private static final java.lang.String[] nsfe = new java.lang.String[]{ "f0", "f2", "f4", "f6" };

	private static final java.lang.String[] pass = new java.lang.String[]{ "f1" };

	private void test(java.lang.String s, java.lang.Class ex) {
		java.lang.Throwable t = null;
		try {
			getClass().getField(s);
		} catch (java.lang.Throwable x) {
			if (ex.isAssignableFrom(x.getClass())) {
				t = x;
			}
		}
		if ((t == null) && (ex != null)) {
			javaT.lang.Class.getField.Exceptions.ok = false;
			java.lang.System.out.println(((("expected " + ex.getName()) + " for ") + s) + " -- FAILED");
		} else {
			java.lang.System.out.println(s + " -- OK");
		}
	}

	public static void main(java.lang.String[] args) {
		javaT.lang.Class.getField.Exceptions e = new javaT.lang.Class.getField.Exceptions();
		for (int i = 0; i < javaT.lang.Class.getField.Exceptions.npe.length; i++) {
			e.test(javaT.lang.Class.getField.Exceptions.npe[i], java.lang.NullPointerException.class);
		}
		for (int i = 0; i < javaT.lang.Class.getField.Exceptions.nsfe.length; i++) {
			e.test(javaT.lang.Class.getField.Exceptions.nsfe[i], java.lang.NoSuchFieldException.class);
		}
		for (int i = 0; i < javaT.lang.Class.getField.Exceptions.pass.length; i++) {
			e.test(javaT.lang.Class.getField.Exceptions.pass[i], null);
		}
		if (!javaT.lang.Class.getField.Exceptions.ok) {
			throw new java.lang.RuntimeException("some tests failed");
		}
	}
}