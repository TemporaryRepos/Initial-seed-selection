public class BasicFloat extends javaT.nio.Buffer.Basic {
	private static final float[] VALUES = new float[]{ java.lang.Float.MIN_VALUE, ((float) (-1)), ((float) (0)), ((float) (1)), java.lang.Float.MAX_VALUE, java.lang.Float.NEGATIVE_INFINITY, java.lang.Float.POSITIVE_INFINITY, java.lang.Float.NaN, ((float) (-0.0)) };

	private static void relGet(java.nio.FloatBuffer b) {
		int n = b.capacity();
		float v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((float) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void relGet(java.nio.FloatBuffer b, int start) {
		int n = b.remaining();
		float v;
		for (int i = start; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((float) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void absGet(java.nio.FloatBuffer b) {
		int n = b.capacity();
		float v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((float) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void bulkGet(java.nio.FloatBuffer b) {
		int n = b.capacity();
		float[] a = new float[n + 7];
		b.get(a, 7, n);
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (a[i + 7])), ((long) ((float) (javaT.nio.Buffer.Basic.ic(i)))));
		}
	}

	private static void relPut(java.nio.FloatBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(((float) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.flip();
	}

	private static void absPut(java.nio.FloatBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((float) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void bulkPutArray(java.nio.FloatBuffer b) {
		int n = b.capacity();
		b.clear();
		float[] a = new float[n + 7];
		for (int i = 0; i < n; i++) {
			a[i + 7] = ((float) (javaT.nio.Buffer.Basic.ic(i)));
		}
		b.put(a, 7, n);
		b.flip();
	}

	private static void bulkPutBuffer(java.nio.FloatBuffer b) {
		int n = b.capacity();
		b.clear();
		java.nio.FloatBuffer c = java.nio.FloatBuffer.allocate(n + 7);
		c.position(7);
		for (int i = 0; i < n; i++) {
			c.put(((float) (javaT.nio.Buffer.Basic.ic(i))));
		}
		c.flip();
		c.position(7);
		b.put(c);
		b.flip();
	}

	private static void callReset(java.nio.FloatBuffer b) {
		b.position(0);
		b.mark();
		b.duplicate().reset();
		b.asReadOnlyBuffer().reset();
	}

	private static void putBuffer() {
		final int cap = 10;
		java.nio.FloatBuffer direct1 = java.nio.ByteBuffer.allocateDirect(cap).asFloatBuffer();
		java.nio.FloatBuffer nondirect1 = java.nio.ByteBuffer.allocate(cap).asFloatBuffer();
		direct1.put(nondirect1);
		java.nio.FloatBuffer direct2 = java.nio.ByteBuffer.allocateDirect(cap).asFloatBuffer();
		java.nio.FloatBuffer nondirect2 = java.nio.ByteBuffer.allocate(cap).asFloatBuffer();
		nondirect2.put(direct2);
		java.nio.FloatBuffer direct3 = java.nio.ByteBuffer.allocateDirect(cap).asFloatBuffer();
		java.nio.FloatBuffer direct4 = java.nio.ByteBuffer.allocateDirect(cap).asFloatBuffer();
		direct3.put(direct4);
		java.nio.FloatBuffer nondirect3 = java.nio.ByteBuffer.allocate(cap).asFloatBuffer();
		java.nio.FloatBuffer nondirect4 = java.nio.ByteBuffer.allocate(cap).asFloatBuffer();
		nondirect3.put(nondirect4);
	}

	private static void checkSlice(java.nio.FloatBuffer b, java.nio.FloatBuffer slice) {
		javaT.nio.Buffer.Basic.ck(slice, 0, slice.position());
		javaT.nio.Buffer.Basic.ck(slice, b.remaining(), slice.limit());
		javaT.nio.Buffer.Basic.ck(slice, b.remaining(), slice.capacity());
		if (b.isDirect() != slice.isDirect()) {
			javaT.nio.Buffer.Basic.fail("Lost direction", slice);
		}
		if (b.isReadOnly() != slice.isReadOnly()) {
			javaT.nio.Buffer.Basic.fail("Lost read-only", slice);
		}
	}

	private static void fail(java.lang.String problem, java.nio.FloatBuffer xb, java.nio.FloatBuffer yb, float x, float y) {
		javaT.nio.Buffer.Basic.fail(problem + java.lang.String.format(": x=%s y=%s", x, y), xb, yb);
	}

	private static void tryCatch(java.nio.Buffer b, java.lang.Class<?> ex, java.lang.Runnable thunk) {
		boolean caught = false;
		try {
			thunk.run();
		} catch (java.lang.Throwable x) {
			if (ex.isAssignableFrom(x.getClass())) {
				caught = true;
			} else {
				javaT.nio.Buffer.Basic.fail(x.getMessage() + " not expected");
			}
		}
		if (!caught) {
			javaT.nio.Buffer.Basic.fail(ex.getName() + " not thrown", b);
		}
	}

	private static void tryCatch(float[] t, java.lang.Class<?> ex, java.lang.Runnable thunk) {
		javaT.nio.Buffer.BasicFloat.tryCatch(java.nio.FloatBuffer.wrap(t), ex, thunk);
	}

	public static void test(int level, final java.nio.FloatBuffer b, boolean direct) {
		javaT.nio.Buffer.Basic.show(level, b);
		if (direct != b.isDirect()) {
			javaT.nio.Buffer.Basic.fail("Wrong direction", b);
		}
		javaT.nio.Buffer.BasicFloat.relPut(b);
		javaT.nio.Buffer.BasicFloat.relGet(b);
		javaT.nio.Buffer.BasicFloat.absGet(b);
		javaT.nio.Buffer.BasicFloat.bulkGet(b);
		javaT.nio.Buffer.BasicFloat.absPut(b);
		javaT.nio.Buffer.BasicFloat.relGet(b);
		javaT.nio.Buffer.BasicFloat.absGet(b);
		javaT.nio.Buffer.BasicFloat.bulkGet(b);
		javaT.nio.Buffer.BasicFloat.bulkPutArray(b);
		javaT.nio.Buffer.BasicFloat.relGet(b);
		javaT.nio.Buffer.BasicFloat.bulkPutBuffer(b);
		javaT.nio.Buffer.BasicFloat.relGet(b);
		javaT.nio.Buffer.BasicFloat.relPut(b);
		b.position(13);
		b.compact();
		b.flip();
		javaT.nio.Buffer.BasicFloat.relGet(b, 13);
		javaT.nio.Buffer.BasicFloat.relPut(b);
		b.limit(b.capacity() / 2);
		b.position(b.limit());
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.BufferUnderflowException.class, new java.lang.Runnable() {
			public void run() {
				b.get();
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.BufferOverflowException.class, new java.lang.Runnable() {
			public void run() {
				b.put(((float) (42)));
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(b.limit());
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(-1);
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.put(b.limit(), ((float) (42)));
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.InvalidMarkException.class, new java.lang.Runnable() {
			public void run() {
				b.position(0);
				b.mark();
				b.compact();
				b.reset();
			}
		});
		b.clear();
		b.put(((float) (0)));
		b.put(((float) (-1)));
		b.put(((float) (1)));
		b.put(java.lang.Float.MAX_VALUE);
		b.put(java.lang.Float.MIN_VALUE);
		b.put(-java.lang.Float.MAX_VALUE);
		b.put(-java.lang.Float.MIN_VALUE);
		b.put(java.lang.Float.NEGATIVE_INFINITY);
		b.put(java.lang.Float.POSITIVE_INFINITY);
		b.put(java.lang.Float.NaN);
		b.put(0.91697687F);
		float v;
		b.flip();
		javaT.nio.Buffer.Basic.ck(b, b.get(), 0);
		javaT.nio.Buffer.Basic.ck(b, b.get(), ((float) (-1)));
		javaT.nio.Buffer.Basic.ck(b, b.get(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Float.MAX_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Float.MIN_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), -java.lang.Float.MAX_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), -java.lang.Float.MIN_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Float.NEGATIVE_INFINITY);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Float.POSITIVE_INFINITY);
		if (java.lang.Float.floatToRawIntBits(v = b.get()) != java.lang.Float.floatToRawIntBits(java.lang.Float.NaN)) {
			javaT.nio.Buffer.Basic.fail(b, ((long) (java.lang.Float.NaN)), ((long) (v)));
		}
		javaT.nio.Buffer.Basic.ck(b, b.get(), 0.91697687F);
		b.rewind();
		java.nio.FloatBuffer b2 = java.nio.FloatBuffer.allocate(b.capacity());
		b2.put(b);
		b2.flip();
		b.position(2);
		b2.position(2);
		if (!b.equals(b2)) {
			for (int i = 2; i < b.limit(); i++) {
				float x = b.get(i);
				float y = b2.get(i);
				if ((x != y) || (java.lang.Float.compare(x, y) != 0)) {
					javaT.nio.Buffer.Basic.out.println((((("[" + i) + "] ") + x) + " != ") + y);
				}
			}
			javaT.nio.Buffer.Basic.fail("Identical buffers not equal", b, b2);
		}
		if (b.compareTo(b2) != 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to identical buffer != 0", b, b2);
		}
		b.limit(b.limit() + 1);
		b.position(b.limit() - 1);
		b.put(((float) (99)));
		b.rewind();
		b2.rewind();
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to shorter buffer <= 0", b, b2);
		}
		b.limit(b.limit() - 1);
		b.put(2, ((float) (42)));
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to lesser buffer <= 0", b, b2);
		}
		for (float x : javaT.nio.Buffer.BasicFloat.VALUES) {
			java.nio.FloatBuffer xb = java.nio.FloatBuffer.wrap(new float[]{ x });
			if (xb.compareTo(xb) != 0) {
				javaT.nio.Buffer.BasicFloat.fail("compareTo not reflexive", xb, xb, x, x);
			}
			if (!xb.equals(xb)) {
				javaT.nio.Buffer.BasicFloat.fail("equals not reflexive", xb, xb, x, x);
			}
			for (float y : javaT.nio.Buffer.BasicFloat.VALUES) {
				java.nio.FloatBuffer yb = java.nio.FloatBuffer.wrap(new float[]{ y });
				if (xb.compareTo(yb) != (-yb.compareTo(xb))) {
					javaT.nio.Buffer.BasicFloat.fail("compareTo not anti-symmetric", xb, yb, x, y);
				}
				if ((xb.compareTo(yb) == 0) != xb.equals(yb)) {
					javaT.nio.Buffer.BasicFloat.fail("compareTo inconsistent with equals", xb, yb, x, y);
				}
				if (xb.compareTo(yb) != java.lang.Float.compare(x, y)) {
					if ((x == 0.0) && (y == 0.0)) {
						continue;
					}
					javaT.nio.Buffer.BasicFloat.fail("Incorrect results for FloatBuffer.compareTo", xb, yb, x, y);
				}
				if (xb.equals(yb) != ((x == y) || ((x != x) && (y != y)))) {
					javaT.nio.Buffer.BasicFloat.fail("Incorrect results for FloatBuffer.equals", xb, yb, x, y);
				}
			}
		}
		javaT.nio.Buffer.BasicFloat.relPut(b);
		javaT.nio.Buffer.BasicFloat.relGet(b.duplicate());
		b.position(13);
		javaT.nio.Buffer.BasicFloat.relGet(b.duplicate(), 13);
		javaT.nio.Buffer.BasicFloat.relGet(b.duplicate().slice(), 13);
		javaT.nio.Buffer.BasicFloat.relGet(b.slice(), 13);
		javaT.nio.Buffer.BasicFloat.relGet(b.slice().duplicate(), 13);
		b.position(5);
		java.nio.FloatBuffer sb = b.slice();
		javaT.nio.Buffer.BasicFloat.checkSlice(b, sb);
		b.position(0);
		java.nio.FloatBuffer sb2 = sb.slice();
		javaT.nio.Buffer.BasicFloat.checkSlice(sb, sb2);
		if (!sb.equals(sb2)) {
			javaT.nio.Buffer.Basic.fail("Sliced slices do not match", sb, sb2);
		}
		if (sb.hasArray() && (sb.arrayOffset() != sb2.arrayOffset())) {
			javaT.nio.Buffer.Basic.fail((("Array offsets do not match: " + sb.arrayOffset()) + " != ") + sb2.arrayOffset(), sb, sb2);
		}
		b.rewind();
		final java.nio.FloatBuffer rb = b.asReadOnlyBuffer();
		if (!b.equals(rb)) {
			javaT.nio.Buffer.Basic.fail("Buffer not equal to read-only view", b, rb);
		}
		javaT.nio.Buffer.Basic.show(level + 1, rb);
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicFloat.relPut(rb);
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicFloat.absPut(rb);
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicFloat.bulkPutArray(rb);
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicFloat.bulkPutBuffer(rb);
			}
		});
		final java.nio.FloatBuffer src = java.nio.FloatBuffer.allocate(1);
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.put(src);
			}
		});
		javaT.nio.Buffer.Basic.ck(src, src.position(), 0);
		javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.compact();
			}
		});
		if (rb.getClass().getName().startsWith("java.nio.Heap")) {
			javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
				public void run() {
					rb.array();
				}
			});
			javaT.nio.Buffer.BasicFloat.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
				public void run() {
					rb.arrayOffset();
				}
			});
			if (rb.hasArray()) {
				javaT.nio.Buffer.Basic.fail("Read-only heap buffer's backing array is accessible", rb);
			}
		}
		b.clear();
		rb.rewind();
		b.put(rb);
		javaT.nio.Buffer.BasicFloat.relPut(b);
	}

	public static void test(final float[] ba) {
		int offset = 47;
		int length = 900;
		final java.nio.FloatBuffer b = java.nio.FloatBuffer.wrap(ba, offset, length);
		javaT.nio.Buffer.Basic.show(0, b);
		javaT.nio.Buffer.Basic.ck(b, b.capacity(), ba.length);
		javaT.nio.Buffer.Basic.ck(b, b.position(), offset);
		javaT.nio.Buffer.Basic.ck(b, b.limit(), offset + length);
		javaT.nio.Buffer.BasicFloat.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.FloatBuffer.wrap(ba, -1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.FloatBuffer.wrap(ba, ba.length + 1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.FloatBuffer.wrap(ba, 0, -1);
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.FloatBuffer.wrap(ba, 0, ba.length + 1);
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.FloatBuffer.wrap(((float[]) (null)), 0, 5);
			}
		});
		javaT.nio.Buffer.BasicFloat.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.FloatBuffer.wrap(((float[]) (null)));
			}
		});
	}

	private static void testAllocate() {
		javaT.nio.Buffer.BasicFloat.tryCatch(((java.nio.Buffer) (null)), java.lang.IllegalArgumentException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.FloatBuffer.allocate(-1);
			}
		});
	}

	public static void test() {
		javaT.nio.Buffer.BasicFloat.testAllocate();
		javaT.nio.Buffer.BasicFloat.test(0, java.nio.FloatBuffer.allocate(7 * 1024), false);
		javaT.nio.Buffer.BasicFloat.test(0, java.nio.FloatBuffer.wrap(new float[7 * 1024], 0, 7 * 1024), false);
		javaT.nio.Buffer.BasicFloat.test(new float[1024]);
		javaT.nio.Buffer.BasicFloat.callReset(java.nio.FloatBuffer.allocate(10));
		javaT.nio.Buffer.BasicFloat.putBuffer();
	}
}