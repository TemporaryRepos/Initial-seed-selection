public class Basic {
	private static final java.lang.String s = "Beware the Jabberwock, my son!";

	private static java.io.CharArrayWriter gw = new java.io.CharArrayWriter();

	private static java.io.ByteArrayOutputStream gos = new java.io.ByteArrayOutputStream();

	private static java.io.File newFile() {
		java.io.File f = null;
		try {
			f = java.io.File.createTempFile("append", ".txt");
			f.deleteOnExit();
		} catch (java.io.IOException x) {
			javaT.lang.Appendable.Basic.fail(x);
		}
		return f;
	}

	private static java.io.File gf = javaT.lang.Appendable.Basic.newFile();

	private static int fail = 0;

	private static int pass = 0;

	private static java.lang.Throwable first;

	static void pass() {
		javaT.lang.Appendable.Basic.pass++;
	}

	static void fail(java.lang.Throwable ex) {
		if (javaT.lang.Appendable.Basic.first == null) {
			javaT.lang.Appendable.Basic.first = ex;
		}
		java.lang.System.err.println("FAILED: unexpected exception");
		javaT.lang.Appendable.Basic.fail++;
	}

	static void fail(java.lang.String fs, java.lang.Throwable ex) {
		java.lang.String s = ((("'" + fs) + "': ") + ex.getClass().getName()) + " not thrown";
		if (javaT.lang.Appendable.Basic.first == null) {
			javaT.lang.Appendable.Basic.first = ex;
		}
		java.lang.System.err.println("FAILED: " + s);
		javaT.lang.Appendable.Basic.fail++;
	}

	static void fail(java.lang.String fs, java.lang.String exp, java.lang.String got) {
		java.lang.String s = ((((("'" + fs) + "': Expected '") + exp) + "', got '") + got) + "'";
		if (javaT.lang.Appendable.Basic.first == null) {
			javaT.lang.Appendable.Basic.first = new java.lang.RuntimeException(s);
		}
		java.lang.System.err.println("FAILED: " + s);
		javaT.lang.Appendable.Basic.fail++;
	}

	static void ck(java.lang.String s, java.lang.String exp, java.lang.String got) {
		if (!exp.equals(got)) {
			javaT.lang.Appendable.Basic.fail(s, exp, got);
		} else {
			javaT.lang.Appendable.Basic.pass();
		}
	}

	private static javaT.lang.Appendable.BasicRunnable testBufferedWriter = new javaT.lang.Appendable.BasicRunnable() {
		private java.lang.String csn;

		private java.lang.String exp;

		public void init(java.lang.Appendable bw, java.lang.String csn, java.lang.String exp) {
			try {
				((java.io.BufferedWriter) (bw)).flush();
			} catch (java.io.IOException x) {
				javaT.lang.Appendable.Basic.fail(x);
			}
			this.csn = csn;
			this.exp = exp;
		}

		public void run() {
			javaT.lang.Appendable.Basic.ck(("BufferedWriter.append(" + csn) + ")", exp, javaT.lang.Appendable.Basic.gw.toString());
		}

		public java.lang.Appendable reset(java.lang.Appendable bw) {
			javaT.lang.Appendable.Basic.gw.reset();
			return bw;
		}
	};

	private static javaT.lang.Appendable.BasicRunnable testCharArrayWriter = new javaT.lang.Appendable.BasicRunnable() {
		private java.lang.String csn;

		private java.lang.String exp;

		private java.io.CharArrayWriter cw;

		public void init(java.lang.Appendable cw, java.lang.String csn, java.lang.String exp) {
			this.cw = ((java.io.CharArrayWriter) (cw));
			this.csn = csn;
			this.exp = exp;
		}

		public void run() {
			javaT.lang.Appendable.Basic.ck(("CharArrayWriter.append(" + csn) + ")", exp, cw.toString());
		}

		public java.lang.Appendable reset(java.lang.Appendable cw) {
			((java.io.CharArrayWriter) (cw)).reset();
			return cw;
		}
	};

	private static javaT.lang.Appendable.BasicRunnable testFileWriter = new javaT.lang.Appendable.BasicRunnable() {
		private java.lang.String csn;

		private java.lang.String exp;

		public void init(java.lang.Appendable fw, java.lang.String csn, java.lang.String exp) {
			try {
				((java.io.FileWriter) (fw)).flush();
			} catch (java.io.IOException x) {
				javaT.lang.Appendable.Basic.fail(x);
			}
			this.csn = csn;
			this.exp = exp;
		}

		public void run() {
			java.lang.StringBuilder sb = new java.lang.StringBuilder();
			try {
				java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(javaT.lang.Appendable.Basic.gf));
				java.lang.String line;
				while (true) {
					if ((line = in.readLine()) == null) {
						break;
					}
					sb.append(line);
				} 
			} catch (java.io.IOException x) {
				javaT.lang.Appendable.Basic.fail(x);
			}
			javaT.lang.Appendable.Basic.ck(("FileWriter.append(" + csn) + ")", exp, sb.toString());
		}

		public java.lang.Appendable reset(java.lang.Appendable fw) {
			try {
				fw = new java.io.FileWriter(javaT.lang.Appendable.Basic.gf);
			} catch (java.io.IOException x) {
				javaT.lang.Appendable.Basic.fail(x);
			}
			return fw;
		}
	};

	private static javaT.lang.Appendable.BasicRunnable testOutputStreamWriter = new javaT.lang.Appendable.BasicRunnable() {
		private java.lang.String csn;

		private java.lang.String exp;

		public void init(java.lang.Appendable osw, java.lang.String csn, java.lang.String exp) {
			try {
				((java.io.OutputStreamWriter) (osw)).flush();
			} catch (java.io.IOException x) {
				javaT.lang.Appendable.Basic.fail(x);
			}
			this.csn = csn;
			this.exp = exp;
		}

		public void run() {
			javaT.lang.Appendable.Basic.ck(("OutputStreamWriter.append(" + csn) + ")", exp, javaT.lang.Appendable.Basic.gos.toString());
		}

		public java.lang.Appendable reset(java.lang.Appendable osw) {
			javaT.lang.Appendable.Basic.gos.reset();
			return osw;
		}
	};

	private static javaT.lang.Appendable.BasicRunnable testPrintWriter = new javaT.lang.Appendable.BasicRunnable() {
		private java.lang.String csn;

		private java.lang.String exp;

		public void init(java.lang.Appendable pw, java.lang.String csn, java.lang.String exp) {
			((java.io.PrintWriter) (pw)).flush();
			this.csn = csn;
			this.exp = exp;
		}

		public void run() {
			javaT.lang.Appendable.Basic.ck(("PrintWriter.append(" + csn) + ")", exp, javaT.lang.Appendable.Basic.gw.toString());
		}

		public java.lang.Appendable reset(java.lang.Appendable pw) {
			javaT.lang.Appendable.Basic.gw.reset();
			return pw;
		}
	};

	private static javaT.lang.Appendable.BasicRunnable testStringWriter = new javaT.lang.Appendable.BasicRunnable() {
		private java.lang.String csn;

		private java.lang.String exp;

		private java.io.StringWriter sw;

		public void init(java.lang.Appendable sw, java.lang.String csn, java.lang.String exp) {
			this.sw = ((java.io.StringWriter) (sw));
			this.csn = csn;
			this.exp = exp;
		}

		public void run() {
			javaT.lang.Appendable.Basic.ck(("StringWriter.append(" + csn) + ")", exp, sw.toString());
		}

		public java.lang.Appendable reset(java.lang.Appendable sw) {
			return new java.io.StringWriter();
		}
	};

	private static javaT.lang.Appendable.BasicRunnable testPrintStream = new javaT.lang.Appendable.BasicRunnable() {
		private java.lang.String csn;

		private java.lang.String exp;

		public void init(java.lang.Appendable ps, java.lang.String csn, java.lang.String exp) {
			((java.io.PrintStream) (ps)).flush();
			this.csn = csn;
			this.exp = exp;
		}

		public void run() {
			javaT.lang.Appendable.Basic.ck(("PrintStream.append(" + csn) + ")", exp, javaT.lang.Appendable.Basic.gos.toString());
		}

		public java.lang.Appendable reset(java.lang.Appendable ps) {
			javaT.lang.Appendable.Basic.gos.reset();
			return ps;
		}
	};

	private static javaT.lang.Appendable.BasicRunnable testCharBuffer = new javaT.lang.Appendable.BasicRunnable() {
		private java.lang.String csn;

		private java.lang.String exp;

		private java.nio.CharBuffer cb;

		public void init(java.lang.Appendable cb, java.lang.String csn, java.lang.String exp) {
			this.cb = ((java.nio.CharBuffer) (cb));
			this.csn = csn;
			this.exp = exp;
		}

		public void run() {
			cb.limit(cb.position()).rewind();
			javaT.lang.Appendable.Basic.ck(("CharBuffer.append(" + csn) + ")", exp, cb.toString());
		}

		public java.lang.Appendable reset(java.lang.Appendable cb) {
			((java.nio.CharBuffer) (cb)).clear();
			return cb;
		}
	};

	private static javaT.lang.Appendable.BasicRunnable testStringBuffer = new javaT.lang.Appendable.BasicRunnable() {
		private java.lang.String csn;

		private java.lang.String exp;

		private java.lang.StringBuffer sb;

		public void init(java.lang.Appendable sb, java.lang.String csn, java.lang.String exp) {
			this.sb = ((java.lang.StringBuffer) (sb));
			this.csn = csn;
			this.exp = exp;
		}

		public void run() {
			javaT.lang.Appendable.Basic.ck(("StringBuffer.append(" + csn) + ")", exp, sb.toString());
		}

		public java.lang.Appendable reset(java.lang.Appendable sb) {
			return new java.lang.StringBuffer();
		}
	};

	private static javaT.lang.Appendable.BasicRunnable testStringBuilder = new javaT.lang.Appendable.BasicRunnable() {
		private java.lang.String csn;

		private java.lang.String exp;

		private java.lang.StringBuilder sb;

		public void init(java.lang.Appendable sb, java.lang.String csn, java.lang.String exp) {
			this.sb = ((java.lang.StringBuilder) (sb));
			this.csn = csn;
			this.exp = exp;
		}

		public void run() {
			javaT.lang.Appendable.Basic.ck(("StringBuilder.append(" + csn) + ")", exp, sb.toString());
		}

		public java.lang.Appendable reset(java.lang.Appendable sb) {
			return new java.lang.StringBuilder();
		}
	};

	private static void test(java.lang.Appendable a, java.lang.CharSequence csq, javaT.lang.Appendable.BasicRunnable thunk) {
		int[][] sp = new int[][]{ new int[]{ 0, 0 }, new int[]{ 11, 11 }, new int[]{ 11, 21 }, new int[]{ 0, 7 }, new int[]{ 0, javaT.lang.Appendable.Basic.s.length() }, new int[]{ javaT.lang.Appendable.Basic.s.length(), javaT.lang.Appendable.Basic.s.length() } };
		for (int j = 0; j < sp.length; j++) {
			int start = sp[j][0];
			int end = sp[j][1];
			try {
				thunk.init(a.append(csq, start, end), csq.getClass().getName(), javaT.lang.Appendable.Basic.s.subSequence(start, end).toString());
				thunk.run();
				a = thunk.reset(a);
			} catch (java.io.IOException x) {
				javaT.lang.Appendable.Basic.fail(x);
			}
		}
		int[][] sf = new int[][]{ new int[]{ -1, 0 }, new int[]{ 0, -1 }, new int[]{ 11, 10 }, new int[]{ 0, javaT.lang.Appendable.Basic.s.length() + 1 } };
		for (int j = 0; j < sf.length; j++) {
			int start = sf[j][0];
			int end = sf[j][1];
			try {
				a.append(csq, start, end);
				javaT.lang.Appendable.Basic.fail((("start = " + start) + ", end = ") + end, new java.lang.IndexOutOfBoundsException());
				a = thunk.reset(a);
			} catch (java.lang.IndexOutOfBoundsException x) {
				javaT.lang.Appendable.Basic.pass();
			} catch (java.io.IOException x) {
				javaT.lang.Appendable.Basic.fail(x);
			}
		}
		int start = 1;
		int end = 2;
		try {
			thunk.init(a.append(null, start, end), "null", "null".subSequence(start, end).toString());
			thunk.run();
			a = thunk.reset(a);
		} catch (java.io.IOException x) {
			javaT.lang.Appendable.Basic.fail(x);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.CharBuffer cb = java.nio.CharBuffer.allocate(128).put(javaT.lang.Appendable.Basic.s);
		cb.limit(javaT.lang.Appendable.Basic.s.length()).rewind();
		java.nio.CharBuffer dcb = java.nio.ByteBuffer.allocateDirect(128).asCharBuffer().put(javaT.lang.Appendable.Basic.s);
		dcb.limit(javaT.lang.Appendable.Basic.s.length()).rewind();
		java.lang.CharSequence[] ca = new java.lang.CharSequence[]{ javaT.lang.Appendable.Basic.s, new java.lang.StringBuffer(javaT.lang.Appendable.Basic.s), new java.lang.StringBuilder(javaT.lang.Appendable.Basic.s), cb, dcb };
		java.lang.Object[][] wa = new java.lang.Object[][]{ new java.lang.Object[]{ new java.io.CharArrayWriter(), javaT.lang.Appendable.Basic.testCharArrayWriter }, new java.lang.Object[]{ new java.io.BufferedWriter(javaT.lang.Appendable.Basic.gw), javaT.lang.Appendable.Basic.testBufferedWriter }, new java.lang.Object[]{ new java.io.FileWriter(javaT.lang.Appendable.Basic.gf), javaT.lang.Appendable.Basic.testFileWriter }, new java.lang.Object[]{ new java.io.OutputStreamWriter(javaT.lang.Appendable.Basic.gos), javaT.lang.Appendable.Basic.testOutputStreamWriter }, new java.lang.Object[]{ new java.io.PrintWriter(javaT.lang.Appendable.Basic.gw), javaT.lang.Appendable.Basic.testPrintWriter }, new java.lang.Object[]{ new java.io.StringWriter(), javaT.lang.Appendable.Basic.testStringWriter } };
		for (int i = 0; i < ca.length; i++) {
			java.lang.CharSequence a = ca[i];
			for (int j = 0; j < wa.length; j++) {
				javaT.lang.Appendable.Basic.test(((java.io.Writer) (wa[j][0])), a, ((javaT.lang.Appendable.BasicRunnable) (wa[j][1])));
			}
			javaT.lang.Appendable.Basic.test(new java.io.PrintStream(javaT.lang.Appendable.Basic.gos), a, javaT.lang.Appendable.Basic.testPrintStream);
			javaT.lang.Appendable.Basic.test(java.nio.CharBuffer.allocate(128), a, javaT.lang.Appendable.Basic.testCharBuffer);
			javaT.lang.Appendable.Basic.test(java.nio.ByteBuffer.allocateDirect(128).asCharBuffer(), a, javaT.lang.Appendable.Basic.testCharBuffer);
			javaT.lang.Appendable.Basic.test(new java.lang.StringBuffer(), a, javaT.lang.Appendable.Basic.testStringBuffer);
			javaT.lang.Appendable.Basic.test(new java.lang.StringBuilder(), a, javaT.lang.Appendable.Basic.testStringBuilder);
		}
		if (javaT.lang.Appendable.Basic.fail != 0) {
			throw new java.lang.RuntimeException((((javaT.lang.Appendable.Basic.fail + javaT.lang.Appendable.Basic.pass) + " tests: ") + javaT.lang.Appendable.Basic.fail) + " failure(s), first", javaT.lang.Appendable.Basic.first);
		} else {
			java.lang.System.out.println(("all " + (javaT.lang.Appendable.Basic.fail + javaT.lang.Appendable.Basic.pass)) + " tests passed");
		}
	}
}