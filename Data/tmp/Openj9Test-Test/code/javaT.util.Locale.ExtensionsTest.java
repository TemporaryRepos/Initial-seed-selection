public class ExtensionsTest {
	public static void main(java.lang.String[] args) {
		java.util.Locale jaJPJP = new java.util.Locale("ja", "JP", "JP");
		if (!jaJPJP.hasExtensions()) {
			javaT.util.Locale.ExtensionsTest.error(jaJPJP + " should have an extension.");
		}
		java.util.Locale stripped = jaJPJP.stripExtensions();
		if (stripped.hasExtensions()) {
			javaT.util.Locale.ExtensionsTest.error(stripped + " should NOT have an extension.");
		}
		if (jaJPJP.equals(stripped)) {
			throw new java.lang.RuntimeException("jaJPJP equals stripped");
		}
		if (!"ja-JP-x-lvariant-JP".equals(stripped.toLanguageTag())) {
			javaT.util.Locale.ExtensionsTest.error("stripped.toLanguageTag() isn't ja-JP-x-lvariant-JP");
		}
		java.util.Locale enUSja = java.util.Locale.forLanguageTag("en-US-u-ca-japanese");
		if (!enUSja.stripExtensions().equals(java.util.Locale.US)) {
			javaT.util.Locale.ExtensionsTest.error("stripped enUSja not equals Locale.US");
		}
		java.util.Locale enUS = java.util.Locale.US.stripExtensions();
		if (enUS != java.util.Locale.US) {
			javaT.util.Locale.ExtensionsTest.error("stripped Locale.US != Locale.US");
		}
	}

	private static void error(java.lang.String msg) {
		throw new java.lang.RuntimeException(msg);
	}
}