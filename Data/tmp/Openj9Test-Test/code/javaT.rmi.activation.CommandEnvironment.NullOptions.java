public class NullOptions {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.rmi.activation.ActivationGroupDesc.CommandEnvironment env1 = new java.rmi.activation.ActivationGroupDesc.CommandEnvironment(null, null);
		java.rmi.activation.ActivationGroupDesc.CommandEnvironment env2 = new java.rmi.activation.ActivationGroupDesc.CommandEnvironment(null, new java.lang.String[0]);
		if (env1.equals(env2)) {
			java.lang.System.err.println("TEST PASSED: environments are equal");
		} else {
			java.lang.System.err.println("TEST FAILED: environments not equal!");
			throw new java.lang.RuntimeException("TEST FAILED");
		}
	}
}