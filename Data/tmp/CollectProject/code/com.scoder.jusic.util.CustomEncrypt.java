public class CustomEncrypt {
	public static void main(java.lang.String[] args) {
		java.lang.String ids = "9734249,981411932,988914785,97879005,981612013,97949621,97919383,984113004,986013809,97416233,9090103,9194277359,96521442";
		for (java.lang.String id : ids.split(",")) {
			java.lang.String mid = com.scoder.jusic.util.CustomEncrypt.idToMid(id);
			java.lang.System.out.println("mid:" + mid);
			java.lang.System.out.println("id:" + com.scoder.jusic.util.CustomEncrypt.midToId(mid));
		}
		java.lang.String sessionId = "5b1f11d0-ad92-4855-ae44-b2052ecd76d8";
	}

	private static java.lang.String str62keys = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static java.lang.String midToId(java.lang.String str62) {
		java.lang.String id = "";
		for (int i = str62.length() - 4; i > (-4); i = i - 4) {
			int offset = (i < 0) ? 0 : i;
			int len = (i < 0) ? str62.length() % 4 : 4;
			long encode = com.scoder.jusic.util.CustomEncrypt.encode62ToInt(com.scoder.jusic.util.CustomEncrypt.left(str62, offset, len));
			java.lang.String str = java.lang.String.valueOf(encode);
			if (offset > 0) {
				str = com.scoder.jusic.util.CustomEncrypt.leftPad(str, 7, '0');
			}
			id = str + id;
		}
		return id;
	}

	public static java.lang.String idToMid(java.lang.String mid) {
		java.lang.String result = "";
		for (int i = mid.length() - 7; i > (-7); i -= 7) {
			int offset1 = (i < 0) ? 0 : i;
			int offset2 = i + 7;
			java.lang.String num = com.scoder.jusic.util.CustomEncrypt.intToEnode62(com.scoder.jusic.util.CustomEncrypt.left(mid, offset1, offset2 - offset1));
			result = num + result;
		}
		return result;
	}

	private static java.lang.String intToEnode62(java.lang.String mid) {
		long int_mid = java.lang.Long.parseLong(mid);
		java.lang.String result = "";
		do {
			long a = int_mid % 62;
			result = com.scoder.jusic.util.CustomEncrypt.str62keys.charAt(((int) (a))) + result;
			int_mid = (int_mid - a) / 62;
		} while (int_mid > 0 );
		return com.scoder.jusic.util.CustomEncrypt.leftPad(result, 4, '0');
	}

	private static long encode62ToInt(java.lang.String str62) {
		long i10 = 0;
		for (int i = 0; i < str62.length(); i++) {
			double n = (str62.length() - i) - 1;
			i10 += com.scoder.jusic.util.CustomEncrypt.str62keys.indexOf(str62.charAt(i)) * java.lang.Math.pow(62, n);
		}
		java.lang.String temp = com.scoder.jusic.util.CustomEncrypt.leftPad(java.lang.String.valueOf(i10), 7, '0');
		try {
			i10 = java.lang.Long.parseLong(temp);
		} catch (java.lang.Exception e) {
		} finally {
			return i10;
		}
	}

	public static java.lang.String leftPad(java.lang.String s, int size, char padChar) {
		int length = s.length();
		if (length == 0) {
			return s;
		}
		int pads = size - length;
		if (pads <= 0) {
			return s;
		}
		return com.scoder.jusic.util.CustomEncrypt.padding(pads, padChar).concat(s);
	}

	private static java.lang.String padding(int repeat, char padChar) {
		if (repeat < 0) {
			throw new java.lang.IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
		}
		char[] buf = new char[repeat];
		for (int i = 0; i < buf.length; i++) {
			buf[i] = padChar;
		}
		return new java.lang.String(buf);
	}

	public static java.lang.String left(java.lang.String s, int begin, int len) {
		int length = com.scoder.jusic.util.CustomEncrypt.length(s);
		if (length <= len) {
			return s;
		}
		return s.substring(begin, begin > 0 ? begin + len : len);
	}

	public static int length(java.lang.String s) {
		return s != null ? s.length() : 0;
	}
}