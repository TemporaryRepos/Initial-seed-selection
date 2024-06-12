class StringConcatenationExamples {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println((5 + "Test") + 5);
		java.lang.System.out.println((5 + 5) + "Test");
		java.lang.System.out.println(("5" + 5) + "Test");
		java.lang.System.out.println("5" + ("5" + "25"));
		java.lang.System.out.println((5 + 5) + "25");
		java.lang.System.out.println((("" + 5) + 5) + "25");
		java.lang.System.out.println(5 + (5 + "25"));
	}
}