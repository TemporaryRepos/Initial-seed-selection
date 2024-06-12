public class TestGHASH {
	private final java.lang.reflect.Constructor<?> GHASH;

	private final java.lang.reflect.Method UPDATE;

	private final java.lang.reflect.Method DIGEST;

	TestGHASH(java.lang.String className) throws java.lang.Exception {
		java.lang.Class<?> cls = java.lang.Class.forName(className);
		GHASH = cls.getDeclaredConstructor(byte[].class);
		GHASH.setAccessible(true);
		UPDATE = cls.getDeclaredMethod("update", byte[].class);
		UPDATE.setAccessible(true);
		DIGEST = cls.getDeclaredMethod("digest");
		DIGEST.setAccessible(true);
	}

	private java.lang.Object newGHASH(byte[] H) throws java.lang.Exception {
		return GHASH.newInstance(H);
	}

	private void updateGHASH(java.lang.Object hash, byte[] data) throws java.lang.Exception {
		UPDATE.invoke(hash, data);
	}

	private byte[] digestGHASH(java.lang.Object hash) throws java.lang.Exception {
		return ((byte[]) (DIGEST.invoke(hash)));
	}

	private static final java.lang.String HEX_DIGITS = "0123456789abcdef";

	private static java.lang.String hex(byte[] bs) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder(2 * bs.length);
		for (byte b : bs) {
			sb.append(com.sun.crypto.provider.Cipher.AES.TestGHASH.HEX_DIGITS.charAt((b >> 4) & 0xf));
			sb.append(com.sun.crypto.provider.Cipher.AES.TestGHASH.HEX_DIGITS.charAt(b & 0xf));
		}
		return sb.toString();
	}

	private static byte[] bytes(java.lang.String hex) {
		if ((hex.length() & 1) != 0) {
			throw new java.lang.AssertionError();
		}
		byte[] result = new byte[hex.length() / 2];
		for (int i = 0; i < result.length; ++i) {
			int a = com.sun.crypto.provider.Cipher.AES.TestGHASH.HEX_DIGITS.indexOf(hex.charAt(2 * i));
			int b = com.sun.crypto.provider.Cipher.AES.TestGHASH.HEX_DIGITS.indexOf(hex.charAt((2 * i) + 1));
			if ((a | b) < 0) {
				if (a < 0) {
					throw new java.lang.AssertionError("bad character " + ((int) (hex.charAt(2 * i))));
				}
				throw new java.lang.AssertionError("bad character " + ((int) (hex.charAt((2 * i) + 1))));
			}
			result[i] = ((byte) ((a << 4) | b));
		}
		return result;
	}

	private static byte[] bytes(long L0, long L1) {
		return java.nio.ByteBuffer.allocate(16).putLong(L0).putLong(L1).array();
	}

	private void check(int testCase, java.lang.String H, java.lang.String A, java.lang.String C, java.lang.String expected) throws java.lang.Exception {
		int lenA = A.length() * 4;
		while ((A.length() % 32) != 0) {
			A += '0';
		} 
		int lenC = C.length() * 4;
		while ((C.length() % 32) != 0) {
			C += '0';
		} 
		java.lang.Object hash = newGHASH(com.sun.crypto.provider.Cipher.AES.TestGHASH.bytes(H));
		updateGHASH(hash, com.sun.crypto.provider.Cipher.AES.TestGHASH.bytes(A));
		updateGHASH(hash, com.sun.crypto.provider.Cipher.AES.TestGHASH.bytes(C));
		updateGHASH(hash, com.sun.crypto.provider.Cipher.AES.TestGHASH.bytes(lenA, lenC));
		byte[] digest = digestGHASH(hash);
		java.lang.String actual = com.sun.crypto.provider.Cipher.AES.TestGHASH.hex(digest);
		if (!expected.equals(actual)) {
			throw new java.lang.AssertionError(java.lang.String.format("%d: expected %s, got %s", testCase, expected, actual));
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.sun.crypto.provider.Cipher.AES.TestGHASH test;
		java.lang.String test_class = "com.sun.crypto.provider.GHASH";
		int i = 0;
		int num_of_loops = 1;
		while (args.length > i) {
			if (args[i].compareTo("-c") == 0) {
				test_class = args[++i];
			} else if (args[i].compareTo("-n") == 0) {
				num_of_loops = java.lang.Integer.parseInt(args[++i]);
			}
			i++;
		} 
		java.lang.System.out.println(("Running " + num_of_loops) + " iterations.");
		test = new com.sun.crypto.provider.Cipher.AES.TestGHASH(test_class);
		i = 0;
		while (num_of_loops > i) {
			test.check(1, "66e94bd4ef8a2c3b884cfa59ca342b2e", "", "", "00000000000000000000000000000000");
			test.check(2, "66e94bd4ef8a2c3b884cfa59ca342b2e", "", "0388dace60b6a392f328c2b971b2fe78", "f38cbb1ad69223dcc3457ae5b6b0f885");
			test.check(3, "b83b533708bf535d0aa6e52980d53b78", "", "42831ec2217774244b7221b784d0d49c" + (("e3aa212f2c02a4e035c17e2329aca12e" + "21d514b25466931c7d8f6a5aac84aa05") + "1ba30b396a0aac973d58e091473f5985"), "7f1b32b81b820d02614f8895ac1d4eac");
			test.check(4, "b83b533708bf535d0aa6e52980d53b78", "feedfacedeadbeeffeedfacedeadbeef" + "abaddad2", "42831ec2217774244b7221b784d0d49c" + (("e3aa212f2c02a4e035c17e2329aca12e" + "21d514b25466931c7d8f6a5aac84aa05") + "1ba30b396a0aac973d58e091"), "698e57f70e6ecc7fd9463b7260a9ae5f");
			test.check(5, "b83b533708bf535d0aa6e52980d53b78", "feedfacedeadbeeffeedfacedeadbeef" + "abaddad2", "61353b4c2806934a777ff51fa22a4755" + (("699b2a714fcdc6f83766e5f97b6c7423" + "73806900e49f24b22b097544d4896b42") + "4989b5e1ebac0f07c23f4598"), "df586bb4c249b92cb6922877e444d37b");
			i++;
		} 
	}
}