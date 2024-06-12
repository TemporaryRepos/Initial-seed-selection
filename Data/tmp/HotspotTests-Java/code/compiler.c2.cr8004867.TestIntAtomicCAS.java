public class TestIntAtomicCAS {
	private static final int ARRLEN = 97;

	private static final int ITERS = 11000;

	private static final int OFFSET = 3;

	private static final int SCALE = 2;

	private static final int ALIGN_OFF = 8;

	private static final int UNALIGN_OFF = 5;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Testing Integer array atomic CAS operations");
		int errn = compiler.c2.cr8004867.TestIntAtomicCAS.test(false);
		if (errn > 0) {
			java.lang.System.err.println(("FAILED: " + errn) + " errors");
			java.lang.System.exit(97);
		}
		java.lang.System.out.println("PASSED");
	}

	static int test(boolean test_only) {
		java.util.concurrent.atomic.AtomicIntegerArray a1 = new java.util.concurrent.atomic.AtomicIntegerArray(compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN);
		java.util.concurrent.atomic.AtomicIntegerArray a2 = new java.util.concurrent.atomic.AtomicIntegerArray(compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN);
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
			a1.set(i, -1);
			a2.set(i, -1);
		}
		java.lang.System.out.println("Warmup");
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci(a1);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi(a2, 123, -1);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi(a1, a2, 123, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_neg(a1, 123);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_neg(a2, 123, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_neg(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_neg(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_neg(a1, a2, 123, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_oppos(a1, 123);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_oppos(a2, 123, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_oppos(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_oppos(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_oppos(a1, a2, 123, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_off(a1, 123);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_off(a2, 123, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_off(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_off(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_off(a1, a2, 123, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_inv(a1, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, 123);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_inv(a2, 123, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_inv(a1, a2, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_inv(a1, a2, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_inv(a1, a2, 123, 103, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_scl(a1, 123);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_scl(a2, 123, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_scl(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_scl(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_scl(a1, a2, 123, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_alndst(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_alnsrc(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_aln(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_aln(a1, a2, 123, 103);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_unalndst(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_unalnsrc(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_unaln(a1, a2);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_unaln(a1, a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
			a1.set(i, -1);
			a2.set(i, -1);
		}
		java.lang.System.out.println("Verification");
		int errn = 0;
		{
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci(a1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_ci: a1", i, a1.get(i), -123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi(a2, 123, -1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_vi: a2", i, a2.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp: a1", i, a1.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci: a1", i, a1.get(i), -123);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci: a2", i, a2.get(i), -103);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi(a1, a2, 123, 103);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi: a1", i, a1.get(i), 123);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi: a2", i, a2.get(i), 103);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_neg(a1, -1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_ci_neg: a1", i, a1.get(i), -123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_neg(a2, 123, -1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_vi_neg: a2", i, a2.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_neg(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_neg: a1", i, a1.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_neg(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_neg: a1", i, a1.get(i), -123);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_neg: a2", i, a2.get(i), -103);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_neg(a1, a2, 123, 103);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_neg: a1", i, a1.get(i), 123);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_neg: a2", i, a2.get(i), 103);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_oppos(a1, -1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_ci_oppos: a1", i, a1.get(i), -123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_oppos(a2, 123, -1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_vi_oppos: a2", i, a2.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_oppos(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_oppos: a1", i, a1.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_oppos(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_oppos: a1", i, a1.get(i), -123);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_oppos: a2", i, a2.get(i), -103);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_oppos(a1, a2, 123, 103);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_oppos: a1", i, a1.get(i), 123);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_oppos: a2", i, a2.get(i), 103);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_off(a1, -1);
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_ci_off: a1", i, a1.get(i), -123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_off(a2, 123, -1);
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_vi_off: a2", i, a2.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_off(a1, a2);
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_off: a1", i, a1.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_off(a1, a2);
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_off: a1", i, a1.get(i), -123);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_off: a2", i, a2.get(i), -103);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_off(a1, a2, 123, 103);
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_off: a1", i, a1.get(i), 123);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_off: a2", i, a2.get(i), 103);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_off: a1", i, a1.get(i), -1);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_off: a2", i, a2.get(i), -1);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_inv(a1, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, -1);
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_ci_inv: a1", i, a1.get(i), -123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_inv(a2, 123, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, -1);
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_vi_inv: a2", i, a2.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_inv(a1, a2, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET);
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_inv: a1", i, a1.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_inv(a1, a2, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET);
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_inv: a1", i, a1.get(i), -123);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_inv: a2", i, a2.get(i), -103);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_inv(a1, a2, 123, 103, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET);
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_inv: a1", i, a1.get(i), 123);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_inv: a2", i, a2.get(i), 103);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_inv: a1", i, a1.get(i), -1);
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_inv: a2", i, a2.get(i), -1);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_scl(a1, -1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				int val = ((i % compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) != 0) ? -1 : -123;
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_ci_scl: a1", i, a1.get(i), val);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_scl(a2, 123, -1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				int val = ((i % compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) != 0) ? -1 : 123;
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_vi_scl: a2", i, a2.get(i), val);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_scl(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				int val = ((i % compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) != 0) ? -1 : 123;
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_scl: a1", i, a1.get(i), val);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_scl(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				if ((i % compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) != 0) {
					errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_scl: a1", i, a1.get(i), -1);
				} else if ((i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN) {
					errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_scl: a1", i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, a1.get(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE), -123);
				}
				if ((i % compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) != 0) {
					errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_scl: a2", i, a2.get(i), -1);
				} else if ((i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN) {
					errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_scl: a2", i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, a2.get(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE), -103);
				}
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_scl(a1, a2, 123, 103);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				if ((i % compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) != 0) {
					errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_scl: a1", i, a1.get(i), -1);
				} else if ((i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN) {
					errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_scl: a1", i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, a1.get(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE), 123);
				}
				if ((i % compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) != 0) {
					errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_scl: a2", i, a2.get(i), -1);
				} else if ((i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN) {
					errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_scl: a2", i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, a2.get(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE), 103);
				}
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi(a2, 123, -1);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_alndst(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_alndst: a1", i, a1.get(i), -1);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_alndst: a1", i, a1.get(i), 123);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i++) {
				a1.set(i, 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi(a2, -123, 123);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_alnsrc(a1, a2);
			for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF); i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_alnsrc: a1", i, a1.get(i), -123);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_alnsrc: a1", i, a1.get(i), 123);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_aln(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_aln: a1", i, a1.get(i), -1);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_aln: a1", i, a1.get(i), -123);
			}
			for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF); i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_aln: a2", i, a2.get(i), -103);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_aln: a2", i, a2.get(i), -1);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_aln(a1, a2, 123, 103);
			for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF); i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_aln: a1", i, a1.get(i), 123);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_aln: a1", i, a1.get(i), -1);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_aln: a2", i, a2.get(i), -1);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_aln: a2", i, a2.get(i), 103);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi(a2, 123, -1);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_unalndst(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_unalndst: a1", i, a1.get(i), -1);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_unalndst: a1", i, a1.get(i), 123);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi(a2, -123, 123);
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_unalnsrc(a1, a2);
			for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF); i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_unalnsrc: a1", i, a1.get(i), -123);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_unalnsrc: a1", i, a1.get(i), 123);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_unaln(a1, a2);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_unaln: a1", i, a1.get(i), -1);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_unaln: a1", i, a1.get(i), -123);
			}
			for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF); i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_unaln: a2", i, a2.get(i), -103);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_unaln: a2", i, a2.get(i), -1);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
				a2.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_unaln(a1, a2, 123, 103);
			for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF); i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_unaln: a1", i, a1.get(i), 123);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_unaln: a1", i, a1.get(i), -1);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_unaln: a2", i, a2.get(i), -1);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_unaln: a2", i, a2.get(i), 103);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i++) {
				a1.set(i, i);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_alndst(a1, a1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				int v = i % compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF;
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_alndst_overlap: a1", i, a1.get(i), v);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i++) {
				a1.set(i + compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_alnsrc(a1, a1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_alnsrc_overlap: a1", i, a1.get(i), -1);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				int v = i % compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF;
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_alnsrc_overlap: a1", i, a1.get(i), v);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_aln(a1, a1);
			for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF); i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_aln_overlap: a1", i, a1.get(i), -103);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_aln_overlap: a1", i, a1.get(i), -123);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_aln(a1, a1, 123, 103);
			for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF); i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_aln_overlap: a1", i, a1.get(i), 123);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_aln_overlap: a1", i, a1.get(i), 103);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i++) {
				a1.set(i, i);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_unalndst(a1, a1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				int v = i % compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF;
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_unalndst_overlap: a1", i, a1.get(i), v);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i++) {
				a1.set(i + compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_unalnsrc(a1, a1);
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_unalnsrc_overlap: a1", i, a1.get(i), -1);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				int v = i % compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF;
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_cp_unalnsrc_overlap: a1", i, a1.get(i), v);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_unaln(a1, a1);
			for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF); i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_unaln_overlap: a1", i, a1.get(i), -103);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2ci_unaln_overlap: a1", i, a1.get(i), -123);
			}
			for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				a1.set(i, -1);
			}
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_unaln(a1, a1, 123, 103);
			for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF); i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_unaln_overlap: a1", i, a1.get(i), 123);
			}
			for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
				errn += compiler.c2.cr8004867.TestIntAtomicCAS.verify("test_2vi_unaln_overlap: a1", i, a1.get(i), 103);
			}
		}
		if ((errn > 0) || test_only) {
			return errn;
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i++) {
			a1.set(i, -1);
			a2.set(i, -1);
		}
		java.lang.System.out.println("Time");
		long start;
		long end;
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci(a1);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi(a2, 123, -1);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi(a1, a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_neg(a1, 123);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_neg(a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_neg(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_neg(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_neg(a1, a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_oppos(a1, 123);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_oppos(a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_oppos(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_oppos(a1, a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_off(a1, 123);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_off(a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_off(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_off(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_off(a1, a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_inv(a1, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, 123);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_inv(a2, 123, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_inv(a1, a2, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_inv(a1, a2, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_inv(a1, a2, 123, 103, compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_ci_scl(a1, 123);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_vi_scl(a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_scl(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_scl(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_scl(a1, a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_alndst(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_alnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_aln(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_aln(a1, a2, 123, 103);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_unalndst(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_cp_unalnsrc(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2ci_unaln(a1, a2);
		}
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ITERS; i++) {
			compiler.c2.cr8004867.TestIntAtomicCAS.test_2vi_unaln(a1, a2, 123, 103);
		}
		return errn;
	}

	static void test_ci(java.util.concurrent.atomic.AtomicIntegerArray a) {
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i, -1, -123);
		}
	}

	static void test_vi(java.util.concurrent.atomic.AtomicIntegerArray a, int b, int old) {
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i, old, b);
		}
	}

	static void test_cp(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i, -123, b.get(i));
		}
	}

	static void test_2ci(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i, 123, -123);
			b.compareAndSet(i, 123, -103);
		}
	}

	static void test_2vi(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b, int c, int d) {
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i, -123, c);
			b.compareAndSet(i, -103, d);
		}
	}

	static void test_ci_neg(java.util.concurrent.atomic.AtomicIntegerArray a, int old) {
		for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - 1; i >= 0; i -= 1) {
			a.compareAndSet(i, old, -123);
		}
	}

	static void test_vi_neg(java.util.concurrent.atomic.AtomicIntegerArray a, int b, int old) {
		for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - 1; i >= 0; i -= 1) {
			a.compareAndSet(i, old, b);
		}
	}

	static void test_cp_neg(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - 1; i >= 0; i -= 1) {
			a.compareAndSet(i, -123, b.get(i));
		}
	}

	static void test_2ci_neg(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - 1; i >= 0; i -= 1) {
			a.compareAndSet(i, 123, -123);
			b.compareAndSet(i, 123, -103);
		}
	}

	static void test_2vi_neg(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b, int c, int d) {
		for (int i = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - 1; i >= 0; i -= 1) {
			a.compareAndSet(i, -123, c);
			b.compareAndSet(i, -103, d);
		}
	}

	static void test_ci_oppos(java.util.concurrent.atomic.AtomicIntegerArray a, int old) {
		int limit = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - 1;
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(limit - i, old, -123);
		}
	}

	static void test_vi_oppos(java.util.concurrent.atomic.AtomicIntegerArray a, int b, int old) {
		int limit = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a.compareAndSet(limit - i, old, b);
		}
	}

	static void test_cp_oppos(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		int limit = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - 1;
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i, -123, b.get(limit - i));
		}
	}

	static void test_2ci_oppos(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		int limit = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - 1;
		for (int i = 0; i < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(limit - i, 123, -123);
			b.compareAndSet(i, 123, -103);
		}
	}

	static void test_2vi_oppos(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b, int c, int d) {
		int limit = compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - 1;
		for (int i = limit; i >= 0; i -= 1) {
			a.compareAndSet(i, -123, c);
			b.compareAndSet(limit - i, -103, d);
		}
	}

	static void test_ci_off(java.util.concurrent.atomic.AtomicIntegerArray a, int old) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET); i += 1) {
			a.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, old, -123);
		}
	}

	static void test_vi_off(java.util.concurrent.atomic.AtomicIntegerArray a, int b, int old) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET); i += 1) {
			a.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, old, b);
		}
	}

	static void test_cp_off(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET); i += 1) {
			a.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, -123, b.get(i + compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET));
		}
	}

	static void test_2ci_off(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET); i += 1) {
			a.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, 123, -123);
			b.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, 123, -103);
		}
	}

	static void test_2vi_off(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b, int c, int d) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET); i += 1) {
			a.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, -123, c);
			b.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.OFFSET, -103, d);
		}
	}

	static void test_ci_inv(java.util.concurrent.atomic.AtomicIntegerArray a, int k, int old) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - k); i += 1) {
			a.compareAndSet(i + k, old, -123);
		}
	}

	static void test_vi_inv(java.util.concurrent.atomic.AtomicIntegerArray a, int b, int k, int old) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - k); i += 1) {
			a.compareAndSet(i + k, old, b);
		}
	}

	static void test_cp_inv(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b, int k) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - k); i += 1) {
			a.compareAndSet(i + k, -123, b.get(i + k));
		}
	}

	static void test_2ci_inv(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b, int k) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - k); i += 1) {
			a.compareAndSet(i + k, 123, -123);
			b.compareAndSet(i + k, 123, -103);
		}
	}

	static void test_2vi_inv(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b, int c, int d, int k) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - k); i += 1) {
			a.compareAndSet(i + k, -123, c);
			b.compareAndSet(i + k, -103, d);
		}
	}

	static void test_ci_scl(java.util.concurrent.atomic.AtomicIntegerArray a, int old) {
		for (int i = 0; (i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, old, -123);
		}
	}

	static void test_vi_scl(java.util.concurrent.atomic.AtomicIntegerArray a, int b, int old) {
		for (int i = 0; (i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, old, b);
		}
	}

	static void test_cp_scl(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; (i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, -123, b.get(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE));
		}
	}

	static void test_2ci_scl(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; (i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, 123, -123);
			b.compareAndSet(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, 123, -103);
		}
	}

	static void test_2vi_scl(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b, int c, int d) {
		for (int i = 0; (i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE) < compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN; i += 1) {
			a.compareAndSet(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, -123, c);
			b.compareAndSet(i * compiler.c2.cr8004867.TestIntAtomicCAS.SCALE, -103, d);
		}
	}

	static void test_cp_alndst(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF); i += 1) {
			a.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF, -1, b.get(i));
		}
	}

	static void test_cp_alnsrc(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF); i += 1) {
			a.getAndSet(i, b.get(i + compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF));
		}
	}

	static void test_2ci_aln(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF); i += 1) {
			a.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF, -1, -123);
			b.getAndSet(i, -103);
		}
	}

	static void test_2vi_aln(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b, int c, int d) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF); i += 1) {
			a.getAndSet(i, c);
			b.getAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.ALIGN_OFF, d);
		}
	}

	static void test_cp_unalndst(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF); i += 1) {
			a.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF, -1, b.get(i));
		}
	}

	static void test_cp_unalnsrc(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF); i += 1) {
			a.getAndSet(i, b.get(i + compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF));
		}
	}

	static void test_2ci_unaln(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF); i += 1) {
			a.compareAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF, -1, -123);
			b.getAndSet(i, -103);
		}
	}

	static void test_2vi_unaln(java.util.concurrent.atomic.AtomicIntegerArray a, java.util.concurrent.atomic.AtomicIntegerArray b, int c, int d) {
		for (int i = 0; i < (compiler.c2.cr8004867.TestIntAtomicCAS.ARRLEN - compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF); i += 1) {
			a.getAndSet(i, c);
			b.getAndSet(i + compiler.c2.cr8004867.TestIntAtomicCAS.UNALIGN_OFF, d);
		}
	}

	static int verify(java.lang.String text, int i, int elem, int val) {
		if (elem != val) {
			java.lang.System.err.println((((((text + "[") + i) + "] = ") + elem) + " != ") + val);
			return 1;
		}
		return 0;
	}
}