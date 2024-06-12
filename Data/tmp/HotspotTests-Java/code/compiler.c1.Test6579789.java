public class Test6579789 {
	public static void main(java.lang.String[] args) {
		compiler.c1.Test6579789.bug(4);
	}

	public static void bug(int n) {
		float f = 1;
		int i = 1;
		try {
			int x = 1 / n;
			f = 2;
			i = 2;
			int y = 2 / n;
		} catch (java.lang.Exception ex) {
			f++;
			i++;
		}
	}
}