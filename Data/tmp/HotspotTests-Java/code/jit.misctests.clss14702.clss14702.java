public class clss14702 {
	static int ML = 1;

	public static void main(java.lang.String[] argv) {
		jit.misctests.clss14702.clss14702 test = null;
		for (int i = 0; i < jit.misctests.clss14702.clss14702.ML; i++) {
			try {
				if (test.equals(null)) {
					java.lang.System.out.println("Error! NullPointerException should be thrown.");
				}
				throw new nsk.share.TestFailure("Error! No exception.");
			} catch (java.lang.Exception e) {
				if (!java.lang.NullPointerException.class.isInstance(e)) {
					throw new nsk.share.TestFailure("Error! Exception: " + e);
				}
			}
		}
		java.lang.System.out.println("Passed");
	}
}