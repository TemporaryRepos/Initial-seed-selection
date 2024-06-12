public class Encodings {
	static boolean equals(byte[] a, byte[] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	static void go(java.lang.String enc, java.lang.String str, final byte[] bytes, boolean bidir) throws java.lang.Exception {
		final java.nio.charset.Charset charset = java.nio.charset.Charset.forName(enc);
		if (!new java.lang.String(bytes, enc).equals(str)) {
			throw new java.lang.Exception(enc + ": String constructor failed");
		}
		if (!new java.lang.String(bytes, charset).equals(str)) {
			throw new java.lang.Exception(charset + ": String constructor failed");
		}
		java.lang.String start = str.substring(0, 2);
		java.lang.String end = str.substring(2);
		if (enc.equals("UTF-16BE") || enc.equals("UTF-16LE")) {
			if (!new java.lang.String(bytes, 0, 4, charset).equals(start)) {
				throw new java.lang.Exception(charset + ": String constructor failed");
			}
			if (!new java.lang.String(bytes, 4, bytes.length - 4, charset).equals(end)) {
				throw new java.lang.Exception(charset + ": String constructor failed");
			}
		} else if (enc.equals("UTF-16")) {
			if (!new java.lang.String(bytes, 0, 6, charset).equals(start)) {
				throw new java.lang.Exception(charset + ": String constructor failed");
			}
		} else {
			if (!new java.lang.String(bytes, 0, 2, charset).equals(start)) {
				throw new java.lang.Exception(charset + ": String constructor failed");
			}
			if (!new java.lang.String(bytes, 2, bytes.length - 2, charset).equals(end)) {
				throw new java.lang.Exception(charset + ": String constructor failed");
			}
		}
		java.io.ByteArrayInputStream bi = new java.io.ByteArrayInputStream(bytes);
		java.io.InputStreamReader r = new java.io.InputStreamReader(bi, enc);
		java.lang.String inEnc = r.getEncoding();
		int n = str.length();
		char[] cs = new char[n];
		for (int i = 0; i < n;) {
			int m;
			if ((m = r.read(cs, i, n - i)) < 0) {
				throw new java.lang.Exception(enc + ": EOF on InputStreamReader");
			}
			i += m;
		}
		if (!new java.lang.String(cs).equals(str)) {
			throw new java.lang.Exception(enc + ": InputStreamReader failed");
		}
		if (!bidir) {
			java.lang.System.err.println((enc + " --> ") + inEnc);
			return;
		}
		byte[] bs = str.getBytes(enc);
		if (!javaT.lang.String.Encodings.equals(bs, bytes)) {
			throw new java.lang.Exception(enc + ": String.getBytes failed");
		}
		bs = str.getBytes(charset);
		if (!javaT.lang.String.Encodings.equals(bs, bytes)) {
			throw new java.lang.Exception(charset + ": String.getBytes failed");
		}
		if (charset.name().equals("UTF-16BE")) {
			java.lang.String s = new java.lang.String(bytes, charset);
			byte[] bb = s.getBytes(java.nio.charset.Charset.forName("UTF-16LE"));
			if (bytes.length != bb.length) {
				throw new java.lang.RuntimeException((("unequal length: " + bytes.length) + " != ") + bb.length);
			} else {
				boolean diff = false;
				for (int i = 0; i < bytes.length; i++) {
					if (bytes[i] != bb[i]) {
						diff = true;
					}
				}
				if (!diff) {
					throw new java.lang.RuntimeException("byte arrays equal");
				}
			}
		}
		java.io.ByteArrayOutputStream bo = new java.io.ByteArrayOutputStream();
		java.io.OutputStreamWriter w = new java.io.OutputStreamWriter(bo, enc);
		java.lang.String outEnc = w.getEncoding();
		w.write(str);
		w.close();
		bs = bo.toByteArray();
		if (!javaT.lang.String.Encodings.equals(bs, bytes)) {
			throw new java.lang.Exception(enc + ": OutputStreamWriter failed");
		}
		java.lang.System.err.println((((enc + " --> ") + inEnc) + " / ") + outEnc);
	}

	static void go(java.lang.String enc, java.lang.String str, byte[] bytes) throws java.lang.Exception {
		javaT.lang.String.Encodings.go(enc, str, bytes, true);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.String.Encodings.go("US-ASCII", "abc", new byte[]{ 'a', 'b', 'c' });
		javaT.lang.String.Encodings.go("us-ascii", "abc", new byte[]{ 'a', 'b', 'c' });
		javaT.lang.String.Encodings.go("ISO646-US", "abc", new byte[]{ 'a', 'b', 'c' });
		javaT.lang.String.Encodings.go("ISO-8859-1", "abÇ", new byte[]{ 'a', 'b', ((byte) ('Ç')) });
		javaT.lang.String.Encodings.go("UTF-8", "abḉ", new byte[]{ 'a', 'b', ((byte) (0xe0 | (0xf & (0x1e09 >> 12)))), ((byte) (0x80 | (0x3f & (0x1e09 >> 6)))), ((byte) (0x80 | (0x3f & 0x1e09))) });
		javaT.lang.String.Encodings.go("UTF-16BE", "abḉ", new byte[]{ 0, 'a', 0, 'b', 0x1e, 0x9 });
		javaT.lang.String.Encodings.go("UTF-16LE", "abḉ", new byte[]{ 'a', 0, 'b', 0, 0x9, 0x1e });
		javaT.lang.String.Encodings.go("UTF-16", "abḉ", new byte[]{ ((byte) (0xfe)), ((byte) (0xff)), 0, 'a', 0, 'b', 0x1e, 0x9 });
		javaT.lang.String.Encodings.go("UTF-16", "abḉ", new byte[]{ ((byte) (0xff)), ((byte) (0xfe)), 'a', 0, 'b', 0, 0x9, 0x1e }, false);
	}
}