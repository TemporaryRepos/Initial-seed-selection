public class Bug6481179 {
	public static void main(java.lang.String[] args) {
		boolean err = false;
		try {
			java.text.MessageFormat.format("Testdata {1,invalid_format_type}", new java.lang.Object[]{ "val0", "val1" });
			java.lang.System.err.println("Error: IllegalArgumentException should be thrown.");
			err = true;
		} catch (java.lang.IllegalArgumentException e) {
			java.lang.String expected = "unknown format type: invalid_format_type";
			java.lang.String got = e.getMessage();
			if (!expected.equals(got)) {
				java.lang.System.err.println("Error: Unexpected error message: " + got);
				err = true;
			}
		} catch (java.lang.Exception e) {
			java.lang.System.err.println("Error: Unexpected exception was thrown: " + e);
			err = true;
		}
		if (err) {
			throw new java.lang.RuntimeException("Failed.");
		}
	}
}