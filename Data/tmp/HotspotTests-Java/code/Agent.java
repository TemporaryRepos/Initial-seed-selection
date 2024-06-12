class Agent implements java.lang.instrument.ClassFileTransformer {
	private static java.lang.Runnable lambda = () -> {
		java.lang.System.out.println("I'll crash you!");
	};

	public static void premain(java.lang.String args, java.lang.instrument.Instrumentation instrumentation) {
		if (!instrumentation.isRetransformClassesSupported()) {
			java.lang.System.out.println("Class retransformation is not supported.");
			return;
		}
		java.lang.System.out.println("Calling lambda to ensure that lambda forms were created");
		Agent.lambda.run();
		java.lang.System.out.println("Registering class file transformer");
		instrumentation.addTransformer(new Agent());
		for (java.lang.Class c : instrumentation.getAllLoadedClasses()) {
			if (c.getName().contains("LambdaForm") && instrumentation.isModifiableClass(c)) {
				java.lang.System.out.format("We've found a modifiable lambda form: %s%n", c.getName());
				try {
					instrumentation.retransformClasses(c);
				} catch (java.lang.instrument.UnmodifiableClassException e) {
					throw new java.lang.AssertionError("Modification of modifiable class " + "caused UnmodifiableClassException", e);
				}
			}
		}
	}

	public static void main(java.lang.String[] args) {
	}

	@java.lang.Override
	public byte[] transform(java.lang.ClassLoader loader, java.lang.String className, java.lang.Class<?> classBeingRedefined, java.security.ProtectionDomain protectionDomain, byte[] classfileBuffer) throws java.lang.instrument.IllegalClassFormatException {
		java.lang.System.out.println("Transforming " + className);
		return classfileBuffer.clone();
	}
}