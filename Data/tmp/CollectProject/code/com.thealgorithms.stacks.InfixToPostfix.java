public class InfixToPostfix {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		assert "32+".equals(com.thealgorithms.stacks.InfixToPostfix.infix2PostFix("3+2"));
		assert "123++".equals(com.thealgorithms.stacks.InfixToPostfix.infix2PostFix("1+(2+3)"));
		assert "34+5*6-".equals(com.thealgorithms.stacks.InfixToPostfix.infix2PostFix("(3+4)*5-6"));
	}

	public static java.lang.String infix2PostFix(java.lang.String infixExpression) throws java.lang.Exception {
		if (!com.thealgorithms.stacks.BalancedBrackets.isBalanced(infixExpression)) {
			throw new java.lang.Exception("invalid expression");
		}
		java.lang.StringBuilder output = new java.lang.StringBuilder();
		java.util.Stack<java.lang.Character> stack = new java.util.Stack<>();
		for (char element : infixExpression.toCharArray()) {
			if (java.lang.Character.isLetterOrDigit(element)) {
				output.append(element);
			} else if (element == '(') {
				stack.push(element);
			} else if (element == ')') {
				while ((!stack.isEmpty()) && (stack.peek() != '(')) {
					output.append(stack.pop());
				} 
				stack.pop();
			} else {
				while ((!stack.isEmpty()) && (com.thealgorithms.stacks.InfixToPostfix.precedence(element) <= com.thealgorithms.stacks.InfixToPostfix.precedence(stack.peek()))) {
					output.append(stack.pop());
				} 
				stack.push(element);
			}
		}
		while (!stack.isEmpty()) {
			output.append(stack.pop());
		} 
		return output.toString();
	}

	private static int precedence(char operator) {
		switch (operator) {
			case '+' :
			case '-' :
				return 0;
			case '*' :
			case '/' :
				return 1;
			case '^' :
				return 2;
			default :
				return -1;
		}
	}
}