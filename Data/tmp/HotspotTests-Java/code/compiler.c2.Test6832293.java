public class Test6832293 {
	static interface SomeInterface {
		public static final int SEVENS = 777;
	}

	static interface AnotherInterface {
		public static final int THIRDS = 33;
	}

	static class SomeClass implements compiler.c2.Test6832293.SomeInterface {
		int i;

		SomeClass(int i) {
			this.i = i;
		}
	}

	static class ImmediateSubclass extends compiler.c2.Test6832293.SomeClass implements compiler.c2.Test6832293.SomeInterface {
		float f;

		ImmediateSubclass(int i, float f) {
			super(i);
			this.f = f;
		}
	}

	static final class FinalSubclass extends compiler.c2.Test6832293.ImmediateSubclass implements compiler.c2.Test6832293.AnotherInterface {
		double d;

		FinalSubclass(int i, float f, double d) {
			super(i, f);
			this.d = d;
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		compiler.c2.Test6832293.SomeClass[] a = new compiler.c2.Test6832293.SomeClass[10];
		java.lang.String className = compiler.c2.Test6832293.class.getName();
		java.lang.Class.forName(className + "$ImmediateSubclass");
		java.lang.Class.forName(className + "$FinalSubclass");
		java.lang.System.exit(compiler.c2.Test6832293.run(args, java.lang.System.out) + 95);
	}

	static int errorStatus = 0;

	static void errorAlert(java.io.PrintStream out, int errorLevel) {
		out.println("Test: failure #" + errorLevel);
		compiler.c2.Test6832293.errorStatus = 2;
	}

	static compiler.c2.Test6832293.SomeClass[] v2 = new compiler.c2.Test6832293.FinalSubclass[4];

	public static int run(java.lang.String[] args, java.io.PrintStream out) {
		int[] i;
		int[] j;
		compiler.c2.Test6832293.SomeInterface[] u;
		compiler.c2.Test6832293.SomeInterface[][] v;
		compiler.c2.Test6832293.AnotherInterface[] w;
		compiler.c2.Test6832293.SomeClass[][] x;
		i = new int[10];
		i[0] = 777;
		j = ((int[]) (i));
		if (j != i) {
			compiler.c2.Test6832293.errorAlert(out, 2);
		} else if (j.length != 10) {
			compiler.c2.Test6832293.errorAlert(out, 3);
		} else if (j[0] != 777) {
			compiler.c2.Test6832293.errorAlert(out, 4);
		}
		v = new compiler.c2.Test6832293.SomeClass[3][];
		x = ((compiler.c2.Test6832293.SomeClass[][]) (v));
		if (!(x instanceof compiler.c2.Test6832293.SomeInterface[][])) {
			compiler.c2.Test6832293.errorAlert(out, 5);
		} else if (!(x instanceof compiler.c2.Test6832293.SomeClass[][])) {
			compiler.c2.Test6832293.errorAlert(out, 6);
		} else if (x != v) {
			compiler.c2.Test6832293.errorAlert(out, 7);
		}
		x[0] = ((compiler.c2.Test6832293.SomeClass[]) (new compiler.c2.Test6832293.ImmediateSubclass[4]));
		if (!(x[0] instanceof compiler.c2.Test6832293.ImmediateSubclass[])) {
			compiler.c2.Test6832293.errorAlert(out, 8);
		} else if (x[0].length != 4) {
			compiler.c2.Test6832293.errorAlert(out, 9);
		}
		x[1] = ((compiler.c2.Test6832293.SomeClass[]) (compiler.c2.Test6832293.v2));
		if (!(x[1] instanceof compiler.c2.Test6832293.FinalSubclass[])) {
			compiler.c2.Test6832293.errorAlert(out, 10);
		} else if (x[1].length != 4) {
			compiler.c2.Test6832293.errorAlert(out, 11);
		}
		w = ((compiler.c2.Test6832293.AnotherInterface[]) (x[1]));
		if (!(w instanceof compiler.c2.Test6832293.FinalSubclass[])) {
			compiler.c2.Test6832293.errorAlert(out, 12);
		} else if (w != x[1]) {
			compiler.c2.Test6832293.errorAlert(out, 13);
		} else if (w.length != 4) {
			compiler.c2.Test6832293.errorAlert(out, 14);
		}
		return compiler.c2.Test6832293.errorStatus;
	}
}