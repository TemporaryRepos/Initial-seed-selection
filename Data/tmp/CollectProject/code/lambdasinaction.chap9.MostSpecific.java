public class MostSpecific {
	public static void main(java.lang.String... args) {
		new lambdasinaction.chap9.MostSpecific.C().hello();
		new lambdasinaction.chap9.MostSpecific.E().hello();
		new lambdasinaction.chap9.MostSpecific.G().hello();
	}

	static interface A {
		public default void hello() {
			java.lang.System.out.println("Hello from A");
		}
	}

	static interface B extends lambdasinaction.chap9.MostSpecific.A {
		public default void hello() {
			java.lang.System.out.println("Hello from B");
		}
	}

	static class C implements lambdasinaction.chap9.MostSpecific.B , lambdasinaction.chap9.MostSpecific.A {}

	static class D implements lambdasinaction.chap9.MostSpecific.A {}

	static class E extends lambdasinaction.chap9.MostSpecific.D implements lambdasinaction.chap9.MostSpecific.B , lambdasinaction.chap9.MostSpecific.A {}

	static class F implements lambdasinaction.chap9.MostSpecific.B , lambdasinaction.chap9.MostSpecific.A {
		public void hello() {
			java.lang.System.out.println("Hello from F");
		}
	}

	static class G extends lambdasinaction.chap9.MostSpecific.F implements lambdasinaction.chap9.MostSpecific.B , lambdasinaction.chap9.MostSpecific.A {}
}