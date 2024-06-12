public class SubMap {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.SortedMap m = new java.util.TreeMap();
		m.put(new java.lang.Integer(1), new java.lang.Integer(1));
		m.put(new java.lang.Integer(2), new java.lang.Integer(2));
		m.put(new java.lang.Integer(3), new java.lang.Integer(3));
		java.util.SortedMap m2 = m.subMap(new java.lang.Integer(2), new java.lang.Integer(2));
		boolean exc = false;
		try {
			m2.firstKey();
		} catch (java.util.NoSuchElementException e) {
			exc = true;
		}
		if (!exc) {
			throw new java.lang.Exception("first key");
		}
		exc = false;
		try {
			m2.lastKey();
		} catch (java.util.NoSuchElementException e) {
			exc = true;
		}
		if (!exc) {
			throw new java.lang.Exception("last key");
		}
		java.util.SortedMap m3 = m.subMap(new java.lang.Integer(2), new java.lang.Integer(3));
		if (!m3.firstKey().equals(new java.lang.Integer(2))) {
			throw new java.lang.Exception("first key wrong");
		}
		if (!m3.lastKey().equals(new java.lang.Integer(2))) {
			throw new java.lang.Exception("last key wrong");
		}
		java.util.SortedSet s = new java.util.TreeSet();
		s.add(new java.lang.Integer(1));
		s.add(new java.lang.Integer(2));
		s.add(new java.lang.Integer(3));
		java.util.SortedSet s2 = s.subSet(new java.lang.Integer(2), new java.lang.Integer(2));
		exc = false;
		try {
			s2.first();
		} catch (java.util.NoSuchElementException e) {
			exc = true;
		}
		if (!exc) {
			throw new java.lang.Exception("first element");
		}
		exc = false;
		try {
			s2.last();
		} catch (java.util.NoSuchElementException e) {
			exc = true;
		}
		if (!exc) {
			throw new java.lang.Exception("last element");
		}
		java.util.SortedSet s3 = s.subSet(new java.lang.Integer(2), new java.lang.Integer(3));
		if (!s3.first().equals(new java.lang.Integer(2))) {
			throw new java.lang.Exception("first element wrong");
		}
		if (!s3.last().equals(new java.lang.Integer(2))) {
			throw new java.lang.Exception("last element wrong");
		}
	}
}