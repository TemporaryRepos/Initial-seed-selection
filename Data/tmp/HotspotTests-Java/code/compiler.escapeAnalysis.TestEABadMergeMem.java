public class TestEABadMergeMem {
	static class Box {
		int i;
	}

	static void m_notinlined() {
	}

	static float dummy1;

	static float dummy2;

	static int test(compiler.escapeAnalysis.TestEABadMergeMem.Box a, compiler.escapeAnalysis.TestEABadMergeMem.Box c, int i, int j, int k, boolean flag1, boolean flag2) {
		compiler.escapeAnalysis.TestEABadMergeMem.Box b = new compiler.escapeAnalysis.TestEABadMergeMem.Box();
		a.i = i;
		b.i = j;
		c.i = k;
		compiler.escapeAnalysis.TestEABadMergeMem.m_notinlined();
		boolean flag3 = false;
		if (flag1) {
			for (int ii = 0; ii < 100; ii++) {
				if (flag2) {
					compiler.escapeAnalysis.TestEABadMergeMem.dummy1 = ((float) (ii));
				} else {
					compiler.escapeAnalysis.TestEABadMergeMem.dummy2 = ((float) (ii));
				}
			}
			flag3 = true;
		}
		if (flag3) {
			int res = c.i + b.i;
			compiler.escapeAnalysis.TestEABadMergeMem.m_notinlined();
			return res;
		} else {
			return 44 + 43;
		}
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 20000; i++) {
			compiler.escapeAnalysis.TestEABadMergeMem.Box a = new compiler.escapeAnalysis.TestEABadMergeMem.Box();
			compiler.escapeAnalysis.TestEABadMergeMem.Box c = new compiler.escapeAnalysis.TestEABadMergeMem.Box();
			int res = compiler.escapeAnalysis.TestEABadMergeMem.test(a, c, 42, 43, 44, (i % 2) == 0, (i % 3) == 0);
			if (res != (44 + 43)) {
				throw new java.lang.RuntimeException("Bad result " + res);
			}
		}
	}
}