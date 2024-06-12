public class TestNaNVector {
	private char[] array;

	private static final int LEN = 1024;

	public static void main(java.lang.String[] args) {
		compiler.vectorization.TestNaNVector test = new compiler.vectorization.TestNaNVector();
		for (int i = 0; i < 10000; ++i) {
			test.vectorizeNaNDP();
		}
		java.lang.System.out.println("Checking double precision Nan");
		test.checkResult(0xfff7);
		for (int i = 0; i < 10000; ++i) {
			test.vectorizeNaNSP();
		}
		java.lang.System.out.println("Checking single precision Nan");
		test.checkResult(0xff80);
	}

	public TestNaNVector() {
		array = new char[compiler.vectorization.TestNaNVector.LEN];
	}

	public void vectorizeNaNDP() {
		for (int i = 0; i < compiler.vectorization.TestNaNVector.LEN; ++i) {
			array[i] = 0xfff7;
		}
	}

	public void vectorizeNaNSP() {
		for (int i = 0; i < compiler.vectorization.TestNaNVector.LEN; ++i) {
			array[i] = 0xff80;
		}
	}

	public void checkResult(int expected) {
		for (int i = 0; i < compiler.vectorization.TestNaNVector.LEN; ++i) {
			if (array[i] != expected) {
				throw new java.lang.RuntimeException((((("Invalid result: array[" + i) + "] = ") + ((int) (array[i]))) + " != ") + expected);
			}
		}
	}
}