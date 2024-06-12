public class ChainOfResponsibilityMain {
	public static void main(java.lang.String[] args) {
		lambdasinaction.chap8.ChainOfResponsibilityMain.ProcessingObject<java.lang.String> p1 = new lambdasinaction.chap8.ChainOfResponsibilityMain.HeaderTextProcessing();
		lambdasinaction.chap8.ChainOfResponsibilityMain.ProcessingObject<java.lang.String> p2 = new lambdasinaction.chap8.ChainOfResponsibilityMain.SpellCheckerProcessing();
		p1.setSuccessor(p2);
		java.lang.String result1 = p1.handle("Aren't labdas really sexy?!!");
		java.lang.System.out.println(result1);
		java.util.function.UnaryOperator<java.lang.String> headerProcessing = (java.lang.String text) -> "From Raoul, Mario and Alan: " + text;
		java.util.function.UnaryOperator<java.lang.String> spellCheckerProcessing = (java.lang.String text) -> text.replaceAll("labda", "lambda");
		java.util.function.Function<java.lang.String, java.lang.String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
		java.lang.String result2 = pipeline.apply("Aren't labdas really sexy?!!");
		java.lang.System.out.println(result2);
	}

	private abstract static class ProcessingObject<T> {
		protected lambdasinaction.chap8.ChainOfResponsibilityMain.ProcessingObject<T> successor;

		public void setSuccessor(lambdasinaction.chap8.ChainOfResponsibilityMain.ProcessingObject<T> successor) {
			this.successor = successor;
		}

		public T handle(T input) {
			T r = handleWork(input);
			if (successor != null) {
				return successor.handle(r);
			}
			return r;
		}

		protected abstract T handleWork(T input);
	}

	private static class HeaderTextProcessing extends lambdasinaction.chap8.ChainOfResponsibilityMain.ProcessingObject<java.lang.String> {
		public java.lang.String handleWork(java.lang.String text) {
			return "From Raoul, Mario and Alan: " + text;
		}
	}

	private static class SpellCheckerProcessing extends lambdasinaction.chap8.ChainOfResponsibilityMain.ProcessingObject<java.lang.String> {
		public java.lang.String handleWork(java.lang.String text) {
			return text.replaceAll("labda", "lambda");
		}
	}
}