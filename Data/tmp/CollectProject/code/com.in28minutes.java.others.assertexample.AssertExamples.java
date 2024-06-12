public class AssertExamples {
	private int computerSimpleInterest(int principal, float interest, int years) {
		assert principal > 0;
		return 100;
	}

	private int computeCompoundInterest(int principal, float interest, int years) {
		assert principal > 0 : "principal is " + principal;
		return 100;
	}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.others.assertexample.AssertExamples examples = new com.in28minutes.java.others.assertexample.AssertExamples();
		java.lang.System.out.println(examples.computerSimpleInterest(-1000, 1.0F, 5));
	}
}