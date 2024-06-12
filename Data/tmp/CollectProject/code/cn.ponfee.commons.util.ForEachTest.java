public class ForEachTest {
	public static void main(java.lang.String[] args) {
		cn.ponfee.commons.util.ForEachTest.forEachRemaining();
	}

	private static void foreach() {
		java.util.List<java.lang.Integer> list = java.util.Arrays.asList(1, 2, 3, 4, 5, 6);
		list.forEach(java.lang.System.out::println);
		java.lang.System.out.println("===================================");
		list.forEach(java.lang.System.out::println);
	}

	private static void forEachRemaining() {
		java.util.Iterator<java.lang.Integer> iter = java.util.Arrays.asList(1, 2, 3, 4, 5, 6).iterator();
		iter.forEachRemaining(java.lang.System.out::println);
		java.lang.System.out.println("===================================");
		iter.forEachRemaining(java.lang.System.out::println);
	}
}