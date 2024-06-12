public class HelloSystemProperty {
	public static void main(java.lang.String... args) {
		java.lang.System.out.println("Hello " + java.lang.System.getProperty("test.name"));
	}
}