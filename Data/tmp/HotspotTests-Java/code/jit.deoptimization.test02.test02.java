class test02 {
	public static void main(java.lang.String[] args) {
		jit.deoptimization.test02.A obj = new jit.deoptimization.test02.A();
		for (int index = 0; index < 100; index++) {
			obj.used_alot();
		}
	}
}