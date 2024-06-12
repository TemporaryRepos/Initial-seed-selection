public class Bug4210525 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String language = "en";
		java.lang.String country = "US";
		java.lang.String variant = "socal";
		java.util.Locale aLocale = new java.util.Locale(language, country, variant);
		java.lang.String localeVariant = aLocale.getVariant();
		if (localeVariant.equals(variant)) {
			java.lang.System.out.println("passed");
		} else {
			java.lang.System.out.println("failed");
			throw new java.lang.Exception("Bug4210525 test failed.");
		}
	}
}