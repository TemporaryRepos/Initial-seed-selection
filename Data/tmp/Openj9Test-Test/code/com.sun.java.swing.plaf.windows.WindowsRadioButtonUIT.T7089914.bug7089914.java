public class bug7089914 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("Not WindowsLookAndFeel, test skipped");
			return;
		}
		javax.swing.SwingUtilities.invokeAndWait(new java.lang.Runnable() {
			@java.lang.Override
			public void run() {
				javax.swing.JRadioButton rb = new javax.swing.JRadioButton();
				if (!"com.sun.java.swing.plaf.windows.WindowsRadioButtonUI".equals(rb.getUI().getClass().getName())) {
					throw new java.lang.RuntimeException("Unexpected UI class of JRadioButton");
				}
				try {
					java.lang.reflect.Field initializedField = rb.getUI().getClass().getDeclaredField("initialized");
					initializedField.setAccessible(true);
					if (!initializedField.getBoolean(rb.getUI())) {
						throw new java.lang.RuntimeException("initialized is false");
					}
					rb.getUI().uninstallUI(rb);
					if (initializedField.getBoolean(rb.getUI())) {
						throw new java.lang.RuntimeException("initialized is true");
					}
				} catch (java.lang.NoSuchFieldException | java.lang.IllegalAccessException e) {
					throw new java.lang.RuntimeException(e);
				}
			}
		});
	}
}