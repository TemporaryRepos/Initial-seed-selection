public class CompareIC {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String test1 = "Tess";
		java.lang.String test2 = "Test";
		java.lang.String test3 = "Tesu";
		javaT.lang.String.CompareIC comparer = new javaT.lang.String.CompareIC();
		comparer.testTriplet(test1, test2, test3);
		test2 = test2.toUpperCase();
		comparer.testTriplet(test1, test2, test3);
		test2 = test2.toLowerCase();
		comparer.testTriplet(test1, test2, test3);
	}

	private void testTriplet(java.lang.String one, java.lang.String two, java.lang.String three) throws java.lang.Exception {
		if (one.compareToIgnoreCase(two) > 0) {
			throw new java.lang.RuntimeException("Comparison failure1");
		}
		if (two.compareToIgnoreCase(three) > 0) {
			throw new java.lang.RuntimeException("Comparison failure2");
		}
		if (three.compareToIgnoreCase(one) < 0) {
			throw new java.lang.RuntimeException("Comparison failure3");
		}
	}
}