public class TestCatchException {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		java.lang.invoke.MethodHandle throwing = TestCatchException.findStatic("throwing");
		java.lang.invoke.MethodHandle catching = TestCatchException.findStatic("catching");
		java.lang.invoke.MethodHandles.catchException(throwing, TestCatchException.MyException.class, java.lang.invoke.MethodHandles.dropArguments(catching, 0, TestCatchException.MyException.class));
	}

	private static class MyException extends java.lang.RuntimeException {}

	private static java.lang.invoke.MethodHandle findStatic(java.lang.String name) {
		return Lookup.PUBLIC.findStatic(TestCatchException.class, name, java.lang.invoke.MethodType.methodType(int.class, java.lang.Object.class));
	}

	public static int throwing(java.lang.Object o) {
		throw new java.lang.IllegalArgumentException();
	}

	public static int catching(java.lang.Object o) {
		return 0;
	}
}