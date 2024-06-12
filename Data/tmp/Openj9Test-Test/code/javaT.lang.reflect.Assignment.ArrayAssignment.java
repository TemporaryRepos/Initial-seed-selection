public class ArrayAssignment {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		int[][] from = new int[5][5];
		java.lang.Object[] to = from;
		to = new java.lang.Object[1];
		if (!to.getClass().isAssignableFrom(from.getClass())) {
			throw new java.lang.Exception("bad array assignment check in reflection");
		}
	}
}