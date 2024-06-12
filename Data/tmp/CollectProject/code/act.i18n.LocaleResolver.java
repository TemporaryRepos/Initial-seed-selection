public class LocaleResolver {
	private static final java.lang.String KEY = "__locale__";

	private static final int COOKIE_TTL = ((60 * 60) * 24) * 7;

	private act.app.ActionContext context;

	private act.conf.AppConfig config;

	private boolean enabled;

	private java.util.Locale locale;

	private boolean reset;

	private boolean resolvedFromParam;

	@act.apidoc.Description("Set locale to the session. The parameter name is configured with default value act_locale, it must be put as a query parameter instead of form field")
	@org.osgl.mvc.annotation.PostAction("i18n/locale")
	public static void updateLocale(org.osgl.http.H.Request request) {
		java.lang.String s = request.header(org.osgl.http.H.Header.Names.REFERER);
		if (org.osgl.util.S.notBlank(s)) {
			throw act.controller.Controller.Util.redirect(s);
		}
	}

	@javax.inject.Inject
	public LocaleResolver(act.app.ActionContext context) {
		act.conf.AppConfig config = context.config();
		this.enabled = config.i18nEnabled();
		if (!this.enabled) {
			return;
		}
		this.context = context;
		this.config = config;
	}

	public void resolve() {
		if (!enabled) {
			return;
		}
		java.util.Locale locale = resolveFromParam();
		if ((!reset) && (null == locale)) {
			locale = resolveFromSessionOrCookie();
		}
		if (null == locale) {
			locale = resolveFromHeader();
		}
		if (null == locale) {
			locale = resolveFromServer();
		}
		context.locale(locale);
		this.locale = locale;
	}

	public void dissolve() {
		if (!shouldWriteLocaleCookie()) {
			return;
		}
		java.lang.String cookieName = config.localeCookieName();
		java.util.Locale locale = context.locale();
		if (null == locale) {
			locale = this.locale;
		}
		java.lang.String localeStr = locale.toString();
		org.osgl.http.H.Session session = context.session();
		if (null != session) {
			if (reset) {
				session.remove(act.i18n.LocaleResolver.KEY);
			} else {
				session.put(act.i18n.LocaleResolver.KEY, localeStr);
			}
		}
		org.osgl.http.H.Cookie cookie = new org.osgl.http.H.Cookie(cookieName, localeStr);
		cookie.domain(config.cookieDomain());
		cookie.path("/");
		cookie.maxAge(reset ? -1 : act.i18n.LocaleResolver.COOKIE_TTL);
		if (reset) {
			cookie.expires(org.joda.time.DateTime.now().minusDays(1).toDate());
		}
		context.resp().addCookie(cookie);
	}

	private boolean shouldWriteLocaleCookie() {
		return enabled && ((reset || resolvedFromParam) || (locale != context.locale()));
	}

	private java.util.Locale resolveFromSessionOrCookie() {
		java.util.Locale locale = null;
		org.osgl.http.H.Session session = context.session();
		if (null != session) {
			locale = parseStr(session.get(act.i18n.LocaleResolver.KEY));
		}
		if (null == locale) {
			org.osgl.http.H.Cookie cookie = context.cookie(config.localeCookieName());
			locale = (null == cookie) ? null : parseStr(cookie.value());
		}
		return locale;
	}

	private java.util.Locale resolveFromParam() {
		java.lang.String s = context.paramValwithoutBodyParsing(config.localeParamName());
		java.util.Locale locale = parseStr(s);
		if (null != locale) {
			resolvedFromParam = true;
		}
		return locale;
	}

	private java.util.Locale resolveFromHeader() {
		return context.req().locale();
	}

	private java.util.Locale resolveFromServer() {
		return config.locale();
	}

	private java.util.Locale parseStr(java.lang.String val) {
		if (null == val) {
			return null;
		}
		if ("default".equals(val)) {
			reset = true;
			return null;
		}
		java.lang.String[] sa = val.trim().split("[-_]");
		int len = sa.length;
		switch (len) {
			case 3 :
				return new java.util.Locale(sa[0], sa[1], sa[2]);
			case 2 :
				return new java.util.Locale(sa[0], sa[1]);
			default :
				return new java.util.Locale(sa[0]);
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(java.util.Locale.US.toLanguageTag());
	}
}