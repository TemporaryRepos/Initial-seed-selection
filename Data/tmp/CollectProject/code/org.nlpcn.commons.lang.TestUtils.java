public class TestUtils {
	public static java.lang.String mainResources(final java.lang.String file) {
		return (java.lang.System.getProperties().getProperty("user.dir") + "/src/main/resources") + (file.startsWith("/") ? file : "/" + file);
	}

	public static java.lang.String testResources(final java.lang.String file) {
		return (java.lang.System.getProperties().getProperty("user.dir") + "/src/test/resources") + (file.startsWith("/") ? file : "/" + file);
	}

	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.String> parseStr = org.nlpcn.commons.lang.pinyin.Pinyin.unicodePinyin("日往月来");
		java.lang.System.out.println(parseStr);
		parseStr = org.nlpcn.commons.lang.pinyin.Pinyin.pinyin("日往月来");
		java.lang.System.out.println(parseStr);
		parseStr = org.nlpcn.commons.lang.pinyin.Pinyin.tonePinyin("日往月来");
		java.lang.System.out.println(parseStr);
	}
}