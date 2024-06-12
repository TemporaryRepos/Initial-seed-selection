public class GuavaTest {
	public static void main(java.lang.String[] args) {
		com.pancm.commons.google.GuavaTest.noChangeList();
		com.pancm.commons.google.GuavaTest.one2MoreMap();
		com.pancm.commons.google.GuavaTest.more2One();
		com.pancm.commons.google.GuavaTest.filtedMap();
		com.pancm.commons.google.GuavaTest.joiner();
		com.pancm.commons.google.GuavaTest.splitter();
		com.pancm.commons.google.GuavaTest.integer();
	}

	private static void noChangeList() {
		com.google.common.collect.ImmutableList<java.lang.String> list = com.google.common.collect.ImmutableList.of("A", "B", "C");
		com.google.common.collect.ImmutableMap<java.lang.Integer, java.lang.String> map = com.google.common.collect.ImmutableMap.of(1, "壹", 2, "贰", 3, "叁");
		java.lang.System.out.println("ImmutableList:" + list);
		java.lang.System.out.println("ImmutableMap:" + map);
	}

	private static void one2MoreMap() {
		com.google.common.collect.Multimap<java.lang.String, java.lang.String> map = com.google.common.collect.ArrayListMultimap.create();
		map.put("路人甲", "123");
		map.put("路人甲", "234");
		map.put("路人乙", "567");
		map.put("路人乙", "890");
		java.lang.System.out.println("Multimap:" + map);
		java.lang.System.out.println("get:" + map.get("路人乙"));
	}

	private static void more2One() {
		com.google.common.collect.Table<java.lang.Double, java.lang.Double, java.lang.String> table = com.google.common.collect.HashBasedTable.create();
		table.put(22.54, 114.01, "深圳");
		table.put(39.96, 116.4, "北京");
		java.lang.System.out.println("Table:" + table);
		java.lang.System.out.println("Table.get:" + table.get(22.54, 114.01));
	}

	private static void filtedMap() {
		java.util.Map<java.lang.String, java.lang.Integer> map = new java.util.HashMap<java.lang.String, java.lang.Integer>();
		map.put("张三", 19);
		map.put("李四", 20);
		map.put("王五", 21);
		java.util.Map<java.lang.String, java.lang.Integer> filtedmap = com.google.common.collect.Maps.filterValues(map, new com.google.common.base.Predicate<java.lang.Integer>() {
			@java.lang.Override
			public boolean apply(java.lang.Integer age) {
				return age > 20;
			}
		});
		java.lang.System.out.println("Map:" + map);
		java.lang.System.out.println("filtedmap:" + filtedmap);
	}

	private static void joiner() {
		com.google.common.base.Joiner joiner = com.google.common.base.Joiner.on(",");
		java.lang.String str = joiner.skipNulls().join("你好", "java");
		java.util.Map<java.lang.String, java.lang.String> map = new java.util.HashMap<java.lang.String, java.lang.String>();
		map.put("张三", "你好");
		map.put("李四", "嗨");
		java.lang.String str1 = com.google.common.base.Joiner.on(",").withKeyValueSeparator(":").join(map);
		java.lang.System.out.println("Joiner: " + str);
		java.lang.System.out.println("Joiner: " + str1);
	}

	private static void splitter() {
		java.lang.String str = "你好,java";
		for (java.lang.String s : com.google.common.base.Splitter.on(",").split(str)) {
			java.lang.System.out.println("s:" + s);
		}
		for (java.lang.String d : com.google.common.base.Splitter.fixedLength(2).split(str)) {
			java.lang.System.out.println("d:" + d);
		}
	}

	private static void integer() {
		int[] ints = new int[]{ 1, 4, 3, 2 };
		java.lang.System.out.println("max:" + com.google.common.primitives.Ints.max(ints));
		java.util.List<java.lang.Integer> list = new java.util.ArrayList<java.lang.Integer>();
		list.add(1);
		list.add(3);
		list.add(6);
		int[] arr = com.google.common.primitives.Ints.toArray(list);
		for (int i = 0, j = arr.length; i < j; i++) {
			java.lang.System.out.println("arr:" + arr[i]);
		}
	}
}