public class ReplaceAll {
	static final int SIZE = 20;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.List[] a = new java.util.List[]{ new java.util.ArrayList(), new java.util.LinkedList(), new java.util.Vector() };
		for (int i = 0; i < a.length; i++) {
			java.util.List lst = a[i];
			for (int j = 1; j <= javaT.util.Collections.ReplaceAll.SIZE; j++) {
				lst.add(new java.lang.Integer(j % 3));
			}
			java.util.List goal = java.util.Collections.nCopies(javaT.util.Collections.ReplaceAll.SIZE, "*");
			for (int j = 0; j < 3; j++) {
				java.util.List before = new java.util.ArrayList(lst);
				if (!java.util.Collections.replaceAll(lst, new java.lang.Integer(j), "*")) {
					throw new java.lang.Exception((("False return value: " + i) + ", ") + j);
				}
				if (lst.equals(before)) {
					throw new java.lang.Exception(((((("Unchanged: " + i) + ", ") + j) + ", ") + ": ") + lst);
				}
				if (lst.equals(goal) != (j == 2)) {
					throw new java.lang.Exception((("Wrong change:" + i) + ", ") + j);
				}
			}
			if (java.util.Collections.replaceAll(lst, "love", "hate")) {
				throw new java.lang.Exception("True return value: " + i);
			}
		}
	}
}