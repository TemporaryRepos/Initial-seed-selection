public class Utils {
	public static final java.lang.String DOT_IDWORKERS = ".idworkers";

	public static java.lang.ClassLoader getClassLoader() {
		java.lang.ClassLoader contextClassLoader = java.lang.Thread.currentThread().getContextClassLoader();
		return contextClassLoader != null ? contextClassLoader : org.n3r.idworker.utils.Utils.class.getClassLoader();
	}

	public static java.io.InputStream classResourceToStream(java.lang.String resourceName) {
		return org.n3r.idworker.utils.Utils.getClassLoader().getResourceAsStream(resourceName);
	}

	public static java.lang.String firstLine(java.lang.String classResourceName) {
		java.io.InputStream inputStream = null;
		try {
			inputStream = org.n3r.idworker.utils.Utils.classResourceToStream(classResourceName);
			java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, "UTF-8"));
			return bufferedReader.readLine();
		} catch (java.io.IOException e) {
			return null;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (java.io.IOException e) {
				}
			}
		}
	}

	public static java.lang.String checkNotEmpty(java.lang.String param, java.lang.String name) {
		if ((param == null) || param.isEmpty()) {
			throw new java.lang.IllegalArgumentException(name + " is empty");
		}
		return param;
	}

	public static long midnightMillis() {
		java.util.Calendar date = java.util.Calendar.getInstance();
		date.set(java.util.Calendar.HOUR_OF_DAY, 0);
		date.set(java.util.Calendar.MINUTE, 0);
		date.set(java.util.Calendar.SECOND, 0);
		date.set(java.util.Calendar.MILLISECOND, 0);
		return date.getTimeInMillis();
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.sql.Timestamp(org.n3r.idworker.utils.Utils.midnightMillis())));
		java.lang.System.out.println(org.n3r.idworker.utils.Utils.encode(281474976710655L));
	}

	public static long decode(java.lang.String s, java.lang.String symbols) {
		final int B = symbols.length();
		long num = 0;
		for (char ch : s.toCharArray()) {
			num *= B;
			num += symbols.indexOf(ch);
		}
		return num;
	}

	public static java.lang.String encode(long num) {
		return org.n3r.idworker.utils.Utils.encode(num, org.n3r.idworker.utils.Utils.defaultRange);
	}

	public static java.lang.String encode(long num, java.lang.String symbols) {
		final int B = symbols.length();
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		while (num != 0) {
			sb.append(symbols.charAt(((int) (num % B))));
			num /= B;
		} 
		return sb.reverse().toString();
	}

	static java.lang.String defaultRange = "0123456789ABCDFGHKMNPRSTWXYZ";

	public static java.lang.String padLeft(java.lang.String str, int size, char padChar) {
		if (str.length() >= size) {
			return str;
		}
		java.lang.StringBuilder s = new java.lang.StringBuilder();
		for (int i = size - str.length(); i > 0; --i) {
			s.append(padChar);
		}
		s.append(str);
		return s.toString();
	}

	public static java.io.File createIdWorkerHome() {
		java.lang.String userHome = java.lang.System.getProperty("user.home");
		java.io.File idWorkerHome = new java.io.File((userHome + java.io.File.separator) + org.n3r.idworker.utils.Utils.DOT_IDWORKERS);
		idWorkerHome.mkdirs();
		if (idWorkerHome.isDirectory()) {
			return idWorkerHome;
		}
		throw new java.lang.RuntimeException("failed to create .idworkers at user home");
	}
}