public class CertStoreConstructorParam {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.security.cert.CertStore.getInstance("Collection", null, "SUN");
		} catch (java.security.InvalidAlgorithmParameterException iape) {
			java.lang.System.out.println("test passed");
		} catch (java.security.NoSuchAlgorithmException nsae) {
			java.lang.System.out.println("test failed");
			throw nsae;
		}
	}
}