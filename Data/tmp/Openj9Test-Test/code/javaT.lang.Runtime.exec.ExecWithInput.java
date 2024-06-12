public class ExecWithInput {
	private static final java.lang.String CAT = "/bin/cat";

	private static final int N = 200;

	static int go(int i) throws java.lang.Exception {
		java.lang.Process p = java.lang.Runtime.getRuntime().exec(javaT.lang.Runtime.exec.ExecWithInput.CAT);
		java.lang.String input = ((i + ": line 1\n") + i) + ": line 2\n";
		java.io.StringBufferInputStream in = new java.io.StringBufferInputStream(input);
		javaT.lang.Runtime.exec.ExecWithInput.IO ioIn = new javaT.lang.Runtime.exec.ExecWithInput.IO("stdin", in, p.getOutputStream());
		javaT.lang.Runtime.exec.ExecWithInput.IO ioOut = new javaT.lang.Runtime.exec.ExecWithInput.IO("stdout", p.getInputStream(), java.lang.System.out);
		javaT.lang.Runtime.exec.ExecWithInput.IO ioErr = new javaT.lang.Runtime.exec.ExecWithInput.IO("stderr", p.getErrorStream(), java.lang.System.err);
		return p.waitFor();
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (!java.lang.System.getProperty("os.name").equals("Linux")) {
			return;
		}
		if (java.io.File.separatorChar == '\\') {
			return;
		}
		for (int i = 0; i < javaT.lang.Runtime.exec.ExecWithInput.N; i++) {
			javaT.lang.Runtime.exec.ExecWithInput.go(i);
		}
	}

	static class IO extends java.lang.Thread {
		private java.io.InputStream in;

		private java.io.OutputStream out;

		IO(java.lang.String name, java.io.InputStream in, java.io.OutputStream out) {
			this.in = in;
			this.out = out;
			setName(name);
			start();
		}

		public void run() {
			try {
				int c;
				byte[] buf = new byte[8192];
				int n;
				while ((n = in.read(buf)) != (-1)) {
					out.write(buf, 0, n);
					out.flush();
				} 
			} catch (java.io.IOException e) {
				e.printStackTrace();
			} finally {
				if ((!java.lang.System.out.equals(out)) && (!java.lang.System.err.equals(out))) {
					if (out != null) {
						try {
							out.close();
						} catch (java.lang.Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}