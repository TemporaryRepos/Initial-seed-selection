public class Test7029152 {
	static final java.lang.String str = "11111xx11111xx1x";

	static int idx = 0;

	static int IndexOfTest(java.lang.String str) {
		return str.indexOf("11111xx1x");
	}

	public static void main(java.lang.String[] args) {
		final int ITERS = 2000000;
		for (int i = 0; i < ITERS; i++) {
			compiler.c2.Test7029152.idx = compiler.c2.Test7029152.IndexOfTest(compiler.c2.Test7029152.str);
		}
		java.lang.System.out.println("IndexOf = " + compiler.c2.Test7029152.idx);
	}
}