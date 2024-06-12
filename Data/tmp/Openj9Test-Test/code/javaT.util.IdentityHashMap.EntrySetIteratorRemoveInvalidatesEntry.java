public class EntrySetIteratorRemoveInvalidatesEntry {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		final java.util.IdentityHashMap<java.lang.String, java.lang.String> identityHashMap = new java.util.IdentityHashMap<>();
		identityHashMap.put("One", "Un");
		identityHashMap.put("Two", "Deux");
		identityHashMap.put("Three", "Trois");
		java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> entrySetIterator = identityHashMap.entrySet().iterator();
		java.util.Map.Entry<java.lang.String, java.lang.String> entry = entrySetIterator.next();
		entrySetIterator.remove();
		try {
			entry.getKey();
			throw new java.lang.RuntimeException("Test FAILED: Entry not invalidated by removal.");
		} catch (java.lang.Exception e) {
		}
	}
}