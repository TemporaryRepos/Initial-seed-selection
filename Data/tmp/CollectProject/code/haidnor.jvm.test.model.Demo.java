public class Demo {
	static {
		java.lang.System.out.println("类被加载了");
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("helloWorld");
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int div(int a, int b) {
		int c = 0;
		try {
			c = a / b;
		} catch (java.lang.Exception exception) {
			throw new java.lang.RuntimeException();
		} finally {
			java.lang.System.out.println("调用 div()");
		}
		return c;
	}
}