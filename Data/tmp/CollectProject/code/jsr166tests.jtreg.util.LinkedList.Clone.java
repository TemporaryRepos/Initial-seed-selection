public class Clone {
	public static void main(java.lang.String[] args) {
		jsr166tests.jtreg.util.LinkedList.Clone.LinkedList2 l = new jsr166tests.jtreg.util.LinkedList.Clone.LinkedList2();
		jsr166tests.jtreg.util.LinkedList.Clone.LinkedList2 lClone = ((jsr166tests.jtreg.util.LinkedList.Clone.LinkedList2) (l.clone()));
		if (!(l.equals(lClone) && lClone.equals(l))) {
			throw new java.lang.RuntimeException("LinkedList.clone() is broken 1.");
		}
		l.add("a");
		lClone = ((jsr166tests.jtreg.util.LinkedList.Clone.LinkedList2) (l.clone()));
		if (!(l.equals(lClone) && lClone.equals(l))) {
			throw new java.lang.RuntimeException("LinkedList.clone() is broken 2.");
		}
		l.add("b");
		lClone = ((jsr166tests.jtreg.util.LinkedList.Clone.LinkedList2) (l.clone()));
		if (!(l.equals(lClone) && lClone.equals(l))) {
			throw new java.lang.RuntimeException("LinkedList.clone() is broken 2.");
		}
		jsr166tests.jtreg.util.LinkedList.Clone.TreeSet2 s = new jsr166tests.jtreg.util.LinkedList.Clone.TreeSet2();
		jsr166tests.jtreg.util.LinkedList.Clone.TreeSet2 sClone = ((jsr166tests.jtreg.util.LinkedList.Clone.TreeSet2) (s.clone()));
		if (!(s.equals(sClone) && sClone.equals(s))) {
			throw new java.lang.RuntimeException("TreeSet.clone() is broken.");
		}
		s.add("a");
		sClone = ((jsr166tests.jtreg.util.LinkedList.Clone.TreeSet2) (s.clone()));
		if (!(s.equals(sClone) && sClone.equals(s))) {
			throw new java.lang.RuntimeException("TreeSet.clone() is broken.");
		}
		s.add("b");
		sClone = ((jsr166tests.jtreg.util.LinkedList.Clone.TreeSet2) (s.clone()));
		if (!(s.equals(sClone) && sClone.equals(s))) {
			throw new java.lang.RuntimeException("TreeSet.clone() is broken.");
		}
		jsr166tests.jtreg.util.LinkedList.Clone.TreeMap2 m = new jsr166tests.jtreg.util.LinkedList.Clone.TreeMap2();
		jsr166tests.jtreg.util.LinkedList.Clone.TreeMap2 mClone = ((jsr166tests.jtreg.util.LinkedList.Clone.TreeMap2) (m.clone()));
		if (!(m.equals(mClone) && mClone.equals(m))) {
			throw new java.lang.RuntimeException("TreeMap.clone() is broken.");
		}
		m.put("a", "b");
		mClone = ((jsr166tests.jtreg.util.LinkedList.Clone.TreeMap2) (m.clone()));
		if (!(m.equals(mClone) && mClone.equals(m))) {
			throw new java.lang.RuntimeException("TreeMap.clone() is broken.");
		}
		m.put("c", "d");
		mClone = ((jsr166tests.jtreg.util.LinkedList.Clone.TreeMap2) (m.clone()));
		if (!(m.equals(mClone) && mClone.equals(m))) {
			throw new java.lang.RuntimeException("TreeMap.clone() is broken.");
		}
	}

	private static class LinkedList2 extends java.util.LinkedList {}

	private static class TreeSet2 extends java.util.TreeSet {}

	private static class TreeMap2 extends java.util.TreeMap {}
}