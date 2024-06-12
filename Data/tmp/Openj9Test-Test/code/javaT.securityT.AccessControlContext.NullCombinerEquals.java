public class NullCombinerEquals {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.securityT.AccessControlContext.NullCombinerEquals nce = new javaT.securityT.AccessControlContext.NullCombinerEquals();
		try {
			nce.go();
		} catch (java.lang.Exception e) {
			throw new java.lang.Exception("Test Failed: " + e.toString());
		}
	}

	void go() throws java.lang.Exception {
		java.security.AccessControlContext acc = java.security.AccessController.getContext();
		acc.equals(acc);
		java.security.AccessControlContext acc2 = new java.security.AccessControlContext(acc, new javaT.securityT.AccessControlContext.NullCombinerEquals.DC());
		acc.equals(acc2);
		acc2.equals(acc);
		java.security.AccessControlContext acc3 = new java.security.AccessControlContext(acc, new javaT.securityT.AccessControlContext.NullCombinerEquals.DC());
		acc2.equals(acc3);
	}

	private static class DC implements java.security.DomainCombiner {
		public java.security.ProtectionDomain[] combine(java.security.ProtectionDomain[] a, java.security.ProtectionDomain[] b) {
			return a;
		}
	}
}