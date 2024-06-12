public class StrategyTest {
	public static void main(java.lang.String[] args) {
		int a = 4;
		int b = 2;
		com.pancm.design.strategy.CalculatorContext context = new com.pancm.design.strategy.CalculatorContext(new com.pancm.design.strategy.OperationAdd());
		java.lang.System.out.println("a + b = " + context.executeStrategy(a, b));
		com.pancm.design.strategy.CalculatorContext context2 = new com.pancm.design.strategy.CalculatorContext(new com.pancm.design.strategy.OperationSub());
		java.lang.System.out.println("a - b = " + context2.executeStrategy(a, b));
		com.pancm.design.strategy.CalculatorContext context3 = new com.pancm.design.strategy.CalculatorContext(new com.pancm.design.strategy.OperationMul());
		java.lang.System.out.println("a * b = " + context3.executeStrategy(a, b));
		com.pancm.design.strategy.CalculatorContext context4 = new com.pancm.design.strategy.CalculatorContext(new com.pancm.design.strategy.OperationDiv());
		java.lang.System.out.println("a / b = " + context4.executeStrategy(a, b));
	}
}