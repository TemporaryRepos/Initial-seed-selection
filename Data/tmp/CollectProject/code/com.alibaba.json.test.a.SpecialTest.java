public class SpecialTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int count = 0;
		for (int i = 0; i < 1000; ++i) {
			char ch = ((char) (i));
			if (com.alibaba.json.test.a.SpecialTest.isSpecial(ch, 0)) {
				count++;
			}
		}
		java.lang.System.out.println(count);
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