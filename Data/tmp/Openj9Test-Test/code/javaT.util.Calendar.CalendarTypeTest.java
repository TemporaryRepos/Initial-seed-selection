public class CalendarTypeTest {
	static java.util.Locale[] locales = new java.util.Locale[]{ java.util.Locale.US, java.util.Locale.forLanguageTag("th-TH-u-ca-gregory"), new java.util.Locale("th", "TH"), java.util.Locale.forLanguageTag("en-US-u-ca-buddhist"), new java.util.Locale("ja", "JP", "JP"), java.util.Locale.forLanguageTag("en-US-u-ca-japanese") };

	static final java.lang.String[] TYPES = new java.lang.String[]{ "gregory", "buddhist", "japanese" };

	static final java.lang.String[] ALIASES = new java.lang.String[]{ "gregorian", "iso8601" };

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < javaT.util.Calendar.CalendarTypeTest.locales.length; i++) {
			java.util.Calendar cal = java.util.Calendar.getInstance(javaT.util.Calendar.CalendarTypeTest.locales[i]);
			java.lang.String type = cal.getCalendarType();
			javaT.util.Calendar.CalendarTypeTest.checkValue("bad calendar type", type, javaT.util.Calendar.CalendarTypeTest.TYPES[i / 2]);
		}
		java.util.GregorianCalendar gcal = new java.util.GregorianCalendar();
		javaT.util.Calendar.CalendarTypeTest.checkValue("bad GregorianCalendar type", gcal.getCalendarType(), "gregory");
		javaT.util.Calendar.CalendarTypeTest.Gregorian g = new javaT.util.Calendar.CalendarTypeTest.Gregorian();
		javaT.util.Calendar.CalendarTypeTest.checkValue("bad GregorianCalendar subclass type", g.getCalendarType(), "gregory");
		java.util.Calendar k = new javaT.util.Calendar.CalendarTypeTest.Koyomi();
		javaT.util.Calendar.CalendarTypeTest.checkValue("bad class name", k.getCalendarType(), k.getClass().getName());
		java.util.Set<java.lang.String> types = java.util.Calendar.getAvailableCalendarTypes();
		if (types.size() != 3) {
			throw new java.lang.RuntimeException("size != 3");
		}
		for (java.lang.String s : javaT.util.Calendar.CalendarTypeTest.TYPES) {
			if (!types.contains(s)) {
				throw new java.lang.RuntimeException(s + " not contained");
			}
		}
		for (java.lang.String s : javaT.util.Calendar.CalendarTypeTest.ALIASES) {
			if (types.contains(s)) {
				throw new java.lang.RuntimeException(("alias " + s) + " contained");
			}
		}
	}

	private static void checkValue(java.lang.String msg, java.lang.String got, java.lang.String expected) {
		if (!expected.equals(got)) {
			java.lang.String str = java.lang.String.format("%s: got '%s', expected '%s'", msg, got, expected);
			throw new java.lang.RuntimeException(str);
		}
	}

	private static class Gregorian extends java.util.GregorianCalendar {}

	private static class Koyomi extends java.util.Calendar {
		@java.lang.Override
		protected void computeTime() {
			throw new java.lang.UnsupportedOperationException("Not supported yet.");
		}

		@java.lang.Override
		protected void computeFields() {
			throw new java.lang.UnsupportedOperationException("Not supported yet.");
		}

		@java.lang.Override
		public void add(int field, int amount) {
			throw new java.lang.UnsupportedOperationException("Not supported yet.");
		}

		@java.lang.Override
		public void roll(int field, boolean up) {
			throw new java.lang.UnsupportedOperationException("Not supported yet.");
		}

		@java.lang.Override
		public int getMinimum(int field) {
			throw new java.lang.UnsupportedOperationException("Not supported yet.");
		}

		@java.lang.Override
		public int getMaximum(int field) {
			throw new java.lang.UnsupportedOperationException("Not supported yet.");
		}

		@java.lang.Override
		public int getGreatestMinimum(int field) {
			throw new java.lang.UnsupportedOperationException("Not supported yet.");
		}

		@java.lang.Override
		public int getLeastMaximum(int field) {
			throw new java.lang.UnsupportedOperationException("Not supported yet.");
		}
	}
}