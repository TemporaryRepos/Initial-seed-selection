public class constprop01 {
	static int err = 0;

	static final int is = 16386;

	double a;

	double b;

	double c;

	double d;

	double x;

	double z;

	double a_opt;

	double b_opt;

	double c_opt;

	double d_opt;

	double x_opt;

	double z_opt;

	static vm.compiler.jbe.constprop.constprop01.Starter st = new vm.compiler.jbe.constprop.constprop01.Starter();

	public static void main(java.lang.String[] args) {
		vm.compiler.jbe.constprop.constprop01.constprop01 cpr = new vm.compiler.jbe.constprop.constprop01.constprop01();
		cpr.un_optimized();
		cpr.hand_optimized();
		if (vm.compiler.jbe.constprop.constprop01.constprop01.st.gl_unopt != vm.compiler.jbe.constprop.constprop01.constprop01.st.gl_opt) {
			java.lang.System.out.println(((">>Bad output: gl_unopt is not equal to gl_optimized. gl_unopt = " + vm.compiler.jbe.constprop.constprop01.constprop01.st.gl_unopt) + "; gl_optimized = ") + vm.compiler.jbe.constprop.constprop01.constprop01.st.gl_opt);
			vm.compiler.jbe.constprop.constprop01.constprop01.err = 1;
		}
		if (cpr.a != cpr.a_opt) {
			java.lang.System.out.println(((">>Bad output: a_unoptimized=" + cpr.a) + "; a_optimized=") + cpr.a_opt);
			vm.compiler.jbe.constprop.constprop01.constprop01.err = 1;
		}
		if (cpr.b != cpr.b_opt) {
			java.lang.System.out.println(((">>Bad output: b_unoptimized=" + cpr.b) + "; b_optimized=") + cpr.b_opt);
			vm.compiler.jbe.constprop.constprop01.constprop01.err = 1;
		}
		if (cpr.c != cpr.c_opt) {
			java.lang.System.out.println(((">>Bad output: c_unoptimized=" + cpr.c) + "; c_optimized=") + cpr.c_opt);
			vm.compiler.jbe.constprop.constprop01.constprop01.err = 1;
		}
		if (cpr.d != cpr.d_opt) {
			java.lang.System.out.println(((">>Bad output: d_unoptimized=" + cpr.d) + "; d_optimized=") + cpr.d_opt);
			vm.compiler.jbe.constprop.constprop01.constprop01.err = 1;
		}
		if (cpr.x != cpr.x_opt) {
			java.lang.System.out.println(((">>Bad output: x_unoptimized=" + cpr.x) + "; x_optimized=") + cpr.x_opt);
			vm.compiler.jbe.constprop.constprop01.constprop01.err = 1;
		}
		if (cpr.z != cpr.z_opt) {
			java.lang.System.out.println(((">>Bad output: z_unoptimized=" + cpr.z) + "; z_optimized=") + cpr.z_opt);
			vm.compiler.jbe.constprop.constprop01.constprop01.err = 1;
		}
		if (vm.compiler.jbe.constprop.constprop01.constprop01.err == 0) {
			java.lang.System.out.println("Test constprop01 Passed.");
		} else {
			throw new java.lang.Error("Test constprop01 Failed.");
		}
	}

	void un_optimized() {
		int k;
		int m;
		a = vm.compiler.jbe.constprop.constprop01.constprop01.st.a_one;
		c = vm.compiler.jbe.constprop.constprop01.constprop01.st.a_one;
		d = vm.compiler.jbe.constprop.constprop01.constprop01.st.a_one;
		x = vm.compiler.jbe.constprop.constprop01.constprop01.st.a_one;
		for (k = 0; k < vm.compiler.jbe.constprop.constprop01.constprop01.is; k++) {
			vm.compiler.jbe.constprop.constprop01.constprop01.st.increment_unopt();
		}
		java.lang.System.out.println(("gl_unopt = " + vm.compiler.jbe.constprop.constprop01.constprop01.st.gl_unopt) + " after incrementing it 16386 times.");
		vm.compiler.jbe.constprop.constprop01.constprop01.st.gl_unopt -= 16386;
		java.lang.System.out.println(("gl_unopt = " + vm.compiler.jbe.constprop.constprop01.constprop01.st.gl_unopt) + " after subtracting 16386.");
		m = 32769;
		b = c * m;
		java.lang.System.out.println((("c = " + c) + "; m = 2; b = ") + b);
		a = java.lang.Math.E / ((a * d) * java.lang.Math.pow(1 / java.lang.Math.PI, 15));
		c = (2 * java.lang.Math.E) * d;
		d = (2 * java.lang.Math.E) * a;
		java.lang.System.out.println((((("e = " + java.lang.Math.E) + "; d = ") + d) + "; a = ") + a);
		java.lang.System.out.println("x = " + x);
		x += m;
		java.lang.System.out.println((("x = " + x) + "; m = ") + m);
		z = java.lang.Math.pow(1 / java.lang.Math.PI, 15) + (vm.compiler.jbe.constprop.constprop01.constprop01.st.zero / java.lang.Math.PI);
		java.lang.System.out.println("z = " + z);
	}

	void hand_optimized() {
		int k;
		int m;
		a_opt = vm.compiler.jbe.constprop.constprop01.constprop01.st.a_one;
		c_opt = vm.compiler.jbe.constprop.constprop01.constprop01.st.a_one;
		d_opt = vm.compiler.jbe.constprop.constprop01.constprop01.st.a_one;
		x_opt = vm.compiler.jbe.constprop.constprop01.constprop01.st.a_one;
		for (k = 0; k < 16386; k++) {
			vm.compiler.jbe.constprop.constprop01.constprop01.st.increment_opt();
		}
		java.lang.System.out.println(("gl_opt = " + vm.compiler.jbe.constprop.constprop01.constprop01.st.gl_opt) + " after incrementing it 16386 times.");
		vm.compiler.jbe.constprop.constprop01.constprop01.st.gl_opt -= 16386;
		java.lang.System.out.println(("gl_opt = " + vm.compiler.jbe.constprop.constprop01.constprop01.st.gl_opt) + " after subtracting 16386.");
		m = 32769;
		b_opt = c_opt * 32769;
		java.lang.System.out.println((("c_opt = " + c_opt) + "; b_opt = ") + b_opt);
		double e = 2.718281828459045;
		a_opt = 2.718281828459045 / ((a_opt * d_opt) * java.lang.Math.pow(0.3183098861837907, 15));
		c_opt = (2 * 2.718281828459045) * d_opt;
		d_opt = (2 * 2.718281828459045) * a_opt;
		java.lang.System.out.println((((("e = " + 2.718281828459045) + "; d_opt = ") + d_opt) + "; a_opt = ") + a_opt);
		java.lang.System.out.println("x_opt = " + x_opt);
		x_opt += 32769;
		java.lang.System.out.println((("x_opt = " + x_opt) + "; m = ") + m);
		z_opt = 3.4894092627910365E-8 + (0 / 3.141592653589793);
		java.lang.System.out.println("z_opt = " + z_opt);
	}
}