public class Combinators {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(lambdasinaction.chap14.Combinators.repeat(3, (java.lang.Integer x) -> 2 * x).apply(10));
	}

	static <A, B, C> java.util.function.Function<A, C> compose(java.util.function.Function<B, C> g, java.util.function.Function<A, B> f) {
		return ( x) -> g.apply(f.apply(x));
	}

	static <A> java.util.function.Function<A, A> repeat(int n, java.util.function.Function<A, A> f) {
		return n == 0 ? ( x) -> x : lambdasinaction.chap14.Combinators.compose(f, lambdasinaction.chap14.Combinators.repeat(n - 1, f));
	}
}