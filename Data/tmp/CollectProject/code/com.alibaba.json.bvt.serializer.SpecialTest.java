public class SpecialTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int count = 0;
		for (int i = 0; i < 1000; ++i) {
			char ch = ((char) (i));
			if (com.alibaba.json.bvt.serializer.SpecialTest.isSpecial(ch)) {
				count++;
			}
		}
		java.lang.System.out.println(count);
	}

	static final long flags;

	static {
		long val = 0L;
		val |= 1L << ('"' - 31);
		val |= 1L << ('\\' - 31);
		flags = val;
	}

	static boolean isSpecial(char ch) {
		if (ch <= 31) {
			return true;
		}
		if (ch > '\\') {
			return false;
		}
		return ((1L << (ch - 31)) & com.alibaba.json.bvt.serializer.SpecialTest.flags) != 0;
	}

	static boolean isSpecial(char ch, int features) {
		if (ch == ' ') {
			return false;
		}
		if (ch == '/') {
			return com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(features, SerializerFeature.WriteSlashAsSpecial);
		}
		if ((ch > '#') && (ch != '\\')) {
			return false;
		}
		if (((ch <= 0x1f) || (ch == '\\')) || (ch == '"')) {
			return true;
		}
		return false;
	}
}