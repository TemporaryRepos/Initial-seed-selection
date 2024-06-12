public class ExceptionHandlingExample1 {
	public static void methodThrowCheckedException() throws java.lang.RuntimeException {
		throw new java.lang.RuntimeException();
	}

	public static void methodSomething() {
		com.in28minutes.java.exceptionhandling.ExceptionHandlingExample1.methodThrowCheckedException();
	}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.exceptionhandling.ExceptionHandlingExample1.method1();
		java.lang.System.out.println("Line after Exception - Main");
	}

	private static void method1() {
		com.in28minutes.java.exceptionhandling.ExceptionHandlingExample1.method2();
		java.lang.System.out.println("Line after Exception - Method 1");
	}

	private static void method2() {
		com.in28minutes.java.exceptionhandling.Connection connection = new com.in28minutes.java.exceptionhandling.Connection();
		connection.open();
		try {
			return;
		} catch (java.lang.Exception e) {
		} finally {
		}
	}
}