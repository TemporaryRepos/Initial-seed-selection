public class StampOverflow {
	public static void main(java.lang.String[] args) throws java.lang.IllegalAccessException {
		java.lang.reflect.Field nextstamp = null;
		try {
			nextstamp = java.util.Calendar.class.getDeclaredField("nextStamp");
		} catch (java.lang.NoSuchFieldException e) {
			throw new java.lang.RuntimeException("implementation changed?", e);
		}
		nextstamp.setAccessible(true);
		java.util.Calendar cal = new java.util.GregorianCalendar();
		int initialValue = nextstamp.getInt(cal);
		nextstamp.setInt(cal, java.lang.Integer.MAX_VALUE - 100);
		for (int i = 0; i < 1000; i++) {
			javaT.util.Calendar.StampOverflow.invoke(cal);
			int stampValue = nextstamp.getInt(cal);
			if (stampValue < initialValue) {
				throw new java.lang.RuntimeException("invalid nextStamp: " + stampValue);
			}
		}
	}

	static void invoke(java.util.Calendar cal) {
		cal.clear();
		cal.set(2000, java.util.Calendar.NOVEMBER, 2, 0, 0, 0);
		int y = cal.get(java.util.Calendar.YEAR);
		int m = cal.get(java.util.Calendar.MONTH);
		int d = cal.get(java.util.Calendar.DAY_OF_MONTH);
		if (((y != 2000) || (m != java.util.Calendar.NOVEMBER)) || (d != 2)) {
			throw new java.lang.RuntimeException(((((("wrong date produced (" + y) + "/") + (m + 1)) + "/") + d) + ")");
		}
	}
}