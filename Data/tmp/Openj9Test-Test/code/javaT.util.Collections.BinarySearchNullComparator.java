public class BinarySearchNullComparator {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.List list = java.util.Arrays.asList(new java.lang.String[]{ "I", "Love", "You" });
		int result = java.util.Collections.binarySearch(list, "You", null);
		if (result != 2) {
			throw new java.lang.Exception("Result: " + result);
		}
	}
}