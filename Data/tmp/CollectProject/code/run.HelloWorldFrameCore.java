public class HelloWorldFrameCore {
	public static void main(java.lang.String[] args) {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes = lsieun.utils.FileUtils.readBytes(filepath);
		org.objectweb.asm.ClassReader cr = new org.objectweb.asm.ClassReader(bytes);
		int api = org.objectweb.asm.Opcodes.ASM9;
		org.objectweb.asm.ClassVisitor cv = new lsieun.asm.commons.MethodStackMapFrameVisitor(api, null);
		int parsingOptions = org.objectweb.asm.ClassReader.EXPAND_FRAMES;
		cr.accept(cv, parsingOptions);
	}
}