public class GeneratorAdapterExample01 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes = lsieun.asm.commons.GeneratorAdapterExample01.dump();
		lsieun.utils.FileUtils.writeBytes(filepath, bytes);
	}

	public static byte[] dump() throws java.lang.Exception {
		org.objectweb.asm.ClassWriter cw = new org.objectweb.asm.ClassWriter(org.objectweb.asm.ClassWriter.COMPUTE_FRAMES);
		java.io.PrintWriter printWriter = new java.io.PrintWriter(java.lang.System.out);
		org.objectweb.asm.util.TraceClassVisitor cv = new org.objectweb.asm.util.TraceClassVisitor(cw, printWriter);
		cv.visit(org.objectweb.asm.Opcodes.V1_8, org.objectweb.asm.Opcodes.ACC_PUBLIC + org.objectweb.asm.Opcodes.ACC_SUPER, "sample/HelloWorld", null, "java/lang/Object", null);
		{
			org.objectweb.asm.commons.Method m1 = org.objectweb.asm.commons.Method.getMethod("void <init> ()");
			org.objectweb.asm.commons.GeneratorAdapter mg = new org.objectweb.asm.commons.GeneratorAdapter(org.objectweb.asm.Opcodes.ACC_PUBLIC, m1, null, null, cv);
			mg.loadThis();
			mg.invokeConstructor(org.objectweb.asm.Type.getType(java.lang.Object.class), m1);
			mg.returnValue();
			mg.endMethod();
		}
		{
			org.objectweb.asm.commons.Method m2 = org.objectweb.asm.commons.Method.getMethod("void main (String[])");
			org.objectweb.asm.commons.GeneratorAdapter mg = new org.objectweb.asm.commons.GeneratorAdapter(org.objectweb.asm.Opcodes.ACC_PUBLIC + org.objectweb.asm.Opcodes.ACC_STATIC, m2, null, null, cv);
			mg.getStatic(org.objectweb.asm.Type.getType(java.lang.System.class), "out", org.objectweb.asm.Type.getType(java.io.PrintStream.class));
			mg.push("Hello world!");
			mg.invokeVirtual(org.objectweb.asm.Type.getType(java.io.PrintStream.class), org.objectweb.asm.commons.Method.getMethod("void println (String)"));
			mg.returnValue();
			mg.endMethod();
		}
		cv.visitEnd();
		return cw.toByteArray();
	}
}