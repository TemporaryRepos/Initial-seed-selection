public class StringCharBufferSliceTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: testing the slice method...");
		final java.lang.String in = "for testing";
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: testing with the position 0.");
		java.nio.CharBuffer buff = java.nio.CharBuffer.wrap(in);
		javaT.nio.Buffer.StringCharBufferSliceTest.test(buff, buff.slice());
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: testing with new position.");
		buff.position(2);
		javaT.nio.Buffer.StringCharBufferSliceTest.test(buff, buff.slice());
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: testing with non zero initial position.");
		buff = java.nio.CharBuffer.wrap(in, 3, in.length());
		javaT.nio.Buffer.StringCharBufferSliceTest.test(buff, buff.slice());
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: testing slice result with get()");
		buff.position(4);
		buff.limit(7);
		java.nio.CharBuffer slice = buff.slice();
		for (int i = 0; i < 3; i++) {
			if (slice.get() != buff.get()) {
				throw new java.lang.RuntimeException("Wrong characters in slice result.");
			}
		}
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: testing slice result with get(int)");
		buff.position(4);
		buff.limit(7);
		slice = buff.slice();
		for (int i = 0; i < 3; i++) {
			if (slice.get(i) != buff.get(4 + i)) {
				throw new java.lang.RuntimeException("Wrong characters in slice result.");
			}
		}
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: testing slice with result of slice");
		buff.position(0);
		buff.limit(buff.capacity());
		slice = buff.slice();
		for (int i = 0; i < 4; i++) {
			slice.position(i);
			java.nio.CharBuffer nextSlice = slice.slice();
			if (nextSlice.position() != 0) {
				throw new java.lang.RuntimeException("New buffer's position should be zero");
			}
			if (!nextSlice.equals(slice)) {
				throw new java.lang.RuntimeException("New buffer should be equal");
			}
			slice = nextSlice;
		}
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: testing toString.");
		buff.position(4);
		buff.limit(7);
		slice = buff.slice();
		if (!slice.toString().equals("tes")) {
			throw new java.lang.RuntimeException("bad toString() after slice(): " + slice.toString());
		}
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: testing subSequence.");
		buff.position(4);
		buff.limit(8);
		slice = buff.slice();
		java.lang.CharSequence subSeq = slice.subSequence(1, 3);
		if ((subSeq.charAt(0) != 'e') || (subSeq.charAt(1) != 's')) {
			throw new java.lang.RuntimeException(("bad subSequence() after slice(): '" + subSeq) + "'");
		}
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: testing duplicate.");
		buff.position(4);
		buff.limit(8);
		slice = buff.slice();
		java.nio.CharBuffer dupe = slice.duplicate();
		if ((((dupe.charAt(0) != 't') || (dupe.charAt(1) != 'e')) || (dupe.charAt(2) != 's')) || (dupe.charAt(3) != 't')) {
			throw new java.lang.RuntimeException(("bad duplicate() after slice(): '" + dupe) + "'");
		}
		java.lang.System.out.println(">>> StringCharBufferSliceTest-main: done!");
	}

	public static void test(java.nio.CharBuffer buff, java.nio.CharBuffer slice) throws java.lang.RuntimeException {
		boolean marked = false;
		try {
			slice.reset();
			marked = true;
		} catch (java.nio.InvalidMarkException ime) {
		}
		if (((marked || (slice.position() != 0)) || (buff.remaining() != slice.limit())) || (buff.remaining() != slice.capacity())) {
			throw new java.lang.RuntimeException("Calling the CharBuffer.slice method failed.");
		}
	}
}