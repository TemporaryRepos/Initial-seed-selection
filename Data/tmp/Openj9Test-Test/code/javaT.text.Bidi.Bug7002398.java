public class Bug7002398 {
	private static final int[] directions = new int[]{ java.text.Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT, java.text.Bidi.DIRECTION_DEFAULT_RIGHT_TO_LEFT, java.text.Bidi.DIRECTION_LEFT_TO_RIGHT, java.text.Bidi.DIRECTION_RIGHT_TO_LEFT };

	private static final java.lang.String str = "ا٠ܐ܏܍";

	private static final int[] expectedLevels = new int[]{ 1, 2, 1, 1, 1 };

	public static void main(java.lang.String[] args) {
		boolean err = false;
		for (int dir = 0; dir < javaT.text.Bidi.Bug7002398.directions.length; dir++) {
			java.text.Bidi bidi = new java.text.Bidi(javaT.text.Bidi.Bug7002398.str, javaT.text.Bidi.Bug7002398.directions[dir]);
			for (int index = 0; index < javaT.text.Bidi.Bug7002398.str.length(); index++) {
				int gotLevel = bidi.getLevelAt(index);
				if (gotLevel != javaT.text.Bidi.Bug7002398.expectedLevels[index]) {
					err = true;
					java.lang.System.err.println(((((((("Unexpected level for the character 0x" + java.lang.Integer.toHexString(javaT.text.Bidi.Bug7002398.str.charAt(index)).toUpperCase()) + ": Expected level = ") + javaT.text.Bidi.Bug7002398.expectedLevels[index]) + ", actual level = ") + bidi.getLevelAt(index)) + " in direction = ") + javaT.text.Bidi.Bug7002398.directions[dir]) + ".");
				}
			}
		}
		if (err) {
			throw new java.lang.RuntimeException("Failed.");
		}
	}
}