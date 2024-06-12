public class CheckUsage {
	public static void main(java.lang.String[] args) {
		try {
			java.io.ByteArrayOutputStream berr = new java.io.ByteArrayOutputStream();
			javaT.rmi.testlibrary.JavaVM registryVM = new javaT.rmi.testlibrary.JavaVM("sun.rmi.registry.RegistryImpl", "", "foo", java.lang.System.out, berr);
			java.lang.System.err.println("starting registry");
			java.lang.System.err.println(" registry exited with status: " + registryVM.execute());
			java.lang.String usage = new java.lang.String(berr.toByteArray());
			java.lang.System.err.println("rmiregistry usage: " + usage);
			if (usage.indexOf("-J") < 0) {
				javaT.rmi.testlibrary.TestLibrary.bomb("rmiregistry has incorrect usage statement");
			} else {
				java.lang.System.err.println("test passed");
			}
		} catch (java.lang.Exception e) {
			javaT.rmi.testlibrary.TestLibrary.bomb(e);
		}
	}
}