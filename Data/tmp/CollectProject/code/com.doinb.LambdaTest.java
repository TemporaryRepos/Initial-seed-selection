@lombok.extern.slf4j.Slf4j
public class LambdaTest {
	public static void main(java.lang.String[] args) {
		com.doinb.LambdaTest.lambdaTest();
	}

	public static void lambdaTest() {
		com.doinb.LambdaTest lambdaTest = new com.doinb.LambdaTest();
		java.util.List<com.doinb.LambdaTest.Student> list = lambdaTest.getStudents();
		java.util.List<com.doinb.LambdaTest.Demo> demos = new java.util.ArrayList<>();
		java.lang.System.out.println("原始数据 组装list<demo>*******************");
		demos = list.stream().map(( student) -> new com.doinb.LambdaTest.Demo(student.getName(), student.getAge(), student.getSex())).collect(java.util.stream.Collectors.toList());
		demos.forEach(( demo) -> {
			java.lang.System.out.println(((("年龄 " + demo.getAge()) + "  性别 ") + demo.getSex()) + ",");
		});
		java.lang.System.out.println("只取sex为0**************** 去重");
		java.util.List<com.doinb.LambdaTest.Demo> demorm = demos.stream().filter(( demo) -> demo.getSex() == 0).distinct().collect(java.util.stream.Collectors.toList());
		demorm.forEach(( demo) -> {
			java.lang.System.out.println(((("年龄 " + demo.getAge()) + "  性别 ") + demo.getSex()) + ",");
		});
		java.lang.System.out.println("只取sex为0**************** 非去重");
		demos.stream().filter(( demo) -> demo.getSex() == 0).collect(java.util.stream.Collectors.toList()).forEach(( demo) -> java.lang.System.out.println(((("年龄 " + demo.getAge()) + "  性别 ") + demo.getSex()) + ","));
		java.lang.System.out.println("筛选年龄大于12岁的*************");
		java.util.List<com.doinb.LambdaTest.Demo> demoFilter = demos.stream().filter(( demo) -> java.lang.Integer.valueOf(demo.getAge()) > 12).collect(java.util.stream.Collectors.toList());
		demoFilter.forEach(( demo) -> {
			java.lang.System.out.println(((("年龄 " + demo.getAge()) + "  性别 ") + demo.getSex()) + ",");
		});
		java.lang.System.out.println("年龄排序******************");
		java.util.List<com.doinb.LambdaTest.Demo> demoSort = demos.stream().sorted(java.util.Comparator.comparing(com.doinb.LambdaTest.Demo::getAge)).collect(java.util.stream.Collectors.toList());
		demoSort.forEach(( demo) -> {
			java.lang.System.out.println(("年龄 " + demo.getAge()) + ",");
		});
		java.lang.System.out.println("年龄倒序****************");
		java.util.ArrayList<com.doinb.LambdaTest.Demo> demoArray = ((java.util.ArrayList<com.doinb.LambdaTest.Demo>) (demos));
		java.util.Comparator<com.doinb.LambdaTest.Demo> comparator = java.util.Comparator.comparing(com.doinb.LambdaTest.Demo::getAge);
		demos.sort(comparator.reversed());
		demos.sort(java.util.Comparator.comparing(com.doinb.LambdaTest.Demo::getAge).reversed());
		demos.forEach(( demo) -> {
			java.lang.System.out.println(("年龄 " + demo.getAge()) + ",");
		});
		java.lang.System.out.println("多条件排序正序****************");
		demoArray.sort(java.util.Comparator.comparing(com.doinb.LambdaTest.Demo::getSex).thenComparing(com.doinb.LambdaTest.Demo::getAge));
		demoArray.forEach(( demo) -> {
			java.lang.System.out.println(((("年龄 " + demo.getAge()) + "  性别 ") + demo.getSex()) + ",");
		});
		java.lang.System.out.println("多条件排序倒序 sex  倒序****************");
		demoArray.sort(java.util.Comparator.comparing(com.doinb.LambdaTest.Demo::getSex).reversed().thenComparing(com.doinb.LambdaTest.Demo::getAge));
		demoArray.forEach(( demo) -> {
			java.lang.System.out.println(((("年龄 " + demo.getAge()) + "  性别 ") + demo.getSex()) + ",");
		});
		java.lang.System.out.println("========================================================\n");
		java.lang.System.out.println("根据age分组结果为Map****************");
		java.util.Map<java.lang.String, java.util.List<com.doinb.LambdaTest.Demo>> demoOder = demos.stream().collect(java.util.stream.Collectors.groupingBy(com.doinb.LambdaTest.Demo::getAge));
		java.lang.System.out.println(demoOder);
		java.lang.System.out.println("#根据age获取值#");
		java.lang.System.out.println(demoOder.get("12"));
		java.lang.System.out.println("========================================================\n");
		java.lang.System.out.println(" >>> 收集为demoMaps1**************");
		java.util.HashMap<java.lang.String, com.doinb.LambdaTest.Demo> demoMaps1 = demos.stream().collect(java.util.stream.Collectors.toMap(com.doinb.LambdaTest.Demo::getName, java.util.function.Function.identity(), ( k1, k2) -> k2, java.util.HashMap::new));
		demoMaps1.forEach(( key, value) -> java.lang.System.out.println((key + "=") + value));
		java.lang.System.out.println("========================================================\n");
		java.lang.System.out.println(" >>> 收集为demoMaps2**************");
		java.util.HashMap<java.lang.String, java.lang.Object> demoMaps2 = demos.stream().collect(java.util.HashMap::new, ( k, v) -> k.put(v.getName(), v.getAge()), java.util.HashMap::putAll);
		demoMaps2.forEach(( key, value) -> java.lang.System.out.println((key + "=") + value));
	}

	private java.util.List<com.doinb.LambdaTest.Student> getStudents() {
		java.util.List<com.doinb.LambdaTest.Student> list = new java.util.ArrayList<>();
		list.add(new com.doinb.LambdaTest.Student().setAge("12").setSex(1).setName("张三丰"));
		list.add(new com.doinb.LambdaTest.Student().setAge("12").setSex(1).setName("赵无极"));
		list.add(new com.doinb.LambdaTest.Student().setAge("11").setSex(1).setName("冯绍峰"));
		list.add(new com.doinb.LambdaTest.Student().setAge("18").setSex(0).setName("杨幂"));
		list.add(new com.doinb.LambdaTest.Student().setAge("20").setSex(1).setName("tfboy"));
		list.add(new com.doinb.LambdaTest.Student().setAge("29").setSex(1).setName("李逵"));
		list.add(new com.doinb.LambdaTest.Student().setAge("28").setSex(1).setName("黑人"));
		list.add(new com.doinb.LambdaTest.Student().setAge("31").setSex(1).setName("黑人"));
		list.add(new com.doinb.LambdaTest.Student().setAge("30").setSex(1).setName("黑人"));
		list.add(new com.doinb.LambdaTest.Student().setAge("23").setSex(1).setName("tfboy"));
		return list;
	}

	@lombok.Data
	@lombok.NoArgsConstructor
	@lombok.AllArgsConstructor
	@lombok.experimental.Accessors(chain = true)
	static class Demo {
		private java.lang.String name;

		private java.lang.String age;

		private java.lang.Integer sex;
	}

	@lombok.Data
	@lombok.experimental.Accessors(chain = true)
	static class Student {
		private java.lang.String name;

		private java.lang.String age;

		private java.lang.Integer sex;
	}
}