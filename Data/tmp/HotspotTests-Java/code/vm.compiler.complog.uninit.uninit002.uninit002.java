public class uninit002 {
	static {
		uninit002 u = new uninit002();
		java.lang.Object o = u.osr();
	}

	public java.lang.Object osr() {
		java.lang.Object o = null;
		for (int i = 0; i < vm.compiler.complog.share.Constants.LOOP_ITERATIONS; i++) {
			o = new vm.compiler.complog.uninit.uninit002.uninit002();
		}
		return o;
	}

	public static void main(java.lang.String[] args) {
	}
}