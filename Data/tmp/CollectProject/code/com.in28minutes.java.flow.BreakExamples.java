public class BreakExamples {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 10; i++) {
			java.lang.System.out.print(i);
			if (i == 5) {
				break;
			}
		}
		int i = 0;
		while (i < 10) {
			java.lang.System.out.print(i);
			if (i == 5) {
				break;
			}
			i++;
		} 
		java.lang.System.out.println();
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				java.lang.System.out.print((j + "") + k);
				if (k == 5) {
					break;
				}
			}
		}
		java.lang.System.out.println();
		outer : for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				java.lang.System.out.print((j + "") + k);
				if (k == 5) {
					break outer;
				}
			}
		}
	}
}