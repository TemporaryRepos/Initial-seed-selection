public class Example1 {
	static final int num = 2;

	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.Integer> numbers = java.util.Arrays.asList(1, 2, 3, 4, 5, 6);
		numbers.forEach((java.lang.Integer value) -> java.lang.System.out.println(value));
		java.util.function.Function<java.lang.Integer, java.lang.Integer> stringConverter = ( from) -> from * ch6.s2.Example1.num;
		java.lang.System.out.println(stringConverter.apply(3));
	}
}