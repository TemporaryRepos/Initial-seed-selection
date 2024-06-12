public class EqualsHashCodeExamples {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.object.Client client1 = new com.in28minutes.java.object.Client(25);
		com.in28minutes.java.object.Client client2 = new com.in28minutes.java.object.Client(25);
		com.in28minutes.java.object.Client client3 = client1;
		java.lang.System.out.println(client1.equals(client2));
		java.lang.System.out.println(client1.equals(client3));
	}
}