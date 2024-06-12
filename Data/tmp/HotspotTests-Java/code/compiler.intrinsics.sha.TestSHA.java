public class TestSHA {
	private static final int HASH_LEN = 64;

	private static final int ALIGN = 8;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String provider = java.lang.System.getProperty("provider", "SUN");
		java.lang.String algorithm = java.lang.System.getProperty("algorithm", "SHA-1");
		java.lang.String algorithm2 = java.lang.System.getProperty("algorithm2", "");
		int msgSize = java.lang.Integer.getInteger("msgSize", 1024);
		int offset = java.lang.Integer.getInteger("offset", 0) % compiler.intrinsics.sha.TestSHA.ALIGN;
		int iters = (args.length > 0) ? java.lang.Integer.valueOf(args[0]) : 100000;
		int warmupIters = (args.length > 1) ? java.lang.Integer.valueOf(args[1]) : 20000;
		compiler.intrinsics.sha.TestSHA.testSHA(provider, algorithm, msgSize, offset, iters, warmupIters);
		if (algorithm2.equals("") == false) {
			compiler.intrinsics.sha.TestSHA.testSHA(provider, algorithm2, msgSize, offset, iters, warmupIters);
		}
	}

	public static void testSHA(java.lang.String provider, java.lang.String algorithm, int msgSize, int offset, int iters, int warmupIters) throws java.lang.Exception {
		java.lang.System.out.println("provider = " + provider);
		java.lang.System.out.println("algorithm = " + algorithm);
		java.lang.System.out.println(("msgSize = " + msgSize) + " bytes");
		java.lang.System.out.println("offset = " + offset);
		java.lang.System.out.println("iters = " + iters);
		byte[] expectedHash = new byte[compiler.intrinsics.sha.TestSHA.HASH_LEN];
		byte[] hash = new byte[compiler.intrinsics.sha.TestSHA.HASH_LEN];
		byte[] data = new byte[msgSize + offset];
		for (int i = 0; i < (msgSize + offset); i++) {
			data[i] = ((byte) (i & 0xff));
		}
		try {
			java.security.MessageDigest sha = java.security.MessageDigest.getInstance(algorithm, provider);
			sha.reset();
			sha.update(data, offset, msgSize);
			expectedHash = sha.digest();
			for (int i = 0; i < warmupIters; i++) {
				sha.reset();
				sha.update(data, offset, msgSize);
				hash = sha.digest();
			}
			if (java.util.Arrays.equals(hash, expectedHash) == false) {
				java.lang.System.out.println("TestSHA Error: ");
				compiler.intrinsics.sha.TestSHA.showArray(expectedHash, "expectedHash");
				compiler.intrinsics.sha.TestSHA.showArray(hash, "computedHash");
				throw new java.lang.Exception("TestSHA Error");
			} else {
				compiler.intrinsics.sha.TestSHA.showArray(hash, "hash");
			}
			for (int i = 0; i < iters; i++) {
				sha.reset();
				sha.update(data, offset, msgSize);
				hash = sha.digest();
			}
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("Exception: " + e);
			throw new java.lang.Exception(e);
		}
	}

	static void showArray(byte[] b, java.lang.String name) {
		java.lang.System.out.format("%s [%d]: ", name, b.length);
		for (int i = 0; i < java.lang.Math.min(b.length, compiler.intrinsics.sha.TestSHA.HASH_LEN); i++) {
			java.lang.System.out.format("%02x ", b[i] & 0xff);
		}
		java.lang.System.out.println();
	}
}