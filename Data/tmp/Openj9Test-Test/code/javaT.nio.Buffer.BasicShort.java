public class BasicShort extends javaT.nio.Buffer.Basic {
	private static final short[] VALUES = new short[]{ java.lang.Short.MIN_VALUE, ((short) (-1)), ((short) (0)), ((short) (1)), java.lang.Short.MAX_VALUE };

	private static void relGet(java.nio.ShortBuffer b) {
		int n = b.capacity();
		short v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((short) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void relGet(java.nio.ShortBuffer b, int start) {
		int n = b.remaining();
		short v;
		for (int i = start; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((short) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void absGet(java.nio.ShortBuffer b) {
		int n = b.capacity();
		short v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((short) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void bulkGet(java.nio.ShortBuffer b) {
		int n = b.capacity();
		short[] a = new short[n + 7];
		b.get(a, 7, n);
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (a[i + 7])), ((long) ((short) (javaT.nio.Buffer.Basic.ic(i)))));
		}
	}

	private static void relPut(java.nio.ShortBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(((short) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.flip();
	}

	private static void absPut(java.nio.ShortBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((short) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void bulkPutArray(java.nio.ShortBuffer b) {
		int n = b.capacity();
		b.clear();
		short[] a = new short[n + 7];
		for (int i = 0; i < n; i++) {
			a[i + 7] = ((short) (javaT.nio.Buffer.Basic.ic(i)));
		}
		b.put(a, 7, n);
		b.flip();
	}

	private static void bulkPutBuffer(java.nio.ShortBuffer b) {
		int n = b.capacity();
		b.clear();
		java.nio.ShortBuffer c = java.nio.ShortBuffer.allocate(n + 7);
		c.position(7);
		for (int i = 0; i < n; i++) {
			c.put(((short) (javaT.nio.Buffer.Basic.ic(i))));
		}
		c.flip();
		c.position(7);
		b.put(c);
		b.flip();
	}

	private static void callReset(java.nio.ShortBuffer b) {
		b.position(0);
		b.mark();
		b.duplicate().reset();
		b.asReadOnlyBuffer().reset();
	}

	private static void putBuffer() {
		final int cap = 10;
		java.nio.ShortBuffer direct1 = java.nio.ByteBuffer.allocateDirect(cap).asShortBuffer();
		java.nio.ShortBuffer nondirect1 = java.nio.ByteBuffer.allocate(cap).asShortBuffer();
		direct1.put(nondirect1);
		java.nio.ShortBuffer direct2 = java.nio.ByteBuffer.allocateDirect(cap).asShortBuffer();
		java.nio.ShortBuffer nondirect2 = java.nio.ByteBuffer.allocate(cap).asShortBuffer();
		nondirect2.put(direct2);
		java.nio.ShortBuffer direct3 = java.nio.ByteBuffer.allocateDirect(cap).asShortBuffer();
		java.nio.ShortBuffer direct4 = java.nio.ByteBuffer.allocateDirect(cap).asShortBuffer();
		direct3.put(direct4);
		java.nio.ShortBuffer nondirect3 = java.nio.ByteBuffer.allocate(cap).asShortBuffer();
		java.nio.ShortBuffer nondirect4 = java.nio.ByteBuffer.allocate(cap).asShortBuffer();
		nondirect3.put(nondirect4);
	}

	private static void checkSlice(java.nio.ShortBuffer b, java.nio.ShortBuffer slice) {
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

	private static void fail(java.lang.String problem, java.nio.ShortBuffer xb, java.nio.ShortBuffer yb, short x, short y) {
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

	private static void tryCatch(short[] t, java.lang.Class<?> ex, java.lang.Runnable thunk) {
		javaT.nio.Buffer.BasicShort.tryCatch(java.nio.ShortBuffer.wrap(t), ex, thunk);
	}

	public static void test(int level, final java.nio.ShortBuffer b, boolean direct) {
		javaT.nio.Buffer.Basic.show(level, b);
		if (direct != b.isDirect()) {
			javaT.nio.Buffer.Basic.fail("Wrong direction", b);
		}
		javaT.nio.Buffer.BasicShort.relPut(b);
		javaT.nio.Buffer.BasicShort.relGet(b);
		javaT.nio.Buffer.BasicShort.absGet(b);
		javaT.nio.Buffer.BasicShort.bulkGet(b);
		javaT.nio.Buffer.BasicShort.absPut(b);
		javaT.nio.Buffer.BasicShort.relGet(b);
		javaT.nio.Buffer.BasicShort.absGet(b);
		javaT.nio.Buffer.BasicShort.bulkGet(b);
		javaT.nio.Buffer.BasicShort.bulkPutArray(b);
		javaT.nio.Buffer.BasicShort.relGet(b);
		javaT.nio.Buffer.BasicShort.bulkPutBuffer(b);
		javaT.nio.Buffer.BasicShort.relGet(b);
		javaT.nio.Buffer.BasicShort.relPut(b);
		b.position(13);
		b.compact();
		b.flip();
		javaT.nio.Buffer.BasicShort.relGet(b, 13);
		javaT.nio.Buffer.BasicShort.relPut(b);
		b.limit(b.capacity() / 2);
		b.position(b.limit());
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.BufferUnderflowException.class, new java.lang.Runnable() {
			public void run() {
				b.get();
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.BufferOverflowException.class, new java.lang.Runnable() {
			public void run() {
				b.put(((short) (42)));
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(b.limit());
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(-1);
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.put(b.limit(), ((short) (42)));
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.InvalidMarkException.class, new java.lang.Runnable() {
			public void run() {
				b.position(0);
				b.mark();
				b.compact();
				b.reset();
			}
		});
		b.clear();
		b.put(((short) (0)));
		b.put(((short) (-1)));
		b.put(((short) (1)));
		b.put(java.lang.Short.MAX_VALUE);
		b.put(java.lang.Short.MIN_VALUE);
		short v;
		b.flip();
		javaT.nio.Buffer.Basic.ck(b, b.get(), 0);
		javaT.nio.Buffer.Basic.ck(b, b.get(), ((short) (-1)));
		javaT.nio.Buffer.Basic.ck(b, b.get(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Short.MAX_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Short.MIN_VALUE);
		b.rewind();
		java.nio.ShortBuffer b2 = java.nio.ShortBuffer.allocate(b.capacity());
		b2.put(b);
		b2.flip();
		b.position(2);
		b2.position(2);
		if (!b.equals(b2)) {
			for (int i = 2; i < b.limit(); i++) {
				short x = b.get(i);
				short y = b2.get(i);
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
		b.put(((short) (99)));
		b.rewind();
		b2.rewind();
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to shorter buffer <= 0", b, b2);
		}
		b.limit(b.limit() - 1);
		b.put(2, ((short) (42)));
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to lesser buffer <= 0", b, b2);
		}
		for (short x : javaT.nio.Buffer.BasicShort.VALUES) {
			java.nio.ShortBuffer xb = java.nio.ShortBuffer.wrap(new short[]{ x });
			if (xb.compareTo(xb) != 0) {
				javaT.nio.Buffer.BasicShort.fail("compareTo not reflexive", xb, xb, x, x);
			}
			if (!xb.equals(xb)) {
				javaT.nio.Buffer.BasicShort.fail("equals not reflexive", xb, xb, x, x);
			}
			for (short y : javaT.nio.Buffer.BasicShort.VALUES) {
				java.nio.ShortBuffer yb = java.nio.ShortBuffer.wrap(new short[]{ y });
				if (xb.compareTo(yb) != (-yb.compareTo(xb))) {
					javaT.nio.Buffer.BasicShort.fail("compareTo not anti-symmetric", xb, yb, x, y);
				}
				if ((xb.compareTo(yb) == 0) != xb.equals(yb)) {
					javaT.nio.Buffer.BasicShort.fail("compareTo inconsistent with equals", xb, yb, x, y);
				}
				if (xb.compareTo(yb) != java.lang.Short.compare(x, y)) {
					javaT.nio.Buffer.BasicShort.fail("Incorrect results for ShortBuffer.compareTo", xb, yb, x, y);
				}
				if (xb.equals(yb) != ((x == y) || ((x != x) && (y != y)))) {
					javaT.nio.Buffer.BasicShort.fail("Incorrect results for ShortBuffer.equals", xb, yb, x, y);
				}
			}
		}
		javaT.nio.Buffer.BasicShort.relPut(b);
		javaT.nio.Buffer.BasicShort.relGet(b.duplicate());
		b.position(13);
		javaT.nio.Buffer.BasicShort.relGet(b.duplicate(), 13);
		javaT.nio.Buffer.BasicShort.relGet(b.duplicate().slice(), 13);
		javaT.nio.Buffer.BasicShort.relGet(b.slice(), 13);
		javaT.nio.Buffer.BasicShort.relGet(b.slice().duplicate(), 13);
		b.position(5);
		java.nio.ShortBuffer sb = b.slice();
		javaT.nio.Buffer.BasicShort.checkSlice(b, sb);
		b.position(0);
		java.nio.ShortBuffer sb2 = sb.slice();
		javaT.nio.Buffer.BasicShort.checkSlice(sb, sb2);
		if (!sb.equals(sb2)) {
			javaT.nio.Buffer.Basic.fail("Sliced slices do not match", sb, sb2);
		}
		if (sb.hasArray() && (sb.arrayOffset() != sb2.arrayOffset())) {
			javaT.nio.Buffer.Basic.fail((("Array offsets do not match: " + sb.arrayOffset()) + " != ") + sb2.arrayOffset(), sb, sb2);
		}
		b.rewind();
		final java.nio.ShortBuffer rb = b.asReadOnlyBuffer();
		if (!b.equals(rb)) {
			javaT.nio.Buffer.Basic.fail("Buffer not equal to read-only view", b, rb);
		}
		javaT.nio.Buffer.Basic.show(level + 1, rb);
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicShort.relPut(rb);
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicShort.absPut(rb);
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicShort.bulkPutArray(rb);
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicShort.bulkPutBuffer(rb);
			}
		});
		final java.nio.ShortBuffer src = java.nio.ShortBuffer.allocate(1);
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.put(src);
			}
		});
		javaT.nio.Buffer.Basic.ck(src, src.position(), 0);
		javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.compact();
			}
		});
		if (rb.getClass().getName().startsWith("java.nio.Heap")) {
			javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
				public void run() {
					rb.array();
				}
			});
			javaT.nio.Buffer.BasicShort.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
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
		javaT.nio.Buffer.BasicShort.relPut(b);
	}

	public static void test(final short[] ba) {
		int offset = 47;
		int length = 900;
		final java.nio.ShortBuffer b = java.nio.ShortBuffer.wrap(ba, offset, length);
		javaT.nio.Buffer.Basic.show(0, b);
		javaT.nio.Buffer.Basic.ck(b, b.capacity(), ba.length);
		javaT.nio.Buffer.Basic.ck(b, b.position(), offset);
		javaT.nio.Buffer.Basic.ck(b, b.limit(), offset + length);
		javaT.nio.Buffer.BasicShort.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ShortBuffer.wrap(ba, -1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ShortBuffer.wrap(ba, ba.length + 1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ShortBuffer.wrap(ba, 0, -1);
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ShortBuffer.wrap(ba, 0, ba.length + 1);
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ShortBuffer.wrap(((short[]) (null)), 0, 5);
			}
		});
		javaT.nio.Buffer.BasicShort.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ShortBuffer.wrap(((short[]) (null)));
			}
		});
	}

	private static void testAllocate() {
		javaT.nio.Buffer.BasicShort.tryCatch(((java.nio.Buffer) (null)), java.lang.IllegalArgumentException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ShortBuffer.allocate(-1);
			}
		});
	}

	public static void test() {
		javaT.nio.Buffer.BasicShort.testAllocate();
		javaT.nio.Buffer.BasicShort.test(0, java.nio.ShortBuffer.allocate(7 * 1024), false);
		javaT.nio.Buffer.BasicShort.test(0, java.nio.ShortBuffer.wrap(new short[7 * 1024], 0, 7 * 1024), false);
		javaT.nio.Buffer.BasicShort.test(new short[1024]);
		javaT.nio.Buffer.BasicShort.callReset(java.nio.ShortBuffer.allocate(10));
		javaT.nio.Buffer.BasicShort.putBuffer();
	}
}