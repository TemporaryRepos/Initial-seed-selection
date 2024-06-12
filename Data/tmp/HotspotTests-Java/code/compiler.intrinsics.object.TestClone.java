public class TestClone implements java.lang.Cloneable {
	static class A extends compiler.intrinsics.object.TestClone {}

	static class B extends compiler.intrinsics.object.TestClone {
		public compiler.intrinsics.object.TestClone.B clone() {
			return ((compiler.intrinsics.object.TestClone.B) (compiler.intrinsics.object.TestClone.b));
		}
	}

	static class C extends compiler.intrinsics.object.TestClone {
		public compiler.intrinsics.object.TestClone.C clone() {
			return ((compiler.intrinsics.object.TestClone.C) (compiler.intrinsics.object.TestClone.c));
		}
	}

	static class D extends compiler.intrinsics.object.TestClone {
		public compiler.intrinsics.object.TestClone.D clone() {
			return ((compiler.intrinsics.object.TestClone.D) (compiler.intrinsics.object.TestClone.d));
		}
	}

	static compiler.intrinsics.object.TestClone a = new compiler.intrinsics.object.TestClone.A();

	static compiler.intrinsics.object.TestClone b = new compiler.intrinsics.object.TestClone.B();

	static compiler.intrinsics.object.TestClone c = new compiler.intrinsics.object.TestClone.C();

	static compiler.intrinsics.object.TestClone d = new compiler.intrinsics.object.TestClone.D();

	public static java.lang.Object f(compiler.intrinsics.object.TestClone o) throws java.lang.CloneNotSupportedException {
		return o.clone();
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		compiler.intrinsics.object.TestClone[] params1 = new compiler.intrinsics.object.TestClone[]{ compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.a, compiler.intrinsics.object.TestClone.b, compiler.intrinsics.object.TestClone.c, compiler.intrinsics.object.TestClone.d };
		for (int i = 0; i < 15000; i++) {
			compiler.intrinsics.object.TestClone.f(params1[i % params1.length]);
		}
		jdk.test.lib.Asserts.assertTrue(compiler.intrinsics.object.TestClone.f(compiler.intrinsics.object.TestClone.a) != compiler.intrinsics.object.TestClone.a);
		jdk.test.lib.Asserts.assertTrue(compiler.intrinsics.object.TestClone.f(compiler.intrinsics.object.TestClone.b) == compiler.intrinsics.object.TestClone.b);
		jdk.test.lib.Asserts.assertTrue(compiler.intrinsics.object.TestClone.f(compiler.intrinsics.object.TestClone.c) == compiler.intrinsics.object.TestClone.c);
		jdk.test.lib.Asserts.assertTrue(compiler.intrinsics.object.TestClone.f(compiler.intrinsics.object.TestClone.d) == compiler.intrinsics.object.TestClone.d);
		try {
			compiler.intrinsics.object.TestClone.f(null);
			throw new java.lang.AssertionError("");
		} catch (java.lang.NullPointerException e) {
		}
		java.lang.System.out.println("TEST PASSED");
	}
}