public class CommonMistakesApplication {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaprogramming.commonmistakes.datetime.newdate.CommonMistakesApplication.wrong();
		javaprogramming.commonmistakes.datetime.newdate.CommonMistakesApplication.right();
		javaprogramming.commonmistakes.datetime.newdate.CommonMistakesApplication.better();
	}

	private static void wrong() {
		java.lang.System.out.println("wrong");
		java.util.Date date = new java.util.Date(2019, 12, 31, 11, 12, 13);
		java.lang.System.out.println(date);
	}

	private static void wrongfix() {
		java.lang.System.out.println("right");
		java.util.Date date = new java.util.Date(2019 - 1900, 11, 31, 11, 12, 13);
		java.lang.System.out.println(date);
	}

	private static void right() {
		java.lang.System.out.println("right");
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(2019, 11, 31, 11, 12, 13);
		java.lang.System.out.println(calendar.getTime());
		java.util.Calendar calendar2 = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("America/New_York"));
		calendar2.set(2019, java.util.Calendar.DECEMBER, 31, 11, 12, 13);
		java.lang.System.out.println(calendar2.getTime());
	}

	private static void better() {
		java.lang.System.out.println("better");
		java.time.LocalDateTime localDateTime = java.time.LocalDateTime.of(2019, java.time.Month.DECEMBER, 31, 11, 12, 13);
		java.lang.System.out.println(localDateTime);
		java.time.ZonedDateTime zonedDateTime = java.time.ZonedDateTime.of(localDateTime, java.time.ZoneId.of("America/New_York"));
		java.lang.System.out.println(zonedDateTime);
	}
}