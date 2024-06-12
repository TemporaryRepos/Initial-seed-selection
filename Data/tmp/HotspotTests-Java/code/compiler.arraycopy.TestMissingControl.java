public class TestMissingControl {
	static int[] m1(int[] a2) {
		int[] a1 = new int[10];
		java.lang.System.arraycopy(a1, 0, a2, 0, 10);
		return a1;
	}

	static class A {}

	static java.lang.Object m2(java.lang.Object[] a2) {
		compiler.arraycopy.TestMissingControl.A[] a1 = new compiler.arraycopy.TestMissingControl.A[10];
		java.lang.System.arraycopy(a1, 0, a2, 0, 10);
		return a1;
	}

	static void test1() {
		int[] a2 = new int[10];
		int[] a3 = new int[5];
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestMissingControl.m1(a2);
		}
		for (int i = 0; i < 10; i++) {
			try {
				compiler.arraycopy.TestMissingControl.m1(a3);
			} catch (java.lang.IndexOutOfBoundsException ioobe) {
			}
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestMissingControl.m1(a2);
		}
		try {
			compiler.arraycopy.TestMissingControl.m1(null);
		} catch (java.lang.NullPointerException npe) {
		}
	}

	static void test2() {
		compiler.arraycopy.TestMissingControl.A[] a2 = new compiler.arraycopy.TestMissingControl.A[10];
		compiler.arraycopy.TestMissingControl.A[] a3 = new compiler.arraycopy.TestMissingControl.A[5];
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestMissingControl.m2(a2);
		}
		for (int i = 0; i < 10; i++) {
			try {
				compiler.arraycopy.TestMissingControl.m2(a3);
			} catch (java.lang.IndexOutOfBoundsException ioobe) {
			}
		}
		for (int i = 0; i < 20000; i++) {
			compiler.arraycopy.TestMissingControl.m2(a2);
		}
		try {
			compiler.arraycopy.TestMissingControl.m2(null);
		} catch (java.lang.NullPointerException npe) {
		}
	}

	public static void main(java.lang.String[] args) {
		compiler.arraycopy.TestMissingControl.test1();
		compiler.arraycopy.TestMissingControl.test2();
	}
}