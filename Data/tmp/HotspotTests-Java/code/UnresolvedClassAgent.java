public class UnresolvedClassAgent {
	public static void main(java.lang.String... args) {
	}

	public static void premain(java.lang.String args, java.lang.instrument.Instrumentation inst) throws java.lang.Exception {
		try {
			MyRedefinedClass.foo();
		} catch (java.lang.NoClassDefFoundError err) {
			java.lang.System.out.println("NoClassDefFoundError (expected)");
		}
		java.io.File f = new java.io.File(java.lang.System.getProperty("test.classes"), "MyRedefinedClass.class");
		byte[] buf = new byte[((int) (f.length()))];
		try (final java.io.DataInputStream dis = new java.io.DataInputStream(new java.io.FileInputStream(f))) {
			dis.readFully(buf);
		}
		java.lang.instrument.ClassDefinition cd = new java.lang.instrument.ClassDefinition(MyRedefinedClass.class, buf);
		inst.redefineClasses(new java.lang.instrument.ClassDefinition[]{ cd });
		try {
			MyRedefinedClass.foo();
		} catch (java.lang.NoClassDefFoundError err) {
			java.lang.System.out.println("NoClassDefFoundError (expected again)");
		}
	}
}