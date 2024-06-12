public class SM3DigestTest {
	public static void main(java.lang.String[] args) {
		java.lang.String actual = org.apache.commons.codec.binary.Hex.encodeHexString(cn.ponfee.commons.jce.sm.SM3Digest.getInstance().doFinal("0123456789".getBytes()));
		if (!"09093b72553f5d9d622d6c62f5ffd916ee959679b1bd4d169c3e12aa8328e743".equals(actual)) {
			java.lang.System.err.println("sm3 digest error!");
		} else {
			java.lang.System.out.println("SUCCESS!");
		}
		byte[] data = "0123456789".getBytes();
		byte[] hash = cn.ponfee.commons.jce.sm.SM3Digest.getInstance().doFinal(data);
		java.lang.System.out.println(org.apache.commons.codec.binary.Hex.encodeHexString(hash));
		cn.ponfee.commons.jce.sm.SM3Digest sm3 = cn.ponfee.commons.jce.sm.SM3Digest.getInstance();
		hash = sm3.doFinal(data);
		java.lang.System.out.println(org.apache.commons.codec.binary.Hex.encodeHexString(hash));
		hash = sm3.doFinal(data);
		java.lang.System.out.println(org.apache.commons.codec.binary.Hex.encodeHexString(hash));
		hash = sm3.doFinal(data);
		java.lang.System.out.println(org.apache.commons.codec.binary.Hex.encodeHexString(hash));
		cn.ponfee.commons.jce.sm.SM3Digest sm3_1 = cn.ponfee.commons.jce.sm.SM3Digest.getInstance();
		org.bouncycastle.crypto.digests.SM3Digest sm3_2 = new org.bouncycastle.crypto.digests.SM3Digest();
		for (int i = 0; i < 100; i++) {
			byte[] data1 = cn.ponfee.commons.util.SecureRandoms.nextBytes(java.util.concurrent.ThreadLocalRandom.current().nextInt(65537) + 1);
			byte[] data2 = cn.ponfee.commons.util.SecureRandoms.nextBytes(java.util.concurrent.ThreadLocalRandom.current().nextInt(65537) + 1);
			sm3_1.update(data1);
			sm3_2.update(data1, 0, data1.length);
			sm3_2.update(data2, 0, data2.length);
			byte[] dig = new byte[sm3_2.getDigestSize()];
			sm3_2.doFinal(dig, 0);
			org.junit.Assert.assertArrayEquals(sm3_1.doFinal(data2), dig);
		}
	}
}