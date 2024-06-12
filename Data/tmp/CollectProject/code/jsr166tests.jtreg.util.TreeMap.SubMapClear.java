public class SubMapClear {
	public static void main(java.lang.String[] args) {
		java.util.SortedSet treeSet = new java.util.TreeSet();
		for (int i = 1; i <= 10; i++) {
			treeSet.add(new java.lang.Integer(i));
		}
		java.util.Set subSet = treeSet.subSet(new java.lang.Integer(4), new java.lang.Integer(10));
		subSet.clear();
		int[] a = new int[]{ 1, 2, 3, 10 };
		java.util.Set s = new java.util.TreeSet();
		for (int i = 0; i < a.length; i++) {
			s.add(new java.lang.Integer(a[i]));
		}
		if (!treeSet.equals(s)) {
			throw new java.lang.RuntimeException(treeSet.toString());
		}
	}
}