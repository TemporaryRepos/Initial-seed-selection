public class TestPrivateInterfaceMethodReflect {
	static final java.lang.String INTERFACE_NAME = "PrivateInterfaceMethodReflectTest_Interface";

	static final java.lang.String CLASS_NAME = "PrivateInterfaceMethodReflectTest_Class";

	static final int EXPECTED = 1234;

	static class TestClassLoader extends java.lang.ClassLoader implements jdk.internal.org.objectweb.asm.Opcodes {
		@java.lang.Override
		public java.lang.Class findClass(java.lang.String name) throws java.lang.ClassNotFoundException {
			byte[] b;
			try {
				b = loadClassData(name);
			} catch (java.lang.Throwable th) {
				throw new java.lang.ClassNotFoundException("Loading error", th);
			}
			return defineClass(name, b, 0, b.length);
		}

		private byte[] loadClassData(java.lang.String name) throws java.lang.Exception {
			jdk.internal.org.objectweb.asm.ClassWriter cw = new jdk.internal.org.objectweb.asm.ClassWriter(0);
			jdk.internal.org.objectweb.asm.MethodVisitor mv;
			switch (name) {
				case javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.INTERFACE_NAME :
					cw.visit(jdk.internal.org.objectweb.asm.Opcodes.V1_8, (jdk.internal.org.objectweb.asm.Opcodes.ACC_ABSTRACT | jdk.internal.org.objectweb.asm.Opcodes.ACC_INTERFACE) | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.INTERFACE_NAME, null, "java/lang/Object", null);
					{
						mv = cw.visitMethod(jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE, "privInstance", "()I", null, null);
						mv.visitCode();
						mv.visitLdcInsn(javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.EXPECTED);
						mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.IRETURN);
						mv.visitMaxs(1, 1);
						mv.visitEnd();
					}
					break;
				case javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.CLASS_NAME :
					cw.visit(52, jdk.internal.org.objectweb.asm.Opcodes.ACC_SUPER | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.CLASS_NAME, null, "java/lang/Object", new java.lang.String[]{ javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.INTERFACE_NAME });
					{
						mv = cw.visitMethod(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
						mv.visitCode();
						mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ALOAD, 0);
						mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
						mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.RETURN);
						mv.visitMaxs(1, 1);
						mv.visitEnd();
					}
					break;
				default :
					break;
			}
			cw.visitEnd();
			return cw.toByteArray();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.TestClassLoader tcl = new javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.TestClassLoader();
		java.lang.Class<?> itf = tcl.loadClass(javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.INTERFACE_NAME);
		java.lang.Class<?> k = tcl.loadClass(javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.CLASS_NAME);
		java.lang.Object inst = k.newInstance();
		java.lang.reflect.Method[] meths = itf.getDeclaredMethods();
		if (meths.length != 1) {
			throw new java.lang.Exception((("Expected one method in " + javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.INTERFACE_NAME) + " instead ") + meths.length);
		}
		java.lang.reflect.Method m = meths[0];
		int mod = m.getModifiers();
		if ((mod & java.lang.reflect.Modifier.PRIVATE) == 0) {
			throw new java.lang.Exception(("Expected " + m) + " to be private");
		}
		if ((mod & java.lang.reflect.Modifier.STATIC) != 0) {
			throw new java.lang.Exception(("Expected " + m) + " to be instance method");
		}
		m.setAccessible(true);
		for (int i = 1; i < 200; i++) {
			if (!m.invoke(inst).equals(javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.EXPECTED)) {
				throw new java.lang.Exception((("Expected " + javaT.lang.reflect.Method.invoke.TestPrivateInterfaceMethodReflect.EXPECTED) + " from ") + m);
			}
		}
		java.lang.System.out.println("Passed.");
	}
}