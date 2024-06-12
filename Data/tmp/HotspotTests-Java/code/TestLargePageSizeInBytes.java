public class TestLargePageSizeInBytes {
	private static long M = 1024L * 1024L;

	private static long G = 1024L * TestLargePageSizeInBytes.M;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (!jdk.test.lib.Platform.isSolaris()) {
			return;
		}
		TestLargePageSizeInBytes.testLargePageSizeInBytes(4 * TestLargePageSizeInBytes.M);
		TestLargePageSizeInBytes.testLargePageSizeInBytes(256 * TestLargePageSizeInBytes.M);
		TestLargePageSizeInBytes.testLargePageSizeInBytes(512 * TestLargePageSizeInBytes.M);
		TestLargePageSizeInBytes.testLargePageSizeInBytes(2 * TestLargePageSizeInBytes.G);
	}

	private static void testLargePageSizeInBytes(long size) throws java.lang.Exception {
		java.lang.ProcessBuilder pb = jdk.test.lib.process.ProcessTools.createJavaProcessBuilder("-XX:+UseLargePages", "-XX:LargePageSizeInBytes=" + size, "-version");
		jdk.test.lib.process.OutputAnalyzer out = new jdk.test.lib.process.OutputAnalyzer(pb.start());
		out.shouldNotContain("Attempt to use MPSS failed.");
		out.shouldHaveExitValue(0);
	}
}