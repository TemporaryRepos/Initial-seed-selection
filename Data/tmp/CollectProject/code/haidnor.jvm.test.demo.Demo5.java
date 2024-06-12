public class Demo5 {
	static {
		java.lang.System.out.println("hello,world");
	}

	public static void main(java.lang.String[] args) {
		java.lang.String str = haidnor.jvm.test.demo.Demo5.method1("hello world");
		haidnor.jvm.test.demo.Demo5.method1(str);
	}

	public static java.lang.String method1(java.lang.String s) {
		return haidnor.jvm.test.demo.Demo5.method2(s);
	}

	public static java.lang.String method2(java.lang.String s) {
		return haidnor.jvm.test.demo.Demo5.method3(s);
	}

	public static java.lang.String method3(java.lang.String s) {
		java.lang.System.out.println(s);
		return "你好 世界";
	}
}