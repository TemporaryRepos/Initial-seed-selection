public class Test6823453 {
	static long vara_1 = 1L;

	static void testa() {
		short var_2 = ((byte) (1.0E10));
		for (java.lang.Object temp = new byte[((byte) (1.0E10))]; true; var_2 = ("1".equals("0")) ? ((byte) (compiler.c2.Test6823453.vara_1)) : 1) {
		}
	}

	static void testb() {
		long var_1 = -1L;
		short var_2 = ((byte) (1.0E10));
		for (java.lang.Object temp = new byte[((byte) (1.0E10))]; true; var_2 = ("1".equals("0")) ? ((byte) (var_1)) : 1) {
		}
	}

	static void testc() {
		long var_1 = -1L;
		if (compiler.c2.Test6823453.vara_1 > 0) {
			var_1 = 1L;
		}
		int var_2 = ((byte) (var_1)) - 128;
		for (java.lang.Object temp = new byte[var_2]; true; var_2 = ("1".equals("0")) ? 2 : 1) {
		}
	}

	static void testd() {
		long var_1 = 0L;
		int var_2 = ((byte) (var_1)) + 1;
		for (int i = 0; i < 2; i++) {
			var_2 = var_2 - 1;
		}
		for (java.lang.Object temp = new byte[var_2]; true; var_2 = ("1".equals("0")) ? 2 : 1) {
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int nex = 0;
		try {
			compiler.c2.Test6823453.testa();
		} catch (java.lang.NegativeArraySizeException ex) {
			nex++;
		}
		try {
			compiler.c2.Test6823453.testb();
		} catch (java.lang.NegativeArraySizeException ex) {
			nex++;
		}
		try {
			compiler.c2.Test6823453.testc();
		} catch (java.lang.NegativeArraySizeException ex) {
			nex++;
		}
		try {
			compiler.c2.Test6823453.testd();
		} catch (java.lang.NegativeArraySizeException ex) {
			nex++;
		}
		if (nex != 4) {
			java.lang.System.exit(97);
		}
	}
}