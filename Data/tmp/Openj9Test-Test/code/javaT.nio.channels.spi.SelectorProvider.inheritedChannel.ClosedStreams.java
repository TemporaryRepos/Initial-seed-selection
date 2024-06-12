public class ClosedStreams {
	public static void main(java.lang.String[] args) throws java.io.IOException {
		new java.io.FileInputStream(java.io.FileDescriptor.in).close();
		if (java.lang.System.inheritedChannel() != null) {
			throw new java.lang.RuntimeException("inherited channel not null - unexpected!");
		}
	}
}