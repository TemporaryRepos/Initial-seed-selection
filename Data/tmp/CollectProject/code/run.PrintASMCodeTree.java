public class PrintASMCodeTree {
	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.lang.String className = "sample.HelloWorld";
		int parsingOptions = org.objectweb.asm.ClassReader.SKIP_FRAMES | org.objectweb.asm.ClassReader.SKIP_DEBUG;
		org.objectweb.asm.util.Printer printer = new lsieun.asm.util.TreePrinter();
		java.io.PrintWriter printWriter = new java.io.PrintWriter(java.lang.System.out, true);
		org.objectweb.asm.util.TraceClassVisitor traceClassVisitor = new org.objectweb.asm.util.TraceClassVisitor(null, printer, printWriter);
		new org.objectweb.asm.ClassReader(className).accept(traceClassVisitor, parsingOptions);
	}
}