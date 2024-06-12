public class GetLocalHostWithSM {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.net.InetAddress localHost = java.net.InetAddress.getLocalHost();
		if (localHost.isLoopbackAddress()) {
			java.lang.System.err.println("Local host name is resolved into a loopback address. Quit now!");
			return;
		}
		java.lang.System.setProperty("host.name", localHost.getHostName());
		java.lang.String policyFileName = (java.lang.System.getProperty("test.src", ".") + "/") + "policy.file";
		java.lang.System.setProperty("java.security.policy", policyFileName);
		java.lang.System.setSecurityManager(new java.lang.SecurityManager());
		java.net.InetAddress localHost1 = null;
		java.net.InetAddress localHost2 = null;
		localHost1 = java.net.InetAddress.getLocalHost();
		javax.security.auth.Subject mySubject = new javax.security.auth.Subject();
		javaT.net.InetAddress.MyPrincipal userPrincipal = new javaT.net.InetAddress.MyPrincipal("test");
		mySubject.getPrincipals().add(userPrincipal);
		localHost2 = ((java.net.InetAddress) (javax.security.auth.Subject.doAsPrivileged(mySubject, new javaT.net.InetAddress.MyAction(), null)));
		if (localHost1.equals(localHost2)) {
			java.lang.System.out.println("localHost1 = " + localHost1);
			throw new java.lang.RuntimeException(("InetAddress.getLocalHost() test " + ((" fails. localHost2 should be " + " the real address instead of ") + " the loopback address.")) + localHost2);
		}
	}
}