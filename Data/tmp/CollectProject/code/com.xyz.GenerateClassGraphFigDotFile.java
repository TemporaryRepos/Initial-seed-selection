public class GenerateClassGraphFigDotFile {
	public static void main(final java.lang.String[] args) {
		try (final io.github.classgraph.ScanResult scanResult = new io.github.classgraph.ClassGraph().acceptPackages("com.xyz.fig").ignoreFieldVisibility().enableFieldInfo().ignoreMethodVisibility().enableMethodInfo().enableAnnotationInfo().scan()) {
			java.lang.System.out.println(scanResult.getAllClasses().generateGraphVizDotFile(9.2F, 8.0F));
		}
	}
}