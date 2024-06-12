public class Main {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		final java.util.Properties fp = new java.util.Properties();
		final java.io.InputStream ras = org.apache.commons.net.examples.Main.class.getResourceAsStream("examples.properties");
		if (ras != null) {
			fp.load(ras);
		} else {
			java.lang.System.err.println("[Cannot find examples.properties file, so aliases cannot be used]");
		}
		if (args.length == 0) {
			if (java.lang.Thread.currentThread().getStackTrace().length > 2) {
				java.lang.System.out.println("Usage: mvn -q exec:java  -Dexec.arguments=<alias or" + " exampleClass>,<exampleClass parameters> (comma-separated, no spaces)");
				java.lang.System.out.println("Or   : mvn -q exec:java  -Dexec.args=\"<alias" + " or exampleClass> <exampleClass parameters>\" (space separated)");
			} else if (org.apache.commons.net.examples.Main.fromJar()) {
				java.lang.System.out.println("Usage: java -jar commons-net-examples-m.n.jar <alias or exampleClass> <exampleClass parameters>");
			} else {
				java.lang.System.out.println("Usage: java -cp target/classes examples/Main <alias or exampleClass> <exampleClass parameters>");
			}
			@java.lang.SuppressWarnings("unchecked")
			java.util.List<java.lang.String> l = ((java.util.List<java.lang.String>) (java.util.Collections.list(fp.propertyNames())));
			if (l.isEmpty()) {
				return;
			}
			java.util.Collections.sort(l);
			java.lang.System.out.println("\nAliases and their classes:");
			for (java.lang.String s : l) {
				java.lang.System.out.printf("%-25s %s%n", s, fp.getProperty(s));
			}
			return;
		}
		java.lang.String shortName = args[0];
		java.lang.String fullName = fp.getProperty(shortName);
		if (fullName == null) {
			fullName = shortName;
		}
		fullName = fullName.replace('/', '.');
		try {
			java.lang.Class<?> clazz = java.lang.Class.forName(fullName);
			java.lang.reflect.Method m = clazz.getDeclaredMethod("main", new java.lang.Class[]{ args.getClass() });
			java.lang.String[] args2 = new java.lang.String[args.length - 1];
			java.lang.System.arraycopy(args, 1, args2, 0, args2.length);
			try {
				m.invoke(null, ((java.lang.Object) (args2)));
			} catch (java.lang.reflect.InvocationTargetException ite) {
				java.lang.Throwable cause = ite.getCause();
				if (cause != null) {
					throw cause;
				} else {
					throw ite;
				}
			}
		} catch (java.lang.ClassNotFoundException e) {
			java.lang.System.out.println(e);
		}
	}

	private static boolean fromJar() {
		final java.security.CodeSource codeSource = org.apache.commons.net.examples.Main.class.getProtectionDomain().getCodeSource();
		if (codeSource != null) {
			return codeSource.getLocation().getFile().endsWith(".jar");
		}
		return false;
	}
}