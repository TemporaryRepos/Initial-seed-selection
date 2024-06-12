public class StrategyMain {
	public static void main(java.lang.String[] args) {
		lambdasinaction.chap8.StrategyMain.Validator v1 = new lambdasinaction.chap8.StrategyMain.Validator(new lambdasinaction.chap8.StrategyMain.IsNumeric());
		java.lang.System.out.println(v1.validate("aaaa"));
		lambdasinaction.chap8.StrategyMain.Validator v2 = new lambdasinaction.chap8.StrategyMain.Validator(new lambdasinaction.chap8.StrategyMain.IsAllLowerCase());
		java.lang.System.out.println(v2.validate("bbbb"));
		lambdasinaction.chap8.StrategyMain.Validator v3 = new lambdasinaction.chap8.StrategyMain.Validator((java.lang.String s) -> s.matches("\\d+"));
		java.lang.System.out.println(v3.validate("aaaa"));
		lambdasinaction.chap8.StrategyMain.Validator v4 = new lambdasinaction.chap8.StrategyMain.Validator((java.lang.String s) -> s.matches("[a-z]+"));
		java.lang.System.out.println(v4.validate("bbbb"));
	}

	interface ValidationStrategy {
		public abstract boolean execute(java.lang.String s);
	}

	private static class IsAllLowerCase implements lambdasinaction.chap8.StrategyMain.ValidationStrategy {
		public boolean execute(java.lang.String s) {
			return s.matches("[a-z]+");
		}
	}

	private static class IsNumeric implements lambdasinaction.chap8.StrategyMain.ValidationStrategy {
		public boolean execute(java.lang.String s) {
			return s.matches("\\d+");
		}
	}

	private static class Validator {
		private final lambdasinaction.chap8.StrategyMain.ValidationStrategy strategy;

		public Validator(lambdasinaction.chap8.StrategyMain.ValidationStrategy v) {
			this.strategy = v;
		}

		public boolean validate(java.lang.String s) {
			return strategy.execute(s);
		}
	}
}