public class InstructionAdapterExample01 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes = lsieun.asm.commons.InstructionAdapterExample01.dump();
		lsieun.utils.FileUtils.writeBytes(filepath, bytes);
	}

	public static byte[] dump() throws java.lang.Exception {
		org.objectweb.asm.ClassWriter cw = new org.objectweb.asm.ClassWriter(org.objectweb.asm.ClassWriter.COMPUTE_FRAMES);
		cw.visit(org.objectweb.asm.Opcodes.V1_8, org.objectweb.asm.Opcodes.ACC_PUBLIC + org.objectweb.asm.Opcodes.ACC_SUPER, "sample/HelloWorld", null, "java/lang/Object", null);
		{
			org.objectweb.asm.MethodVisitor mv1 = cw.visitMethod(org.objectweb.asm.Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			org.objectweb.asm.commons.InstructionAdapter ia = new org.objectweb.asm.commons.InstructionAdapter(mv1);
			ia.visitCode();
			ia.load(0, org.objectweb.asm.commons.InstructionAdapter.OBJECT_TYPE);
			ia.invokespecial("java/lang/Object", "<init>", "()V", false);
			ia.areturn(org.objectweb.asm.Type.VOID_TYPE);
			ia.visitMaxs(1, 1);
			ia.visitEnd();
		}
		{
			org.objectweb.asm.MethodVisitor mv2 = cw.visitMethod(org.objectweb.asm.Opcodes.ACC_PUBLIC, "test", "()V", null, null);
			org.objectweb.asm.commons.InstructionAdapter ia = new org.objectweb.asm.commons.InstructionAdapter(mv2);
			ia.visitCode();
			ia.getstatic("java/lang/System", "out", "Ljava/io/PrintStream;");
			ia.aconst("Hello World");
			ia.invokevirtual("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
			ia.areturn(org.objectweb.asm.Type.VOID_TYPE);
			ia.visitMaxs(2, 1);
			ia.visitEnd();
		}
		cw.visitEnd();
		return cw.toByteArray();
	}
}