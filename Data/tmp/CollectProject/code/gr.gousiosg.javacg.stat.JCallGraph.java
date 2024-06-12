public class JCallGraph {
	public static void main(java.lang.String[] args) {
		java.util.function.Function<org.apache.bcel.classfile.ClassParser, gr.gousiosg.javacg.stat.ClassVisitor> getClassVisitor = (org.apache.bcel.classfile.ClassParser cp) -> {
			try {
				return new gr.gousiosg.javacg.stat.ClassVisitor(cp.parse());
			} catch (java.io.IOException e) {
				throw new java.io.UncheckedIOException(e);
			}
		};
		try {
			for (java.lang.String arg : args) {
				java.io.File f = new java.io.File(arg);
				if (!f.exists()) {
					java.lang.System.err.println(("Jar file " + arg) + " does not exist");
				}
				try (final java.util.jar.JarFile jar = new java.util.jar.JarFile(f)) {
					java.util.stream.Stream<java.util.jar.JarEntry> entries = gr.gousiosg.javacg.stat.JCallGraph.enumerationAsStream(jar.entries());
					java.lang.String methodCalls = entries.flatMap(( e) -> {
						if (e.isDirectory() || (!e.getName().endsWith(".class"))) {
							return new java.util.ArrayList<java.lang.String>().stream();
						}
						org.apache.bcel.classfile.ClassParser cp = new org.apache.bcel.classfile.ClassParser(arg, e.getName());
						return getClassVisitor.apply(cp).start().methodCalls().stream();
					}).map(( s) -> s + "\n").reduce(new java.lang.StringBuilder(), java.lang.StringBuilder::append, java.lang.StringBuilder::append).toString();
					java.io.BufferedWriter log = new java.io.BufferedWriter(new java.io.OutputStreamWriter(java.lang.System.out));
					log.write(methodCalls);
					log.close();
				}
			}
		} catch (java.io.IOException e) {
			java.lang.System.err.println("Error while processing jar: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static <T> java.util.stream.Stream<T> enumerationAsStream(java.util.Enumeration<T> e) {
		return java.util.stream.StreamSupport.stream(java.util.Spliterators.spliteratorUnknownSize(new java.util.Iterator<T>() {
			public T next() {
				return e.nextElement();
			}

			public boolean hasNext() {
				return e.hasMoreElements();
			}
		}, java.util.Spliterator.ORDERED), false);
	}
}