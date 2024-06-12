public class CommonMistakesApplication {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaprogramming.commonmistakes.datetime.timezone.CommonMistakesApplication.test();
		javaprogramming.commonmistakes.datetime.timezone.CommonMistakesApplication.wrong1();
		javaprogramming.commonmistakes.datetime.timezone.CommonMistakesApplication.wrong2();
		javaprogramming.commonmistakes.datetime.timezone.CommonMistakesApplication.right();
	}

	private static void test() {
		java.lang.System.out.println("test");
		java.lang.System.out.println(new java.util.Date(0));
	}

	private static void wrong1() throws java.text.ParseException {
		java.lang.System.out.println("wrong1");
		java.lang.String stringDate = "2020-01-02 22:00:00";
		java.text.SimpleDateFormat inputFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date1 = inputFormat.parse(stringDate);
		java.lang.System.out.println((date1 + ":") + date1.getTime());
		inputFormat.setTimeZone(java.util.TimeZone.getTimeZone("America/New_York"));
		java.util.Date date2 = inputFormat.parse(stringDate);
		java.lang.System.out.println((date2 + ":") + date2.getTime());
	}

	private static void wrong2() throws java.text.ParseException {
		java.lang.System.out.println("wrong2");
		java.lang.String stringDate = "2020-01-02 22:00:00";
		java.text.SimpleDateFormat inputFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = inputFormat.parse(stringDate);
		java.lang.System.out.println(new java.text.SimpleDateFormat("[yyyy-MM-dd HH:mm:ss Z]").format(date));
		java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("America/New_York"));
		java.lang.System.out.println(new java.text.SimpleDateFormat("[yyyy-MM-dd HH:mm:ss Z]").format(date));
	}

	private static void right() {
		java.lang.System.out.println("right");
		java.lang.String stringDate = "2020-01-02 22:00:00";
		java.time.ZoneId timeZoneSH = java.time.ZoneId.of("Asia/Shanghai");
		java.time.ZoneId timeZoneNY = java.time.ZoneId.of("America/New_York");
		java.time.ZoneId timeZoneJST = java.time.ZoneOffset.ofHours(9);
		java.time.format.DateTimeFormatter dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		java.time.ZonedDateTime date = java.time.ZonedDateTime.of(java.time.LocalDateTime.parse(stringDate, dateTimeFormatter), timeZoneJST);
		java.time.format.DateTimeFormatter outputFormat = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
		java.lang.System.out.println(timeZoneSH.getId() + outputFormat.withZone(timeZoneSH).format(date));
		java.lang.System.out.println(timeZoneNY.getId() + outputFormat.withZone(timeZoneNY).format(date));
		java.lang.System.out.println(timeZoneJST.getId() + outputFormat.withZone(timeZoneJST).format(date));
	}
}