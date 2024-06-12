public class demo_finally_1 {
	public static void main(java.lang.String[] args) {
		java.lang.String name = haidnor.jvm.test.demo.demo_finally_1.fun();
		java.lang.System.out.println(name);
	}

	public static java.lang.String fun() {
		java.lang.String str = "zhang san";
		try {
			return str;
		} finally {
			str = "li si";
		}
	}
}