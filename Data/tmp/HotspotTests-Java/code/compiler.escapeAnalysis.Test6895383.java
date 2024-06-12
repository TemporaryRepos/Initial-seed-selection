public class Test6895383 {
	public static void main(java.lang.String[] argv) {
		compiler.escapeAnalysis.Test6895383 test = new compiler.escapeAnalysis.Test6895383();
		test.testRemove1_IndexOutOfBounds();
		test.testAddAll1_IndexOutOfBoundsException();
	}

	public void testRemove1_IndexOutOfBounds() {
		java.util.concurrent.CopyOnWriteArrayList c = new java.util.concurrent.CopyOnWriteArrayList();
	}

	public void testAddAll1_IndexOutOfBoundsException() {
		try {
			java.util.concurrent.CopyOnWriteArrayList c = new java.util.concurrent.CopyOnWriteArrayList();
			c.addAll(-1, new java.util.LinkedList());
		} catch (java.lang.IndexOutOfBoundsException e) {
		}
	}
}