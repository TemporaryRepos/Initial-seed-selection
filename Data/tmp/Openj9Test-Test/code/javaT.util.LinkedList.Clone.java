public class Clone {
	public static void main(java.lang.String[] args) {
		javaT.util.LinkedList.Clone.LinkedList2 l = new javaT.util.LinkedList.Clone.LinkedList2();
		javaT.util.LinkedList.Clone.LinkedList2 lClone = ((javaT.util.LinkedList.Clone.LinkedList2) (l.clone()));
		if (!(l.equals(lClone) && lClone.equals(l))) {
			throw new java.lang.RuntimeException("LinkedList.clone() is broken 1.");
		}
		l.add("a");
		lClone = ((javaT.util.LinkedList.Clone.LinkedList2) (l.clone()));
		if (!(l.equals(lClone) && lClone.equals(l))) {
			throw new java.lang.RuntimeException("LinkedList.clone() is broken 2.");
		}
		l.add("b");
		lClone = ((javaT.util.LinkedList.Clone.LinkedList2) (l.clone()));
		if (!(l.equals(lClone) && lClone.equals(l))) {
			throw new java.lang.RuntimeException("LinkedList.clone() is broken 2.");
		}
		javaT.util.LinkedList.Clone.TreeSet2 s = new javaT.util.LinkedList.Clone.TreeSet2();
		javaT.util.LinkedList.Clone.TreeSet2 sClone = ((javaT.util.LinkedList.Clone.TreeSet2) (s.clone()));
		if (!(s.equals(sClone) && sClone.equals(s))) {
			throw new java.lang.RuntimeException("TreeSet.clone() is broken.");
		}
		s.add("a");
		sClone = ((javaT.util.LinkedList.Clone.TreeSet2) (s.clone()));
		if (!(s.equals(sClone) && sClone.equals(s))) {
			throw new java.lang.RuntimeException("TreeSet.clone() is broken.");
		}
		s.add("b");
		sClone = ((javaT.util.LinkedList.Clone.TreeSet2) (s.clone()));
		if (!(s.equals(sClone) && sClone.equals(s))) {
			throw new java.lang.RuntimeException("TreeSet.clone() is broken.");
		}
		javaT.util.LinkedList.Clone.TreeMap2 m = new javaT.util.LinkedList.Clone.TreeMap2();
		javaT.util.LinkedList.Clone.TreeMap2 mClone = ((javaT.util.LinkedList.Clone.TreeMap2) (m.clone()));
		if (!(m.equals(mClone) && mClone.equals(m))) {
			throw new java.lang.RuntimeException("TreeMap.clone() is broken.");
		}
		m.put("a", "b");
		mClone = ((javaT.util.LinkedList.Clone.TreeMap2) (m.clone()));
		if (!(m.equals(mClone) && mClone.equals(m))) {
			throw new java.lang.RuntimeException("TreeMap.clone() is broken.");
		}
		m.put("c", "d");
		mClone = ((javaT.util.LinkedList.Clone.TreeMap2) (m.clone()));
		if (!(m.equals(mClone) && mClone.equals(m))) {
			throw new java.lang.RuntimeException("TreeMap.clone() is broken.");
		}
	}

	private static class LinkedList2 extends java.util.LinkedList {}

	private static class TreeSet2 extends java.util.TreeSet {}

	private static class TreeMap2 extends java.util.TreeMap {}
}