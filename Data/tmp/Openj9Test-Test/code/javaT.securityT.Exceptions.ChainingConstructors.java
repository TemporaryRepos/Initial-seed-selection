public class ChainingConstructors {
	private static final java.lang.String MSG = "msg";

	private static java.lang.Exception cause = new java.lang.Exception("cause");

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.SecurityException se = new java.lang.SecurityException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!se.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 1 failed");
		}
		se = new java.lang.SecurityException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!se.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!se.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 1 failed");
		}
		java.security.DigestException de = new java.security.DigestException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!de.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 2 failed");
		}
		de = new java.security.DigestException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!de.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!de.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 2 failed");
		}
		java.security.GeneralSecurityException gse = new java.security.GeneralSecurityException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!gse.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 3 failed");
		}
		gse = new java.security.GeneralSecurityException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!gse.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!gse.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 3 failed");
		}
		java.security.InvalidAlgorithmParameterException iape = new java.security.InvalidAlgorithmParameterException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!iape.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 4 failed");
		}
		iape = new java.security.InvalidAlgorithmParameterException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!iape.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!iape.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 4 failed");
		}
		java.security.InvalidKeyException ike = new java.security.InvalidKeyException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!ike.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 5 failed");
		}
		ike = new java.security.InvalidKeyException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!ike.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!ike.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 5 failed");
		}
		java.security.spec.InvalidKeySpecException ikse = new java.security.spec.InvalidKeySpecException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!ikse.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 6 failed");
		}
		ikse = new java.security.spec.InvalidKeySpecException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!ikse.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!ikse.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 6 failed");
		}
		java.security.KeyException ke = new java.security.KeyException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!ke.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 7 failed");
		}
		ke = new java.security.KeyException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!ke.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!ke.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 7 failed");
		}
		java.security.KeyManagementException kme = new java.security.KeyManagementException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!kme.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 8 failed");
		}
		kme = new java.security.KeyManagementException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!kme.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!kme.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 8 failed");
		}
		java.security.KeyStoreException kse = new java.security.KeyStoreException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!kse.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 9 failed");
		}
		kse = new java.security.KeyStoreException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!kse.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!kse.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 9 failed");
		}
		java.security.NoSuchAlgorithmException nsae = new java.security.NoSuchAlgorithmException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!nsae.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 10 failed");
		}
		nsae = new java.security.NoSuchAlgorithmException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!nsae.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!nsae.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 10 failed");
		}
		java.security.ProviderException pe = new java.security.ProviderException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!pe.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 11 failed");
		}
		pe = new java.security.ProviderException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!pe.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!pe.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 11 failed");
		}
		java.security.SignatureException sige = new java.security.SignatureException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!sige.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 12 failed");
		}
		sige = new java.security.SignatureException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!sige.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!sige.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 12 failed");
		}
		java.security.cert.CRLException crle = new java.security.cert.CRLException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!crle.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 13 failed");
		}
		crle = new java.security.cert.CRLException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!crle.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!crle.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 13 failed");
		}
		java.security.cert.CertificateException ce = new java.security.cert.CertificateException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!ce.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 14 failed");
		}
		ce = new java.security.cert.CertificateException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!ce.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!ce.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 14 failed");
		}
		java.security.cert.CertificateParsingException cpe = new java.security.cert.CertificateParsingException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!cpe.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 15 failed");
		}
		cpe = new java.security.cert.CertificateParsingException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!cpe.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!cpe.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 15 failed");
		}
		java.security.cert.CertificateEncodingException cee = new java.security.cert.CertificateEncodingException(javaT.securityT.Exceptions.ChainingConstructors.cause);
		if (!cee.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause)) {
			throw new java.lang.SecurityException("Test 16 failed");
		}
		cee = new java.security.cert.CertificateEncodingException(javaT.securityT.Exceptions.ChainingConstructors.MSG, javaT.securityT.Exceptions.ChainingConstructors.cause);
		if ((!cee.getMessage().equals(javaT.securityT.Exceptions.ChainingConstructors.MSG)) || (!cee.getCause().equals(javaT.securityT.Exceptions.ChainingConstructors.cause))) {
			throw new java.lang.SecurityException("Test 16 failed");
		}
	}
}