public class Bug8005277 {
	public static void main(java.lang.String[] args) {
		boolean err = false;
		java.lang.String string = "אבג";
		java.text.Bidi bidi = new java.text.Bidi(string, java.text.Bidi.DIRECTION_LEFT_TO_RIGHT);
		int result = bidi.getRunCount();
		if (result != 1) {
			java.lang.System.err.println("Incorrect run count: " + result);
			err = true;
		}
		result = bidi.getRunStart(0);
		if (result != 0) {
			java.lang.System.err.println("Incorrect run start: " + result);
			err = true;
		}
		result = bidi.getRunLimit(0);
		if (result != 3) {
			java.lang.System.err.println("Incorrect run limit: " + result);
			err = true;
		}
		result = bidi.getRunLevel(0);
		if (result != 1) {
			java.lang.System.err.println("Incorrect run level: " + result);
			err = true;
		}
		if (err) {
			throw new java.lang.RuntimeException("Failed.");
		}
	}
}