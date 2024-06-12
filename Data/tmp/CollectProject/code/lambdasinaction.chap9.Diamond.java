public class Diamond {
	public static void main(java.lang.String... args) {
		new lambdasinaction.chap9.Diamond.D().hello();
	}

	static interface A {
		public default void hello() {
			java.lang.System.out.println("Hello from A");
		}
	}

	static interface B extends lambdasinaction.chap9.Diamond.A {}

	static interface C extends lambdasinaction.chap9.Diamond.A {}

	static class D implements lambdasinaction.chap9.Diamond.B , lambdasinaction.chap9.Diamond.C {}
}