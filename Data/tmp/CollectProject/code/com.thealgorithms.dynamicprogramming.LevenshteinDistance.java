public class LevenshteinDistance {
	private static int minimum(int a, int b, int c) {
		if ((a < b) && (a < c)) {
			return a;
		} else if ((b < a) && (b < c)) {
			return b;
		} else {
			return c;
		}
	}

	public static int calculateLevenshteinDistance(java.lang.String str1, java.lang.String str2) {
		int len1 = str1.length() + 1;
		int len2 = str2.length() + 1;
		int[][] distanceMat = new int[len1][len2];
		for (int i = 0; i < len1; i++) {
			distanceMat[i][0] = i;
		}
		for (int j = 0; j < len2; j++) {
			distanceMat[0][j] = j;
		}
		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					distanceMat[i][j] = distanceMat[i - 1][j - 1];
				} else {
					distanceMat[i][j] = 1 + com.thealgorithms.dynamicprogramming.LevenshteinDistance.minimum(distanceMat[i - 1][j], distanceMat[i - 1][j - 1], distanceMat[i][j - 1]);
				}
			}
		}
		return distanceMat[len1 - 1][len2 - 1];
	}

	public static void main(java.lang.String[] args) {
		java.lang.String str1 = "";
		java.lang.String str2 = "";
		java.lang.System.out.print(((("Levenshtein distance between " + str1) + " and ") + str2) + " is: ");
		java.lang.System.out.println(com.thealgorithms.dynamicprogramming.LevenshteinDistance.calculateLevenshteinDistance(str1, str2));
	}
}