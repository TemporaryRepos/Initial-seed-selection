public class Main {
	public static void testOperators() {
		int i = 0;
		int j = 0;
		i = ((j + (i * 40)) + 5) - 3;
		java.lang.Thread.dumpStack();
		return;
	}

	public static void testConditions() {
		int i = 0;
		int j = 0;
		boolean f = (j < i) && ((i > j) || (i == 4));
	}

	public static void testNew() {
	}

	public static void tesRef() {
		int i = 10;
		int j = 15;
		i = j;
	}

	public void foo(int i) {
	}

	public void boo() {
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		JavaTesting.Main.testOperators();
	}
}