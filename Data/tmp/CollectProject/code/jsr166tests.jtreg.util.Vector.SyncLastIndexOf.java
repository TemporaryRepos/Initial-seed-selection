public class SyncLastIndexOf {
	static java.util.Vector v = new java.util.Vector();

	static class RemovingThread extends java.lang.Thread {
		public void run() {
			synchronized(jsr166tests.jtreg.util.Vector.SyncLastIndexOf.v) {
				try {
					java.lang.Thread.sleep(200);
				} catch (java.lang.InterruptedException e) {
				}
				jsr166tests.jtreg.util.Vector.SyncLastIndexOf.v.removeElementAt(0);
			}
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.Integer x = new java.lang.Integer(1);
		jsr166tests.jtreg.util.Vector.SyncLastIndexOf.v.addElement(x);
		new jsr166tests.jtreg.util.Vector.SyncLastIndexOf.RemovingThread().start();
		try {
			jsr166tests.jtreg.util.Vector.SyncLastIndexOf.v.lastIndexOf(x);
		} catch (java.lang.IndexOutOfBoundsException e) {
			throw new java.lang.RuntimeException("Vector.lastIndexOf() synchronization failed.");
		}
	}
}