public class EveryClassExtendsObject {
	public void testMethod() throws java.lang.CloneNotSupportedException {
		java.lang.System.out.println(this.toString());
		java.lang.System.out.println(this.hashCode());
		java.lang.System.out.println(this.clone());
	}

	public static void main(java.lang.String[] args) throws java.lang.CloneNotSupportedException {
		com.in28minutes.java.oops.inheritance.EveryClassExtendsObject example1 = new com.in28minutes.java.oops.inheritance.EveryClassExtendsObject();
		com.in28minutes.java.oops.inheritance.EveryClassExtendsObject example2 = new com.in28minutes.java.oops.inheritance.EveryClassExtendsObject();
		if (example1 instanceof java.lang.Object) {
			java.lang.System.out.println("I extend Object");
		}
		java.lang.System.out.println(example1.equals(example2));
	}
}