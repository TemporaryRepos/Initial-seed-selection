public class Cause {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.Exception e = new java.lang.Exception();
		java.lang.AssertionError ae = new java.lang.AssertionError(e);
		if (ae.getCause() != e) {
			throw new java.lang.Exception("Cause not set.");
		}
		ae = new java.lang.AssertionError("gosh it's late");
		if (ae.getCause() != null) {
			throw new java.lang.Exception("Cause set erroneously: " + ae.getCause());
		}
	}
}