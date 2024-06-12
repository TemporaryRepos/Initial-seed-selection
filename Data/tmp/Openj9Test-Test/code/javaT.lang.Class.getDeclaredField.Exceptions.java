public class Exceptions {
	int f0;

	public int f1;

	private int f2;

	protected int f4;

	private static final java.lang.String[] npe = new java.lang.String[]{ null };

	private static final java.lang.String[] nsfe = new java.lang.String[]{ "f6" };

	private static final java.lang.String[] pass = new java.lang.String[]{ "f0", "f1", "f2", "f4" };

	private void test(java.lang.String s, java.lang.Class ex) {
		java.lang.Throwable t = null;
		try {
			getClass().getDeclaredField(s);
		} catch (java.lang.Throwable x) {
			if (ex.isAssignableFrom(x.getClass())) {
				t = x;
			}
		}
		if ((t == null) && (ex != null)) {
			throw new java.lang.RuntimeException((("expected " + ex.getName()) + " for ") + s);
		} else {
			java.lang.System.out.println(s + " OK");
		}
	}

	public static void main(java.lang.String[] args) {
		javaT.lang.Class.getDeclaredField.Exceptions e = new javaT.lang.Class.getDeclaredField.Exceptions();
		for (int i = 0; i < javaT.lang.Class.getDeclaredField.Exceptions.npe.length; i++) {
			e.test(javaT.lang.Class.getDeclaredField.Exceptions.npe[i], java.lang.NullPointerException.class);
		}
		for (int i = 0; i < javaT.lang.Class.getDeclaredField.Exceptions.nsfe.length; i++) {
			e.test(javaT.lang.Class.getDeclaredField.Exceptions.nsfe[i], java.lang.NoSuchFieldException.class);
		}
		for (int i = 0; i < javaT.lang.Class.getDeclaredField.Exceptions.pass.length; i++) {
			e.test(javaT.lang.Class.getDeclaredField.Exceptions.pass[i], null);
		}
	}
}