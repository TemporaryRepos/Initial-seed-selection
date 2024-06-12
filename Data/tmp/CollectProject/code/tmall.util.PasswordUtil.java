public class PasswordUtil {
	public static java.lang.String encryptPassword(java.lang.String password) {
		return tmall.util.PasswordUtil.md5Encrypt(tmall.util.PasswordUtil.md5Encrypt(password).substring(8, 24));
	}

	private static java.lang.String md5Encrypt(java.lang.String str) {
		java.lang.String result = "";
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			result = new java.math.BigInteger(1, md.digest()).toString(16);
		} catch (java.lang.Exception ignored) {
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(tmall.util.PasswordUtil.encryptPassword("xi753951"));
	}
}