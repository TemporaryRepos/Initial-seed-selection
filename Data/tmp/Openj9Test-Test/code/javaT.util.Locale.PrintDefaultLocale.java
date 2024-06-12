public class PrintDefaultLocale {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.printf("default locale: ID: %s, Name: %s\n", java.util.Locale.getDefault().toString(), java.util.Locale.getDefault().getDisplayName(java.util.Locale.US));
		java.lang.System.out.printf("display locale: ID: %s, Name: %s\n", java.util.Locale.getDefault(java.util.Locale.Category.DISPLAY).toString(), java.util.Locale.getDefault(java.util.Locale.Category.DISPLAY).getDisplayName(java.util.Locale.US));
		java.lang.System.out.printf("format locale: ID: %s, Name: %s\n", java.util.Locale.getDefault(java.util.Locale.Category.FORMAT).toString(), java.util.Locale.getDefault(java.util.Locale.Category.FORMAT).getDisplayName(java.util.Locale.US));
		java.lang.System.out.printf("default charset: %s\n", java.nio.charset.Charset.defaultCharset());
	}
}