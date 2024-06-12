public class MD5Utils {
	public static java.lang.String md5(byte[] original) throws java.security.NoSuchAlgorithmException {
		java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		md.update(original);
		byte[] digest = md.digest();
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		for (byte b : digest) {
			sb.append(java.lang.String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	public static java.lang.String md5(java.lang.String originalStr, java.lang.String charset) throws java.io.UnsupportedEncodingException, java.security.NoSuchAlgorithmException {
		byte[] original = originalStr.getBytes(charset);
		return cn.edu.hfut.dmic.webcollector.util.MD5Utils.md5(original);
	}

	public static void main(java.lang.String[] args) throws java.io.UnsupportedEncodingException, java.security.NoSuchAlgorithmException {
		java.lang.System.out.println(cn.edu.hfut.dmic.webcollector.util.MD5Utils.md5("测试abc", "utf-8"));
	}
}