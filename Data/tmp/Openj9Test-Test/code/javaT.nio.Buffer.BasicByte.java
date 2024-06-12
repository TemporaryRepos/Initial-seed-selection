public class BasicByte extends javaT.nio.Buffer.Basic {
	private static final byte[] VALUES = new byte[]{ java.lang.Byte.MIN_VALUE, ((byte) (-1)), ((byte) (0)), ((byte) (1)), java.lang.Byte.MAX_VALUE };

	private static void relGet(java.nio.ByteBuffer b) {
		int n = b.capacity();
		byte v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((byte) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void relGet(java.nio.ByteBuffer b, int start) {
		int n = b.remaining();
		byte v;
		for (int i = start; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((byte) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void absGet(java.nio.ByteBuffer b) {
		int n = b.capacity();
		byte v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((byte) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void bulkGet(java.nio.ByteBuffer b) {
		int n = b.capacity();
		byte[] a = new byte[n + 7];
		b.get(a, 7, n);
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (a[i + 7])), ((long) ((byte) (javaT.nio.Buffer.Basic.ic(i)))));
		}
	}

	private static void relPut(java.nio.ByteBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(((byte) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.flip();
	}

	private static void absPut(java.nio.ByteBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((byte) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void bulkPutArray(java.nio.ByteBuffer b) {
		int n = b.capacity();
		b.clear();
		byte[] a = new byte[n + 7];
		for (int i = 0; i < n; i++) {
			a[i + 7] = ((byte) (javaT.nio.Buffer.Basic.ic(i)));
		}
		b.put(a, 7, n);
		b.flip();
	}

	private static void bulkPutBuffer(java.nio.ByteBuffer b) {
		int n = b.capacity();
		b.clear();
		java.nio.ByteBuffer c = java.nio.ByteBuffer.allocate(n + 7);
		c.position(7);
		for (int i = 0; i < n; i++) {
			c.put(((byte) (javaT.nio.Buffer.Basic.ic(i))));
		}
		c.flip();
		c.position(7);
		b.put(c);
		b.flip();
	}

	private static void callReset(java.nio.ByteBuffer b) {
		b.position(0);
		b.mark();
		b.duplicate().reset();
		b.asReadOnlyBuffer().reset();
	}

	private static void checkSlice(java.nio.ByteBuffer b, java.nio.ByteBuffer slice) {
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

	private static void checkBytes(java.nio.ByteBuffer b, byte[] bs) {
		int n = bs.length;
		int p = b.position();
		byte v;
		if (b.order() == java.nio.ByteOrder.BIG_ENDIAN) {
			for (int i = 0; i < n; i++) {
				javaT.nio.Buffer.Basic.ck(b, b.get(), bs[i]);
			}
		} else {
			for (int i = n - 1; i >= 0; i--) {
				javaT.nio.Buffer.Basic.ck(b, b.get(), bs[i]);
			}
		}
		b.position(p);
	}

	private static void compact(java.nio.Buffer b) {
		try {
			java.lang.Class<?> cl = b.getClass();
			java.lang.reflect.Method m = cl.getDeclaredMethod("compact");
			m.setAccessible(true);
			m.invoke(b);
		} catch (java.lang.Exception e) {
			javaT.nio.Buffer.Basic.fail(e.getMessage(), b);
		}
	}

	private static void checkInvalidMarkException(final java.nio.Buffer b) {
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.InvalidMarkException.class, new java.lang.Runnable() {
			public void run() {
				b.mark();
				javaT.nio.Buffer.BasicByte.compact(b);
				b.reset();
			}
		});
	}

	private static void testViews(int level, java.nio.ByteBuffer b, boolean direct) {
		java.nio.ShortBuffer sb = b.asShortBuffer();
		javaT.nio.Buffer.BasicShort.test(level, sb, direct);
		javaT.nio.Buffer.BasicByte.checkBytes(b, new byte[]{ 0, ((byte) (javaT.nio.Buffer.Basic.ic(0))) });
		javaT.nio.Buffer.BasicByte.checkInvalidMarkException(sb);
		java.nio.CharBuffer cb = b.asCharBuffer();
		javaT.nio.Buffer.BasicChar.test(level, cb, direct);
		javaT.nio.Buffer.BasicByte.checkBytes(b, new byte[]{ 0, ((byte) (javaT.nio.Buffer.Basic.ic(0))) });
		javaT.nio.Buffer.BasicByte.checkInvalidMarkException(cb);
		java.nio.IntBuffer ib = b.asIntBuffer();
		javaT.nio.Buffer.BasicInt.test(level, ib, direct);
		javaT.nio.Buffer.BasicByte.checkBytes(b, new byte[]{ 0, 0, 0, ((byte) (javaT.nio.Buffer.Basic.ic(0))) });
		javaT.nio.Buffer.BasicByte.checkInvalidMarkException(ib);
		java.nio.LongBuffer lb = b.asLongBuffer();
		javaT.nio.Buffer.BasicLong.test(level, lb, direct);
		javaT.nio.Buffer.BasicByte.checkBytes(b, new byte[]{ 0, 0, 0, 0, 0, 0, 0, ((byte) (javaT.nio.Buffer.Basic.ic(0))) });
		javaT.nio.Buffer.BasicByte.checkInvalidMarkException(lb);
		java.nio.FloatBuffer fb = b.asFloatBuffer();
		javaT.nio.Buffer.BasicFloat.test(level, fb, direct);
		javaT.nio.Buffer.BasicByte.checkBytes(b, new byte[]{ 0x42, ((byte) (0xc2)), 0, 0 });
		javaT.nio.Buffer.BasicByte.checkInvalidMarkException(fb);
		java.nio.DoubleBuffer db = b.asDoubleBuffer();
		javaT.nio.Buffer.BasicDouble.test(level, db, direct);
		javaT.nio.Buffer.BasicByte.checkBytes(b, new byte[]{ 0x40, 0x58, 0x40, 0, 0, 0, 0, 0 });
		javaT.nio.Buffer.BasicByte.checkInvalidMarkException(db);
	}

	private static void testHet(int level, java.nio.ByteBuffer b) {
		int p = b.position();
		b.limit(b.capacity());
		javaT.nio.Buffer.Basic.show(level, b);
		javaT.nio.Buffer.Basic.out.print("    put:");
		b.putChar(((char) (1)));
		b.putChar(((char) (java.lang.Character.MAX_VALUE)));
		javaT.nio.Buffer.Basic.out.print(" char");
		b.putShort(((short) (1)));
		b.putShort(((short) (java.lang.Short.MAX_VALUE)));
		javaT.nio.Buffer.Basic.out.print(" short");
		b.putInt(1);
		b.putInt(java.lang.Integer.MAX_VALUE);
		javaT.nio.Buffer.Basic.out.print(" int");
		b.putLong(((long) (1)));
		b.putLong(((long) (java.lang.Long.MAX_VALUE)));
		javaT.nio.Buffer.Basic.out.print(" long");
		b.putFloat(((float) (1)));
		b.putFloat(((float) (java.lang.Float.MIN_VALUE)));
		b.putFloat(((float) (java.lang.Float.MAX_VALUE)));
		javaT.nio.Buffer.Basic.out.print(" float");
		b.putDouble(((double) (1)));
		b.putDouble(((double) (java.lang.Double.MIN_VALUE)));
		b.putDouble(((double) (java.lang.Double.MAX_VALUE)));
		javaT.nio.Buffer.Basic.out.print(" double");
		javaT.nio.Buffer.Basic.out.println();
		b.limit(b.position());
		b.position(p);
		javaT.nio.Buffer.Basic.show(level, b);
		javaT.nio.Buffer.Basic.out.print("    get:");
		javaT.nio.Buffer.Basic.ck(b, b.getChar(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.getChar(), java.lang.Character.MAX_VALUE);
		javaT.nio.Buffer.Basic.out.print(" char");
		javaT.nio.Buffer.Basic.ck(b, b.getShort(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.getShort(), java.lang.Short.MAX_VALUE);
		javaT.nio.Buffer.Basic.out.print(" short");
		javaT.nio.Buffer.Basic.ck(b, b.getInt(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.getInt(), java.lang.Integer.MAX_VALUE);
		javaT.nio.Buffer.Basic.out.print(" int");
		javaT.nio.Buffer.Basic.ck(b, b.getLong(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.getLong(), java.lang.Long.MAX_VALUE);
		javaT.nio.Buffer.Basic.out.print(" long");
		javaT.nio.Buffer.Basic.ck(b, ((long) (b.getFloat())), 1);
		javaT.nio.Buffer.Basic.ck(b, ((long) (b.getFloat())), ((long) (java.lang.Float.MIN_VALUE)));
		javaT.nio.Buffer.Basic.ck(b, ((long) (b.getFloat())), ((long) (java.lang.Float.MAX_VALUE)));
		javaT.nio.Buffer.Basic.out.print(" float");
		javaT.nio.Buffer.Basic.ck(b, ((long) (b.getDouble())), 1);
		javaT.nio.Buffer.Basic.ck(b, ((long) (b.getDouble())), ((long) (java.lang.Double.MIN_VALUE)));
		javaT.nio.Buffer.Basic.ck(b, ((long) (b.getDouble())), ((long) (java.lang.Double.MAX_VALUE)));
		javaT.nio.Buffer.Basic.out.print(" double");
		javaT.nio.Buffer.Basic.out.println();
	}

	private static void fail(java.lang.String problem, java.nio.ByteBuffer xb, java.nio.ByteBuffer yb, byte x, byte y) {
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

	private static void tryCatch(byte[] t, java.lang.Class<?> ex, java.lang.Runnable thunk) {
		javaT.nio.Buffer.BasicByte.tryCatch(java.nio.ByteBuffer.wrap(t), ex, thunk);
	}

	public static void test(int level, final java.nio.ByteBuffer b, boolean direct) {
		javaT.nio.Buffer.Basic.show(level, b);
		if (direct != b.isDirect()) {
			javaT.nio.Buffer.Basic.fail("Wrong direction", b);
		}
		javaT.nio.Buffer.BasicByte.relPut(b);
		javaT.nio.Buffer.BasicByte.relGet(b);
		javaT.nio.Buffer.BasicByte.absGet(b);
		javaT.nio.Buffer.BasicByte.bulkGet(b);
		javaT.nio.Buffer.BasicByte.absPut(b);
		javaT.nio.Buffer.BasicByte.relGet(b);
		javaT.nio.Buffer.BasicByte.absGet(b);
		javaT.nio.Buffer.BasicByte.bulkGet(b);
		javaT.nio.Buffer.BasicByte.bulkPutArray(b);
		javaT.nio.Buffer.BasicByte.relGet(b);
		javaT.nio.Buffer.BasicByte.bulkPutBuffer(b);
		javaT.nio.Buffer.BasicByte.relGet(b);
		javaT.nio.Buffer.BasicByte.relPut(b);
		b.position(13);
		b.compact();
		b.flip();
		javaT.nio.Buffer.BasicByte.relGet(b, 13);
		javaT.nio.Buffer.BasicByte.relPut(b);
		b.limit(b.capacity() / 2);
		b.position(b.limit());
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.BufferUnderflowException.class, new java.lang.Runnable() {
			public void run() {
				b.get();
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.BufferOverflowException.class, new java.lang.Runnable() {
			public void run() {
				b.put(((byte) (42)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(b.limit());
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(-1);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.put(b.limit(), ((byte) (42)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.InvalidMarkException.class, new java.lang.Runnable() {
			public void run() {
				b.position(0);
				b.mark();
				b.compact();
				b.reset();
			}
		});
		b.clear();
		b.put(((byte) (0)));
		b.put(((byte) (-1)));
		b.put(((byte) (1)));
		b.put(java.lang.Byte.MAX_VALUE);
		b.put(java.lang.Byte.MIN_VALUE);
		byte v;
		b.flip();
		javaT.nio.Buffer.Basic.ck(b, b.get(), 0);
		javaT.nio.Buffer.Basic.ck(b, b.get(), ((byte) (-1)));
		javaT.nio.Buffer.Basic.ck(b, b.get(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Byte.MAX_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Byte.MIN_VALUE);
		b.rewind();
		java.nio.ByteBuffer b2 = java.nio.ByteBuffer.allocate(b.capacity());
		b2.put(b);
		b2.flip();
		b.position(2);
		b2.position(2);
		if (!b.equals(b2)) {
			for (int i = 2; i < b.limit(); i++) {
				byte x = b.get(i);
				byte y = b2.get(i);
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
		b.put(((byte) (99)));
		b.rewind();
		b2.rewind();
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to shorter buffer <= 0", b, b2);
		}
		b.limit(b.limit() - 1);
		b.put(2, ((byte) (42)));
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to lesser buffer <= 0", b, b2);
		}
		for (byte x : javaT.nio.Buffer.BasicByte.VALUES) {
			java.nio.ByteBuffer xb = java.nio.ByteBuffer.wrap(new byte[]{ x });
			if (xb.compareTo(xb) != 0) {
				javaT.nio.Buffer.BasicByte.fail("compareTo not reflexive", xb, xb, x, x);
			}
			if (!xb.equals(xb)) {
				javaT.nio.Buffer.BasicByte.fail("equals not reflexive", xb, xb, x, x);
			}
			for (byte y : javaT.nio.Buffer.BasicByte.VALUES) {
				java.nio.ByteBuffer yb = java.nio.ByteBuffer.wrap(new byte[]{ y });
				if (xb.compareTo(yb) != (-yb.compareTo(xb))) {
					javaT.nio.Buffer.BasicByte.fail("compareTo not anti-symmetric", xb, yb, x, y);
				}
				if ((xb.compareTo(yb) == 0) != xb.equals(yb)) {
					javaT.nio.Buffer.BasicByte.fail("compareTo inconsistent with equals", xb, yb, x, y);
				}
				if (xb.compareTo(yb) != java.lang.Byte.compare(x, y)) {
					javaT.nio.Buffer.BasicByte.fail("Incorrect results for ByteBuffer.compareTo", xb, yb, x, y);
				}
				if (xb.equals(yb) != ((x == y) || ((x != x) && (y != y)))) {
					javaT.nio.Buffer.BasicByte.fail("Incorrect results for ByteBuffer.equals", xb, yb, x, y);
				}
			}
		}
		javaT.nio.Buffer.BasicByte.relPut(b);
		javaT.nio.Buffer.BasicByte.relGet(b.duplicate());
		b.position(13);
		javaT.nio.Buffer.BasicByte.relGet(b.duplicate(), 13);
		javaT.nio.Buffer.BasicByte.relGet(b.duplicate().slice(), 13);
		javaT.nio.Buffer.BasicByte.relGet(b.slice(), 13);
		javaT.nio.Buffer.BasicByte.relGet(b.slice().duplicate(), 13);
		b.position(5);
		java.nio.ByteBuffer sb = b.slice();
		javaT.nio.Buffer.BasicByte.checkSlice(b, sb);
		b.position(0);
		java.nio.ByteBuffer sb2 = sb.slice();
		javaT.nio.Buffer.BasicByte.checkSlice(sb, sb2);
		if (!sb.equals(sb2)) {
			javaT.nio.Buffer.Basic.fail("Sliced slices do not match", sb, sb2);
		}
		if (sb.hasArray() && (sb.arrayOffset() != sb2.arrayOffset())) {
			javaT.nio.Buffer.Basic.fail((("Array offsets do not match: " + sb.arrayOffset()) + " != ") + sb2.arrayOffset(), sb, sb2);
		}
		b.clear();
		b.order(java.nio.ByteOrder.BIG_ENDIAN);
		javaT.nio.Buffer.BasicByte.testViews(level + 1, b, direct);
		for (int i = 1; i <= 9; i++) {
			b.position(i);
			javaT.nio.Buffer.Basic.show(level + 1, b);
			javaT.nio.Buffer.BasicByte.testViews(level + 2, b, direct);
		}
		b.position(0);
		b.order(java.nio.ByteOrder.LITTLE_ENDIAN);
		javaT.nio.Buffer.BasicByte.testViews(level + 1, b, direct);
		b.order(java.nio.ByteOrder.BIG_ENDIAN);
		for (int i = 0; i <= 9; i++) {
			b.position(i);
			javaT.nio.Buffer.BasicByte.testHet(level + 1, b);
		}
		b.order(java.nio.ByteOrder.LITTLE_ENDIAN);
		b.position(3);
		javaT.nio.Buffer.BasicByte.testHet(level + 1, b);
		b.rewind();
		final java.nio.ByteBuffer rb = b.asReadOnlyBuffer();
		if (!b.equals(rb)) {
			javaT.nio.Buffer.Basic.fail("Buffer not equal to read-only view", b, rb);
		}
		javaT.nio.Buffer.Basic.show(level + 1, rb);
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicByte.relPut(rb);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicByte.absPut(rb);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicByte.bulkPutArray(rb);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicByte.bulkPutBuffer(rb);
			}
		});
		final java.nio.ByteBuffer src = java.nio.ByteBuffer.allocate(1);
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.put(src);
			}
		});
		javaT.nio.Buffer.Basic.ck(src, src.position(), 0);
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.compact();
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putChar(((char) (1)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putChar(0, ((char) (1)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putShort(((short) (1)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putShort(0, ((short) (1)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putInt(1);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putInt(0, 1);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putLong(((long) (1)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putLong(0, ((long) (1)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putFloat(((float) (1)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putFloat(0, ((float) (1)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putDouble(((double) (1)));
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.putDouble(0, ((double) (1)));
			}
		});
		if (rb.getClass().getName().startsWith("java.nio.Heap")) {
			javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
				public void run() {
					rb.array();
				}
			});
			javaT.nio.Buffer.BasicByte.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
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
		java.nio.ByteBuffer ob = (b.isDirect()) ? java.nio.ByteBuffer.allocate(rb.capacity()) : java.nio.ByteBuffer.allocateDirect(rb.capacity());
		rb.rewind();
		ob.put(rb);
		javaT.nio.Buffer.BasicByte.relPut(b);
	}

	public static void test(final byte[] ba) {
		int offset = 47;
		int length = 900;
		final java.nio.ByteBuffer b = java.nio.ByteBuffer.wrap(ba, offset, length);
		javaT.nio.Buffer.Basic.show(0, b);
		javaT.nio.Buffer.Basic.ck(b, b.capacity(), ba.length);
		javaT.nio.Buffer.Basic.ck(b, b.position(), offset);
		javaT.nio.Buffer.Basic.ck(b, b.limit(), offset + length);
		javaT.nio.Buffer.BasicByte.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ByteBuffer.wrap(ba, -1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ByteBuffer.wrap(ba, ba.length + 1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ByteBuffer.wrap(ba, 0, -1);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ByteBuffer.wrap(ba, 0, ba.length + 1);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ByteBuffer.wrap(((byte[]) (null)), 0, 5);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ByteBuffer.wrap(((byte[]) (null)));
			}
		});
	}

	private static void testAllocate() {
		javaT.nio.Buffer.BasicByte.tryCatch(((java.nio.Buffer) (null)), java.lang.IllegalArgumentException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ByteBuffer.allocate(-1);
			}
		});
		javaT.nio.Buffer.BasicByte.tryCatch(((java.nio.Buffer) (null)), java.lang.IllegalArgumentException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.ByteBuffer.allocateDirect(-1);
			}
		});
	}

	public static void test() {
		javaT.nio.Buffer.BasicByte.testAllocate();
		javaT.nio.Buffer.BasicByte.test(0, java.nio.ByteBuffer.allocate(7 * 1024), false);
		javaT.nio.Buffer.BasicByte.test(0, java.nio.ByteBuffer.wrap(new byte[7 * 1024], 0, 7 * 1024), false);
		javaT.nio.Buffer.BasicByte.test(new byte[1024]);
		java.nio.ByteBuffer b = java.nio.ByteBuffer.allocateDirect(7 * 1024);
		for (b.position(0); b.position() < b.limit();) {
			javaT.nio.Buffer.Basic.ck(b, b.get(), 0);
		}
		javaT.nio.Buffer.BasicByte.test(0, b, true);
		javaT.nio.Buffer.BasicByte.callReset(java.nio.ByteBuffer.allocate(10));
	}
}