public class TestRecursiveReplacedException {
	public static void main(java.lang.String[] args) {
		new compiler.exceptions.TestRecursiveReplacedException().run();
	}

	public void run() {
		try {
			run();
		} catch (java.lang.Throwable t) {
		}
	}
}