public class DefaultEntryType {
	private static class PrivKey1 implements java.security.PrivateKey {
		public java.lang.String getAlgorithm() {
			return "matching_alg";
		}

		public java.lang.String getFormat() {
			return "privkey1";
		}

		public byte[] getEncoded() {
			return ((byte[]) (null));
		}
	}

	private static class PubKey1 implements java.security.PublicKey {
		public java.lang.String getAlgorithm() {
			return "non_matching_alg";
		}

		public java.lang.String getFormat() {
			return "pubkey1";
		}

		public byte[] getEncoded() {
			return ((byte[]) (null));
		}
	}

	private static class PubKey2 implements java.security.PublicKey {
		public java.lang.String getAlgorithm() {
			return "matching_alg";
		}

		public java.lang.String getFormat() {
			return "pubkey2";
		}

		public byte[] getEncoded() {
			return ((byte[]) (null));
		}
	}

	private static class Cert extends java.security.cert.Certificate {
		public Cert() {
			super("cert");
		}

		public byte[] getEncoded() throws java.security.cert.CertificateEncodingException {
			return ((byte[]) (null));
		}

		public void verify(java.security.PublicKey key) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.NoSuchProviderException, java.security.SignatureException {
		}

		public void verify(java.security.PublicKey key, java.lang.String sigProvider) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.NoSuchProviderException, java.security.SignatureException {
		}

		public java.lang.String toString() {
			return "cert";
		}

		public java.security.PublicKey getPublicKey() {
			return new javaT.securityT.KeyStore.DefaultEntryType.PubKey1();
		}
	}

	private static class X509Cert extends java.security.cert.X509Certificate {
		public byte[] getEncoded() throws java.security.cert.CertificateEncodingException {
			return ((byte[]) (null));
		}

		public void verify(java.security.PublicKey key) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.NoSuchProviderException, java.security.SignatureException {
		}

		public void verify(java.security.PublicKey key, java.lang.String sigProvider) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.NoSuchProviderException, java.security.SignatureException {
		}

		public java.lang.String toString() {
			return "x509cert";
		}

		public java.security.PublicKey getPublicKey() {
			return new javaT.securityT.KeyStore.DefaultEntryType.PubKey2();
		}

		public void checkValidity() throws java.security.cert.CertificateExpiredException, java.security.cert.CertificateNotYetValidException {
		}

		public void checkValidity(java.util.Date date) throws java.security.cert.CertificateExpiredException, java.security.cert.CertificateNotYetValidException {
		}

		public int getVersion() {
			return 1;
		}

		public java.math.BigInteger getSerialNumber() {
			return new java.math.BigInteger("5", 10);
		}

		public java.security.Principal getIssuerDN() {
			return new javax.security.auth.x500.X500Principal("cn=x509cert");
		}

		public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
			return new javax.security.auth.x500.X500Principal("cn=x509cert");
		}

		public java.security.Principal getSubjectDN() {
			return new javax.security.auth.x500.X500Principal("cn=x509cert");
		}

		public javax.security.auth.x500.X500Principal getSubjectX500Principal() {
			return new javax.security.auth.x500.X500Principal("cn=x509cert");
		}

		public java.util.Date getNotBefore() {
			return new java.util.Date();
		}

		public java.util.Date getNotAfter() {
			return new java.util.Date();
		}

		public byte[] getTBSCertificate() throws java.security.cert.CertificateEncodingException {
			return ((byte[]) (null));
		}

		public byte[] getSignature() {
			return ((byte[]) (null));
		}

		public java.lang.String getSigAlgName() {
			return "x509cert";
		}

		public java.lang.String getSigAlgOID() {
			return "x509cert";
		}

		public byte[] getSigAlgParams() {
			return ((byte[]) (null));
		}

		public boolean[] getIssuerUniqueID() {
			return ((boolean[]) (null));
		}

		public boolean[] getSubjectUniqueID() {
			return ((boolean[]) (null));
		}

		public boolean[] getKeyUsage() {
			return ((boolean[]) (null));
		}

		public int getBasicConstraints() {
			return 1;
		}

		public boolean hasUnsupportedCriticalExtension() {
			return true;
		}

		public java.util.Set getCriticalExtensionOIDs() {
			return new java.util.HashSet();
		}

		public java.util.Set getNonCriticalExtensionOIDs() {
			return new java.util.HashSet();
		}

		public byte[] getExtensionValue(java.lang.String oid) {
			return ((byte[]) (null));
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.securityT.KeyStore.DefaultEntryType.testPrivateKeyEntry();
		javaT.securityT.KeyStore.DefaultEntryType.testSecretKeyEntry();
		javaT.securityT.KeyStore.DefaultEntryType.testTrustedCertificateEntry();
	}

	private static void testPrivateKeyEntry() throws java.lang.Exception {
		try {
			java.security.cert.Certificate[] chain = new java.security.cert.Certificate[0];
			java.security.KeyStore.PrivateKeyEntry pke = new java.security.KeyStore.PrivateKeyEntry(null, chain);
			throw new java.lang.SecurityException("test 1 failed");
		} catch (java.lang.NullPointerException npe) {
			java.lang.System.out.println("test 1 passed");
		}
		try {
			java.security.KeyStore.PrivateKeyEntry pke = new java.security.KeyStore.PrivateKeyEntry(new javaT.securityT.KeyStore.DefaultEntryType.PrivKey1(), null);
			throw new java.lang.SecurityException("test 2 failed");
		} catch (java.lang.NullPointerException npe) {
			java.lang.System.out.println("test 2 passed");
		}
		try {
			java.security.cert.Certificate[] chain = new java.security.cert.Certificate[0];
			java.security.KeyStore.PrivateKeyEntry pke = new java.security.KeyStore.PrivateKeyEntry(new javaT.securityT.KeyStore.DefaultEntryType.PrivKey1(), chain);
			throw new java.lang.SecurityException("test 3 failed");
		} catch (java.lang.IllegalArgumentException npe) {
			java.lang.System.out.println("test 3 passed");
		}
		try {
			java.security.cert.Certificate[] chain = new java.security.cert.Certificate[2];
			chain[0] = new javaT.securityT.KeyStore.DefaultEntryType.Cert();
			chain[1] = new javaT.securityT.KeyStore.DefaultEntryType.X509Cert();
			java.security.KeyStore.PrivateKeyEntry pke = new java.security.KeyStore.PrivateKeyEntry(new javaT.securityT.KeyStore.DefaultEntryType.PrivKey1(), chain);
			throw new java.lang.SecurityException("test 4 failed");
		} catch (java.lang.IllegalArgumentException npe) {
			java.lang.System.out.println("test 4 passed");
		}
		try {
			java.security.cert.Certificate[] chain = new java.security.cert.Certificate[1];
			chain[0] = new javaT.securityT.KeyStore.DefaultEntryType.Cert();
			java.security.KeyStore.PrivateKeyEntry pke = new java.security.KeyStore.PrivateKeyEntry(new javaT.securityT.KeyStore.DefaultEntryType.PrivKey1(), chain);
			throw new java.lang.SecurityException("test 5 failed");
		} catch (java.lang.IllegalArgumentException npe) {
			java.lang.System.out.println("test 5 passed");
		}
		java.security.cert.Certificate[] chain = new java.security.cert.Certificate[2];
		chain[0] = new javaT.securityT.KeyStore.DefaultEntryType.X509Cert();
		chain[1] = new javaT.securityT.KeyStore.DefaultEntryType.X509Cert();
		java.security.PrivateKey pkey = new javaT.securityT.KeyStore.DefaultEntryType.PrivKey1();
		java.security.KeyStore.PrivateKeyEntry pke = new java.security.KeyStore.PrivateKeyEntry(pkey, chain);
		java.security.cert.Certificate[] gotChain = pke.getCertificateChain();
		if (gotChain instanceof java.security.cert.X509Certificate[]) {
			java.lang.System.out.println("test 6 passed");
		} else {
			throw new java.lang.SecurityException("test 6 failed");
		}
		if (((gotChain.length == 2) && (gotChain[0] == chain[0])) && (gotChain[1] == chain[1])) {
			java.lang.System.out.println("test 7 passed");
		} else {
			throw new java.lang.SecurityException("test 7 failed");
		}
		if (pke.getPrivateKey() == pkey) {
			java.lang.System.out.println("test 8 passed");
		} else {
			throw new java.lang.SecurityException("test 8 failed");
		}
	}

	private static void testSecretKeyEntry() throws java.lang.Exception {
	}

	private static void testTrustedCertificateEntry() throws java.lang.Exception {
	}
}