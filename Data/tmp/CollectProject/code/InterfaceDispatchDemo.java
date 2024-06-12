public class InterfaceDispatchDemo {
	interface Greeter {
		public abstract void sayHello();
	}

	static class English implements InterfaceDispatchDemo.Greeter {
		@java.lang.Override
		public void sayHello() {
			java.lang.System.out.println("Hello!");
		}
	}

	static class Spanish implements InterfaceDispatchDemo.Greeter {
		@java.lang.Override
		public void sayHello() {
			java.lang.System.out.println("Hola!");
		}
	}

	public static void main(java.lang.String[] args) {
		final InterfaceDispatchDemo.Greeter[] greeters = new InterfaceDispatchDemo.Greeter[]{ new InterfaceDispatchDemo.English(), new InterfaceDispatchDemo.Spanish(), new InterfaceDispatchDemo.English(), new InterfaceDispatchDemo.Spanish(), new InterfaceDispatchDemo.Spanish(), new InterfaceDispatchDemo.English(), new InterfaceDispatchDemo.English() };
		for (InterfaceDispatchDemo.Greeter greeter : greeters) {
			greeter.sayHello();
		}
	}
}