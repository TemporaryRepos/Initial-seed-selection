public class LimitedDoPrivileged {
	private static final java.security.ProtectionDomain domain = new java.security.ProtectionDomain(null, null, null, null);

	private static final java.security.AccessControlContext acc = new java.security.AccessControlContext(new java.security.ProtectionDomain[]{ javaT.securityT.AccessController.LimitedDoPrivileged.domain });

	private static final java.util.PropertyPermission pathPerm = new java.util.PropertyPermission("path.separator", "read");

	private static final java.util.PropertyPermission filePerm = new java.util.PropertyPermission("file.separator", "read");

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.AccessController.getContext().checkPermission(javaT.securityT.AccessController.LimitedDoPrivileged.filePerm);
		java.security.AccessController.getContext().checkPermission(javaT.securityT.AccessController.LimitedDoPrivileged.pathPerm);
		java.lang.System.out.println("test 1 passed");
		java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {
			public java.lang.Object run() {
				try {
					java.security.AccessController.getContext().checkPermission(javaT.securityT.AccessController.LimitedDoPrivileged.pathPerm);
				} catch (java.security.AccessControlException ace) {
					java.lang.System.out.println("test 2 passed");
				}
				java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {
					public java.lang.Object run() {
						java.security.AccessController.getContext().checkPermission(javaT.securityT.AccessController.LimitedDoPrivileged.pathPerm);
						return null;
					}
				}, null, new java.util.PropertyPermission("path.*", "read"));
				java.lang.System.out.println("test 3 passed");
				try {
					java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {
						public java.lang.Object run() {
							java.security.AccessController.getContext().checkPermission(javaT.securityT.AccessController.LimitedDoPrivileged.filePerm);
							return null;
						}
					}, null, new java.util.PropertyPermission("path.*", "read"));
				} catch (java.security.AccessControlException ace) {
					java.lang.System.out.println("test 4 passed");
				}
				final java.security.AccessControlContext context = java.security.AccessController.getContext();
				try {
					java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {
						public java.lang.Object run() {
							java.security.AccessController.getContext().checkPermission(javaT.securityT.AccessController.LimitedDoPrivileged.pathPerm);
							return null;
						}
					}, context, new java.util.PropertyPermission("path.*", "read"));
				} catch (java.security.AccessControlException ace) {
					java.lang.System.out.println("test 5 passed");
				}
				java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {
					public java.lang.Object run() {
						java.security.AccessController.getContext().checkPermission(javaT.securityT.AccessController.LimitedDoPrivileged.pathPerm);
						return null;
					}
				});
				java.lang.System.out.println("test 6 passed");
				try {
					java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {
						public java.lang.Object run() {
							java.security.AccessController.getContext().checkPermission(javaT.securityT.AccessController.LimitedDoPrivileged.pathPerm);
							return null;
						}
					}, context);
				} catch (java.security.AccessControlException ace) {
					java.lang.System.out.println("test 7 passed");
				}
				java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {
					public java.lang.Object run() {
						final java.security.AccessControlContext limitedContext = java.security.AccessController.getContext();
						java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {
							public java.lang.Object run() {
								java.security.AccessController.getContext().checkPermission(javaT.securityT.AccessController.LimitedDoPrivileged.pathPerm);
								return null;
							}
						}, limitedContext);
						return null;
					}
				}, null, new java.util.PropertyPermission("path.*", "read"));
				java.lang.System.out.println("test 8 passed");
				java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {
					public java.lang.Object run() {
						final java.security.AccessControlContext limitedContext = java.security.AccessController.getContext();
						try {
							java.security.AccessController.doPrivileged(new java.security.PrivilegedAction() {
								public java.lang.Object run() {
									java.security.AccessController.getContext().checkPermission(javaT.securityT.AccessController.LimitedDoPrivileged.filePerm);
									return null;
								}
							}, limitedContext);
						} catch (java.security.AccessControlException ace) {
							java.lang.System.out.println("test 9 passed");
						}
						return null;
					}
				}, null, new java.util.PropertyPermission("path.*", "read"));
				return null;
			}
		}, javaT.securityT.AccessController.LimitedDoPrivileged.acc);
	}
}