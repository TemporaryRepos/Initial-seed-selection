public class InstanceOfExamples {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.operators.SubClass subClass = new com.in28minutes.java.operators.SubClass();
		java.lang.Object subClassObj = new com.in28minutes.java.operators.SubClass();
		com.in28minutes.java.operators.SubClass2 subClass2 = new com.in28minutes.java.operators.SubClass2();
		com.in28minutes.java.operators.SomeOtherClass someOtherClass = new com.in28minutes.java.operators.SomeOtherClass();
		java.lang.System.out.println(subClass instanceof com.in28minutes.java.operators.SubClass);
		java.lang.System.out.println(subClass instanceof com.in28minutes.java.operators.SuperClass);
		java.lang.System.out.println(subClassObj instanceof com.in28minutes.java.operators.SuperClass);
		java.lang.System.out.println(subClass2 instanceof com.in28minutes.java.operators.SuperClassImplementingInteface);
		java.lang.System.out.println(subClass2 instanceof com.in28minutes.java.operators.Interface);
		java.lang.System.out.println(subClassObj instanceof com.in28minutes.java.operators.SomeOtherClass);
	}
}