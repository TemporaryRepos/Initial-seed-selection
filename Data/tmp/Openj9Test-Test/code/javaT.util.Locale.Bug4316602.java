public class Bug4316602 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String language = "ja";
		java.util.Locale aLocale = new java.util.Locale(language);
		if (aLocale.toString().equals(language)) {
			java.lang.System.out.println("passed");
		} else {
			java.lang.System.out.println("Bug4316602 failed");
			throw new java.lang.Exception("Bug4316602 failed");
		}
	}
}