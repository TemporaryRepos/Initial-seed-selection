public class Demo3 {
	public static void main(java.lang.String[] args) {
		haidnor.jvm.test.clazz.Student sut1 = new haidnor.jvm.test.clazz.Student();
		haidnor.jvm.test.clazz.Student sut2 = new haidnor.jvm.test.clazz.Student();
		java.util.HashMap<haidnor.jvm.test.clazz.Student, java.lang.String> hashMap = new java.util.HashMap<>();
		hashMap.put(sut1, "张三123");
		hashMap.put(sut2, "张三");
		java.lang.System.out.println(hashMap.get(sut1));
		java.lang.System.out.println(hashMap.get(sut2));
	}
}