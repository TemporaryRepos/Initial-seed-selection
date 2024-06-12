public class TestVectorRegAlloc {
	static int test_helper_i;

	static boolean test_helper() {
		compiler.regalloc.TestVectorRegAlloc.test_helper_i++;
		return (compiler.regalloc.TestVectorRegAlloc.test_helper_i & 7) != 0;
	}

	static void test(double[] src, double[] dst, boolean flag) {
		double j = 0.0;
		while (compiler.regalloc.TestVectorRegAlloc.test_helper()) {
			for (int i = 0; i < src.length; i++) {
				dst[i] = src[i] + j;
			}
			for (int i = 0; i < src.length; i++) {
				double k;
				if (flag) {
					k = j;
				} else {
					k = 0;
				}
				dst[i] = src[i] + k;
			}
			j++;
		} 
	}

	public static void main(java.lang.String[] args) {
		double[] src = new double[10];
		double[] dst = new double[10];
		for (int i = 0; i < 20000; i++) {
			compiler.regalloc.TestVectorRegAlloc.test(src, dst, (i % 2) == 0);
		}
	}
}