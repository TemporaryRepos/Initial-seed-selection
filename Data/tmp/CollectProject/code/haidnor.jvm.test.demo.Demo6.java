public class Demo6 {
	public static void main(java.lang.String[] args) {
		haidnor.jvm.test.clazz.Student student = new haidnor.jvm.test.clazz.Student();
		if (student instanceof haidnor.jvm.test.clazz.Human) {
			java.lang.System.out.println("true");
		}
	}
}