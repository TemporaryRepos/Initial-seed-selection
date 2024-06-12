public class RemoveUnregedListener {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.prefs.Preferences userRoot = null;
		java.util.prefs.Preferences N1 = null;
		javaT.util.prefs.NodeChangeListenerTestAdd ncl = new javaT.util.prefs.NodeChangeListenerTestAdd();
		javaT.util.prefs.NodeChangeListenerTestAdd ncl2 = new javaT.util.prefs.NodeChangeListenerTestAdd();
		javaT.util.prefs.NodeChangeListenerTestAdd ncl3 = new javaT.util.prefs.NodeChangeListenerTestAdd();
		try {
			userRoot = java.util.prefs.Preferences.userRoot();
			N1 = userRoot.node("N1");
			userRoot.flush();
			N1.addNodeChangeListener(ncl);
			N1.addNodeChangeListener(ncl2);
			N1.removeNodeChangeListener(ncl3);
			throw new java.lang.RuntimeException();
		} catch (java.lang.IllegalArgumentException iae) {
			java.lang.System.out.println("Test Passed!");
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("Test Failed");
			throw e;
		}
	}
}