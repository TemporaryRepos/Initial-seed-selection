public class NullTest {
	public static void main(java.lang.String[] args) {
		java.nio.channels.Channel c1;
		java.nio.channels.Channel c2;
		try {
			c1 = java.nio.channels.spi.SelectorProvider.provider().inheritedChannel();
			c2 = java.lang.System.inheritedChannel();
		} catch (java.io.IOException ioe) {
			throw new java.lang.RuntimeException("Unexpected IOException: " + ioe);
		}
		if ((c1 != null) || (c2 != null)) {
			throw new java.lang.RuntimeException("Channel returned - unexpected");
		}
	}
}