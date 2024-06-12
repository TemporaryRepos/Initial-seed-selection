public class Ambiguous {
	public static void main(java.lang.String... args) {
		new lambdasinaction.chap9.Ambiguous.C().hello();
	}

	static interface A {
		public default void hello() {
			java.lang.System.out.println("Hello from A");
		}
	}

	static interface B {
		public default void hello() {
			java.lang.System.out.println("Hello from B");
		}
	}

	static class C implements lambdasinaction.chap9.Ambiguous.B , lambdasinaction.chap9.Ambiguous.A {
		public void hello() {
			lambdasinaction.chap9.Ambiguous.A.super.hello();
		}
	}
}