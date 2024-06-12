public class Bug6448234 {
	public static void main(java.lang.String[] args) {
		java.util.Calendar jcal = java.util.Calendar.getInstance(new java.util.Locale("ja", "JP", "JP"));
		java.util.Calendar gcal = java.util.Calendar.getInstance(java.util.Locale.US);
		for (int i = java.util.Calendar.SUNDAY; i <= java.util.Calendar.SATURDAY; i++) {
			jcal.set(java.util.Calendar.DAY_OF_WEEK, i);
			gcal.set(java.util.Calendar.DAY_OF_WEEK, i);
			java.lang.String j = jcal.getDisplayName(java.util.Calendar.DAY_OF_WEEK, java.util.Calendar.LONG, java.util.Locale.US);
			java.lang.String g = gcal.getDisplayName(java.util.Calendar.DAY_OF_WEEK, java.util.Calendar.LONG, java.util.Locale.US);
			if (!j.equals(g)) {
				throw new java.lang.RuntimeException((("Got " + j) + ", expected ") + g);
			}
			j = jcal.getDisplayName(java.util.Calendar.DAY_OF_WEEK, java.util.Calendar.SHORT, java.util.Locale.US);
			g = gcal.getDisplayName(java.util.Calendar.DAY_OF_WEEK, java.util.Calendar.SHORT, java.util.Locale.US);
			if (!j.equals(g)) {
				throw new java.lang.RuntimeException((("Got " + j) + ", expected ") + g);
			}
		}
	}
}