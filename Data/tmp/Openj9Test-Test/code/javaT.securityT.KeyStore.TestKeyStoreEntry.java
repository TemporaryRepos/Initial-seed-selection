public class TestKeyStoreEntry {
	private static final char[] PASSWDK = new char[]{ 't', 'e', 'r', 'c', 'e', 's' };

	private static final char[] PASSWDF = new java.lang.String("guardian Angel").toCharArray();

	private static final java.lang.String[] KS_ALGOS = new java.lang.String[]{ "DES", "DESede", "Blowfish" };

	private static final int NUM_ALGOS = javaT.securityT.KeyStore.TestKeyStoreEntry.KS_ALGOS.length;

	private static final java.lang.String[] KS_TYPE = new java.lang.String[]{ "jks", "jceks", "pkcs12", "PKCS11KeyStore" };

	private static final java.lang.String[] PRO_TYPE = new java.lang.String[]{ "SUN", "SunJCE", "SunJSSE", "SunPKCS11-Solaris" };

	private final javax.crypto.SecretKey[] sks = new javax.crypto.SecretKey[javaT.securityT.KeyStore.TestKeyStoreEntry.NUM_ALGOS];

	TestKeyStoreEntry() throws java.lang.Exception {
		javax.crypto.KeyGenerator[] kgs = new javax.crypto.KeyGenerator[javaT.securityT.KeyStore.TestKeyStoreEntry.NUM_ALGOS];
		for (int i = 0; i < javaT.securityT.KeyStore.TestKeyStoreEntry.NUM_ALGOS; i++) {
			kgs[i] = javax.crypto.KeyGenerator.getInstance(javaT.securityT.KeyStore.TestKeyStoreEntry.KS_ALGOS[i], "SunJCE");
			sks[i] = kgs[i].generateKey();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.securityT.KeyStore.TestKeyStoreEntry jstest = new javaT.securityT.KeyStore.TestKeyStoreEntry();
		jstest.run();
	}

	public void run() throws java.lang.Exception {
		java.security.Provider[] providers = java.security.Security.getProviders();
		for (java.security.Provider p : providers) {
			java.lang.String prvName = p.getName();
			if (prvName.startsWith("SunJCE") || prvName.startsWith("SunPKCS11-Solaris")) {
				try {
					runTest(p);
					java.lang.System.out.println((("Test with provider " + p.getName()) + "") + " passed");
				} catch (java.security.KeyStoreException e) {
					if (prvName.startsWith("SunPKCS11-Solaris")) {
						java.lang.System.out.println("KeyStoreException is expected because " + "PKCS11KeyStore is invalid keystore type.");
						e.printStackTrace();
					} else {
						throw e;
					}
				}
			}
		}
	}

	public void runTest(java.security.Provider p) throws java.lang.Exception {
		try (final java.io.FileOutputStream fos = new java.io.FileOutputStream("jceks");final java.io.FileInputStream fis = new java.io.FileInputStream("jceks")) {
			java.security.KeyStore ks = java.security.KeyStore.getInstance("jceks", p);
			ks.load(null, null);
			java.lang.String aliasHead = new java.lang.String("secretKey");
			for (int j = 0; j < javaT.securityT.KeyStore.TestKeyStoreEntry.NUM_ALGOS; j++) {
				ks.setKeyEntry(aliasHead + j, sks[j], javaT.securityT.KeyStore.TestKeyStoreEntry.PASSWDK, null);
			}
			ks.store(fos, javaT.securityT.KeyStore.TestKeyStoreEntry.PASSWDF);
			for (int k = 0; k < javaT.securityT.KeyStore.TestKeyStoreEntry.NUM_ALGOS; k++) {
				ks.deleteEntry(aliasHead + k);
			}
			if (ks.size() != 0) {
				throw new java.lang.RuntimeException("ERROR: re-initialization failed");
			}
			ks.load(fis, javaT.securityT.KeyStore.TestKeyStoreEntry.PASSWDF);
			java.security.Key temp = null;
			java.lang.String alias = null;
			if (ks.size() != javaT.securityT.KeyStore.TestKeyStoreEntry.NUM_ALGOS) {
				throw new java.lang.RuntimeException("ERROR: wrong number of key" + " entries");
			}
			for (int m = 0; m < ks.size(); m++) {
				alias = aliasHead + m;
				temp = ks.getKey(alias, javaT.securityT.KeyStore.TestKeyStoreEntry.PASSWDK);
				if (!temp.equals(sks[m])) {
					throw new java.lang.RuntimeException(("ERROR: key comparison (" + m) + ") failed");
				}
				if (ks.isCertificateEntry(alias) || (!ks.isKeyEntry(alias))) {
					throw new java.lang.RuntimeException(("ERROR: type identification (" + m) + ") failed");
				}
			}
		}
	}
}