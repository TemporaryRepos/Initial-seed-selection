public class Test6850611 {
	public static void main(java.lang.String[] args) {
		compiler.c2.Test6850611.test();
	}

	private static void test() {
		for (int j = 0; j < 5; ++j) {
			long x = 0;
			for (int i = java.lang.Integer.MIN_VALUE; i < java.lang.Integer.MAX_VALUE; ++i) {
				x += i;
			}
			java.lang.System.out.println("sum: " + x);
			if (x != (-4294967295L)) {
				java.lang.System.out.println("FAILED");
				java.lang.System.exit(97);
			}
		}
	}
}