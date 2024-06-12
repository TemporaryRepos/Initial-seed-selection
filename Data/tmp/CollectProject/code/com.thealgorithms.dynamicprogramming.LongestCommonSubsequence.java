class LongestCommonSubsequence {
	public static java.lang.String getLCS(java.lang.String str1, java.lang.String str2) {
		if ((str1 == null) || (str2 == null)) {
			return null;
		}
		if ((str1.length() == 0) || (str2.length() == 0)) {
			return "";
		}
		java.lang.String[] arr1 = str1.split("");
		java.lang.String[] arr2 = str2.split("");
		int[][] lcsMatrix = new int[arr1.length + 1][arr2.length + 1];
		for (int i = 0; i < (arr1.length + 1); i++) {
			lcsMatrix[i][0] = 0;
		}
		for (int j = 1; j < (arr2.length + 1); j++) {
			lcsMatrix[0][j] = 0;
		}
		for (int i = 1; i < (arr1.length + 1); i++) {
			for (int j = 1; j < (arr2.length + 1); j++) {
				if (arr1[i - 1].equals(arr2[j - 1])) {
					lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
				} else {
					lcsMatrix[i][j] = java.lang.Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
				}
			}
		}
		return com.thealgorithms.dynamicprogramming.LongestCommonSubsequence.lcsString(str1, str2, lcsMatrix);
	}

	public static java.lang.String lcsString(java.lang.String str1, java.lang.String str2, int[][] lcsMatrix) {
		java.lang.StringBuilder lcs = new java.lang.StringBuilder();
		int i = str1.length();
		int j = str2.length();
		while ((i > 0) && (j > 0)) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				lcs.append(str1.charAt(i - 1));
				i--;
				j--;
			} else if (lcsMatrix[i - 1][j] > lcsMatrix[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		} 
		return lcs.reverse().toString();
	}

	public static void main(java.lang.String[] args) {
		java.lang.String str1 = "DSGSHSRGSRHTRD";
		java.lang.String str2 = "DATRGAGTSHS";
		java.lang.String lcs = com.thealgorithms.dynamicprogramming.LongestCommonSubsequence.getLCS(str1, str2);
		if (lcs != null) {
			java.lang.System.out.println("String 1: " + str1);
			java.lang.System.out.println("String 2: " + str2);
			java.lang.System.out.println("LCS: " + lcs);
			java.lang.System.out.println("LCS length: " + lcs.length());
		}
	}
}