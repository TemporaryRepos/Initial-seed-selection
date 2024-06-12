public class FailFastIterator {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.List orig = new java.util.ArrayList(100);
		for (int i = 0; i < 100; i++) {
			orig.add(new java.lang.Integer(i));
		}
		java.util.List copy = new java.util.ArrayList(orig);
		try {
			java.util.ListIterator i = copy.listIterator();
			i.next();
			copy.remove(99);
			copy.add(new java.lang.Integer(99));
			i.remove();
			throw new java.lang.Exception("remove: iterator didn't fail fast");
		} catch (java.util.ConcurrentModificationException e) {
		}
		if (!copy.equals(orig)) {
			throw new java.lang.Exception("remove: iterator didn't fail fast enough");
		}
		try {
			java.util.ListIterator i = copy.listIterator();
			i.next();
			copy.remove(99);
			copy.add(new java.lang.Integer(99));
			i.set(new java.lang.Integer(666));
			throw new java.lang.Exception("set: iterator didn't fail fast");
		} catch (java.util.ConcurrentModificationException e) {
		}
		if (!copy.equals(orig)) {
			throw new java.lang.Exception("set: iterator didn't fail fast enough");
		}
		try {
			java.util.ListIterator i = copy.listIterator();
			copy.remove(99);
			copy.add(new java.lang.Integer(99));
			i.add(new java.lang.Integer(666));
			throw new java.lang.Exception("add: iterator didn't fail fast");
		} catch (java.util.ConcurrentModificationException e) {
		}
		if (!copy.equals(orig)) {
			throw new java.lang.Exception("add: iterator didn't fail fast enough");
		}
	}
}