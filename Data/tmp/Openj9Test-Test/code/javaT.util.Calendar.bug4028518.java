public class bug4028518 {
	public static void main(java.lang.String[] args) {
		java.util.GregorianCalendar cal1 = new java.util.GregorianCalendar();
		java.util.GregorianCalendar cal2 = ((java.util.GregorianCalendar) (cal1.clone()));
		javaT.util.Calendar.bug4028518.printdate(cal1, "cal1: ");
		javaT.util.Calendar.bug4028518.printdate(cal2, "cal2 - cloned(): ");
		cal1.add(java.util.Calendar.DAY_OF_MONTH, 1);
		javaT.util.Calendar.bug4028518.printdate(cal1, "cal1 after adding 1 day: ");
		javaT.util.Calendar.bug4028518.printdate(cal2, "cal2 should be unmodified: ");
		if (cal1.get(java.util.Calendar.DAY_OF_MONTH) == cal2.get(java.util.Calendar.DAY_OF_MONTH)) {
			throw new java.lang.RuntimeException("cloned GregorianCalendar modified");
		}
	}

	private static void printdate(java.util.GregorianCalendar cal, java.lang.String string) {
		java.lang.System.out.println(((((string + (cal.get(java.util.Calendar.MONTH) + 1)) + "/") + cal.get(java.util.Calendar.DAY_OF_MONTH)) + "/") + cal.get(java.util.Calendar.YEAR));
	}
}