public class GCMLargeDataKAT {
	static final java.util.HashMap<java.lang.Integer, java.lang.String> results = new java.util.HashMap<java.lang.Integer, java.lang.String>() {
		{
			put(65534, "1397b91c31ce793895edace4e175bfee");
			put(65535, "4ad101c9f450e686668b3f8f05db96f0");
			put(65536, "fbfaee3451acd3f603200d6be0f39b24");
			put(65537, "e7dfca4a71495c65d20982c3c9b9813f");
			put(67583, "c8ebdcb3532ec6c165de961341af7635");
			put(67584, "36559d108dfd25dd29da3fec3455b9e5");
			put(67585, "1d21b42d80ea179810744fc23dc228b6");
			put(102400, "0d1544fcab20bbd4c8103b9d273f2c82");
			put(102401, "f2d53ef65fd12d0a861368659b23ea2e");
			put(102402, "97f0f524cf63d2d9d23d81e64d416ee0");
			put(102403, "4a6b4af55b7d9016b64114d6813d639c");
			put(102404, "ba63cc131fcde2f12ddf2ac634201be8");
			put(102405, "673d05c7fe5e283e42e5c0d049fdcea6");
			put(102406, "76cc99a7850ce857eb3cb43049cf9877");
			put(102407, "65863f99072cf2eb7fce18bd78b33f4e");
			put(102408, "b9184f0f272682cc1f791fa7070eddd4");
			put(102409, "45fe36afef43cc665bf22a9ca200c3c2");
			put(102410, "67249e41646edcb37a78a61b0743cf11");
			put(102411, "ffdc611e29c8849842e81ec78f32c415");
			put(102412, "b7fde7fd52221057dccc1c181a140125");
			put(102413, "4b1d6c64d56448105e5613157e69c0ae");
			put(102414, "6d2c0b26c0c8785c8eec3298a5f0080c");
			put(102415, "1df2061b114fbe56bdf3717e3ee61ef9");
			put(102416, "a691742692c683ac9d1254df5fc5f768");
		}
	};

	static final int HIGHLEN = 102416;

	static final int GCM_TAG_LENGTH = 16;

	static final byte[] iv = new byte[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	static final byte[] key_code = new byte[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

	static final javax.crypto.spec.GCMParameterSpec spec = new javax.crypto.spec.GCMParameterSpec(com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.GCM_TAG_LENGTH * 8, com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.iv);

	static final javax.crypto.SecretKey key = new javax.crypto.spec.SecretKeySpec(com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.key_code, "AES");

	static boolean testresult = true;

	static byte[] plaintext = new byte[com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.HIGHLEN];

	static java.security.MessageDigest md5;

	javax.crypto.Cipher cipher;

	GCMLargeDataKAT() {
	}

	byte[] encrypt(int inLen) {
		try {
			cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding", "SunJCE");
			cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.key, com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.spec);
			return cipher.doFinal(com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.plaintext, 0, inLen);
		} catch (java.lang.Exception e) {
			java.lang.System.err.println((("Encrypt Failure (length = " + inLen) + ") : ") + e.getMessage());
			e.printStackTrace();
		}
		return new byte[0];
	}

	static byte[] hash(byte[] data) {
		return com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.md5.digest(data);
	}

	boolean decrypt(byte[] data) {
		byte[] result = null;
		int len = data.length - com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.GCM_TAG_LENGTH;
		if (data.length == 0) {
			return false;
		}
		try {
			cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding", "SunJCE");
			cipher.init(javax.crypto.Cipher.DECRYPT_MODE, com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.key, com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.spec);
			result = cipher.doFinal(data);
		} catch (java.lang.Exception e) {
			java.lang.System.err.println((("Decrypt Failure (length = " + len) + ") : ") + e.getMessage());
			e.printStackTrace();
			return false;
		}
		if (result.length != len) {
			java.lang.System.err.println((("Decrypt Failure (length = " + len) + ") : plaintext length invalid = ") + result.length);
		}
		int i = 0;
		while (result.length > i) {
			if (result[i++] != 0) {
				java.lang.System.err.println((("Decrypt Failure (length = " + len) + ") : plaintext invalid, char index ") + i);
				return false;
			}
		} 
		return true;
	}

	void test() throws java.lang.Exception {
		for (int l : com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.results.keySet()) {
			byte[] enc = new com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT().encrypt(l);
			java.lang.String hashstr = com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.toHex(com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.hash(enc));
			boolean r = hashstr.compareTo(com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.results.get(l)) == 0;
			java.lang.System.out.println("---------------------------------------------");
			java.lang.System.out.println((("Encrypt data size " + l) + " \tResult: ") + (r ? "Pass" : "Fail"));
			if (!r) {
				if (enc.length != 0) {
					java.lang.System.out.println("\tExpected: " + com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.results.get(l));
					java.lang.System.out.println("\tReturned: " + hashstr);
				}
				com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.testresult = false;
				continue;
			}
			r = decrypt(enc);
			java.lang.System.out.println((("Decrypt data size " + l) + " \tResult: ") + (r ? "Pass" : "Fail"));
			if (!r) {
				com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.testresult = false;
			}
		}
		if (!com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.testresult) {
			throw new java.lang.Exception("Tests failed");
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.md5 = java.security.MessageDigest.getInstance("MD5");
		if (args.length > 0) {
			int len = java.lang.Integer.parseInt(args[0]);
			byte[] e = new com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT().encrypt(len);
			java.lang.System.out.println(com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.toHex(com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.hash(e)));
			return;
		}
		new com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT().test();
	}

	static java.lang.String toHex(byte[] bytes) {
		java.lang.StringBuffer hexStringBuffer = new java.lang.StringBuffer(32);
		for (int i = 0; i < bytes.length; i++) {
			hexStringBuffer.append(com.sun.crypto.provider.Cipher.AEAD.GCMLargeDataKAT.byteToHex(bytes[i]));
		}
		return hexStringBuffer.toString();
	}

	static java.lang.String byteToHex(byte num) {
		char[] hexDigits = new char[2];
		hexDigits[0] = java.lang.Character.forDigit((num >> 4) & 0xf, 16);
		hexDigits[1] = java.lang.Character.forDigit(num & 0xf, 16);
		return new java.lang.String(hexDigits);
	}
}