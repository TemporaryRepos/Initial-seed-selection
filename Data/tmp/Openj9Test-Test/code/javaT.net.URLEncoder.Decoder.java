public class Decoder {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		boolean passed = true;
		java.lang.String enc = "UTF-16";
		java.lang.String[] strings = new java.lang.String[]{ "Āā", "Ā ā", "Ā āĂ", "Ā ā Ă", "ĀCā Ă", "ĀāĂ", "?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&?&", "foobar", "foo?bar" };
		for (int i = 0; i < strings.length; i++) {
			java.lang.String encoded = java.net.URLEncoder.encode(strings[i], enc);
			java.lang.System.out.println("ecnoded: " + encoded);
			java.lang.String decoded = java.net.URLDecoder.decode(encoded, enc);
			java.lang.System.out.print("init:    ");
			javaT.net.URLEncoder.Decoder.printString(strings[i]);
			java.lang.System.out.print("decoded: ");
			javaT.net.URLEncoder.Decoder.printString(decoded);
			if (strings[i].equals(decoded)) {
				java.lang.System.out.println(" - correct - \n");
			} else {
				java.lang.System.out.println(" - incorrect - \n");
				throw new java.lang.RuntimeException("Unexpected decoded output on string " + i);
			}
		}
	}

	static void printString(java.lang.String s) {
		for (int i = 0; i < s.length(); i++) {
			java.lang.System.out.print(((int) (s.charAt(i))) + " ");
		}
		java.lang.System.out.println();
	}
}