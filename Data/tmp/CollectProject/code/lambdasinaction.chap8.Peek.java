public class Peek {
	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.Integer> result = java.util.stream.Stream.of(2, 3, 4, 5).peek(( x) -> java.lang.System.out.println("taking from stream: " + x)).map(( x) -> x + 17).peek(( x) -> java.lang.System.out.println("after map: " + x)).filter(( x) -> (x % 2) == 0).peek(( x) -> java.lang.System.out.println("after filter: " + x)).limit(3).peek(( x) -> java.lang.System.out.println("after limit: " + x)).collect(java.util.stream.Collectors.toList());
	}
}