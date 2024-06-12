public class InterfaceWithMain {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.oops.interfaces.Bird bird = new com.in28minutes.java.oops.interfaces.Bird();
		bird.fly();
		com.in28minutes.java.oops.interfaces.Aeroplane aeroplane = new com.in28minutes.java.oops.interfaces.Aeroplane();
		aeroplane.fly();
		com.in28minutes.java.oops.interfaces.Flyable flyable1 = new com.in28minutes.java.oops.interfaces.Bird();
		com.in28minutes.java.oops.interfaces.Flyable flyable2 = new com.in28minutes.java.oops.interfaces.Aeroplane();
	}
}