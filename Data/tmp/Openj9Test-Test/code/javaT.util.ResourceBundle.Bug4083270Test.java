public class Bug4083270Test extends javaT.util.ResourceBundle.RBTestFmwk {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.util.ResourceBundle.Bug4083270Test(true).run(args);
	}

	public Bug4083270Test(boolean dummy) {
	}

	public Bug4083270Test() throws java.lang.Exception {
		errln("ResourceBundle loaded a non-ResourceBundle class");
	}

	public void testRecursiveResourceLoads() throws java.lang.Exception {
		final java.lang.String className = getClass().getName();
		try {
			java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(className, java.util.Locale.getDefault());
			if (bundle == null) {
				errln("ResourceBundle did not find properties file");
			} else if (!(bundle instanceof java.util.PropertyResourceBundle)) {
				errln("ResourceBundle loaded a non-ResourceBundle class");
			}
		} catch (java.util.MissingResourceException e) {
			errln("ResourceBundle threw a MissingResourceException");
		}
	}
}