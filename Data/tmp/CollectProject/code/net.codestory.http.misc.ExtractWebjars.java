public class ExtractWebjars {
	private ExtractWebjars() {
	}

	public static void main(java.lang.String[] args) throws java.io.IOException {
		new org.webjars.WebJarExtractor().extractAllWebJarsTo(new java.io.File("target", "webjars"));
	}
}