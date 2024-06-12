public class SuperTest extends com.pancm.basics.Person8 {
	SuperTest() {
		super();
		com.pancm.basics.Person8.prt("A chinese.");
	}

	SuperTest(java.lang.String name) {
		super(name);
		com.pancm.basics.Person8.prt("his name is:" + name);
	}

	SuperTest(java.lang.String name, int age) {
		this(name);
		com.pancm.basics.Person8.prt("his age is:" + age);
	}

	public static void main(java.lang.String[] args) {
		com.pancm.basics.SuperTest cn = new com.pancm.basics.SuperTest();
		cn = new com.pancm.basics.SuperTest("kevin");
		cn = new com.pancm.basics.SuperTest("kevin", 22);
	}
}