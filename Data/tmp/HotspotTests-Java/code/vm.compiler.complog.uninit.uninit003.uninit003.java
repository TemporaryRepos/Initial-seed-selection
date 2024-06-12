public class uninit003 {
	static {
		uninit003 u = new uninit003();
		java.lang.Object o = u.osr();
	}

	public java.lang.Object osr() {
		java.lang.Object o = null;
		for (int i = 0; i < vm.compiler.complog.share.Constants.LOOP_ITERATIONS; i++) {
			o = new java.lang.Object();
		}
		return o;
	}

	public static void main(java.lang.String[] args) {
	}
}