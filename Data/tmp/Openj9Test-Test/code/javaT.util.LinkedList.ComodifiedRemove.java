public class ComodifiedRemove {
	public static void main(java.lang.String[] args) {
		java.util.List list = new java.util.LinkedList();
		java.lang.Object o1 = new java.lang.Integer(1);
		list.add(o1);
		java.util.ListIterator e = list.listIterator();
		e.next();
		java.lang.Object o2 = new java.lang.Integer(2);
		list.add(o2);
		try {
			e.remove();
		} catch (java.util.ConcurrentModificationException cme) {
			return;
		}
		throw new java.lang.RuntimeException("LinkedList ListIterator.remove() comodification check failed.");
	}
}