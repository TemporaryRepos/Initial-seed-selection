public class TestPopCountVector {
	private int[] input;

	private int[] output;

	private static final int LEN = 1024;

	public static void main(java.lang.String[] args) {
		compiler.vectorization.TestPopCountVector test = new compiler.vectorization.TestPopCountVector();
		for (int i = 0; i < 10000; ++i) {
			test.vectorizeBitCount();
		}
		java.lang.System.out.println("Checking popcount result");
		test.checkResult();
		for (int i = 0; i < 10000; ++i) {
			test.vectorizeBitCount();
		}
		java.lang.System.out.println("Checking popcount result");
		test.checkResult();
	}

	public TestPopCountVector() {
		input = new int[compiler.vectorization.TestPopCountVector.LEN];
		output = new int[compiler.vectorization.TestPopCountVector.LEN];
		for (int i = 0; i < compiler.vectorization.TestPopCountVector.LEN; ++i) {
			input[i] = ((i % 2) == 0) ? i : (-1) * i;
		}
	}

	public void vectorizeBitCount() {
		for (int i = 0; i < compiler.vectorization.TestPopCountVector.LEN; ++i) {
			output[i] = java.lang.Integer.bitCount(input[i]);
		}
	}

	public void checkResult() {
		for (int i = 0; i < compiler.vectorization.TestPopCountVector.LEN; ++i) {
			int expected = java.lang.Integer.bitCount(input[i]);
			if (output[i] != expected) {
				throw new java.lang.RuntimeException((((("Invalid result: output[" + i) + "] = ") + output[i]) + " != ") + expected);
			}
		}
	}
}