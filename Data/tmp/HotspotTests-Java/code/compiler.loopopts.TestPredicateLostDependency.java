public class TestPredicateLostDependency {
	static class A {
		int i;
	}

	static class B extends compiler.loopopts.TestPredicateLostDependency.A {}

	static boolean crash = false;

	static boolean m2() {
		return compiler.loopopts.TestPredicateLostDependency.crash;
	}

	static int m3(float[] arr) {
		return 0;
	}

	static float m1(compiler.loopopts.TestPredicateLostDependency.A aa) {
		float res = 0;
		float[] arr = new float[10];
		for (int i = 0; i < 10; i++) {
			if (compiler.loopopts.TestPredicateLostDependency.m2()) {
				arr = null;
			}
			compiler.loopopts.TestPredicateLostDependency.m3(arr);
			int j = arr.length;
			int k = 0;
			for (k = 9; k < j; k++) {
			}
			if (k == 10) {
				if (aa instanceof compiler.loopopts.TestPredicateLostDependency.B) {
				}
			}
			res += arr[0];
			res += arr[1];
		}
		return res;
	}

	public static void main(java.lang.String[] args) {
		compiler.loopopts.TestPredicateLostDependency.A a = new compiler.loopopts.TestPredicateLostDependency.A();
		compiler.loopopts.TestPredicateLostDependency.B b = new compiler.loopopts.TestPredicateLostDependency.B();
		for (int i = 0; i < 20000; i++) {
			compiler.loopopts.TestPredicateLostDependency.m1(a);
		}
		compiler.loopopts.TestPredicateLostDependency.crash = true;
		try {
			compiler.loopopts.TestPredicateLostDependency.m1(a);
		} catch (java.lang.NullPointerException npe) {
		}
	}
}