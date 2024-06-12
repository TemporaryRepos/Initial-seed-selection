public class LastIndexOf {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		java.util.Vector v = new java.util.Vector(10);
		try {
			int i = v.lastIndexOf(null, 5);
			throw new java.lang.Exception("lastIndexOf(5/10) " + i);
		} catch (java.lang.IndexOutOfBoundsException e) {
		}
	}
}