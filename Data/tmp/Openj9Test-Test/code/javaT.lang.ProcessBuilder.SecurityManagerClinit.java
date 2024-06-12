public class SecurityManagerClinit {
	private static class Policy extends java.security.Policy {
		private java.security.Permissions perms;

		public Policy(java.security.Permission... permissions) {
			perms = new java.security.Permissions();
			for (java.security.Permission permission : permissions) {
				perms.add(permission);
			}
		}

		public boolean implies(java.security.ProtectionDomain pd, java.security.Permission p) {
			return perms.implies(p);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		java.lang.String javaExe = (((java.lang.System.getProperty("java.home") + java.io.File.separator) + "bin") + java.io.File.separator) + "java";
		final javaT.lang.ProcessBuilder.SecurityManagerClinit.Policy policy = new javaT.lang.ProcessBuilder.SecurityManagerClinit.Policy(new java.io.FilePermission("<<ALL FILES>>", "execute"), new java.lang.RuntimePermission("setSecurityManager"));
		javaT.lang.ProcessBuilder.SecurityManagerClinit.Policy.setPolicy(policy);
		java.lang.System.setSecurityManager(new java.lang.SecurityManager());
		try {
			java.lang.String[] cmd = new java.lang.String[]{ javaExe, "-version" };
			java.lang.Process p = java.lang.Runtime.getRuntime().exec(cmd);
			p.getOutputStream().close();
			p.getInputStream().close();
			p.getErrorStream().close();
			p.waitFor();
		} finally {
			java.lang.System.setSecurityManager(null);
		}
	}
}