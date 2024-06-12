public class BashCache {
	private static final int THREADS = 10;

	private static final int TRIALS = 1000;

	private static final java.nio.charset.Charset[] charsets = new java.nio.charset.Charset[]{ java.nio.charset.Charset.forName("US-ASCII"), java.nio.charset.Charset.forName("UTF-8"), java.nio.charset.Charset.forName("CP1252"), java.nio.charset.Charset.forName("UTF-16BE") };

	private static volatile boolean failed = false;

	private static class Basher extends java.lang.Thread {
		java.util.Random rnd = new java.util.Random(java.lang.System.identityHashCode(this));

		public void run() {
			for (int i = 0; i < javaT.nio.charset.coders.BashCache.TRIALS; i++) {
				java.nio.charset.Charset cs = javaT.nio.charset.coders.BashCache.charsets[rnd.nextInt(4)];
				try {
					if (rnd.nextBoolean()) {
						cs.encode("hi mom");
					} else {
						cs.decode(java.nio.ByteBuffer.wrap(new byte[]{ ((byte) ('x')), ((byte) ('y')), ((byte) ('z')), ((byte) ('z')), ((byte) ('y')) }));
					}
				} catch (java.lang.Exception x) {
					x.printStackTrace();
					javaT.nio.charset.coders.BashCache.failed = true;
					return;
				}
				if (rnd.nextBoolean()) {
					java.lang.Thread.yield();
				}
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.charset.Charset cs = java.nio.charset.Charset.forName("us-ascii");
		javaT.nio.charset.coders.BashCache.Basher[] bashers = new javaT.nio.charset.coders.BashCache.Basher[javaT.nio.charset.coders.BashCache.THREADS];
		for (int i = 0; i < javaT.nio.charset.coders.BashCache.THREADS; i++) {
			bashers[i] = new javaT.nio.charset.coders.BashCache.Basher();
			bashers[i].start();
		}
		for (int i = 0; i < javaT.nio.charset.coders.BashCache.THREADS; i++) {
			bashers[i].join();
		}
		if (javaT.nio.charset.coders.BashCache.failed) {
			throw new java.lang.Exception("Test failed");
		}
	}
}