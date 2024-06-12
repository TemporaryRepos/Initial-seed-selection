public class AllocateDirectInit {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 1024; i++) {
			java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocateDirect(1024);
			for (bb.position(0); bb.position() < bb.limit();) {
				if ((bb.get() & 0xff) != 0) {
					throw new java.lang.RuntimeException("uninitialized buffer, position = " + bb.position());
				}
			}
		}
	}

	private static void printByteBuffer(java.nio.ByteBuffer bb) {
		java.lang.System.out.print("byte [");
		for (bb.position(0); bb.position() < bb.limit();) {
			java.lang.System.out.print(" " + java.lang.Integer.toHexString(bb.get() & 0xff));
		}
		java.lang.System.out.println(" ]");
	}
}