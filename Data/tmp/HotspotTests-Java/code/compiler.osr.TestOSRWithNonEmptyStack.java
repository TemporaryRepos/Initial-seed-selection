public class TestOSRWithNonEmptyStack extends java.lang.ClassLoader {
	private static final int CLASS_FILE_VERSION = 52;

	private static final java.lang.String CLASS_NAME = "TestCase";

	private static final java.lang.String METHOD_NAME = "test";

	private static final int ITERATIONS = 1000000;

	private static byte[] generateTestClass() {
		jdk.internal.org.objectweb.asm.ClassWriter cw = new jdk.internal.org.objectweb.asm.ClassWriter(jdk.internal.org.objectweb.asm.ClassWriter.COMPUTE_FRAMES);
		cw.visit(compiler.osr.TestOSRWithNonEmptyStack.CLASS_FILE_VERSION, jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, compiler.osr.TestOSRWithNonEmptyStack.CLASS_NAME, null, "java/lang/Object", null);
		compiler.osr.TestOSRWithNonEmptyStack.generateConstructor(cw);
		compiler.osr.TestOSRWithNonEmptyStack.generateTestMethod(cw);
		cw.visitEnd();
		return cw.toByteArray();
	}

	private static void generateConstructor(jdk.internal.org.objectweb.asm.ClassWriter classWriter) {
		jdk.internal.org.objectweb.asm.MethodVisitor mv = classWriter.visitMethod(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ALOAD, 0);
		mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
		mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
	}

	private static void generateTestMethod(jdk.internal.org.objectweb.asm.ClassWriter classWriter) {
		jdk.internal.org.objectweb.asm.MethodVisitor mv = classWriter.visitMethod(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, compiler.osr.TestOSRWithNonEmptyStack.METHOD_NAME, "()V", null, null);
		jdk.internal.org.objectweb.asm.Label osrEntryPoint = new jdk.internal.org.objectweb.asm.Label();
		mv.visitCode();
		mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ALOAD, 0);
		mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.ICONST_0);
		mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ISTORE, 1);
		mv.visitLabel(osrEntryPoint);
		mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ILOAD, 1);
		mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.ICONST_1);
		mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.IADD);
		mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.DUP);
		mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ISTORE, 1);
		mv.visitLdcInsn(compiler.osr.TestOSRWithNonEmptyStack.ITERATIONS);
		mv.visitJumpInsn(jdk.internal.org.objectweb.asm.Opcodes.IF_ICMPLT, osrEntryPoint);
		mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.POP);
		mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
	}

	private void run() {
		byte[] bytecode = compiler.osr.TestOSRWithNonEmptyStack.generateTestClass();
		try {
			java.lang.Class klass = defineClass(compiler.osr.TestOSRWithNonEmptyStack.CLASS_NAME, bytecode, 0, bytecode.length);
			java.lang.reflect.Constructor ctor = klass.getConstructor();
			java.lang.reflect.Method method = klass.getDeclaredMethod(compiler.osr.TestOSRWithNonEmptyStack.METHOD_NAME);
			java.lang.Object testCase = ctor.newInstance();
			method.invoke(testCase);
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException("Test bug: generated class should be valid.", e);
		}
	}

	public static void main(java.lang.String[] args) {
		new compiler.osr.TestOSRWithNonEmptyStack().run();
	}
}