public class OptionalTest {
	public static void main(java.lang.String[] args) {
		java.util.Optional<java.lang.String> name = java.util.Optional.of("Sanaulla");
		java.util.Optional<java.lang.String> empty = java.util.Optional.ofNullable(null);
		if (name.isPresent()) {
			java.lang.System.out.println(name.get());
		}
		try {
			java.lang.System.out.println(empty.get());
		} catch (java.util.NoSuchElementException ex) {
			java.lang.System.out.println(ex.getMessage());
		}
		name.ifPresent(( value) -> {
			java.lang.System.out.println("The length of the value is: " + value.length());
		});
		java.lang.System.out.println(empty.orElse("There is no value present!"));
		java.lang.System.out.println(name.orElse("There is some value!"));
		java.lang.System.out.println(empty.orElseGet(() -> "Default Value"));
		java.lang.System.out.println(name.orElseGet(() -> "Default Value"));
		try {
			empty.orElseThrow(java.lang.RuntimeException::new);
		} catch (java.lang.Throwable ex) {
			java.lang.System.out.println(ex.toString());
		}
		java.util.Optional<java.lang.String> upperName = name.map(( value) -> value.toUpperCase());
		java.lang.System.out.println(upperName.orElse("No value found"));
		upperName = name.flatMap(( value) -> java.util.Optional.of(value.toUpperCase()));
		java.lang.System.out.println(upperName.orElse("No value found"));
		java.util.Optional<java.lang.String> longName = name.filter(( value) -> value.length() > 6);
		java.lang.System.out.println(longName.orElse("The name is less than 6 characters"));
		java.util.Optional<java.lang.String> anotherName = java.util.Optional.of("Sana");
		java.util.Optional<java.lang.String> shortName = anotherName.filter(( value) -> value.length() > 6);
		java.lang.System.out.println(shortName.orElse("The name is less than 6 characters"));
	}
}