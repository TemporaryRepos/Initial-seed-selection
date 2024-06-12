public class MultiplyByMaxInt {
	static int test(int x) {
		int loops = (x >>> 4) & 7;
		while ((loops--) > 0) {
			x = (x * 2147483647) % 16807;
		} 
		return x;
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 20000; i++) {
			compiler.c1.MultiplyByMaxInt.test(i);
		}
	}
}