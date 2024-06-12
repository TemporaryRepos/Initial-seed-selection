public class CheckSomeClass {
	public static void main(java.lang.String[] args) {
		org.mutabilitydetector.CheckSomeClass.checkClass(org.mutabilitydetector.CheckSomeClass.IAmImmutable.class);
		org.mutabilitydetector.CheckSomeClass.checkClass(org.mutabilitydetector.CheckSomeClass.ComposedOfImmutables.class);
	}

	private static void checkClass(java.lang.Class<?> toAnalyse) {
		com.google.classpath.ClassPath cp = new com.google.classpath.ClassPathFactory().createFromJVM();
		java.lang.String match = toAnalyse.getName().replace("$", "\\$");
		org.mutabilitydetector.cli.BatchAnalysisOptions options = new org.mutabilitydetector.cli.CommandLineOptions(java.lang.System.err, "-verbose", "-match", match);
		new org.mutabilitydetector.cli.RunMutabilityDetector(cp, options, new org.mutabilitydetector.cli.NamesFromClassResources(options.match())).run();
	}

	public class IAmImmutable {
		private java.lang.String label;

		public IAmImmutable(java.lang.String label) {
			this.label = label;
		}

		public java.lang.String getLabel() {
			return this.label;
		}
	}

	public static class SecondImmutable {
		private java.lang.String label;

		public SecondImmutable(java.lang.String label) {
			this.label = label;
		}

		public java.lang.String getLabel() {
			return this.label;
		}
	}

	public class ComposedOfImmutables {
		public final org.mutabilitydetector.CheckSomeClass.IAmImmutable firstField;

		public final org.mutabilitydetector.CheckSomeClass.SecondImmutable secondField;

		public ComposedOfImmutables(org.mutabilitydetector.CheckSomeClass.IAmImmutable first, org.mutabilitydetector.CheckSomeClass.SecondImmutable second) {
			firstField = first;
			secondField = second;
		}
	}
}