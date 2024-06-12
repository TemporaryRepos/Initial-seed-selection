public class CTSMode {
	private static final byte[] toByteArray(java.lang.String s) {
		char[] c = s.toCharArray();
		byte[] t = new byte[c.length / 2];
		int n = 0;
		int d1 = -1;
		int d2 = -1;
		for (int i = 0; i < c.length; i++) {
			char ch = c[i];
			if (d1 == (-1)) {
				d1 = java.lang.Character.digit(ch, 16);
			} else {
				d2 = java.lang.Character.digit(ch, 16);
				if (d2 != (-1)) {
					t[n++] = ((byte) ((d1 << 4) | d2));
					d1 = -1;
					d2 = -1;
				}
			}
		}
		if (d1 != (-1)) {
			throw new java.lang.RuntimeException();
		}
		if (n == t.length) {
			return t;
		}
		byte[] b = new byte[n];
		java.lang.System.arraycopy(t, 0, b, 0, n);
		return b;
	}

	private static final javax.crypto.SecretKey KEY1 = new javax.crypto.spec.SecretKeySpec(com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("636869636b656e207465726979616b69"), "AES");

	private static final javax.crypto.spec.IvParameterSpec IV1 = new javax.crypto.spec.IvParameterSpec(new byte[16]);

	private static final byte[][] PLAIN1 = new byte[][]{ com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("4920776f756c64206c696b652074686520"), com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("4920776f756c64206c696b6520746865" + "2047656e6572616c20476175277320"), com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("4920776f756c64206c696b6520746865" + "2047656e6572616c2047617527732043"), com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("4920776f756c64206c696b6520746865" + ("2047656e6572616c2047617527732043" + "6869636b656e2c20706c656173652c")), com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("4920776f756c64206c696b6520746865" + ("2047656e6572616c2047617527732043" + "6869636b656e2c20706c656173652c20")), com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("4920776f756c64206c696b6520746865" + (("2047656e6572616c2047617527732043" + "6869636b656e2c20706c656173652c20") + "616e6420776f6e746f6e20736f75702e")) };

	private static final byte[][] CIPHER1 = new byte[][]{ com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("c6353568f2bf8cb4d8a580362da7ff7f97"), com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("fc00783e0efdb2c1d445d4c8eff7ed22" + "97687268d6ecccc0c07b25e25ecfe5"), com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("39312523a78662d5be7fcbcc98ebf5a8" + "97687268d6ecccc0c07b25e25ecfe584"), com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("97687268d6ecccc0c07b25e25ecfe584" + ("b3fffd940c16a18c1b5549d2f838029e" + "39312523a78662d5be7fcbcc98ebf5")), com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("97687268d6ecccc0c07b25e25ecfe584" + ("9dad8bbb96c4cdc03bc103e1a194bbd8" + "39312523a78662d5be7fcbcc98ebf5a8")), com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("97687268d6ecccc0c07b25e25ecfe584" + (("39312523a78662d5be7fcbcc98ebf5a8" + "4807efe836ee89a526730dbc2f7bc840") + "9dad8bbb96c4cdc03bc103e1a194bbd8")) };

	private static final byte[] IV2_SRC = com.sun.crypto.provider.Cipher.CTS.CTSMode.toByteArray("11223344556677880011223344556677");

	private static final java.lang.String[] ALGORITHMS2 = new java.lang.String[]{ "DES", "DESede", "Blowfish", "AES" };

	private static final int[] KEYSIZES2 = new int[]{ 8, 24, 16, 16 };

	private static java.lang.String toString(byte[] b) {
		java.lang.StringBuffer sb = new java.lang.StringBuffer(b.length * 3);
		for (int i = 0; i < b.length; i++) {
			int k = b[i] & 0xff;
			if (i != 0) {
				sb.append(':');
			}
			sb.append(java.lang.Character.forDigit(k >> 4, 16));
			sb.append(java.lang.Character.forDigit(k & 0xf, 16));
		}
		return sb.toString();
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.sun.crypto.provider.Cipher.CTS.CTSMode.test1();
		com.sun.crypto.provider.Cipher.CTS.CTSMode.test2();
		com.sun.crypto.provider.Cipher.CTS.CTSMode.test3();
	}

	private static void test1() throws java.lang.Exception {
		for (int i = 0; i < com.sun.crypto.provider.Cipher.CTS.CTSMode.PLAIN1.length; i++) {
			java.lang.String algo = com.sun.crypto.provider.Cipher.CTS.CTSMode.KEY1.getAlgorithm();
			int MAX_KEYSIZE = javax.crypto.Cipher.getMaxAllowedKeyLength(algo);
			if (com.sun.crypto.provider.Cipher.CTS.CTSMode.KEY1.getEncoded().length > MAX_KEYSIZE) {
				continue;
			}
			java.lang.System.out.println(((("Running test1_" + i) + " (") + algo) + ")");
			javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(algo + "/CTS/NoPadding", "SunJCE");
			byte[] plainText = com.sun.crypto.provider.Cipher.CTS.CTSMode.PLAIN1[i];
			byte[] cipherText = com.sun.crypto.provider.Cipher.CTS.CTSMode.CIPHER1[i];
			cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.CTS.CTSMode.KEY1, com.sun.crypto.provider.Cipher.CTS.CTSMode.IV1);
			byte[] enc = cipher.doFinal(plainText);
			if (java.util.Arrays.equals(cipherText, enc) == false) {
				java.lang.System.out.println("plain:  " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(plainText));
				java.lang.System.out.println("cipher: " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(cipherText));
				java.lang.System.out.println("actual: " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(enc));
				throw new java.lang.RuntimeException("Encryption failure for test " + i);
			}
			cipher.init(javax.crypto.Cipher.DECRYPT_MODE, com.sun.crypto.provider.Cipher.CTS.CTSMode.KEY1, com.sun.crypto.provider.Cipher.CTS.CTSMode.IV1);
			byte[] dec = cipher.doFinal(cipherText);
			if (java.util.Arrays.equals(plainText, dec) == false) {
				java.lang.System.out.println("cipher: " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(cipherText));
				java.lang.System.out.println("plain:  " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(plainText));
				java.lang.System.out.println("actual: " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(enc));
				throw new java.lang.RuntimeException("Decryption failure for test " + i);
			}
		}
	}

	private static void test2() throws java.lang.Exception {
		for (int i = 0; i < com.sun.crypto.provider.Cipher.CTS.CTSMode.ALGORITHMS2.length; i++) {
			java.lang.String algo = com.sun.crypto.provider.Cipher.CTS.CTSMode.ALGORITHMS2[i];
			java.lang.System.out.println(((("Running test2_" + i) + " (") + algo) + ")");
			int keySize = com.sun.crypto.provider.Cipher.CTS.CTSMode.KEYSIZES2[i];
			int MAX_KEYSIZE = javax.crypto.Cipher.getMaxAllowedKeyLength(algo);
			if (keySize > MAX_KEYSIZE) {
				continue;
			}
			javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(algo + "/CTS/NoPadding", "SunJCE");
			int blockSize = cipher.getBlockSize();
			javax.crypto.spec.SecretKeySpec key = new javax.crypto.spec.SecretKeySpec(new byte[keySize], algo);
			byte[] plainText = com.sun.crypto.provider.Cipher.CTS.CTSMode.PLAIN1[3];
			cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
			byte[] cipherText = new byte[plainText.length];
			int firstPartLen = blockSize + 1;
			int processed1 = cipher.update(plainText, 0, firstPartLen, cipherText, 0);
			int processed2 = cipher.doFinal(plainText, firstPartLen, plainText.length - firstPartLen, cipherText, processed1);
			java.security.AlgorithmParameters params = cipher.getParameters();
			if ((processed1 + processed2) != plainText.length) {
				java.lang.System.out.println("processed1 = " + processed1);
				java.lang.System.out.println("processed2 = " + processed2);
				java.lang.System.out.println("total length = " + plainText.length);
				throw new java.lang.RuntimeException("Encryption failure for test " + i);
			}
			try {
				cipher.doFinal(new byte[blockSize - 1]);
				throw new java.lang.RuntimeException("Expected IBSE is not thrown");
			} catch (javax.crypto.IllegalBlockSizeException ibse) {
			}
			javax.crypto.spec.IvParameterSpec iv2 = new javax.crypto.spec.IvParameterSpec(com.sun.crypto.provider.Cipher.CTS.CTSMode.IV2_SRC, 0, blockSize);
			cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key, iv2);
			javax.crypto.Cipher cipher2 = javax.crypto.Cipher.getInstance(algo + "/CBC/NoPadding", "SunJCE");
			cipher2.init(javax.crypto.Cipher.ENCRYPT_MODE, key, iv2);
			byte[] eout = cipher.doFinal(com.sun.crypto.provider.Cipher.CTS.CTSMode.IV2_SRC, 0, blockSize);
			byte[] eout2 = cipher2.doFinal(com.sun.crypto.provider.Cipher.CTS.CTSMode.IV2_SRC, 0, blockSize);
			if (!java.util.Arrays.equals(eout, eout2)) {
				throw new java.lang.RuntimeException("Different encryption output " + "for CBC and CTS");
			}
			cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key, params);
			byte[] recoveredText = new byte[cipher.getOutputSize(cipherText.length)];
			processed1 = cipher.update(cipherText, 0, firstPartLen, recoveredText, 0);
			processed2 = cipher.update(cipherText, firstPartLen, cipherText.length - firstPartLen, recoveredText, processed1);
			int processed3 = cipher.doFinal(recoveredText, processed1 + processed2);
			if (((processed1 + processed2) + processed3) != plainText.length) {
				java.lang.System.out.println("processed1 = " + processed1);
				java.lang.System.out.println("processed2 = " + processed2);
				java.lang.System.out.println("processed3 = " + processed3);
				java.lang.System.out.println("total length = " + plainText.length);
				throw new java.lang.RuntimeException("Decryption failure for test " + i);
			}
			if (java.util.Arrays.equals(plainText, recoveredText) == false) {
				java.lang.System.out.println("plain:  " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(plainText));
				java.lang.System.out.println("recovered: " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(recoveredText));
				throw new java.lang.RuntimeException("Decryption failure for test " + i);
			}
			try {
				cipher.doFinal(new byte[blockSize - 1]);
				throw new java.lang.RuntimeException("Expected IBSE is not thrown");
			} catch (javax.crypto.IllegalBlockSizeException ibse) {
			}
			cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key, iv2);
			cipher2.init(javax.crypto.Cipher.DECRYPT_MODE, key, iv2);
			byte[] dout = cipher.doFinal(eout);
			byte[] dout2 = cipher2.doFinal(eout2);
			if (!java.util.Arrays.equals(dout, dout2)) {
				throw new java.lang.RuntimeException("Different decryption output " + "for CBC and CTS");
			}
		}
	}

	private static void test3() throws java.lang.Exception {
		for (int i = 3; i < com.sun.crypto.provider.Cipher.CTS.CTSMode.PLAIN1.length; i++) {
			java.lang.String algo = com.sun.crypto.provider.Cipher.CTS.CTSMode.KEY1.getAlgorithm();
			java.lang.System.out.println(((("Running test3_" + i) + " (") + algo) + ")");
			int MAX_KEYSIZE = javax.crypto.Cipher.getMaxAllowedKeyLength(algo);
			if (com.sun.crypto.provider.Cipher.CTS.CTSMode.KEY1.getEncoded().length > MAX_KEYSIZE) {
				continue;
			}
			javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(algo + "/CTS/NoPadding", "SunJCE");
			byte[] plainText = com.sun.crypto.provider.Cipher.CTS.CTSMode.PLAIN1[i];
			byte[] cipherText = com.sun.crypto.provider.Cipher.CTS.CTSMode.CIPHER1[i];
			byte[] enc = new byte[plainText.length];
			cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.CTS.CTSMode.KEY1, com.sun.crypto.provider.Cipher.CTS.CTSMode.IV1);
			int halfInput = plainText.length / 2;
			int processed1 = cipher.update(plainText, 0, halfInput, enc, 0);
			try {
				cipher.doFinal(plainText, halfInput, plainText.length - halfInput, new byte[1], 0);
				throw new java.lang.RuntimeException("Expected Exception is not thrown");
			} catch (javax.crypto.ShortBufferException sbe) {
				int processed2 = cipher.doFinal(plainText, halfInput, plainText.length - halfInput, enc, processed1);
				if ((processed1 + processed2) != enc.length) {
					java.lang.System.out.println("processed1 = " + processed1);
					java.lang.System.out.println("processed2 = " + processed2);
					java.lang.System.out.println("total length = " + enc.length);
					throw new java.lang.RuntimeException("Encryption length check " + "failed");
				}
			}
			if (java.util.Arrays.equals(cipherText, enc) == false) {
				java.lang.System.out.println("plain:  " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(plainText));
				java.lang.System.out.println("cipher: " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(cipherText));
				java.lang.System.out.println("actual: " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(enc));
				throw new java.lang.RuntimeException("Encryption failure for test " + i);
			}
			cipher.init(javax.crypto.Cipher.DECRYPT_MODE, com.sun.crypto.provider.Cipher.CTS.CTSMode.KEY1, com.sun.crypto.provider.Cipher.CTS.CTSMode.IV1);
			byte[] dec = new byte[cipher.getOutputSize(cipherText.length)];
			processed1 = cipher.update(cipherText, 0, halfInput, dec, 0);
			try {
				cipher.update(cipherText, halfInput, cipherText.length - halfInput, new byte[1], 0);
				throw new java.lang.RuntimeException("Expected Exception is not thrown");
			} catch (javax.crypto.ShortBufferException sbe) {
				int processed2 = cipher.update(cipherText, halfInput, cipherText.length - halfInput, dec, processed1);
				int processed3 = cipher.doFinal(dec, processed1 + processed2);
				if (((processed1 + processed2) + processed3) != dec.length) {
					java.lang.System.out.println("processed1 = " + processed1);
					java.lang.System.out.println("processed2 = " + processed2);
					java.lang.System.out.println("processed3 = " + processed3);
					java.lang.System.out.println("total length = " + dec.length);
					throw new java.lang.RuntimeException("Decryption length check " + "failed");
				}
			}
			if (java.util.Arrays.equals(plainText, dec) == false) {
				java.lang.System.out.println("cipher: " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(cipherText));
				java.lang.System.out.println("plain:  " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(plainText));
				java.lang.System.out.println("actualD: " + com.sun.crypto.provider.Cipher.CTS.CTSMode.toString(dec));
				throw new java.lang.RuntimeException("Decryption failure for test " + i);
			}
		}
	}
}