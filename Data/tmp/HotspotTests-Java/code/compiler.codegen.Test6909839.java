public class Test6909839 {
	public static void main(java.lang.String[] args) {
		compiler.codegen.Test6909839.testi();
		compiler.codegen.Test6909839.testi();
		compiler.codegen.Test6909839.testi();
		compiler.codegen.Test6909839.testui();
		compiler.codegen.Test6909839.testui();
		compiler.codegen.Test6909839.testui();
		compiler.codegen.Test6909839.testdi();
		compiler.codegen.Test6909839.testdi();
		compiler.codegen.Test6909839.testdi();
		compiler.codegen.Test6909839.testfi();
		compiler.codegen.Test6909839.testfi();
		compiler.codegen.Test6909839.testfi();
		compiler.codegen.Test6909839.testl();
		compiler.codegen.Test6909839.testl();
		compiler.codegen.Test6909839.testl();
		compiler.codegen.Test6909839.testul();
		compiler.codegen.Test6909839.testul();
		compiler.codegen.Test6909839.testul();
		compiler.codegen.Test6909839.testdl();
		compiler.codegen.Test6909839.testdl();
		compiler.codegen.Test6909839.testdl();
		compiler.codegen.Test6909839.testfl();
		compiler.codegen.Test6909839.testfl();
		compiler.codegen.Test6909839.testfl();
		compiler.codegen.Test6909839.testf();
		compiler.codegen.Test6909839.testf();
		compiler.codegen.Test6909839.testf();
		compiler.codegen.Test6909839.testuf();
		compiler.codegen.Test6909839.testuf();
		compiler.codegen.Test6909839.testuf();
		compiler.codegen.Test6909839.testdf();
		compiler.codegen.Test6909839.testdf();
		compiler.codegen.Test6909839.testdf();
		compiler.codegen.Test6909839.testff();
		compiler.codegen.Test6909839.testff();
		compiler.codegen.Test6909839.testff();
		compiler.codegen.Test6909839.testd();
		compiler.codegen.Test6909839.testd();
		compiler.codegen.Test6909839.testd();
		compiler.codegen.Test6909839.testud();
		compiler.codegen.Test6909839.testud();
		compiler.codegen.Test6909839.testud();
		compiler.codegen.Test6909839.testdd();
		compiler.codegen.Test6909839.testdd();
		compiler.codegen.Test6909839.testdd();
		compiler.codegen.Test6909839.testfd();
		compiler.codegen.Test6909839.testfd();
		compiler.codegen.Test6909839.testfd();
		compiler.codegen.Test6909839.testp();
		compiler.codegen.Test6909839.testp();
		compiler.codegen.Test6909839.testp();
		compiler.codegen.Test6909839.testup();
		compiler.codegen.Test6909839.testup();
		compiler.codegen.Test6909839.testup();
		compiler.codegen.Test6909839.testdp();
		compiler.codegen.Test6909839.testdp();
		compiler.codegen.Test6909839.testdp();
		compiler.codegen.Test6909839.testfp();
		compiler.codegen.Test6909839.testfp();
		compiler.codegen.Test6909839.testfp();
	}

	static void testui() {
		int total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += ((v >= 1) && (v < 3)) ? 1 : 2;
		}
		java.lang.System.out.println(total);
	}

	static void testdi() {
		int total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += (v > 1.0) ? 1 : 2;
		}
		java.lang.System.out.println(total);
	}

	static void testfi() {
		int total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += (v > 1.0F) ? 1 : 2;
		}
		java.lang.System.out.println(total);
	}

	static void testi() {
		int total = 0;
		for (int i = 0; i < 10000; i++) {
			total += ((i % 4) != 0) ? 1 : 2;
		}
		java.lang.System.out.println(total);
	}

	static void testul() {
		long total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += ((v >= 1) && (v < 3)) ? 1L : 2L;
		}
		java.lang.System.out.println(total);
	}

	static void testdl() {
		long total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += (v > 1.0) ? 1L : 2L;
		}
		java.lang.System.out.println(total);
	}

	static void testfl() {
		long total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += (v > 1.0F) ? 1L : 2L;
		}
		java.lang.System.out.println(total);
	}

	static void testl() {
		long total = 0;
		for (int i = 0; i < 10000; i++) {
			total += ((i % 4) != 0) ? 1L : 2L;
		}
		java.lang.System.out.println(total);
	}

	static void testuf() {
		float total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += ((v >= 1) && (v < 3)) ? 1.0F : 2.0F;
		}
		java.lang.System.out.println(total);
	}

	static void testdf() {
		float total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += (v > 0.0) ? 1.0F : 2.0F;
		}
		java.lang.System.out.println(total);
	}

	static void testff() {
		float total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += (v > 0.0F) ? 1.0F : 2.0F;
		}
		java.lang.System.out.println(total);
	}

	static void testf() {
		float total = 0;
		for (int i = 0; i < 10000; i++) {
			total += ((i % 4) != 0) ? 1.0F : 2.0F;
		}
		java.lang.System.out.println(total);
	}

	static void testud() {
		double total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += ((v >= 1) && (v < 3)) ? 1.0 : 2.0;
		}
		java.lang.System.out.println(total);
	}

	static void testdd() {
		double total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += (v > 1.0) ? 1.0 : 2.0;
		}
		java.lang.System.out.println(total);
	}

	static void testfd() {
		double total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += (v > 1.0F) ? 1.0 : 2.0;
		}
		java.lang.System.out.println(total);
	}

	static void testd() {
		double total = 0;
		for (int i = 0; i < 10000; i++) {
			total += ((i % 4) != 0) ? 1.0 : 2.0;
		}
		java.lang.System.out.println(total);
	}

	static void testp() {
		java.lang.Object a = new java.lang.Object();
		java.lang.Object b = new java.lang.Object();
		int total = 0;
		for (int i = 0; i < 10000; i++) {
			total += 10000;
		}
		java.lang.System.out.println(total);
	}

	static void testup() {
		java.lang.Object a = new java.lang.Object();
		java.lang.Object b = new java.lang.Object();
		int total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += 10000;
		}
		java.lang.System.out.println(total);
	}

	static void testdp() {
		java.lang.Object a = new java.lang.Object();
		java.lang.Object b = new java.lang.Object();
		int total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += 10000;
		}
		java.lang.System.out.println(total);
	}

	static void testfp() {
		java.lang.Object a = new java.lang.Object();
		java.lang.Object b = new java.lang.Object();
		int total = 0;
		for (int i = 0; i < 10000; i++) {
			int v = i % 4;
			total += 10000;
		}
		java.lang.System.out.println(total);
	}
}