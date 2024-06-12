public class Test8011771 {
	static void m(int[] a, int[] b, int j) {
		for (int i = 0; i < 10; i++) {
			a[i] = i;
		}
		a[j] = 0;
		a[j + 5] = 0;
		b[j + 4] = 0;
	}

	public static void main(java.lang.String[] args) {
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		for (int i = 0; i < 5000; i++) {
			compiler.c1.Test8011771.m(arr1, arr2, 0);
		}
		try {
			compiler.c1.Test8011771.m(new int[1], null, 0);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
		}
		for (int i = 0; i < 5000; i++) {
			compiler.c1.Test8011771.m(arr1, arr2, 0);
		}
		boolean success = false;
		try {
			compiler.c1.Test8011771.m(arr1, new int[1], 0);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			success = true;
		}
		if (success) {
			java.lang.System.out.println("TEST PASSED");
		} else {
			throw new java.lang.RuntimeException("TEST FAILED: erroneous bound check elimination");
		}
	}
}