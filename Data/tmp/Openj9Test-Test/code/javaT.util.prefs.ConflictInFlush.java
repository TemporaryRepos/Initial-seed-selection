public final class ConflictInFlush {
	public static void main(java.lang.String[] args) {
		java.util.prefs.Preferences root = java.util.prefs.Preferences.userRoot();
		try {
			java.util.prefs.Preferences node = root.node("1/2/3");
			node.flush();
			java.lang.System.out.println(("Node " + node) + " has been created");
			java.lang.System.out.println("Removing node " + node);
			node.removeNode();
			node.flush();
		} catch (java.util.prefs.BackingStoreException bse) {
			bse.printStackTrace();
		}
	}
}