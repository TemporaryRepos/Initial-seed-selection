public class HashCode {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Map m = new java.util.Hashtable();
		if (m.hashCode() != 0) {
			throw new java.lang.Exception("Empty Hashtable has nonzero hashCode.");
		}
		m.put("Joe", "Blow");
		if (m.hashCode() != ("Joe".hashCode() ^ "Blow".hashCode())) {
			throw new java.lang.Exception("Non-empty Hashtable has wrong hashCode.");
		}
	}
}