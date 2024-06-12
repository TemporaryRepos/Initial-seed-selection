public class Test7046096 {
	static int first = 1;

	java.lang.String add(java.lang.String str) {
		if (compiler.c2.Test7046096.first != 0) {
			return str + "789";
		} else {
			return "null";
		}
	}

	java.lang.String test(java.lang.String str) {
		for (int i = 0; i < compiler.c2.Test7046096.first; i++) {
			if (i > 1) {
				return "bad";
			}
		}
		return add(str + "456");
	}

	public static void main(java.lang.String[] args) {
		compiler.c2.Test7046096 t = new compiler.c2.Test7046096();
		for (int i = 0; i < 11000; i++) {
			java.lang.String str = t.test("123");
			if (!str.equals("123456789")) {
				java.lang.System.out.println(("FAILED: " + str) + " != \"123456789\"");
				java.lang.System.exit(97);
			}
		}
	}
}