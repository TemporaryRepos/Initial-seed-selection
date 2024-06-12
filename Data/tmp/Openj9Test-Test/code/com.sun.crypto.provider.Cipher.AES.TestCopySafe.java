public class TestCopySafe {
	private static boolean DEBUG = false;

	private static int INPUT_LENGTH = 160;

	private static byte[] PT = new byte[com.sun.crypto.provider.Cipher.AES.TestCopySafe.INPUT_LENGTH];

	private static javax.crypto.SecretKey KEY = new javax.crypto.spec.SecretKeySpec(new byte[16], "AES");

	private static byte[] IV = new byte[16];

	private static int[] OFFSETS = new int[]{ 1, 8, 9, 16, 17, 32, 33 };

	private static final java.lang.String[] MODES = new java.lang.String[]{ "ECB", "CBC", "PCBC", "CTR", "CTS", "CFB", "CFB8", "CFB16", "CFB24", "CFB32", "CFB40", "CFB48", "CFB56", "CFB64", "OFB", "OFB8", "OFB16", "OFB24", "OFB32", "OFB40", "OFB48", "OFB56", "OFB64", "GCM" };

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		java.security.Provider p = java.security.Security.getProvider("SunJCE");
		java.security.spec.AlgorithmParameterSpec params = null;
		boolean result = true;
		for (java.lang.String mode : com.sun.crypto.provider.Cipher.AES.TestCopySafe.MODES) {
			java.lang.String transformation = ("AES/" + mode) + "/NoPadding";
			boolean isGCM = mode == "GCM";
			if (isGCM) {
				params = new javax.crypto.spec.GCMParameterSpec(128, com.sun.crypto.provider.Cipher.AES.TestCopySafe.IV);
			} else if (mode != "ECB") {
				params = new javax.crypto.spec.IvParameterSpec(com.sun.crypto.provider.Cipher.AES.TestCopySafe.IV);
			}
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance(transformation, p);
			java.lang.System.out.println(("Testing " + transformation) + ":");
			for (int offset : com.sun.crypto.provider.Cipher.AES.TestCopySafe.OFFSETS) {
				java.lang.System.out.print(("=> offset " + offset) + ": ");
				try {
					com.sun.crypto.provider.Cipher.AES.TestCopySafe.test(c, params, offset, isGCM);
					java.lang.System.out.println("Passed");
				} catch (java.lang.Exception ex) {
					ex.printStackTrace();
					result = false;
					continue;
				}
			}
		}
		if (!result) {
			throw new java.lang.Exception("One or more test failed");
		}
	}

	private static void test(javax.crypto.Cipher c, java.security.spec.AlgorithmParameterSpec params, int offset, boolean isGCM) throws java.lang.Exception {
		if (isGCM) {
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestCopySafe.KEY);
		}
		c.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestCopySafe.KEY, params);
		byte[] answer = c.doFinal(com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT);
		byte[] pt2 = java.util.Arrays.copyOf(com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT, answer.length + offset);
		if (isGCM) {
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestCopySafe.KEY);
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestCopySafe.KEY, params);
		}
		c.doFinal(pt2, 0, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT.length, pt2, 0);
		if (!com.sun.crypto.provider.Cipher.AES.TestCopySafe.isTwoArraysEqual(pt2, 0, answer, 0, answer.length)) {
			throw new java.lang.Exception("Enc#1 diff check failed!");
		} else if (com.sun.crypto.provider.Cipher.AES.TestCopySafe.DEBUG) {
			java.lang.System.out.println("Enc#1 diff check passed");
		}
		java.lang.System.arraycopy(com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT, 0, pt2, 0, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT.length);
		if (isGCM) {
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestCopySafe.KEY);
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestCopySafe.KEY, params);
		}
		c.doFinal(pt2, 0, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT.length, pt2, offset);
		if (!com.sun.crypto.provider.Cipher.AES.TestCopySafe.isTwoArraysEqual(pt2, offset, answer, 0, answer.length)) {
			throw new java.lang.Exception("Enc#2 diff check failed");
		} else if (com.sun.crypto.provider.Cipher.AES.TestCopySafe.DEBUG) {
			java.lang.System.out.println("Enc#2 diff check passed");
		}
		java.lang.System.arraycopy(com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT, 0, pt2, offset, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT.length);
		if (isGCM) {
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestCopySafe.KEY);
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestCopySafe.KEY, params);
		}
		c.doFinal(pt2, offset, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT.length, pt2, 0);
		if (!com.sun.crypto.provider.Cipher.AES.TestCopySafe.isTwoArraysEqual(pt2, 0, answer, 0, answer.length)) {
			throw new java.lang.Exception("Enc#3 diff check failed");
		} else if (com.sun.crypto.provider.Cipher.AES.TestCopySafe.DEBUG) {
			java.lang.System.out.println("Enc#3 diff check passed");
		}
		c.init(javax.crypto.Cipher.DECRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestCopySafe.KEY, params);
		pt2 = java.util.Arrays.copyOf(answer, answer.length + offset);
		c.doFinal(pt2, 0, answer.length, pt2, 0);
		if (!com.sun.crypto.provider.Cipher.AES.TestCopySafe.isTwoArraysEqual(pt2, 0, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT, 0, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT.length)) {
			throw new java.lang.Exception("Dec#1 diff check failed!");
		} else if (com.sun.crypto.provider.Cipher.AES.TestCopySafe.DEBUG) {
			java.lang.System.out.println("Dec#1 diff check passed");
		}
		java.lang.System.arraycopy(answer, 0, pt2, 0, answer.length);
		c.doFinal(pt2, 0, answer.length, pt2, offset);
		if (!com.sun.crypto.provider.Cipher.AES.TestCopySafe.isTwoArraysEqual(pt2, offset, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT, 0, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT.length)) {
			throw new java.lang.Exception("Dec#2 diff check failed");
		} else if (com.sun.crypto.provider.Cipher.AES.TestCopySafe.DEBUG) {
			java.lang.System.out.println("Dec#2 diff check passed");
		}
		java.lang.System.arraycopy(answer, 0, pt2, offset, answer.length);
		c.doFinal(pt2, offset, answer.length, pt2, 0);
		if (!com.sun.crypto.provider.Cipher.AES.TestCopySafe.isTwoArraysEqual(pt2, 0, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT, 0, com.sun.crypto.provider.Cipher.AES.TestCopySafe.PT.length)) {
			throw new java.lang.Exception("Dec#3 diff check failed");
		} else if (com.sun.crypto.provider.Cipher.AES.TestCopySafe.DEBUG) {
			java.lang.System.out.println("Dec#3 diff check passed");
		}
	}

	private static boolean isTwoArraysEqual(byte[] a, int aOff, byte[] b, int bOff, int len) {
		for (int i = 0; i < len; i++) {
			if (a[aOff + i] != b[bOff + i]) {
				return false;
			}
		}
		return true;
	}
}