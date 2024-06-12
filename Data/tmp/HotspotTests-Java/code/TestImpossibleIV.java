public class TestImpossibleIV {
	private static void testMethod() {
		int sum = 0;
		for (int i = 100000; i >= 0; i--) {
			sum += java.lang.Integer.MIN_VALUE;
		}
	}

	public static void main(java.lang.String[] args) {
		TestImpossibleIV.testMethod();
	}
}