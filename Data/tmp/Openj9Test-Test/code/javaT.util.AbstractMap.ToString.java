public class ToString {
	public static void main(java.lang.String[] args) {
		java.util.Map m = new javaT.util.AbstractMap.LyingMap();
		if (!m.toString().equals("{}")) {
			throw new java.lang.RuntimeException(m.toString() + "!= {}");
		}
		m.put("x", "1");
		if (!m.toString().equals("{x=1}")) {
			throw new java.lang.RuntimeException(m.toString() + "!= {x=1}");
		}
		m.put("y", "2");
		if (!m.toString().equals("{x=1, y=2}")) {
			throw new java.lang.RuntimeException(m.toString() + "!= {x=1, y=2}");
		}
	}
}