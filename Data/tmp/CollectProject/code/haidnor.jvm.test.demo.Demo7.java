public class Demo7 {
	public static void main(java.lang.String[] args) {
		try {
			java.lang.String name = haidnor.jvm.test.demo.Demo7.fun();
			java.lang.System.out.println(name);
		} catch (java.lang.Exception exception) {
			java.lang.System.out.println("计算错误");
		}
	}

	public static java.lang.String fun() {
		java.lang.System.out.println(1 / 0);
		return "zhangsan";
	}
}