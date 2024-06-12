public class CharAt {
	public static void main(java.lang.String[] args) {
		java.lang.CharSequence cs = java.nio.CharBuffer.wrap("foo");
		for (int i = 0; i < cs.length(); i++) {
			java.lang.System.err.print(cs.charAt(i));
		}
		java.lang.System.err.println();
	}
}