public class Test7044738 {
	private static final int INITSIZE = 10000;

	public int[] d = new int[]{ 1, 2, 3, 4 };

	public int i;

	public int size;

	private static int iter = 5;

	boolean done() {
		return (--compiler.loopopts.Test7044738.iter) > 0;
	}

	public static void main(java.lang.String[] args) {
		compiler.loopopts.Test7044738 t = new compiler.loopopts.Test7044738();
		t.test();
	}

	int test() {
		while (done()) {
			size = compiler.loopopts.Test7044738.INITSIZE;
			for (i = 0; i < size; i++) {
				d[0] = d[1];
				d[1] = d[2];
				d[2] = d[3];
				d[3] = d[0];
				d[0] = d[1];
				d[1] = d[2];
				d[2] = d[3];
				d[3] = d[0];
				d[0] = d[1];
				d[1] = d[2];
				d[2] = d[3];
				d[3] = d[0];
				d[0] = d[1];
				d[1] = d[2];
				d[2] = d[3];
				d[3] = d[0];
				d[0] = d[1];
				d[1] = d[2];
				d[2] = d[3];
				d[3] = d[0];
				d[0] = d[1];
				d[1] = d[2];
				d[2] = d[3];
				d[3] = d[0];
				d[0] = d[1];
				d[1] = d[2];
				d[2] = d[3];
				d[3] = d[0];
				d[0] = d[1];
				d[1] = d[2];
				d[2] = d[3];
				d[3] = d[0];
			}
			if (d[0] == d[1]) {
				java.lang.System.out.println(((((((((((("test failed: iter=" + compiler.loopopts.Test7044738.iter) + "  i=") + i) + " d[] = { ") + d[0]) + ", ") + d[1]) + ", ") + d[2]) + ", ") + d[3]) + " } ");
				java.lang.System.exit(97);
			}
		} 
		return d[3];
	}
}