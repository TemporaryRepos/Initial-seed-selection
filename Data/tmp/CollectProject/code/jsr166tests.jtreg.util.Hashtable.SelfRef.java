public class SelfRef {
	public static void main(java.lang.String[] args) {
		jsr166tests.jtreg.util.Hashtable.SelfRef.testMap(new java.util.Hashtable<java.lang.Object, java.lang.Object>());
		jsr166tests.jtreg.util.Hashtable.SelfRef.testMap(new java.util.HashMap<java.lang.Object, java.lang.Object>());
		jsr166tests.jtreg.util.Hashtable.SelfRef.testMap(new java.util.LinkedHashMap<java.lang.Object, java.lang.Object>());
		jsr166tests.jtreg.util.Hashtable.SelfRef.testMap(new java.util.concurrent.ConcurrentHashMap<java.lang.Object, java.lang.Object>());
	}

	private static void testMap(java.util.Map<java.lang.Object, java.lang.Object> m) {
		if (!m.toString().equals("{}")) {
			throw new java.lang.Error();
		}
		m.put("Harvey", m);
		if (!m.toString().equals("{Harvey=(this Map)}")) {
			throw new java.lang.Error();
		}
		m.clear();
		m.put(m, "Harvey");
		if (!m.toString().equals("{(this Map)=Harvey}")) {
			throw new java.lang.Error();
		}
		m.clear();
		m.hashCode();
	}
}