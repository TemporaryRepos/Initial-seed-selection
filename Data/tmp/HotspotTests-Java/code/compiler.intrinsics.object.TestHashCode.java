public class TestHashCode {
	static class A {
		int i;
	}

	static class B extends compiler.intrinsics.object.TestHashCode.A {}

	static boolean crash = false;

	static compiler.intrinsics.object.TestHashCode.A m2() {
		if (compiler.intrinsics.object.TestHashCode.crash) {
			return null;
		}
		return new compiler.intrinsics.object.TestHashCode.A();
	}

	static int m1(compiler.intrinsics.object.TestHashCode.A aa) {
		int res = 0;
		for (int i = 0; i < 10; i++) {
			compiler.intrinsics.object.TestHashCode.A a = compiler.intrinsics.object.TestHashCode.m2();
			int j = a.i;
			if (aa instanceof compiler.intrinsics.object.TestHashCode.B) {
			}
			res += 10000;
		}
		return res;
	}

	public static void main(java.lang.String[] args) {
		compiler.intrinsics.object.TestHashCode.A a = new compiler.intrinsics.object.TestHashCode.A();
		for (int i = 0; i < 20000; i++) {
			compiler.intrinsics.object.TestHashCode.m1(a);
		}
		compiler.intrinsics.object.TestHashCode.crash = true;
		try {
			compiler.intrinsics.object.TestHashCode.m1(a);
		} catch (java.lang.NullPointerException e) {
			java.lang.System.out.println("Test passed");
		}
	}
}