public class InvokespecialInterface {
	interface I {
		public default void imethod() {
			java.lang.System.out.println("I::imethod");
		}
	}

	static class C implements InvokespecialInterface.I {
		public void foo() {
			InvokespecialInterface.I.super.imethod();
		}

		public void bar() {
			InvokespecialInterface.I i = this;
			i.imethod();
		}

		public void doSomeInvokedynamic() {
			java.lang.String str = "world";
			java.util.function.Supplier<java.lang.String> foo = () -> "hello, " + str;
			java.lang.String res = foo.get();
			java.lang.System.out.println(res);
		}
	}

	public static void main(java.lang.String[] unused) {
		InvokespecialInterface.C c = new InvokespecialInterface.C();
		c.foo();
		c.bar();
		c.doSomeInvokedynamic();
	}
}