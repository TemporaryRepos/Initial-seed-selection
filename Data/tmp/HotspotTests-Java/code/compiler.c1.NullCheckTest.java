public class NullCheckTest {
	static class A {
		int f;

		public final void inlined(compiler.c1.NullCheckTest.A a) {
			compiler.c1.NullCheckTest.B b = ((compiler.c1.NullCheckTest.B) (a));
		}
	}

	static class B extends compiler.c1.NullCheckTest.A {}

	private static void test(compiler.c1.NullCheckTest.A a1, compiler.c1.NullCheckTest.A a2) {
		a1.inlined(a2);
		int x = a1.f;
	}

	public static void main(java.lang.String[] args) {
		new compiler.c1.NullCheckTest.B();
		try {
			compiler.c1.NullCheckTest.test(null, new compiler.c1.NullCheckTest.A());
			throw new java.lang.InternalError("FAILURE: no exception");
		} catch (java.lang.NullPointerException ex) {
			java.lang.System.out.println("CORRECT: NullPointerException");
		} catch (java.lang.ClassCastException ex) {
			java.lang.System.out.println("FAILURE: ClassCastException");
			throw ex;
		}
	}
}