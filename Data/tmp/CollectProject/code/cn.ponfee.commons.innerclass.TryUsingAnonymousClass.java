public class TryUsingAnonymousClass {
	public static void main(java.lang.String[] args) {
		new cn.ponfee.commons.innerclass.TryUsingAnonymousClass().useMyInterface();
	}

	public void useMyInterface() {
		final java.lang.Integer number = 123;
		java.lang.System.out.println(number);
		cn.ponfee.commons.innerclass.MyInterface myInterface = new cn.ponfee.commons.innerclass.MyInterface() {
			@java.lang.Override
			public void doSomething() {
				java.lang.System.out.println(number);
			}
		};
		myInterface.doSomething();
		java.lang.System.out.println(number);
	}
}