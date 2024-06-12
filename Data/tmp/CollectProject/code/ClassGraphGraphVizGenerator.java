public class ClassGraphGraphVizGenerator {
	public static void main(final java.lang.String[] args) throws java.io.IOException {
		try (final io.github.classgraph.ScanResult scanResult = new io.github.classgraph.ClassGraph().acceptPackagesNonRecursive("io.github.classgraph").enableMethodInfo().ignoreMethodVisibility().enableFieldInfo().ignoreFieldVisibility().enableAnnotationInfo().scan()) {
			final java.lang.String fileName = "/tmp/graph.dot";
			try (final java.io.PrintWriter writer = new java.io.PrintWriter(fileName)) {
				writer.print(scanResult.getAllClasses().generateGraphVizDotFile(12, 8, false, true, false, true, true));
			}
			java.lang.System.out.println("Wrote " + fileName);
		}
	}
}