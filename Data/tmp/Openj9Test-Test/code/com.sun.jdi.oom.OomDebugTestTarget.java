class OomDebugTestTarget {
	OomDebugTestTarget() {
		java.lang.System.out.println("DEBUG: invoked constructor");
	}

	static class FooCls {
		@java.lang.SuppressWarnings("unused")
		private byte[] bytes = new byte[3000000];
	}

	com.sun.jdi.oom.OomDebugTestTarget.FooCls fooCls = new com.sun.jdi.oom.OomDebugTestTarget.FooCls();

	byte[] byteArray = new byte[0];

	void testMethod(com.sun.jdi.oom.OomDebugTestTarget.FooCls foo) {
		java.lang.System.out.println("DEBUG: invoked 'void testMethod(FooCls)', foo == " + foo);
	}

	void testPrimitive(byte[] foo) {
		java.lang.System.out.println("DEBUG: invoked 'void testPrimitive(byte[])', foo == " + foo);
	}

	byte[] testPrimitiveArrRetval() {
		java.lang.System.out.println("DEBUG: invoked 'byte[] testPrimitiveArrRetval()'");
		return new byte[3000000];
	}

	com.sun.jdi.oom.OomDebugTestTarget.FooCls testFooClsRetval() {
		java.lang.System.out.println("DEBUG: invoked 'FooCls testFooClsRetval()'");
		return new com.sun.jdi.oom.OomDebugTestTarget.FooCls();
	}

	public void entry() {
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("DEBUG: OomDebugTestTarget.main");
		new com.sun.jdi.oom.OomDebugTestTarget().entry();
	}
}