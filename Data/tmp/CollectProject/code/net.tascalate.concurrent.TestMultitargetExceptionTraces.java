public class TestMultitargetExceptionTraces {
	public static void main(java.lang.String[] argv) {
		net.tascalate.concurrent.MultitargetException e = ((net.tascalate.concurrent.MultitargetException) (net.tascalate.concurrent.TestMultitargetExceptionTraces.err()));
		e.printStackTrace();
		java.lang.System.err.println("--------------");
		java.lang.System.err.println(e.getLocalizedMessage());
		java.lang.System.err.println("--------------");
		e.printExceptions();
	}

	static java.lang.Exception outer() {
		return new java.io.IOException("Invalid user input");
	}

	static java.lang.Exception err() {
		return net.tascalate.concurrent.TestMultitargetExceptionTraces.err_1();
	}

	static java.lang.Exception err_1() {
		net.tascalate.concurrent.MultitargetException e = new net.tascalate.concurrent.MultitargetException("First message", java.util.Arrays.asList(null, null, net.tascalate.concurrent.TestMultitargetExceptionTraces.b(), null, net.tascalate.concurrent.TestMultitargetExceptionTraces.a(), null, new net.tascalate.concurrent.MultitargetException("Another message", java.util.Arrays.asList(net.tascalate.concurrent.TestMultitargetExceptionTraces.c(), net.tascalate.concurrent.TestMultitargetExceptionTraces.b()))));
		return e;
	}

	static java.lang.Throwable a() {
		java.lang.Exception e = new java.lang.IllegalArgumentException("Something wrong", net.tascalate.concurrent.TestMultitargetExceptionTraces.b());
		return e;
	}

	static java.lang.Throwable b() {
		return net.tascalate.concurrent.TestMultitargetExceptionTraces.b_1();
	}

	static java.lang.Throwable b_1() {
		return net.tascalate.concurrent.TestMultitargetExceptionTraces.b_2();
	}

	static java.lang.Throwable b_2() {
		java.lang.Throwable e = new java.lang.NoSuchMethodError("Data not found");
		return e;
	}

	static java.lang.Throwable c() {
		return net.tascalate.concurrent.TestMultitargetExceptionTraces.c_1();
	}

	static java.lang.Throwable c_1() {
		return net.tascalate.concurrent.TestMultitargetExceptionTraces.c_2();
	}

	static java.lang.Exception c_2() {
		java.lang.Exception e = new java.lang.IllegalStateException("State is forbidden");
		return e;
	}
}