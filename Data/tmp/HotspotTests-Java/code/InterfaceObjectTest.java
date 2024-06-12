public class InterfaceObjectTest implements ICloneExtend {
	public java.lang.Object clone() {
		java.lang.System.out.println("In InterfaceObjectTest\'s clone() method\n");
		return null;
	}

	public void finalize() throws java.lang.Throwable {
		try {
			java.lang.System.out.println("In InterfaceObjectTest\'s finalize() method\n");
		} catch (java.lang.Throwable t) {
			throw new java.lang.AssertionError(t);
		}
	}

	public static void tryIt(ICloneExtend o1) {
		try {
			java.lang.Object o2 = o1.clone();
			o1.finalize();
		} catch (java.lang.Throwable t) {
			if (t instanceof java.lang.IllegalAccessError) {
				java.lang.System.out.println("TEST FAILS - IAE resulted\n");
				java.lang.System.exit(1);
			}
		}
	}

	public static void main(java.lang.String[] args) {
		InterfaceObjectTest o1 = new InterfaceObjectTest();
		InterfaceObjectTest.tryIt(o1);
		java.lang.System.out.println("TEST PASSES - no IAE resulted\n");
	}
}