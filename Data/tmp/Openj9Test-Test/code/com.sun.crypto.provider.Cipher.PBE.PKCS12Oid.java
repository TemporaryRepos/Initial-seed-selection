public class PKCS12Oid {
	private static java.lang.String OID_PKCS12 = "1.2.840.113549.1.12.1.";

	private static java.lang.String OID_PBEWithSHAAnd128BitRC4 = com.sun.crypto.provider.Cipher.PBE.PKCS12Oid.OID_PKCS12 + "1";

	private static java.lang.String OID_PBEWithSHAAnd40BitRC4 = com.sun.crypto.provider.Cipher.PBE.PKCS12Oid.OID_PKCS12 + "2";

	private static java.lang.String OID_PBEWithSHAAnd3KeyTripleDESCBC = com.sun.crypto.provider.Cipher.PBE.PKCS12Oid.OID_PKCS12 + "3";

	private static java.lang.String OID_PBEWithSHAAnd128BitRC2CBC = com.sun.crypto.provider.Cipher.PBE.PKCS12Oid.OID_PKCS12 + "5";

	private static java.lang.String OID_PBEWithSHAAnd40BitRC2CBC = com.sun.crypto.provider.Cipher.PBE.PKCS12Oid.OID_PKCS12 + "6";

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance(com.sun.crypto.provider.Cipher.PBE.PKCS12Oid.OID_PBEWithSHAAnd40BitRC2CBC, "SunJCE");
		c = javax.crypto.Cipher.getInstance(com.sun.crypto.provider.Cipher.PBE.PKCS12Oid.OID_PBEWithSHAAnd3KeyTripleDESCBC, "SunJCE");
		c = javax.crypto.Cipher.getInstance(com.sun.crypto.provider.Cipher.PBE.PKCS12Oid.OID_PBEWithSHAAnd128BitRC4, "SunJCE");
		c = javax.crypto.Cipher.getInstance(com.sun.crypto.provider.Cipher.PBE.PKCS12Oid.OID_PBEWithSHAAnd40BitRC4, "SunJCE");
		c = javax.crypto.Cipher.getInstance(com.sun.crypto.provider.Cipher.PBE.PKCS12Oid.OID_PBEWithSHAAnd128BitRC2CBC, "SunJCE");
		java.lang.System.out.println("All tests passed");
	}
}