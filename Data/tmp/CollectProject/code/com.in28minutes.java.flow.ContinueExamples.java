public class ContinueExamples {
	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				continue;
			}
			java.lang.System.out.print(i);
		}
		java.lang.System.out.println();
		int i = 0;
		while (i < 10) {
			i++;
			if (i == 5) {
				continue;
			}
			java.lang.System.out.print(i);
		} 
		java.lang.System.out.println();
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				if (k == 5) {
					continue;
				}
				java.lang.System.out.print((j + "") + k);
			}
		}
		java.lang.System.out.println();
		outer : for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				if (k == 5) {
					continue outer;
				}
				java.lang.System.out.print((j + "") + k);
			}
		}
	}
}