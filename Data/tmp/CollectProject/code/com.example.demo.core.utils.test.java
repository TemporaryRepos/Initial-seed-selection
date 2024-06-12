public class test {
	public static void main(java.lang.String[] ages) {
		java.lang.String hashAlgorithmName = "md5";
		java.lang.String credentials = "123456";
		int hashIterations = 1024;
		java.lang.String hash = "wxKYXuTPST5SG0jMQzVPsg==";
		org.apache.shiro.util.ByteSource credentialsSalt = org.apache.shiro.util.ByteSource.Util.bytes(hash);
		java.lang.String password = new org.apache.shiro.crypto.hash.SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations).toHex();
		java.lang.System.out.println(password);
	}
}