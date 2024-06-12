public class uninit001 {
	static {
		for (int i = 0; i < vm.compiler.complog.share.Constants.LOOP_ITERATIONS; i++) {
			uninit001 u = new uninit001();
			java.lang.Object o = u.copy();
		}
	}

	public java.lang.Object copy() {
		return new vm.compiler.complog.uninit.uninit001.uninit001();
	}

	public static void main(java.lang.String[] args) {
	}
}