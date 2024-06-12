static class A extends compiler.types.TestPhiElimination {
	public java.lang.Object f;

	public compiler.types.TestPhiElimination.A create() {
		return new compiler.types.TestPhiElimination.A();
	}

	public synchronized java.lang.Object get() {
		if (f == null) {
			f = create();
		}
		return f;
	}
}