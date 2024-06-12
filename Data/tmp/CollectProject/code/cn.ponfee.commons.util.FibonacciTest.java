public class FibonacciTest {
	public static int fibonacci(int i) {
		return (i == 1) || (i == 2) ? 1 : cn.ponfee.commons.util.FibonacciTest.fibonacci(i - 1) + cn.ponfee.commons.util.FibonacciTest.fibonacci(i - 2);
	}

	public static void main(java.lang.String[] args) {
		java.math.BigDecimal previous = new java.math.BigDecimal(1);
		java.math.BigDecimal following = new java.math.BigDecimal(1);
		java.math.BigDecimal temp;
		for (int i = 1; i < 1000; i++) {
			java.lang.System.out.println(previous.divide(following, 1000, java.math.RoundingMode.HALF_UP).toString());
			temp = following;
			following = following.add(previous);
			previous = temp;
		}
	}
}