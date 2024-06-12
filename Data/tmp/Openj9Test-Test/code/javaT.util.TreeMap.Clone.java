public class Clone {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.TreeMap<java.lang.String, java.lang.Object> m1 = new java.util.TreeMap<java.lang.String, java.lang.Object>();
		m1.put("one", 1);
		m1.keySet();
		java.util.TreeMap<java.lang.String, java.lang.Object> m2 = ((java.util.TreeMap<java.lang.String, java.lang.Object>) (m1.clone()));
		m1.put("two", 2);
		m2.put("three", 3);
		for (final java.lang.String key : m2.keySet()) {
			if ((!"one".equals(key)) && (!"three".equals(key))) {
				throw new java.lang.IllegalStateException("Unexpected key: " + key);
			}
		}
		for (final java.lang.String key : m1.keySet()) {
			if ((!"one".equals(key)) && (!"two".equals(key))) {
				throw new java.lang.IllegalStateException("Unexpected key: " + key);
			}
		}
	}
}