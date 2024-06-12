class BalancedBrackets {
	public static boolean isPaired(char leftBracket, char rightBracket) {
		char[][] pairedBrackets = new char[][]{ new char[]{ '(', ')' }, new char[]{ '[', ']' }, new char[]{ '{', '}' }, new char[]{ '<', '>' } };
		for (char[] pairedBracket : pairedBrackets) {
			if ((pairedBracket[0] == leftBracket) && (pairedBracket[1] == rightBracket)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isBalanced(java.lang.String brackets) {
		if (brackets == null) {
			throw new java.lang.IllegalArgumentException("brackets is null");
		}
		java.util.Stack<java.lang.Character> bracketsStack = new java.util.Stack<>();
		for (char bracket : brackets.toCharArray()) {
			switch (bracket) {
				case '(' :
				case '[' :
				case '{' :
					bracketsStack.push(bracket);
					break;
				case ')' :
				case ']' :
				case '}' :
					if (bracketsStack.isEmpty() || (!com.thealgorithms.stacks.BalancedBrackets.isPaired(bracketsStack.pop(), bracket))) {
						return false;
					}
					break;
				default :
					return false;
			}
		}
		return bracketsStack.isEmpty();
	}

	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.stacks.BalancedBrackets.isBalanced("[()]{}{[()()]()}");
		assert !com.thealgorithms.stacks.BalancedBrackets.isBalanced("[(])");
	}
}