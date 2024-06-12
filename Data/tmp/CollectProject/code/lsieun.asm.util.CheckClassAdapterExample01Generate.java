public class CheckClassAdapterExample01Generate {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes = lsieun.asm.util.CheckClassAdapterExample01Generate.dump();
		lsieun.utils.FileUtils.writeBytes(filepath, bytes);
	}

	public static byte[] dump() throws java.lang.Exception {
		org.objectweb.asm.ClassWriter cw = new org.objectweb.asm.ClassWriter(org.objectweb.asm.ClassWriter.COMPUTE_FRAMES);
		org.objectweb.asm.ClassVisitor cv = new org.objectweb.asm.util.CheckClassAdapter(cw);
		lsieun.asm.util.CodeUtils.generate(cv);
		return cw.toByteArray();
	}
}