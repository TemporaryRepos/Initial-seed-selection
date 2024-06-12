public class Test7125879 {
	java.lang.String var_1 = "abc";

	public Test7125879() {
		var_1 = var_1.replaceAll("d", "e") + var_1;
	}

	public static void main(java.lang.String[] args) {
		compiler.c2.Test7125879 t = new compiler.c2.Test7125879();
		try {
			t.test();
		} catch (java.lang.Throwable e) {
		}
	}

	private void test() {
		new compiler.c2.Test7125879().var_1 = ((compiler.c2.Test7125879) (new java.lang.Object[-1][0])).var_1;
	}
}