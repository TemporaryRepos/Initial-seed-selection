public class SerializeExceptions {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.util.prefs.SerializeExceptions.test(new java.util.prefs.BackingStoreException("Hi"));
		javaT.util.prefs.SerializeExceptions.test(new java.util.prefs.InvalidPreferencesFormatException("Mom!"));
	}

	static void test(java.lang.Object o) throws java.io.IOException {
		java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(bos);
		out.writeObject(o);
		out.flush();
		out.close();
	}
}