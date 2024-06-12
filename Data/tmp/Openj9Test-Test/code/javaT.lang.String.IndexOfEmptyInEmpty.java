public class IndexOfEmptyInEmpty {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int result = new java.lang.String("").indexOf("");
		if (result != 0) {
			throw new java.lang.Exception("new String(\"\").indexOf(\"\") must be 0, but got " + result);
		}
	}
}