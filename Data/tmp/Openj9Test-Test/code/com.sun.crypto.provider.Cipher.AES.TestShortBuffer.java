public class TestShortBuffer {
	private static final java.lang.String ALGO = "AES";

	private static final java.lang.String[] MODES = new java.lang.String[]{ "ECB", "CBC", "PCBC", "CFB16", "OFB8" };

	private static final javax.crypto.SecretKey KEY = new javax.crypto.spec.SecretKeySpec(new byte[16], com.sun.crypto.provider.Cipher.AES.TestShortBuffer.ALGO);

	private static byte[] SHORTBUFFER = new byte[1];

	private static final byte[] PLAINTEXT = new byte[30];

	static {
		PLAINTEXT[0] = ((byte) (0x15));
	}

	private javax.crypto.Cipher ci = null;

	private byte[] in = null;

	private byte[] expected = null;

	private byte[] out = null;

	private int outOffset = 0;

	private TestShortBuffer(javax.crypto.Cipher ci) {
		this.ci = ci;
	}

	private void init(byte[] in, byte[] expected) {
		this.in = ((byte[]) (in.clone()));
		this.expected = ((byte[]) (expected.clone()));
		this.out = new byte[expected.length];
		this.outOffset = 0;
	}

	private static void runTest() throws java.lang.Exception {
		for (int i = 0; i < com.sun.crypto.provider.Cipher.AES.TestShortBuffer.MODES.length; i++) {
			java.lang.System.out.println(("===== TESTING MODE " + com.sun.crypto.provider.Cipher.AES.TestShortBuffer.MODES[i]) + " =====");
			javax.crypto.Cipher ci = javax.crypto.Cipher.getInstance(((com.sun.crypto.provider.Cipher.AES.TestShortBuffer.ALGO + "/") + com.sun.crypto.provider.Cipher.AES.TestShortBuffer.MODES[i]) + "/PKCS5Padding", "SunJCE");
			com.sun.crypto.provider.Cipher.AES.TestShortBuffer test = null;
			int stored = 0;
			java.security.AlgorithmParameters params = null;
			byte[] cipherText = null;
			byte[] shortBuffer = new byte[8];
			for (int k = 0; k < 2; k++) {
				byte[] expected = null;
				switch (k) {
					case 0 :
						java.lang.System.out.println("Testing with Cipher.ENCRYPT_MODE");
						ci.init(javax.crypto.Cipher.ENCRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestShortBuffer.KEY);
						cipherText = ci.doFinal(com.sun.crypto.provider.Cipher.AES.TestShortBuffer.PLAINTEXT);
						test = new com.sun.crypto.provider.Cipher.AES.TestShortBuffer(ci);
						test.init(com.sun.crypto.provider.Cipher.AES.TestShortBuffer.PLAINTEXT, cipherText);
						params = ci.getParameters();
						break;
					case 1 :
						java.lang.System.out.println("Testing with Cipher.DECRYPT_MODE");
						ci.init(javax.crypto.Cipher.DECRYPT_MODE, com.sun.crypto.provider.Cipher.AES.TestShortBuffer.KEY, params);
						test = new com.sun.crypto.provider.Cipher.AES.TestShortBuffer(ci);
						test.init(cipherText, com.sun.crypto.provider.Cipher.AES.TestShortBuffer.PLAINTEXT);
						break;
				}
				int offset = 2 + (i * 5);
				test.testUpdate();
				test.testUpdateWithUpdate(offset);
				test.testDoFinal();
				test.testDoFinalWithUpdate(offset);
			}
		}
	}

	private void checkOutput() throws java.lang.Exception {
		if (!java.util.Arrays.equals(out, expected)) {
			java.lang.System.out.println("got: " + new java.math.BigInteger(out));
			java.lang.System.out.println("expect: " + new java.math.BigInteger(expected));
			throw new java.lang.Exception("Generated different outputs");
		}
	}

	private void testUpdate() throws java.lang.Exception {
		outOffset = 0;
		int stored = 0;
		try {
			stored = ci.update(in, 0, in.length, com.sun.crypto.provider.Cipher.AES.TestShortBuffer.SHORTBUFFER);
			throw new java.lang.Exception("Should throw ShortBufferException!");
		} catch (javax.crypto.ShortBufferException sbe) {
			java.lang.System.out.println("Expected SBE thrown....");
			stored = ci.update(in, 0, in.length, out);
			stored = ci.doFinal(out, outOffset += stored);
			if (out.length != (stored + outOffset)) {
				throw new java.lang.Exception("Wrong number of output bytes");
			}
		}
		checkOutput();
	}

	private void testUpdateWithUpdate(int offset) throws java.lang.Exception {
		outOffset = 0;
		int stored = 0;
		byte[] out1 = ci.update(in, 0, offset);
		if (out1 != null) {
			java.lang.System.arraycopy(out1, 0, out, 0, out1.length);
			outOffset += out1.length;
		}
		try {
			stored = ci.update(in, offset, in.length - offset, com.sun.crypto.provider.Cipher.AES.TestShortBuffer.SHORTBUFFER);
			throw new java.lang.Exception("Should throw ShortBufferException!");
		} catch (javax.crypto.ShortBufferException sbe) {
			java.lang.System.out.println("Expected SBE thrown....");
			stored = ci.update(in, offset, in.length - offset, out, outOffset);
			stored = ci.doFinal(out, outOffset += stored);
			if (out.length != (stored + outOffset)) {
				throw new java.lang.Exception("Wrong number of output bytes");
			}
		}
		checkOutput();
	}

	private void testDoFinal() throws java.lang.Exception {
		outOffset = 0;
		int stored = 0;
		try {
			stored = ci.doFinal(in, 0, in.length, com.sun.crypto.provider.Cipher.AES.TestShortBuffer.SHORTBUFFER);
			throw new java.lang.Exception("Should throw ShortBufferException!");
		} catch (javax.crypto.ShortBufferException sbe) {
			java.lang.System.out.println("Expected SBE thrown....");
			stored = ci.doFinal(in, 0, in.length, out, 0);
			if (out.length != stored) {
				throw new java.lang.Exception("Wrong number of output bytes");
			}
		}
		checkOutput();
	}

	private void testDoFinalWithUpdate(int offset) throws java.lang.Exception {
		outOffset = 0;
		int stored = 0;
		byte[] out1 = ci.update(in, 0, offset);
		if (out1 != null) {
			java.lang.System.arraycopy(out1, 0, out, 0, out1.length);
			outOffset += out1.length;
		}
		try {
			stored = ci.doFinal(in, offset, in.length - offset, com.sun.crypto.provider.Cipher.AES.TestShortBuffer.SHORTBUFFER);
			throw new java.lang.Exception("Should throw ShortBufferException!");
		} catch (javax.crypto.ShortBufferException sbe) {
			java.lang.System.out.println("Expected SBE thrown....");
			stored = ci.doFinal(in, offset, in.length - offset, out, outOffset);
			if (out.length != (stored + outOffset)) {
				throw new java.lang.Exception("Wrong number of output bytes");
			}
		}
		checkOutput();
	}

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		com.sun.crypto.provider.Cipher.AES.TestShortBuffer.runTest();
		java.lang.System.out.println("Test Passed");
	}
}