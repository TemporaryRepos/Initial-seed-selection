public class Rotation {
	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.strings.Rotation.rotation("abcdef", 2).equals("cdefab");
		char[] values = "abcdef".toCharArray();
		com.thealgorithms.strings.Rotation.rotation(values, 2);
		assert new java.lang.String(values).equals("cdefab");
	}

	public static java.lang.String rotation(java.lang.String s, int n) {
		return s.substring(n) + s.substring(0, n);
	}

	public static void rotation(char[] values, int n) {
		com.thealgorithms.strings.Rotation.reverse(values, 0, n - 1);
		com.thealgorithms.strings.Rotation.reverse(values, n, values.length - 1);
		com.thealgorithms.strings.Rotation.reverse(values, 0, values.length - 1);
	}

	public static void reverse(char[] values, int from, int to) {
		while (from < to) {
			char temp = values[from];
			values[from] = values[to];
			values[to] = temp;
			from++;
			to--;
		} 
	}
}