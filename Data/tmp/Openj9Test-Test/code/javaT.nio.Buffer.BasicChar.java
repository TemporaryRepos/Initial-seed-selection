public class BasicChar extends javaT.nio.Buffer.Basic {
	private static final char[] VALUES = new char[]{ java.lang.Character.MIN_VALUE, ((char) (-1)), ((char) (0)), ((char) (1)), java.lang.Character.MAX_VALUE };

	private static void relGet(java.nio.CharBuffer b) {
		int n = b.capacity();
		char v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((char) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void relGet(java.nio.CharBuffer b, int start) {
		int n = b.remaining();
		char v;
		for (int i = start; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((char) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void absGet(java.nio.CharBuffer b) {
		int n = b.capacity();
		char v;
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (b.get())), ((long) ((char) (javaT.nio.Buffer.Basic.ic(i)))));
		}
		b.rewind();
	}

	private static void bulkGet(java.nio.CharBuffer b) {
		int n = b.capacity();
		char[] a = new char[n + 7];
		b.get(a, 7, n);
		for (int i = 0; i < n; i++) {
			javaT.nio.Buffer.Basic.ck(b, ((long) (a[i + 7])), ((long) ((char) (javaT.nio.Buffer.Basic.ic(i)))));
		}
	}

	private static void relPut(java.nio.CharBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(((char) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.flip();
	}

	private static void absPut(java.nio.CharBuffer b) {
		int n = b.capacity();
		b.clear();
		for (int i = 0; i < n; i++) {
			b.put(i, ((char) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.limit(n);
		b.position(0);
	}

	private static void bulkPutArray(java.nio.CharBuffer b) {
		int n = b.capacity();
		b.clear();
		char[] a = new char[n + 7];
		for (int i = 0; i < n; i++) {
			a[i + 7] = ((char) (javaT.nio.Buffer.Basic.ic(i)));
		}
		b.put(a, 7, n);
		b.flip();
	}

	private static void bulkPutBuffer(java.nio.CharBuffer b) {
		int n = b.capacity();
		b.clear();
		java.nio.CharBuffer c = java.nio.CharBuffer.allocate(n + 7);
		c.position(7);
		for (int i = 0; i < n; i++) {
			c.put(((char) (javaT.nio.Buffer.Basic.ic(i))));
		}
		c.flip();
		c.position(7);
		b.put(c);
		b.flip();
	}

	private static void callReset(java.nio.CharBuffer b) {
		b.position(0);
		b.mark();
		b.duplicate().reset();
		b.asReadOnlyBuffer().reset();
	}

	private static void putBuffer() {
		final int cap = 10;
		java.nio.CharBuffer direct1 = java.nio.ByteBuffer.allocateDirect(cap).asCharBuffer();
		java.nio.CharBuffer nondirect1 = java.nio.ByteBuffer.allocate(cap).asCharBuffer();
		direct1.put(nondirect1);
		java.nio.CharBuffer direct2 = java.nio.ByteBuffer.allocateDirect(cap).asCharBuffer();
		java.nio.CharBuffer nondirect2 = java.nio.ByteBuffer.allocate(cap).asCharBuffer();
		nondirect2.put(direct2);
		java.nio.CharBuffer direct3 = java.nio.ByteBuffer.allocateDirect(cap).asCharBuffer();
		java.nio.CharBuffer direct4 = java.nio.ByteBuffer.allocateDirect(cap).asCharBuffer();
		direct3.put(direct4);
		java.nio.CharBuffer nondirect3 = java.nio.ByteBuffer.allocate(cap).asCharBuffer();
		java.nio.CharBuffer nondirect4 = java.nio.ByteBuffer.allocate(cap).asCharBuffer();
		nondirect3.put(nondirect4);
	}

	private static void bulkPutString(java.nio.CharBuffer b) {
		int n = b.capacity();
		b.clear();
		java.lang.StringBuffer sb = new java.lang.StringBuffer(n + 7);
		sb.append("1234567");
		for (int i = 0; i < n; i++) {
			sb.append(((char) (javaT.nio.Buffer.Basic.ic(i))));
		}
		b.put(sb.toString(), 7, 7 + n);
		b.flip();
	}

	private static void checkSlice(java.nio.CharBuffer b, java.nio.CharBuffer slice) {
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

	private static void fail(java.lang.String problem, java.nio.CharBuffer xb, java.nio.CharBuffer yb, char x, char y) {
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

	private static void tryCatch(char[] t, java.lang.Class<?> ex, java.lang.Runnable thunk) {
		javaT.nio.Buffer.BasicChar.tryCatch(java.nio.CharBuffer.wrap(t), ex, thunk);
	}

	public static void test(int level, final java.nio.CharBuffer b, boolean direct) {
		javaT.nio.Buffer.Basic.show(level, b);
		if (direct != b.isDirect()) {
			javaT.nio.Buffer.Basic.fail("Wrong direction", b);
		}
		javaT.nio.Buffer.BasicChar.relPut(b);
		javaT.nio.Buffer.BasicChar.relGet(b);
		javaT.nio.Buffer.BasicChar.absGet(b);
		javaT.nio.Buffer.BasicChar.bulkGet(b);
		javaT.nio.Buffer.BasicChar.absPut(b);
		javaT.nio.Buffer.BasicChar.relGet(b);
		javaT.nio.Buffer.BasicChar.absGet(b);
		javaT.nio.Buffer.BasicChar.bulkGet(b);
		javaT.nio.Buffer.BasicChar.bulkPutArray(b);
		javaT.nio.Buffer.BasicChar.relGet(b);
		javaT.nio.Buffer.BasicChar.bulkPutBuffer(b);
		javaT.nio.Buffer.BasicChar.relGet(b);
		javaT.nio.Buffer.BasicChar.bulkPutString(b);
		javaT.nio.Buffer.BasicChar.relGet(b);
		b.position(1);
		b.limit(7);
		javaT.nio.Buffer.Basic.ck(b, b.toString().equals("bcdefg"));
		b.position(2);
		javaT.nio.Buffer.Basic.ck(b, b.charAt(1), 'd');
		java.nio.CharBuffer c = b.subSequence(1, 4);
		javaT.nio.Buffer.Basic.ck(c, c.capacity(), b.capacity());
		javaT.nio.Buffer.Basic.ck(c, c.position(), b.position() + 1);
		javaT.nio.Buffer.Basic.ck(c, c.limit(), b.position() + 4);
		javaT.nio.Buffer.Basic.ck(c, b.subSequence(1, 4).toString().equals("def"));
		b.position(4);
		javaT.nio.Buffer.Basic.ck(b, b.charAt(1), 'f');
		javaT.nio.Buffer.Basic.ck(b, b.subSequence(1, 3).toString().equals("fg"));
		b.clear();
		int pos = b.position();
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.BufferOverflowException.class, new java.lang.Runnable() {
			public void run() {
				b.put(java.lang.String.valueOf(new char[b.capacity() + 1]), 0, b.capacity() + 1);
			}
		});
		javaT.nio.Buffer.Basic.ck(b, b.position(), pos);
		javaT.nio.Buffer.BasicChar.relGet(b);
		javaT.nio.Buffer.BasicChar.relPut(b);
		b.position(13);
		b.compact();
		b.flip();
		javaT.nio.Buffer.BasicChar.relGet(b, 13);
		javaT.nio.Buffer.BasicChar.relPut(b);
		b.limit(b.capacity() / 2);
		b.position(b.limit());
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.BufferUnderflowException.class, new java.lang.Runnable() {
			public void run() {
				b.get();
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.BufferOverflowException.class, new java.lang.Runnable() {
			public void run() {
				b.put(((char) (42)));
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(b.limit());
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(-1);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.put(b.limit(), ((char) (42)));
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.InvalidMarkException.class, new java.lang.Runnable() {
			public void run() {
				b.position(0);
				b.mark();
				b.compact();
				b.reset();
			}
		});
		b.clear();
		b.put(((char) (0)));
		b.put(((char) (-1)));
		b.put(((char) (1)));
		b.put(java.lang.Character.MAX_VALUE);
		b.put(java.lang.Character.MIN_VALUE);
		char v;
		b.flip();
		javaT.nio.Buffer.Basic.ck(b, b.get(), 0);
		javaT.nio.Buffer.Basic.ck(b, b.get(), ((char) (-1)));
		javaT.nio.Buffer.Basic.ck(b, b.get(), 1);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Character.MAX_VALUE);
		javaT.nio.Buffer.Basic.ck(b, b.get(), java.lang.Character.MIN_VALUE);
		b.rewind();
		java.nio.CharBuffer b2 = java.nio.CharBuffer.allocate(b.capacity());
		b2.put(b);
		b2.flip();
		b.position(2);
		b2.position(2);
		if (!b.equals(b2)) {
			for (int i = 2; i < b.limit(); i++) {
				char x = b.get(i);
				char y = b2.get(i);
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
		b.put(((char) (99)));
		b.rewind();
		b2.rewind();
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to shorter buffer <= 0", b, b2);
		}
		b.limit(b.limit() - 1);
		b.put(2, ((char) (42)));
		if (b.equals(b2)) {
			javaT.nio.Buffer.Basic.fail("Non-identical buffers equal", b, b2);
		}
		if (b.compareTo(b2) <= 0) {
			javaT.nio.Buffer.Basic.fail("Comparison to lesser buffer <= 0", b, b2);
		}
		for (char x : javaT.nio.Buffer.BasicChar.VALUES) {
			java.nio.CharBuffer xb = java.nio.CharBuffer.wrap(new char[]{ x });
			if (xb.compareTo(xb) != 0) {
				javaT.nio.Buffer.BasicChar.fail("compareTo not reflexive", xb, xb, x, x);
			}
			if (!xb.equals(xb)) {
				javaT.nio.Buffer.BasicChar.fail("equals not reflexive", xb, xb, x, x);
			}
			for (char y : javaT.nio.Buffer.BasicChar.VALUES) {
				java.nio.CharBuffer yb = java.nio.CharBuffer.wrap(new char[]{ y });
				if (xb.compareTo(yb) != (-yb.compareTo(xb))) {
					javaT.nio.Buffer.BasicChar.fail("compareTo not anti-symmetric", xb, yb, x, y);
				}
				if ((xb.compareTo(yb) == 0) != xb.equals(yb)) {
					javaT.nio.Buffer.BasicChar.fail("compareTo inconsistent with equals", xb, yb, x, y);
				}
				if (xb.compareTo(yb) != java.lang.Character.compare(x, y)) {
					javaT.nio.Buffer.BasicChar.fail("Incorrect results for CharBuffer.compareTo", xb, yb, x, y);
				}
				if (xb.equals(yb) != ((x == y) || ((x != x) && (y != y)))) {
					javaT.nio.Buffer.BasicChar.fail("Incorrect results for CharBuffer.equals", xb, yb, x, y);
				}
			}
		}
		javaT.nio.Buffer.BasicChar.relPut(b);
		javaT.nio.Buffer.BasicChar.relGet(b.duplicate());
		b.position(13);
		javaT.nio.Buffer.BasicChar.relGet(b.duplicate(), 13);
		javaT.nio.Buffer.BasicChar.relGet(b.duplicate().slice(), 13);
		javaT.nio.Buffer.BasicChar.relGet(b.slice(), 13);
		javaT.nio.Buffer.BasicChar.relGet(b.slice().duplicate(), 13);
		b.position(5);
		java.nio.CharBuffer sb = b.slice();
		javaT.nio.Buffer.BasicChar.checkSlice(b, sb);
		b.position(0);
		java.nio.CharBuffer sb2 = sb.slice();
		javaT.nio.Buffer.BasicChar.checkSlice(sb, sb2);
		if (!sb.equals(sb2)) {
			javaT.nio.Buffer.Basic.fail("Sliced slices do not match", sb, sb2);
		}
		if (sb.hasArray() && (sb.arrayOffset() != sb2.arrayOffset())) {
			javaT.nio.Buffer.Basic.fail((("Array offsets do not match: " + sb.arrayOffset()) + " != ") + sb2.arrayOffset(), sb, sb2);
		}
		b.rewind();
		final java.nio.CharBuffer rb = b.asReadOnlyBuffer();
		if (!b.equals(rb)) {
			javaT.nio.Buffer.Basic.fail("Buffer not equal to read-only view", b, rb);
		}
		javaT.nio.Buffer.Basic.show(level + 1, rb);
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicChar.relPut(rb);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicChar.absPut(rb);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicChar.bulkPutArray(rb);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				javaT.nio.Buffer.BasicChar.bulkPutBuffer(rb);
			}
		});
		final java.nio.CharBuffer src = java.nio.CharBuffer.allocate(1);
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.put(src);
			}
		});
		javaT.nio.Buffer.Basic.ck(src, src.position(), 0);
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				rb.compact();
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				java.lang.String s = new java.lang.String(new char[rb.remaining() + 1]);
				rb.put(s);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				java.lang.String s = new java.lang.String(new char[rb.remaining() + 1]);
				rb.append(s);
			}
		});
		if (rb.getClass().getName().startsWith("java.nio.Heap")) {
			javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
				public void run() {
					rb.array();
				}
			});
			javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
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
		javaT.nio.Buffer.BasicChar.relPut(b);
	}

	private static void testStr() {
		final java.lang.String s = "abcdefghijklm";
		int start = 3;
		int end = 9;
		final java.nio.CharBuffer b = java.nio.CharBuffer.wrap(s, start, end);
		javaT.nio.Buffer.Basic.show(0, b);
		javaT.nio.Buffer.Basic.ck(b, b.toString().equals(s.substring(start, end)));
		javaT.nio.Buffer.Basic.ck(b, b.toString().equals("defghi"));
		javaT.nio.Buffer.Basic.ck(b, b.isReadOnly());
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.nio.ReadOnlyBufferException.class, new java.lang.Runnable() {
			public void run() {
				b.put('x');
			}
		});
		javaT.nio.Buffer.Basic.ck(b, start, b.position());
		javaT.nio.Buffer.Basic.ck(b, end, b.limit());
		javaT.nio.Buffer.Basic.ck(b, s.length(), b.capacity());
		b.position(6);
		javaT.nio.Buffer.Basic.ck(b, b.subSequence(0, 3).toString().equals("ghi"));
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.charAt(-1);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.charAt(b.remaining());
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(b.limit());
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.get(-1);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.subSequence(-1, b.remaining());
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.subSequence(b.remaining() + 1, b.remaining());
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.subSequence(2, 1);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				b.subSequence(0, b.remaining() + 1);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.wrap(s, -1, s.length());
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.wrap(s, s.length() + 1, s.length());
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.wrap(s, 1, 0);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(b, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.wrap(s, 0, s.length() + 1);
			}
		});
	}

	public static void test(final char[] ba) {
		int offset = 47;
		int length = 900;
		final java.nio.CharBuffer b = java.nio.CharBuffer.wrap(ba, offset, length);
		javaT.nio.Buffer.Basic.show(0, b);
		javaT.nio.Buffer.Basic.ck(b, b.capacity(), ba.length);
		javaT.nio.Buffer.Basic.ck(b, b.position(), offset);
		javaT.nio.Buffer.Basic.ck(b, b.limit(), offset + length);
		javaT.nio.Buffer.BasicChar.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.wrap(ba, -1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.wrap(ba, ba.length + 1, ba.length);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.wrap(ba, 0, -1);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(ba, java.lang.IndexOutOfBoundsException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.wrap(ba, 0, ba.length + 1);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.wrap(((char[]) (null)), 0, 5);
			}
		});
		javaT.nio.Buffer.BasicChar.tryCatch(ba, java.lang.NullPointerException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.wrap(((char[]) (null)));
			}
		});
	}

	private static void testAllocate() {
		javaT.nio.Buffer.BasicChar.tryCatch(((java.nio.Buffer) (null)), java.lang.IllegalArgumentException.class, new java.lang.Runnable() {
			public void run() {
				java.nio.CharBuffer.allocate(-1);
			}
		});
	}

	public static void test() {
		javaT.nio.Buffer.BasicChar.testAllocate();
		javaT.nio.Buffer.BasicChar.test(0, java.nio.CharBuffer.allocate(7 * 1024), false);
		javaT.nio.Buffer.BasicChar.test(0, java.nio.CharBuffer.wrap(new char[7 * 1024], 0, 7 * 1024), false);
		javaT.nio.Buffer.BasicChar.test(new char[1024]);
		javaT.nio.Buffer.BasicChar.testStr();
		javaT.nio.Buffer.BasicChar.callReset(java.nio.CharBuffer.allocate(10));
		javaT.nio.Buffer.BasicChar.putBuffer();
	}
}