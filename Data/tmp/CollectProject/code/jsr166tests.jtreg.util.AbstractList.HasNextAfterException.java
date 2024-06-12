public class HasNextAfterException {
	public static void main(java.lang.String[] args) {
		java.util.List list = new java.util.ArrayList();
		java.util.ListIterator i = list.listIterator();
		try {
			i.previous();
		} catch (java.util.NoSuchElementException e) {
		}
		if (i.hasNext()) {
			throw new java.lang.RuntimeException("ListIterator.hasNext() returns true for an empty " + "List after ListIterator.previous().");
		}
	}
}