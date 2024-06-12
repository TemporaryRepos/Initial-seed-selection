public class MapTest {
	private static java.util.Map<java.lang.String, java.lang.String> map = new java.util.HashMap<java.lang.String, java.lang.String>();

	public static java.util.Map<java.lang.String, java.lang.String> getHashMap() {
		if ((com.pancm.basics.MapTest.map == null) || com.pancm.basics.MapTest.map.isEmpty()) {
			com.pancm.basics.MapTest.map = new java.util.HashMap<java.lang.String, java.lang.String>();
		}
		return com.pancm.basics.MapTest.map;
	}

	public static void main(java.lang.String[] args) {
		com.pancm.basics.MapTest.test1();
		com.pancm.basics.MapTest.test2();
	}

	private static void test1() {
		java.util.Map<java.lang.String, java.lang.String> map = new java.util.HashMap<java.lang.String, java.lang.String>();
		map.put("1", "value1");
		map.put("2", "value2");
		map.put("3", "value3");
		java.lang.System.out.println("通过Map.keySet遍历key和value：");
		for (java.lang.String key : map.keySet()) {
			java.lang.System.out.println((("key= " + key) + " and value= ") + map.get(key));
		}
		java.lang.System.out.println("通过Map.entrySet使用iterator遍历key和value：");
		java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			java.util.Map.Entry<java.lang.String, java.lang.String> entry = it.next();
			java.lang.System.out.println((("key= " + entry.getKey()) + " and value= ") + entry.getValue());
		} 
		java.lang.System.out.println("通过Map.entrySet遍历key和value");
		for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
			java.lang.System.out.println((("key= " + entry.getKey()) + " and value= ") + entry.getValue());
		}
	}

	private static void test2() {
		java.util.Map<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<java.lang.String, java.lang.Object>();
		hashMap.put("a", 1);
		hashMap.put("c", 3);
		hashMap.put("b", 2);
		java.lang.System.out.println("HashMap:" + hashMap);
		java.util.Map<java.lang.String, java.lang.Object> treeMap = new java.util.TreeMap<java.lang.String, java.lang.Object>();
		treeMap.put("a", 1);
		treeMap.put("c", 3);
		treeMap.put("b", 2);
		java.lang.System.out.println("TreeMap:" + treeMap);
	}

	@java.lang.SuppressWarnings("unused")
	private static void getMap1() {
		java.util.Map<java.lang.Integer, java.lang.Integer> map1 = new java.util.HashMap<java.lang.Integer, java.lang.Integer>();
		java.util.Map<java.lang.Integer, java.lang.Integer> map2 = new java.util.HashMap<java.lang.Integer, java.lang.Integer>();
		map1.put(1, 1);
		map1.put(2, 2);
		map1.put(3, 3);
		map2.put(11, 11);
		map2.put(22, 22);
		map2.put(33, 33);
		java.util.Map<java.lang.Integer, java.util.Map<java.lang.Integer, java.lang.Integer>> map3 = new java.util.HashMap<java.lang.Integer, java.util.Map<java.lang.Integer, java.lang.Integer>>();
		map3.put(1, map1);
		map3.put(2, map2);
		java.lang.System.out.println("map3:" + map3);
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		for (java.util.Map.Entry<java.lang.Integer, java.util.Map<java.lang.Integer, java.lang.Integer>> entry : map3.entrySet()) {
			sb.append(entry.getKey());
			sb.append(":");
			java.util.Map<java.lang.Integer, java.lang.Integer> map4 = entry.getValue();
			for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry1 : map4.entrySet()) {
				sb.append(entry1.getKey());
				sb.append("_");
				sb.append(entry1.getValue());
				sb.append(",");
			}
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		java.lang.System.out.println("sb:" + sb);
	}
}