public class Cache {
	private static final int MAP_SIZE = 10;

	private static final int NUM_KEYS = 100;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Map m = new java.util.LinkedHashMap() {
			protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
				return size() > javaT.util.LinkedHashMap.Cache.MAP_SIZE;
			}
		};
		for (int i = 0; i < javaT.util.LinkedHashMap.Cache.NUM_KEYS; i++) {
			m.put(new java.lang.Integer(i), "");
			int eldest = ((java.lang.Integer) (m.keySet().iterator().next())).intValue();
			if (eldest != java.lang.Math.max(i - 9, 0)) {
				throw new java.lang.RuntimeException((("i = " + i) + ", eldest = ") + eldest);
			}
		}
	}
}