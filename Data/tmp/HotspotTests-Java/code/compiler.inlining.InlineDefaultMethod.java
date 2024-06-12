public class InlineDefaultMethod {
	interface InterfaceWithDefaultMethod0 {
		public default int defaultMethod() {
			return 1;
		}
	}

	interface InterfaceWithDefaultMethod1 extends compiler.inlining.InlineDefaultMethod.InterfaceWithDefaultMethod0 {}

	abstract static class Subtype implements compiler.inlining.InlineDefaultMethod.InterfaceWithDefaultMethod1 {}

	static class Decoy extends compiler.inlining.InlineDefaultMethod.Subtype {
		public int defaultMethod() {
			return 2;
		}
	}

	static class Instance extends compiler.inlining.InlineDefaultMethod.Subtype {}

	public static int test(compiler.inlining.InlineDefaultMethod.InterfaceWithDefaultMethod1 x) {
		return x.defaultMethod();
	}

	public static void main(java.lang.String[] args) {
		compiler.inlining.InlineDefaultMethod.InterfaceWithDefaultMethod1 a = new compiler.inlining.InlineDefaultMethod.Decoy();
		compiler.inlining.InlineDefaultMethod.InterfaceWithDefaultMethod1 b = new compiler.inlining.InlineDefaultMethod.Instance();
		if ((compiler.inlining.InlineDefaultMethod.test(a) != 2) || (compiler.inlining.InlineDefaultMethod.test(b) != 1)) {
			java.lang.System.err.println("FAILED");
			java.lang.System.exit(97);
		}
		java.lang.System.err.println("PASSED");
	}
}