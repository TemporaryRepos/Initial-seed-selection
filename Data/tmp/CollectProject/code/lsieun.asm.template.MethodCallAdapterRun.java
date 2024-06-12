public class MethodCallAdapterRun {
	public static void main(java.lang.String[] args) {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes1 = lsieun.utils.ReadUtils.readByPath(filepath);
		org.objectweb.asm.ClassReader cr = new org.objectweb.asm.ClassReader(bytes1);
		org.objectweb.asm.ClassWriter cw = new org.objectweb.asm.ClassWriter(org.objectweb.asm.ClassWriter.COMPUTE_FRAMES);
		lsieun.asm.template.Info info1 = new lsieun.asm.template.Info(org.objectweb.asm.Opcodes.INVOKEVIRTUAL, "sample/HelloWorld", "add", "(II)I", org.objectweb.asm.Opcodes.INVOKEVIRTUAL, "sample/HelloWorld", "sub", "(II)I");
		java.util.List<lsieun.asm.template.Info> list = new java.util.ArrayList<>();
		list.add(info1);
		org.objectweb.asm.ClassVisitor cv = new lsieun.asm.template.MethodCallAdapter(org.objectweb.asm.Opcodes.ASM9, cw, list);
		cr.accept(cv, org.objectweb.asm.ClassReader.SKIP_FRAMES);
		byte[] bytes2 = cw.toByteArray();
		lsieun.utils.FileUtils.writeBytes(filepath, bytes2);
	}
}