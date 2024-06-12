public class EmptyRead {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.channels.spi.SelectorProvider sp = java.nio.channels.spi.SelectorProvider.provider();
		java.nio.channels.Pipe p = sp.openPipe();
		java.nio.channels.Pipe.SinkChannel sink = p.sink();
		java.nio.channels.Pipe.SourceChannel source = p.source();
		byte[] someBytes = new byte[0];
		java.nio.ByteBuffer outgoingdata = java.nio.ByteBuffer.wrap(someBytes);
		int totalWritten = 0;
		int written = sink.write(outgoingdata);
		if (written < 0) {
			throw new java.lang.Exception("Write failed");
		}
		java.nio.ByteBuffer incomingdata = java.nio.ByteBuffer.allocateDirect(0);
		int read = source.read(incomingdata);
		if (read < 0) {
			throw new java.lang.Exception("Read EOF");
		}
		sink.close();
		source.close();
	}
}