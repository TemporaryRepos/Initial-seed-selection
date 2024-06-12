public class ResourcesUtil implements java.io.Serializable {
	private static final long serialVersionUID = -7657898714983901418L;

	public static final java.lang.String LANGUAGE = "zh";

	public static final java.lang.String COUNTRY = "CN";

	private static java.util.Locale getLocale() {
		java.util.Locale locale = new java.util.Locale(com.megagao.production.ssm.util.ResourcesUtil.LANGUAGE, com.megagao.production.ssm.util.ResourcesUtil.COUNTRY);
		return locale;
	}

	private static java.lang.String getProperties(java.lang.String baseName, java.lang.String section) {
		java.lang.String retValue = "";
		try {
			java.util.Locale locale = com.megagao.production.ssm.util.ResourcesUtil.getLocale();
			java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle(baseName, locale);
			retValue = ((java.lang.String) (rb.getObject(section)));
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return retValue;
	}

	public static java.lang.String getValue(java.lang.String fileName, java.lang.String key) {
		java.lang.String value = com.megagao.production.ssm.util.ResourcesUtil.getProperties(fileName, key);
		return value;
	}

	public static java.util.List<java.lang.String> gekeyList(java.lang.String baseName) {
		java.util.Locale locale = com.megagao.production.ssm.util.ResourcesUtil.getLocale();
		java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle(baseName, locale);
		java.util.List<java.lang.String> reslist = new java.util.ArrayList<java.lang.String>();
		java.util.Set<java.lang.String> keyset = rb.keySet();
		for (java.util.Iterator<java.lang.String> it = keyset.iterator(); it.hasNext();) {
			java.lang.String lkey = ((java.lang.String) (it.next()));
			reslist.add(lkey);
		}
		return reslist;
	}

	public static java.lang.String getValue(java.lang.String fileName, java.lang.String key, java.lang.Object[] objs) {
		java.lang.String pattern = com.megagao.production.ssm.util.ResourcesUtil.getValue(fileName, key);
		java.lang.String value = java.text.MessageFormat.format(pattern, objs);
		return value;
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.megagao.production.ssm.util.ResourcesUtil.getValue("resources.messages", "101", new java.lang.Object[]{ 100, 200 }));
	}
}