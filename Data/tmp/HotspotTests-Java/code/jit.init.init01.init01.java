class init01 {
	public static void main(java.lang.String[] s) {
		jit.init.init01.InitTest1.ix1 = 5445;
		jit.init.init01.InitTest2.ix2 = 1;
		if (jit.init.init01.InitTest2.oop.i_ix == 5445) {
			java.lang.System.out.println("Correct order of initialization");
		} else {
			throw new nsk.share.TestFailure("Incorrect order of initialization");
		}
	}
}