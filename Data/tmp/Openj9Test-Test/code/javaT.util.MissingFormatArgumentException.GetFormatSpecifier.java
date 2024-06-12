public class GetFormatSpecifier {
	static void fail(java.lang.String s) {
		throw new java.lang.RuntimeException(s);
	}

	public static void main(java.lang.String[] args) {
		final java.lang.String formatSpecifier = "%1$5.3s";
		try {
			java.lang.String formatResult = java.lang.String.format(formatSpecifier);
			javaT.util.MissingFormatArgumentException.GetFormatSpecifier.fail("MissingFormatArgumentException not thrown.");
		} catch (java.util.MissingFormatArgumentException ex) {
			final java.lang.String returnedFormatSpecifier = ex.getFormatSpecifier();
			if (!returnedFormatSpecifier.equals(formatSpecifier)) {
				javaT.util.MissingFormatArgumentException.GetFormatSpecifier.fail((("The specified format specifier: " + formatSpecifier) + " does not match the value from getFormatSpecifier(): ") + returnedFormatSpecifier);
			}
		}
	}
}