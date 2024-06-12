public class Chew {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 64; i++) {
			java.nio.ByteBuffer.allocateDirect(1 << 20);
		}
	}
}