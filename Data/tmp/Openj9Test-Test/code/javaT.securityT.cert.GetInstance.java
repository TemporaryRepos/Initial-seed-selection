public class GetInstance {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.cert.CollectionCertStoreParameters ccsp = new java.security.cert.CollectionCertStoreParameters(new java.util.ArrayList());
		try {
			java.security.cert.CertStore cs = java.security.cert.CertStore.getInstance("LDAP", ccsp);
			throw new java.lang.Exception("CertStore.getInstance() should have thrown " + "InvalidAlgorithmParameterException");
		} catch (java.security.InvalidAlgorithmParameterException iape) {
		}
		try {
			java.security.cert.CertStore cs = java.security.cert.CertStore.getInstance("BOGUS", null);
			throw new java.lang.Exception("CertStore.getInstance() should have thrown " + "NoSuchAlgorithmException");
		} catch (java.security.NoSuchAlgorithmException nsae) {
		}
		try {
			java.security.cert.CertPathBuilder cpb = java.security.cert.CertPathBuilder.getInstance("BOGUS");
			throw new java.lang.Exception("CertPathBuilder.getInstance() should have " + "thrown NoSuchAlgorithmException");
		} catch (java.security.NoSuchAlgorithmException nsae) {
		}
		try {
			java.security.cert.CertPathValidator cpv = java.security.cert.CertPathValidator.getInstance("BOGUS");
			throw new java.lang.Exception("CertPathValidator.getInstance() should have " + "thrown NoSuchAlgorithmException");
		} catch (java.security.NoSuchAlgorithmException nsae) {
		}
		try {
			java.security.cert.CertificateFactory cf = java.security.cert.CertificateFactory.getInstance("BOGUS");
			throw new java.lang.Exception("CertificateFactory.getInstance() should " + "have thrown CertificateException");
		} catch (java.security.cert.CertificateException ce) {
		}
	}
}