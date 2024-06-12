public class Bug6850113 {
	public static void main(java.lang.String[] args) {
		boolean err = false;
		for (int i = 0xff21, j = 10; i <= 0xff3a; i++ , j++) {
			if (sun.text.normalizer.UCharacter.digit(i, 36) != j) {
				err = true;
				java.lang.System.out.println((((("Error: UCharacter.digit(0x" + java.lang.Integer.toHexString(i)) + ", 36) returned ") + sun.text.normalizer.UCharacter.digit(i, 36)) + ", expected=") + j);
			}
		}
		for (int i = 0xff41, j = 10; i <= 0xff5a; i++ , j++) {
			if (sun.text.normalizer.UCharacter.digit(i, 36) != j) {
				err = true;
				java.lang.System.out.println((((("Error: UCharacter.digit(0x" + java.lang.Integer.toHexString(i)) + ", 36) returned ") + sun.text.normalizer.UCharacter.digit(i, 36)) + ", expected=") + j);
			}
		}
		if (err) {
			throw new java.lang.RuntimeException("UCharacter.digit():  Wrong return value");
		}
	}
}