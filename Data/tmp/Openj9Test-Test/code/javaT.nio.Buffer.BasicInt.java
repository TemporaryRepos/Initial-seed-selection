public class BasicInt extends javaT.nio.Buffer.Basic {
	private static final int[] VALUES = new int[]{ java.lang.Integer.MIN_VALUE, ((int) (-1)), ((int) (0)), ((int) (1)), java.lang.Integer.MAX_VALUE };

	private static void relGet(java.nio.IntBuffer b) {
		int n = b.capacity();
		int v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((int) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void relGet(java.nio.IntBuffer b, int start) {
		int n = b.remaining();
		int v;
		for (int i = start; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((int) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void absGet(java.nio.IntBuffer b) {
		int n = b.capacity();
		int v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((int) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void bulkGet(java.nio.IntBuffer b) {
		int n = b.capacity();
		int[] a = new int[n + 7];
		b.get(a, 7, n);
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (a[i + 7])), ((long) ((int) (javaT.nio.Buffer.Basic.ic(i)))));
		}
	}

	private static void relPut(java.nio.IntBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(((int) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.flip();
	}

	private static void absPut(java.nio.IntBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((int) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void bulkPutArray(java.nio.IntBuffer b) {
		int n = b.capacity();
		b.clear();
		int[] a = new int[n + 7];
		for (int i = 0; i < n; i++) {
			a[i + 7] = ((int) (javaT.nio.Buffer.Basic.ic(i)));
		}
		b.put(a, 7, n);
		b.flip();
	}

	private static void bulkPutBuffer(java.nio.IntBuffer b) {
		int n = b.capacity();
		b.clear();
		java.nio.IntBuffer c = java.nio.IntBuffer.allocate(n + 7);
		c.position(7);
		for (int i = 0; i < n; i++) {
			c.put(((int) (javaT.nio.Buffer.Basic.ic(i))));
		}
		c.flip();
		c.position(7);
		b.put(c);
		b.flip();
	}

	private static void callReset(java.nio.IntBuffer b) {
		b.position(0);
		b.mark();
		b.duplicate().reset();
		b.asReadOnlyBuffer().reset();
	}

	private static void putBuffer() {
		final int cap = 10;
		java.nio.IntBuffer direct1 = java.nio.ByteBuffer.allocateDirect(cap).asIntBuffer();
		java.nio.IntBuffer nondirect1 = java.nio.ByteBuffer.allocate(cap).asIntBuffer();
		direct1.put(nondirect1);
		java.nio.IntBuffer direct2 = java.nio.ByteBuffer.allocateDirect(cap).asIntBuffer();
		java.nio.IntBuffer nondirect2 = java.nio.ByteBuffer.allocate(cap).asIntBuffer();
		nondirect2.put(direct2);
		java.nio.IntBuffer direct3 = java.nio.ByteBuffer.allocateDirect(cap).asIntBuffer();
		java.nio.IntBuffer direct4 = java.nio.ByteBuffer.allocateDirect(cap).asIntBuffer();
		direct3.put(direct4);
		java.nio.IntBuffer nondirect3 = java.nio.ByteBuffer.allocate(cap).asIntBuffer();
		java.nio.IntBuffer nondirect4 = java.nio.ByteBuffer.allocate(cap).asIntBuffer();
		nondirect3.put(nondirect4);
	}

	private static void checkSlice(java.nio.IntBuffer b, java.nio.IntBuffer slice) {
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

	private static void fail(java.lang.String problem, java.nio.IntBuffer xb, java.nio.IntBuffer yb, int x, int y) {
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

	private static void tryCatch(int[] t, java.lang.Class<?> ex, java.lang.Runnable thunk) {
		javaT.nio.Buffer.BasicInt.tryCatch(java.nio.IntBuffer.wrap(t), ex, thunk);
	}

	public static void test(int level, final java.nio.IntBuffer b, boolean direct) {
		javaT.nio.Buffer.Basic.show(level, b);
		if (direct != b.isDirect()) {
			javaT.nio.Buffer.Basic.fail("Wrong direction", b);
		}
		javaT.nio.Buffer.BasicInt.relPut(b);
		javaT.nio.Buffer.BasicInt.relGet(b);
		javaT.nio.Buffer.BasicInt.absGet(b);
		javaT.nio.Buffer.BasicInt.bulkGet(b);
		javaT.nio.Buffer.BasicInt.absPut(b);
		javaT.nio.Buffer.BasicInt.relGet(b);
		javaT.nio.Buffer.BasicInt.absGet(b);
		javaT.nio.Buffer.BasicInt.bulkGet(b);
		javaT.nio.Buffer.BasicInt.bulkPutArray(b);
		javaT.nio.Buffer.BasicInt.relGet(b);
		javaT.nio.Buffer.BasicInt.bulkPutBuffer(b);
		javaT.nio.Buffer.BasicInt.relGet(b);
		javaT.nio.Buffer.BasicInt.relPut(b);
		b.position(13);
		b.compact();
		b.flip();
		javaT.nio.Buffer.BasicInt.relGet(b, 13);
		javaT.nio.Buffer.BasicInt.relPut(b);
		b.limit(b.capacity() / 2);
		b.position(b.limit());
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.BufferUnderflowException.class, new java.lang.Runnable() {
			public void run() {
				b.get();
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.BufferOverflowException.class, new java.lang.Runnable() {
			public void run() {
				b.put(((int) (42)));
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(b.limit());
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(-1);
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.put(b.limit(), ((int) (42)));
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.InvalidMarkException.class, new java.lang.Runnable() {
			public void run() {
				b.position(0);
				b.mark();
				b.compact();
				b.reset();
			}
		});
		b.clear();
		b.put(((int) (0)));
		b.put(((int) (-1)));
		b.put(((int) (1)));
		b.put(java.lang.Integer.MAX_VALUE);
		b.put(java.lang.Integer.MIN_VALUE);
		int v;
		b.flip();
		javaT.nio.Buffer.Basic.ck(b, b.get(), 0);
		javaT.nio.Buffer.Basic.ck(b, b.get(), ((int) (-1)));
		javaT.nio.Buffer.Basic.ck(b, b.get(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Integer.MAX_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Integer.MIN_VALUE);
		b.rewind();
		java.nio.IntBuffer b2 = java.nio.IntBuffer.allocate(b.capacity());
		b2.put(b);
		b2.flip();
		b.position(2);
		b2.position(2);
		if (!b.equals(b2)) {
			for (int i = 2; i < b.limit(); i++) {
				int x = b.get(i);
				int y = b2.get(i);
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
		b.put(((int) (99)));
		b.rewind();
		b2.rewind();
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to shorter buffer <= 0", b, b2);
		}
		b.limit(b.limit() - 1);
		b.put(2, ((int) (42)));
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to lesser buffer <= 0", b, b2);
		}
		for (int x : javaT.nio.Buffer.BasicInt.VALUES) {
			java.nio.IntBuffer xb = java.nio.IntBuffer.wrap(new int[]{ x });
			if (xb.compareTo(xb) != 0) {
				javaT.nio.Buffer.BasicInt.fail("compareTo not reflexive", xb, xb, x, x);
			}
			if (!xb.equals(xb)) {
				javaT.nio.Buffer.BasicInt.fail("equals not reflexive", xb, xb, x, x);
			}
			for (int y : javaT.nio.Buffer.BasicInt.VALUES) {
				java.nio.IntBuffer yb = java.nio.IntBuffer.wrap(new int[]{ y });
				if (xb.compareTo(yb) != (-yb.compareTo(xb))) {
					javaT.nio.Buffer.BasicInt.fail("compareTo not anti-symmetric", xb, yb, x, y);
				}
				if ((xb.compareTo(yb) == 0) != xb.equals(yb)) {
					javaT.nio.Buffer.BasicInt.fail("compareTo inconsistent with equals", xb, yb, x, y);
				}
				if (xb.compareTo(yb) != java.lang.Integer.compare(x, y)) {
					javaT.nio.Buffer.BasicInt.fail("Incorrect results for IntBuffer.compareTo", xb, yb, x, y);
				}
				if (xb.equals(yb) != ((x == y) || ((x != x) && (y != y)))) {
					javaT.nio.Buffer.BasicInt.fail("Incorrect results for IntBuffer.equals", xb, yb, x, y);
				}
			}
		}
		javaT.nio.Buffer.BasicInt.relPut(b);
		javaT.nio.Buffer.BasicInt.relGet(b.duplicate());
		b.position(13);
		javaT.nio.Buffer.BasicInt.relGet(b.duplicate(), 13);
		javaT.nio.Buffer.BasicInt.relGet(b.duplicate().slice(), 13);
		javaT.nio.Buffer.BasicInt.relGet(b.slice(), 13);
		javaT.nio.Buffer.BasicInt.relGet(b.slice().duplicate(), 13);
		b.position(5);
		java.nio.IntBuffer sb = b.slice();
		javaT.nio.Buffer.BasicInt.checkSlice(b, sb);
		b.position(0);
		java.nio.IntBuffer sb2 = sb.slice();
		javaT.nio.Buffer.BasicInt.checkSlice(sb, sb2);
		if (!sb.equals(sb2)) {
			javaT.nio.Buffer.Basic.fail("Sliced slices do not match", sb, sb2);
		}
		if (sb.hasArray() && (sb.arrayOffset() != sb2.arrayOffset())) {
			javaT.nio.Buffer.Basic.fail((("Array offsets do not match: " + sb.arrayOffset()) + " != ") + sb2.arrayOffset(), sb, sb2);
		}
		b.rewind();
		final java.nio.IntBuffer rb = b.asReadOnlyBuffer();
		if (!b.equals(rb)) {
			javaT.nio.Buffer.Basic.fail("Buffer not equal to read-only view", b, rb);
		}
		javaT.nio.Buffer.Basic.show(level + 1, rb);
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicInt.relPut(rb);
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicInt.absPut(rb);
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicInt.bulkPutArray(rb);
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicInt.bulkPutBuffer(rb);
			}
		});
		final java.nio.IntBuffer src = java.nio.IntBuffer.allocate(1);
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.put(src);
			}
		});
		javaT.nio.Buffer.Basic.ck(src, src.position(), 0);
		javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.compact();
			}
		});
		if (rb.getClass().getName().startsWith("java.nio.Heap")) {
			javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
				public void run() {
					rb.array();
				}
			});
			javaT.nio.Buffer.BasicInt.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
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
		javaT.nio.Buffer.BasicInt.relPut(b);
	}

	public static void test(final int[] ba) {
		int offset = 47;
		int length = 900;
		final java.nio.IntBuffer b = java.nio.IntBuffer.wrap(ba, offset, length);
		javaT.nio.Buffer.Basic.show(0, b);
		javaT.nio.Buffer.Basic.ck(b, b.capacity(), ba.length);
		javaT.nio.Buffer.Basic.ck(b, b.position(), offset);
		javaT.nio.Buffer.Basic.ck(b, b.limit(), offset + length);
		javaT.nio.Buffer.BasicInt.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.IntBuffer.wrap(ba, -1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.IntBuffer.wrap(ba, ba.length + 1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.IntBuffer.wrap(ba, 0, -1);
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.IntBuffer.wrap(ba, 0, ba.length + 1);
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.IntBuffer.wrap(((int[]) (null)), 0, 5);
			}
		});
		javaT.nio.Buffer.BasicInt.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.IntBuffer.wrap(((int[]) (null)));
			}
		});
	}

	private static void testAllocate() {
		javaT.nio.Buffer.BasicInt.tryCatch(((java.nio.Buffer) (null)), java.lang.IllegalArgumentException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.IntBuffer.allocate(-1);
			}
		});
	}

	public static void test() {
		javaT.nio.Buffer.BasicInt.testAllocate();
		javaT.nio.Buffer.BasicInt.test(0, java.nio.IntBuffer.allocate(7 * 1024), false);
		javaT.nio.Buffer.BasicInt.test(0, java.nio.IntBuffer.wrap(new int[7 * 1024], 0, 7 * 1024), false);
		javaT.nio.Buffer.BasicInt.test(new int[1024]);
		javaT.nio.Buffer.BasicInt.callReset(java.nio.IntBuffer.allocate(10));
		javaT.nio.Buffer.BasicInt.putBuffer();
	}
}