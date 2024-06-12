public class TestMultiplyLongHiZero {
	private static void check(long leftFactor, long rightFactor, long optimizedProduct, long constantProduct) {
		long normalProduct = leftFactor * rightFactor;
		if ((optimizedProduct != constantProduct) || (normalProduct != constantProduct)) {
			throw new java.lang.RuntimeException((((("Not all three products are equal: " + java.lang.Long.toHexString(normalProduct)) + ", ") + java.lang.Long.toHexString(optimizedProduct)) + ", ") + java.lang.Long.toHexString(constantProduct));
		}
	}

	private static int initInt(java.lang.String[] args, int v) {
		if (args.length > 0) {
			try {
				return java.lang.Integer.valueOf(args[0]);
			} catch (java.lang.NumberFormatException e) {
			}
		}
		return v;
	}

	private static final long mask32 = 0xffffffffL;

	private static void testNormal(int leftFactor, int rightFactor, long constantProduct) {
		compiler.c2.TestMultiplyLongHiZero.check(((long) (leftFactor)), ((long) (rightFactor)), ((long) (leftFactor)) * ((long) (rightFactor)), constantProduct);
	}

	private static void testLeftOptimized(int leftFactor, int rightFactor, long constantProduct) {
		compiler.c2.TestMultiplyLongHiZero.check(leftFactor & compiler.c2.TestMultiplyLongHiZero.mask32, ((long) (rightFactor)), (leftFactor & compiler.c2.TestMultiplyLongHiZero.mask32) * ((long) (rightFactor)), constantProduct);
	}

	private static void testRightOptimized(int leftFactor, int rightFactor, long constantProduct) {
		compiler.c2.TestMultiplyLongHiZero.check(((long) (leftFactor)), rightFactor & compiler.c2.TestMultiplyLongHiZero.mask32, ((long) (leftFactor)) * (rightFactor & compiler.c2.TestMultiplyLongHiZero.mask32), constantProduct);
	}

	private static void testOptimized(int leftFactor, int rightFactor, long constantProduct) {
		compiler.c2.TestMultiplyLongHiZero.check(leftFactor & compiler.c2.TestMultiplyLongHiZero.mask32, rightFactor & compiler.c2.TestMultiplyLongHiZero.mask32, (leftFactor & compiler.c2.TestMultiplyLongHiZero.mask32) * (rightFactor & compiler.c2.TestMultiplyLongHiZero.mask32), constantProduct);
	}

	private static void testLeftOptimized_LoadUI2L(int leftFactor, int rightFactor, long constantProduct, int[] factors) {
		compiler.c2.TestMultiplyLongHiZero.check(leftFactor & compiler.c2.TestMultiplyLongHiZero.mask32, ((long) (rightFactor)), (factors[0] & compiler.c2.TestMultiplyLongHiZero.mask32) * ((long) (rightFactor)), constantProduct);
	}

	private static void testRightOptimized_LoadUI2L(int leftFactor, int rightFactor, long constantProduct, int[] factors) {
		compiler.c2.TestMultiplyLongHiZero.check(((long) (leftFactor)), rightFactor & compiler.c2.TestMultiplyLongHiZero.mask32, ((long) (leftFactor)) * (factors[1] & compiler.c2.TestMultiplyLongHiZero.mask32), constantProduct);
	}

	private static void testOptimized_LoadUI2L(int leftFactor, int rightFactor, long constantProduct, int[] factors) {
		compiler.c2.TestMultiplyLongHiZero.check(leftFactor & compiler.c2.TestMultiplyLongHiZero.mask32, rightFactor & compiler.c2.TestMultiplyLongHiZero.mask32, (factors[0] & compiler.c2.TestMultiplyLongHiZero.mask32) * (factors[1] & compiler.c2.TestMultiplyLongHiZero.mask32), constantProduct);
	}

	private static void test(int leftFactor, int rightFactor, long normalConstantProduct, long leftOptimizedConstantProduct, long rightOptimizedConstantProduct, long optimizedConstantProduct) {
		int[] factors = new int[2];
		factors[0] = leftFactor;
		factors[1] = rightFactor;
		compiler.c2.TestMultiplyLongHiZero.testNormal(leftFactor, rightFactor, normalConstantProduct);
		compiler.c2.TestMultiplyLongHiZero.testLeftOptimized(leftFactor, rightFactor, leftOptimizedConstantProduct);
		compiler.c2.TestMultiplyLongHiZero.testRightOptimized(leftFactor, rightFactor, rightOptimizedConstantProduct);
		compiler.c2.TestMultiplyLongHiZero.testOptimized(leftFactor, rightFactor, optimizedConstantProduct);
		compiler.c2.TestMultiplyLongHiZero.testLeftOptimized_LoadUI2L(leftFactor, rightFactor, leftOptimizedConstantProduct, factors);
		compiler.c2.TestMultiplyLongHiZero.testRightOptimized_LoadUI2L(leftFactor, rightFactor, rightOptimizedConstantProduct, factors);
		compiler.c2.TestMultiplyLongHiZero.testOptimized_LoadUI2L(leftFactor, rightFactor, optimizedConstantProduct, factors);
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 100000; ++i) {
			int i0 = compiler.c2.TestMultiplyLongHiZero.initInt(args, 1);
			int i1 = compiler.c2.TestMultiplyLongHiZero.initInt(args, 3);
			int i2 = compiler.c2.TestMultiplyLongHiZero.initInt(args, -1);
			int i3 = compiler.c2.TestMultiplyLongHiZero.initInt(args, 0x7fffffff);
			compiler.c2.TestMultiplyLongHiZero.test(i0, i1, 3L, 3L, 3L, 3L);
			compiler.c2.TestMultiplyLongHiZero.test(i0, i2, -1L, -1L, 0xffffffffL, 0xffffffffL);
			compiler.c2.TestMultiplyLongHiZero.test(i0, i3, 0x7fffffffL, 0x7fffffffL, 0x7fffffffL, 0x7fffffffL);
			compiler.c2.TestMultiplyLongHiZero.test(i1, i2, -3L, -3L, 0x2fffffffdL, 0x2fffffffdL);
			compiler.c2.TestMultiplyLongHiZero.test(i1, i3, 0x17ffffffdL, 0x17ffffffdL, 0x17ffffffdL, 0x17ffffffdL);
			compiler.c2.TestMultiplyLongHiZero.test(i2, i3, 0xffffffff80000001L, 0x7ffffffe80000001L, 0xffffffff80000001L, 0x7ffffffe80000001L);
		}
	}
}