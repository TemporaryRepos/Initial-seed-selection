public class Test6646019 {
	static final int i = 2076285318;

	long l = 2;

	short s;

	public static void main(java.lang.String[] args) {
		compiler.c2.Test6646019 t = new compiler.c2.Test6646019();
		try {
			t.test();
		} catch (java.lang.Throwable e) {
			if (t.l != 5) {
				java.lang.System.out.println(("Fails: " + t.l) + " != 5");
			}
		}
	}

	private void test() {
		l = 5;
		l = new short[((byte) (-2))][((byte) (l = compiler.c2.Test6646019.i))];
	}
}