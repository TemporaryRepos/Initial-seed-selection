public class Test6196102 {
	public static void main(java.lang.String[] args) {
		int i1 = 0;
		int i2 = java.lang.Integer.MAX_VALUE;
		while (i1 >= 0) {
			i1++;
			if (i1 > i2) {
				java.lang.System.out.println("E R R O R: " + i1);
				java.lang.System.exit(97);
			}
		} 
	}
}