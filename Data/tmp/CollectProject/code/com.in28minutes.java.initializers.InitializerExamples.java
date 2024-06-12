public class InitializerExamples {
	static int count;

	int i;

	{
		java.lang.System.out.println("Instance Initializer");
		i = 6;
		count = count + 1;
		java.lang.System.out.println("Count when Instance Initializer is run is " + count);
	}

	static {
		java.lang.System.out.println("Static Initializer");
		java.lang.System.out.println("Count when Static Initializer is run is " + count);
	}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.initializers.InitializerExamples example = new com.in28minutes.java.initializers.InitializerExamples();
		com.in28minutes.java.initializers.InitializerExamples example1 = new com.in28minutes.java.initializers.InitializerExamples();
		com.in28minutes.java.initializers.InitializerExamples example2 = new com.in28minutes.java.initializers.InitializerExamples();
	}
}