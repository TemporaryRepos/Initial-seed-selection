class CountingSort implements com.thealgorithms.sorts.SortAlgorithm {
	@java.lang.Override
	public <T extends java.lang.Comparable<T>> T[] sort(T[] unsorted) {
		return sort(java.util.Arrays.asList(unsorted)).toArray(unsorted);
	}

	@java.lang.Override
	public <T extends java.lang.Comparable<T>> java.util.List<T> sort(java.util.List<T> list) {
		java.util.Map<T, java.lang.Integer> frequency = new java.util.TreeMap<>();
		java.util.List<T> sortedArray = new java.util.ArrayList<>(list.size());
		list.forEach(( v) -> frequency.put(v, frequency.getOrDefault(v, 0) + 1));
		for (java.util.Map.Entry<T, java.lang.Integer> element : frequency.entrySet()) {
			for (int j = 0; j < element.getValue(); j++) {
				sortedArray.add(element.getKey());
			}
		}
		return sortedArray;
	}

	private static <T extends java.lang.Comparable<T>> java.util.List<T> streamSort(java.util.List<T> list) {
		return list.stream().collect(java.util.stream.Collectors.toMap(( k) -> k, ( v) -> 1, ( v1, v2) -> v1 + v2, java.util.TreeMap::new)).entrySet().stream().flatMap(( entry) -> java.util.stream.IntStream.rangeClosed(1, entry.getValue()).mapToObj(( t) -> entry.getKey())).collect(java.util.stream.Collectors.toList());
	}

	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.Integer> unsortedInts = java.util.stream.Stream.of(4, 23, 6, 78, 1, 54, 23, 1, 9, 231, 9, 12).collect(java.util.stream.Collectors.toList());
		com.thealgorithms.sorts.CountingSort countingSort = new com.thealgorithms.sorts.CountingSort();
		java.lang.System.out.println("Before Sorting:");
		com.thealgorithms.sorts.SortUtils.print(unsortedInts);
		java.lang.System.out.println("After Sorting:");
		com.thealgorithms.sorts.SortUtils.print(countingSort.sort(unsortedInts));
		java.lang.System.out.println("After Sorting By Streams:");
		com.thealgorithms.sorts.SortUtils.print(com.thealgorithms.sorts.CountingSort.streamSort(unsortedInts));
		java.lang.System.out.println("\n------------------------------\n");
		java.util.List<java.lang.String> unsortedStrings = java.util.stream.Stream.of("c", "a", "e", "b", "d", "a", "f", "g", "c").collect(java.util.stream.Collectors.toList());
		java.lang.System.out.println("Before Sorting:");
		com.thealgorithms.sorts.SortUtils.print(unsortedStrings);
		java.lang.System.out.println("After Sorting:");
		com.thealgorithms.sorts.SortUtils.print(countingSort.sort(unsortedStrings));
		java.lang.System.out.println("After Sorting By Streams:");
		com.thealgorithms.sorts.SortUtils.print(com.thealgorithms.sorts.CountingSort.streamSort(unsortedStrings));
	}
}