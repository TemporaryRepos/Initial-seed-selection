public class DecimalToAnyUsingStack {
	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.stacks.DecimalToAnyUsingStack.convert(0, 2).equals("0");
		assert com.thealgorithms.stacks.DecimalToAnyUsingStack.convert(30, 2).equals("11110");
		assert com.thealgorithms.stacks.DecimalToAnyUsingStack.convert(30, 8).equals("36");
		assert com.thealgorithms.stacks.DecimalToAnyUsingStack.convert(30, 10).equals("30");
		assert com.thealgorithms.stacks.DecimalToAnyUsingStack.convert(30, 16).equals("1E");
	}

	private static java.lang.String convert(int number, int radix) {
		if ((radix < 2) || (radix > 16)) {
			throw new java.lang.ArithmeticException(java.lang.String.format("Invalid input -> number:%d,radius:%d", number, radix));
		}
		char[] tables = new char[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		java.util.Stack<java.lang.Character> bits = new java.util.Stack<>();
		do {
			bits.push(tables[number % radix]);
			number = number / radix;
		} while (number != 0 );
		java.lang.StringBuilder result = new java.lang.StringBuilder();
		while (!bits.isEmpty()) {
			result.append(bits.pop());
		} 
		return result.toString();
	}
}