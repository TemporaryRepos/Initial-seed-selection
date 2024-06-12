public class TestRegisterRestoring {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		float[] array = new float[100];
		for (int i = 0; i < array.length; ++i) {
			array[i] = 0;
		}
		for (int j = 0; j < 20000; ++j) {
			compiler.runtime.safepoints.TestRegisterRestoring.increment(array);
			for (int i = 0; i < array.length; i++) {
				if (array[i] != 10000) {
					throw new java.lang.RuntimeException(((("Test failed: array[" + i) + "] = ") + array[i]) + " but should be 10.000");
				}
				array[i] = 0;
			}
		}
	}

	static void increment(float[] array) {
		for (long l = 0; l < 10000; l++) {
			for (int i = 0; i < array.length; ++i) {
				array[i] += 1;
			}
		}
	}
}