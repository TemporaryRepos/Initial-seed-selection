public class Test6916644 {
	static int result;

	static int i1;

	static int i2;

	public static void test(double d) {
		compiler.c2.Test6916644.result = (d <= 0.0) ? compiler.c2.Test6916644.i1 : compiler.c2.Test6916644.i2;
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 100000; i++) {
			compiler.c2.Test6916644.test(i & 1);
		}
	}
}