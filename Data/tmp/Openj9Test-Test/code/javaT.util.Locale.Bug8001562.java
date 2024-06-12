public class Bug8001562 {
	static final java.lang.String[] jdk7availTags = new java.lang.String[]{ "ar", "ar-AE", "ar-BH", "ar-DZ", "ar-EG", "ar-IQ", "ar-JO", "ar-KW", "ar-LB", "ar-LY", "ar-MA", "ar-OM", "ar-QA", "ar-SA", "ar-SD", "ar-SY", "ar-TN", "ar-YE", "be", "be-BY", "bg", "bg-BG", "ca", "ca-ES", "cs", "cs-CZ", "da", "da-DK", "de", "de-AT", "de-CH", "de-DE", "de-LU", "el", "el-CY", "el-GR", "en", "en-AU", "en-CA", "en-GB", "en-IE", "en-IN", "en-MT", "en-NZ", "en-PH", "en-SG", "en-US", "en-ZA", "es", "es-AR", "es-BO", "es-CL", "es-CO", "es-CR", "es-DO", "es-EC", "es-ES", "es-GT", "es-HN", "es-MX", "es-NI", "es-PA", "es-PE", "es-PR", "es-PY", "es-SV", "es-US", "es-UY", "es-VE", "et", "et-EE", "fi", "fi-FI", "fr", "fr-BE", "fr-CA", "fr-CH", "fr-FR", "fr-LU", "ga", "ga-IE", "he", "he-IL", "hi-IN", "hr", "hr-HR", "hu", "hu-HU", "id", "id-ID", "is", "is-IS", "it", "it-CH", "it-IT", "ja", "ja-JP", "ja-JP-u-ca-japanese-x-lvariant-JP", "ko", "ko-KR", "lt", "lt-LT", "lv", "lv-LV", "mk", "mk-MK", "ms", "ms-MY", "mt", "mt-MT", "nl", "nl-BE", "nl-NL", "no", "no-NO", "no-NO-x-lvariant-NY", "pl", "pl-PL", "pt", "pt-BR", "pt-PT", "ro", "ro-RO", "ru", "ru-RU", "sk", "sk-SK", "sl", "sl-SI", "sq", "sq-AL", "sr", "sr-BA", "sr-CS", "sr-Latn", "sr-Latn-BA", "sr-Latn-ME", "sr-Latn-RS", "sr-ME", "sr-RS", "sv", "sv-SE", "th", "th-TH", "th-TH-u-nu-thai-x-lvariant-TH", "tr", "tr-TR", "uk", "uk-UA", "vi", "vi-VN", "zh", "zh-CN", "zh-HK", "zh-SG", "zh-TW" };

	static java.util.List<java.util.Locale> jdk7availLocs = new java.util.ArrayList<>();

	static {
		for (java.lang.String locStr : jdk7availTags) {
			jdk7availLocs.add(java.util.Locale.forLanguageTag(locStr));
		}
	}

	public static void main(java.lang.String[] args) {
		java.util.List<java.util.Locale> avail = java.util.Arrays.asList(java.text.BreakIterator.getAvailableLocales());
		javaT.util.Locale.Bug8001562.diffLocale(java.text.BreakIterator.class, avail);
		avail = java.util.Arrays.asList(java.text.Collator.getAvailableLocales());
		javaT.util.Locale.Bug8001562.diffLocale(java.text.Collator.class, avail);
		avail = java.util.Arrays.asList(java.text.DateFormat.getAvailableLocales());
		javaT.util.Locale.Bug8001562.diffLocale(java.text.DateFormat.class, avail);
		avail = java.util.Arrays.asList(java.text.DateFormatSymbols.getAvailableLocales());
		javaT.util.Locale.Bug8001562.diffLocale(java.text.DateFormatSymbols.class, avail);
		avail = java.util.Arrays.asList(java.text.DecimalFormatSymbols.getAvailableLocales());
		javaT.util.Locale.Bug8001562.diffLocale(java.text.DecimalFormatSymbols.class, avail);
		avail = java.util.Arrays.asList(java.text.NumberFormat.getAvailableLocales());
		javaT.util.Locale.Bug8001562.diffLocale(java.text.NumberFormat.class, avail);
		avail = java.util.Arrays.asList(java.util.Locale.getAvailableLocales());
		javaT.util.Locale.Bug8001562.diffLocale(java.util.Locale.class, avail);
	}

	static void diffLocale(java.lang.Class c, java.util.List<java.util.Locale> locs) {
		java.lang.String diff = "";
		java.lang.System.out.printf("Only in target locales (%s.getAvailableLocales()): ", c.getSimpleName());
		for (java.util.Locale l : locs) {
			if (!javaT.util.Locale.Bug8001562.jdk7availLocs.contains(l)) {
				diff += ("\"" + l.toLanguageTag()) + "\", ";
			}
		}
		java.lang.System.out.println(diff);
		diff = "";
		java.lang.System.out.printf("Only in JDK7 (%s.getAvailableLocales()): ", c.getSimpleName());
		for (java.util.Locale l : javaT.util.Locale.Bug8001562.jdk7availLocs) {
			if (!locs.contains(l)) {
				diff += ("\"" + l.toLanguageTag()) + "\", ";
			}
		}
		java.lang.System.out.println(diff);
		if (diff.length() > 0) {
			throw new java.lang.RuntimeException("Above locale(s) were not included in the target available locales");
		}
	}
}