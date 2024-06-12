public class CheckClassAdapterExample02Generate {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes = lsieun.asm.util.CheckClassAdapterExample02Generate.dump();
		lsieun.utils.FileUtils.writeBytes(filepath, bytes);
		java.io.PrintWriter printWriter = new java.io.PrintWriter(java.lang.System.out);
		org.objectweb.asm.util.CheckClassAdapter.verify(new org.objectweb.asm.ClassReader(bytes), false, printWriter);
	}

	public static byte[] dump() throws java.lang.Exception {
		org.objectweb.asm.ClassWriter cw = new org.objectweb.asm.ClassWriter(org.objectweb.asm.ClassWriter.COMPUTE_FRAMES);
		lsieun.asm.util.CodeUtils.generate(cw);
		return cw.toByteArray();
	}
}