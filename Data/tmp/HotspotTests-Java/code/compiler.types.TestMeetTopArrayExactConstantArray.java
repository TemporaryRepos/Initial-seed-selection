public class TestMeetTopArrayExactConstantArray {
	static class A {}

	static class B {}

	static class C extends compiler.types.TestMeetTopArrayExactConstantArray.A {}

	static class D extends compiler.types.TestMeetTopArrayExactConstantArray.C {}

	static final compiler.types.TestMeetTopArrayExactConstantArray.B[] b = new compiler.types.TestMeetTopArrayExactConstantArray.B[10];

	static void m0(java.lang.Object[] o) {
		if (o.getClass() == java.lang.Object[].class) {
		}
	}

	static void m1(java.lang.Object[] o, boolean cond) {
		if (cond) {
			o = compiler.types.TestMeetTopArrayExactConstantArray.b;
		}
		compiler.types.TestMeetTopArrayExactConstantArray.m0(o);
	}

	static void m2(java.lang.Object[] o, boolean cond1, boolean cond2) {
		if (cond1) {
			compiler.types.TestMeetTopArrayExactConstantArray.m1(o, cond2);
		}
	}

	static void m3(compiler.types.TestMeetTopArrayExactConstantArray.C[] o, boolean cond1, boolean cond2, boolean cond3) {
		if (cond1) {
			compiler.types.TestMeetTopArrayExactConstantArray.m2(o, cond2, cond3);
		}
	}

	public static void main(java.lang.String[] args) {
		compiler.types.TestMeetTopArrayExactConstantArray.A[] a = new compiler.types.TestMeetTopArrayExactConstantArray.A[10];
		compiler.types.TestMeetTopArrayExactConstantArray.D[] d = new compiler.types.TestMeetTopArrayExactConstantArray.D[10];
		java.lang.Object[] o = new java.lang.Object[10];
		for (int i = 0; i < 5000; i++) {
			compiler.types.TestMeetTopArrayExactConstantArray.m0(o);
			compiler.types.TestMeetTopArrayExactConstantArray.m2(a, true, (i % 2) == 0);
			compiler.types.TestMeetTopArrayExactConstantArray.m3(d, true, false, (i % 2) == 0);
		}
		compiler.types.TestMeetTopArrayExactConstantArray.C[] c = new compiler.types.TestMeetTopArrayExactConstantArray.C[10];
		for (int i = 0; i < 20000; i++) {
			compiler.types.TestMeetTopArrayExactConstantArray.m3(c, true, false, (i % 2) == 0);
		}
		compiler.types.TestMeetTopArrayExactConstantArray.m3(c, true, true, false);
		compiler.types.TestMeetTopArrayExactConstantArray.m3(c, true, true, false);
		compiler.types.TestMeetTopArrayExactConstantArray.m3(c, true, true, false);
		compiler.types.TestMeetTopArrayExactConstantArray.m3(c, true, true, false);
		for (int i = 0; i < 20000; i++) {
			compiler.types.TestMeetTopArrayExactConstantArray.m3(c, true, false, (i % 2) == 0);
		}
		java.lang.System.out.println("TEST PASSED");
	}
}