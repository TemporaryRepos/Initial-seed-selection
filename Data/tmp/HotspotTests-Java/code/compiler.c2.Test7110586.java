public class Test7110586 {
	static int test1() {
		int i = 0;
		for (; i < 11; i += 1) {
		}
		return i;
	}

	static int test2() {
		int i = 0;
		for (; i < 11; i += 2) {
		}
		return i;
	}

	static int test3() {
		int i = 0;
		for (; i < 11; i += 3) {
		}
		return i;
	}

	static int test11() {
		int i = 0;
		for (; i < 11; i += 11) {
		}
		return i;
	}

	static int testm1() {
		int i = 0;
		for (; i > (-11); i -= 1) {
		}
		return i;
	}

	static int testm2() {
		int i = 0;
		for (; i > (-11); i -= 2) {
		}
		return i;
	}

	static int testm3() {
		int i = 0;
		for (; i > (-11); i -= 3) {
		}
		return i;
	}

	static int testm11() {
		int i = 0;
		for (; i > (-11); i -= 11) {
		}
		return i;
	}

	public static void main(java.lang.String[] args) {
		int x1 = 0;
		int x2 = 0;
		int x3 = 0;
		int x11 = 0;
		int m1 = 0;
		int m2 = 0;
		int m3 = 0;
		int m11 = 0;
		for (int i = 0; i < 10000; i++) {
			x1 = compiler.c2.Test7110586.test1();
			x2 = compiler.c2.Test7110586.test2();
			x3 = compiler.c2.Test7110586.test3();
			x11 = compiler.c2.Test7110586.test11();
			m1 = compiler.c2.Test7110586.testm1();
			m2 = compiler.c2.Test7110586.testm2();
			m3 = compiler.c2.Test7110586.testm3();
			m11 = compiler.c2.Test7110586.testm11();
		}
		boolean failed = false;
		if (x1 != 11) {
			java.lang.System.out.println(("ERROR (incr = +1): " + x1) + " != 11");
			failed = true;
		}
		if (x2 != 12) {
			java.lang.System.out.println(("ERROR (incr = +2): " + x2) + " != 12");
			failed = true;
		}
		if (x3 != 12) {
			java.lang.System.out.println(("ERROR (incr = +3): " + x3) + " != 12");
			failed = true;
		}
		if (x11 != 11) {
			java.lang.System.out.println(("ERROR (incr = +11): " + x11) + " != 11");
			failed = true;
		}
		if (m1 != (-11)) {
			java.lang.System.out.println(("ERROR (incr = -1): " + m1) + " != -11");
			failed = true;
		}
		if (m2 != (-12)) {
			java.lang.System.out.println(("ERROR (incr = -2): " + m2) + " != -12");
			failed = true;
		}
		if (m3 != (-12)) {
			java.lang.System.out.println(("ERROR (incr = -3): " + m3) + " != -12");
			failed = true;
		}
		if (m11 != (-11)) {
			java.lang.System.out.println(("ERROR (incr = -11): " + m11) + " != -11");
			failed = true;
		}
		if (failed) {
			java.lang.System.exit(97);
		}
	}
}