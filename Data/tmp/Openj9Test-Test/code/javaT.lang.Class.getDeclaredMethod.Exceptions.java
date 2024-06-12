public class Exceptions {
	void m0() {
	}

	public void m1() {
	}

	private void m2() {
	}

	protected void m4() {
	}

	private static final java.lang.String[] npe = new java.lang.String[]{ null };

	private static final java.lang.String[] nsme = new java.lang.String[]{ "m6" };

	private static final java.lang.String[] pass = new java.lang.String[]{ "m0", "m1", "m2", "m4" };

	private void test(java.lang.String s, java.lang.Class ex) {
		java.lang.Throwable t = null;
		try {
			getClass().getDeclaredMethod(s, new java.lang.Class[]{  });
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
		javaT.lang.Class.getDeclaredMethod.Exceptions e = new javaT.lang.Class.getDeclaredMethod.Exceptions();
		for (int i = 0; i < javaT.lang.Class.getDeclaredMethod.Exceptions.npe.length; i++) {
			e.test(javaT.lang.Class.getDeclaredMethod.Exceptions.npe[i], java.lang.NullPointerException.class);
		}
		for (int i = 0; i < javaT.lang.Class.getDeclaredMethod.Exceptions.nsme.length; i++) {
			e.test(javaT.lang.Class.getDeclaredMethod.Exceptions.nsme[i], java.lang.NoSuchMethodException.class);
		}
		for (int i = 0; i < javaT.lang.Class.getDeclaredMethod.Exceptions.pass.length; i++) {
			e.test(javaT.lang.Class.getDeclaredMethod.Exceptions.pass[i], null);
		}
	}
}