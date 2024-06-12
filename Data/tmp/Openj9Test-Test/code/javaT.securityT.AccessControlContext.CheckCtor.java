public class CheckCtor {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			new java.security.AccessControlContext(null);
			throw new java.lang.Exception("Expected NullPointerException not thrown");
		} catch (java.lang.Exception e) {
			if (!(e instanceof java.lang.NullPointerException)) {
				throw new java.lang.Exception("Expected NullPointerException not thrown");
			}
		}
		java.security.ProtectionDomain[] zero = new java.security.ProtectionDomain[]{  };
		java.security.ProtectionDomain[] null1 = new java.security.ProtectionDomain[]{ null };
		java.security.ProtectionDomain[] null2 = new java.security.ProtectionDomain[]{ null, null };
		java.security.AccessControlContext accZero = new java.security.AccessControlContext(zero);
		java.security.AccessControlContext accNull1 = new java.security.AccessControlContext(null1);
		java.security.AccessControlContext accNull2 = new java.security.AccessControlContext(null2);
		javaT.securityT.AccessControlContext.CheckCtor.testEquals(accZero, accNull1);
		javaT.securityT.AccessControlContext.CheckCtor.testEquals(accZero, accNull2);
		javaT.securityT.AccessControlContext.CheckCtor.testEquals(accNull1, accNull2);
		javaT.securityT.AccessControlContext.CheckCtor.testEquals(accNull1, accZero);
		javaT.securityT.AccessControlContext.CheckCtor.testEquals(accNull2, accZero);
		javaT.securityT.AccessControlContext.CheckCtor.testEquals(accNull2, accNull1);
	}

	private static void testEquals(java.security.AccessControlContext acc1, java.security.AccessControlContext acc2) throws java.lang.Exception {
		if (!acc1.equals(acc2)) {
			throw new java.lang.Exception("AccessControlContexts should be equal");
		}
	}
}