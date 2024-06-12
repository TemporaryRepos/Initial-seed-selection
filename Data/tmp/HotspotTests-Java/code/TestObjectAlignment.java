public class TestObjectAlignment {
	public static byte[] garbage;

	private static boolean runsOn32bit() {
		return java.lang.System.getProperty("sun.arch.data.model").equals("32");
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (TestObjectAlignment.runsOn32bit()) {
			return;
		}
		for (int i = 0; i < 10; i++) {
			TestObjectAlignment.garbage = new byte[1000];
			java.lang.System.gc();
		}
	}
}