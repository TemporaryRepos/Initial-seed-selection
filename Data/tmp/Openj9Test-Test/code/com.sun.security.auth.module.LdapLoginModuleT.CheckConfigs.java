public class CheckConfigs {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
		java.lang.System.out.println(securityManager == null ? "[security manager is not running]" : ("[security manager is running: " + securityManager.getClass().getName()) + "]");
		com.sun.security.auth.module.LdapLoginModuleT.CheckConfigs.init();
		com.sun.security.auth.module.LdapLoginModuleT.CheckConfigs.checkConfigModes();
	}

	private static void init() throws java.lang.Exception {
	}

	private static void checkConfigModes() throws java.lang.Exception {
		javax.security.auth.login.LoginContext ldapLogin;
		java.lang.System.out.println("Testing search-first mode...");
		try {
			ldapLogin = new javax.security.auth.login.LoginContext(com.sun.security.auth.module.LdapLoginModuleT.LdapConfiguration.LOGIN_CONFIG_NAME, null, new com.sun.security.auth.module.LdapLoginModuleT.CheckConfigs.TestCallbackHandler(), new com.sun.security.auth.module.LdapLoginModuleT.SearchFirstMode());
			ldapLogin.login();
			throw new java.lang.SecurityException("expected a LoginException");
		} catch (javax.security.auth.login.LoginException le) {
			if (!(le.getCause() instanceof javax.naming.CommunicationException)) {
				throw le;
			}
		}
		java.lang.System.out.println("\nTesting authentication-first mode...");
		try {
			ldapLogin = new javax.security.auth.login.LoginContext(com.sun.security.auth.module.LdapLoginModuleT.LdapConfiguration.LOGIN_CONFIG_NAME, null, new com.sun.security.auth.module.LdapLoginModuleT.CheckConfigs.TestCallbackHandler(), new com.sun.security.auth.module.LdapLoginModuleT.AuthFirstMode());
			ldapLogin.login();
			throw new java.lang.SecurityException("expected a LoginException");
		} catch (javax.security.auth.login.LoginException le) {
			if (!(le.getCause() instanceof javax.naming.CommunicationException)) {
				throw le;
			}
		}
		java.lang.System.out.println("\nTesting authentication-only mode...");
		try {
			ldapLogin = new javax.security.auth.login.LoginContext(com.sun.security.auth.module.LdapLoginModuleT.LdapConfiguration.LOGIN_CONFIG_NAME, null, new com.sun.security.auth.module.LdapLoginModuleT.CheckConfigs.TestCallbackHandler(), new com.sun.security.auth.module.LdapLoginModuleT.AuthOnlyMode());
			ldapLogin.login();
			throw new java.lang.SecurityException("expected a LoginException");
		} catch (javax.security.auth.login.LoginException le) {
			if (!(le.getCause() instanceof javax.naming.CommunicationException)) {
				throw le;
			}
		}
	}

	private static class TestCallbackHandler implements javax.security.auth.callback.CallbackHandler {
		public void handle(javax.security.auth.callback.Callback[] callbacks) throws java.io.IOException, javax.security.auth.callback.UnsupportedCallbackException {
			for (int i = 0; i < callbacks.length; i++) {
				if (callbacks[i] instanceof javax.security.auth.callback.NameCallback) {
					((javax.security.auth.callback.NameCallback) (callbacks[i])).setName("myname");
				} else if (callbacks[i] instanceof javax.security.auth.callback.PasswordCallback) {
					((javax.security.auth.callback.PasswordCallback) (callbacks[i])).setPassword("mypassword".toCharArray());
				} else {
					throw new javax.security.auth.callback.UnsupportedCallbackException(callbacks[i], "Unrecognized callback");
				}
			}
		}
	}
}