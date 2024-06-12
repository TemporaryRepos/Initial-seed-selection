public class Main {
	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.String> data = java.util.Arrays.asList("Adam", "Bob", "Carol", "Dave", "Eve", "Francis", "Gregg", "Helen", "Ann", "Chris", "David", "Daniel", "George");
		java.util.Map<java.lang.Character, java.util.List<java.lang.String>> groupings = data.stream().collect(java.util.stream.Collectors.groupingBy(( name) -> name.charAt(0)));
		groupings.forEach(( firstLetter, names) -> {
			java.lang.System.out.println((("" + firstLetter) + ": ") + names);
		});
	}
}