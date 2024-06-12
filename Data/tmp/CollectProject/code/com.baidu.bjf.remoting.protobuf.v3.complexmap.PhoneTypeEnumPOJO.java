public enum PhoneTypeEnumPOJO implements com.baidu.bjf.remoting.protobuf.EnumReadable {

	MOBILE(0),
	HOME(1),
	WORK(2);
	private int value;

	private PhoneTypeEnumPOJO(int value) {
		this.value = value;
	}

	@java.lang.Override
	public int value() {
		return value;
	}

	public static void main(java.lang.String[] args) {
		try {
			java.lang.String string = "a网a";
			byte[] utf8 = string.getBytes("UTF-8");
			string = new java.lang.String(utf8, "UTF-8");
			java.lang.System.out.println(string);
		} catch (java.io.UnsupportedEncodingException e) {
		}
	}
}