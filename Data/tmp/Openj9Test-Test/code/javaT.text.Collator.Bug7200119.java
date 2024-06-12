public class Bug7200119 {
	public static void main(java.lang.String[] args) {
		java.util.List<java.util.Locale> avail = java.util.Arrays.asList(java.text.Collator.getAvailableLocales());
		if (!avail.contains(java.util.Locale.US)) {
			throw new java.lang.RuntimeException("Failed.");
		}
	}
}