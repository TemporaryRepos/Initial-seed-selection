public class TestStringConstruction {
	public static void main(java.lang.String[] args) {
		char[] chars = new char[42];
		for (int i = 0; i < 10000; ++i) {
			compiler.intrinsics.string.TestStringConstruction.test(chars);
		}
	}

	private static java.lang.String test(char[] chars) {
		try {
			return new java.lang.String(chars, -1, 42);
		} catch (java.lang.Exception e) {
			return "";
		}
	}
}