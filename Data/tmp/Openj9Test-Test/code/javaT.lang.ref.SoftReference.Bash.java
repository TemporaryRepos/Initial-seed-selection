public class Bash {
	static class TestReference extends java.lang.ref.SoftReference {
		public static javaT.lang.ref.SoftReference.Bash.TestReference head;

		public javaT.lang.ref.SoftReference.Bash.TestReference next;

		public TestReference(java.lang.Object referent) {
			super(referent);
			next = javaT.lang.ref.SoftReference.Bash.TestReference.head;
			javaT.lang.ref.SoftReference.Bash.TestReference.head = this;
		}
	}

	static final int NUM_BLOCKS = 2048;

	static final int BLOCK_SIZE = 32768;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (int i = 0; i < javaT.lang.ref.SoftReference.Bash.NUM_BLOCKS; ++i) {
			javaT.lang.ref.SoftReference.Bash.TestReference ref = new javaT.lang.ref.SoftReference.Bash.TestReference(new byte[javaT.lang.ref.SoftReference.Bash.BLOCK_SIZE]);
		}
		int emptyCount = 0;
		int fullCount = 0;
		for (javaT.lang.ref.SoftReference.Bash.TestReference r = javaT.lang.ref.SoftReference.Bash.TestReference.head; r != null; r = r.next) {
			if (r.get() == null) {
				emptyCount++;
			} else {
				fullCount++;
			}
		}
		java.lang.System.err.println(((fullCount + " full, ") + emptyCount) + " empty ");
	}
}