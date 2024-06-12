public class PasswordUtilTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String password = "123456";
		password = org.apache.commons.codec.digest.DigestUtils.md5Hex(password);
		java.lang.System.out.println("md5:" + password);
		java.lang.String initPassword = io.geekidea.boot.auth.util.PasswordUtil.encrypt(password, "666");
		java.lang.System.out.println("initPassword:" + initPassword);
	}
}