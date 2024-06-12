public class Test6855215 {
	private double m;

	private double b;

	public static double log10(double x) {
		return java.lang.Math.log(x) / java.lang.Math.log(10);
	}

	void calcMapping(double xmin, double xmax, double ymin, double ymax) {
		m = (ymax - ymin) / (compiler.c1.Test6855215.log10(xmax) - compiler.c1.Test6855215.log10(xmin));
		b = (compiler.c1.Test6855215.log10(xmin) * ymax) - (compiler.c1.Test6855215.log10(xmax) * ymin);
	}

	public static void main(java.lang.String[] args) {
		compiler.c1.Test6855215 c = new compiler.c1.Test6855215();
		for (int i = 0; i < 30000; i++) {
			c.calcMapping(91, 121, 177, 34);
			if (c.m != c.m) {
				throw new java.lang.InternalError();
			}
		}
	}
}