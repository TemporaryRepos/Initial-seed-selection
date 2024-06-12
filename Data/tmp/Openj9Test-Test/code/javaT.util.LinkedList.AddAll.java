public class AddAll {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.List head = java.util.Collections.nCopies(7, "deadly sin");
		java.util.List tail = java.util.Collections.nCopies(4, "basic food group");
		java.util.List l1 = new java.util.ArrayList(head);
		java.util.List l2 = new java.util.LinkedList(head);
		l1.addAll(tail);
		l2.addAll(tail);
		if (!l1.equals(l2)) {
			throw new java.lang.RuntimeException("addAll is broken.");
		}
	}
}