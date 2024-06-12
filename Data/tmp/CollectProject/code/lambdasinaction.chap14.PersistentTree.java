public class PersistentTree {
	public static void main(java.lang.String[] args) {
		lambdasinaction.chap14.PersistentTree.Tree t = new lambdasinaction.chap14.PersistentTree.Tree("Mary", 22, new lambdasinaction.chap14.PersistentTree.Tree("Emily", 20, new lambdasinaction.chap14.PersistentTree.Tree("Alan", 50, null, null), new lambdasinaction.chap14.PersistentTree.Tree("Georgie", 23, null, null)), new lambdasinaction.chap14.PersistentTree.Tree("Tian", 29, new lambdasinaction.chap14.PersistentTree.Tree("Raoul", 23, null, null), null));
		java.lang.System.out.println(lambdasinaction.chap14.PersistentTree.lookup("Raoul", -1, t));
		java.lang.System.out.println(lambdasinaction.chap14.PersistentTree.lookup("Jeff", -1, t));
		lambdasinaction.chap14.PersistentTree.Tree f = lambdasinaction.chap14.PersistentTree.fupdate("Jeff", 80, t);
		java.lang.System.out.println(lambdasinaction.chap14.PersistentTree.lookup("Jeff", -1, f));
		lambdasinaction.chap14.PersistentTree.Tree u = lambdasinaction.chap14.PersistentTree.update("Jim", 40, t);
		java.lang.System.out.println(lambdasinaction.chap14.PersistentTree.lookup("Jeff", -1, u));
		java.lang.System.out.println(lambdasinaction.chap14.PersistentTree.lookup("Jim", -1, u));
		lambdasinaction.chap14.PersistentTree.Tree f2 = lambdasinaction.chap14.PersistentTree.fupdate("Jeff", 80, t);
		java.lang.System.out.println(lambdasinaction.chap14.PersistentTree.lookup("Jeff", -1, f2));
		java.lang.System.out.println(lambdasinaction.chap14.PersistentTree.lookup("Jim", -1, f2));
	}

	static class Tree {
		private java.lang.String key;

		private int val;

		private lambdasinaction.chap14.PersistentTree.Tree left;

		private lambdasinaction.chap14.PersistentTree.Tree right;

		public Tree(java.lang.String k, int v, lambdasinaction.chap14.PersistentTree.Tree l, lambdasinaction.chap14.PersistentTree.Tree r) {
			key = k;
			val = v;
			left = l;
			right = r;
		}
	}

	public static int lookup(java.lang.String k, int defaultval, lambdasinaction.chap14.PersistentTree.Tree t) {
		if (t == null) {
			return defaultval;
		}
		if (k.equals(t.key)) {
			return t.val;
		}
		return lambdasinaction.chap14.PersistentTree.lookup(k, defaultval, k.compareTo(t.key) < 0 ? t.left : t.right);
	}

	public static lambdasinaction.chap14.PersistentTree.Tree update(java.lang.String k, int newval, lambdasinaction.chap14.PersistentTree.Tree t) {
		if (t == null) {
			t = new lambdasinaction.chap14.PersistentTree.Tree(k, newval, null, null);
		} else if (k.equals(t.key)) {
			t.val = newval;
		} else if (k.compareTo(t.key) < 0) {
			t.left = lambdasinaction.chap14.PersistentTree.update(k, newval, t.left);
		} else {
			t.right = lambdasinaction.chap14.PersistentTree.update(k, newval, t.right);
		}
		return t;
	}

	public static lambdasinaction.chap14.PersistentTree.Tree fupdate(java.lang.String k, int newval, lambdasinaction.chap14.PersistentTree.Tree t) {
		return t == null ? new lambdasinaction.chap14.PersistentTree.Tree(k, newval, null, null) : k.equals(t.key) ? new lambdasinaction.chap14.PersistentTree.Tree(k, newval, t.left, t.right) : k.compareTo(t.key) < 0 ? new lambdasinaction.chap14.PersistentTree.Tree(t.key, t.val, lambdasinaction.chap14.PersistentTree.fupdate(k, newval, t.left), t.right) : new lambdasinaction.chap14.PersistentTree.Tree(t.key, t.val, t.left, lambdasinaction.chap14.PersistentTree.fupdate(k, newval, t.right));
	}
}