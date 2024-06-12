public class ExtendsTest2 {
	public static void main(java.lang.String[] args) {
		com.pancm.basics.A a1 = new com.pancm.basics.A();
		com.pancm.basics.A a2 = new com.pancm.basics.B();
		com.pancm.basics.B b = new com.pancm.basics.B();
		com.pancm.basics.C c = new com.pancm.basics.C();
		com.pancm.basics.D d = new com.pancm.basics.D();
		java.lang.System.out.println("1--" + a1.show(b));
		java.lang.System.out.println("2--" + a1.show(c));
		java.lang.System.out.println("3--" + a1.show(d));
		java.lang.System.out.println("4--" + a2.show(b));
		java.lang.System.out.println("5--" + a2.show(c));
		java.lang.System.out.println("6--" + a2.show(d));
		java.lang.System.out.println("7--" + b.show(b));
		java.lang.System.out.println("8--" + b.show(c));
		java.lang.System.out.println("9--" + b.show(d));
	}
}