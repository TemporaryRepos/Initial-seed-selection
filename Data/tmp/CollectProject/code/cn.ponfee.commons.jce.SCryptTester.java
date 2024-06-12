public class SCryptTester {
	java.lang.String passwd = "secret";

	@org.junit.Test
	public void scrypt() {
		int N = 8388608;
		int r = 1;
		int p = 1;
		java.lang.String hashed = cn.ponfee.commons.jce.passwd.SCrypt.create(passwd, N, r, p);
		java.lang.String[] parts = hashed.split("\\$");
		org.junit.Assert.assertEquals(5, parts.length);
		org.junit.Assert.assertEquals("s0", parts[1]);
		org.junit.Assert.assertEquals(16, java.util.Base64.getUrlDecoder().decode(parts[3]).length);
		org.junit.Assert.assertEquals(32, java.util.Base64.getUrlDecoder().decode(parts[4]).length);
		long params = java.lang.Long.parseLong(parts[2], 16);
		org.junit.Assert.assertEquals(N, ((int) (java.lang.Math.pow(2, (params >> 16) & 0xffff))));
		org.junit.Assert.assertEquals(r, (params >> 8) & 0xff);
		org.junit.Assert.assertEquals(p, (params >> 0) & 0xff);
	}

	@org.junit.Test
	public void check() {
		java.lang.String hashed = cn.ponfee.commons.jce.passwd.SCrypt.create(passwd, 16384, 8, 1);
		org.junit.Assert.assertTrue(cn.ponfee.commons.jce.passwd.SCrypt.check(passwd, hashed));
		org.junit.Assert.assertFalse(cn.ponfee.commons.jce.passwd.SCrypt.check("s3cr3t", hashed));
	}

	@org.junit.Test
	public void format_0_rp_max() {
		int N = 2;
		int r = 255;
		int p = 255;
		java.lang.String hashed = cn.ponfee.commons.jce.passwd.SCrypt.create(passwd, N, r, p);
		org.junit.Assert.assertTrue(cn.ponfee.commons.jce.passwd.SCrypt.check(passwd, hashed));
		java.lang.String[] parts = hashed.split("\\$");
		long params = java.lang.Long.parseLong(parts[2], 16);
		org.junit.Assert.assertEquals(N, ((int) (java.lang.Math.pow(2, (params >>> 16) & 0xffff))));
		org.junit.Assert.assertEquals(r, (params >> 8) & 0xff);
		org.junit.Assert.assertEquals(p, (params >> 0) & 0xff);
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println((java.lang.Integer.MAX_VALUE / 128) / 255);
		java.lang.System.out.println(java.lang.Long.toString(8388608, 16));
		java.lang.System.out.println(java.lang.Math.pow(2, 0xe));
	}
}