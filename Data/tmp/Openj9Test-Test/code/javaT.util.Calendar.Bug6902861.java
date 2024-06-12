public class Bug6902861 {
	static int errors = 0;

	public static void main(java.lang.String[] args) {
		java.util.Locale loc = java.util.Locale.getDefault();
		try {
			java.util.Locale.setDefault(java.util.Locale.GERMANY);
			javaT.util.Calendar.Bug6902861.test(2010, java.util.Calendar.JANUARY, 1, +1, 1);
			javaT.util.Calendar.Bug6902861.test(2010, java.util.Calendar.JANUARY, 1, +2, 2);
			javaT.util.Calendar.Bug6902861.test(2010, java.util.Calendar.JANUARY, 1, -1, 52);
			javaT.util.Calendar.Bug6902861.test(2010, java.util.Calendar.JANUARY, 1, -2, 51);
			javaT.util.Calendar.Bug6902861.test(2008, java.util.Calendar.DECEMBER, 31, +1, 1);
			javaT.util.Calendar.Bug6902861.test(2008, java.util.Calendar.DECEMBER, 31, +2, 2);
			javaT.util.Calendar.Bug6902861.test(2008, java.util.Calendar.DECEMBER, 31, -1, 52);
			javaT.util.Calendar.Bug6902861.test(2008, java.util.Calendar.DECEMBER, 31, -2, 51);
			if (javaT.util.Calendar.Bug6902861.errors > 0) {
				throw new java.lang.RuntimeException("Failed");
			}
		} finally {
			java.util.Locale.setDefault(loc);
		}
	}

	static void test(int year, int month, int dayOfMonth, int amount, int expected) {
		java.util.Calendar calendar = new java.util.GregorianCalendar(year, month, dayOfMonth);
		int week = calendar.get(java.util.Calendar.WEEK_OF_YEAR);
		calendar.roll(java.util.Calendar.WEEK_OF_YEAR, amount);
		int got = calendar.get(java.util.Calendar.WEEK_OF_YEAR);
		int y = calendar.get(java.util.Calendar.YEAR);
		if ((got != expected) || (y != year)) {
			java.lang.String date = java.lang.String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth);
			java.lang.System.err.printf("%s: roll %+d: got: %d,%2d; expected: %d,%2d%n", date, amount, y, got, year, expected);
			javaT.util.Calendar.Bug6902861.errors++;
		}
	}
}