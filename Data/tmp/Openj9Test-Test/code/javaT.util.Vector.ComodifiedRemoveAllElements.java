public class ComodifiedRemoveAllElements {
	public static void main(java.lang.String[] args) {
		java.util.Vector v = new java.util.Vector();
		v.addElement(null);
		java.util.Iterator it = v.iterator();
		v.removeAllElements();
		try {
			it.next();
		} catch (java.util.ConcurrentModificationException cme) {
			return;
		}
		throw new java.lang.RuntimeException("Vector.RemoveAllElements() modCount increment failed.");
	}
}