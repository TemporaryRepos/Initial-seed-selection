public class ACCModule52 {
	static final java.lang.String CLASS_NAME = "ACCModule52Pkg";

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int ACC_MODULE = 0x8000;
		jdk.internal.org.objectweb.asm.ClassWriter cw = new jdk.internal.org.objectweb.asm.ClassWriter(0);
		cw.visit(jdk.internal.org.objectweb.asm.Opcodes.V1_8, ((jdk.internal.org.objectweb.asm.Opcodes.ACC_INTERFACE + jdk.internal.org.objectweb.asm.Opcodes.ACC_ABSTRACT) + jdk.internal.org.objectweb.asm.Opcodes.ACC_SYNTHETIC) + ACC_MODULE, ACCModule52.CLASS_NAME, null, "java/lang/Object", null);
		cw.visitEnd();
		byte[] bytes = cw.toByteArray();
		java.lang.ClassLoader loader = new java.lang.ClassLoader(ACCModule52.class.getClassLoader()) {
			@java.lang.Override
			protected java.lang.Class<?> findClass(java.lang.String cn) throws java.lang.ClassNotFoundException {
				if (cn.equals(ACCModule52.CLASS_NAME)) {
					java.lang.Class superClass = super.defineClass(cn, bytes, 0, bytes.length);
				} else {
					throw new java.lang.ClassNotFoundException(cn);
				}
				return null;
			}
		};
		java.lang.Class<?> clazz = loader.loadClass(ACCModule52.CLASS_NAME);
	}
}