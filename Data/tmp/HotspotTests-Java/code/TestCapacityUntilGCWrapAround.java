public class TestCapacityUntilGCWrapAround {
	private static long MB = 1024 * 1024;

	private static long GB = 1024 * TestCapacityUntilGCWrapAround.MB;

	private static long MAX_UINT = (4 * TestCapacityUntilGCWrapAround.GB) - 1;

	public static void main(java.lang.String[] args) {
		if (jdk.test.lib.Platform.is32bit()) {
			sun.hotspot.WhiteBox wb = sun.hotspot.WhiteBox.getWhiteBox();
			long before = wb.metaspaceCapacityUntilGC();
			long after = wb.incMetaspaceCapacityUntilGC(TestCapacityUntilGCWrapAround.MAX_UINT);
			jdk.test.lib.Asserts.assertGTE(after, before, (("Increasing with MAX_UINT should not cause wrap around: " + after) + " < ") + before);
			jdk.test.lib.Asserts.assertLTE(after, TestCapacityUntilGCWrapAround.MAX_UINT, "Increasing with MAX_UINT should not cause value larger than MAX_UINT:" + after);
		}
	}
}