public class ViewSynch {
	static final java.lang.Integer ZERO = new java.lang.Integer(0);

	static final javaT.util.Collections.Int INT_ZERO = new javaT.util.Collections.Int(0);

	static final javaT.util.Collections.Int INT_ONE = new javaT.util.Collections.Int(1);

	static java.util.SortedMap m = java.util.Collections.synchronizedSortedMap(new java.util.TreeMap());

	static java.util.Map m2 = javaT.util.Collections.ViewSynch.m.tailMap(javaT.util.Collections.ViewSynch.ZERO);

	static java.util.Collection c = javaT.util.Collections.ViewSynch.m2.values();

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 10000; i++) {
			javaT.util.Collections.ViewSynch.m.put(new java.lang.Integer(i), javaT.util.Collections.ViewSynch.INT_ZERO);
		}
		new java.lang.Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					java.lang.Thread.yield();
					javaT.util.Collections.ViewSynch.m.remove(javaT.util.Collections.ViewSynch.ZERO);
					javaT.util.Collections.ViewSynch.m.put(javaT.util.Collections.ViewSynch.ZERO, javaT.util.Collections.ViewSynch.INT_ZERO);
				}
			}
		}.start();
		javaT.util.Collections.ViewSynch.c.contains(javaT.util.Collections.ViewSynch.INT_ONE);
	}
}