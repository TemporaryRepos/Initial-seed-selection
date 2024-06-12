public class MD5Checksum {
	public static byte[] createChecksum(java.lang.String filename) throws java.lang.Exception {
		java.io.InputStream fis = new java.io.FileInputStream(filename);
		byte[] buffer = new byte[1024];
		java.security.MessageDigest complete = java.security.MessageDigest.getInstance("MD5");
		int numRead;
		do {
			numRead = fis.read(buffer);
			if (numRead > 0) {
				complete.update(buffer, 0, numRead);
			}
		} while (numRead != (-1) );
		fis.close();
		return complete.digest();
	}

	public static java.lang.String getMD5Checksum(java.lang.String filename) {
		try {
			byte[] b = io.github.biezhi.wechat.utils.MD5Checksum.createChecksum(filename);
			java.lang.String result = "";
			for (int i = 0; i < b.length; i++) {
				result += java.lang.Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
			}
			return result;
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public static void main(java.lang.String[] args) {
		try {
			java.lang.System.out.println(io.github.biezhi.wechat.utils.MD5Checksum.getMD5Checksum("apache-tomcat-5.5.17.exe"));
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}