public class TestReuse {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.oops.inheritance.reuse.Hero hero = new com.in28minutes.java.oops.inheritance.reuse.Hero();
		hero.act();
		hero.fight();
		com.in28minutes.java.oops.inheritance.reuse.Comedian comedian = new com.in28minutes.java.oops.inheritance.reuse.Comedian();
		comedian.act();
		comedian.performComedy();
		com.in28minutes.java.oops.inheritance.reuse.Actor actor1 = new com.in28minutes.java.oops.inheritance.reuse.Comedian();
		com.in28minutes.java.oops.inheritance.reuse.Actor actor2 = new com.in28minutes.java.oops.inheritance.reuse.Hero();
		java.lang.Object object = new com.in28minutes.java.oops.inheritance.reuse.Hero();
	}
}