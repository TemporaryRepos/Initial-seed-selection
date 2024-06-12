public class BuddhistCalendarTest {
	private static final java.util.Locale THAI_LOCALE = new java.util.Locale("th", "TH");

	public static void main(java.lang.String[] args) {
		javaT.util.Calendar.BuddhistCalendarTest.testAddRoll();
		javaT.util.Calendar.BuddhistCalendarTest.testToString();
		javaT.util.Calendar.BuddhistCalendarTest.testException();
		javaT.util.Calendar.BuddhistCalendarTest.testLeastMax();
	}

	static void testAddRoll() {
		java.util.Calendar cal;
		int base;
		int year;
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		cal.add(java.util.Calendar.YEAR, 1);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, base + 1, "add(+YEAR)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		cal.add(java.util.Calendar.YEAR, -3);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, base - 3, "add(-YEAR)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		cal.set(java.util.Calendar.MONTH, java.util.Calendar.DECEMBER);
		cal.add(java.util.Calendar.MONTH, 2);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, base + 1, "add(+MONTH)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		cal.set(java.util.Calendar.MONTH, java.util.Calendar.FEBRUARY);
		cal.add(java.util.Calendar.MONTH, -4);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, base - 1, "add(-MONTH)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		cal.roll(java.util.Calendar.YEAR, 2);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, base + 2, "roll(+YEAR)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		cal.roll(java.util.Calendar.YEAR, -4);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, base - 4, "roll(-YEAR)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		cal.set(java.util.Calendar.YEAR, 2543);
		cal.set(java.util.Calendar.MONTH, java.util.Calendar.DECEMBER);
		cal.set(java.util.Calendar.DATE, 31);
		base = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(base, 2543, "roll(+WEEK_OF_YEAR)");
		cal.roll(java.util.Calendar.WEEK_OF_YEAR, 10);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, base, "roll(+WEEK_OF_YEAR)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		cal.set(java.util.Calendar.YEAR, 2543);
		cal.set(java.util.Calendar.MONTH, java.util.Calendar.JANUARY);
		cal.set(java.util.Calendar.DATE, 1);
		base = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(base, 2543, "roll(+WEEK_OF_YEAR)");
		cal.roll(java.util.Calendar.WEEK_OF_YEAR, -10);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, base, "roll(-WEEK_OF_YEAR)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		cal.set(3001, java.util.Calendar.APRIL, 10);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, 3001, "set(year, month, date)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		cal.set(3020, java.util.Calendar.MAY, 20, 9, 10);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, 3020, "set(year, month, date, hour, minute)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		cal.set(3120, java.util.Calendar.MAY, 20, 9, 10, 52);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, 3120, "set(year, month, date, hour, minute, second)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		int limit = cal.getActualMaximum(java.util.Calendar.YEAR);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, base, "BuddhistCalendar.getActualMaximum(YEAR)");
		cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		base = cal.get(java.util.Calendar.YEAR);
		limit = cal.getActualMinimum(java.util.Calendar.YEAR);
		year = cal.get(java.util.Calendar.YEAR);
		javaT.util.Calendar.BuddhistCalendarTest.check(year, base, "BuddhistCalendar.getActualMinimum(YEAR)");
	}

	static void testToString() {
		java.util.Calendar cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		int year = cal.get(java.util.Calendar.YEAR);
		java.lang.String s = cal.toString();
		java.lang.String y = s.replaceAll(".+,YEAR=(\\d+),.+", "$1");
		if (java.lang.Integer.parseInt(y) != year) {
			throw new java.lang.RuntimeException((("toString(): wrong year value: got " + y) + ", expected ") + year);
		}
	}

	static void testException() {
		java.util.Calendar cal = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		int year = cal.get(java.util.Calendar.YEAR);
		boolean exceptionOccurred = false;
		try {
			cal.add(100, +1);
		} catch (java.lang.Exception e) {
			exceptionOccurred = true;
		}
		if (!exceptionOccurred) {
			throw new java.lang.RuntimeException("testException: test case failed: no exception thrown");
		}
		int year2 = cal.get(java.util.Calendar.YEAR);
		if (year2 != year) {
			throw new java.lang.RuntimeException((("wrong year value after exception: got " + year2) + ", expected ") + year);
		}
	}

	static void testLeastMax() {
		java.util.Calendar bc = javaT.util.Calendar.BuddhistCalendarTest.getBuddhistCalendar();
		java.util.Calendar gc = new java.util.GregorianCalendar(javaT.util.Calendar.BuddhistCalendarTest.THAI_LOCALE);
		for (int f = 0; f < java.util.Calendar.FIELD_COUNT; f++) {
			if ((f == java.util.Calendar.ERA) || (f == java.util.Calendar.YEAR)) {
				continue;
			}
			int bn = bc.getLeastMaximum(f);
			int gn = gc.getLeastMaximum(f);
			if (bn != gn) {
				throw new java.lang.RuntimeException((((("inconsistent Least Max value for " + javaT.util.Calendar.Koyomi.getFieldName(f)) + ": Buddhist=") + bn) + ": Gregorian=") + gn);
			}
		}
	}

	static java.util.Calendar getBuddhistCalendar() {
		return java.util.Calendar.getInstance(javaT.util.Calendar.BuddhistCalendarTest.THAI_LOCALE);
	}

	static void check(int got, int expected, java.lang.String s) {
		if (got != expected) {
			throw new java.lang.RuntimeException((((("Failed: " + s) + ": got:") + got) + ", expected:") + expected);
		}
	}
}