public class ReplaceExisting {
	private static int ENTRIES = 13;

	public static void main(java.lang.String[] args) {
		for (int i = 0; i <= javaT.util.HashMap.ReplaceExisting.ENTRIES; i++) {
			java.util.HashMap<java.lang.Integer, java.lang.Integer> hm = javaT.util.HashMap.ReplaceExisting.prepHashMap();
			javaT.util.HashMap.ReplaceExisting.testItr(hm, i);
		}
	}

	private static java.util.HashMap<java.lang.Integer, java.lang.Integer> prepHashMap() {
		java.util.HashMap<java.lang.Integer, java.lang.Integer> hm = new java.util.HashMap<>(16, 0.75F);
		for (int i = 0; i < javaT.util.HashMap.ReplaceExisting.ENTRIES; i++) {
			hm.put(i * 10, i * 10);
		}
		return hm;
	}

	private static void testItr(java.util.HashMap<java.lang.Integer, java.lang.Integer> hm, int elemBeforePut) {
		if (elemBeforePut > hm.size()) {
			throw new java.lang.IllegalArgumentException("Error in test: elemBeforePut must be <= HashMap size");
		}
		java.util.HashSet<java.lang.Integer> keys = new java.util.HashSet<>(hm.size());
		keys.addAll(hm.keySet());
		java.util.HashSet<java.lang.Integer> collected = new java.util.HashSet<>(hm.size());
		java.util.Iterator<java.lang.Integer> itr = hm.keySet().iterator();
		for (int i = 0; i < elemBeforePut; i++) {
			java.lang.Integer retVal = itr.next();
			if (!collected.add(retVal)) {
				throw new java.lang.RuntimeException(("Corrupt iterator: key " + retVal) + " already encountered");
			}
		}
		if (null == hm.put(0, 100)) {
			throw new java.lang.RuntimeException("Error in test: expected key 0 to be in the HashMap");
		}
		while (itr.hasNext()) {
			java.lang.Integer retVal = itr.next();
			if (!collected.add(retVal)) {
				throw new java.lang.RuntimeException(("Corrupt iterator: key " + retVal) + " already encountered");
			}
		} 
		if (!keys.equals(collected)) {
			throw new java.lang.RuntimeException("Collected keys do not match original set of keys");
		}
	}
}