public class ViewSynch {
	static final java.lang.Integer ZERO = new java.lang.Integer(0);

	static final jsr166tests.jtreg.util.Collections.Int INT_ZERO = new jsr166tests.jtreg.util.Collections.Int(0);

	static final jsr166tests.jtreg.util.Collections.Int INT_ONE = new jsr166tests.jtreg.util.Collections.Int(1);

	static java.util.SortedMap m = java.util.Collections.synchronizedSortedMap(new java.util.TreeMap());

	static java.util.Map m2 = jsr166tests.jtreg.util.Collections.ViewSynch.m.tailMap(jsr166tests.jtreg.util.Collections.ViewSynch.ZERO);

	static java.util.Collection c = jsr166tests.jtreg.util.Collections.ViewSynch.m2.values();

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 10000; i++) {
			jsr166tests.jtreg.util.Collections.ViewSynch.m.put(new java.lang.Integer(i), jsr166tests.jtreg.util.Collections.ViewSynch.INT_ZERO);
		}
		new java.lang.Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					java.lang.Thread.yield();
					jsr166tests.jtreg.util.Collections.ViewSynch.m.remove(jsr166tests.jtreg.util.Collections.ViewSynch.ZERO);
					jsr166tests.jtreg.util.Collections.ViewSynch.m.put(jsr166tests.jtreg.util.Collections.ViewSynch.ZERO, jsr166tests.jtreg.util.Collections.ViewSynch.INT_ZERO);
				}
			}
		}.start();
		jsr166tests.jtreg.util.Collections.ViewSynch.c.contains(jsr166tests.jtreg.util.Collections.ViewSynch.INT_ONE);
	}
}