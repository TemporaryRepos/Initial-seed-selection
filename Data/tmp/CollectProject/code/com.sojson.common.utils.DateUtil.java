public class DateUtil {
	public static final java.lang.String ISO_DATE_FORMAT = "yyyyMMdd";

	public static final java.lang.String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";

	public static java.lang.String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static java.lang.String DATE_PATTERN = "yyyyMMddHHmmss";

	private static boolean LENIENT_DATE = false;

	private static java.util.Random random = new java.util.Random();

	private static final int ID_BYTES = 10;

	public static synchronized java.lang.String generateId() {
		java.lang.StringBuffer result = new java.lang.StringBuffer();
		result = result.append(java.lang.System.currentTimeMillis());
		for (int i = 0; i < com.sojson.common.utils.DateUtil.ID_BYTES; i++) {
			result = result.append(com.sojson.common.utils.DateUtil.random.nextInt(10));
		}
		return result.toString();
	}

	protected static final float normalizedJulian(float JD) {
		float f = java.lang.Math.round(JD + 0.5F) - 0.5F;
		return f;
	}

	public static final java.util.Date toDate(float JD) {
		float Z = com.sojson.common.utils.DateUtil.normalizedJulian(JD) + 0.5F;
		float W = ((int) ((Z - 1867216.2F) / 36524.25F));
		float X = ((int) (W / 4.0F));
		float A = ((Z + 1) + W) - X;
		float B = A + 1524;
		float C = ((int) ((B - 122.1) / 365.25));
		float D = ((int) (365.25F * C));
		float E = ((int) ((B - D) / 30.6001));
		float F = ((int) (30.6001F * E));
		int day = ((int) ((B - D) - F));
		int month = ((int) (E - 1));
		if (month > 12) {
			month = month - 12;
		}
		int year = ((int) (C - 4715));
		if (month > 2) {
			year--;
		}
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.set(java.util.Calendar.YEAR, year);
		c.set(java.util.Calendar.MONTH, month - 1);
		c.set(java.util.Calendar.DATE, day);
		return c.getTime();
	}

	public static final int daysBetween(java.util.Date early, java.util.Date late) {
		java.util.Calendar c1 = java.util.Calendar.getInstance();
		java.util.Calendar c2 = java.util.Calendar.getInstance();
		c1.setTime(early);
		c2.setTime(late);
		return com.sojson.common.utils.DateUtil.daysBetween(c1, c2);
	}

	public static final int daysBetween(java.util.Calendar early, java.util.Calendar late) {
		return ((int) (com.sojson.common.utils.DateUtil.toJulian(late) - com.sojson.common.utils.DateUtil.toJulian(early)));
	}

	public static final float toJulian(java.util.Calendar c) {
		int Y = c.get(java.util.Calendar.YEAR);
		int M = c.get(java.util.Calendar.MONTH);
		int D = c.get(java.util.Calendar.DATE);
		int A = Y / 100;
		int B = A / 4;
		int C = (2 - A) + B;
		float E = ((int) (365.25F * (Y + 4716)));
		float F = ((int) (30.6001F * (M + 1)));
		float JD = (((C + D) + E) + F) - 1524.5F;
		return JD;
	}

	public static final float toJulian(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return com.sojson.common.utils.DateUtil.toJulian(c);
	}

	public static final java.lang.String dateIncrease(java.lang.String isoString, java.lang.String fmt, int field, int amount) {
		try {
			java.util.Calendar cal = java.util.GregorianCalendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));
			cal.setTime(com.sojson.common.utils.DateUtil.stringToDate(isoString, fmt, true));
			cal.add(field, amount);
			return com.sojson.common.utils.DateUtil.dateToString(cal.getTime(), fmt);
		} catch (java.lang.Exception ex) {
			return null;
		}
	}

	public static final java.lang.String roll(java.lang.String isoString, java.lang.String fmt, int field, boolean up) throws java.text.ParseException {
		java.util.Calendar cal = java.util.GregorianCalendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));
		cal.setTime(com.sojson.common.utils.DateUtil.stringToDate(isoString, fmt));
		cal.roll(field, up);
		return com.sojson.common.utils.DateUtil.dateToString(cal.getTime(), fmt);
	}

	public static final java.lang.String roll(java.lang.String isoString, int field, boolean up) throws java.text.ParseException {
		return com.sojson.common.utils.DateUtil.roll(isoString, com.sojson.common.utils.DateUtil.DATETIME_PATTERN, field, up);
	}

	public static java.util.Date stringToDate(java.lang.String dateText, java.lang.String format, boolean lenient) {
		if (dateText == null) {
			return null;
		}
		java.text.DateFormat df = null;
		try {
			if (format == null) {
				df = new java.text.SimpleDateFormat();
			} else {
				df = new java.text.SimpleDateFormat(format);
			}
			df.setLenient(false);
			return df.parse(dateText);
		} catch (java.text.ParseException e) {
			return null;
		}
	}

	public static java.sql.Timestamp getCurrentTimestamp() {
		return new java.sql.Timestamp(new java.util.Date().getTime());
	}

	public static java.util.Date stringToDate(java.lang.String dateString, java.lang.String format) {
		return com.sojson.common.utils.DateUtil.stringToDate(dateString, format, com.sojson.common.utils.DateUtil.LENIENT_DATE);
	}

	public static java.util.Date stringToDate(java.lang.String dateString) {
		return com.sojson.common.utils.DateUtil.stringToDate(dateString, com.sojson.common.utils.DateUtil.ISO_EXPANDED_DATE_FORMAT, com.sojson.common.utils.DateUtil.LENIENT_DATE);
	}

	public static java.lang.String dateToString(java.util.Date date, java.lang.String pattern) {
		if (date == null) {
			return null;
		}
		try {
			java.text.SimpleDateFormat sfDate = new java.text.SimpleDateFormat(pattern);
			sfDate.setLenient(false);
			return sfDate.format(date);
		} catch (java.lang.Exception e) {
			return null;
		}
	}

	public static java.lang.String dateToString(java.util.Date date) {
		return com.sojson.common.utils.DateUtil.dateToString(date, com.sojson.common.utils.DateUtil.ISO_EXPANDED_DATE_FORMAT);
	}

	public static java.util.Date getCurrentDateTime() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		java.util.Date dtNow = calNow.getTime();
		return dtNow;
	}

	public static java.lang.String getCurrentDateString(java.lang.String pattern) {
		return com.sojson.common.utils.DateUtil.dateToString(com.sojson.common.utils.DateUtil.getCurrentDateTime(), pattern);
	}

	public static java.lang.String getCurrentDateString() {
		return com.sojson.common.utils.DateUtil.dateToString(com.sojson.common.utils.DateUtil.getCurrentDateTime(), com.sojson.common.utils.DateUtil.ISO_EXPANDED_DATE_FORMAT);
	}

	public static java.lang.String dateToStringWithTime() {
		return com.sojson.common.utils.DateUtil.dateToString(new java.util.Date(), com.sojson.common.utils.DateUtil.DATETIME_PATTERN);
	}

	public static java.lang.String dateToStringWithTime(java.util.Date date) {
		return com.sojson.common.utils.DateUtil.dateToString(date, com.sojson.common.utils.DateUtil.DATETIME_PATTERN);
	}

	public static java.util.Date dateIncreaseByDay(java.util.Date date, int days) {
		java.util.Calendar cal = java.util.GregorianCalendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(java.util.Calendar.DATE, days);
		return cal.getTime();
	}

	public static java.util.Date dateIncreaseByMonth(java.util.Date date, int mnt) {
		java.util.Calendar cal = java.util.GregorianCalendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(java.util.Calendar.MONTH, mnt);
		return cal.getTime();
	}

	public static java.util.Date dateIncreaseByYear(java.util.Date date, int mnt) {
		java.util.Calendar cal = java.util.GregorianCalendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(java.util.Calendar.YEAR, mnt);
		return cal.getTime();
	}

	public static java.lang.String dateIncreaseByDay(java.lang.String date, int days) {
		return com.sojson.common.utils.DateUtil.dateIncreaseByDay(date, com.sojson.common.utils.DateUtil.ISO_DATE_FORMAT, days);
	}

	public static java.lang.String dateIncreaseByDay(java.lang.String date, java.lang.String fmt, int days) {
		return com.sojson.common.utils.DateUtil.dateIncrease(date, fmt, java.util.Calendar.DATE, days);
	}

	public static java.lang.String stringToString(java.lang.String src, java.lang.String srcfmt, java.lang.String desfmt) {
		return com.sojson.common.utils.DateUtil.dateToString(com.sojson.common.utils.DateUtil.stringToDate(src, srcfmt), desfmt);
	}

	public static java.lang.String getYear(java.util.Date date) {
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat("yyyy");
		java.lang.String cur_year = formater.format(date);
		return cur_year;
	}

	public static java.lang.String getMonth(java.util.Date date) {
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat("MM");
		java.lang.String cur_month = formater.format(date);
		return cur_month;
	}

	public static java.lang.String getDay(java.util.Date date) {
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat("dd");
		java.lang.String cur_day = formater.format(date);
		return cur_day;
	}

	public static java.lang.String getHour(java.util.Date date) {
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat("HH");
		java.lang.String cur_day = formater.format(date);
		return cur_day;
	}

	public static int getMinsFromDate(java.util.Date dt) {
		java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
		cal.setTime(dt);
		int hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
		int min = cal.get(java.util.Calendar.MINUTE);
		return (hour * 60) + min;
	}

	public static java.util.Date convertToDate(java.lang.String str, boolean isExpiry) {
		java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date dt = null;
		try {
			dt = fmt.parse(str);
		} catch (java.text.ParseException ex) {
			java.util.Calendar cal = java.util.Calendar.getInstance();
			if (isExpiry) {
				cal.add(java.util.Calendar.DAY_OF_MONTH, 1);
				cal.set(java.util.Calendar.HOUR_OF_DAY, 23);
				cal.set(java.util.Calendar.MINUTE, 59);
			} else {
				cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
				cal.set(java.util.Calendar.MINUTE, 0);
			}
			dt = cal.getTime();
		}
		return dt;
	}

	public static java.util.Date convertToDate(java.lang.String str) {
		java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm");
		java.util.Date dt = null;
		try {
			dt = fmt.parse(str);
		} catch (java.text.ParseException ex) {
			dt = new java.util.Date();
		}
		return dt;
	}

	public static java.lang.String dateFromat(java.util.Date date, int minute) {
		java.lang.String dateFormat = null;
		int year = java.lang.Integer.parseInt(com.sojson.common.utils.DateUtil.getYear(date));
		int month = java.lang.Integer.parseInt(com.sojson.common.utils.DateUtil.getMonth(date));
		int day = java.lang.Integer.parseInt(com.sojson.common.utils.DateUtil.getDay(date));
		int hour = minute / 60;
		int min = minute % 60;
		dateFormat = (((((java.lang.String.valueOf(year) + (month > 9 ? java.lang.String.valueOf(month) : "0" + java.lang.String.valueOf(month))) + (day > 9 ? java.lang.String.valueOf(day) : "0" + java.lang.String.valueOf(day))) + " ") + (hour > 9 ? java.lang.String.valueOf(hour) : "0" + java.lang.String.valueOf(hour))) + (min > 9 ? java.lang.String.valueOf(min) : "0" + java.lang.String.valueOf(min))) + "00";
		return dateFormat;
	}

	public static java.lang.String sDateFormat() {
		return new java.text.SimpleDateFormat(com.sojson.common.utils.DateUtil.DATE_PATTERN).format(java.util.Calendar.getInstance().getTime());
	}

	public static void main(java.lang.String[] args) {
		java.lang.String timeDir = com.sojson.common.utils.DateUtil.dateToString(new java.util.Date(), com.sojson.common.utils.DateUtil.ISO_EXPANDED_DATE_FORMAT);
		java.lang.System.out.println(timeDir);
	}
}