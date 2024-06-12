public class LotsOfChannels {
	private static final int PIPES_COUNT = 256;

	private static final int BUF_SIZE = 8192;

	private static final int LOOPS = 10;

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		java.nio.channels.Pipe[] pipes = new java.nio.channels.Pipe[javaT.nio.channels.Selector.LotsOfChannels.PIPES_COUNT];
		java.nio.channels.Pipe pipe = java.nio.channels.Pipe.open();
		java.nio.channels.Pipe.SinkChannel sink = pipe.sink();
		java.nio.channels.Pipe.SourceChannel source = pipe.source();
		java.nio.channels.Selector sel = java.nio.channels.Selector.open();
		source.configureBlocking(false);
		source.register(sel, java.nio.channels.SelectionKey.OP_READ);
		for (int i = 0; i < javaT.nio.channels.Selector.LotsOfChannels.PIPES_COUNT; i++) {
			pipes[i] = java.nio.channels.Pipe.open();
			java.nio.channels.Pipe.SourceChannel sc = pipes[i].source();
			sc.configureBlocking(false);
			sc.register(sel, java.nio.channels.SelectionKey.OP_READ);
			java.nio.channels.Pipe.SinkChannel sc2 = pipes[i].sink();
			sc2.configureBlocking(false);
			sc2.register(sel, java.nio.channels.SelectionKey.OP_WRITE);
		}
		for (int i = 0; i < javaT.nio.channels.Selector.LotsOfChannels.LOOPS; i++) {
			sink.write(java.nio.ByteBuffer.allocate(javaT.nio.channels.Selector.LotsOfChannels.BUF_SIZE));
			int x = sel.selectNow();
			sel.selectedKeys().clear();
			source.read(java.nio.ByteBuffer.allocate(javaT.nio.channels.Selector.LotsOfChannels.BUF_SIZE));
		}
		for (int i = 0; i < javaT.nio.channels.Selector.LotsOfChannels.PIPES_COUNT; i++) {
			pipes[i].sink().close();
			pipes[i].source().close();
		}
		pipe.sink().close();
		pipe.source().close();
		sel.close();
	}
}