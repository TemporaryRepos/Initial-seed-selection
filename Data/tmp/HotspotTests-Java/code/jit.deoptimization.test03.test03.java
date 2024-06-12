class test03 {
	public static void main(java.lang.String[] args) {
		jit.deoptimization.test03.A obj = new jit.deoptimization.test03.A();
		for (int index = 0; index < 100; index++) {
			obj.used_alot();
		}
	}
}