public class PatternMatching {
	public static void main(java.lang.String[] args) {
		lambdasinaction.chap14.PatternMatching.simplify();
		lambdasinaction.chap14.PatternMatching.Expr e = new lambdasinaction.chap14.PatternMatching.BinOp("+", new lambdasinaction.chap14.PatternMatching.Number(5), new lambdasinaction.chap14.PatternMatching.BinOp("*", new lambdasinaction.chap14.PatternMatching.Number(3), new lambdasinaction.chap14.PatternMatching.Number(4)));
		java.lang.Integer result = lambdasinaction.chap14.PatternMatching.evaluate(e);
		java.lang.System.out.println((e + " = ") + result);
	}

	private static void simplify() {
		lambdasinaction.chap14.PatternMatching.TriFunction<java.lang.String, lambdasinaction.chap14.PatternMatching.Expr, lambdasinaction.chap14.PatternMatching.Expr, lambdasinaction.chap14.PatternMatching.Expr> binopcase = ( opname, left, right) -> {
			if ("+".equals(opname)) {
				if ((left instanceof lambdasinaction.chap14.PatternMatching.Number) && (((lambdasinaction.chap14.PatternMatching.Number) (left)).val == 0)) {
					return right;
				}
				if ((right instanceof lambdasinaction.chap14.PatternMatching.Number) && (((lambdasinaction.chap14.PatternMatching.Number) (right)).val == 0)) {
					return left;
				}
			}
			if ("*".equals(opname)) {
				if ((left instanceof lambdasinaction.chap14.PatternMatching.Number) && (((lambdasinaction.chap14.PatternMatching.Number) (left)).val == 1)) {
					return right;
				}
				if ((right instanceof lambdasinaction.chap14.PatternMatching.Number) && (((lambdasinaction.chap14.PatternMatching.Number) (right)).val == 1)) {
					return left;
				}
			}
			return new lambdasinaction.chap14.PatternMatching.BinOp(opname, left, right);
		};
		java.util.function.Function<java.lang.Integer, lambdasinaction.chap14.PatternMatching.Expr> numcase = ( val) -> new lambdasinaction.chap14.PatternMatching.Number(val);
		java.util.function.Supplier<lambdasinaction.chap14.PatternMatching.Expr> defaultcase = () -> new lambdasinaction.chap14.PatternMatching.Number(0);
		lambdasinaction.chap14.PatternMatching.Expr e = new lambdasinaction.chap14.PatternMatching.BinOp("+", new lambdasinaction.chap14.PatternMatching.Number(5), new lambdasinaction.chap14.PatternMatching.Number(0));
		lambdasinaction.chap14.PatternMatching.Expr match = lambdasinaction.chap14.PatternMatching.patternMatchExpr(e, binopcase, numcase, defaultcase);
		if (match instanceof lambdasinaction.chap14.PatternMatching.Number) {
			java.lang.System.out.println("Number: " + match);
		} else if (match instanceof lambdasinaction.chap14.PatternMatching.BinOp) {
			java.lang.System.out.println("BinOp: " + match);
		}
	}

	private static java.lang.Integer evaluate(lambdasinaction.chap14.PatternMatching.Expr e) {
		java.util.function.Function<java.lang.Integer, java.lang.Integer> numcase = ( val) -> val;
		java.util.function.Supplier<java.lang.Integer> defaultcase = () -> 0;
		lambdasinaction.chap14.PatternMatching.TriFunction<java.lang.String, lambdasinaction.chap14.PatternMatching.Expr, lambdasinaction.chap14.PatternMatching.Expr, java.lang.Integer> binopcase = ( opname, left, right) -> {
			if ("+".equals(opname)) {
				if ((left instanceof lambdasinaction.chap14.PatternMatching.Number) && (right instanceof lambdasinaction.chap14.PatternMatching.Number)) {
					return ((lambdasinaction.chap14.PatternMatching.Number) (left)).val + ((lambdasinaction.chap14.PatternMatching.Number) (right)).val;
				}
				if ((right instanceof lambdasinaction.chap14.PatternMatching.Number) && (left instanceof lambdasinaction.chap14.PatternMatching.BinOp)) {
					return ((lambdasinaction.chap14.PatternMatching.Number) (right)).val + lambdasinaction.chap14.PatternMatching.evaluate(((lambdasinaction.chap14.PatternMatching.BinOp) (left)));
				}
				if ((left instanceof lambdasinaction.chap14.PatternMatching.Number) && (right instanceof lambdasinaction.chap14.PatternMatching.BinOp)) {
					return ((lambdasinaction.chap14.PatternMatching.Number) (left)).val + lambdasinaction.chap14.PatternMatching.evaluate(((lambdasinaction.chap14.PatternMatching.BinOp) (right)));
				}
				if ((left instanceof lambdasinaction.chap14.PatternMatching.BinOp) && (right instanceof lambdasinaction.chap14.PatternMatching.BinOp)) {
					return lambdasinaction.chap14.PatternMatching.evaluate(((lambdasinaction.chap14.PatternMatching.BinOp) (left))) + lambdasinaction.chap14.PatternMatching.evaluate(((lambdasinaction.chap14.PatternMatching.BinOp) (right)));
				}
			}
			if ("*".equals(opname)) {
				if ((left instanceof lambdasinaction.chap14.PatternMatching.Number) && (right instanceof lambdasinaction.chap14.PatternMatching.Number)) {
					return ((lambdasinaction.chap14.PatternMatching.Number) (left)).val * ((lambdasinaction.chap14.PatternMatching.Number) (right)).val;
				}
				if ((right instanceof lambdasinaction.chap14.PatternMatching.Number) && (left instanceof lambdasinaction.chap14.PatternMatching.BinOp)) {
					return ((lambdasinaction.chap14.PatternMatching.Number) (right)).val * lambdasinaction.chap14.PatternMatching.evaluate(((lambdasinaction.chap14.PatternMatching.BinOp) (left)));
				}
				if ((left instanceof lambdasinaction.chap14.PatternMatching.Number) && (right instanceof lambdasinaction.chap14.PatternMatching.BinOp)) {
					return ((lambdasinaction.chap14.PatternMatching.Number) (left)).val * lambdasinaction.chap14.PatternMatching.evaluate(((lambdasinaction.chap14.PatternMatching.BinOp) (right)));
				}
				if ((left instanceof lambdasinaction.chap14.PatternMatching.BinOp) && (right instanceof lambdasinaction.chap14.PatternMatching.BinOp)) {
					return lambdasinaction.chap14.PatternMatching.evaluate(((lambdasinaction.chap14.PatternMatching.BinOp) (left))) * lambdasinaction.chap14.PatternMatching.evaluate(((lambdasinaction.chap14.PatternMatching.BinOp) (right)));
				}
			}
			return defaultcase.get();
		};
		return lambdasinaction.chap14.PatternMatching.patternMatchExpr(e, binopcase, numcase, defaultcase);
	}

	static class Expr {}

	static class Number extends lambdasinaction.chap14.PatternMatching.Expr {
		int val;

		public Number(int val) {
			this.val = val;
		}

		@java.lang.Override
		public java.lang.String toString() {
			return "" + val;
		}
	}

	static class BinOp extends lambdasinaction.chap14.PatternMatching.Expr {
		java.lang.String opname;

		lambdasinaction.chap14.PatternMatching.Expr left;

		lambdasinaction.chap14.PatternMatching.Expr right;

		public BinOp(java.lang.String opname, lambdasinaction.chap14.PatternMatching.Expr left, lambdasinaction.chap14.PatternMatching.Expr right) {
			this.opname = opname;
			this.left = left;
			this.right = right;
		}

		@java.lang.Override
		public java.lang.String toString() {
			return ((((("(" + left) + " ") + opname) + " ") + right) + ")";
		}
	}

	static <T> T MyIf(boolean b, java.util.function.Supplier<T> truecase, java.util.function.Supplier<T> falsecase) {
		return b ? truecase.get() : falsecase.get();
	}

	static interface TriFunction<S, T, U, R> {
		public abstract R apply(S s, T t, U u);
	}

	static <T> T patternMatchExpr(lambdasinaction.chap14.PatternMatching.Expr e, lambdasinaction.chap14.PatternMatching.TriFunction<java.lang.String, lambdasinaction.chap14.PatternMatching.Expr, lambdasinaction.chap14.PatternMatching.Expr, T> binopcase, java.util.function.Function<java.lang.Integer, T> numcase, java.util.function.Supplier<T> defaultcase) {
		if (e instanceof lambdasinaction.chap14.PatternMatching.BinOp) {
			return binopcase.apply(((lambdasinaction.chap14.PatternMatching.BinOp) (e)).opname, ((lambdasinaction.chap14.PatternMatching.BinOp) (e)).left, ((lambdasinaction.chap14.PatternMatching.BinOp) (e)).right);
		} else if (e instanceof lambdasinaction.chap14.PatternMatching.Number) {
			return numcase.apply(((lambdasinaction.chap14.PatternMatching.Number) (e)).val);
		} else {
			return defaultcase.get();
		}
	}
}