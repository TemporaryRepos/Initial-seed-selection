public class MockAnalyzerRun {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String relative_path = "sample/HelloWorld.class";
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(relative_path);
		byte[] bytes = lsieun.utils.FileUtils.readBytes(filepath);
		org.objectweb.asm.ClassReader cr = new org.objectweb.asm.ClassReader(bytes);
		int api = org.objectweb.asm.Opcodes.ASM9;
		org.objectweb.asm.tree.ClassNode cn = new org.objectweb.asm.tree.ClassNode();
		int parsingOptions = org.objectweb.asm.ClassReader.SKIP_DEBUG | org.objectweb.asm.ClassReader.SKIP_FRAMES;
		cr.accept(cn, parsingOptions);
		lsieun.asm.analysis.MockAnalyzer<org.objectweb.asm.tree.analysis.BasicValue> analyzer = new lsieun.asm.analysis.MockAnalyzer<>(new org.objectweb.asm.tree.analysis.SimpleVerifier());
		java.util.List<org.objectweb.asm.tree.MethodNode> methods = cn.methods;
		for (org.objectweb.asm.tree.MethodNode mn : methods) {
			java.lang.System.out.println((("Method Name: " + mn.name) + ":") + mn.desc);
			org.objectweb.asm.tree.analysis.Frame<org.objectweb.asm.tree.analysis.BasicValue>[] frames = analyzer.analyze(cn.name, mn);
			for (org.objectweb.asm.tree.analysis.Frame<?> f : frames) {
				java.lang.System.out.println(f);
			}
			java.lang.System.out.println(lsieun.cst.Const.DIVISION_LINE);
		}
	}
}