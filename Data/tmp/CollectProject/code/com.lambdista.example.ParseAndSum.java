public class ParseAndSum {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Sum using the try-catch block");
		int sum1 = com.lambdista.example.ParseAndSum.sumWithoutTry(args);
		java.lang.System.out.println("Result: " + sum1);
		java.lang.System.out.println("Sum using the Try-Success-Failure API");
		int sum2 = com.lambdista.example.ParseAndSum.sumWithTry(args);
		java.lang.System.out.println("Result: " + sum2);
	}

	public static int sumWithoutTry(java.lang.String[] args) {
		int sum = 0;
		for (java.lang.String arg : args) {
			try {
				int number = java.lang.Math.abs(java.lang.Integer.parseInt(arg));
				sum += number;
			} catch (java.lang.NumberFormatException e) {
				return -1;
			}
		}
		return sum;
	}

	public static int sumWithTry(java.lang.String[] args) {
		return java.util.Arrays.stream(args).map(( line) -> com.lambdista.util.Try.apply(() -> java.lang.Math.abs(java.lang.Integer.parseInt(line)))).reduce(com.lambdista.util.Try.apply(() -> 0), com.lambdista.util.TryBinaryOperator.of(java.lang.Integer::sum)).getOrElse(-1);
	}
}