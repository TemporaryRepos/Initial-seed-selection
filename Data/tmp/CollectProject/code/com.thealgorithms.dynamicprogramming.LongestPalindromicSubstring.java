public class LongestPalindromicSubstring {
	public static void main(java.lang.String[] args) {
		java.lang.String a = "babad";
		java.lang.String b = "cbbd";
		java.lang.String aLPS = com.thealgorithms.dynamicprogramming.LongestPalindromicSubstring.LPS(a);
		java.lang.String bLPS = com.thealgorithms.dynamicprogramming.LongestPalindromicSubstring.LPS(b);
		java.lang.System.out.println((a + " => ") + aLPS);
		java.lang.System.out.println((b + " => ") + bLPS);
	}

	private static java.lang.String LPS(java.lang.String input) {
		if ((input == null) || (input.length() == 0)) {
			return input;
		}
		boolean[][] arr = new boolean[input.length()][input.length()];
		int start = 0;
		int end = 0;
		for (int g = 0; g < input.length(); g++) {
			for (int i = 0, j = g; j < input.length(); i++ , j++) {
				if (g == 0) {
					arr[i][j] = true;
				} else if (g == 1) {
					arr[i][j] = input.charAt(i) == input.charAt(j);
				} else {
					arr[i][j] = (input.charAt(i) == input.charAt(j)) && arr[i + 1][j - 1];
				}
				if (arr[i][j]) {
					start = i;
					end = j;
				}
			}
		}
		return input.substring(start, end + 1);
	}
}