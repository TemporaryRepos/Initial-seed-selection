public class Overloading {
	public int test() {
		java.lang.System.out.println("test");
		return 1;
	}

	public void test(int a) {
		java.lang.System.out.println("test " + a);
	}

	public java.lang.String test(int a, java.lang.String s) {
		java.lang.System.out.println((("test " + a) + " ") + s);
		return (a + " ") + s;
	}

	public static void main(java.lang.String[] args) {
		com.flink.tutorials.java.chapter2_basics.Overloading o = new com.flink.tutorials.java.chapter2_basics.Overloading();
		java.lang.System.out.println(o.test());
		o.test(1);
		java.lang.System.out.println(o.test(1, "test3"));
	}
}