static class GCTest {
	private static byte[] garbage;

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Creating garbage");
		for (int i = 0; i < 1024; i++) {
			TestDynamicNumberOfGCThreads.GCTest.garbage = new byte[128 * 1024];
		}
		java.lang.System.out.println("Done");
	}
}