public class NonCharacterMapping {
	private static final java.util.Locale ENGLISH = new java.util.Locale("en");

	private static final java.util.Locale TURKISH = new java.util.Locale("tr");

	public static void main(java.lang.String[] args) {
		if (java.lang.Character.toLowerCase('￿') != '￿') {
			throw new java.lang.RuntimeException();
		}
		if (java.lang.Character.toUpperCase('￿') != '￿') {
			throw new java.lang.RuntimeException();
		}
		if (java.lang.Character.toTitleCase('￿') != '￿') {
			throw new java.lang.RuntimeException();
		}
		if (!"￿".toLowerCase(javaT.lang.String.NonCharacterMapping.ENGLISH).equals("￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"￿".toUpperCase(javaT.lang.String.NonCharacterMapping.ENGLISH).equals("￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"￿".toLowerCase(javaT.lang.String.NonCharacterMapping.TURKISH).equals("￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"￿".toUpperCase(javaT.lang.String.NonCharacterMapping.TURKISH).equals("￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"A￿".toLowerCase(javaT.lang.String.NonCharacterMapping.ENGLISH).equals("a￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"A￿".toUpperCase(javaT.lang.String.NonCharacterMapping.ENGLISH).equals("A￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"A￿".toLowerCase(javaT.lang.String.NonCharacterMapping.TURKISH).equals("a￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"A￿".toUpperCase(javaT.lang.String.NonCharacterMapping.TURKISH).equals("A￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"a￿".toLowerCase(javaT.lang.String.NonCharacterMapping.ENGLISH).equals("a￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"a￿".toUpperCase(javaT.lang.String.NonCharacterMapping.ENGLISH).equals("A￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"a￿".toLowerCase(javaT.lang.String.NonCharacterMapping.TURKISH).equals("a￿")) {
			throw new java.lang.RuntimeException();
		}
		if (!"a￿".toUpperCase(javaT.lang.String.NonCharacterMapping.TURKISH).equals("A￿")) {
			throw new java.lang.RuntimeException();
		}
	}
}