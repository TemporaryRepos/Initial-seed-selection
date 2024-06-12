public class Iteration {
	public static void main(java.lang.String[] args) {
		java.lang.String s = "iatrogenic";
		java.util.Map m = new java.util.WeakHashMap();
		m.put(s, "cucumber");
		java.util.Iterator i = m.keySet().iterator();
		if (i.hasNext() != i.hasNext()) {
			throw new java.lang.RuntimeException("hasNext advances iterator");
		}
	}
}