public class HeadTailTypeError {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		try {
			java.util.SortedMap m = new java.util.TreeMap();
			m.headMap(new java.lang.Object());
			throw new java.lang.Exception("headMap, natural ordering");
		} catch (java.lang.ClassCastException e) {
		}
		try {
			java.util.SortedMap m = new java.util.TreeMap();
			m.tailMap(new java.lang.Object());
			throw new java.lang.Exception("tailMap, natural ordering");
		} catch (java.lang.ClassCastException e) {
		}
		try {
			java.util.SortedMap m = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
			m.headMap(new java.lang.Integer(0));
			throw new java.lang.Exception("headMap, explicit comparator");
		} catch (java.lang.ClassCastException e) {
		}
		try {
			java.util.SortedMap m = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
			m.tailMap(new java.lang.Integer(0));
			throw new java.lang.Exception("tailMap, explicit comparator");
		} catch (java.lang.ClassCastException e) {
		}
		try {
			java.util.SortedSet m = new java.util.TreeSet();
			m.headSet(new java.lang.Object());
			throw new java.lang.Exception("headSet, natural ordering");
		} catch (java.lang.ClassCastException e) {
		}
		try {
			java.util.SortedSet m = new java.util.TreeSet();
			m.tailSet(new java.lang.Object());
			throw new java.lang.Exception("tailSet, natural ordering");
		} catch (java.lang.ClassCastException e) {
		}
		try {
			java.util.SortedSet m = new java.util.TreeSet(java.lang.String.CASE_INSENSITIVE_ORDER);
			m.headSet(new java.lang.Integer(0));
			throw new java.lang.Exception("headSet, explicit comparator");
		} catch (java.lang.ClassCastException e) {
		}
		try {
			java.util.SortedSet m = new java.util.TreeSet(java.lang.String.CASE_INSENSITIVE_ORDER);
			m.tailSet(new java.lang.Integer(0));
			throw new java.lang.Exception("tailSet, explicit comparator");
		} catch (java.lang.ClassCastException e) {
		}
		try {
			java.util.SortedMap m = new java.util.TreeMap();
			m.headMap(null);
			throw new java.lang.Exception("(null endpoint)headMap, natural ordering");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			java.util.SortedMap m = new java.util.TreeMap();
			m.tailMap(null);
			throw new java.lang.Exception("(null endpoint)tailMap, natural ordering");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			java.util.SortedMap m = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
			m.headMap(null);
			throw new java.lang.Exception("(null endpoint)headMap, explicit comparator");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			java.util.SortedMap m = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
			m.tailMap(null);
			throw new java.lang.Exception("(null endpoint)tailMap, explicit comparator");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			java.util.SortedSet m = new java.util.TreeSet();
			m.headSet(null);
			throw new java.lang.Exception("(null endpoint)headSet, natural ordering");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			java.util.SortedSet m = new java.util.TreeSet();
			m.tailSet(null);
			throw new java.lang.Exception("(null endpoint)tailSet, natural ordering");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			java.util.SortedSet m = new java.util.TreeSet(java.lang.String.CASE_INSENSITIVE_ORDER);
			m.headSet(null);
			throw new java.lang.Exception("(null endpoint)headSet, explicit comparator");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			java.util.SortedSet m = new java.util.TreeSet(java.lang.String.CASE_INSENSITIVE_ORDER);
			m.tailSet(null);
			throw new java.lang.Exception("(null endpoint)tailSet, explicit comparator");
		} catch (java.lang.NullPointerException e) {
		}
		java.util.SortedMap m = new java.util.TreeMap();
		m.headMap(new java.lang.Integer(0));
		m.tailMap(new java.lang.Integer(0));
		m = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
		m.headMap("llama");
		m.tailMap("llama");
		java.util.SortedSet s = new java.util.TreeSet();
		s.headSet(new java.lang.Integer(0));
		s.tailSet(new java.lang.Integer(0));
		s = new java.util.TreeSet(java.lang.String.CASE_INSENSITIVE_ORDER);
		s.headSet("drama");
		s.tailSet("drama");
	}
}