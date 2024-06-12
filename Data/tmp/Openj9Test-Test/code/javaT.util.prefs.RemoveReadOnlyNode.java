public class RemoveReadOnlyNode {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String osName = java.lang.System.getProperty("os.name");
		if (osName.startsWith("Windows")) {
			return;
		}
		java.util.prefs.Preferences root = java.util.prefs.Preferences.userRoot();
		java.util.prefs.Preferences node1 = root.node("node1");
		java.util.prefs.Preferences node1A = node1.node("node1A");
		java.util.prefs.Preferences node1B = node1.node("node1B");
		node1B.put("mykey", "myvalue");
		node1.flush();
		java.lang.String node1BDirName = (java.lang.System.getProperty("user.home") + "/.java/.userPrefs") + "/node1/node1B";
		java.io.File node1BDir = new java.io.File(node1BDirName);
		node1BDir.setReadOnly();
		try {
			node1.removeNode();
		} catch (java.util.prefs.BackingStoreException ex) {
		} finally {
			java.lang.Runtime.getRuntime().exec("chmod 755 " + node1BDirName).waitFor();
			try {
				node1.removeNode();
			} catch (java.lang.Exception e) {
			}
		}
	}
}