public class SharedUsageTest {
	private static final java.lang.String HELLO_MSG = "HelloWorld";

	private static final boolean ADD_TEST_VM_OPTION = false;

	private static boolean shouldBeFalseInParent = false;

	private static final boolean IS_PARENT = java.lang.Boolean.getBoolean("compiler.aot.SharedUsageTest.parent");

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		jdk.test.lib.Asserts.assertFalse(compiler.aot.SharedUsageTest.shouldBeFalseInParent, "A test invariant is broken");
		if (compiler.aot.SharedUsageTest.IS_PARENT) {
			jdk.test.lib.cli.CommandLineOptionTest.verifyJVMStartup(new java.lang.String[]{ "libSharedUsageTest.so  aot library", compiler.aot.SharedUsageTest.HELLO_MSG }, null, "Unexpected exit code", "Unexpected output", jdk.test.lib.process.ExitCode.OK, compiler.aot.SharedUsageTest.ADD_TEST_VM_OPTION, "-XX:+UseAOT", "-XX:+PrintAOT", "-Dtest.jdk=" + jdk.test.lib.Utils.TEST_JDK, "-XX:AOTLibrary=./libSharedUsageTest.so", compiler.aot.SharedUsageTest.class.getName());
			jdk.test.lib.Asserts.assertFalse(compiler.aot.SharedUsageTest.shouldBeFalseInParent, "A static member got " + "unexpectedly changed");
		} else {
			compiler.aot.SharedUsageTest.shouldBeFalseInParent = true;
			jdk.test.lib.Asserts.assertTrue(compiler.aot.SharedUsageTest.shouldBeFalseInParent, "A static member wasn't" + "changed as expected");
			java.lang.System.out.println(compiler.aot.SharedUsageTest.HELLO_MSG);
		}
	}
}