public class C1NullCheckOfNullStore {
	private static class Foo {
		java.lang.Object bar;
	}

	private static void test(compiler.codegen.C1NullCheckOfNullStore.Foo x) {
		x.bar = null;
	}

	public static void main(java.lang.String[] args) {
		compiler.codegen.C1NullCheckOfNullStore.Foo x = new compiler.codegen.C1NullCheckOfNullStore.Foo();
		for (int i = 0; i < 10000; i++) {
			compiler.codegen.C1NullCheckOfNullStore.test(x);
		}
		boolean gotNPE = false;
		try {
			for (int i = 0; i < 10000; i++) {
				compiler.codegen.C1NullCheckOfNullStore.test(null);
			}
		} catch (java.lang.NullPointerException e) {
			gotNPE = true;
		}
		if (!gotNPE) {
			throw new java.lang.Error("Expecting a NullPointerException");
		}
	}
}