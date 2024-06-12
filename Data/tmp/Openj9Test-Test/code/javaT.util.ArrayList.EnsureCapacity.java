public class EnsureCapacity {
	public static void main(java.lang.String[] args) {
		javaT.util.ArrayList.EnsureCapacity.testArrayList();
		javaT.util.ArrayList.EnsureCapacity.testVector();
	}

	private static void checkCapacity(int before, int after) {
		if (before != after) {
			throw new java.lang.RuntimeException(((("capacity is expected to be unchanged: " + "before=") + before) + " after=") + after);
		}
	}

	private static void testArrayList() {
		java.util.ArrayList<java.lang.String> al = new java.util.ArrayList<java.lang.String>();
		al.add("abc");
		al.ensureCapacity(java.lang.Integer.MIN_VALUE);
	}

	private static void testVector() {
		java.util.Vector<java.lang.String> vector = new java.util.Vector<java.lang.String>();
		vector.add("abc");
		int cap = vector.capacity();
		vector.ensureCapacity(java.lang.Integer.MIN_VALUE);
		javaT.util.ArrayList.EnsureCapacity.checkCapacity(cap, vector.capacity());
	}
}