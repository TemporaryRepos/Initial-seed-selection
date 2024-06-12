public class TestBestAlign {
	static final int initVal = -1;

	static int[] intArray;

	static boolean[] boolArray;

	static int limit;

	public static void clear() {
		for (int i = 0; i < compiler.loopopts.superword.TestBestAlign.limit; i++) {
			compiler.loopopts.superword.TestBestAlign.boolArray[1] = true;
			compiler.loopopts.superword.TestBestAlign.intArray[i] = compiler.loopopts.superword.TestBestAlign.initVal;
			compiler.loopopts.superword.TestBestAlign.boolArray[2] = true;
		}
	}

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		compiler.loopopts.superword.TestBestAlign.limit = 64;
		compiler.loopopts.superword.TestBestAlign.boolArray = new boolean[8];
		compiler.loopopts.superword.TestBestAlign.intArray = new int[compiler.loopopts.superword.TestBestAlign.limit + 4];
		for (int i = 0; i < 10000000; ++i) {
			if ((i % 1000000) == 0) {
				java.lang.System.out.println(i);
			}
			compiler.loopopts.superword.TestBestAlign.clear();
		}
	}
}