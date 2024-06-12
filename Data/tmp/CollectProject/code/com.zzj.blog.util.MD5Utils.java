public class MD5Utils {
	public static java.lang.String code(java.lang.String str) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] byteDigest = md.digest();
			int i;
			java.lang.StringBuffer buf = new java.lang.StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++) {
				i = byteDigest[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(java.lang.Integer.toHexString(i));
			}
			return buf.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.zzj.blog.util.MD5Utils.code("123456"));
	}
}