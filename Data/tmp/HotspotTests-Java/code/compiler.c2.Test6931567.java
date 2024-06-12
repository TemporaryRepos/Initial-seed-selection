public class Test6931567 {
	public static void main(final java.lang.String[] args) {
		compiler.c2.Test6931567.booleanInvert(java.lang.Integer.MAX_VALUE);
		compiler.c2.Test6931567.booleanInvert(java.lang.Integer.MAX_VALUE - 1);
	}

	private static void booleanInvert(final int max) {
		boolean test1 = false;
		boolean test2 = false;
		for (int i = 0; i < max; i++) {
			test1 = !test1;
		}
		for (int i = 0; i < max; i++) {
			test2 ^= true;
		}
		if (test1 != test2) {
			java.lang.System.out.println((("ERROR: Boolean invert\n\ttest1=" + test1) + "\n\ttest2=") + test2);
			java.lang.System.exit(97);
		} else {
			java.lang.System.out.println("Passed!");
		}
	}
}