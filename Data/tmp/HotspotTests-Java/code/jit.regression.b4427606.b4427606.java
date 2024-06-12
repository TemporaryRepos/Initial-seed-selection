public class b4427606 {
	private static final int NUM_ITERATIONS = 1000000;

	public static void main(java.lang.String[] args) {
		new jit.regression.b4427606.b4427606().run();
	}

	public void run() {
		new jit.regression.b4427606.b4427606.DivByZero().start();
		new jit.regression.b4427606.b4427606.NeverDivByZero().start();
	}

	class DivByZero extends java.lang.Thread {
		public void run() {
			long source = 1L;
			long iter = jit.regression.b4427606.b4427606.NUM_ITERATIONS;
			while ((--iter) > 0) {
				try {
					long ignore = source % zero;
					throw new java.lang.RuntimeException("Should Not Reach Here....");
				} catch (java.lang.ArithmeticException ax) {
				} catch (java.lang.RuntimeException rx) {
					rx.printStackTrace();
					throw new nsk.share.TestFailure("Test failed.");
				}
			} 
		}
	}

	class NeverDivByZero extends java.lang.Thread {
		public void run() {
			long source = 1L;
			long iter = jit.regression.b4427606.b4427606.NUM_ITERATIONS;
			while ((--iter) > 0) {
				try {
					long ignore = source % notzero;
				} catch (java.lang.ArithmeticException ax) {
					ax.printStackTrace();
					throw new nsk.share.TestFailure("Test failed.");
				}
			} 
		}
	}

	long zero = 0;

	long notzero = 10;
}