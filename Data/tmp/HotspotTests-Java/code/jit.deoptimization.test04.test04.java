class test04 {
	public static void main(java.lang.String[] args) {
		jit.deoptimization.test04.A obj = new jit.deoptimization.test04.A();
		int result = -1;
		for (int index = 0; index < 1; index++) {
			result += obj.used_alot();
		}
		if (result != 1) {
			throw new nsk.share.TestFailure(("result : " + result) + " must equal 1");
		}
	}
}