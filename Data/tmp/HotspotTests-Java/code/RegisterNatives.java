public class RegisterNatives {
	interface I {
		public abstract void registerNatives();
	}

	interface J extends RegisterNatives.I {}

	static class B implements RegisterNatives.J {
		public void registerNatives() {
			java.lang.System.out.println("B");
		}
	}

	public static void main(java.lang.String... args) {
		java.lang.System.out.println("Regression test for JDK-8024804, crash when InterfaceMethodref resolves to Object.registerNatives\n");
		RegisterNatives.J val = new RegisterNatives.B();
		try {
			val.registerNatives();
		} catch (java.lang.IllegalAccessError e) {
			java.lang.System.out.println("TEST FAILS - JDK 8 JVMS, static and non-public methods of j.l.Object should be ignored during interface method resolution\n");
			e.printStackTrace();
			throw e;
		}
		java.lang.System.out.println("TEST PASSES - no IAE resulted\n");
	}
}