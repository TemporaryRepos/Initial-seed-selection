public class TestCombination {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		org.dataalgorithms.util.TestCombination.test1();
		java.lang.System.out.println("==========");
		org.dataalgorithms.util.TestCombination.test2();
		java.lang.System.out.println("==========");
		org.dataalgorithms.util.TestCombination.test3();
		java.lang.System.out.println("==========");
		java.lang.System.exit(0);
	}

	public static void test3() throws java.lang.Exception {
		java.util.List<java.lang.String> list = java.util.Arrays.asList("a", "b", "c", "d");
		java.lang.System.out.println("list=" + list);
		java.lang.System.out.println("==========");
		java.util.List<java.util.List<java.lang.String>> comb = org.dataalgorithms.util.Combination.findSortedCombinations(list);
		java.lang.System.out.println(comb.size());
		java.lang.System.out.println(comb);
	}

	public static void test2() throws java.lang.Exception {
		java.util.List<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.String, java.lang.Integer>> list = new java.util.ArrayList<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.String, java.lang.Integer>>();
		list.add(new org.apache.commons.lang3.tuple.ImmutablePair<java.lang.String, java.lang.Integer>("d1", 1));
		list.add(new org.apache.commons.lang3.tuple.ImmutablePair<java.lang.String, java.lang.Integer>("d2", 1));
		list.add(new org.apache.commons.lang3.tuple.ImmutablePair<java.lang.String, java.lang.Integer>("d3", 1));
		java.util.List<java.util.List<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.String, java.lang.Integer>>> comb = org.dataalgorithms.util.Combination.findSortedCombinations(list, 2);
		java.lang.System.out.println(comb.size());
		java.lang.System.out.println(comb);
		for (java.util.List<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.String, java.lang.Integer>> l : comb) {
			java.lang.System.out.println(l);
		}
	}

	public static void test1() throws java.lang.Exception {
		java.util.List<java.lang.String> list = java.util.Arrays.asList("butter", "milk", "cracker");
		java.lang.System.out.println("list=" + list);
		java.util.List<java.util.List<java.lang.String>> comb2 = org.dataalgorithms.util.Combination.findSortedCombinations(list, 2);
		java.lang.System.out.println(comb2.size());
		java.lang.System.out.println(comb2);
		for (java.util.List<java.lang.String> l2 : comb2) {
			java.lang.System.out.println(l2);
		}
		java.lang.System.out.println("==========");
		java.util.List<java.util.List<java.lang.String>> comb = org.dataalgorithms.util.Combination.findSortedCombinations(list);
		java.lang.System.out.println(comb.size());
		java.lang.System.out.println(comb);
	}
}