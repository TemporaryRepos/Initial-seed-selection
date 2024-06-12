public class Test6775880 {
	int cnt;

	int[] b;

	java.lang.String s;

	java.lang.String test() {
		java.lang.String res = "";
		for (int i = 0; i < cnt; i++) {
			if (i != 0) {
				res = res + ".";
			}
			res = res + b[i];
		}
		return res;
	}

	public static void main(java.lang.String[] args) {
		compiler.escapeAnalysis.Test6775880 t = new compiler.escapeAnalysis.Test6775880();
		t.cnt = 3;
		t.b = new int[3];
		t.b[0] = 0;
		t.b[1] = 1;
		t.b[2] = 2;
		int j = 0;
		t.s = "";
		for (int i = 0; i < 10001; i++) {
			t.s = "c";
			t.s = t.test();
		}
		java.lang.System.out.println("After s=" + t.s);
	}
}