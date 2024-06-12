public class CheckVMID {
	public static void main(java.lang.String[] args) {
		java.lang.System.err.println("\nRegression test for bug 4171370\n");
		javaT.rmi.testlibrary.TestLibrary.suggestSecurityManager(null);
		try {
			java.lang.System.err.println("Create a VMID");
			java.rmi.dgc.VMID vmid = new java.rmi.dgc.VMID();
			java.lang.System.err.println("vmid = " + vmid);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			throw new java.lang.RuntimeException("TEST FAILED: " + e.toString());
		}
	}
}