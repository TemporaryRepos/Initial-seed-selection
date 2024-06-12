public class StackOverflowTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try (final java.nio.channels.Selector sel = java.nio.channels.Selector.open()) {
			javaT.nio.channels.Selector.StackOverflowTest.recursiveSelect(sel);
		} catch (java.lang.StackOverflowError e) {
		}
	}

	static void recursiveSelect(java.nio.channels.Selector sel) throws java.lang.Exception {
		sel.selectNow();
		javaT.nio.channels.Selector.StackOverflowTest.recursiveSelect(sel);
	}
}