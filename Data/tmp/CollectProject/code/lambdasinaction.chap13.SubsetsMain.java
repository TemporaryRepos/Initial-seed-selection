public class SubsetsMain {
	public static void main(java.lang.String[] args) {
		java.util.List<java.util.List<java.lang.Integer>> subs = lambdasinaction.chap13.SubsetsMain.subsets(java.util.Arrays.asList(1, 4, 9));
		subs.forEach(java.lang.System.out::println);
	}

	public static java.util.List<java.util.List<java.lang.Integer>> subsets(java.util.List<java.lang.Integer> l) {
		if (l.isEmpty()) {
			java.util.List<java.util.List<java.lang.Integer>> ans = new java.util.ArrayList<>();
			ans.add(java.util.Collections.emptyList());
			return ans;
		}
		java.lang.Integer first = l.get(0);
		java.util.List<java.lang.Integer> rest = l.subList(1, l.size());
		java.util.List<java.util.List<java.lang.Integer>> subans = lambdasinaction.chap13.SubsetsMain.subsets(rest);
		java.util.List<java.util.List<java.lang.Integer>> subans2 = lambdasinaction.chap13.SubsetsMain.insertAll(first, subans);
		return lambdasinaction.chap13.SubsetsMain.concat(subans, subans2);
	}

	public static java.util.List<java.util.List<java.lang.Integer>> insertAll(java.lang.Integer first, java.util.List<java.util.List<java.lang.Integer>> lists) {
		java.util.List<java.util.List<java.lang.Integer>> result = new java.util.ArrayList<>();
		for (java.util.List<java.lang.Integer> l : lists) {
			java.util.List<java.lang.Integer> copyList = new java.util.ArrayList<>();
			copyList.add(first);
			copyList.addAll(l);
			result.add(copyList);
		}
		return result;
	}

	static java.util.List<java.util.List<java.lang.Integer>> concat(java.util.List<java.util.List<java.lang.Integer>> a, java.util.List<java.util.List<java.lang.Integer>> b) {
		java.util.List<java.util.List<java.lang.Integer>> r = new java.util.ArrayList<>(a);
		r.addAll(b);
		return r;
	}
}