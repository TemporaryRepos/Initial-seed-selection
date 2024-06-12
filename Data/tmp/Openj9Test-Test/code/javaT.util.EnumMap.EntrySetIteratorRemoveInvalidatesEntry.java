public class EntrySetIteratorRemoveInvalidatesEntry {
	static enum TestEnum {

		e00,
		e01,
		e02;}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		final java.util.EnumMap<javaT.util.EnumMap.EntrySetIteratorRemoveInvalidatesEntry.TestEnum, java.lang.String> enumMap = new java.util.EnumMap<>(javaT.util.EnumMap.EntrySetIteratorRemoveInvalidatesEntry.TestEnum.class);
		for (javaT.util.EnumMap.EntrySetIteratorRemoveInvalidatesEntry.TestEnum e : javaT.util.EnumMap.EntrySetIteratorRemoveInvalidatesEntry.TestEnum.values()) {
			enumMap.put(e, e.name());
		}
		java.util.Iterator<java.util.Map.Entry<javaT.util.EnumMap.EntrySetIteratorRemoveInvalidatesEntry.TestEnum, java.lang.String>> entrySetIterator = enumMap.entrySet().iterator();
		java.util.Map.Entry<javaT.util.EnumMap.EntrySetIteratorRemoveInvalidatesEntry.TestEnum, java.lang.String> entry = entrySetIterator.next();
		entrySetIterator.remove();
		try {
			entry.getKey();
			throw new java.lang.RuntimeException("Test FAILED: Entry not invalidated by removal.");
		} catch (java.lang.Exception e) {
		}
	}
}