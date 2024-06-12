public class AbstractMapClone extends java.util.AbstractMap implements java.lang.Cloneable {
	private java.util.Map map = new java.util.HashMap();

	public java.util.Set entrySet() {
		return map.entrySet();
	}

	public java.lang.Object put(java.lang.Object key, java.lang.Object value) {
		return map.put(key, value);
	}

	public java.lang.Object clone() {
		jsr166tests.jtreg.util.AbstractMap.AbstractMapClone clone = null;
		try {
			clone = ((jsr166tests.jtreg.util.AbstractMap.AbstractMapClone) (super.clone()));
		} catch (java.lang.CloneNotSupportedException e) {
		}
		clone.map = ((java.util.Map) (((java.util.HashMap) (map)).clone()));
		return clone;
	}

	public static void main(java.lang.String[] args) {
		jsr166tests.jtreg.util.AbstractMap.AbstractMapClone m1 = new jsr166tests.jtreg.util.AbstractMap.AbstractMapClone();
		m1.put("1", "1");
		java.util.Set k1 = m1.keySet();
		jsr166tests.jtreg.util.AbstractMap.AbstractMapClone m2 = ((jsr166tests.jtreg.util.AbstractMap.AbstractMapClone) (m1.clone()));
		java.util.Set k2 = m2.keySet();
		m2.put("2", "2");
		if (k1.equals(k2)) {
			throw new java.lang.RuntimeException("AbstractMap.clone() failed.");
		}
	}
}