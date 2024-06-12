public class BasicDouble extends javaT.nio.Buffer.Basic {
	private static final double[] VALUES = new double[]{ java.lang.Double.MIN_VALUE, ((double) (-1)), ((double) (0)), ((double) (1)), java.lang.Double.MAX_VALUE, java.lang.Double.NEGATIVE_INFINITY, java.lang.Double.POSITIVE_INFINITY, java.lang.Double.NaN, ((double) (-0.0)) };

	private static void relGet(java.nio.DoubleBuffer b) {
		int n = b.capacity();
		double v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((double) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void relGet(java.nio.DoubleBuffer b, int start) {
		int n = b.remaining();
		double v;
		for (int i = start; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((double) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void absGet(java.nio.DoubleBuffer b) {
		int n = b.capacity();
		double v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((double) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void bulkGet(java.nio.DoubleBuffer b) {
		int n = b.capacity();
		double[] a = new double[n + 7];
		b.get(a, 7, n);
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (a[i + 7])), ((long) ((double) (javaT.nio.Buffer.Basic.ic(i)))));
		}
	}

	private static void relPut(java.nio.DoubleBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(((double) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.flip();
	}

	private static void absPut(java.nio.DoubleBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((double) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void bulkPutArray(java.nio.DoubleBuffer b) {
		int n = b.capacity();
		b.clear();
		double[] a = new double[n + 7];
		for (int i = 0; i < n; i++) {
			a[i + 7] = ((double) (javaT.nio.Buffer.Basic.ic(i)));
		}
		b.put(a, 7, n);
		b.flip();
	}

	private static void bulkPutBuffer(java.nio.DoubleBuffer b) {
		int n = b.capacity();
		b.clear();
		java.nio.DoubleBuffer c = java.nio.DoubleBuffer.allocate(n + 7);
		c.position(7);
		for (int i = 0; i < n; i++) {
			c.put(((double) (javaT.nio.Buffer.Basic.ic(i))));
		}
		c.flip();
		c.position(7);
		b.put(c);
		b.flip();
	}

	private static void callReset(java.nio.DoubleBuffer b) {
		b.position(0);
		b.mark();
		b.duplicate().reset();
		b.asReadOnlyBuffer().reset();
	}

	private static void putBuffer() {
		final int cap = 10;
		java.nio.DoubleBuffer direct1 = java.nio.ByteBuffer.allocateDirect(cap).asDoubleBuffer();
		java.nio.DoubleBuffer nondirect1 = java.nio.ByteBuffer.allocate(cap).asDoubleBuffer();
		direct1.put(nondirect1);
		java.nio.DoubleBuffer direct2 = java.nio.ByteBuffer.allocateDirect(cap).asDoubleBuffer();
		java.nio.DoubleBuffer nondirect2 = java.nio.ByteBuffer.allocate(cap).asDoubleBuffer();
		nondirect2.put(direct2);
		java.nio.DoubleBuffer direct3 = java.nio.ByteBuffer.allocateDirect(cap).asDoubleBuffer();
		java.nio.DoubleBuffer direct4 = java.nio.ByteBuffer.allocateDirect(cap).asDoubleBuffer();
		direct3.put(direct4);
		java.nio.DoubleBuffer nondirect3 = java.nio.ByteBuffer.allocate(cap).asDoubleBuffer();
		java.nio.DoubleBuffer nondirect4 = java.nio.ByteBuffer.allocate(cap).asDoubleBuffer();
		nondirect3.put(nondirect4);
	}

	private static void checkSlice(java.nio.DoubleBuffer b, java.nio.DoubleBuffer slice) {
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

	private static void fail(java.lang.String problem, java.nio.DoubleBuffer xb, java.nio.DoubleBuffer yb, double x, double y) {
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

	private static void tryCatch(double[] t, java.lang.Class<?> ex, java.lang.Runnable thunk) {
		javaT.nio.Buffer.BasicDouble.tryCatch(java.nio.DoubleBuffer.wrap(t), ex, thunk);
	}

	public static void test(int level, final java.nio.DoubleBuffer b, boolean direct) {
		javaT.nio.Buffer.Basic.show(level, b);
		if (direct != b.isDirect()) {
			javaT.nio.Buffer.Basic.fail("Wrong direction", b);
		}
		javaT.nio.Buffer.BasicDouble.relPut(b);
		javaT.nio.Buffer.BasicDouble.relGet(b);
		javaT.nio.Buffer.BasicDouble.absGet(b);
		javaT.nio.Buffer.BasicDouble.bulkGet(b);
		javaT.nio.Buffer.BasicDouble.absPut(b);
		javaT.nio.Buffer.BasicDouble.relGet(b);
		javaT.nio.Buffer.BasicDouble.absGet(b);
		javaT.nio.Buffer.BasicDouble.bulkGet(b);
		javaT.nio.Buffer.BasicDouble.bulkPutArray(b);
		javaT.nio.Buffer.BasicDouble.relGet(b);
		javaT.nio.Buffer.BasicDouble.bulkPutBuffer(b);
		javaT.nio.Buffer.BasicDouble.relGet(b);
		javaT.nio.Buffer.BasicDouble.relPut(b);
		b.position(13);
		b.compact();
		b.flip();
		javaT.nio.Buffer.BasicDouble.relGet(b, 13);
		javaT.nio.Buffer.BasicDouble.relPut(b);
		b.limit(b.capacity() / 2);
		b.position(b.limit());
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.BufferUnderflowException.class, new java.lang.Runnable() {
			public void run() {
				b.get();
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.BufferOverflowException.class, new java.lang.Runnable() {
			public void run() {
				b.put(((double) (42)));
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(b.limit());
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(-1);
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.put(b.limit(), ((double) (42)));
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.InvalidMarkException.class, new java.lang.Runnable() {
			public void run() {
				b.position(0);
				b.mark();
				b.compact();
				b.reset();
			}
		});
		b.clear();
		b.put(((double) (0)));
		b.put(((double) (-1)));
		b.put(((double) (1)));
		b.put(java.lang.Double.MAX_VALUE);
		b.put(java.lang.Double.MIN_VALUE);
		b.put(-java.lang.Double.MAX_VALUE);
		b.put(-java.lang.Double.MIN_VALUE);
		b.put(java.lang.Double.NEGATIVE_INFINITY);
		b.put(java.lang.Double.POSITIVE_INFINITY);
		b.put(java.lang.Double.NaN);
		b.put(0.5121609353879392);
		double v;
		b.flip();
		javaT.nio.Buffer.Basic.ck(b, b.get(), 0);
		javaT.nio.Buffer.Basic.ck(b, b.get(), ((double) (-1)));
		javaT.nio.Buffer.Basic.ck(b, b.get(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Double.MAX_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Double.MIN_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), -java.lang.Double.MAX_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), -java.lang.Double.MIN_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Double.NEGATIVE_INFINITY);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Double.POSITIVE_INFINITY);
		if (java.lang.Double.doubleToRawLongBits(v = b.get()) != java.lang.Double.doubleToRawLongBits(java.lang.Double.NaN)) {
			javaT.nio.Buffer.Basic.fail(b, ((long) (java.lang.Double.NaN)), ((long) (v)));
		}
		javaT.nio.Buffer.Basic.ck(b, b.get(), 0.5121609353879392);
		b.rewind();
		java.nio.DoubleBuffer b2 = java.nio.DoubleBuffer.allocate(b.capacity());
		b2.put(b);
		b2.flip();
		b.position(2);
		b2.position(2);
		if (!b.equals(b2)) {
			for (int i = 2; i < b.limit(); i++) {
				double x = b.get(i);
				double y = b2.get(i);
				if ((x != y) || (java.lang.Double.compare(x, y) != 0)) {
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
		b.put(((double) (99)));
		b.rewind();
		b2.rewind();
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to shorter buffer <= 0", b, b2);
		}
		b.limit(b.limit() - 1);
		b.put(2, ((double) (42)));
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to lesser buffer <= 0", b, b2);
		}
		for (double x : javaT.nio.Buffer.BasicDouble.VALUES) {
			java.nio.DoubleBuffer xb = java.nio.DoubleBuffer.wrap(new double[]{ x });
			if (xb.compareTo(xb) != 0) {
				javaT.nio.Buffer.BasicDouble.fail("compareTo not reflexive", xb, xb, x, x);
			}
			if (!xb.equals(xb)) {
				javaT.nio.Buffer.BasicDouble.fail("equals not reflexive", xb, xb, x, x);
			}
			for (double y : javaT.nio.Buffer.BasicDouble.VALUES) {
				java.nio.DoubleBuffer yb = java.nio.DoubleBuffer.wrap(new double[]{ y });
				if (xb.compareTo(yb) != (-yb.compareTo(xb))) {
					javaT.nio.Buffer.BasicDouble.fail("compareTo not anti-symmetric", xb, yb, x, y);
				}
				if ((xb.compareTo(yb) == 0) != xb.equals(yb)) {
					javaT.nio.Buffer.BasicDouble.fail("compareTo inconsistent with equals", xb, yb, x, y);
				}
				if (xb.compareTo(yb) != java.lang.Double.compare(x, y)) {
					if ((x == 0.0) && (y == 0.0)) {
						continue;
					}
					javaT.nio.Buffer.BasicDouble.fail("Incorrect results for DoubleBuffer.compareTo", xb, yb, x, y);
				}
				if (xb.equals(yb) != ((x == y) || ((x != x) && (y != y)))) {
					javaT.nio.Buffer.BasicDouble.fail("Incorrect results for DoubleBuffer.equals", xb, yb, x, y);
				}
			}
		}
		javaT.nio.Buffer.BasicDouble.relPut(b);
		javaT.nio.Buffer.BasicDouble.relGet(b.duplicate());
		b.position(13);
		javaT.nio.Buffer.BasicDouble.relGet(b.duplicate(), 13);
		javaT.nio.Buffer.BasicDouble.relGet(b.duplicate().slice(), 13);
		javaT.nio.Buffer.BasicDouble.relGet(b.slice(), 13);
		javaT.nio.Buffer.BasicDouble.relGet(b.slice().duplicate(), 13);
		b.position(5);
		java.nio.DoubleBuffer sb = b.slice();
		javaT.nio.Buffer.BasicDouble.checkSlice(b, sb);
		b.position(0);
		java.nio.DoubleBuffer sb2 = sb.slice();
		javaT.nio.Buffer.BasicDouble.checkSlice(sb, sb2);
		if (!sb.equals(sb2)) {
			javaT.nio.Buffer.Basic.fail("Sliced slices do not match", sb, sb2);
		}
		if (sb.hasArray() && (sb.arrayOffset() != sb2.arrayOffset())) {
			javaT.nio.Buffer.Basic.fail((("Array offsets do not match: " + sb.arrayOffset()) + " != ") + sb2.arrayOffset(), sb, sb2);
		}
		b.rewind();
		final java.nio.DoubleBuffer rb = b.asReadOnlyBuffer();
		if (!b.equals(rb)) {
			javaT.nio.Buffer.Basic.fail("Buffer not equal to read-only view", b, rb);
		}
		javaT.nio.Buffer.Basic.show(level + 1, rb);
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicDouble.relPut(rb);
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicDouble.absPut(rb);
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicDouble.bulkPutArray(rb);
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicDouble.bulkPutBuffer(rb);
			}
		});
		final java.nio.DoubleBuffer src = java.nio.DoubleBuffer.allocate(1);
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.put(src);
			}
		});
		javaT.nio.Buffer.Basic.ck(src, src.position(), 0);
		javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.compact();
			}
		});
		if (rb.getClass().getName().startsWith("java.nio.Heap")) {
			javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
				public void run() {
					rb.array();
				}
			});
			javaT.nio.Buffer.BasicDouble.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
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
		javaT.nio.Buffer.BasicDouble.relPut(b);
	}

	public static void test(final double[] ba) {
		int offset = 47;
		int length = 900;
		final java.nio.DoubleBuffer b = java.nio.DoubleBuffer.wrap(ba, offset, length);
		javaT.nio.Buffer.Basic.show(0, b);
		javaT.nio.Buffer.Basic.ck(b, b.capacity(), ba.length);
		javaT.nio.Buffer.Basic.ck(b, b.position(), offset);
		javaT.nio.Buffer.Basic.ck(b, b.limit(), offset + length);
		javaT.nio.Buffer.BasicDouble.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.DoubleBuffer.wrap(ba, -1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.DoubleBuffer.wrap(ba, ba.length + 1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.DoubleBuffer.wrap(ba, 0, -1);
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.DoubleBuffer.wrap(ba, 0, ba.length + 1);
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.DoubleBuffer.wrap(((double[]) (null)), 0, 5);
			}
		});
		javaT.nio.Buffer.BasicDouble.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.DoubleBuffer.wrap(((double[]) (null)));
			}
		});
	}

	private static void testAllocate() {
		javaT.nio.Buffer.BasicDouble.tryCatch(((java.nio.Buffer) (null)), java.lang.IllegalArgumentException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.DoubleBuffer.allocate(-1);
			}
		});
	}

	public static void test() {
		javaT.nio.Buffer.BasicDouble.testAllocate();
		javaT.nio.Buffer.BasicDouble.test(0, java.nio.DoubleBuffer.allocate(7 * 1024), false);
		javaT.nio.Buffer.BasicDouble.test(0, java.nio.DoubleBuffer.wrap(new double[7 * 1024], 0, 7 * 1024), false);
		javaT.nio.Buffer.BasicDouble.test(new double[1024]);
		javaT.nio.Buffer.BasicDouble.callReset(java.nio.DoubleBuffer.allocate(10));
		javaT.nio.Buffer.BasicDouble.putBuffer();
	}
}