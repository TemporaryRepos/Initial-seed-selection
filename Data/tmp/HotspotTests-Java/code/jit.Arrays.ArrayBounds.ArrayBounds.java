public class ArrayBounds {
	private static int global;

	private static int[] aplIota(int n) {
		int[] a = new int[n];
		for (int j = 0; j < n; j++) {
			a[j] = j;
		}
		return a;
	}

	private static int prematureExceptionWork(int[] a, int n) {
		jit.Arrays.ArrayBounds.ArrayBounds.global = 0;
		int sum = 0;
		try {
			for (int i = 0; i < n; i++) {
				jit.Arrays.ArrayBounds.ArrayBounds.global++;
				sum += a[i];
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException t) {
		}
		return sum;
	}

	private static void prematureException() {
		int[] a = jit.Arrays.ArrayBounds.ArrayBounds.aplIota(10);
		int sum = jit.Arrays.ArrayBounds.ArrayBounds.prematureExceptionWork(a, 11);
		if ((jit.Arrays.ArrayBounds.ArrayBounds.global != 11) || (sum != 45)) {
			throw new nsk.share.TestFailure("Premature exception test failed.");
		}
	}

	private static class Foo {
		int[] a;
	}

	private static int exceptionInHoistedPredWork(jit.Arrays.ArrayBounds.ArrayBounds.Foo f, int n) {
		jit.Arrays.ArrayBounds.ArrayBounds.global = 0;
		int sum = 0;
		try {
			for (int i = 0; i < n; i++) {
				jit.Arrays.ArrayBounds.ArrayBounds.global++;
				sum += f.a[i];
			}
		} catch (java.lang.NullPointerException t) {
		}
		return sum;
	}

	private static void exceptionInHoistedPred() {
		int sum = jit.Arrays.ArrayBounds.ArrayBounds.exceptionInHoistedPredWork(null, 10);
		if ((jit.Arrays.ArrayBounds.ArrayBounds.global != 1) || (sum != 0)) {
			throw new nsk.share.TestFailure("Premature exception test failed.");
		}
	}

	private static void changeLength(jit.Arrays.ArrayBounds.ArrayBounds.Foo f, int n) {
		int[] a = jit.Arrays.ArrayBounds.ArrayBounds.aplIota(n);
		f.a = a;
	}

	private static int arraySideEffectWork(jit.Arrays.ArrayBounds.ArrayBounds.Foo f, int n) {
		int sum = 0;
		try {
			for (int i = 0; i < n; i++) {
				sum += f.a[i];
				if (i == 0) {
					jit.Arrays.ArrayBounds.ArrayBounds.changeLength(f, 5);
				}
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException t) {
		}
		return sum;
	}

	private static void arraySideEffect() {
		int[] a = jit.Arrays.ArrayBounds.ArrayBounds.aplIota(10);
		jit.Arrays.ArrayBounds.ArrayBounds.Foo f = new jit.Arrays.ArrayBounds.ArrayBounds.Foo();
		f.a = a;
		int sum = jit.Arrays.ArrayBounds.ArrayBounds.arraySideEffectWork(f, 10);
		if (sum != 10) {
			throw new nsk.share.TestFailure(("Array side effect test failed (" + sum) + ")");
		}
	}

	private static boolean nullArrayWork(int[] a, int n) {
		int sum = 0;
		jit.Arrays.ArrayBounds.ArrayBounds.global = 0;
		boolean x = false;
		try {
			for (int i = 0; i < n; i++) {
				jit.Arrays.ArrayBounds.ArrayBounds.global++;
				sum += a[i];
			}
		} catch (java.lang.NullPointerException t) {
			x = true;
		}
		return x;
	}

	private static void nullArray() {
		if ((!jit.Arrays.ArrayBounds.ArrayBounds.nullArrayWork(null, 30000)) || (jit.Arrays.ArrayBounds.ArrayBounds.global != 1)) {
			throw new nsk.share.TestFailure("nullArray test failed.");
		}
	}

	private static int[][] aa = new int[10][20];

	static {
		for (int i = 0; i < 10; i++) {
			aa[i] = aplIota(20);
		}
	}

	private static class ArrayMutator extends java.lang.Thread {
		int[][] aa;

		int newN;

		ArrayMutator(int[][] aa, int newN) {
			super();
			this.aa = aa;
			this.newN = newN;
		}

		public void run() {
			aa[1] = jit.Arrays.ArrayBounds.ArrayBounds.aplIota(newN);
		}
	}

	private static int array2DWork(int[][] aa, int m, int n) {
		int sum = 0;
		jit.Arrays.ArrayBounds.ArrayBounds.global = 0;
		try {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					jit.Arrays.ArrayBounds.ArrayBounds.global++;
					sum += aa[i][j];
					if ((i == 0) && (j == 0)) {
						java.lang.Thread t = new jit.Arrays.ArrayBounds.ArrayBounds.ArrayMutator(aa, n / 2);
						try {
							t.start();
							t.join();
						} catch (java.lang.InterruptedException x) {
						}
					}
				}
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException t) {
		}
		return sum;
	}

	private static void array2D() {
		int sum = jit.Arrays.ArrayBounds.ArrayBounds.array2DWork(jit.Arrays.ArrayBounds.ArrayBounds.aa, jit.Arrays.ArrayBounds.ArrayBounds.aa.length, jit.Arrays.ArrayBounds.ArrayBounds.aa[0].length);
		if ((sum != (((19 * 20) / 2) + ((9 * 10) / 2))) || (jit.Arrays.ArrayBounds.ArrayBounds.global != ((20 + 10) + 1))) {
			throw new nsk.share.TestFailure(((("array2D test failed (sum = " + sum) + "; global = ") + jit.Arrays.ArrayBounds.ArrayBounds.global) + ")");
		}
	}

	public static void main(java.lang.String[] args) {
		jit.Arrays.ArrayBounds.ArrayBounds.exceptionInHoistedPred();
		jit.Arrays.ArrayBounds.ArrayBounds.prematureException();
		jit.Arrays.ArrayBounds.ArrayBounds.arraySideEffect();
		jit.Arrays.ArrayBounds.ArrayBounds.nullArray();
		jit.Arrays.ArrayBounds.ArrayBounds.array2D();
	}
}