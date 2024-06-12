public class LambdaTest {
	public static void main(java.lang.String[] args) {
		com.pancm.jdk8.LambdaTest.test1();
		com.pancm.jdk8.LambdaTest.test2();
	}

	private static void test1() {
		java.util.Map<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
		map.put("a", "a");
		map.put("b", "b");
		map.put("c", "c");
		map.put("d", "d");
		java.lang.System.out.println("map普通方式遍历:");
		for (java.lang.String key : map.keySet()) {
			java.lang.System.out.println((("k=" + key) + "，v=") + map.get(key));
		}
		java.lang.System.out.println("map拉姆达表达式遍历:");
		map.forEach(( k, v) -> {
			java.lang.System.out.println((("k=" + k) + "，v=") + v);
		});
		java.util.List<java.lang.String> list = new java.util.ArrayList<java.lang.String>();
		list.add("a");
		list.add("bb");
		list.add("ccc");
		list.add("dddd");
		java.lang.System.out.println("list拉姆达表达式遍历:");
		list.forEach(( v) -> {
			java.lang.System.out.println(v);
		});
		java.lang.System.out.println("list双冒号运算符遍历:");
		list.forEach(java.lang.System.out::println);
	}

	private static void test2() {
		java.util.List<com.pancm.jdk8.User> list = new java.util.ArrayList<com.pancm.jdk8.User>();
		java.util.List<com.pancm.jdk8.User> list2 = new java.util.ArrayList<com.pancm.jdk8.User>();
		list.add(new com.pancm.jdk8.User(1, "张三"));
		list.add(new com.pancm.jdk8.User(2, "李四"));
		list.add(new com.pancm.jdk8.User(3, "王五"));
		list.add(new com.pancm.jdk8.User(4, "赵六"));
		java.lang.System.out.println("list:" + list);
		list.forEach(( v) -> {
			if (v.getId() > 2) {
				list2.add(v);
			}
		});
		java.lang.System.out.println("list2:" + list2);
	}

	java.lang.Runnable r1 = new java.lang.Runnable() {
		@java.lang.Override
		public void run() {
			java.lang.System.out.println("普通方式创建!");
		}
	};

	java.lang.Runnable r2 = () -> java.lang.System.out.println("拉姆达方式创建!");
}