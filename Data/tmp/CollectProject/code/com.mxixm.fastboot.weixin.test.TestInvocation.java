public class TestInvocation {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				java.lang.System.out.println((("i" + i) + j) + ".app");
			}
		}
		com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObject o = new com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObject();
		com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObjectInterface ob = ((com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObjectInterface) (java.lang.reflect.Proxy.newProxyInstance(com.mxixm.fastboot.weixin.test.TestInvocation.class.getClassLoader(), new java.lang.Class[]{ com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObjectInterface.class }, new com.mxixm.fastboot.weixin.test.TestInvocation.MyInvocation(o))));
		o.set(ob);
		ob.test1();
	}

	public static class MyInvocation implements java.lang.reflect.InvocationHandler {
		public com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObject o;

		public MyInvocation(com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObject o) {
			this.o = o;
		}

		@java.lang.Override
		public java.lang.Object invoke(java.lang.Object proxy, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
			return method.invoke(o, args);
		}
	}

	public static interface InvokedObjectInterface {
		public abstract void test1();

		public abstract void test2();

		public abstract void set(com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObjectInterface o);
	}

	public static class InvokedObject implements com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObjectInterface {
		com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObjectInterface o;

		public InvokedObject() {
		}

		@java.lang.Override
		public void test1() {
			java.lang.System.out.println(1);
			o.test2();
		}

		@java.lang.Override
		public void test2() {
			java.lang.System.out.println(2);
		}

		@java.lang.Override
		public void set(com.mxixm.fastboot.weixin.test.TestInvocation.InvokedObjectInterface o) {
			this.o = o;
		}
	}
}