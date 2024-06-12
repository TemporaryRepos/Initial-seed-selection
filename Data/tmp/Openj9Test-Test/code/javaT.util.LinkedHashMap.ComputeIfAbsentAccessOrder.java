public class ComputeIfAbsentAccessOrder {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> map = new java.util.LinkedHashMap<>(2, 0.75F, true);
		map.put("first", null);
		map.put("second", null);
		map.computeIfAbsent("first", ( l) -> null);
		java.lang.String key = map.keySet().stream().findFirst().orElseThrow(() -> new java.lang.RuntimeException("no value"));
		if (!"first".equals(key)) {
			throw new java.lang.RuntimeException(("not expected value " + ("first" + "!=")) + key);
		}
	}
}