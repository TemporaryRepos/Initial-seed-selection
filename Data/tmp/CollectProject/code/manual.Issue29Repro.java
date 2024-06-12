public class Issue29Repro implements java.lang.Runnable {
	private static java.lang.String xml = "<?xml version='1.0'?><stream:stream xmlns='jabber:client' xmlns:stream='http://etherx.jabber.org/streams' id='4095288169' from='localhost' version='1.0' xml:lang='en'>";

	private static int NUM_THREADS = 5;

	private static javax.xml.stream.util.XMLEventAllocator allocator = com.fasterxml.aalto.evt.EventAllocatorImpl.getDefaultInstance();

	private static com.fasterxml.aalto.AsyncXMLInputFactory inputFactory = new com.fasterxml.aalto.stax.InputFactoryImpl();

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		java.util.concurrent.ExecutorService ex = java.util.concurrent.Executors.newFixedThreadPool(manual.Issue29Repro.NUM_THREADS);
		for (int i = 0; i < 100000; i++) {
			ex.submit(new manual.Issue29Repro(i));
		}
		ex.shutdown();
		ex.awaitTermination(java.lang.Integer.MAX_VALUE, java.util.concurrent.TimeUnit.SECONDS);
	}

	private final int count;

	public Issue29Repro(int count) {
		this.count = count;
	}

	@java.lang.Override
	public void run() {
		try {
			java.nio.ByteBuffer bb = java.nio.charset.StandardCharsets.UTF_8.encode(manual.Issue29Repro.xml);
			com.fasterxml.aalto.AsyncXMLStreamReader<com.fasterxml.aalto.AsyncByteBufferFeeder> parser = manual.Issue29Repro.inputFactory.createAsyncForByteBuffer();
			parser.getInputFeeder().feedInput(bb);
			while (parser.hasNext()) {
				int eventType = parser.next();
				if (eventType == com.fasterxml.aalto.AsyncXMLStreamReader.EVENT_INCOMPLETE) {
					break;
				}
				manual.Issue29Repro.allocator.allocate(parser);
			} 
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("Error in " + count);
			e.printStackTrace();
		}
	}
}