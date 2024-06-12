public class JumpSearch implements com.thealgorithms.devutils.searches.SearchAlgorithm {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.searches.JumpSearch jumpSearch = new com.thealgorithms.searches.JumpSearch();
		java.lang.Integer[] array = new java.lang.Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < array.length; i++) {
			assert jumpSearch.find(array, i) == i;
		}
		assert jumpSearch.find(array, -1) == (-1);
		assert jumpSearch.find(array, 11) == (-1);
	}

	@java.lang.Override
	public <T extends java.lang.Comparable<T>> int find(T[] array, T key) {
		int length = array.length;
		int blockSize = ((int) (java.lang.Math.sqrt(length)));
		int limit = blockSize;
		while ((key.compareTo(array[limit]) > 0) && (limit < (array.length - 1))) {
			limit = java.lang.Math.min(limit + blockSize, array.length - 1);
		} 
		for (int i = limit - blockSize; i <= limit; i++) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}
}