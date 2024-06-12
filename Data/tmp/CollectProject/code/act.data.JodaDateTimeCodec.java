@javax.inject.Singleton
public class JodaDateTimeCodec extends act.data.JodaReadableInstantCodecBase<org.joda.time.DateTime> {
	public JodaDateTimeCodec(org.joda.time.format.DateTimeFormatter formatter) {
		super(formatter);
	}

	public JodaDateTimeCodec(java.lang.String pattern) {
		super(pattern);
	}

	@javax.inject.Inject
	public JodaDateTimeCodec(act.conf.AppConfig config) {
		this(config.dateTimePattern());
	}

	@java.lang.Override
	protected org.joda.time.format.DateTimeFormatter isoFormatter() {
		return org.joda.time.format.ISODateTimeFormat.dateTime();
	}

	@java.lang.Override
	protected act.data.JodaDateTimeCodecBase<org.joda.time.DateTime> create(java.lang.String pattern) {
		return new act.data.JodaDateTimeCodec(pattern);
	}

	@java.lang.Override
	protected org.joda.time.DateTime parse(org.joda.time.format.DateTimeFormatter formatter, java.lang.String value) {
		return formatter.parseDateTime(value);
	}

	@java.lang.Override
	protected org.joda.time.DateTime now() {
		return org.joda.time.DateTime.now();
	}

	@java.lang.Override
	protected java.lang.String dateTimePattern(act.conf.AppConfig config, java.util.Locale locale) {
		return config.localizedDateTimePattern(locale);
	}

	public static void main(java.lang.String[] args) {
		java.util.Date today;
		java.lang.String result;
		java.text.SimpleDateFormat formatter;
		java.util.Locale currentLocale = java.util.Locale.TRADITIONAL_CHINESE;
		java.lang.System.out.println(((java.text.SimpleDateFormat) (java.text.DateFormat.getDateTimeInstance(java.text.DateFormat.LONG, java.text.DateFormat.LONG, java.util.Locale.CHINA))).toPattern());
	}
}