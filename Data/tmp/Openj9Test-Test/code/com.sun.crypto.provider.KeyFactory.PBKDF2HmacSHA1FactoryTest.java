public class PBKDF2HmacSHA1FactoryTest {
	private static final java.lang.String ALGO = "PBKDF2WithHmacSHA1";

	static final int[] KEY_SIZES = new int[]{ 128, 256 };

	private static final com.sun.crypto.provider.KeyFactory.TestVector[] TEST_VECTORS = new com.sun.crypto.provider.KeyFactory.TestVector[]{ new com.sun.crypto.provider.KeyFactory.TestVector(1, "password", "ATHENA.MIT.EDUraeburn", "cdedb5281bb2f801565a1122b25635150ad1f7a04bb9f3a333ecc0e2e1f70837"), new com.sun.crypto.provider.KeyFactory.TestVector(2, "password", "ATHENA.MIT.EDUraeburn", "01dbee7f4a9e243e988b62c73cda935da05378b93244ec8f48a99e61ad799d86"), new com.sun.crypto.provider.KeyFactory.TestVector(1200, "password", "ATHENA.MIT.EDUraeburn", "5c08eb61fdf71e4e4ec3cf6ba1f5512ba7e52ddbc5e5142f708a31e2e62b1e13"), new com.sun.crypto.provider.KeyFactory.TestVector(5, "password", com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.fromHexString("1234567878563412"), "d1daa78615f287e6a1c8b120d7062a493f98d203e6be49a6adf4fa574b6e64ee"), new com.sun.crypto.provider.KeyFactory.TestVector(1200, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pass phrase equals block size", "139c30c0966bc32ba55fdbf212530ac9c5ec59f1a452f5cc9ad940fea0598ed1"), new com.sun.crypto.provider.KeyFactory.TestVector(1200, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "pass phrase exceeds block size", "9ccad6d468770cd51b10e6a68721be611a8b4d282601db3b36be9246915ec82a"), new com.sun.crypto.provider.KeyFactory.TestVector(50, com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.fromHexString("f09d849e"), "EXAMPLE.COMpianist", "6b9cf26d45455a43a5b8bb276a403b39e7fe37a0c41e02c281ff3069e1e94f52") };

	private static void test() throws java.lang.Exception {
		javax.crypto.SecretKeyFactory skf = javax.crypto.SecretKeyFactory.getInstance(com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.ALGO, "SunJCE");
		for (int i = 0; i < com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.TEST_VECTORS.length; i++) {
			java.lang.System.out.println("=>Testing vector#" + (i + 1));
			com.sun.crypto.provider.KeyFactory.TestVector tv = com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.TEST_VECTORS[i];
			for (int j = 0; j < com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.KEY_SIZES.length; j++) {
				javax.crypto.spec.PBEKeySpec keySpec = tv.keySpecs[j];
				javax.crypto.interfaces.PBEKey key = ((javax.crypto.interfaces.PBEKey) (skf.generateSecret(keySpec)));
				byte[] derivedKey = key.getEncoded();
				if (!key.getFormat().equalsIgnoreCase("RAW")) {
					throw new java.lang.Exception("Wrong format for derived key");
				}
				if (derivedKey.length != (com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.KEY_SIZES[j] / 8)) {
					throw new java.lang.Exception("Wrong length for derived key");
				}
				if (!tv.expectedVals[j].equals(com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.toHexString(derivedKey))) {
					java.lang.System.out.println("got:      " + com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.toHexString(derivedKey));
					java.lang.System.out.println("expected: " + tv.expectedVals[j]);
					throw new java.lang.Exception("Wrong value for derived key");
				}
				javax.crypto.spec.PBEKeySpec keySpec2 = ((javax.crypto.spec.PBEKeySpec) (skf.getKeySpec(key, javax.crypto.spec.PBEKeySpec.class)));
				if (!com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.isEqual(keySpec, keySpec2)) {
					throw new java.lang.Exception("Wrong derived keySpec");
				}
			}
		}
	}

	private static boolean isEqual(javax.crypto.spec.PBEKeySpec spec1, javax.crypto.spec.PBEKeySpec spec2) {
		if ((spec1 == null) || (spec2 == null)) {
			return false;
		}
		if (((java.util.Arrays.equals(spec1.getPassword(), spec2.getPassword()) && java.util.Arrays.equals(spec1.getSalt(), spec2.getSalt())) && (spec1.getIterationCount() == spec2.getIterationCount())) && (spec1.getKeyLength() == spec2.getKeyLength())) {
			return true;
		}
		return false;
	}

	private static java.lang.String toHexString(byte[] bytes) {
		java.lang.String mapping = "0123456789abcdef";
		java.lang.StringBuilder sb = new java.lang.StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			int low = bytes[i] & 0xf;
			int high = (bytes[i] >> 4) & 0xf;
			char[] res = new char[2];
			res[0] = mapping.charAt(high);
			res[1] = mapping.charAt(low);
			sb.append(res);
		}
		return sb.toString();
	}

	private static byte[] fromHexString(java.lang.String value) {
		byte[] bytes = new byte[value.length() / 2];
		java.lang.String mapping = "0123456789abcdef";
		java.lang.StringBuilder sb = new java.lang.StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			java.lang.String high = value.substring(2 * i, (2 * i) + 1);
			java.lang.String low = value.substring((2 * i) + 1, (2 * i) + 2);
			bytes[i] = ((byte) ((mapping.indexOf(high) << 4) + mapping.indexOf(low)));
		}
		return bytes;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.sun.crypto.provider.KeyFactory.PBKDF2HmacSHA1FactoryTest.test();
		java.lang.System.out.println("Test Passed!");
	}
}