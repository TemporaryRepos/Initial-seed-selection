public class Test6910605_1 {
	public static int buf = 0;

	public static void main(java.lang.String[] argv) {
		java.lang.System.exit(compiler.c2.Test6910605_1.run(argv, java.lang.System.out) + 95);
	}

	public static int run(java.lang.String[] argv, java.io.PrintStream out) {
		int ret = 0;
		int retx = 0;
		int bad = 0;
		for (int i = 0; (i < 100000) && (bad < 10); i++) {
			retx = compiler.c2.Test6910605_1.OptoRuntime_f2i_Type(out);
			ret += retx;
			if (retx != 0) {
				out.println("i=" + i);
				bad++;
			}
		}
		return ret == 0 ? 0 : 2;
	}

	public static int OptoRuntime_f2i_Type(java.io.PrintStream out) {
		int c1 = 2;
		int c2 = 3;
		int c3 = 4;
		int c4 = 5;
		int c5 = 6;
		int j = 0;
		int k = 0;
		try {
			int[][] iii = ((int[][]) (new int[c1][c2]));
			for (j = 0; j < c1; j++) {
				for (k = 0; k < c2; k++) {
					iii[j][k] = ((int) (((float) (j + 1)) / ((float) (k + 1))));
				}
			}
		} catch (java.lang.Throwable e) {
			out.println("Unexpected exception " + e);
			e.printStackTrace(out);
			out.println((("j=" + j) + ", k=") + k);
			return 1;
		}
		return 0;
	}
}