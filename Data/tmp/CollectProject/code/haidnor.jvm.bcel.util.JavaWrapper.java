public class JavaWrapper {
	private final java.lang.ClassLoader loader;

	public JavaWrapper() {
		this(haidnor.jvm.bcel.util.JavaWrapper.getClassLoader());
	}

	public JavaWrapper(final java.lang.ClassLoader loader) {
		this.loader = loader;
	}

	private static java.lang.ClassLoader getClassLoader() {
		final java.lang.String s = java.lang.System.getProperty("bcel.classloader");
		if (org.apache.commons.lang3.StringUtils.isEmpty(s)) {
			throw new java.lang.IllegalStateException("The property 'bcel.classloader' must be defined");
		}
		try {
			return ((java.lang.ClassLoader) (java.lang.Class.forName(s).newInstance()));
		} catch (final java.lang.Exception e) {
			throw new java.lang.IllegalStateException(e.toString(), e);
		}
	}

	public static void main(final java.lang.String[] argv) throws java.lang.Exception {
		if (argv.length == 0) {
			java.lang.System.out.println("Missing class name.");
			return;
		}
		final java.lang.String className = argv[0];
		final java.lang.String[] newArgv = new java.lang.String[argv.length - 1];
		java.lang.System.arraycopy(argv, 1, newArgv, 0, newArgv.length);
		new haidnor.jvm.bcel.util.JavaWrapper().runMain(className, newArgv);
	}

	public void runMain(final java.lang.String className, final java.lang.String[] argv) throws java.lang.ClassNotFoundException {
		final java.lang.Class<?> cl = loader.loadClass(className);
		java.lang.reflect.Method method = null;
		try {
			method = cl.getMethod("main", argv.getClass());
			final int m = method.getModifiers();
			final java.lang.Class<?> r = method.getReturnType();
			if (((!(java.lang.reflect.Modifier.isPublic(m) && java.lang.reflect.Modifier.isStatic(m))) || java.lang.reflect.Modifier.isAbstract(m)) || (r != java.lang.Void.TYPE)) {
				throw new java.lang.NoSuchMethodException();
			}
		} catch (final java.lang.NoSuchMethodException no) {
			java.lang.System.out.println(("In class " + className) + ": public static void main(String[] argv) is not defined");
			return;
		}
		try {
			method.invoke(null, ((java.lang.Object[]) (argv)));
		} catch (final java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}
}