public class ControlFactoryTest {
	private static interface Factory {
		public abstract java.util.ResourceBundle.Control getControl(java.util.List<java.lang.String> formats);

		public abstract java.lang.String name();
	}

	static int errors;

	public static void main(java.lang.String[] args) {
		javaT.util.ResourceBundle.Control.ControlFactoryTest.testControlFactory(new javaT.util.ResourceBundle.Control.ControlFactoryTest.Factory() {
			public java.util.ResourceBundle.Control getControl(java.util.List<java.lang.String> formats) {
				return java.util.ResourceBundle.Control.getControl(formats);
			}

			public java.lang.String name() {
				return "getControl";
			}
		}, java.util.Locale.getDefault());
		javaT.util.ResourceBundle.Control.ControlFactoryTest.testControlFactory(new javaT.util.ResourceBundle.Control.ControlFactoryTest.Factory() {
			public java.util.ResourceBundle.Control getControl(java.util.List<java.lang.String> formats) {
				return java.util.ResourceBundle.Control.getNoFallbackControl(formats);
			}

			public java.lang.String name() {
				return "getNoFallbackControl";
			}
		}, null);
		if (javaT.util.ResourceBundle.Control.ControlFactoryTest.errors > 0) {
			throw new java.lang.RuntimeException(("FAILED: " + javaT.util.ResourceBundle.Control.ControlFactoryTest.errors) + " error(s)");
		}
	}

	private static void testControlFactory(javaT.util.ResourceBundle.Control.ControlFactoryTest.Factory factory, java.util.Locale loc) {
		javaT.util.ResourceBundle.Control.ControlFactoryTest.testGetControl(factory, loc, java.util.ResourceBundle.Control.FORMAT_DEFAULT, "java.class", "java.properties");
		javaT.util.ResourceBundle.Control.ControlFactoryTest.testGetControl(factory, loc, java.util.ResourceBundle.Control.FORMAT_CLASS, "java.class");
		javaT.util.ResourceBundle.Control.ControlFactoryTest.testGetControl(factory, loc, java.util.ResourceBundle.Control.FORMAT_PROPERTIES, "java.properties");
		java.lang.String[][] data = new java.lang.String[][]{ new java.lang.String[]{ "java.class", "java.properties", "java.xml" }, new java.lang.String[]{ "java.class", "java.props" }, new java.lang.String[]{ "java.properties", "java.class" }, new java.lang.String[]{ "java.foo", "java.properties" }, new java.lang.String[]{ "java.foo" }, new java.lang.String[]{ null } };
		for (java.lang.String[] fmts : data) {
			try {
				java.util.List<java.lang.String> fmt = java.util.Arrays.asList(fmts);
				java.util.ResourceBundle.Control control = factory.getControl(fmt);
				javaT.util.ResourceBundle.Control.ControlFactoryTest.error("getControl: %s%n", fmt);
			} catch (java.lang.IllegalArgumentException e) {
			}
		}
		try {
			java.util.ResourceBundle.Control control = factory.getControl(null);
			javaT.util.ResourceBundle.Control.ControlFactoryTest.error("%s: doesn't throw NPE.%n", factory.name());
		} catch (java.lang.NullPointerException npe) {
		}
	}

	private static void testGetControl(javaT.util.ResourceBundle.Control.ControlFactoryTest.Factory factory, java.util.Locale loc, final java.util.List<java.lang.String> FORMATS, java.lang.String... fmtStrings) {
		final java.util.ResourceBundle.Control CONTROL = factory.getControl(FORMATS);
		java.util.List<java.lang.String> fmt = CONTROL.getFormats("any");
		if (fmt != FORMATS) {
			javaT.util.ResourceBundle.Control.ControlFactoryTest.error("%s: returns %s, expected %s.%n", factory.name(), fmt, FORMATS);
		}
		java.util.ResourceBundle.Control control = null;
		for (int i = 0; i < 10; i++) {
			fmt = java.util.Arrays.asList(fmtStrings);
			control = factory.getControl(fmt);
			if (control != CONTROL) {
				javaT.util.ResourceBundle.Control.ControlFactoryTest.error("%s: doesn't return the singleton: got %s, expected %s%n", factory.name(), control, CONTROL);
			}
		}
		java.util.Locale defaultLocale = java.util.Locale.getDefault();
		java.util.Locale nonDefaultLocale = (defaultLocale.equals(java.util.Locale.US)) ? java.util.Locale.JAPAN : java.util.Locale.US;
		if (loc != null) {
			java.util.Locale l = CONTROL.getFallbackLocale("any", nonDefaultLocale);
			if (!defaultLocale.equals(l)) {
				javaT.util.ResourceBundle.Control.ControlFactoryTest.error("%s: getFallbackLocale doesn't return default locale. got %s, expected %s%n", factory.name(), javaT.util.ResourceBundle.Control.ControlFactoryTest.toString(l), javaT.util.ResourceBundle.Control.ControlFactoryTest.toString(defaultLocale));
			}
			l = CONTROL.getFallbackLocale("any", defaultLocale);
			if (l != null) {
				javaT.util.ResourceBundle.Control.ControlFactoryTest.error("%s: getFallbackLocale doesn't return null. got %s%n", factory.name(), javaT.util.ResourceBundle.Control.ControlFactoryTest.toString(l));
			}
		} else {
			java.util.Locale l = CONTROL.getFallbackLocale("any", nonDefaultLocale);
			if (l != null) {
				javaT.util.ResourceBundle.Control.ControlFactoryTest.error("%s: getFallbackLocale doesn't return null. got %s%n", factory.name(), javaT.util.ResourceBundle.Control.ControlFactoryTest.toString(l));
			}
			l = CONTROL.getFallbackLocale("any", defaultLocale);
			if (l != null) {
				javaT.util.ResourceBundle.Control.ControlFactoryTest.error("%s: getFallbackLocale doesn't return null. got %s%n", factory.name(), javaT.util.ResourceBundle.Control.ControlFactoryTest.toString(l));
			}
		}
	}

	private static java.lang.String toString(java.util.Locale loc) {
		if (loc == null) {
			return "null";
		}
		return ((((("\"" + loc.getLanguage()) + "_") + loc.getCountry()) + "_") + loc.getVariant()) + "\"";
	}

	private static void error(java.lang.String msg) {
		java.lang.System.out.println(msg);
		javaT.util.ResourceBundle.Control.ControlFactoryTest.errors++;
	}

	private static void error(java.lang.String fmt, java.lang.Object... args) {
		java.lang.System.out.printf(fmt, args);
		javaT.util.ResourceBundle.Control.ControlFactoryTest.errors++;
	}
}