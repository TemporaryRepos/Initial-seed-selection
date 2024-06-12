public class TestBootNativeLibraryPath {
	private static final java.lang.String TESTFILE = "Test6";

	static void createTestClass() throws java.io.IOException {
		java.io.FileOutputStream fos = new java.io.FileOutputStream(TestBootNativeLibraryPath.TESTFILE + ".java");
		java.io.PrintStream ps = new java.io.PrintStream(fos);
		ps.println(("public class " + TestBootNativeLibraryPath.TESTFILE) + "{");
		ps.println("public static void main(String[] args) {\n");
		ps.println("System.out.println(System.getProperty(\"sun.boot.library.path\"));\n");
		ps.println("}}\n");
		ps.close();
		fos.close();
		javax.tools.JavaCompiler javac = javax.tools.ToolProvider.getSystemJavaCompiler();
		java.lang.String[] javacOpts = new java.lang.String[]{ TestBootNativeLibraryPath.TESTFILE + ".java" };
		if (javac.run(null, null, null, javacOpts) != 0) {
			throw new java.lang.RuntimeException(("compilation of " + TestBootNativeLibraryPath.TESTFILE) + ".java Failed");
		}
	}

	static java.util.List<java.lang.String> doExec(java.lang.String... args) {
		java.lang.String javaCmd = java.lang.System.getProperty("java.home") + "/bin/java";
		if (!new java.io.File(javaCmd).exists()) {
			javaCmd = java.lang.System.getProperty("java.home") + "/bin/java.exe";
		}
		java.util.ArrayList<java.lang.String> cmds = new java.util.ArrayList<java.lang.String>();
		cmds.add(javaCmd);
		for (java.lang.String x : args) {
			cmds.add(x);
		}
		java.lang.System.out.println("cmds=" + cmds);
		java.lang.ProcessBuilder pb = new java.lang.ProcessBuilder(cmds);
		java.util.Map<java.lang.String, java.lang.String> env = pb.environment();
		pb.directory(new java.io.File("."));
		java.util.List<java.lang.String> out = new java.util.ArrayList<java.lang.String>();
		try {
			pb.redirectErrorStream(true);
			java.lang.Process p = pb.start();
			java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()), 8192);
			java.lang.String in = rd.readLine();
			while (in != null) {
				out.add(in);
				java.lang.System.out.println(in);
				in = rd.readLine();
			} 
			int retval = p.waitFor();
			p.destroy();
			if (retval != 0) {
				throw new java.lang.RuntimeException("Error: test returned non-zero value");
			}
			return out;
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new java.lang.RuntimeException(ex.getMessage());
		}
	}

	public static void main(java.lang.String[] args) {
		try {
			if (!java.lang.System.getProperty("sun.arch.data.model").equals("32")) {
				java.lang.System.out.println("Warning: test skipped for 64-bit systems\n");
				return;
			}
			java.lang.String osname = java.lang.System.getProperty("os.name");
			if (osname.startsWith("Windows")) {
				osname = "Windows";
			}
			TestBootNativeLibraryPath.createTestClass();
			java.lang.String libpath = ((java.io.File.pathSeparator + "tmp") + java.io.File.pathSeparator) + "foobar";
			java.util.List<java.lang.String> processOut = null;
			java.lang.String sunbootlibrarypath = "-Dsun.boot.library.path=" + libpath;
			processOut = TestBootNativeLibraryPath.doExec(sunbootlibrarypath, "-cp", ".", TestBootNativeLibraryPath.TESTFILE);
			if ((processOut == null) || (!processOut.get(0).endsWith(libpath))) {
				throw new java.lang.RuntimeException("Error: did not get expected error string");
			}
		} catch (java.io.IOException ex) {
			throw new java.lang.RuntimeException("Unexpected error " + ex);
		}
	}
}