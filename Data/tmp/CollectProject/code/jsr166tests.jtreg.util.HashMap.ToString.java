public class ToString {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Map m = new java.util.HashMap();
		m.put(null, null);
		m.entrySet().iterator().next().toString();
	}
}