public class StringUtils {
	public static final java.lang.String ENCODE_GBK = "GBK";

	public static final java.lang.String ENCODE_UTF_8 = "UTF-8";

	public static int getLength(java.lang.String str, java.lang.String encode) throws java.io.UnsupportedEncodingException {
		return str.getBytes(encode).length;
	}

	public static int getLength(java.lang.String s) {
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			int ascii = java.lang.Character.codePointAt(s, i);
			if ((ascii >= 0) && (ascii <= 255)) {
				length++;
			} else {
				length += 2;
			}
		}
		return length;
	}

	public static java.lang.String desensitizeIPV4(java.lang.String ipv4) {
		java.lang.String[] split = ipv4.split("\\.");
		java.lang.StringBuilder ip = new java.lang.StringBuilder();
		for (int i = 0; i < split.length; i++) {
			if (i >= (split.length / 2)) {
				ip.append("*");
			} else {
				ip.append(split[i]);
			}
			if (i != (split.length - 1)) {
				ip.append(".");
			}
		}
		return ip.toString();
	}

	public static boolean isQQMusicId(java.lang.String id) {
		java.lang.String regEx = "^[a-zA-Z0-9]{14}$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(regEx);
		java.util.regex.Matcher m = p.matcher(id);
		boolean result = m.find();
		return result;
	}

	public static boolean isMGMusicId(java.lang.String id) {
		java.lang.String regEx = "^[a-zA-Z0-9]{11}$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(regEx);
		java.util.regex.Matcher m = p.matcher(id);
		boolean result = m.find();
		return result;
	}

	public static java.lang.Long getLyricsDuration(java.lang.String lyrics) {
		if ((lyrics != null) && (!"".equals(lyrics))) {
			int startPos = lyrics.lastIndexOf("[");
			int endPos = lyrics.lastIndexOf("]");
			java.lang.String durationStr = lyrics.substring(startPos + 1, endPos);
			return com.scoder.jusic.util.StringUtils.lyricStrToMillisSecond(durationStr);
		} else {
			return null;
		}
	}

	public static long strToMillisSecond(java.lang.String durationStr) {
		int hour = java.lang.Integer.valueOf(durationStr.substring(0, 2));
		int minutes = java.lang.Integer.valueOf(durationStr.substring(3, 5));
		int second = java.lang.Integer.valueOf(durationStr.substring(6, 8));
		long sumMillisecond = ((((hour * 60) * 60) * 1000) + ((minutes * 60) * 1000)) + (second * 1000);
		return sumMillisecond;
	}

	public static long lyricStrToMillisSecond(java.lang.String durationStr) {
		int minutes = java.lang.Integer.valueOf(durationStr.substring(0, 2));
		int second = java.lang.Integer.valueOf(durationStr.substring(3, 5));
		int millisecond = java.lang.Integer.valueOf(durationStr.substring(6, 8));
		long sumMillisecond = (((minutes * 60) * 1000) + (second * 1000)) + millisecond;
		return sumMillisecond;
	}

	public static void main(java.lang.String[] args) throws java.io.UnsupportedEncodingException {
		java.lang.System.out.println(com.scoder.jusic.util.StringUtils.lyricStrToMillisSecond("04:07.93"));
	}
}