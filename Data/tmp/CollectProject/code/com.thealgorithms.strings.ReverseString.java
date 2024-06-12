public class ReverseString {
	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.strings.ReverseString.reverse("abc123").equals("321cba");
		assert com.thealgorithms.strings.ReverseString.reverse2("abc123").equals("321cba");
	}

	public static java.lang.String reverse(java.lang.String str) {
		return new java.lang.StringBuilder(str).reverse().toString();
	}

	public static java.lang.String reverse2(java.lang.String str) {
		if ((str == null) || str.isEmpty()) {
			return str;
		}
		char[] value = str.toCharArray();
		for (int i = 0, j = str.length() - 1; i < j; i++ , j--) {
			char temp = value[i];
			value[i] = value[j];
			value[j] = temp;
		}
		return new java.lang.String(value);
	}
}