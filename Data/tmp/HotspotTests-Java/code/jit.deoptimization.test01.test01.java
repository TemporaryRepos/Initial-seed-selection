class test01 {
	public static void main(java.lang.String[] args) {
		jit.deoptimization.test01.A obj = new jit.deoptimization.test01.A();
		for (int index = 0; index < 100; index++) {
			obj.used_alot();
		}
	}
}