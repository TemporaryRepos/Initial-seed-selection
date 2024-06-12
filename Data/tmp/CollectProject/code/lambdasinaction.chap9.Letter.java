public class Letter {
	public static java.lang.String addHeader(java.lang.String text) {
		return "From Raoul, Mario and Alan:" + text;
	}

	public static java.lang.String addFooter(java.lang.String text) {
		return text + "Kind regards";
	}

	public static java.lang.String checkSpelling(java.lang.String text) {
		return text.replaceAll("C\\+\\+", "**Censored**");
	}

	public static void main(java.lang.String... args) {
		java.util.function.Function<java.lang.String, java.lang.String> addHeader = lambdasinaction.chap9.Letter::addHeader;
		java.util.function.Function<java.lang.String, java.lang.String> transformationPipeline = addHeader.andThen(lambdasinaction.chap9.Letter::checkSpelling).andThen(lambdasinaction.chap9.Letter::addFooter);
		java.lang.System.out.println(transformationPipeline.apply("C++ stay away from me!"));
	}
}