class t014 {
	void foo() {
		java.lang.System.out.println("Hiya.");
	}

	public static void main(java.lang.String[] argv) {
		jit.t.t014.t014 o;
		o = new jit.t.t014.t014();
		try {
			o.foo();
		} catch (java.lang.Throwable x) {
			throw new nsk.share.TestFailure("Exception thrown");
		}
		o = null;
		try {
			o.foo();
			throw new nsk.share.TestFailure("Exception NOT thrown");
		} catch (java.lang.Throwable x) {
		}
	}
}