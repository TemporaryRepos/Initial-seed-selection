public class Combination {
	public static <T extends java.lang.Comparable<? super T>> java.util.List<java.util.List<T>> findSortedCombinations(java.util.Collection<T> elements) {
		java.util.List<java.util.List<T>> result = new java.util.ArrayList<java.util.List<T>>();
		for (int i = 0; i <= elements.size(); i++) {
			result.addAll(org.dataalgorithms.util.Combination.findSortedCombinations(elements, i));
		}
		return result;
	}

	public static <T extends java.lang.Comparable<? super T>> java.util.List<java.util.List<T>> findSortedCombinations(java.util.Collection<T> elements, int n) {
		java.util.List<java.util.List<T>> result = new java.util.ArrayList<java.util.List<T>>();
		if (n == 0) {
			result.add(new java.util.ArrayList<T>());
			return result;
		}
		java.util.List<java.util.List<T>> combinations = org.dataalgorithms.util.Combination.findSortedCombinations(elements, n - 1);
		for (java.util.List<T> combination : combinations) {
			for (T element : elements) {
				if (combination.contains(element)) {
					continue;
				}
				java.util.List<T> list = new java.util.ArrayList<T>();
				list.addAll(combination);
				if (list.contains(element)) {
					continue;
				}
				list.add(element);
				java.util.Collections.sort(list);
				if (result.contains(list)) {
					continue;
				}
				result.add(list);
			}
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.String> elements = java.util.Arrays.asList("a", "b", "c", "d", "e");
		java.util.List<java.util.List<java.lang.String>> combinations = org.dataalgorithms.util.Combination.findSortedCombinations(elements, 2);
		java.lang.System.out.println(combinations);
	}
}