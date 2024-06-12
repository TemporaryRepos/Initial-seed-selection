public class uninit005 {
	static {
		uninit005 u = new uninit005();
		java.lang.Object o = u.recursiveMethod(vm.compiler.complog.share.Constants.RECURSION_DEPTH);
	}

	public java.lang.Object recursiveMethod(int i) {
		if (i <= 0) {
			return new vm.compiler.complog.uninit.uninit005.uninit005();
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