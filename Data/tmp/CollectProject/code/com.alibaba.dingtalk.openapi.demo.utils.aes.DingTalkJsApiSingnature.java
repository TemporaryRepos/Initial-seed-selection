public class DingTalkJsApiSingnature {
	public static java.lang.String getJsApiSingnature(java.lang.String url, java.lang.String nonce, java.lang.Long timeStamp, java.lang.String jsTicket) throws com.alibaba.dingtalk.openapi.demo.utils.aes.DingTalkEncryptException {
		java.lang.String plainTex = (((((("jsapi_ticket=" + jsTicket) + "&noncestr=") + nonce) + "&timestamp=") + timeStamp) + "&url=") + url;
		java.lang.System.out.println(plainTex);
		java.lang.String signature = "";
		try {
			java.security.MessageDigest crypt = java.security.MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(plainTex.getBytes("UTF-8"));
			signature = com.alibaba.dingtalk.openapi.demo.utils.aes.DingTalkJsApiSingnature.byteToHex(crypt.digest());
			return signature;
		} catch (java.lang.Exception e) {
			throw new com.alibaba.dingtalk.openapi.demo.utils.aes.DingTalkEncryptException(com.alibaba.dingtalk.openapi.demo.utils.aes.DingTalkEncryptException.COMPUTE_SIGNATURE_ERROR);
		}
	}

	private static java.lang.String byteToHex(final byte[] hash) {
		java.util.Formatter formatter = new java.util.Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		java.lang.String result = formatter.toString();
		formatter.close();
		return result;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String url = "http://10.62.53.138:3000/jsapi";
		java.lang.String nonce = "abcdefgh";
		java.lang.Long timeStamp = 1437027269927L;
		java.lang.String tikcet = "zHoQdGJuH0ZDebwo7sLqLzHGUueLmkWCC4RycYgkuvDu3eoROgN5qhwnQLgfzwEXtuR9SDzh6BdhyVngzAjrxV";
		java.lang.System.err.println(com.alibaba.dingtalk.openapi.demo.utils.aes.DingTalkJsApiSingnature.getJsApiSingnature(url, nonce, timeStamp, tikcet));
	}
}