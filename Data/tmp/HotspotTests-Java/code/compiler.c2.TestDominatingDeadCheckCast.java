public class TestDominatingDeadCheckCast {
	static class A {
		int f;
	}

	static class B extends compiler.c2.TestDominatingDeadCheckCast.A {}

	static compiler.c2.TestDominatingDeadCheckCast.A not_inlined() {
		return new compiler.c2.TestDominatingDeadCheckCast.A();
	}

	static void inlined(compiler.c2.TestDominatingDeadCheckCast.A param) {
		param.f = 42;
	}

	static compiler.c2.TestDominatingDeadCheckCast.A field;

	static void test(boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5) {
		compiler.c2.TestDominatingDeadCheckCast.field = compiler.c2.TestDominatingDeadCheckCast.not_inlined();
		compiler.c2.TestDominatingDeadCheckCast.inlined(compiler.c2.TestDominatingDeadCheckCast.field);
		if (flag1) {
			if (flag2) {
				if (flag3) {
					compiler.c2.TestDominatingDeadCheckCast.inlined(compiler.c2.TestDominatingDeadCheckCast.field);
					if (flag4) {
						if (flag5) {
							compiler.c2.TestDominatingDeadCheckCast.inlined(compiler.c2.TestDominatingDeadCheckCast.field);
						}
					}
				}
			}
		}
	}

	public static void main(java.lang.String[] args) {
		compiler.c2.TestDominatingDeadCheckCast.field = new compiler.c2.TestDominatingDeadCheckCast.A();
		for (int i = 0; i < 20000; i++) {
			compiler.c2.TestDominatingDeadCheckCast.test(true, true, true, true, true);
		}
	}
}