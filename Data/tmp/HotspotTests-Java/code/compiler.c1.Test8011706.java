public class Test8011706 {
	int[] array;

	void m(boolean test, int[] array1, int[] array2) {
		int i = 0;
		if (test) {
			array = array1;
		} else {
			array = array2;
		}
		while (true) {
			int v = array[i];
			i++;
			if (i >= 10) {
				return;
			}
		} 
	}

	public static void main(java.lang.String[] args) {
		int[] new_array = new int[10];
		compiler.c1.Test8011706 ti = new compiler.c1.Test8011706();
		boolean failed = false;
		try {
			for (int i = 0; i < 10000; i++) {
				ti.array = null;
				ti.m(true, new_array, new_array);
			}
		} catch (java.lang.NullPointerException ex) {
			throw new java.lang.RuntimeException("TEST FAILED", ex);
		}
		java.lang.System.out.println("TEST PASSED");
	}
}