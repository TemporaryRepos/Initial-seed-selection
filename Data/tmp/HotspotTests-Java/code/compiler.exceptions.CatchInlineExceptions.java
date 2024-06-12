public class CatchInlineExceptions {
	static class Exception1 extends java.lang.Exception {}

	static class Exception2 extends java.lang.Exception {}

	private static int counter0;

	private static int counter1;

	private static int counter2;

	private static int counter;

	static void foo(int i) throws java.lang.Exception {
		if ((i & 1023) == 2) {
			compiler.exceptions.CatchInlineExceptions.counter0++;
			throw new compiler.exceptions.CatchInlineExceptions.Exception2();
		}
	}

	static void test(int i) throws java.lang.Exception {
		try {
			compiler.exceptions.CatchInlineExceptions.foo(i);
		} catch (java.lang.Exception e) {
			if (e instanceof compiler.exceptions.CatchInlineExceptions.Exception1) {
				compiler.exceptions.CatchInlineExceptions.counter1++;
			} else if (e instanceof compiler.exceptions.CatchInlineExceptions.Exception2) {
				compiler.exceptions.CatchInlineExceptions.counter2++;
			}
			compiler.exceptions.CatchInlineExceptions.counter++;
			throw e;
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		for (int i = 0; i < 15000; i++) {
			try {
				compiler.exceptions.CatchInlineExceptions.test(i);
			} catch (java.lang.Exception e) {
			}
		}
		if (compiler.exceptions.CatchInlineExceptions.counter1 != 0) {
			throw new java.lang.RuntimeException(("Failed: counter1(" + compiler.exceptions.CatchInlineExceptions.counter1) + ") != 0");
		}
		if (compiler.exceptions.CatchInlineExceptions.counter2 != compiler.exceptions.CatchInlineExceptions.counter0) {
			throw new java.lang.RuntimeException(((("Failed: counter2(" + compiler.exceptions.CatchInlineExceptions.counter2) + ") != counter0(") + compiler.exceptions.CatchInlineExceptions.counter0) + ")");
		}
		if (compiler.exceptions.CatchInlineExceptions.counter2 != compiler.exceptions.CatchInlineExceptions.counter) {
			throw new java.lang.RuntimeException(((("Failed: counter2(" + compiler.exceptions.CatchInlineExceptions.counter2) + ") != counter(") + compiler.exceptions.CatchInlineExceptions.counter) + ")");
		}
		java.lang.System.out.println("TEST PASSED");
	}
}