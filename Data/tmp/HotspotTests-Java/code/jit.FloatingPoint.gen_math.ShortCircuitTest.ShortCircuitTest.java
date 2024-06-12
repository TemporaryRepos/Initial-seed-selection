public class ShortCircuitTest {
	private static int f = 0;

	private static int t = 0;

	public ShortCircuitTest() {
	}

	public boolean f() {
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f++;
		return false;
	}

	public boolean t() {
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t++;
		return true;
	}

	public static void main(java.lang.String[] args) {
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest s = new jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest();
		int errors = 0;
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.t() && s.t()) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 2) {
				if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 0) {
				} else {
					java.lang.System.out.println("Short circuit error: true && true");
					errors++;
				}
			} else {
				java.lang.System.out.println("Short circuit error: true && true");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: true && true");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.t() && s.f()) {
			java.lang.System.out.println("Short circuit error: true && false");
			errors++;
		} else if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 1) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 1) {
			} else {
				java.lang.System.out.println("Short circuit error: true && false");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: true && false");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.f() && s.t()) {
			java.lang.System.out.println("Short circuit error: false && true");
			errors++;
		} else if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 1) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 0) {
			} else {
				java.lang.System.out.println("Short circuit error: false && true");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: false && true");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.f() && s.f()) {
			java.lang.System.out.println("Short circuit error: false && false");
			errors++;
		} else if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 1) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 0) {
			} else {
				java.lang.System.out.println("Short circuit error: false && false");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: false && false");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.t() || s.t()) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 1) {
				if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 0) {
				} else {
					java.lang.System.out.println("Short circuit error: true || true");
					errors++;
				}
			} else {
				java.lang.System.out.println("Short circuit error: true || true");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: true || true");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.t() || s.f()) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 1) {
				if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 0) {
				} else {
					java.lang.System.out.println("Short circuit error: true || false");
					errors++;
				}
			} else {
				java.lang.System.out.println("Short circuit error: true || false");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: true || false");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.f() || s.t()) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 1) {
				if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 1) {
				} else {
					java.lang.System.out.println("Short circuit error: false || true");
					errors++;
				}
			} else {
				java.lang.System.out.println("Short circuit error: false || true");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: false || true");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.f() || s.f()) {
			java.lang.System.out.println("Short circuit error: false || false");
			errors++;
		} else if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 2) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 0) {
			} else {
				java.lang.System.out.println("Short circuit error: false || false");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: false || false");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.t() & s.t()) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 2) {
				if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 0) {
				} else {
					java.lang.System.out.println("Short circuit error: true & true");
					errors++;
				}
			} else {
				java.lang.System.out.println("Short circuit error: true & true");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: true & true");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.t() & s.f()) {
			java.lang.System.out.println("Short circuit error: true & false");
			errors++;
		} else if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 1) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 1) {
			} else {
				java.lang.System.out.println("Short circuit error: true & false");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: true & false");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.f() & s.t()) {
			java.lang.System.out.println("Short circuit error: false & true");
			errors++;
		} else if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 1) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 1) {
			} else {
				java.lang.System.out.println("Short circuit error: false & true");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: false & true");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.f() & s.f()) {
			java.lang.System.out.println("Short circuit error: false & false");
			errors++;
		} else if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 2) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 0) {
			} else {
				java.lang.System.out.println("Short circuit error: false & false");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: false & false");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.t() | s.t()) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 2) {
				if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 0) {
				} else {
					java.lang.System.out.println("Short circuit error: true | true");
					errors++;
				}
			} else {
				java.lang.System.out.println("Short circuit error: true | true");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: true | true");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.t() | s.f()) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 1) {
				if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 1) {
				} else {
					java.lang.System.out.println("Short circuit error: true | false");
					errors++;
				}
			} else {
				java.lang.System.out.println("Short circuit error: true | false");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: true | false");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.f() | s.t()) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 1) {
				if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 1) {
				} else {
					java.lang.System.out.println("Short circuit error: false | true");
					errors++;
				}
			} else {
				java.lang.System.out.println("Short circuit error: false | true");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: false | true");
			errors++;
		}
		jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f = jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t = 0;
		if (s.f() | s.f()) {
			java.lang.System.out.println("Short circuit error: false | false");
			errors++;
		} else if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.f == 2) {
			if (jit.FloatingPoint.gen_math.ShortCircuitTest.ShortCircuitTest.t == 0) {
			} else {
				java.lang.System.out.println("Short circuit error: false | false");
				errors++;
			}
		} else {
			java.lang.System.out.println("Short circuit error: false | false");
			errors++;
		}
		if (errors > 0) {
			throw new nsk.share.TestFailure(("Test failed: got " + errors) + "errors");
		}
	}
}