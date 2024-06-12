public class PreserveCombiner {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javax.security.auth.Subject s = new javax.security.auth.Subject();
		s.getPrincipals().add(new javax.security.auth.x500.X500Principal("cn=duke"));
		java.lang.String result = ((java.lang.String) (javax.security.auth.Subject.doAs(s, new java.security.PrivilegedAction() {
			public java.lang.Object run() {
				javax.security.auth.Subject doAsSubject = javax.security.auth.Subject.getSubject(java.security.AccessController.getContext());
				if (doAsSubject == null) {
					return "test 1 failed";
				} else {
					java.lang.System.out.println(doAsSubject);
					java.lang.System.out.println("test 1 passed");
				}
				java.lang.String result = java.security.AccessController.doPrivilegedWithCombiner(new java.security.PrivilegedAction<java.lang.String>() {
					public java.lang.String run() {
						javax.security.auth.Subject doPrivSubject = javax.security.auth.Subject.getSubject(java.security.AccessController.getContext());
						if (doPrivSubject == null) {
							return "test 2 failed";
						} else {
							java.lang.System.out.println(doPrivSubject);
							return "test 2 passed";
						}
					}
				});
				if ("test 2 failed".equals(result)) {
					return result;
				} else {
					java.lang.System.out.println(result);
				}
				try {
					result = java.security.AccessController.doPrivilegedWithCombiner(new java.security.PrivilegedExceptionAction<java.lang.String>() {
						public java.lang.String run() throws java.security.PrivilegedActionException {
							javax.security.auth.Subject doPrivSubject = javax.security.auth.Subject.getSubject(java.security.AccessController.getContext());
							if (doPrivSubject == null) {
								return "test 3 failed";
							} else {
								java.lang.System.out.println(doPrivSubject);
								return "test 3 passed";
							}
						}
					});
				} catch (java.security.PrivilegedActionException pae) {
					result = "test 3 failed";
				}
				if ("test 3 failed".equals(result)) {
					return result;
				} else {
					java.lang.System.out.println(result);
				}
				return result;
			}
		})));
		if (result.indexOf("passed") <= 0) {
			throw new java.lang.SecurityException("overall test failed");
		}
	}
}