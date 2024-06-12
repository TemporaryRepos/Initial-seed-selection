public class DefaultPKCS11 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String osName = java.lang.System.getProperty("os.name", "(null)");
		java.lang.String osVersion = java.lang.System.getProperty("os.version", "(null)");
		java.lang.System.out.println((("Running on " + osName) + " ") + osVersion);
		java.security.Provider[] ps = java.security.Security.getProviders();
		java.lang.System.out.println("Providers: " + java.util.Arrays.asList(ps));
		java.lang.System.out.println();
		if (osName.equals("SunOS") == false) {
			java.lang.System.out.println("Test only applies to Solaris, skipping");
			return;
		}
		java.lang.String[] v = osVersion.split("\\.");
		if (v.length < 2) {
			throw new java.lang.Exception("Failed to parse Solaris version: " + java.util.Arrays.asList(v));
		}
		if (java.lang.Integer.parseInt(v[0]) != 5) {
			throw new java.lang.Exception("Unknown Solaris major version: " + v[0]);
		}
		if (java.lang.Integer.parseInt(v[1]) < 10) {
			java.lang.System.out.println("Test only applies to Solaris 10 and later, skipping");
			return;
		}
		if ((ps[0].getName().equals("SunPKCS11-Solaris") == false) && (ps[1].getName().equals("SunPKCS11-Solaris") == false)) {
			throw new java.lang.Exception("SunPKCS11-Solaris provider not installed");
		}
		java.lang.System.out.println("OK");
	}
}