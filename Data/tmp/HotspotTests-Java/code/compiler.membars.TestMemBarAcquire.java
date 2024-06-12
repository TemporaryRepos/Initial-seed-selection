public class TestMemBarAcquire {
	private static volatile java.lang.Object defaultObj = new java.lang.Object();

	private java.lang.Object obj;

	public TestMemBarAcquire(java.lang.Object param) {
		this.obj = compiler.membars.TestMemBarAcquire.defaultObj;
		this.obj = param;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (int i = 0; i < 100000; ++i) {
			compiler.membars.TestMemBarAcquire p = new compiler.membars.TestMemBarAcquire(new java.lang.Object());
		}
	}
}