public class PostfixToInfix {
	public static boolean isOperator(char token) {
		switch (token) {
			case '+' :
			case '-' :
			case '/' :
			case '*' :
			case '^' :
				return true;
		}
		return false;
	}

	public static boolean isValidPostfixExpression(java.lang.String postfix) {
		if (postfix.length() < 3) {
			return false;
		}
		if (com.thealgorithms.stacks.PostfixToInfix.isOperator(postfix.charAt(0))) {
			return false;
		}
		if (com.thealgorithms.stacks.PostfixToInfix.isOperator(postfix.charAt(1))) {
			return false;
		}
		int operandCount = 0;
		int operatorCount = 0;
		for (int i = 0; i < postfix.length(); i++) {
			char token = postfix.charAt(i);
			if (com.thealgorithms.stacks.PostfixToInfix.isOperator(token)) {
				operatorCount++;
				if (operatorCount >= operandCount) {
					return false;
				}
			} else {
				if (operatorCount == 0) {
					operandCount++;
					continue;
				}
				if (operandCount != (operatorCount + 1)) {
					return false;
				}
				operandCount = 2;
				operatorCount = 0;
			}
		}
		return operandCount == (operatorCount + 1);
	}

	public static java.lang.String getPostfixToInfix(java.lang.String postfix) {
		java.lang.String infix = "";
		if (postfix.isEmpty()) {
			return infix;
		}
		if (!com.thealgorithms.stacks.PostfixToInfix.isValidPostfixExpression(postfix)) {
			throw new java.lang.IllegalArgumentException("Invalid Postfix Expression");
		}
		java.util.Stack<java.lang.String> stack = new java.util.Stack<>();
		java.lang.StringBuilder valueString = new java.lang.StringBuilder();
		java.lang.String operandA;
		java.lang.String operandB;
		char operator;
		for (int index = 0; index < postfix.length(); index++) {
			char token = postfix.charAt(index);
			if (!com.thealgorithms.stacks.PostfixToInfix.isOperator(token)) {
				stack.push(java.lang.Character.toString(token));
				continue;
			}
			operator = token;
			operandB = stack.pop();
			operandA = stack.pop();
			valueString.append('(');
			valueString.append(operandA);
			valueString.append(operator);
			valueString.append(operandB);
			valueString.append(')');
			stack.push(valueString.toString());
			valueString.setLength(0);
		}
		infix = stack.pop();
		return infix;
	}

	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.stacks.PostfixToInfix.getPostfixToInfix("ABC+/").equals("(A/(B+C))");
		assert com.thealgorithms.stacks.PostfixToInfix.getPostfixToInfix("AB+CD+*").equals("((A+B)*(C+D))");
		assert com.thealgorithms.stacks.PostfixToInfix.getPostfixToInfix("AB+C+D+").equals("(((A+B)+C)+D)");
		assert com.thealgorithms.stacks.PostfixToInfix.getPostfixToInfix("ABCDE^*/-").equals("(A-(B/(C*(D^E))))");
		assert com.thealgorithms.stacks.PostfixToInfix.getPostfixToInfix("AB+CD^/E*FGH+-^").equals("((((A+B)/(C^D))*E)^(F-(G+H)))");
	}
}