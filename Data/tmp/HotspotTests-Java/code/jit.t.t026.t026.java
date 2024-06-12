class t026 {
	jit.t.t026.t026 foo() {
		return new jit.t.t026.t026();
	}

	void doit() {
		jit.t.t026.t026 o = foo();
		if (o == this) {
			throw new nsk.share.TestFailure("Say wut?");
		} else {
			java.lang.System.out.println("Ommmm.");
		}
	}

	public static void main(java.lang.String[] argv) {
		jit.t.t026.t026 o = new jit.t.t026.t026();
		o.doit();
	}
}