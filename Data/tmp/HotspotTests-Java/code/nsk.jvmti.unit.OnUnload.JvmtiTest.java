public class JvmtiTest {
	static final int JCK_STATUS_BASE = 95;

	static int fail_id = 0;

	public static void main(java.lang.String[] args) {
		args = nsk.share.jvmti.JVMTITest.commonInit(args);
		java.lang.System.exit(nsk.jvmti.unit.OnUnload.JvmtiTest.run(args, java.lang.System.out) + nsk.jvmti.unit.OnUnload.JvmtiTest.JCK_STATUS_BASE);
	}

	public static int run(java.lang.String[] args, java.io.PrintStream out) {
		return nsk.jvmti.unit.OnUnload.JvmtiTest.fail_id;
	}
}