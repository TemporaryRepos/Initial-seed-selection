public class StreamForkerTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.stream.Stream<java.lang.Integer> stream = java.util.stream.Stream.of(1, 2, 3, 4, 4, 5, 5);
		cn.ponfee.commons.collect.StreamForker.Results results = new cn.ponfee.commons.collect.StreamForker<>(stream).fork(1, ( s) -> s.max(java.lang.Integer::compareTo)).fork(2, ( s) -> s.distinct().reduce(0, java.lang.Integer::sum)).getResults();
		java.lang.System.out.println(results.get(1) + "");
		java.lang.System.out.println(results.get(2) + "");
	}
}