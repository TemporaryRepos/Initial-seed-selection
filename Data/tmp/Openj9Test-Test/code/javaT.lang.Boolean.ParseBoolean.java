public class ParseBoolean {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.Boolean.ParseBoolean.checkTrue(java.lang.Boolean.parseBoolean("TRUE"));
		javaT.lang.Boolean.ParseBoolean.checkTrue(java.lang.Boolean.parseBoolean("true"));
		javaT.lang.Boolean.ParseBoolean.checkTrue(java.lang.Boolean.parseBoolean("TrUe"));
		javaT.lang.Boolean.ParseBoolean.checkFalse(java.lang.Boolean.parseBoolean("false"));
		javaT.lang.Boolean.ParseBoolean.checkFalse(java.lang.Boolean.parseBoolean("FALSE"));
		javaT.lang.Boolean.ParseBoolean.checkFalse(java.lang.Boolean.parseBoolean("FaLse"));
		javaT.lang.Boolean.ParseBoolean.checkFalse(java.lang.Boolean.parseBoolean(null));
		javaT.lang.Boolean.ParseBoolean.checkFalse(java.lang.Boolean.parseBoolean("garbage"));
		javaT.lang.Boolean.ParseBoolean.checkFalse(java.lang.Boolean.parseBoolean("TRUEE"));
	}

	static void checkTrue(boolean b) {
		if (!b) {
			throw new java.lang.RuntimeException("test failed");
		}
	}

	static void checkFalse(boolean b) {
		if (b) {
			throw new java.lang.RuntimeException("test failed");
		}
	}
}