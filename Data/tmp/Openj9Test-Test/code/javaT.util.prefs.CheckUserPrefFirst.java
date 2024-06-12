public class CheckUserPrefFirst {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(javaT.util.prefs.CheckUserPrefFirst.class);
		prefs.put("Check", "Success");
		prefs.flush();
	}
}