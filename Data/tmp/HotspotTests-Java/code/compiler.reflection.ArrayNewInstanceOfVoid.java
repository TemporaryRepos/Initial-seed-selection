public class ArrayNewInstanceOfVoid {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 100000; i++) {
			compiler.reflection.ArrayNewInstanceOfVoid.test();
		}
	}

	private static void test() {
		try {
			java.lang.reflect.Array.newInstance(void.class, 2);
		} catch (java.lang.IllegalArgumentException e) {
		}
	}
}