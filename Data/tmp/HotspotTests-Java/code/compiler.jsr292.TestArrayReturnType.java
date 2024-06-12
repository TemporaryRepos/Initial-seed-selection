public class TestArrayReturnType {
	static final java.lang.invoke.MethodHandle mh;

	static int[] testArray = new int[1];

	static {
		try {
			mh = java.lang.invoke.MethodHandles.lookup().findStatic(compiler.jsr292.TestArrayReturnType.class, "testArrayReturnType", java.lang.invoke.MethodType.methodType(int[].class));
		} catch (java.lang.Exception e) {
			throw new java.lang.Error(e);
		}
	}

	static int[] testArrayReturnType() {
		return compiler.jsr292.TestArrayReturnType.testArray;
	}

	public static void test() throws java.lang.Throwable {
		int[] a = ((int[]) (compiler.jsr292.TestArrayReturnType.mh.invokeExact()));
		for (int i = 0; i < a.length; i++) {
			a[i] = 1;
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		for (int i = 0; i < 15000; i++) {
			compiler.jsr292.TestArrayReturnType.test();
		}
		java.lang.System.out.println("TEST PASSED");
	}
}