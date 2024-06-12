public class RemoveNullKeyCheck {
	private static boolean failed = false;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.util.prefs.RemoveNullKeyCheck.checkPreferencesRemove();
		javaT.util.prefs.RemoveNullKeyCheck.checkAbstractPreferencesRemove();
		if (javaT.util.prefs.RemoveNullKeyCheck.failed) {
			throw new java.lang.RuntimeException("Expected NullPointerException " + "not thrown");
		}
	}

	public static void checkPreferencesRemove() {
		try {
			java.util.prefs.Preferences node = java.util.prefs.Preferences.userRoot().node("N1");
			node.remove(null);
			javaT.util.prefs.RemoveNullKeyCheck.failed = true;
		} catch (java.lang.NullPointerException npe) {
		}
	}

	public static void checkAbstractPreferencesRemove() {
		java.util.prefs.Preferences abstrPrefs = new java.util.prefs.AbstractPreferences(null, "") {
			@java.lang.Override
			protected void putSpi(java.lang.String key, java.lang.String value) {
			}

			@java.lang.Override
			protected java.lang.String getSpi(java.lang.String key) {
				return null;
			}

			@java.lang.Override
			protected void removeSpi(java.lang.String key) {
			}

			@java.lang.Override
			protected void removeNodeSpi() throws java.util.prefs.BackingStoreException {
			}

			@java.lang.Override
			protected java.lang.String[] keysSpi() throws java.util.prefs.BackingStoreException {
				return new java.lang.String[0];
			}

			@java.lang.Override
			protected java.lang.String[] childrenNamesSpi() throws java.util.prefs.BackingStoreException {
				return new java.lang.String[0];
			}

			@java.lang.Override
			protected java.util.prefs.AbstractPreferences childSpi(java.lang.String name) {
				return null;
			}

			@java.lang.Override
			protected void syncSpi() throws java.util.prefs.BackingStoreException {
			}

			@java.lang.Override
			protected void flushSpi() throws java.util.prefs.BackingStoreException {
			}
		};
		try {
			abstrPrefs.remove(null);
			javaT.util.prefs.RemoveNullKeyCheck.failed = true;
		} catch (java.lang.NullPointerException npe) {
		}
	}
}