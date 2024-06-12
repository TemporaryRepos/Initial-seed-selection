public class Test6935022 {
	public static final void main(java.lang.String[] args) throws java.lang.Exception {
		compiler.c2.Test6935022 test = new compiler.c2.Test6935022();
		int cnt = 0;
		while (cnt < 10000) {
			try {
				++cnt;
				if ((cnt & 1023) == 0) {
					java.lang.System.out.println((("Thread=" + java.lang.Thread.currentThread().getName()) + " iteration: ") + cnt);
				}
				test.loop(2147483647, cnt & 1023);
			} catch (java.lang.Exception e) {
				java.lang.System.out.println("Caught on iteration " + cnt);
				e.printStackTrace();
				java.lang.System.exit(97);
			}
		} 
	}

	private void loop(int endingRow, int mask) throws java.lang.Exception {
		int rows = 1;
		boolean next = true;
		while ((rows <= endingRow) && next) {
			rows++;
			if (rows == mask) {
				java.lang.System.out.println((((("Rows=" + rows) + ", end=") + endingRow) + ", next=") + next);
			}
			next = next(rows);
		} 
		if (next) {
			throw new java.lang.Exception("Ended on rows(no rs): " + rows);
		}
	}

	private boolean next(int rows) {
		return rows < 12;
	}
}