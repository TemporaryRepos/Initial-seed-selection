public class SelectNowWhenEmpty {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.channels.Selector s = java.nio.channels.spi.SelectorProvider.provider().openSelector();
		s.selectNow();
	}
}