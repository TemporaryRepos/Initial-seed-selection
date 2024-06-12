public class SignUtil {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(com.doinb.utils.SignUtil.class);

	public static void validateParams(java.lang.String nonce, java.lang.String sign, java.lang.String timeStamp, java.lang.String clientId) {
		try {
			org.springframework.util.Assert.notNull(nonce, "签名验证失败:NONCE不能为空");
			org.springframework.util.Assert.notNull(sign, "签名验证失败:SING不能为空");
			org.springframework.util.Assert.notNull(timeStamp, "签名验证失败:TIMESTAMP不能为空");
			org.springframework.util.Assert.notNull(clientId, "签名验证失败:CLIENT_ID不能为空");
		} catch (java.lang.Exception e) {
			com.doinb.utils.SignUtil.log.error(e.getMessage());
			throw new java.lang.IllegalArgumentException(e.getMessage());
		}
	}

	public static java.lang.String getSign(java.lang.String nonce, java.lang.String secret, java.lang.String timeStamp) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		sb.append("nonce").append(nonce).append(secret).append(timeStamp);
		char[] sortChars = sb.toString().toCharArray();
		java.util.Arrays.sort(sortChars);
		java.lang.String encodeStr = java.lang.String.valueOf(sortChars);
		java.lang.String signStr = org.apache.commons.codec.digest.DigestUtils.md5Hex(encodeStr).toLowerCase();
		return signStr;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String sbf = "ihdfegpkjalbc";
		char[] sortChars = sbf.toCharArray();
		java.util.Arrays.parallelSort(sortChars);
		java.lang.System.out.println(sortChars);
	}
}