public class TestMemoryInitialization {
	static final int LOOP_LENGTH = 10;

	static final int CHUNK_SIZE = 1500000;

	public static byte[] buffer;

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < TestMemoryInitialization.LOOP_LENGTH; i++) {
			for (int j = 0; j < TestMemoryInitialization.LOOP_LENGTH; j++) {
				TestMemoryInitialization.buffer = new byte[TestMemoryInitialization.CHUNK_SIZE];
				TestMemoryInitialization.buffer = null;
			}
		}
	}
}