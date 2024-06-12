public class InnerClassApplication {
	private java.lang.String gender = "male";

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaprogramming.commonmistakes.advancedfeatures.innerclass.InnerClassApplication application = new javaprogramming.commonmistakes.advancedfeatures.innerclass.InnerClassApplication();
		application.test();
	}

	private void test() {
		javaprogramming.commonmistakes.advancedfeatures.innerclass.InnerClassApplication.MyInnerClass myInnerClass = new javaprogramming.commonmistakes.advancedfeatures.innerclass.InnerClassApplication.MyInnerClass();
		java.lang.System.out.println(myInnerClass.name);
		myInnerClass.test();
	}

	class MyInnerClass {
		private java.lang.String name = "zhuye";

		void test() {
			java.lang.System.out.println(gender);
		}
	}
}