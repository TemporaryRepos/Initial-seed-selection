public class InvokeDynamicPatcher extends jdk.internal.org.objectweb.asm.ClassVisitor {
	private static final java.lang.String CLASS = compiler.calls.common.InvokeDynamic.class.getName().replace('.', '/');

	private static final java.lang.String CALLER_METHOD_NAME = "caller";

	private static final java.lang.String CALLEE_METHOD_NAME = "callee";

	private static final java.lang.String NATIVE_CALLEE_METHOD_NAME = "calleeNative";

	private static final java.lang.String BOOTSTRAP_METHOD_NAME = "bootstrapMethod";

	private static final java.lang.String CALL_NATIVE_FIELD = "nativeCallee";

	private static final java.lang.String CALL_NATIVE_FIELD_DESC = "Z";

	private static final java.lang.String CALLEE_METHOD_DESC = ("(L" + compiler.calls.common.InvokeDynamicPatcher.CLASS) + ";IJFDLjava/lang/String;)Z";

	private static final java.lang.String ASSERTTRUE_METHOD_DESC = "(ZLjava/lang/String;)V";

	private static final java.lang.String ASSERTS_CLASS = "jdk/test/lib/Asserts";

	private static final java.lang.String ASSERTTRUE_METHOD_NAME = "assertTrue";

	public static void main(java.lang.String[] args) {
		jdk.internal.org.objectweb.asm.ClassReader cr;
		java.nio.file.Path filePath;
		try {
			filePath = java.nio.file.Paths.get(compiler.calls.common.InvokeDynamic.class.getProtectionDomain().getCodeSource().getLocation().toURI()).resolve(compiler.calls.common.InvokeDynamicPatcher.CLASS + ".class");
		} catch (java.net.URISyntaxException ex) {
			throw new java.lang.Error("TESTBUG: Can't get code source" + ex, ex);
		}
		try (final java.io.FileInputStream fis = new java.io.FileInputStream(filePath.toFile())) {
			cr = new jdk.internal.org.objectweb.asm.ClassReader(fis);
		} catch (java.io.IOException e) {
			throw new java.lang.Error("Error reading file", e);
		}
		jdk.internal.org.objectweb.asm.ClassWriter cw = new jdk.internal.org.objectweb.asm.ClassWriter(cr, jdk.internal.org.objectweb.asm.ClassWriter.COMPUTE_FRAMES | jdk.internal.org.objectweb.asm.ClassWriter.COMPUTE_MAXS);
		cr.accept(new compiler.calls.common.InvokeDynamicPatcher(jdk.internal.org.objectweb.asm.Opcodes.ASM5, cw), 0);
		try {
			java.nio.file.Files.write(filePath, cw.toByteArray(), java.nio.file.StandardOpenOption.WRITE);
		} catch (java.io.IOException e) {
			throw new java.lang.Error(e);
		}
	}

	public InvokeDynamicPatcher(int api, jdk.internal.org.objectweb.asm.ClassWriter cw) {
		super(api, cw);
	}

	@java.lang.Override
	public jdk.internal.org.objectweb.asm.MethodVisitor visitMethod(final int access, final java.lang.String name, final java.lang.String desc, final java.lang.String signature, final java.lang.String[] exceptions) {
		if (name.equals(compiler.calls.common.InvokeDynamicPatcher.CALLER_METHOD_NAME)) {
			jdk.internal.org.objectweb.asm.MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
			jdk.internal.org.objectweb.asm.Label nonNativeLabel = new jdk.internal.org.objectweb.asm.Label();
			jdk.internal.org.objectweb.asm.Label checkLabel = new jdk.internal.org.objectweb.asm.Label();
			java.lang.invoke.MethodType mtype = java.lang.invoke.MethodType.methodType(java.lang.invoke.CallSite.class, java.lang.invoke.MethodHandles.Lookup.class, java.lang.String.class, java.lang.invoke.MethodType.class);
			jdk.internal.org.objectweb.asm.Handle bootstrap = new jdk.internal.org.objectweb.asm.Handle(jdk.internal.org.objectweb.asm.Opcodes.H_INVOKESTATIC, compiler.calls.common.InvokeDynamicPatcher.CLASS, compiler.calls.common.InvokeDynamicPatcher.BOOTSTRAP_METHOD_NAME, mtype.toMethodDescriptorString());
			mv.visitCode();
			mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ALOAD, 0);
			mv.visitLdcInsn(1);
			mv.visitLdcInsn(2L);
			mv.visitLdcInsn(3.0F);
			mv.visitLdcInsn(4.0);
			mv.visitLdcInsn("5");
			mv.visitVarInsn(jdk.internal.org.objectweb.asm.Opcodes.ALOAD, 0);
			mv.visitFieldInsn(jdk.internal.org.objectweb.asm.Opcodes.GETFIELD, compiler.calls.common.InvokeDynamicPatcher.CLASS, compiler.calls.common.InvokeDynamicPatcher.CALL_NATIVE_FIELD, compiler.calls.common.InvokeDynamicPatcher.CALL_NATIVE_FIELD_DESC);
			mv.visitJumpInsn(jdk.internal.org.objectweb.asm.Opcodes.IFEQ, nonNativeLabel);
			mv.visitInvokeDynamicInsn(compiler.calls.common.InvokeDynamicPatcher.NATIVE_CALLEE_METHOD_NAME, compiler.calls.common.InvokeDynamicPatcher.CALLEE_METHOD_DESC, bootstrap);
			mv.visitJumpInsn(jdk.internal.org.objectweb.asm.Opcodes.GOTO, checkLabel);
			mv.visitLabel(nonNativeLabel);
			mv.visitInvokeDynamicInsn(compiler.calls.common.InvokeDynamicPatcher.CALLEE_METHOD_NAME, compiler.calls.common.InvokeDynamicPatcher.CALLEE_METHOD_DESC, bootstrap);
			mv.visitLabel(checkLabel);
			mv.visitLdcInsn(compiler.calls.common.CallsBase.CALL_ERR_MSG);
			mv.visitMethodInsn(jdk.internal.org.objectweb.asm.Opcodes.INVOKESTATIC, compiler.calls.common.InvokeDynamicPatcher.ASSERTS_CLASS, compiler.calls.common.InvokeDynamicPatcher.ASSERTTRUE_METHOD_NAME, compiler.calls.common.InvokeDynamicPatcher.ASSERTTRUE_METHOD_DESC, false);
			mv.visitInsn(jdk.internal.org.objectweb.asm.Opcodes.RETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
			return null;
		}
		return super.visitMethod(access, name, desc, signature, exceptions);
	}
}