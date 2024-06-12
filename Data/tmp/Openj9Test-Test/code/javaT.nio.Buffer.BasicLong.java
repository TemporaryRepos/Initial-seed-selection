public class BasicLong extends javaT.nio.Buffer.Basic {
	private static final long[] VALUES = new long[]{ java.lang.Long.MIN_VALUE, ((long) (-1)), ((long) (0)), ((long) (1)), java.lang.Long.MAX_VALUE };

	private static void relGet(java.nio.LongBuffer b) {
		int n = b.capacity();
		long v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((long) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void relGet(java.nio.LongBuffer b, int start) {
		int n = b.remaining();
		long v;
		for (int i = start; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((long) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void absGet(java.nio.LongBuffer b) {
		int n = b.capacity();
		long v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((long) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void bulkGet(java.nio.LongBuffer b) {
		int n = b.capacity();
		long[] a = new long[n + 7];
		b.get(a, 7, n);
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (a[i + 7])), ((long) ((long) (javaT.nio.Buffer.Basic.ic(i)))));
		}
	}

	private static void relPut(java.nio.LongBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(((long) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.flip();
	}

	private static void absPut(java.nio.LongBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((long) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void bulkPutArray(java.nio.LongBuffer b) {
		int n = b.capacity();
		b.clear();
		long[] a = new long[n + 7];
		for (int i = 0; i < n; i++) {
			a[i + 7] = ((long) (javaT.nio.Buffer.Basic.ic(i)));
		}
		b.put(a, 7, n);
		b.flip();
	}

	private static void bulkPutBuffer(java.nio.LongBuffer b) {
		int n = b.capacity();
		b.clear();
		java.nio.LongBuffer c = java.nio.LongBuffer.allocate(n + 7);
		c.position(7);
		for (int i = 0; i < n; i++) {
			c.put(((long) (javaT.nio.Buffer.Basic.ic(i))));
		}
		c.flip();
		c.position(7);
		b.put(c);
		b.flip();
	}

	private static void callReset(java.nio.LongBuffer b) {
		b.position(0);
		b.mark();
		b.duplicate().reset();
		b.asReadOnlyBuffer().reset();
	}

	private static void putBuffer() {
		final int cap = 10;
		java.nio.LongBuffer direct1 = java.nio.ByteBuffer.allocateDirect(cap).asLongBuffer();
		java.nio.LongBuffer nondirect1 = java.nio.ByteBuffer.allocate(cap).asLongBuffer();
		direct1.put(nondirect1);
		java.nio.LongBuffer direct2 = java.nio.ByteBuffer.allocateDirect(cap).asLongBuffer();
		java.nio.LongBuffer nondirect2 = java.nio.ByteBuffer.allocate(cap).asLongBuffer();
		nondirect2.put(direct2);
		java.nio.LongBuffer direct3 = java.nio.ByteBuffer.allocateDirect(cap).asLongBuffer();
		java.nio.LongBuffer direct4 = java.nio.ByteBuffer.allocateDirect(cap).asLongBuffer();
		direct3.put(direct4);
		java.nio.LongBuffer nondirect3 = java.nio.ByteBuffer.allocate(cap).asLongBuffer();
		java.nio.LongBuffer nondirect4 = java.nio.ByteBuffer.allocate(cap).asLongBuffer();
		nondirect3.put(nondirect4);
	}

	private static void checkSlice(java.nio.LongBuffer b, java.nio.LongBuffer slice) {
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

	private static void fail(java.lang.String problem, java.nio.LongBuffer xb, java.nio.LongBuffer yb, long x, long y) {
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

	private static void tryCatch(long[] t, java.lang.Class<?> ex, java.lang.Runnable thunk) {
		javaT.nio.Buffer.BasicLong.tryCatch(java.nio.LongBuffer.wrap(t), ex, thunk);
	}

	public static void test(int level, final java.nio.LongBuffer b, boolean direct) {
		javaT.nio.Buffer.Basic.show(level, b);
		if (direct != b.isDirect()) {
			javaT.nio.Buffer.Basic.fail("Wrong direction", b);
		}
		javaT.nio.Buffer.BasicLong.relPut(b);
		javaT.nio.Buffer.BasicLong.relGet(b);
		javaT.nio.Buffer.BasicLong.absGet(b);
		javaT.nio.Buffer.BasicLong.bulkGet(b);
		javaT.nio.Buffer.BasicLong.absPut(b);
		javaT.nio.Buffer.BasicLong.relGet(b);
		javaT.nio.Buffer.BasicLong.absGet(b);
		javaT.nio.Buffer.BasicLong.bulkGet(b);
		javaT.nio.Buffer.BasicLong.bulkPutArray(b);
		javaT.nio.Buffer.BasicLong.relGet(b);
		javaT.nio.Buffer.BasicLong.bulkPutBuffer(b);
		javaT.nio.Buffer.BasicLong.relGet(b);
		javaT.nio.Buffer.BasicLong.relPut(b);
		b.position(13);
		b.compact();
		b.flip();
		javaT.nio.Buffer.BasicLong.relGet(b, 13);
		javaT.nio.Buffer.BasicLong.relPut(b);
		b.limit(b.capacity() / 2);
		b.position(b.limit());
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.BufferUnderflowException.class, new java.lang.Runnable() {
			public void run() {
				b.get();
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.BufferOverflowException.class, new java.lang.Runnable() {
			public void run() {
				b.put(((long) (42)));
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(b.limit());
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(-1);
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.put(b.limit(), ((long) (42)));
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.InvalidMarkException.class, new java.lang.Runnable() {
			public void run() {
				b.position(0);
				b.mark();
				b.compact();
				b.reset();
			}
		});
		b.clear();
		b.put(((long) (0)));
		b.put(((long) (-1)));
		b.put(((long) (1)));
		b.put(java.lang.Long.MAX_VALUE);
		b.put(java.lang.Long.MIN_VALUE);
		long v;
		b.flip();
		javaT.nio.Buffer.Basic.ck(b, b.get(), 0);
		javaT.nio.Buffer.Basic.ck(b, b.get(), ((long) (-1)));
		javaT.nio.Buffer.Basic.ck(b, b.get(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Long.MAX_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Long.MIN_VALUE);
		b.rewind();
		java.nio.LongBuffer b2 = java.nio.LongBuffer.allocate(b.capacity());
		b2.put(b);
		b2.flip();
		b.position(2);
		b2.position(2);
		if (!b.equals(b2)) {
			for (int i = 2; i < b.limit(); i++) {
				long x = b.get(i);
				long y = b2.get(i);
				if (x != y) {
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
		b.put(((long) (99)));
		b.rewind();
		b2.rewind();
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to shorter buffer <= 0", b, b2);
		}
		b.limit(b.limit() - 1);
		b.put(2, ((long) (42)));
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to lesser buffer <= 0", b, b2);
		}
		for (long x : javaT.nio.Buffer.BasicLong.VALUES) {
			java.nio.LongBuffer xb = java.nio.LongBuffer.wrap(new long[]{ x });
			if (xb.compareTo(xb) != 0) {
				javaT.nio.Buffer.BasicLong.fail("compareTo not reflexive", xb, xb, x, x);
			}
			if (!xb.equals(xb)) {
				javaT.nio.Buffer.BasicLong.fail("equals not reflexive", xb, xb, x, x);
			}
			for (long y : javaT.nio.Buffer.BasicLong.VALUES) {
				java.nio.LongBuffer yb = java.nio.LongBuffer.wrap(new long[]{ y });
				if (xb.compareTo(yb) != (-yb.compareTo(xb))) {
					javaT.nio.Buffer.BasicLong.fail("compareTo not anti-symmetric", xb, yb, x, y);
				}
				if ((xb.compareTo(yb) == 0) != xb.equals(yb)) {
					javaT.nio.Buffer.BasicLong.fail("compareTo inconsistent with equals", xb, yb, x, y);
				}
				if (xb.compareTo(yb) != java.lang.Long.compare(x, y)) {
					javaT.nio.Buffer.BasicLong.fail("Incorrect results for LongBuffer.compareTo", xb, yb, x, y);
				}
				if (xb.equals(yb) != ((x == y) || ((x != x) && (y != y)))) {
					javaT.nio.Buffer.BasicLong.fail("Incorrect results for LongBuffer.equals", xb, yb, x, y);
				}
			}
		}
		javaT.nio.Buffer.BasicLong.relPut(b);
		javaT.nio.Buffer.BasicLong.relGet(b.duplicate());
		b.position(13);
		javaT.nio.Buffer.BasicLong.relGet(b.duplicate(), 13);
		javaT.nio.Buffer.BasicLong.relGet(b.duplicate().slice(), 13);
		javaT.nio.Buffer.BasicLong.relGet(b.slice(), 13);
		javaT.nio.Buffer.BasicLong.relGet(b.slice().duplicate(), 13);
		b.position(5);
		java.nio.LongBuffer sb = b.slice();
		javaT.nio.Buffer.BasicLong.checkSlice(b, sb);
		b.position(0);
		java.nio.LongBuffer sb2 = sb.slice();
		javaT.nio.Buffer.BasicLong.checkSlice(sb, sb2);
		if (!sb.equals(sb2)) {
			javaT.nio.Buffer.Basic.fail("Sliced slices do not match", sb, sb2);
		}
		if (sb.hasArray() && (sb.arrayOffset() != sb2.arrayOffset())) {
			javaT.nio.Buffer.Basic.fail((("Array offsets do not match: " + sb.arrayOffset()) + " != ") + sb2.arrayOffset(), sb, sb2);
		}
		b.rewind();
		final java.nio.LongBuffer rb = b.asReadOnlyBuffer();
		if (!b.equals(rb)) {
			javaT.nio.Buffer.Basic.fail("Buffer not equal to read-only view", b, rb);
		}
		javaT.nio.Buffer.Basic.show(level + 1, rb);
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicLong.relPut(rb);
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicLong.absPut(rb);
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicLong.bulkPutArray(rb);
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicLong.bulkPutBuffer(rb);
			}
		});
		final java.nio.LongBuffer src = java.nio.LongBuffer.allocate(1);
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.put(src);
			}
		});
		javaT.nio.Buffer.Basic.ck(src, src.position(), 0);
		javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.compact();
			}
		});
		if (rb.getClass().getName().startsWith("java.nio.Heap")) {
			javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
				public void run() {
					rb.array();
				}
			});
			javaT.nio.Buffer.BasicLong.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
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
		javaT.nio.Buffer.BasicLong.relPut(b);
	}

	public static void test(final long[] ba) {
		int offset = 47;
		int length = 900;
		final java.nio.LongBuffer b = java.nio.LongBuffer.wrap(ba, offset, length);
		javaT.nio.Buffer.Basic.show(0, b);
		javaT.nio.Buffer.Basic.ck(b, b.capacity(), ba.length);
		javaT.nio.Buffer.Basic.ck(b, b.position(), offset);
		javaT.nio.Buffer.Basic.ck(b, b.limit(), offset + length);
		javaT.nio.Buffer.BasicLong.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.LongBuffer.wrap(ba, -1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.LongBuffer.wrap(ba, ba.length + 1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.LongBuffer.wrap(ba, 0, -1);
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.LongBuffer.wrap(ba, 0, ba.length + 1);
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.LongBuffer.wrap(((long[]) (null)), 0, 5);
			}
		});
		javaT.nio.Buffer.BasicLong.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.LongBuffer.wrap(((long[]) (null)));
			}
		});
	}

	private static void testAllocate() {
		javaT.nio.Buffer.BasicLong.tryCatch(((java.nio.Buffer) (null)), java.lang.IllegalArgumentException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.LongBuffer.allocate(-1);
			}
		});
	}

	public static void test() {
		javaT.nio.Buffer.BasicLong.testAllocate();
		javaT.nio.Buffer.BasicLong.test(0, java.nio.LongBuffer.allocate(7 * 1024), false);
		javaT.nio.Buffer.BasicLong.test(0, java.nio.LongBuffer.wrap(new long[7 * 1024], 0, 7 * 1024), false);
		javaT.nio.Buffer.BasicLong.test(new long[1024]);
		javaT.nio.Buffer.BasicLong.callReset(java.nio.LongBuffer.allocate(10));
		javaT.nio.Buffer.BasicLong.putBuffer();
	}
}