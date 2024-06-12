public class Order {
	static final java.nio.ByteOrder be = java.nio.ByteOrder.BIG_ENDIAN;

	static final java.nio.ByteOrder le = java.nio.ByteOrder.LITTLE_ENDIAN;

	static final java.nio.ByteOrder nord = java.nio.ByteOrder.nativeOrder();

	static void ck(java.nio.ByteOrder ord, java.nio.ByteOrder expected) {
		if (ord != expected) {
			throw new java.lang.RuntimeException((("Got " + ord) + ", expected ") + expected);
		}
	}

	static void ckViews(java.nio.ByteBuffer bb, java.nio.ByteOrder ord) {
		javaT.nio.Buffer.Order.ck(bb.asCharBuffer().order(), bb.order());
		javaT.nio.Buffer.Order.ck(bb.asIntBuffer().order(), bb.order());
		javaT.nio.Buffer.Order.ck(bb.asLongBuffer().order(), bb.order());
		javaT.nio.Buffer.Order.ck(bb.asFloatBuffer().order(), bb.order());
		javaT.nio.Buffer.Order.ck(bb.asDoubleBuffer().order(), bb.order());
	}

	static void ckByteBuffer(java.nio.ByteBuffer bb) {
		javaT.nio.Buffer.Order.ckViews(bb, bb.order());
		bb.order(javaT.nio.Buffer.Order.be);
		javaT.nio.Buffer.Order.ckViews(bb, javaT.nio.Buffer.Order.be);
		bb.order(javaT.nio.Buffer.Order.le);
		javaT.nio.Buffer.Order.ckViews(bb, javaT.nio.Buffer.Order.le);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.nio.Buffer.Order.ck(java.nio.ByteBuffer.allocate(10).order(), javaT.nio.Buffer.Order.be);
		javaT.nio.Buffer.Order.ck(java.nio.ByteBuffer.allocateDirect(10).order(), javaT.nio.Buffer.Order.be);
		javaT.nio.Buffer.Order.ck(java.nio.ByteBuffer.allocate(10).order(javaT.nio.Buffer.Order.be).order(), javaT.nio.Buffer.Order.be);
		javaT.nio.Buffer.Order.ck(java.nio.ByteBuffer.allocate(10).order(javaT.nio.Buffer.Order.le).order(), javaT.nio.Buffer.Order.le);
		javaT.nio.Buffer.Order.ckByteBuffer(java.nio.ByteBuffer.allocate(10));
		javaT.nio.Buffer.Order.ckByteBuffer(java.nio.ByteBuffer.allocateDirect(10));
	}
}