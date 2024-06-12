public class BindNull {
	public static void main(java.lang.String[] args) throws java.io.IOException {
		try (final java.nio.channels.DatagramChannel dc = java.nio.channels.DatagramChannel.open()) {
			dc.bind(null);
		}
		try (final java.nio.channels.DatagramChannel dc = java.nio.channels.DatagramChannel.open(java.net.StandardProtocolFamily.INET)) {
			dc.bind(null);
		}
		try (final java.nio.channels.DatagramChannel dc = java.nio.channels.DatagramChannel.open(java.net.StandardProtocolFamily.INET6)) {
			dc.bind(null);
		} catch (java.lang.UnsupportedOperationException uoe) {
		}
	}
}