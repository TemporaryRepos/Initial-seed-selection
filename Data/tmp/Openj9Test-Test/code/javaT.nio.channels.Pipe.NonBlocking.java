public class NonBlocking {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.nio.channels.Pipe.NonBlocking.test1();
	}

	static void test1() throws java.lang.Exception {
		java.nio.channels.Pipe p = java.nio.channels.Pipe.open();
		try {
			p.sink().configureBlocking(false);
			if (p.sink().isBlocking()) {
				throw new java.lang.Exception("Sink still blocking");
			}
			p.source().configureBlocking(false);
			if (p.source().isBlocking()) {
				throw new java.lang.Exception("Source still blocking");
			}
		} finally {
			p.sink().close();
			p.source().close();
		}
	}
}