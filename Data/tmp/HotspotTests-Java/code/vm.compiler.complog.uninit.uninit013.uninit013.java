public class uninit013 {
	java.lang.Object field = null;

	static java.lang.Object staticField = null;

	static {
		uninit013 u = new uninit013();
		for (int i = 0; i < vm.compiler.complog.share.Constants.LOOP_ITERATIONS; i++) {
			u.field = new java.lang.Object();
			uninit013.staticField = new java.lang.Object();
		}
	}

	public static void main(java.lang.String[] args) {
	}
}