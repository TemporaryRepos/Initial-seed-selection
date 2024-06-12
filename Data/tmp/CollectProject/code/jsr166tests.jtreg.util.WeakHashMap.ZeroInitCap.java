public class ZeroInitCap {
	public static void main(java.lang.String[] argv) {
		java.util.Map map = new java.util.WeakHashMap(0);
		map.put("a", "b");
	}
}