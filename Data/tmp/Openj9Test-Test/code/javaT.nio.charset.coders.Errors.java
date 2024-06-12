public class Errors {
	static java.io.PrintStream log = java.lang.System.err;

	static int failures = 0;

	static final byte Q = ((byte) ('?'));

	static final byte X = ((byte) ('x'));

	static final byte Y = ((byte) ('y'));

	static final byte Z = ((byte) ('z'));

	abstract static class Test {
		protected final java.lang.String csn;

		protected final java.lang.String what;

		Test(java.lang.String csn, java.lang.String what) {
			this.csn = csn;
			this.what = what;
		}

		abstract byte[] enc(java.lang.String s) throws java.io.IOException;

		javaT.nio.charset.coders.Errors.Test test(java.lang.String s, byte[] ref) {
			javaT.nio.charset.coders.Errors.log.print("  " + javaT.nio.charset.coders.Util.toString(s.toCharArray()));
			byte[] ba = null;
			try {
				ba = enc(s);
			} catch (java.io.IOException x) {
				javaT.nio.charset.coders.Errors.log.println(" -e-> ERROR: " + x.getClass().getName());
				javaT.nio.charset.coders.Errors.failures++;
				return this;
			}
			javaT.nio.charset.coders.Errors.log.println(" -e-> " + javaT.nio.charset.coders.Util.toString(ba));
			int i = javaT.nio.charset.coders.Util.cmp(ba, ref);
			if (i >= 0) {
				javaT.nio.charset.coders.Errors.log.println((("    ERROR: Mismatch at index " + i) + ", expected: ") + javaT.nio.charset.coders.Util.toString(ref));
				javaT.nio.charset.coders.Errors.failures++;
			}
			return this;
		}

		abstract java.lang.String dec(byte[] ba) throws java.io.IOException;

		javaT.nio.charset.coders.Errors.Test test(byte[] ba, java.lang.String ref) {
			javaT.nio.charset.coders.Errors.log.print("  " + javaT.nio.charset.coders.Util.toString(ba));
			java.lang.String s = null;
			try {
				s = dec(ba);
			} catch (java.io.IOException x) {
				javaT.nio.charset.coders.Errors.log.println(" -d-> ERROR: " + x.getClass().getName());
				javaT.nio.charset.coders.Errors.failures++;
				return this;
			}
			javaT.nio.charset.coders.Errors.log.println(" -d-> " + javaT.nio.charset.coders.Util.toString(s.toCharArray()));
			char[] ca = s.toCharArray();
			char[] refa = ref.toCharArray();
			int i = javaT.nio.charset.coders.Util.cmp(ca, refa);
			if (i >= 0) {
				javaT.nio.charset.coders.Errors.log.println((("    ERROR: Mismatch at index " + i) + ", expected: ") + javaT.nio.charset.coders.Util.toString(refa));
				javaT.nio.charset.coders.Errors.failures++;
			}
			return this;
		}

		javaT.nio.charset.coders.Errors.Test run() {
			javaT.nio.charset.coders.Errors.log.println((csn + ", ") + what);
			test("xyzzy", new byte[]{ javaT.nio.charset.coders.Errors.X, javaT.nio.charset.coders.Errors.Y, javaT.nio.charset.coders.Errors.Z, javaT.nio.charset.coders.Errors.Z, javaT.nio.charset.coders.Errors.Y });
			test("?x", new byte[]{ javaT.nio.charset.coders.Errors.Q, javaT.nio.charset.coders.Errors.X });
			test("?x", new byte[]{ javaT.nio.charset.coders.Errors.Q, javaT.nio.charset.coders.Errors.X });
			test("??x", new byte[]{ javaT.nio.charset.coders.Errors.Q, javaT.nio.charset.coders.Errors.Q, javaT.nio.charset.coders.Errors.X });
			return this;
		}
	}

	static class TestStream extends javaT.nio.charset.coders.Errors.Test {
		TestStream(java.lang.String csn) {
			super(csn, "I/O streams");
		}

		byte[] enc(java.lang.String s) throws java.io.IOException {
			java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
			java.io.Writer wr = new java.io.OutputStreamWriter(bos, csn);
			wr.write(s);
			wr.close();
			return bos.toByteArray();
		}

		java.lang.String dec(byte[] ba) throws java.io.IOException {
			java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(ba);
			java.io.Reader rd = new java.io.InputStreamReader(bis, csn);
			char[] ca = new char[1024];
			int n = rd.read(ca);
			java.lang.String s = new java.lang.String(ca, 0, n);
			rd.close();
			return s;
		}
	}

	static class TestString extends javaT.nio.charset.coders.Errors.Test {
		TestString(java.lang.String csn) {
			super(csn, "strings");
		}

		byte[] enc(java.lang.String s) throws java.io.IOException {
			return s.getBytes(csn);
		}

		java.lang.String dec(byte[] ba) throws java.io.IOException {
			return new java.lang.String(ba, 0, ba.length, csn);
		}
	}

	static void test_US_ASCII(javaT.nio.charset.coders.Errors.Test t) {
		t.run();
		t.test("\u0080", new byte[]{ javaT.nio.charset.coders.Errors.Q });
		t.test("Ā", new byte[]{ javaT.nio.charset.coders.Errors.Q });
		t.test("𐀀", new byte[]{ javaT.nio.charset.coders.Errors.Q });
		t.test("", new byte[]{ javaT.nio.charset.coders.Errors.Q });
		t.test("￾", new byte[]{ javaT.nio.charset.coders.Errors.Q });
		t.test("￿", new byte[]{ javaT.nio.charset.coders.Errors.Q });
		t.test(new byte[]{ javaT.nio.charset.coders.Errors.X, ((byte) (0x7f)), javaT.nio.charset.coders.Errors.Y }, "x\u007fy");
		t.test(new byte[]{ javaT.nio.charset.coders.Errors.X, ((byte) (0x80)), javaT.nio.charset.coders.Errors.Y }, "x�y");
		t.test(new byte[]{ ((byte) (0xf0)), ((byte) (0xf0)) }, "��");
	}

	static void test_ISO_8859_1(javaT.nio.charset.coders.Errors.Test t) {
		t.run();
		t.test("\u0080", new byte[]{ ((byte) (0x80)) });
		t.test("Ā", new byte[]{ javaT.nio.charset.coders.Errors.Q });
		t.test("𐀀x", new byte[]{ javaT.nio.charset.coders.Errors.Q, javaT.nio.charset.coders.Errors.X });
		t.test("", new byte[]{ javaT.nio.charset.coders.Errors.Q });
		t.test("￾", new byte[]{ javaT.nio.charset.coders.Errors.Q });
		t.test("￿", new byte[]{ javaT.nio.charset.coders.Errors.Q });
		t.test(new byte[]{ javaT.nio.charset.coders.Errors.X, ((byte) (0x7f)), javaT.nio.charset.coders.Errors.Y }, "x\u007fy");
		t.test(new byte[]{ javaT.nio.charset.coders.Errors.X, ((byte) (0x80)), javaT.nio.charset.coders.Errors.Y }, "x\u0080y");
		t.test(new byte[]{ ((byte) (0xf0)), ((byte) (0xf0)) }, "ðð");
	}

	static void test_UTF_8(javaT.nio.charset.coders.Errors.Test t) {
		t.run();
		t.test("\u0080", new byte[]{ ((byte) (0xc2)), ((byte) (0x80)) });
		t.test("Ā", new byte[]{ ((byte) (0xc4)), ((byte) (0x80)) });
		t.test("𐀀", new byte[]{ ((byte) (0xf0)), ((byte) (0x90)), ((byte) (0x80)), ((byte) (0x80)) });
		t.test("", new byte[]{ ((byte) (0xef)), ((byte) (0x80)), ((byte) (0x80)) });
		t.test("￾", new byte[]{ ((byte) (0xef)), ((byte) (0xbf)), ((byte) (0xbe)) });
		t.test("￿", new byte[]{ ((byte) (0xef)), ((byte) (0xbf)), ((byte) (0xbf)) });
		t.test(new byte[]{ javaT.nio.charset.coders.Errors.X, ((byte) (0x7f)), javaT.nio.charset.coders.Errors.Y }, "x\u007fy");
		t.test(new byte[]{ javaT.nio.charset.coders.Errors.X, ((byte) (0x80)), javaT.nio.charset.coders.Errors.Y }, "x�y");
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.nio.charset.coders.Errors.test_US_ASCII(new javaT.nio.charset.coders.Errors.TestString("US-ASCII"));
		javaT.nio.charset.coders.Errors.test_US_ASCII(new javaT.nio.charset.coders.Errors.TestStream("US-ASCII"));
		javaT.nio.charset.coders.Errors.test_ISO_8859_1(new javaT.nio.charset.coders.Errors.TestString("ISO-8859-1"));
		javaT.nio.charset.coders.Errors.test_ISO_8859_1(new javaT.nio.charset.coders.Errors.TestStream("ISO-8859-1"));
		javaT.nio.charset.coders.Errors.test_ISO_8859_1(new javaT.nio.charset.coders.Errors.TestString("ISO-8859-15"));
		javaT.nio.charset.coders.Errors.test_ISO_8859_1(new javaT.nio.charset.coders.Errors.TestStream("ISO-8859-15"));
		javaT.nio.charset.coders.Errors.test_UTF_8(new javaT.nio.charset.coders.Errors.TestString("UTF-8"));
		javaT.nio.charset.coders.Errors.test_UTF_8(new javaT.nio.charset.coders.Errors.TestStream("UTF-8"));
		if (javaT.nio.charset.coders.Errors.failures > 0) {
			javaT.nio.charset.coders.Errors.log.println();
			throw new java.lang.Exception("Tests failed: " + javaT.nio.charset.coders.Errors.failures);
		}
	}
}