public class RegularExpressionExamples {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("12", "122345612");
		java.lang.System.out.println("\\");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("\\s", "12 1234 123 ");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("\\d", "12 12");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("\\w", "ab 12 _");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("[a-d1-4]", "azbkdm 15AB");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("[a-dA-D]", "abyzCD");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("a+", "aaabaayza");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("[a-z]+", "abcZ2xyzN1yza");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("a+b+", "aabcacaabbbcbb");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("a+b*c+", "abcdacdabdbc");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("a+b*c?", "adabdabcdabccd");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("[^a]+", "bcadefazyx");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("[^abcd]+a", "efgazyazyzb");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("a.c", "abca ca!cabbc");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("a+", "aaaaab");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("a+?", "aaaaab");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regex("\\.\\.\\.", "...a....b...c");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.regexUsingScanner("a+?", "aaaaab");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.tokenize("ac;bd;def;e", ";");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.tokenizeUsingScanner("ac;bd;def;e", ";");
		com.in28minutes.java.others.regularexpressions.RegularExpressionExamples.lookForDifferentThingsUsingScanner("true false 12 3 abc true 154");
	}

	private static void regex(java.lang.String regex, java.lang.String string) {
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
		java.util.regex.Matcher m = p.matcher(string);
		java.util.List<java.lang.String> matches = new java.util.ArrayList<java.lang.String>();
		while (m.find()) {
			matches.add(((m.start() + "<") + m.group()) + ">");
		} 
		java.lang.System.out.println(matches);
	}

	private static void regexUsingScanner(java.lang.String regex, java.lang.String string) {
		java.util.Scanner s = new java.util.Scanner(string);
		java.util.List<java.lang.String> matches = new java.util.ArrayList<java.lang.String>();
		java.lang.String token;
		while ((token = s.findInLine(regex)) != null) {
			matches.add(token);
		} 
		java.lang.System.out.println(matches);
	}

	private static void tokenize(java.lang.String string, java.lang.String regex) {
		java.lang.String[] tokens = string.split(regex);
		java.lang.System.out.println(java.util.Arrays.toString(tokens));
	}

	private static void tokenizeUsingScanner(java.lang.String string, java.lang.String regex) {
		java.util.Scanner scanner = new java.util.Scanner(string);
		scanner.useDelimiter(regex);
		java.util.List<java.lang.String> matches = new java.util.ArrayList<java.lang.String>();
		while (scanner.hasNext()) {
			matches.add(scanner.next());
		} 
		java.lang.System.out.println(matches);
	}

	private static void lookForDifferentThingsUsingScanner(java.lang.String string) {
		java.util.Scanner scanner = new java.util.Scanner(string);
		while (scanner.hasNext()) {
			if (scanner.hasNextBoolean()) {
				java.lang.System.out.println("Found Boolean :" + scanner.nextBoolean());
			} else if (scanner.hasNextInt()) {
				java.lang.System.out.println("Found Integer :" + scanner.nextInt());
			} else {
				java.lang.System.out.println("Different thing :" + scanner.next());
			}
		} 
	}
}