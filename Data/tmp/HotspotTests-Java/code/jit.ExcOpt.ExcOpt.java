public class ExcOpt {
	static int x;

	public static void main(java.lang.String[] s) {
		jit.ExcOpt.ExcOpt.x = 0;
		try {
			for (int i = 1; i < 100; i++) {
				jit.ExcOpt.ExcOpt.x += 1;
			}
		} catch (java.lang.Exception e) {
			jit.ExcOpt.ExcOpt.x = 0;
		}
		for (int i = 1; i < 100; i++) {
			try {
				jit.ExcOpt.ExcOpt.x += 1;
			} catch (java.lang.Exception e) {
				jit.ExcOpt.ExcOpt.x = 0;
			}
		}
		java.lang.System.out.println("Done " + jit.ExcOpt.ExcOpt.x);
		if (jit.ExcOpt.ExcOpt.x != 198) {
			throw new nsk.share.TestFailure("Test failed (x != 198)");
		}
	}
}