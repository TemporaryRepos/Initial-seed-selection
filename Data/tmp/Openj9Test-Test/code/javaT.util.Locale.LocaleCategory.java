public class LocaleCategory {
	private static java.util.Locale base = null;

	private static java.util.Locale disp = null;

	private static java.util.Locale fmt = null;

	private static java.lang.String enc = null;

	public static void main(java.lang.String[] args) {
		java.util.Locale reservedLocale = java.util.Locale.getDefault();
		try {
			java.util.Locale.Builder builder = new java.util.Locale.Builder();
			javaT.util.Locale.LocaleCategory.base = builder.setLanguage(java.lang.System.getProperty("user.language", "")).setScript(java.lang.System.getProperty("user.script", "")).setRegion(java.lang.System.getProperty("user.country", "")).setVariant(java.lang.System.getProperty("user.variant", "")).build();
			javaT.util.Locale.LocaleCategory.disp = builder.setLanguage(java.lang.System.getProperty("user.language.display", java.util.Locale.getDefault().getLanguage())).setScript(java.lang.System.getProperty("user.script.display", java.util.Locale.getDefault().getScript())).setRegion(java.lang.System.getProperty("user.country.display", java.util.Locale.getDefault().getCountry())).setVariant(java.lang.System.getProperty("user.variant.display", java.util.Locale.getDefault().getVariant())).build();
			javaT.util.Locale.LocaleCategory.fmt = builder.setLanguage(java.lang.System.getProperty("user.language.format", java.util.Locale.getDefault().getLanguage())).setScript(java.lang.System.getProperty("user.script.format", java.util.Locale.getDefault().getScript())).setRegion(java.lang.System.getProperty("user.country.format", java.util.Locale.getDefault().getCountry())).setVariant(java.lang.System.getProperty("user.variant.format", java.util.Locale.getDefault().getVariant())).build();
			javaT.util.Locale.LocaleCategory.checkDefault();
			javaT.util.Locale.LocaleCategory.testGetSetDefault();
			javaT.util.Locale.LocaleCategory.testBug7079486();
		} finally {
			java.util.Locale.setDefault(reservedLocale);
		}
	}

	static void checkDefault() {
		if (((!javaT.util.Locale.LocaleCategory.base.equals(java.util.Locale.getDefault())) || (!javaT.util.Locale.LocaleCategory.disp.equals(java.util.Locale.getDefault(java.util.Locale.Category.DISPLAY)))) || (!javaT.util.Locale.LocaleCategory.fmt.equals(java.util.Locale.getDefault(java.util.Locale.Category.FORMAT)))) {
			throw new java.lang.RuntimeException("Some of the return values from getDefault() do not agree with the locale derived from \"user.xxxx\" system properties");
		}
	}

	static void testGetSetDefault() {
		try {
			java.util.Locale.setDefault(null, null);
			throw new java.lang.RuntimeException("setDefault(null, null) should throw a NullPointerException");
		} catch (java.lang.NullPointerException npe) {
		}
		java.util.Locale.setDefault(java.util.Locale.CHINA);
		if ((!java.util.Locale.CHINA.equals(java.util.Locale.getDefault(java.util.Locale.Category.DISPLAY))) || (!java.util.Locale.CHINA.equals(java.util.Locale.getDefault(java.util.Locale.Category.FORMAT)))) {
			throw new java.lang.RuntimeException("setDefault() should set all default locales for all categories");
		}
	}

	static void testBug7079486() {
		java.util.Locale zh_Hans_CN = java.util.Locale.forLanguageTag("zh-Hans-CN");
		if (zh_Hans_CN.getDisplayScript(java.util.Locale.US).equals(zh_Hans_CN.getDisplayScript(zh_Hans_CN))) {
			return;
		}
		java.util.Locale.setDefault(java.util.Locale.US);
		java.lang.String en_script = zh_Hans_CN.getDisplayScript();
		java.util.Locale.setDefault(java.util.Locale.Category.DISPLAY, zh_Hans_CN);
		java.lang.String zh_script = zh_Hans_CN.getDisplayScript();
		if (en_script.equals(zh_script)) {
			throw new java.lang.RuntimeException("Locale.getDisplayScript() (no args) does not honor default DISPLAY locale");
		}
	}
}