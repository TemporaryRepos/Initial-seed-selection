public class Name {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.util.jar.Attributes.Name name = new java.util.jar.Attributes.Name("");
			throw new java.lang.Exception("empty string should be rejected");
		} catch (java.lang.IllegalArgumentException e) {
		}
	}
}