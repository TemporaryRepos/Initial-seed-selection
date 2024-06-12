public class EqualsTest {
	public static void main(java.lang.String[] args) {
		boolean test;
		java.util.List list = java.util.Collections.synchronizedList(new java.util.ArrayList());
		list.add(list);
		test = list.equals(list);
		javaT.util.Collections.EqualsTest.assertTrue(test);
		list.remove(list);
		java.util.Set s = java.util.Collections.synchronizedSet(new java.util.HashSet());
		s.add(s);
		test = s.equals(s);
		javaT.util.Collections.EqualsTest.assertTrue(test);
		java.util.Map m = java.util.Collections.synchronizedMap(new java.util.HashMap());
		test = m.equals(m);
		javaT.util.Collections.EqualsTest.assertTrue(test);
	}

	private static void assertTrue(boolean b) {
		if (!b) {
			throw new java.lang.RuntimeException("assertion failed");
		}
	}
}