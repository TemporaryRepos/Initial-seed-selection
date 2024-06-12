public class NullComparator {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.List list = new java.util.ArrayList(100);
		for (int i = 0; i < 100; i++) {
			list.add(new java.lang.Integer(i));
		}
		java.util.List sorted = new java.util.ArrayList(list);
		java.util.Collections.shuffle(list);
		java.lang.Object[] a = list.toArray();
		java.util.Arrays.sort(a, null);
		if (!java.util.Arrays.asList(a).equals(sorted)) {
			throw new java.lang.Exception("Arrays.sort");
		}
		a = list.toArray();
		java.util.Arrays.sort(a, 0, 100, null);
		if (!java.util.Arrays.asList(a).equals(sorted)) {
			throw new java.lang.Exception("Arrays.sort(from, to)");
		}
		if (java.util.Arrays.binarySearch(a, new java.lang.Integer(69)) != 69) {
			throw new java.lang.Exception("Arrays.binarySearch");
		}
		java.util.List tmp = new java.util.ArrayList(list);
		java.util.Collections.sort(tmp, null);
		if (!tmp.equals(sorted)) {
			throw new java.lang.Exception("Collections.sort");
		}
		if (java.util.Collections.binarySearch(tmp, new java.lang.Integer(69)) != 69) {
			throw new java.lang.Exception("Collections.binarySearch");
		}
		if (!java.util.Collections.min(list, null).equals(new java.lang.Integer(0))) {
			throw new java.lang.Exception("Collections.min");
		}
		if (!java.util.Collections.max(list, null).equals(new java.lang.Integer(99))) {
			throw new java.lang.Exception("Collections.max");
		}
	}
}