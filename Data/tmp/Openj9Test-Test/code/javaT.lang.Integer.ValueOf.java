public class ValueOf {
	private static final int TEST_LOW = -1024;

	private static final int TEST_HIGH = 24576;

	public static void main(java.lang.String[] args) {
		int i = javaT.lang.Integer.ValueOf.TEST_LOW;
		while (i <= javaT.lang.Integer.ValueOf.TEST_HIGH) {
			if (java.lang.Integer.valueOf(i).intValue() != i) {
				throw new java.lang.RuntimeException();
			}
			if ((i >= (-128)) && (i <= 127)) {
				if (java.lang.Integer.valueOf(i) != java.lang.Integer.valueOf(i)) {
					throw new java.lang.RuntimeException();
				}
			}
			i++;
		} 
	}
}