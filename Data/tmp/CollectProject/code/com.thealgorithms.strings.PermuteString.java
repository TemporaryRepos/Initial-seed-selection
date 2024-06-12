public class PermuteString {
	public static java.lang.String swapString(java.lang.String a, int i, int j) {
		char[] b = a.toCharArray();
		char ch;
		ch = b[i];
		b[i] = b[j];
		b[j] = ch;
		return java.lang.String.valueOf(b);
	}

	public static void main(java.lang.String[] args) {
		java.lang.String str = "ABC";
		int len = str.length();
		java.lang.System.out.println("All the permutations of the string are: ");
		com.thealgorithms.strings.PermuteString.generatePermutation(str, 0, len);
	}

	public static void generatePermutation(java.lang.String str, int start, int end) {
		if (start == (end - 1)) {
			java.lang.System.out.println(str);
		} else {
			for (int i = start; i < end; i++) {
				str = com.thealgorithms.strings.PermuteString.swapString(str, start, i);
				com.thealgorithms.strings.PermuteString.generatePermutation(str, start + 1, end);
				str = com.thealgorithms.strings.PermuteString.swapString(str, start, i);
			}
		}
	}
}