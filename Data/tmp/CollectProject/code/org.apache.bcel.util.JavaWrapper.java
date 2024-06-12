public class JavaWrapper {
	private final java.lang.ClassLoader loader;

	private static java.lang.ClassLoader getClassLoader() {
		final java.lang.String s = java.lang.System.getProperty("bcel.classloader");
		if ((s == null) || "".equals(s)) {
			throw new java.lang.IllegalArgumentException("The property 'bcel.classloader' must be defined");
		}
		try {
			return ((java.lang.ClassLoader) (java.lang.Class.forName(s).newInstance()));
		} catch (final java.lang.Exception e) {
			throw new java.lang.RuntimeException(e.toString(), e);
		}
	}

	public JavaWrapper(final java.lang.ClassLoader loader) {
		this.loader = loader;
	}

	public JavaWrapper() {
		this(org.apache.bcel.util.JavaWrapper.getClassLoader());
	}

	public void runMain(final java.lang.String class_name, final java.lang.String[] argv) throws java.lang.ClassNotFoundException {
		final java.lang.Class<?> cl = loader.loadClass(class_name);
		java.lang.reflect.Method method = null;
		try {
			method = cl.getMethod("main", new java.lang.Class[]{ argv.getClass() });
			final int m = method.getModifiers();
			final java.lang.Class<?> r = method.getReturnType();
			if (((!(java.lang.reflect.Modifier.isPublic(m) && java.lang.reflect.Modifier.isStatic(m))) || java.lang.reflect.Modifier.isAbstract(m)) || (r != java.lang.Void.TYPE)) {
				throw new java.lang.NoSuchMethodException();
			}
		} catch (final java.lang.NoSuchMethodException no) {
			java.lang.System.out.println(("In class " + class_name) + ": public static void main(String[] argv) is not defined");
			return;
		}
		try {
			method.invoke(null, new java.lang.Object[]{ argv });
		} catch (final java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(final java.lang.String[] argv) throws java.lang.Exception {
		if (argv.length == 0) {
			java.lang.System.out.println("Missing class name.");
			return;
		}
		final java.lang.String class_name = argv[0];
		final java.lang.String[] new_argv = new java.lang.String[argv.length - 1];
		java.lang.System.arraycopy(argv, 1, new_argv, 0, new_argv.length);
		final org.apache.bcel.util.JavaWrapper wrapper = new org.apache.bcel.util.JavaWrapper();
		wrapper.runMain(class_name, new_argv);
	}
}