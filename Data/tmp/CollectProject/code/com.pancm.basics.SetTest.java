public class SetTest {
	public static void main(java.lang.String[] args) {
		java.util.Set hashSet = new java.util.HashSet();
		java.util.Set treeSet = new java.util.TreeSet();
		java.util.Set linkedSet = new java.util.LinkedHashSet();
		com.pancm.basics.SetTest.set();
		com.pancm.basics.SetTest.hashSetTest();
		com.pancm.basics.SetTest.treeSet1();
		com.pancm.basics.SetTest.treeSet2();
	}

	public static void set() {
		java.util.List<java.lang.String> list = new java.util.ArrayList<java.lang.String>();
		list.add("Jhon");
		list.add("Jency");
		list.add("Mike");
		list.add("Dmitri");
		list.add("Mike");
		java.util.Set<java.lang.String> set = new java.util.HashSet<java.lang.String>();
		for (int i = 0; i < list.size(); i++) {
			java.lang.String items = list.get(i);
			java.lang.System.out.println("items:" + items);
			if (!set.add(items)) {
				java.lang.System.out.println("重复的数据: " + items);
			}
		}
		java.lang.System.out.println("list:" + list);
	}

	@java.lang.SuppressWarnings({ "unchecked", "rawtypes" })
	public static void hashSetTest() {
		java.util.HashSet hs = new java.util.HashSet();
		hs.add(new com.pancm.basics.AA("ABC", 20));
		hs.add(new com.pancm.basics.AA("BCD", 20));
		hs.add(new com.pancm.basics.AA("CDE", 20));
		hs.add(new com.pancm.basics.AA("ABC", 20));
		hs.add(new com.pancm.basics.AA("BCD", 20));
		java.util.Iterator it = hs.iterator();
		while (it.hasNext()) {
			java.lang.Object next = it.next();
			java.lang.System.out.println("排序之前:" + next);
		} 
	}

	@java.lang.SuppressWarnings({ "unchecked", "rawtypes" })
	public static void treeSet1() {
		java.util.TreeSet ts = new java.util.TreeSet(new com.pancm.basics.MyComparator());
		ts.add(new com.pancm.basics.Book("think in java", 100));
		ts.add(new com.pancm.basics.Book("java 核心技术", 75));
		ts.add(new com.pancm.basics.Book("现代操作系统", 50));
		ts.add(new com.pancm.basics.Book("java就业教程", 35));
		ts.add(new com.pancm.basics.Book("think in java", 100));
		ts.add(new com.pancm.basics.Book("ccc in java", 100));
		java.lang.System.out.println("treeSet1:" + ts);
	}

	@java.lang.SuppressWarnings({ "unchecked", "rawtypes" })
	public static void treeSet2() {
		java.util.TreeSet ts = new java.util.TreeSet();
		ts.add(new com.pancm.basics.Person("aa", 20, "男"));
		ts.add(new com.pancm.basics.Person("bb", 18, "女"));
		ts.add(new com.pancm.basics.Person("cc", 17, "男"));
		ts.add(new com.pancm.basics.Person("dd", 17, "女"));
		ts.add(new com.pancm.basics.Person("dd", 15, "女"));
		ts.add(new com.pancm.basics.Person("dd", 15, "女"));
		java.lang.System.out.println("treeSet2:" + ts);
		java.lang.System.out.println(ts.size());
	}
}