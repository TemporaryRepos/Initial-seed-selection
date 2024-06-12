public class TraceClassVisitorExample01Generate {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes = lsieun.asm.util.TraceClassVisitorExample01Generate.dump();
		lsieun.utils.FileUtils.writeBytes(filepath, bytes);
	}

	public static byte[] dump() throws java.lang.Exception {
		org.objectweb.asm.ClassWriter cw = new org.objectweb.asm.ClassWriter(org.objectweb.asm.ClassWriter.COMPUTE_FRAMES);
		java.io.PrintWriter printWriter = new java.io.PrintWriter(java.lang.System.out);
		org.objectweb.asm.util.TraceClassVisitor cv = new org.objectweb.asm.util.TraceClassVisitor(cw, printWriter);
		cv.visit(org.objectweb.asm.Opcodes.V1_8, org.objectweb.asm.Opcodes.ACC_PUBLIC + org.objectweb.asm.Opcodes.ACC_SUPER, "sample/HelloWorld", null, "java/lang/Object", null);
		{
			org.objectweb.asm.FieldVisitor fv1 = cv.visitField(org.objectweb.asm.Opcodes.ACC_PRIVATE, "intValue", "I", null, null);
			fv1.visitEnd();
		}
		{
			org.objectweb.asm.FieldVisitor fv2 = cv.visitField(org.objectweb.asm.Opcodes.ACC_PRIVATE, "strValue", "Ljava/lang/String;", null, null);
			fv2.visitEnd();
		}
		{
			org.objectweb.asm.MethodVisitor mv1 = cv.visitMethod(org.objectweb.asm.Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv1.visitCode();
			mv1.visitVarInsn(org.objectweb.asm.Opcodes.ALOAD, 0);
			mv1.visitMethodInsn(org.objectweb.asm.Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
			mv1.visitInsn(org.objectweb.asm.Opcodes.RETURN);
			mv1.visitMaxs(0, 0);
			mv1.visitEnd();
		}
		{
			org.objectweb.asm.MethodVisitor mv2 = cv.visitMethod(org.objectweb.asm.Opcodes.ACC_PUBLIC, "test", "()V", null, null);
			mv2.visitCode();
			mv2.visitFieldInsn(org.objectweb.asm.Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
			mv2.visitLdcInsn("Hello World");
			mv2.visitMethodInsn(org.objectweb.asm.Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
			mv2.visitInsn(org.objectweb.asm.Opcodes.RETURN);
			mv2.visitMaxs(2, 1);
			mv2.visitEnd();
		}
		cv.visitEnd();
		return cw.toByteArray();
	}
}