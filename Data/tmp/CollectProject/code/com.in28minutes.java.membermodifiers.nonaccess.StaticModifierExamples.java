public class StaticModifierExamples {
	private static int staticVariable;

	private int instanceVariable;

	public static void staticMethod() {
		com.in28minutes.java.membermodifiers.nonaccess.StaticModifierExamples.staticVariable = 10;
	}

	public void instanceMethod() {
		instanceVariable = 10;
		com.in28minutes.java.membermodifiers.nonaccess.StaticModifierExamples.staticVariable = 10;
	}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.membermodifiers.nonaccess.StaticModifierExamples example = new com.in28minutes.java.membermodifiers.nonaccess.StaticModifierExamples();
		example.instanceVariable = 10;
		example.instanceMethod();
		example.staticVariable = 10;
		example.staticMethod();
		com.in28minutes.java.membermodifiers.nonaccess.StaticModifierExamples.staticVariable = 10;
		com.in28minutes.java.membermodifiers.nonaccess.StaticModifierExamples.staticMethod();
		com.in28minutes.java.membermodifiers.nonaccess.Cricketer cricketer1 = new com.in28minutes.java.membermodifiers.nonaccess.Cricketer();
		com.in28minutes.java.membermodifiers.nonaccess.Cricketer cricketer2 = new com.in28minutes.java.membermodifiers.nonaccess.Cricketer();
		com.in28minutes.java.membermodifiers.nonaccess.Cricketer cricketer3 = new com.in28minutes.java.membermodifiers.nonaccess.Cricketer();
		com.in28minutes.java.membermodifiers.nonaccess.Cricketer cricketer4 = new com.in28minutes.java.membermodifiers.nonaccess.Cricketer();
		java.lang.System.out.println(com.in28minutes.java.membermodifiers.nonaccess.Cricketer.getCount());
		com.in28minutes.java.membermodifiers.nonaccess.Animal animal = new com.in28minutes.java.membermodifiers.nonaccess.Dog();
		animal.StaticMethod();
	}
}