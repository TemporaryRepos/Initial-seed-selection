@java.lang.SuppressWarnings("unused")
public class TimeZoneResolver extends act.controller.Controller.Util {
	public static final java.lang.String SESSION_KEY = "__tz__";

	@org.osgl.mvc.annotation.PostAction("i18n/timezone")
	@act.apidoc.Description("Set timezone into session. The value should be offset to UTC in minutes")
	public static void updateTimezoneOffset(@act.apidoc.Description("the timezone offset to UTC in minutes")
	int offset, org.osgl.http.H.Session session) {
		session.put(act.i18n.TimeZoneResolver.SESSION_KEY, offset);
	}

	public static int timezoneOffset() {
		return act.i18n.TimeZoneResolver.timezoneOffset(org.osgl.http.H.Session.current());
	}

	public static int timezoneOffset(org.osgl.http.H.Session session) {
		java.lang.String s = (null != session) ? session.get(act.i18n.TimeZoneResolver.SESSION_KEY) : null;
		return org.osgl.util.S.notBlank(s) ? java.lang.Integer.parseInt(s) : act.i18n.TimeZoneResolver.serverTimezoneOffset();
	}

	public static int serverTimezoneOffset() {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		return (-(cal.get(java.util.Calendar.ZONE_OFFSET) + cal.get(java.util.Calendar.DST_OFFSET))) / (1000 * 60);
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(act.i18n.TimeZoneResolver.serverTimezoneOffset());
	}
}