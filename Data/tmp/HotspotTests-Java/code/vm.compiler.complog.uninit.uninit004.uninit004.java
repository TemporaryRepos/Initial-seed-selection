public class uninit004 {
	static {
		uninit004 u = new uninit004();
		java.lang.Object o;
		for (int i = 0; i < vm.compiler.complog.share.Constants.LOOP_ITERATIONS; i++) {
			o = u.copy();
		}
	}

	public java.lang.Object copy() {
		return new java.lang.Object();
	}

	public static void main(java.lang.String[] args) {
	}
}