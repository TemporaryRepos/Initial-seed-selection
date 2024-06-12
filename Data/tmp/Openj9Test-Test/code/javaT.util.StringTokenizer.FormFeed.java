public class FormFeed {
	public static void main(java.lang.String[] argv) {
		java.util.StringTokenizer st = new java.util.StringTokenizer("ABCD\tEFG\fHIJKLM PQR");
		if (st.countTokens() != 4) {
			throw new java.lang.RuntimeException("StringTokenizer does not treat form feed as whitespace.");
		}
	}
}