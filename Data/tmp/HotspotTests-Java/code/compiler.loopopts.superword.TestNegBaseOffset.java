public class TestNegBaseOffset {
	public static final int N = 400;

	public static int iFld = 10;

	public static int[] iArr = new int[compiler.loopopts.superword.TestNegBaseOffset.N];

	public static void mainTest() {
		int i0 = 1;
		int i2;
		while ((++i0) < 339) {
			if ((i0 % 2) == 0) {
				for (i2 = 2; i2 > i0; i2 -= 3) {
					compiler.loopopts.superword.TestNegBaseOffset.iArr[i2 - 1] &= compiler.loopopts.superword.TestNegBaseOffset.iFld;
				}
			}
		} 
	}

	public static void main(java.lang.String[] strArr) {
		for (int i = 0; i < 10; i++) {
			compiler.loopopts.superword.TestNegBaseOffset.mainTest();
		}
	}
}