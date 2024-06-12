public class MinMax {
	public static void main(java.lang.String[] args) {
		java.util.Set s = new javaT.util.Collections.LyingSet();
		s.add("x");
		if (!java.util.Collections.min(s).equals("x")) {
			throw new java.lang.RuntimeException("1: " + java.util.Collections.min(s));
		}
		if (!java.util.Collections.max(s).equals("x")) {
			throw new java.lang.RuntimeException("2: " + java.util.Collections.max(s));
		}
		s.add("y");
		if (!java.util.Collections.min(s).equals("x")) {
			throw new java.lang.RuntimeException("3: " + java.util.Collections.min(s));
		}
		if (!java.util.Collections.max(s).equals("y")) {
			throw new java.lang.RuntimeException("4: " + java.util.Collections.max(s));
		}
		s.add("w");
		if (!java.util.Collections.min(s).equals("w")) {
			throw new java.lang.RuntimeException("5: " + java.util.Collections.min(s));
		}
		if (!java.util.Collections.max(s).equals("y")) {
			throw new java.lang.RuntimeException("6: " + java.util.Collections.max(s));
		}
		s.clear();
		s.add("x");
		if (!java.util.Collections.min(s, java.util.Collections.reverseOrder()).equals("x")) {
			throw new java.lang.RuntimeException("1a: " + java.util.Collections.min(s));
		}
		if (!java.util.Collections.max(s, java.util.Collections.reverseOrder()).equals("x")) {
			throw new java.lang.RuntimeException("2a: " + java.util.Collections.max(s));
		}
		s.add("y");
		if (!java.util.Collections.min(s, java.util.Collections.reverseOrder()).equals("y")) {
			throw new java.lang.RuntimeException("3a: " + java.util.Collections.min(s));
		}
		if (!java.util.Collections.max(s, java.util.Collections.reverseOrder()).equals("x")) {
			throw new java.lang.RuntimeException("4a: " + java.util.Collections.max(s));
		}
		s.add("w");
		if (!java.util.Collections.min(s, java.util.Collections.reverseOrder()).equals("y")) {
			throw new java.lang.RuntimeException("5a: " + java.util.Collections.min(s));
		}
		if (!java.util.Collections.max(s, java.util.Collections.reverseOrder()).equals("w")) {
			throw new java.lang.RuntimeException("6a: " + java.util.Collections.max(s));
		}
	}
}