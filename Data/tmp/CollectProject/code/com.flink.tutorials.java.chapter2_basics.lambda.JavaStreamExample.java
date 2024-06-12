public class JavaStreamExample {
	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.String> strings = java.util.Arrays.asList("abc", "", "bc", "12345", "efg", "abcd", "", "jkl");
		java.util.List<java.lang.Integer> lengths = strings.stream().filter(( string) -> !string.isEmpty()).map(( s) -> s.length()).collect(java.util.stream.Collectors.toList());
		lengths.forEach(( s) -> java.lang.System.out.println(s));
	}
}