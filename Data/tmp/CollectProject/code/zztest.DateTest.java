public class DateTest {
	public static void main(java.lang.String[] args) {
	}

	public void diffDays() {
		java.util.Date date1 = com.icexxx.util.IceUtil.parseDate("2015-12-12 23:59:59");
		java.util.Date date2 = com.icexxx.util.IceUtil.parseDate("2015-12-13 00:00:01");
		print(com.icexxx.util.IceUtil.dayLength(date1, date2));
	}

	public void diffDays2() {
		java.util.Date date1 = com.icexxx.util.IceUtil.parseDate("2015-12-12 23:59:59");
		java.util.Date date2 = com.icexxx.util.IceUtil.parseDate("2015-12-13 00:00:00");
		print(com.icexxx.util.IceUtil.dayLength(date1, date2));
	}

	@org.junit.Test
	public void diffDays3() {
		java.util.Date date1 = com.icexxx.util.IceUtil.parseDate("2015-12-13 00:00:01");
		java.util.Date date2 = com.icexxx.util.IceUtil.parseDate("2015-12-12 23:59:59");
		print(com.icexxx.util.IceUtil.dayLength(date1, date2));
	}

	@org.junit.Test
	public void diffDays4() {
		java.util.Date date1 = com.icexxx.util.IceUtil.parseDate("2015-12-12 00:00:00");
		java.util.Date date2 = com.icexxx.util.IceUtil.parseDate("2015-12-13 23:59:59");
		print(com.icexxx.util.IceUtil.dayLength(date1, date2));
	}

	@org.junit.Test
	public void diffDays5() {
		java.util.Date date1 = com.icexxx.util.IceUtil.parseDate("2015-12-12 00:00:00");
		java.util.Date date2 = com.icexxx.util.IceUtil.parseDate("2015-12-12 23:59:59");
		print(com.icexxx.util.IceUtil.dayLength(date1, date2));
	}

	@org.junit.Test
	public void diffDays6() {
		java.util.Date date1 = com.icexxx.util.IceUtil.parseDate("2015-12-13 23:59:59");
		java.util.Date date2 = com.icexxx.util.IceUtil.parseDate("2015-12-12 00:00:00");
		print(com.icexxx.util.IceUtil.dayLength(date1, date2));
	}
}