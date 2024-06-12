public class HelloWorldAnalysisTree {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes = lsieun.utils.FileUtils.readBytes(filepath);
		org.objectweb.asm.ClassReader cr = new org.objectweb.asm.ClassReader(bytes);
		int api = org.objectweb.asm.Opcodes.ASM9;
		org.objectweb.asm.tree.ClassNode cn = new org.objectweb.asm.tree.ClassNode(api);
		int parsingOptions = org.objectweb.asm.ClassReader.SKIP_DEBUG | org.objectweb.asm.ClassReader.SKIP_FRAMES;
		cr.accept(cn, parsingOptions);
		java.lang.String className = cn.name;
		java.util.List<org.objectweb.asm.tree.MethodNode> methods = cn.methods;
		org.objectweb.asm.tree.MethodNode mn = methods.get(1);
		int complexity = lsieun.asm.analysis.cc.CyclomaticComplexity.getCyclomaticComplexity(className, mn);
		java.lang.String line = java.lang.String.format("%s:%s%n    complexity: %d", mn.name, mn.desc, complexity);
		java.lang.System.out.println(line);
	}
}