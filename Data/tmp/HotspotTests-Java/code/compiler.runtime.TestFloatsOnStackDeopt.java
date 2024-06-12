public class TestFloatsOnStackDeopt {
	private static final int ARRLEN = 97;

	private static final int ITERS1 = 100;

	private static final int ITERS2 = 40000;

	private static final float VALUE = 15.0F;

	public static java.lang.String dummyString = "long long string";

	static volatile boolean pleaseStop = false;

	static void run_loop_with_safepoint(float[] a0, float b) {
		for (long l = 0; l < compiler.runtime.TestFloatsOnStackDeopt.ITERS2; l++) {
			for (int i = 0; i < a0.length; i += 1) {
				a0[i] += b;
			}
		}
	}

	static int test() {
		java.lang.Thread th = new java.lang.Thread() {
			public void run() {
				while (!compiler.runtime.TestFloatsOnStackDeopt.pleaseStop) {
					synchronized(this) {
						try {
							wait(1);
						} catch (java.lang.Exception ex) {
						}
					}
					compiler.runtime.TestFloatsOnStackDeopt.dummyString = new java.lang.StringBuilder(compiler.runtime.TestFloatsOnStackDeopt.dummyString).append(compiler.runtime.TestFloatsOnStackDeopt.dummyString).toString();
					if (compiler.runtime.TestFloatsOnStackDeopt.dummyString.length() > (1024 * 1024)) {
						compiler.runtime.TestFloatsOnStackDeopt.dummyString = "long long string";
					}
				} 
			}
		};
		th.start();
		int errn = 0;
		for (int j = 0; j < compiler.runtime.TestFloatsOnStackDeopt.ITERS1; j++) {
			float[] x0 = new float[compiler.runtime.TestFloatsOnStackDeopt.ARRLEN];
			compiler.runtime.TestFloatsOnStackDeopt.run_loop_with_safepoint(x0, compiler.runtime.TestFloatsOnStackDeopt.VALUE);
			for (int i = 0; i < compiler.runtime.TestFloatsOnStackDeopt.ARRLEN; i++) {
				if (x0[i] != (compiler.runtime.TestFloatsOnStackDeopt.VALUE * compiler.runtime.TestFloatsOnStackDeopt.ITERS2)) {
					java.lang.System.err.println(((((((("(" + j) + "): ") + "x0[") + i) + "] = ") + x0[i]) + " != ") + (compiler.runtime.TestFloatsOnStackDeopt.VALUE * compiler.runtime.TestFloatsOnStackDeopt.ITERS2));
					errn++;
				}
				x0[i] = 0.0F;
			}
			if (errn > 0) {
				break;
			}
		}
		compiler.runtime.TestFloatsOnStackDeopt.pleaseStop = true;
		try {
			th.join();
		} catch (java.lang.InterruptedException e) {
			throw new java.lang.Error("InterruptedException in main thread ", e);
		}
		return errn;
	}

	public static void main(java.lang.String[] args) {
		int errn = compiler.runtime.TestFloatsOnStackDeopt.test();
		java.lang.System.err.println(errn > 0 ? "FAILED" : "PASSED");
	}
}