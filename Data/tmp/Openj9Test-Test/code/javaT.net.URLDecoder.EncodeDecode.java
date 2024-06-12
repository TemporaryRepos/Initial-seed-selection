public class EncodeDecode {
	public static void main(java.lang.String[] args) {
		java.lang.String str = "fds@$";
		java.lang.String encStr = java.net.URLEncoder.encode(str);
		java.lang.String decStr = java.net.URLDecoder.decode(encStr);
	}
}