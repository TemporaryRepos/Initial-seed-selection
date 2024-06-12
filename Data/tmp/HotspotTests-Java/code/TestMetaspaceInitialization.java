public class TestMetaspaceInitialization {
	private class Internal {
		public int x;

		public Internal(int x) {
			this.x = x;
		}
	}

	private void test() {
		java.util.ArrayList<TestMetaspaceInitialization.Internal> l = new java.util.ArrayList<>();
		l.add(new TestMetaspaceInitialization.Internal(17));
	}

	public static void main(java.lang.String[] args) {
		new TestMetaspaceInitialization().test();
	}
}