public class TypeSpeculation {
	interface I {}

	static class A {
		int m() {
			return 1;
		}
	}

	static class B extends compiler.types.TypeSpeculation.A implements compiler.types.TypeSpeculation.I {
		int m() {
			return 2;
		}
	}

	static class C extends compiler.types.TypeSpeculation.B {
		int m() {
			return 3;
		}
	}

	static int test1_invokevirtual(compiler.types.TypeSpeculation.A a) {
		return a.m();
	}

	static int test1_1(compiler.types.TypeSpeculation.A a) {
		return compiler.types.TypeSpeculation.test1_invokevirtual(a);
	}

	static boolean test1() {
		compiler.types.TypeSpeculation.A a = new compiler.types.TypeSpeculation.A();
		compiler.types.TypeSpeculation.B b = new compiler.types.TypeSpeculation.B();
		compiler.types.TypeSpeculation.C c = new compiler.types.TypeSpeculation.C();
		for (int i = 0; i < 5000; i++) {
			compiler.types.TypeSpeculation.test1_invokevirtual(a);
			compiler.types.TypeSpeculation.test1_invokevirtual(b);
			compiler.types.TypeSpeculation.test1_invokevirtual(c);
		}
		for (int i = 0; i < 20000; i++) {
			int res = compiler.types.TypeSpeculation.test1_1(b);
			if (res != b.m()) {
				java.lang.System.out.println("test1 failed with class B");
				return false;
			}
		}
		int res = compiler.types.TypeSpeculation.test1_1(a);
		if (res != a.m()) {
			java.lang.System.out.println("test1 failed with class A");
			return false;
		}
		return true;
	}

	static int test2_invokevirtual(compiler.types.TypeSpeculation.A a) {
		return a.m();
	}

	static int test2_1(compiler.types.TypeSpeculation.A a, boolean t) {
		compiler.types.TypeSpeculation.A aa;
		if (t) {
			aa = ((compiler.types.TypeSpeculation.B) (a));
		} else {
			aa = a;
		}
		return compiler.types.TypeSpeculation.test2_invokevirtual(aa);
	}

	static boolean test2() {
		compiler.types.TypeSpeculation.A a = new compiler.types.TypeSpeculation.A();
		compiler.types.TypeSpeculation.B b = new compiler.types.TypeSpeculation.B();
		compiler.types.TypeSpeculation.C c = new compiler.types.TypeSpeculation.C();
		for (int i = 0; i < 5000; i++) {
			compiler.types.TypeSpeculation.test2_invokevirtual(a);
			compiler.types.TypeSpeculation.test2_invokevirtual(b);
			compiler.types.TypeSpeculation.test2_invokevirtual(c);
		}
		for (int i = 0; i < 20000; i++) {
			int res = compiler.types.TypeSpeculation.test2_1(b, (i % 2) == 0);
			if (res != b.m()) {
				java.lang.System.out.println("test2 failed with class B");
				return false;
			}
		}
		int res = compiler.types.TypeSpeculation.test2_1(a, false);
		if (res != a.m()) {
			java.lang.System.out.println("test2 failed with class A");
			return false;
		}
		return true;
	}

	static int test3_invokevirtual(compiler.types.TypeSpeculation.A a) {
		return a.m();
	}

	static void test3_2(compiler.types.TypeSpeculation.A a) {
	}

	static int test3_1(compiler.types.TypeSpeculation.A a, int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			compiler.types.TypeSpeculation.test3_2(a);
		} else {
			compiler.types.TypeSpeculation.test3_2(a);
		}
		return compiler.types.TypeSpeculation.test3_invokevirtual(a);
	}

	static boolean test3() {
		compiler.types.TypeSpeculation.A a = new compiler.types.TypeSpeculation.A();
		compiler.types.TypeSpeculation.B b = new compiler.types.TypeSpeculation.B();
		compiler.types.TypeSpeculation.C c = new compiler.types.TypeSpeculation.C();
		for (int i = 0; i < 3000; i++) {
			compiler.types.TypeSpeculation.test3_invokevirtual(a);
			compiler.types.TypeSpeculation.test3_invokevirtual(b);
			compiler.types.TypeSpeculation.test3_invokevirtual(c);
			compiler.types.TypeSpeculation.test3_1(a, 0);
			compiler.types.TypeSpeculation.test3_1(b, 0);
		}
		for (int i = 0; i < 20000; i++) {
			int res = compiler.types.TypeSpeculation.test3_1(b, (i % 2) + 1);
			if (res != b.m()) {
				java.lang.System.out.println("test3 failed with class B");
				return false;
			}
		}
		int res = compiler.types.TypeSpeculation.test3_1(a, 1);
		if (res != a.m()) {
			java.lang.System.out.println("test3 failed with class A");
			return false;
		}
		return true;
	}

	static int test4_invokevirtual(compiler.types.TypeSpeculation.A a) {
		return a.m();
	}

	static void test4_2(compiler.types.TypeSpeculation.A a) {
	}

	static int test4_1(compiler.types.TypeSpeculation.A a, boolean b) {
		if (b) {
			compiler.types.TypeSpeculation.test4_2(a);
		} else {
			compiler.types.TypeSpeculation.test4_2(a);
		}
		return compiler.types.TypeSpeculation.test4_invokevirtual(a);
	}

	static boolean test4() {
		compiler.types.TypeSpeculation.A a = new compiler.types.TypeSpeculation.A();
		compiler.types.TypeSpeculation.B b = new compiler.types.TypeSpeculation.B();
		compiler.types.TypeSpeculation.C c = new compiler.types.TypeSpeculation.C();
		for (int i = 0; i < 3000; i++) {
			compiler.types.TypeSpeculation.test4_invokevirtual(a);
			compiler.types.TypeSpeculation.test4_invokevirtual(b);
			compiler.types.TypeSpeculation.test4_invokevirtual(c);
		}
		for (int i = 0; i < 20000; i++) {
			if ((i % 2) == 0) {
				int res = compiler.types.TypeSpeculation.test4_1(a, true);
				if (res != a.m()) {
					java.lang.System.out.println("test4 failed with class A");
					return false;
				}
			} else {
				int res = compiler.types.TypeSpeculation.test4_1(b, false);
				if (res != b.m()) {
					java.lang.System.out.println("test4 failed with class B");
					return false;
				}
			}
		}
		return true;
	}

	static int test5_invokevirtual(compiler.types.TypeSpeculation.A a) {
		return a.m();
	}

	static void test5_2(compiler.types.TypeSpeculation.A a) {
	}

	static int test5_1(compiler.types.TypeSpeculation.A a, boolean b) {
		if (b) {
			compiler.types.TypeSpeculation.test5_2(a);
		} else {
			compiler.types.TypeSpeculation.A aa = ((compiler.types.TypeSpeculation.B) (a));
		}
		return compiler.types.TypeSpeculation.test5_invokevirtual(a);
	}

	static boolean test5() {
		compiler.types.TypeSpeculation.A a = new compiler.types.TypeSpeculation.A();
		compiler.types.TypeSpeculation.B b = new compiler.types.TypeSpeculation.B();
		compiler.types.TypeSpeculation.C c = new compiler.types.TypeSpeculation.C();
		for (int i = 0; i < 3000; i++) {
			compiler.types.TypeSpeculation.test5_invokevirtual(a);
			compiler.types.TypeSpeculation.test5_invokevirtual(b);
			compiler.types.TypeSpeculation.test5_invokevirtual(c);
		}
		for (int i = 0; i < 20000; i++) {
			if ((i % 2) == 0) {
				int res = compiler.types.TypeSpeculation.test5_1(a, true);
				if (res != a.m()) {
					java.lang.System.out.println("test5 failed with class A");
					return false;
				}
			} else {
				int res = compiler.types.TypeSpeculation.test5_1(b, false);
				if (res != b.m()) {
					java.lang.System.out.println("test5 failed with class B");
					return false;
				}
			}
		}
		return true;
	}

	static void test6_2(java.lang.Object o) {
	}

	static java.lang.Object test6_1(java.lang.Object o, boolean b) {
		if (b) {
			compiler.types.TypeSpeculation.test6_2(o);
		} else {
			compiler.types.TypeSpeculation.test6_2(o);
		}
		return o;
	}

	static boolean test6() {
		compiler.types.TypeSpeculation.A a = new compiler.types.TypeSpeculation.A();
		compiler.types.TypeSpeculation.A[] aa = new compiler.types.TypeSpeculation.A[10];
		for (int i = 0; i < 20000; i++) {
			if ((i % 2) == 0) {
				compiler.types.TypeSpeculation.test6_1(a, true);
			} else {
				compiler.types.TypeSpeculation.test6_1(aa, false);
			}
		}
		return true;
	}

	static void test7_2(java.lang.Object o) {
	}

	static java.lang.Object test7_1(java.lang.Object o, boolean b) {
		if (b) {
			compiler.types.TypeSpeculation.test7_2(o);
		} else {
			java.lang.Object oo = ((compiler.types.TypeSpeculation.A[]) (o));
		}
		return o;
	}

	static boolean test7() {
		compiler.types.TypeSpeculation.A a = new compiler.types.TypeSpeculation.A();
		compiler.types.TypeSpeculation.A[] aa = new compiler.types.TypeSpeculation.A[10];
		for (int i = 0; i < 20000; i++) {
			if ((i % 2) == 0) {
				compiler.types.TypeSpeculation.test7_1(a, true);
			} else {
				compiler.types.TypeSpeculation.test7_1(aa, false);
			}
		}
		return true;
	}

	static void test8_2(java.lang.Object o) {
	}

	static compiler.types.TypeSpeculation.I test8_1(java.lang.Object o) {
		compiler.types.TypeSpeculation.test8_2(o);
		return ((compiler.types.TypeSpeculation.I) (o));
	}

	static boolean test8() {
		compiler.types.TypeSpeculation.A a = new compiler.types.TypeSpeculation.A();
		compiler.types.TypeSpeculation.B b = new compiler.types.TypeSpeculation.B();
		compiler.types.TypeSpeculation.C c = new compiler.types.TypeSpeculation.C();
		for (int i = 0; i < 20000; i++) {
			compiler.types.TypeSpeculation.test8_1(b);
		}
		return true;
	}

	static void test9_2(java.lang.Object o) {
	}

	static java.lang.Object test9_1(java.lang.Object o, boolean b) {
		java.lang.Object oo;
		if (b) {
			compiler.types.TypeSpeculation.test9_2(o);
			oo = o;
		} else {
			oo = "some string";
		}
		return oo;
	}

	static boolean test9() {
		compiler.types.TypeSpeculation.A a = new compiler.types.TypeSpeculation.A();
		for (int i = 0; i < 20000; i++) {
			if ((i % 2) == 0) {
				compiler.types.TypeSpeculation.test9_1(a, true);
			} else {
				compiler.types.TypeSpeculation.test9_1(a, false);
			}
		}
		return true;
	}

	static void test10_4(java.lang.Object o) {
	}

	static void test10_3(java.lang.Object o, boolean b) {
		if (b) {
			compiler.types.TypeSpeculation.test10_4(o);
		}
	}

	static void test10_2(java.lang.Object o, boolean b1, boolean b2) {
		if (b1) {
			compiler.types.TypeSpeculation.test10_3(o, b2);
		}
	}

	static void test10_1(compiler.types.TypeSpeculation.B[] b, boolean b1, boolean b2) {
		compiler.types.TypeSpeculation.test10_2(b, b1, b2);
	}

	static boolean test10() {
		java.lang.Object o = new java.lang.Object();
		compiler.types.TypeSpeculation.A[] a = new compiler.types.TypeSpeculation.A[10];
		compiler.types.TypeSpeculation.B[] b = new compiler.types.TypeSpeculation.B[10];
		compiler.types.TypeSpeculation.B[] c = new compiler.types.TypeSpeculation.C[10];
		for (int i = 0; i < 20000; i++) {
			compiler.types.TypeSpeculation.test10_1(b, false, false);
			compiler.types.TypeSpeculation.test10_1(c, false, false);
			compiler.types.TypeSpeculation.test10_2(a, true, false);
			compiler.types.TypeSpeculation.test10_3(o, true);
		}
		return true;
	}

	static void test11_3(java.lang.Object o) {
	}

	static void test11_2(java.lang.Object o, boolean b) {
		if (b) {
			compiler.types.TypeSpeculation.test11_3(o);
		}
	}

	static void test11_1(compiler.types.TypeSpeculation.B[] b, boolean bb) {
		compiler.types.TypeSpeculation.test11_2(b, bb);
	}

	static boolean test11() {
		java.lang.Object o = new java.lang.Object();
		compiler.types.TypeSpeculation.B[] b = new compiler.types.TypeSpeculation.B[10];
		compiler.types.TypeSpeculation.B[] c = new compiler.types.TypeSpeculation.C[10];
		for (int i = 0; i < 20000; i++) {
			compiler.types.TypeSpeculation.test11_1(b, false);
			compiler.types.TypeSpeculation.test11_1(c, false);
			compiler.types.TypeSpeculation.test11_2(o, true);
		}
		return true;
	}

	static void test12_3(java.lang.Object o) {
	}

	static void test12_2(java.lang.Object o, boolean b) {
		if (b) {
			compiler.types.TypeSpeculation.test12_3(o);
		}
	}

	static void test12_1(compiler.types.TypeSpeculation.I i, boolean b) {
		compiler.types.TypeSpeculation.test12_2(i, b);
	}

	static boolean test12() {
		java.lang.Object o = new java.lang.Object();
		compiler.types.TypeSpeculation.B b = new compiler.types.TypeSpeculation.B();
		compiler.types.TypeSpeculation.C c = new compiler.types.TypeSpeculation.C();
		for (int i = 0; i < 20000; i++) {
			compiler.types.TypeSpeculation.test12_1(b, false);
			compiler.types.TypeSpeculation.test12_1(c, false);
			compiler.types.TypeSpeculation.test12_2(o, true);
		}
		return true;
	}

	static java.lang.Object test13_3(java.lang.Object o, boolean b) {
		java.lang.Object oo;
		if (b) {
			oo = o;
		} else {
			oo = new compiler.types.TypeSpeculation.A[10];
		}
		return oo;
	}

	static void test13_2(java.lang.Object o, boolean b1, boolean b2) {
		if (b1) {
			compiler.types.TypeSpeculation.test13_3(o, b2);
		}
	}

	static void test13_1(compiler.types.TypeSpeculation.B[] b, boolean b1, boolean b2) {
		compiler.types.TypeSpeculation.test13_2(b, b1, b2);
	}

	static boolean test13() {
		compiler.types.TypeSpeculation.A[] a = new compiler.types.TypeSpeculation.A[10];
		compiler.types.TypeSpeculation.B[] b = new compiler.types.TypeSpeculation.B[10];
		compiler.types.TypeSpeculation.B[] c = new compiler.types.TypeSpeculation.C[10];
		for (int i = 0; i < 20000; i++) {
			compiler.types.TypeSpeculation.test13_1(b, false, false);
			compiler.types.TypeSpeculation.test13_1(c, false, false);
			compiler.types.TypeSpeculation.test13_2(a, true, (i % 2) == 0);
		}
		return true;
	}

	public static void main(java.lang.String[] args) {
		boolean success = true;
		success = compiler.types.TypeSpeculation.test1() && success;
		success = compiler.types.TypeSpeculation.test2() && success;
		success = compiler.types.TypeSpeculation.test3() && success;
		success = compiler.types.TypeSpeculation.test4() && success;
		success = compiler.types.TypeSpeculation.test5() && success;
		success = compiler.types.TypeSpeculation.test6() && success;
		success = compiler.types.TypeSpeculation.test7() && success;
		success = compiler.types.TypeSpeculation.test8() && success;
		success = compiler.types.TypeSpeculation.test9() && success;
		success = compiler.types.TypeSpeculation.test10() && success;
		success = compiler.types.TypeSpeculation.test11() && success;
		success = compiler.types.TypeSpeculation.test12() && success;
		success = compiler.types.TypeSpeculation.test13() && success;
		if (success) {
			java.lang.System.out.println("TEST PASSED");
		} else {
			throw new java.lang.RuntimeException("TEST FAILED: erroneous bound check elimination");
		}
	}
}