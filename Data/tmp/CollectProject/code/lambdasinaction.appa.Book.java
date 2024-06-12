@lambdasinaction.appa.Author(name = "Raoul")
@lambdasinaction.appa.Author(name = "Mario")
@lambdasinaction.appa.Author(name = "Alan")
public class Book {
	public static void main(java.lang.String[] args) {
		lambdasinaction.appa.Author[] authors = lambdasinaction.appa.Book.class.getAnnotationsByType(lambdasinaction.appa.Author.class);
		java.util.Arrays.asList(authors).stream().forEach(( a) -> {
			java.lang.System.out.println(a.name());
		});
	}
}