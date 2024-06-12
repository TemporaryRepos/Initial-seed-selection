@org.springframework.stereotype.Component
public class LocalDateTimeUtil {
	private static cn.com.ogtwelve.utils.LocalDateTimeUtil instance;

	public static cn.com.ogtwelve.utils.LocalDateTimeUtil getInstance() {
		if (null == cn.com.ogtwelve.utils.LocalDateTimeUtil.instance) {
			synchronized(cn.com.ogtwelve.utils.LocalDateTimeUtil.class) {
				if (null == cn.com.ogtwelve.utils.LocalDateTimeUtil.instance) {
					cn.com.ogtwelve.utils.LocalDateTimeUtil.instance = new cn.com.ogtwelve.utils.LocalDateTimeUtil();
				}
			}
		}
		return cn.com.ogtwelve.utils.LocalDateTimeUtil.instance;
	}

	public static java.time.LocalDateTime now() {
		return java.time.LocalDateTime.now();
	}

	public static int week(java.time.LocalDateTime time) {
		return time.getDayOfWeek().getValue();
	}

	public static java.time.LocalDateTime monthFirst(int num) {
		java.time.LocalDateTime newTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.plus(java.time.LocalDateTime.now(), num, java.time.temporal.ChronoUnit.MONTHS);
		newTime = newTime.with(java.time.temporal.TemporalAdjusters.firstDayOfMonth());
		return cn.com.ogtwelve.utils.LocalDateTimeUtil.getDayStart(newTime);
	}

	public static java.time.LocalDateTime monthLast(int num) {
		java.time.LocalDateTime newTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.plus(java.time.LocalDateTime.now(), num, java.time.temporal.ChronoUnit.MONTHS);
		newTime = newTime.with(java.time.temporal.TemporalAdjusters.lastDayOfMonth());
		return cn.com.ogtwelve.utils.LocalDateTimeUtil.getDayEnd(newTime);
	}

	public static java.time.LocalDateTime weekFirst(int num) {
		int week = cn.com.ogtwelve.utils.LocalDateTimeUtil.week(java.time.LocalDateTime.now());
		java.time.LocalDateTime newTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.subtract(java.time.LocalDateTime.now(), week - 1, java.time.temporal.ChronoUnit.DAYS);
		newTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.plus(newTime, num * 7, java.time.temporal.ChronoUnit.DAYS);
		return cn.com.ogtwelve.utils.LocalDateTimeUtil.getDayStart(newTime);
	}

	public static java.time.LocalDateTime weekLast(int num) {
		int week = cn.com.ogtwelve.utils.LocalDateTimeUtil.week(java.time.LocalDateTime.now());
		java.time.LocalDateTime newTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.plus(java.time.LocalDateTime.now(), 7 - week, java.time.temporal.ChronoUnit.DAYS);
		newTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.plus(newTime, num * 7, java.time.temporal.ChronoUnit.DAYS);
		return cn.com.ogtwelve.utils.LocalDateTimeUtil.getDayEnd(newTime);
	}

	public static java.time.LocalDateTime plusDays(int num) {
		java.time.LocalDateTime newTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.plus(java.time.LocalDateTime.now(), num, java.time.temporal.ChronoUnit.DAYS);
		return cn.com.ogtwelve.utils.LocalDateTimeUtil.getDayEnd(newTime);
	}

	public java.time.LocalDate plusDays(java.time.LocalDate localDate, int num) {
		java.time.LocalDate newTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.plus(localDate, num, java.time.temporal.ChronoUnit.DAYS);
		return newTime;
	}

	public static boolean isBefore(java.time.LocalDateTime t1, java.time.LocalDateTime t2) {
		return t1.isBefore(t2);
	}

	public static boolean isAfter(java.time.LocalDateTime t1, java.time.LocalDateTime t2) {
		return t1.isAfter(t2);
	}

	public static java.time.LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute) {
		return java.time.LocalDateTime.of(year, month, dayOfMonth, hour, minute);
	}

	public static java.time.LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) {
		return java.time.LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond);
	}

	public static java.time.LocalDateTime convertDateToLDT(java.util.Date date) {
		return java.time.LocalDateTime.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault());
	}

	public static java.util.Date convertLDTToDate(java.time.LocalDateTime time) {
		return java.util.Date.from(time.atZone(java.time.ZoneId.systemDefault()).toInstant());
	}

	public static java.lang.Long getMilliByTime(java.time.LocalDateTime time) {
		return time.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
	}

	public static java.lang.Long getSecondsByTime(java.time.LocalDateTime time) {
		return time.atZone(java.time.ZoneId.systemDefault()).toInstant().getEpochSecond();
	}

	public static java.lang.String formatTime(java.time.LocalDateTime time, java.lang.String pattern) {
		return time.format(java.time.format.DateTimeFormatter.ofPattern(pattern));
	}

	public static java.lang.String formatDate(java.time.LocalDate localDate, java.lang.String pattern) {
		return localDate.format(java.time.format.DateTimeFormatter.ofPattern(pattern));
	}

	public static java.time.LocalDateTime formatTime(java.lang.String time, java.lang.String pattern) {
		return java.time.LocalDateTime.parse(time, java.time.format.DateTimeFormatter.ofPattern(pattern));
	}

	public java.time.LocalDate formatDate(java.lang.String time, java.lang.String pattern) {
		return java.time.LocalDate.parse(time, java.time.format.DateTimeFormatter.ofPattern(pattern));
	}

	public static java.time.LocalDateTime plus(java.time.LocalDateTime time, long number, java.time.temporal.TemporalUnit field) {
		return time.plus(number, field);
	}

	public static java.time.LocalDate plus(java.time.LocalDate time, long number, java.time.temporal.TemporalUnit field) {
		return time.plus(number, field);
	}

	public static java.time.LocalDateTime subtract(java.time.LocalDateTime time, long number, java.time.temporal.TemporalUnit field) {
		return time.minus(number, field);
	}

	public static long betweenTwoTime(java.time.LocalDateTime startTime, java.time.LocalDateTime endTime, java.time.temporal.ChronoUnit field) {
		java.time.Period period = java.time.Period.between(java.time.LocalDate.from(startTime), java.time.LocalDate.from(endTime));
		if (field == java.time.temporal.ChronoUnit.YEARS) {
			return period.getYears();
		}
		if (field == java.time.temporal.ChronoUnit.MONTHS) {
			return (period.getYears() * 12) + period.getMonths();
		}
		return field.between(startTime, endTime);
	}

	public static java.time.LocalDateTime getDayStart(java.time.LocalDateTime time) {
		return time.withHour(0).withMinute(0).withSecond(0).withNano(0);
	}

	public static java.time.LocalDateTime getDayEnd(java.time.LocalDateTime time) {
		return time.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
	}

	public static java.time.LocalDateTime getWeekOfFirst(java.time.LocalDateTime time) {
		return time.with(java.time.temporal.TemporalAdjusters.previous(java.time.DayOfWeek.SUNDAY)).plusDays(1).withHour(0).withMinute(0).withSecond(0);
	}

	public static java.time.LocalDateTime getWeekOfLast(java.time.LocalDateTime time) {
		return time.with(java.time.temporal.TemporalAdjusters.next(java.time.DayOfWeek.MONDAY)).minusDays(1).withHour(23).withMinute(59).withSecond(59);
	}

	public static java.time.LocalDateTime getMonthOfFirst(java.time.LocalDateTime time) {
		java.time.LocalDateTime firstday = time.with(java.time.temporal.TemporalAdjusters.firstDayOfMonth());
		return java.time.LocalDateTime.of(firstday.toLocalDate(), java.time.LocalTime.MIN);
	}

	public static java.time.LocalDateTime getMonthOfLast(java.time.LocalDateTime time) {
		java.time.LocalDateTime lastDay = time.with(java.time.temporal.TemporalAdjusters.lastDayOfMonth());
		return java.time.LocalDateTime.of(lastDay.toLocalDate(), java.time.LocalTime.MAX);
	}

	public static java.util.List<cn.com.ogtwelve.utils.LocalDateTimeUtil.DateDays> getDateDaysUpList(java.lang.Integer num) {
		java.time.LocalDateTime startTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.monthFirst(0);
		java.time.LocalDateTime entTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.monthLast(num);
		java.util.List<cn.com.ogtwelve.utils.LocalDateTimeUtil.DateDays> everyDays = new java.util.ArrayList<>();
		everyDays.add(new cn.com.ogtwelve.utils.LocalDateTimeUtil.DateDays(startTime, cn.com.ogtwelve.utils.LocalDateTimeUtil.week(startTime)));
		while (true) {
			java.time.LocalDateTime nextDay = cn.com.ogtwelve.utils.LocalDateTimeUtil.plus(everyDays.get(everyDays.size() - 1).dayTime, 1, java.time.temporal.ChronoUnit.DAYS);
			if (cn.com.ogtwelve.utils.LocalDateTimeUtil.isAfter(nextDay, entTime)) {
				break;
			}
			everyDays.add(new cn.com.ogtwelve.utils.LocalDateTimeUtil.DateDays(nextDay, cn.com.ogtwelve.utils.LocalDateTimeUtil.week(nextDay)));
		} 
		return everyDays;
	}

	@lombok.Data
	@lombok.AllArgsConstructor
	public static class DateDays {
		private java.time.LocalDateTime dayTime;

		private int week;
	}

	public static int getDaysOfMonth(int num) {
		java.time.LocalDateTime preDateTime = cn.com.ogtwelve.utils.LocalDateTimeUtil.monthLast(num);
		return preDateTime.toLocalDate().getDayOfMonth();
	}

	public int getTenDay(java.time.LocalDate localDate) {
		int dayOfMonth = localDate.getDayOfMonth();
		if (dayOfMonth < 11) {
			return 1;
		} else if (dayOfMonth < 21) {
			return 2;
		} else {
			return 3;
		}
	}

	public java.time.LocalDate getTenDate(java.time.LocalDate localDate) {
		int tenDay = getTenDay(localDate);
		if (tenDay == 1) {
			return localDate.withDayOfMonth(10);
		} else if (tenDay == 2) {
			return localDate.withDayOfMonth(20);
		} else {
			return localDate.withDayOfMonth(localDate.lengthOfMonth());
		}
	}

	public java.time.LocalDate getLastTenDate(java.time.LocalDate localDate) {
		int dayOfMonth = localDate.getDayOfMonth();
		if (dayOfMonth < 11) {
			java.time.LocalDate newTime = localDate.minusMonths(1).with(java.time.temporal.TemporalAdjusters.lastDayOfMonth());
			return getTenDate(newTime);
		} else if (dayOfMonth < 21) {
			return localDate.withDayOfMonth(10);
		} else {
			return localDate.withDayOfMonth(20);
		}
	}

	public java.time.LocalDate getLastFDate(java.time.LocalDate localDate) {
		int dayOfMonth = localDate.getDayOfMonth();
		if (dayOfMonth < 6) {
			java.time.LocalDate newTime = localDate.minusMonths(1).with(java.time.temporal.TemporalAdjusters.lastDayOfMonth());
			return getTenDate(newTime);
		} else if (dayOfMonth < 11) {
			return localDate.withDayOfMonth(5);
		} else if (dayOfMonth < 16) {
			return localDate.withDayOfMonth(10);
		} else if (dayOfMonth < 21) {
			return localDate.withDayOfMonth(15);
		} else if (dayOfMonth < 26) {
			return localDate.withDayOfMonth(20);
		} else {
			return localDate.withDayOfMonth(25);
		}
	}

	public int getFDay(java.time.LocalDate localDate) {
		int dayOfMonth = localDate.getDayOfMonth();
		if (dayOfMonth < 6) {
			return 1;
		} else if (dayOfMonth < 11) {
			return 2;
		} else if (dayOfMonth < 16) {
			return 3;
		} else if (dayOfMonth < 21) {
			return 4;
		} else if (dayOfMonth < 26) {
			return 5;
		} else {
			return 6;
		}
	}

	public java.time.LocalDate getFDate(java.time.LocalDate localDate) {
		int fDay = getFDay(localDate);
		if (fDay == 1) {
			return localDate.withDayOfMonth(5);
		} else if (fDay == 2) {
			return localDate.withDayOfMonth(10);
		} else if (fDay == 3) {
			return localDate.withDayOfMonth(15);
		} else if (fDay == 4) {
			return localDate.withDayOfMonth(20);
		} else if (fDay == 5) {
			return localDate.withDayOfMonth(25);
		} else {
			return localDate.withDayOfMonth(localDate.lengthOfMonth());
		}
	}

	public java.lang.String getDataFormatePath(java.lang.String path, java.time.LocalDate dt) {
		java.lang.String result = "";
		try {
			java.lang.String[] array = path.split("/");
			for (int i = 0; i < array.length; i++) {
				java.lang.String item = array[i];
				if (item.endsWith("|") && item.startsWith("|")) {
					java.lang.String formateStr = item.substring(1, item.length() - 1);
					array[i] = cn.com.ogtwelve.utils.LocalDateTimeUtil.getInstance().formatDate(dt, formateStr);
				}
			}
			for (java.lang.String item : array) {
				result += item + "/";
			}
		} catch (java.lang.Exception e) {
			java.lang.System.out.println(e);
		}
		return result.substring(0, result.length() - 1);
	}

	public java.lang.String getDataFormate(java.lang.String sourceFileDate, java.time.LocalDate dt) {
		java.lang.String result = sourceFileDate;
		try {
			if (sourceFileDate.contains("|")) {
				java.lang.String formateStr = sourceFileDate.substring(sourceFileDate.indexOf("|") + 1, sourceFileDate.lastIndexOf("|"));
				java.time.format.DateTimeFormatter dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(formateStr);
				result = sourceFileDate.replace(formateStr, dt.format(dateTimeFormatter)).replace("|", "");
			}
		} catch (java.lang.Exception e) {
			java.lang.System.out.println(e);
		}
		return result;
	}

	public java.lang.String appendZero(int obj) {
		if (obj < 10) {
			return "0" + obj;
		} else {
			return java.lang.String.valueOf(obj);
		}
	}

	public static void main(java.lang.String[] args) {
		cn.com.ogtwelve.utils.LocalDateTimeUtil localDateTimeUtil = new cn.com.ogtwelve.utils.LocalDateTimeUtil();
		java.time.LocalDate localDate = java.time.LocalDate.now();
		java.lang.String path = "{yyyyMMdd}";
		localDateTimeUtil.getDataFormatePath(path, localDate);
		int days = localDateTimeUtil.getDaysOfMonth(1);
		java.lang.System.out.println(days);
	}
}