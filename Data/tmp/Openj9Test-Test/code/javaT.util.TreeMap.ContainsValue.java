public class ContainsValue {
	public static void main(java.lang.String[] args) {
		java.util.Map map = new java.util.TreeMap();
		if (map.containsValue("gemutlichkeit")) {
			throw new java.lang.RuntimeException("containsValue optimistic (non-null)");
		}
		if (map.containsValue(null)) {
			throw new java.lang.RuntimeException("containsValue optimistic (null)");
		}
		map.put("a", null);
		map.put("b", "gemutlichkeit");
		if (!map.containsValue("gemutlichkeit")) {
			throw new java.lang.RuntimeException("containsValue pessimistic (non-null)");
		}
		if (!map.containsValue(null)) {
			throw new java.lang.RuntimeException("containsValue pessimistic (null)");
		}
	}
}