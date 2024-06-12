public class Mapping {
	public static void main(java.lang.String... args) {
		java.util.List<java.lang.String> dishNames = lambdasinaction.chap4.Dish.menu.stream().map(lambdasinaction.chap4.Dish::getName).collect(java.util.stream.Collectors.toList());
		java.lang.System.out.println(dishNames);
		java.util.List<java.lang.String> words = java.util.Arrays.asList("Hello", "World");
		java.util.List<java.lang.Integer> wordLengths = words.stream().map(java.lang.String::length).collect(java.util.stream.Collectors.toList());
		java.lang.System.out.println(wordLengths);
		words.stream().flatMap((java.lang.String line) -> java.util.Arrays.stream(line.split(""))).distinct().forEach(java.lang.System.out::println);
		java.util.List<java.lang.Integer> numbers1 = java.util.Arrays.asList(1, 2, 3, 4, 5);
		java.util.List<java.lang.Integer> numbers2 = java.util.Arrays.asList(6, 7, 8);
		java.util.List<int[]> pairs = numbers1.stream().flatMap((java.lang.Integer i) -> numbers2.stream().map((java.lang.Integer j) -> new int[]{ i, j })).filter(( pair) -> ((pair[0] + pair[1]) % 3) == 0).collect(java.util.stream.Collectors.toList());
		pairs.forEach(( pair) -> java.lang.System.out.println(((("(" + pair[0]) + ", ") + pair[1]) + ")"));
	}
}