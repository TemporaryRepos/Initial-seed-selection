public class HelloWorldTransformTree {
	public static void main(java.lang.String[] args) {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes1 = lsieun.utils.FileUtils.readBytes(filepath);
		org.objectweb.asm.ClassReader cr = new org.objectweb.asm.ClassReader(bytes1);
		org.objectweb.asm.ClassWriter cw = new org.objectweb.asm.ClassWriter(org.objectweb.asm.ClassWriter.COMPUTE_FRAMES);
		int api = org.objectweb.asm.Opcodes.ASM9;
		org.objectweb.asm.tree.ClassNode cn = new lsieun.asm.analysis.RemoveUnusedCastNode(api, cw);
		int parsingOptions = org.objectweb.asm.ClassReader.SKIP_DEBUG | org.objectweb.asm.ClassReader.SKIP_FRAMES;
		cr.accept(cn, parsingOptions);
		byte[] bytes2 = cw.toByteArray();
		lsieun.utils.FileUtils.writeBytes(filepath, bytes2);
	}
}