public class LastKeyOfSubMap {
	private static final java.util.Comparator NULL_AT_END = new java.util.Comparator() {
		public int compare(java.lang.Object pObj1, java.lang.Object pObj2) {
			if ((pObj1 == null) && (pObj2 == null)) {
				return 0;
			}
			if ((pObj1 == null) && (pObj2 != null)) {
				return 1;
			}
			if ((pObj1 != null) && (pObj2 == null)) {
				return -1;
			}
			return ((java.lang.Comparable) (pObj1)).compareTo(pObj2);
		}
	};

	public static void main(java.lang.String[] pArgs) {
		java.util.SortedMap m1 = new java.util.TreeMap(jsr166tests.loops.LastKeyOfSubMap.NULL_AT_END);
		m1.put("a", "a");
		m1.put("b", "b");
		m1.put("c", "c");
		m1.put(null, "d");
		java.util.SortedMap m2 = new java.util.TreeMap(m1);
		java.lang.System.out.println(m1.lastKey());
		java.lang.System.out.println(m1.get(m1.lastKey()));
		java.lang.Object m1lk = m1.remove(m1.lastKey());
		if (m1lk == null) {
			throw new java.lang.Error("bad remove of last key");
		}
		m2 = m2.tailMap("b");
		java.lang.System.out.println(m2.lastKey());
		java.lang.System.out.println(m2.get(m2.lastKey()));
		java.lang.Object m2lk = m2.remove(m2.lastKey());
		if (m2lk == null) {
			throw new java.lang.Error("bad remove of last key");
		}
	}
}