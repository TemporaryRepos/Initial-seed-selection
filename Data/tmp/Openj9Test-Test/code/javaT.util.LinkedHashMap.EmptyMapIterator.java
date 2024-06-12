public class EmptyMapIterator {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.HashMap map = new java.util.HashMap();
		java.util.Iterator iter = iter = map.entrySet().iterator();
		map.put("key", "value");
		try {
			iter.next();
			throw new java.lang.Exception("No exception thrown");
		} catch (java.util.ConcurrentModificationException e) {
		}
	}
}