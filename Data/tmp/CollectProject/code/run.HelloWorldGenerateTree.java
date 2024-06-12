public class HelloWorldGenerateTree {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes = run.HelloWorldGenerateTree.dump();
		lsieun.utils.FileUtils.writeBytes(filepath, bytes);
	}

	public static byte[] dump() throws java.lang.Exception {
		org.objectweb.asm.tree.ClassNode cn = new org.objectweb.asm.tree.ClassNode();
		cn.version = org.objectweb.asm.Opcodes.V1_8;
		cn.access = org.objectweb.asm.Opcodes.ACC_PUBLIC | org.objectweb.asm.Opcodes.ACC_SUPER;
		cn.name = "sample/HelloWorld";
		cn.signature = null;
		cn.superName = "java/lang/Object";
		{
			org.objectweb.asm.tree.MethodNode mn1 = new org.objectweb.asm.tree.MethodNode(org.objectweb.asm.Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			cn.methods.add(mn1);
			org.objectweb.asm.tree.InsnList il = mn1.instructions;
			il.add(new org.objectweb.asm.tree.VarInsnNode(org.objectweb.asm.Opcodes.ALOAD, 0));
			il.add(new org.objectweb.asm.tree.MethodInsnNode(org.objectweb.asm.Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false));
			il.add(new org.objectweb.asm.tree.InsnNode(org.objectweb.asm.Opcodes.RETURN));
			mn1.maxStack = 1;
			mn1.maxLocals = 1;
		}
		{
			org.objectweb.asm.tree.MethodNode mn2 = new org.objectweb.asm.tree.MethodNode(org.objectweb.asm.Opcodes.ACC_PUBLIC, "test", "()V", null, null);
			cn.methods.add(mn2);
			org.objectweb.asm.tree.InsnList il = mn2.instructions;
			il.add(new org.objectweb.asm.tree.FieldInsnNode(org.objectweb.asm.Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
			il.add(new org.objectweb.asm.tree.LdcInsnNode("Hello World"));
			il.add(new org.objectweb.asm.tree.MethodInsnNode(org.objectweb.asm.Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
			il.add(new org.objectweb.asm.tree.InsnNode(org.objectweb.asm.Opcodes.RETURN));
			mn2.maxStack = 2;
			mn2.maxLocals = 1;
		}
		org.objectweb.asm.ClassWriter cw = new org.objectweb.asm.ClassWriter(org.objectweb.asm.ClassWriter.COMPUTE_FRAMES);
		cn.accept(cw);
		return cw.toByteArray();
	}
}