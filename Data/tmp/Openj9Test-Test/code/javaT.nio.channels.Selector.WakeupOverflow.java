public class WakeupOverflow {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.channels.Selector selector = java.nio.channels.Selector.open();
		try {
			for (int i = 0; i < 10000; i++) {
				selector.wakeup();
			}
		} finally {
			selector.close();
		}
	}
}