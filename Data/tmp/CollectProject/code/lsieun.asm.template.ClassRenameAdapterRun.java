public class ClassRenameAdapterRun {
	public static void main(java.lang.String[] args) {
		java.lang.String origin_name = "sample/HelloWorld";
		java.lang.String target_name = "sample/GoodChild";
		java.lang.String origin_filepath = lsieun.asm.template.ClassRenameAdapterRun.getFilePath(origin_name);
		byte[] bytes1 = lsieun.utils.ReadUtils.readByPath(origin_filepath);
		org.objectweb.asm.ClassReader cr = new org.objectweb.asm.ClassReader(bytes1);
		org.objectweb.asm.ClassWriter cw = new org.objectweb.asm.ClassWriter(org.objectweb.asm.ClassWriter.COMPUTE_FRAMES);
		org.objectweb.asm.ClassVisitor cv = new lsieun.asm.template.ClassRenameAdapter(org.objectweb.asm.Opcodes.ASM9, cw, origin_name, target_name);
		cr.accept(cv, 0);
		byte[] bytes2 = cw.toByteArray();
		java.lang.String target_filepath = lsieun.asm.template.ClassRenameAdapterRun.getFilePath(target_name);
		lsieun.utils.FileUtils.writeBytes(target_filepath, bytes2);
	}

	public static java.lang.String getFilePath(java.lang.String internalName) {
		java.lang.String relative_path = java.lang.String.format("%s.class", internalName);
		return lsieun.utils.FileUtils.getFilePath(relative_path);
	}
}