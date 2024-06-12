public class RelativeDateFormat extends java.text.DateFormat {
	private long baseMillis;

	private boolean showZeroDays;

	private boolean showZeroHours;

	private java.text.NumberFormat dayFormatter;

	private java.lang.String positivePrefix;

	private java.lang.String daySuffix;

	private java.text.NumberFormat hourFormatter;

	private java.lang.String hourSuffix;

	private java.text.NumberFormat minuteFormatter;

	private java.lang.String minuteSuffix;

	private java.text.NumberFormat secondFormatter;

	private java.lang.String secondSuffix;

	private static long MILLISECONDS_IN_ONE_HOUR = (60 * 60) * 1000L;

	private static long MILLISECONDS_IN_ONE_DAY = 24 * org.jfree.chart.util.RelativeDateFormat.MILLISECONDS_IN_ONE_HOUR;

	public RelativeDateFormat() {
		this(0L);
	}

	public RelativeDateFormat(java.util.Date time) {
		this(time.getTime());
	}

	public RelativeDateFormat(long baseMillis) {
		super();
		this.baseMillis = baseMillis;
		this.showZeroDays = false;
		this.showZeroHours = true;
		this.positivePrefix = "";
		this.dayFormatter = java.text.NumberFormat.getNumberInstance();
		this.daySuffix = "d";
		this.hourFormatter = java.text.NumberFormat.getNumberInstance();
		this.hourSuffix = "h";
		this.minuteFormatter = java.text.NumberFormat.getNumberInstance();
		this.minuteSuffix = "m";
		this.secondFormatter = java.text.NumberFormat.getNumberInstance();
		this.secondFormatter.setMaximumFractionDigits(3);
		this.secondFormatter.setMinimumFractionDigits(3);
		this.secondSuffix = "s";
		this.calendar = new java.util.GregorianCalendar();
		this.numberFormat = new java.text.DecimalFormat("0");
	}

	public long getBaseMillis() {
		return this.baseMillis;
	}

	public void setBaseMillis(long baseMillis) {
		this.baseMillis = baseMillis;
	}

	public boolean getShowZeroDays() {
		return this.showZeroDays;
	}

	public void setShowZeroDays(boolean show) {
		this.showZeroDays = show;
	}

	public boolean getShowZeroHours() {
		return this.showZeroHours;
	}

	public void setShowZeroHours(boolean show) {
		this.showZeroHours = show;
	}

	public java.lang.String getPositivePrefix() {
		return this.positivePrefix;
	}

	public void setPositivePrefix(java.lang.String prefix) {
		if (prefix == null) {
			throw new java.lang.IllegalArgumentException("Null 'prefix' argument.");
		}
		this.positivePrefix = prefix;
	}

	public void setDayFormatter(java.text.NumberFormat formatter) {
		if (formatter == null) {
			throw new java.lang.IllegalArgumentException("Null 'formatter' argument.");
		}
		this.dayFormatter = formatter;
	}

	public java.lang.String getDaySuffix() {
		return this.daySuffix;
	}

	public void setDaySuffix(java.lang.String suffix) {
		if (suffix == null) {
			throw new java.lang.IllegalArgumentException("Null 'suffix' argument.");
		}
		this.daySuffix = suffix;
	}

	public void setHourFormatter(java.text.NumberFormat formatter) {
		if (formatter == null) {
			throw new java.lang.IllegalArgumentException("Null 'formatter' argument.");
		}
		this.hourFormatter = formatter;
	}

	public java.lang.String getHourSuffix() {
		return this.hourSuffix;
	}

	public void setHourSuffix(java.lang.String suffix) {
		if (suffix == null) {
			throw new java.lang.IllegalArgumentException("Null 'suffix' argument.");
		}
		this.hourSuffix = suffix;
	}

	public void setMinuteFormatter(java.text.NumberFormat formatter) {
		if (formatter == null) {
			throw new java.lang.IllegalArgumentException("Null 'formatter' argument.");
		}
		this.minuteFormatter = formatter;
	}

	public java.lang.String getMinuteSuffix() {
		return this.minuteSuffix;
	}

	public void setMinuteSuffix(java.lang.String suffix) {
		if (suffix == null) {
			throw new java.lang.IllegalArgumentException("Null 'suffix' argument.");
		}
		this.minuteSuffix = suffix;
	}

	public java.lang.String getSecondSuffix() {
		return this.secondSuffix;
	}

	public void setSecondSuffix(java.lang.String suffix) {
		if (suffix == null) {
			throw new java.lang.IllegalArgumentException("Null 'suffix' argument.");
		}
		this.secondSuffix = suffix;
	}

	public void setSecondFormatter(java.text.NumberFormat formatter) {
		if (formatter == null) {
			throw new java.lang.IllegalArgumentException("Null 'formatter' argument.");
		}
		this.secondFormatter = formatter;
	}

	@java.lang.Override
	public java.lang.StringBuffer format(java.util.Date date, java.lang.StringBuffer toAppendTo, java.text.FieldPosition fieldPosition) {
		long currentMillis = date.getTime();
		long elapsed = currentMillis - this.baseMillis;
		java.lang.String signPrefix;
		if (elapsed < 0) {
			elapsed *= -1L;
			signPrefix = "-";
		} else {
			signPrefix = this.positivePrefix;
		}
		long days = elapsed / org.jfree.chart.util.RelativeDateFormat.MILLISECONDS_IN_ONE_DAY;
		elapsed = elapsed - (days * org.jfree.chart.util.RelativeDateFormat.MILLISECONDS_IN_ONE_DAY);
		long hours = elapsed / org.jfree.chart.util.RelativeDateFormat.MILLISECONDS_IN_ONE_HOUR;
		elapsed = elapsed - (hours * org.jfree.chart.util.RelativeDateFormat.MILLISECONDS_IN_ONE_HOUR);
		long minutes = elapsed / 60000L;
		elapsed = elapsed - (minutes * 60000L);
		double seconds = elapsed / 1000.0;
		toAppendTo.append(signPrefix);
		if ((days != 0) || this.showZeroDays) {
			toAppendTo.append(this.dayFormatter.format(days) + getDaySuffix());
		}
		if ((hours != 0) || this.showZeroHours) {
			toAppendTo.append(this.hourFormatter.format(hours) + getHourSuffix());
		}
		toAppendTo.append(this.minuteFormatter.format(minutes) + getMinuteSuffix());
		toAppendTo.append(this.secondFormatter.format(seconds) + getSecondSuffix());
		return toAppendTo;
	}

	@java.lang.Override
	public java.util.Date parse(java.lang.String source, java.text.ParsePosition pos) {
		return null;
	}

	@java.lang.Override
	public boolean equals(java.lang.Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof org.jfree.chart.util.RelativeDateFormat)) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		}
		org.jfree.chart.util.RelativeDateFormat that = ((org.jfree.chart.util.RelativeDateFormat) (obj));
		if (this.baseMillis != that.baseMillis) {
			return false;
		}
		if (this.showZeroDays != that.showZeroDays) {
			return false;
		}
		if (this.showZeroHours != that.showZeroHours) {
			return false;
		}
		if (!this.positivePrefix.equals(that.positivePrefix)) {
			return false;
		}
		if (!this.daySuffix.equals(that.daySuffix)) {
			return false;
		}
		if (!this.hourSuffix.equals(that.hourSuffix)) {
			return false;
		}
		if (!this.minuteSuffix.equals(that.minuteSuffix)) {
			return false;
		}
		if (!this.secondSuffix.equals(that.secondSuffix)) {
			return false;
		}
		if (!this.dayFormatter.equals(that.dayFormatter)) {
			return false;
		}
		if (!this.hourFormatter.equals(that.hourFormatter)) {
			return false;
		}
		if (!this.minuteFormatter.equals(that.minuteFormatter)) {
			return false;
		}
		if (!this.secondFormatter.equals(that.secondFormatter)) {
			return false;
		}
		return true;
	}

	@java.lang.Override
	public int hashCode() {
		int result = 193;
		result = (37 * result) + ((int) (this.baseMillis ^ (this.baseMillis >>> 32)));
		result = (37 * result) + this.positivePrefix.hashCode();
		result = (37 * result) + this.daySuffix.hashCode();
		result = (37 * result) + this.hourSuffix.hashCode();
		result = (37 * result) + this.minuteSuffix.hashCode();
		result = (37 * result) + this.secondSuffix.hashCode();
		result = (37 * result) + this.secondFormatter.hashCode();
		return result;
	}

	@java.lang.Override
	public java.lang.Object clone() {
		org.jfree.chart.util.RelativeDateFormat clone = ((org.jfree.chart.util.RelativeDateFormat) (super.clone()));
		clone.dayFormatter = ((java.text.NumberFormat) (this.dayFormatter.clone()));
		clone.secondFormatter = ((java.text.NumberFormat) (this.secondFormatter.clone()));
		return clone;
	}

	public static void main(java.lang.String[] args) {
		java.util.GregorianCalendar c0 = new java.util.GregorianCalendar(2006, 10, 1, 0, 0, 0);
		java.util.GregorianCalendar c1 = new java.util.GregorianCalendar(2006, 10, 1, 11, 37, 43);
		c1.set(java.util.Calendar.MILLISECOND, 123);
		java.lang.System.out.println("Default: ");
		org.jfree.chart.util.RelativeDateFormat rdf = new org.jfree.chart.util.RelativeDateFormat(c0.getTimeInMillis());
		java.lang.System.out.println(rdf.format(c1.getTime()));
		java.lang.System.out.println();
		java.lang.System.out.println("Hide milliseconds: ");
		rdf.setSecondFormatter(new java.text.DecimalFormat("0"));
		java.lang.System.out.println(rdf.format(c1.getTime()));
		java.lang.System.out.println();
		java.lang.System.out.println("Show zero day output: ");
		rdf.setShowZeroDays(true);
		java.lang.System.out.println(rdf.format(c1.getTime()));
		java.lang.System.out.println();
		java.lang.System.out.println("Alternative suffixes: ");
		rdf.setShowZeroDays(false);
		rdf.setDaySuffix(":");
		rdf.setHourSuffix(":");
		rdf.setMinuteSuffix(":");
		rdf.setSecondSuffix("");
		java.lang.System.out.println(rdf.format(c1.getTime()));
		java.lang.System.out.println();
	}
}