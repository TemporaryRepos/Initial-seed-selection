public class TestSplitIfUnswitchedLoopsEliminated {
	static class A {
		int f;
	}

	static compiler.loopopts.TestSplitIfUnswitchedLoopsEliminated.A aa = new compiler.loopopts.TestSplitIfUnswitchedLoopsEliminated.A();

	static compiler.loopopts.TestSplitIfUnswitchedLoopsEliminated.A aaa = new compiler.loopopts.TestSplitIfUnswitchedLoopsEliminated.A();

	static int test_helper(int stop, boolean unswitch) {
		compiler.loopopts.TestSplitIfUnswitchedLoopsEliminated.A a = null;
		for (int i = 3; i < 10; i++) {
			if (unswitch) {
				a = null;
			} else {
				a = compiler.loopopts.TestSplitIfUnswitchedLoopsEliminated.aa;
				int v = a.f;
			}
		}
		if (stop != 4) {
			a = compiler.loopopts.TestSplitIfUnswitchedLoopsEliminated.aaa;
		}
		if (a != null) {
			return a.f;
		}
		return 0;
	}

	static int test(boolean unswitch) {
		int stop = 1;
		for (; stop < 3; stop *= 4) {
		}
		return compiler.loopopts.TestSplitIfUnswitchedLoopsEliminated.test_helper(stop, unswitch);
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 20000; i++) {
			compiler.loopopts.TestSplitIfUnswitchedLoopsEliminated.test_helper(10, (i % 2) == 0);
			compiler.loopopts.TestSplitIfUnswitchedLoopsEliminated.test((i % 2) == 0);
		}
	}
}