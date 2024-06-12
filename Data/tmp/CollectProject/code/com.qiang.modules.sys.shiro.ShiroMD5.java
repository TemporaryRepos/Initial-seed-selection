public class ShiroMD5 {
	public static java.lang.Object MD5(java.lang.String username, java.lang.String password) {
		java.lang.String hashAlgorithName = "MD5";
		int hashIterations = 1024;
		org.apache.shiro.util.ByteSource credentialsSalt = org.apache.shiro.util.ByteSource.Util.bytes(username);
		java.lang.Object obj = new org.apache.shiro.crypto.hash.SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
		return obj;
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.qiang.modules.sys.shiro.ShiroMD5.MD5("15383466854", "123456"));
	}
}