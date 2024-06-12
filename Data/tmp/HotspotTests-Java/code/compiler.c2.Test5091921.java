public class Test5091921 {
	private static int result = 0;

	public static int test_ge1(int limit) {
		int indx;
		int sum = 0;
		for (indx = 500; indx >= limit; indx -= 2) {
			sum += 2000 / indx;
			compiler.c2.Test5091921.result = sum;
		}
		return sum;
	}

	public static int test_le1(int limit) {
		int indx;
		int sum = 0;
		for (indx = -500; indx <= limit; indx += 2) {
			sum += 3000 / indx;
			compiler.c2.Test5091921.result = sum;
		}
		return sum;
	}

	public static volatile int c = 1;

	public static int test_wrap1(int limit) {
		int indx;
		int sum = 0;
		for (indx = 0xffffffff; indx < limit; indx += 0x20000000) {
			sum += compiler.c2.Test5091921.c;
		}
		return sum;
	}

	static int[] box5 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static int test_rce5(int[] b, int limit) {
		int indx;
		int sum = b[1];
		compiler.c2.Test5091921.result = sum;
		for (indx = 0x80000000; indx < limit; ++indx) {
			if (indx > 0x80000000) {
				if ((indx - 9) < (-9)) {
					sum += indx;
					compiler.c2.Test5091921.result = sum;
					sum ^= b[indx & 7];
					compiler.c2.Test5091921.result = sum;
				} else {
					break;
				}
			} else {
				sum += b[indx & 3];
				compiler.c2.Test5091921.result = sum;
			}
		}
		return sum;
	}

	static int[] box6 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static int test_rce6(int[] b, int limit) {
		int indx;
		int sum = b[1];
		compiler.c2.Test5091921.result = sum;
		for (indx = 0x80000000; indx < limit; ++indx) {
			if (indx > 0x80000000) {
				if (indx < 0) {
					sum += compiler.c2.Test5091921.result;
					compiler.c2.Test5091921.result = sum;
				} else {
					break;
				}
				if (((indx * 28) + 1) < 0) {
					sum += indx;
					compiler.c2.Test5091921.result = sum;
					sum ^= b[indx & 7];
					compiler.c2.Test5091921.result = sum;
				} else {
					break;
				}
			} else {
				sum += b[indx & 3];
				compiler.c2.Test5091921.result = sum;
			}
		}
		return sum;
	}

	static int[] box7 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 0x7fffffff };

	public static int test_rce7(int[] b) {
		int indx;
		int max = b[9];
		int sum = b[7];
		compiler.c2.Test5091921.result = sum;
		for (indx = 0; indx < b.length; ++indx) {
			if (indx <= max) {
				sum += (indx ^ 15) + (compiler.c2.Test5091921.result != 0 ? 0 : sum);
				compiler.c2.Test5091921.result = sum;
			} else {
				throw new java.lang.RuntimeException();
			}
		}
		for (indx = -7; indx < b.length; ++indx) {
			if (indx <= 9) {
				sum += (sum ^ 15) + (compiler.c2.Test5091921.result != 0 ? 0 : sum);
				compiler.c2.Test5091921.result = sum;
			} else {
				throw new java.lang.RuntimeException();
			}
		}
		return sum;
	}

	static int[] box8 = new int[]{ -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 0x80000000 };

	public static int test_rce8(int[] b) {
		int indx;
		int sum = b[5];
		int min = b[10];
		compiler.c2.Test5091921.result = sum;
		for (indx = b.length - 1; indx >= 0; --indx) {
			if (indx >= min) {
				sum += (sum ^ 9) + (compiler.c2.Test5091921.result != 0 ? 0 : sum);
				compiler.c2.Test5091921.result = sum;
			} else {
				throw new java.lang.RuntimeException();
			}
		}
		return sum;
	}

	public static void main(java.lang.String[] args) {
		compiler.c2.Test5091921.result = 1;
		int r = 0;
		try {
			r = compiler.c2.Test5091921.test_ge1(0x80000000);
			java.lang.System.out.println(compiler.c2.Test5091921.result);
			java.lang.System.out.println("test_ge1 FAILED");
			java.lang.System.exit(1);
		} catch (java.lang.ArithmeticException e1) {
			java.lang.System.out.println("test_ge1: Expected exception caught");
			if (compiler.c2.Test5091921.result != 5986) {
				java.lang.System.out.println(compiler.c2.Test5091921.result);
				java.lang.System.out.println("test_ge1 FAILED");
				java.lang.System.exit(97);
			}
		}
		java.lang.System.out.println("test_ge1 WORKED");
		compiler.c2.Test5091921.result = 0;
		try {
			r = compiler.c2.Test5091921.test_le1(0x7fffffff);
			java.lang.System.out.println(compiler.c2.Test5091921.result);
			java.lang.System.out.println("test_le1 FAILED");
			java.lang.System.exit(1);
		} catch (java.lang.ArithmeticException e1) {
			java.lang.System.out.println("test_le1: Expected exception caught");
			if (compiler.c2.Test5091921.result != (-9039)) {
				java.lang.System.out.println(compiler.c2.Test5091921.result);
				java.lang.System.out.println("test_le1 FAILED");
				java.lang.System.exit(97);
			}
		}
		java.lang.System.out.println("test_le1 WORKED");
		compiler.c2.Test5091921.result = 0;
		r = compiler.c2.Test5091921.test_wrap1(0x7fffffff);
		if (r != 4) {
			java.lang.System.out.println(compiler.c2.Test5091921.result);
			java.lang.System.out.println("test_wrap1 FAILED");
			java.lang.System.exit(97);
		} else {
			java.lang.System.out.println("test_wrap1 WORKED");
		}
		compiler.c2.Test5091921.result = 0;
		r = compiler.c2.Test5091921.test_rce5(compiler.c2.Test5091921.box5, 0x80000100);
		if (compiler.c2.Test5091921.result != 3) {
			java.lang.System.out.println(compiler.c2.Test5091921.result);
			java.lang.System.out.println("test_rce5 FAILED");
			java.lang.System.exit(97);
		} else {
			java.lang.System.out.println("test_rce5 WORKED");
		}
		compiler.c2.Test5091921.result = 0;
		r = compiler.c2.Test5091921.test_rce6(compiler.c2.Test5091921.box6, 0x80000100);
		if (compiler.c2.Test5091921.result != 6) {
			java.lang.System.out.println(compiler.c2.Test5091921.result);
			java.lang.System.out.println("test_rce6 FAILED");
			java.lang.System.exit(97);
		} else {
			java.lang.System.out.println("test_rce6 WORKED");
		}
		compiler.c2.Test5091921.result = 0;
		r = compiler.c2.Test5091921.test_rce7(compiler.c2.Test5091921.box7);
		if (compiler.c2.Test5091921.result != 14680079) {
			java.lang.System.out.println(compiler.c2.Test5091921.result);
			java.lang.System.out.println("test_rce7 FAILED");
			java.lang.System.exit(97);
		} else {
			java.lang.System.out.println("test_rce7 WORKED");
		}
		compiler.c2.Test5091921.result = 0;
		r = compiler.c2.Test5091921.test_rce8(compiler.c2.Test5091921.box8);
		if (compiler.c2.Test5091921.result != 16393) {
			java.lang.System.out.println(compiler.c2.Test5091921.result);
			java.lang.System.out.println("test_rce8 FAILED");
			java.lang.System.exit(97);
		} else {
			java.lang.System.out.println("test_rce8 WORKED");
		}
	}
}