public class demo_exception_2 {
	public static void main(java.lang.String[] args) {
		int a = 0;
		try {
			haidnor.jvm.test.demo.demo_exception_2.fun(a);
		} catch (java.lang.Exception exception) {
			java.lang.System.out.println("catch Exception");
		}
	}

	public static void fun(int a) {
		if (a == 0) {
			throw new java.lang.ArithmeticException();
		}
	}
}