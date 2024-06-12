public class Remove {
	public static void main(java.lang.String[] args) {
		java.util.LinkedList list = new java.util.LinkedList();
		java.util.ListIterator e = list.listIterator();
		java.lang.Object o = new java.lang.Integer(1);
		e.add(o);
		e.previous();
		e.next();
		e.remove();
		e.add(o);
		if (!o.equals(list.get(0))) {
			throw new java.lang.RuntimeException("LinkedList ListIterator remove failed.");
		}
	}
}