public class KeySetRemove {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Map[] m = new java.util.Map[]{ new java.util.HashMap(), new java.util.TreeMap() };
		for (int i = 0; i < m.length; i++) {
			m[i].put("bananas", null);
			if (!m[i].keySet().remove("bananas")) {
				throw new java.lang.Exception("Yes, we have no bananas: " + i);
			}
		}
	}
}