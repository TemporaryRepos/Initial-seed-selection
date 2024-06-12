public class TestPolymorphism {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.oops.inheritance.polymorphism.Animal animal1 = new com.in28minutes.java.oops.inheritance.polymorphism.Animal();
		java.lang.System.out.println(animal1.shout());
		com.in28minutes.java.oops.inheritance.polymorphism.Animal animal2 = new com.in28minutes.java.oops.inheritance.polymorphism.Dog();
		java.lang.System.out.println(animal2.shout());
	}
}