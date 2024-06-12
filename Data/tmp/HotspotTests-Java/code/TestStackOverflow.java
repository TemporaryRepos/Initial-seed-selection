public class TestStackOverflow {
	static final int LOOP_LENGTH = 1000000;

	static final int LOGGING_STEP = 10000;

	public static void main(java.lang.String[] args) {
		java.lang.Object object = null;
		for (int i = 0; i < TestStackOverflow.LOOP_LENGTH; i++) {
			if ((i % TestStackOverflow.LOGGING_STEP) == 0) {
				java.lang.System.out.println(i);
			}
			try {
				java.lang.Object[] array = new java.lang.Object[]{ object, object, object, object, object };
				object = array;
			} catch (java.lang.OutOfMemoryError e) {
				object = null;
				java.lang.System.out.println("Caught OutOfMemoryError.");
				return;
			} catch (java.lang.StackOverflowError e) {
				object = null;
				java.lang.System.out.println("Caught StackOverflowError.");
				return;
			}
		}
	}
}