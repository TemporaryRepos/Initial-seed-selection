public class Enum {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int[] sizes = new int[]{ 0, 10, 100 };
		for (int i = 0; i < sizes.length; i++) {
			java.util.Vector v = new java.util.Vector();
			int size = sizes[i];
			for (int j = 0; j < size; j++) {
				v.add(new java.lang.Integer(j));
			}
			java.util.List l = java.util.Collections.list(v.elements());
			if (!l.equals(v)) {
				throw new java.lang.Exception("Copy failed: " + size);
			}
		}
	}
}