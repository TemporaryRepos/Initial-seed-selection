public class TransitiveOverrideCFV50 implements jdk.internal.org.objectweb.asm.Opcodes {
	static final java.lang.String classP1A = "P1.A";

	static final java.lang.String classP1B = "P1.B";

	static final java.lang.String classP2C = "P2.C";

	static final java.lang.String callerName = TransitiveOverrideCFV50.classP2C;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.ClassLoader cl = new java.lang.ClassLoader() {
			public java.lang.Class<?> loadClass(java.lang.String name) throws java.lang.ClassNotFoundException {
				if (findLoadedClass(name) != null) {
					return findLoadedClass(name);
				}
				if (TransitiveOverrideCFV50.classP1A.equals(name)) {
					byte[] classFile = TransitiveOverrideCFV50.dumpP1A();
					return defineClass(TransitiveOverrideCFV50.classP1A, classFile, 0, classFile.length);
				}
				if (TransitiveOverrideCFV50.classP1B.equals(name)) {
					byte[] classFile = TransitiveOverrideCFV50.dumpP1B();
					return defineClass(TransitiveOverrideCFV50.classP1B, classFile, 0, classFile.length);
				}
				if (TransitiveOverrideCFV50.classP2C.equals(name)) {
					byte[] classFile = TransitiveOverrideCFV50.dumpP2C();
					return defineClass(TransitiveOverrideCFV50.classP2C, classFile, 0, classFile.length);
				}
				return super.loadClass(name);
			}
		};
		cl.loadClass(TransitiveOverrideCFV50.classP1A);
		cl.loadClass(TransitiveOverrideCFV50.classP1B);
		cl.loadClass(TransitiveOverrideCFV50.classP2C);
		cl.loadClass(TransitiveOverrideCFV50.callerName).newInstance();
		int result = ((java.lang.Integer) (cl.loadClass(TransitiveOverrideCFV50.callerName).getDeclaredMethod("test").invoke(null)));
		if (result != 2) {
			throw new java.lang.RuntimeException("expected B.m:2, got " + result);
		}
	}

	public static byte[] dumpP1A() {
		jdk.internal.org.objectweb.asm.ClassWriter cw = new jdk.internal.org.objectweb.asm.ClassWriter(0);
		jdk.internal.org.objectweb.asm.MethodVisitor mv;
		cw.visit(jdk.internal.org.objectweb.asm.Opcodes.V1_7, jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC + jdk.internal.org.objectweb.asm.Opcodes.ACC_SUPER, "P1/A", null, "java/lang/Object", null);
		{
			mv = cw.visitMethod(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ALOAD, 0);
			mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
			mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, "m", "()I", null, null);
			mv.visitCode();
			mv.visitFieldInsn(jdk.internal.org.objectweb.asm.Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
			mv.visitLdcInsn("A.m");
			mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
			mv.visitIntInsn(jdk.internal.org.objectweb.asm.Opcodes.BIPUSH, 1);
			mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.IRETURN);
			mv.visitMaxs(2, 1);
			mv.visitEnd();
		}
		cw.visitEnd();
		return cw.toByteArray();
	}

	public static byte[] dumpP1B() {
		jdk.internal.org.objectweb.asm.ClassWriter cw = new jdk.internal.org.objectweb.asm.ClassWriter(0);
		jdk.internal.org.objectweb.asm.MethodVisitor mv;
		cw.visit(jdk.internal.org.objectweb.asm.Opcodes.V1_8, jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC + jdk.internal.org.objectweb.asm.Opcodes.ACC_SUPER, "P1/B", null, "P1/A", null);
		{
			mv = cw.visitMethod(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ALOAD, 0);
			mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKESPECIAL, "P1/A", "<init>", "()V", false);
			mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(0, "m", "()I", null, null);
			mv.visitCode();
			mv.visitFieldInsn(jdk.internal.org.objectweb.asm.Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
			mv.visitLdcInsn("B.m");
			mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
			mv.visitIntInsn(jdk.internal.org.objectweb.asm.Opcodes.BIPUSH, 2);
			mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.IRETURN);
			mv.visitMaxs(2, 1);
			mv.visitEnd();
		}
		cw.visitEnd();
		return cw.toByteArray();
	}

	public static byte[] dumpP2C() {
		jdk.internal.org.objectweb.asm.ClassWriter cw = new jdk.internal.org.objectweb.asm.ClassWriter(0);
		jdk.internal.org.objectweb.asm.MethodVisitor mv;
		cw.visit(jdk.internal.org.objectweb.asm.Opcodes.V1_6, jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC + jdk.internal.org.objectweb.asm.Opcodes.ACC_SUPER, "P2/C", null, "P1/B", null);
		{
			mv = cw.visitMethod(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ALOAD, 0);
			mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKESPECIAL, "P1/B", "<init>", "()V", false);
			mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, "m", "()I", null, null);
			mv.visitCode();
			mv.visitFieldInsn(jdk.internal.org.objectweb.asm.Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
			mv.visitLdcInsn("P2/C.m");
			mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
			mv.visitIntInsn(jdk.internal.org.objectweb.asm.Opcodes.BIPUSH, 3);
			mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.IRETURN);
			mv.visitMaxs(2, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC + jdk.internal.org.objectweb.asm.Opcodes.ACC_STATIC, "test", "()I", null, null);
			mv.visitCode();
			mv.visitTypeInsn(jdk.internal.org.objectweb.asm.Opcodes.NEW, "P2/C");
			mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.DUP);
			mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKESPECIAL, "P2/C", "<init>", "()V", false);
			mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKEVIRTUAL, "P1/A", "m", "()I", false);
			mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.IRETURN);
			mv.visitMaxs(3, 2);
			mv.visitEnd();
		}
		cw.visitEnd();
		return cw.toByteArray();
	}
}