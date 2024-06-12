public class ToArray {
	public static void main(java.lang.String[] args) {
		java.util.Map<java.lang.String, java.lang.String> mm = new java.util.IdentityHashMap<java.lang.String, java.lang.String>();
		mm.put("foo", "bar");
		mm.put("baz", "quux");
		java.util.List<java.util.Map.Entry<java.lang.String, java.lang.String>> lm = new java.util.ArrayList<java.util.Map.Entry<java.lang.String, java.lang.String>>(mm.entrySet());
		java.lang.String s = lm.toString();
		if (!(s.equals("[foo=bar, baz=quux]") || s.equals("[baz=quux, foo=bar]"))) {
			throw new java.lang.Error("bad string");
		}
		java.util.Map m = new java.util.IdentityHashMap();
		m.put("french", "connection");
		m.put("polish", "sausage");
		java.lang.Object[] mArray = m.entrySet().toArray();
		if (mArray[0] == mArray[1]) {
			throw new java.lang.RuntimeException("Broken");
		}
		mArray[0].toString();
		mArray[1].toString();
		java.util.IdentityHashMap<java.lang.Integer, java.lang.Integer> map = new java.util.IdentityHashMap<java.lang.Integer, java.lang.Integer>();
		java.util.Set<java.util.Map.Entry<java.lang.Integer, java.lang.Integer>> es = map.entrySet();
		if (es.toArray().length != 0) {
			throw new java.lang.Error("non-empty");
		}
		if (es.toArray(new java.lang.Object[]{ java.lang.Boolean.TRUE })[0] != null) {
			throw new java.lang.Error("non-null");
		}
		map.put(7, 49);
		if (es.toArray().length != 1) {
			throw new java.lang.Error("length");
		}
		java.lang.Object[] x = es.toArray(new java.lang.Object[]{ java.lang.Boolean.TRUE, java.lang.Boolean.TRUE });
		if (x[1] != null) {
			throw new java.lang.Error("non-null");
		}
		java.util.Map.Entry e = ((java.util.Map.Entry) (x[0]));
		if (!e.getKey().equals(new java.lang.Integer(7))) {
			throw new java.lang.Error("bad key");
		}
		if (!e.getValue().equals(new java.lang.Integer(49))) {
			throw new java.lang.Error("bad value");
		}
	}
}