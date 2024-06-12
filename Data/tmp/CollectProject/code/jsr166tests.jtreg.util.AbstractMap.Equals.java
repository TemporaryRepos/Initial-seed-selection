public class Equals {
	public static void main(java.lang.String[] args) {
		java.util.Map m = new java.util.HashMap();
		m.put(null, "");
		java.util.Map h = new java.util.Hashtable();
		h.put("", "");
		if (m.equals(h)) {
			throw new java.lang.RuntimeException("1");
		}
		java.util.Map m1 = new java.util.TreeMap();
		m1.put(new java.lang.Integer(42), "The Answer");
		java.util.Map m2 = new java.util.TreeMap();
		m2.put("The Answer", new java.lang.Integer(42));
		if (m1.equals(m2)) {
			throw new java.lang.RuntimeException("3");
		}
		java.util.Set s1 = new java.util.TreeSet();
		s1.add(new java.lang.Integer(666));
		java.util.Set s2 = new java.util.TreeSet();
		s2.add("Great googly moogly!");
		if (s1.equals(s2)) {
			throw new java.lang.RuntimeException("2");
		}
	}
}