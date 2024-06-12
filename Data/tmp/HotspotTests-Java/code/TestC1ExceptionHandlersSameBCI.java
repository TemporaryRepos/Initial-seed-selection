public class TestC1ExceptionHandlersSameBCI {
	static class Ex1 extends java.lang.Exception {}

	static class Ex2 extends java.lang.Exception {}

	static void not_inline1() throws TestC1ExceptionHandlersSameBCI.Ex1, TestC1ExceptionHandlersSameBCI.Ex2 {
	}

	static void not_inline2(int v) {
	}

	static void test1() throws TestC1ExceptionHandlersSameBCI.Ex1, TestC1ExceptionHandlersSameBCI.Ex2 {
		int i = 0;
		try {
			TestC1ExceptionHandlersSameBCI.not_inline1();
			i = 1;
			TestC1ExceptionHandlersSameBCI.not_inline1();
		} catch (TestC1ExceptionHandlersSameBCI.Ex1 | TestC1ExceptionHandlersSameBCI.Ex2 ex) {
			TestC1ExceptionHandlersSameBCI.not_inline2(i);
		}
	}

	static void test2() {
		int i = 0;
		try {
			TestC1ExceptionHandlersSameBCI.test1();
			i = 1;
			TestC1ExceptionHandlersSameBCI.test1();
		} catch (TestC1ExceptionHandlersSameBCI.Ex1 | TestC1ExceptionHandlersSameBCI.Ex2 ex) {
			TestC1ExceptionHandlersSameBCI.not_inline2(i);
		}
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 5000; i++) {
			TestC1ExceptionHandlersSameBCI.test2();
		}
	}
}