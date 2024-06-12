public class TestClassInSamePackage {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.membermodifiers.access.ExampleClass example = new com.in28minutes.java.membermodifiers.access.ExampleClass();
		example.publicVariable = 5;
		example.publicMethod();
		example.protectedVariable = 5;
		example.protectedMethod();
		example.defaultVariable = 5;
		example.defaultMethod();
	}
}