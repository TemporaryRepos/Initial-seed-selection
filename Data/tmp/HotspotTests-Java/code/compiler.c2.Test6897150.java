public class Test6897150 {
	public static void main(java.lang.String[] args) {
		compiler.c2.Test6897150.loopAndPrint(java.lang.Integer.MAX_VALUE - 1);
		compiler.c2.Test6897150.loopAndPrint(java.lang.Integer.MAX_VALUE);
	}

	static void verify(int max, int a) {
		if (a != (max - 1)) {
			java.lang.System.out.println("Expected: " + (max - 1));
			java.lang.System.out.println("Actual  : " + a);
			java.lang.System.exit(97);
		}
	}

	static void loopAndPrint(int max) {
		int a = -1;
		int i = 1;
		for (; i < max; i++) {
			a = i;
		}
		compiler.c2.Test6897150.verify(max, a);
	}
}