public class StaticAndMemberVariables {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.variables.Actor actor1 = new com.in28minutes.java.variables.Actor();
		actor1.name = "ACTOR1";
		com.in28minutes.java.variables.Actor.count++;
		com.in28minutes.java.variables.Actor actor2 = new com.in28minutes.java.variables.Actor();
		actor2.name = "ACTOR2";
		com.in28minutes.java.variables.Actor.count++;
		java.lang.System.out.println(actor1.name);
		java.lang.System.out.println(actor2.name);
		java.lang.System.out.println(actor1.count);
		java.lang.System.out.println(actor2.count);
		java.lang.System.out.println(com.in28minutes.java.variables.Actor.count);
	}
}