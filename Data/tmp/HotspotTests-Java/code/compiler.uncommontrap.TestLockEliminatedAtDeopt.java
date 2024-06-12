public class TestLockEliminatedAtDeopt {
	static class A {
		void m() {
		}

		synchronized void m2(boolean trap) {
			if (trap) {
				new compiler.uncommontrap.TestLockEliminatedAtDeopt.B();
			}
		}
	}

	static class B extends compiler.uncommontrap.TestLockEliminatedAtDeopt.A {
		void m() {
		}
	}

	static void m1(boolean trap) {
		compiler.uncommontrap.TestLockEliminatedAtDeopt.A a = new compiler.uncommontrap.TestLockEliminatedAtDeopt.A();
		synchronized(a) {
			a.m2(trap);
			a.m();
		}
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 20000; i++) {
			compiler.uncommontrap.TestLockEliminatedAtDeopt.m1(false);
		}
		compiler.uncommontrap.TestLockEliminatedAtDeopt.m1(true);
	}
}