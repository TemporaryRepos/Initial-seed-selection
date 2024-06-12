public class uninit006 {
	static {
		uninit006 u = new uninit006();
		java.lang.Object o = u.recursiveMethod(vm.compiler.complog.share.Constants.RECURSION_DEPTH);
	}

	public java.lang.Object recursiveMethod(int i) {
		if (i <= 0) {
			return new java.lang.Object();
		} else {
			java.lang.Object o = null;
			o = recursiveMethod(i - 1);
			o = recursiveMethod(i - 1);
			return o;
		}
	}

	public static void main(java.lang.String[] args) {
	}
}