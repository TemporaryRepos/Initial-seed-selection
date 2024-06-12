public class ListTest {
	private static final int count = 50000;

	private static java.util.ArrayList arrayList = new java.util.ArrayList<>();

	private static java.util.LinkedList linkedList = new java.util.LinkedList<>();

	private static java.util.Vector vector = new java.util.Vector<>();

	public static void main(java.lang.String[] args) {
		com.pancm.basics.ListTest.test3();
		java.util.Vector<java.lang.String> v = new java.util.Vector<>();
	}

	private static void test1() {
		java.util.List<java.lang.String> list = new java.util.ArrayList<java.lang.String>();
		list.add("a");
		list.add("b");
		list.add("c");
		java.lang.System.out.println("list截取:" + list.subList(0, 1));
		java.lang.System.out.println("list截取:" + list.subList(1, 3));
		for (int i = 0; i < list.size(); i++) {
			java.lang.System.out.println(list.get(i));
		}
		for (java.lang.String str : list) {
			java.lang.System.out.println(str);
		}
		java.util.Iterator<java.lang.String> iterator = list.iterator();
		while (iterator.hasNext()) {
			java.lang.System.out.println(iterator.next());
		} 
	}

	private static void test2() {
		java.util.List<java.lang.String> list1 = new java.util.ArrayList<java.lang.String>();
		list1.add("1");
		list1.add("2");
		java.lang.System.out.println("list1遍历之前:" + list1);
		java.util.Iterator<java.lang.String> iterator = list1.iterator();
		while (iterator.hasNext()) {
			java.lang.String item = iterator.next();
			if ("2".equals(item)) {
				iterator.remove();
			}
		} 
		java.lang.System.out.println("list1遍历之后:" + list1);
		java.util.List<java.lang.String> list = new java.util.ArrayList<java.lang.String>();
		list.add("1");
		list.add("2");
		java.lang.System.out.println("list遍历之前:" + list);
		for (java.lang.String item : list) {
			if ("2".equals(item)) {
				list.remove(item);
				break;
			}
		}
		java.lang.System.out.println("list遍历之后:" + list);
	}

	private static void test3() {
		java.util.List<java.lang.Integer> list = com.pancm.basics.ListTest.initData(100);
		java.lang.System.out.println("list:" + list);
		java.lang.System.out.println("removeList:" + com.pancm.basics.ListTest.removeList(list, 10, 20));
		list.subList(10, 20).clear();
		java.lang.System.out.println("subList:" + list);
		java.util.List<java.lang.String> ls1 = new java.util.ArrayList<java.lang.String>();
		java.util.List<java.lang.String> ls2 = new java.util.ArrayList<java.lang.String>();
		ls1.add("a");
		ls1.add("b");
		ls1.add("c");
		ls2.add("a");
		ls2.add("b");
		ls2.add("c");
		ls2.add("e");
		java.lang.System.out.println("差集 :" + com.pancm.basics.ListTest.removeAll(ls2, ls1));
	}

	private static void test4() {
		java.util.LinkedList<java.lang.Integer> list = new java.util.LinkedList<java.lang.Integer>();
		list.add(3);
		list.add(5);
		list.add(4);
		java.lang.System.out.println(list);
		list.addFirst(2);
		list.addLast(4);
		java.lang.System.out.println(list);
		java.util.LinkedList<java.lang.Integer> list2 = new java.util.LinkedList<java.lang.Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(4);
		list2.add(4);
		list2.add(6);
		list2.add(6);
		list2.add(5);
		java.lang.System.out.println("去重之前:" + list2);
		java.util.List<java.lang.Integer> newList = list2.stream().distinct().collect(java.util.stream.Collectors.toList());
		java.lang.System.out.println("去重之后:" + newList);
	}

	private static void test5() {
		com.pancm.basics.ListTest.insertList(com.pancm.basics.ListTest.arrayList);
		com.pancm.basics.ListTest.insertList(com.pancm.basics.ListTest.linkedList);
		com.pancm.basics.ListTest.insertList(com.pancm.basics.ListTest.vector);
		java.lang.System.out.println("--------------------");
		com.pancm.basics.ListTest.readList(com.pancm.basics.ListTest.arrayList);
		com.pancm.basics.ListTest.readList(com.pancm.basics.ListTest.linkedList);
		com.pancm.basics.ListTest.readList(com.pancm.basics.ListTest.vector);
		java.lang.System.out.println("--------------------");
		com.pancm.basics.ListTest.delList(com.pancm.basics.ListTest.arrayList);
		com.pancm.basics.ListTest.delList(com.pancm.basics.ListTest.linkedList);
		com.pancm.basics.ListTest.delList(com.pancm.basics.ListTest.vector);
	}

	private static void insertList(java.util.List list) {
		long start = java.lang.System.currentTimeMillis();
		java.lang.Object o = new java.lang.Object();
		for (int i = 0; i < com.pancm.basics.ListTest.count; i++) {
			list.add(0, o);
		}
		java.lang.System.out.println(((((com.pancm.basics.ListTest.getName(list) + "插入") + com.pancm.basics.ListTest.count) + "条数据，耗时:") + (java.lang.System.currentTimeMillis() - start)) + "ms");
	}

	private static void readList(java.util.List list) {
		long start = java.lang.System.currentTimeMillis();
		java.lang.Object o = new java.lang.Object();
		for (int i = 0; i < com.pancm.basics.ListTest.count; i++) {
			list.get(i);
		}
		java.lang.System.out.println(((((com.pancm.basics.ListTest.getName(list) + "查询") + com.pancm.basics.ListTest.count) + "条数据，耗时:") + (java.lang.System.currentTimeMillis() - start)) + "ms");
	}

	private static void delList(java.util.List list) {
		long start = java.lang.System.currentTimeMillis();
		java.lang.Object o = new java.lang.Object();
		for (int i = 0; i < com.pancm.basics.ListTest.count; i++) {
			list.remove(0);
		}
		java.lang.System.out.println(((((com.pancm.basics.ListTest.getName(list) + "删除") + com.pancm.basics.ListTest.count) + "条数据，耗时:") + (java.lang.System.currentTimeMillis() - start)) + "ms");
	}

	private static java.lang.String getName(java.util.List list) {
		java.lang.String name = "";
		if (list instanceof java.util.ArrayList) {
			name = "ArrayList";
		} else if (list instanceof java.util.LinkedList) {
			name = "LinkedList";
		} else if (list instanceof java.util.Vector) {
			name = "Vector";
		}
		return name;
	}

	private static java.util.List<java.lang.Integer> removeList(java.util.List<java.lang.Integer> list, int s, int d) {
		for (int i = 0, j = list.size(); i < j; i++) {
			if ((i >= s) && (i < d)) {
				list.remove(i);
			}
		}
		return list;
	}

	private static java.util.List<java.lang.Integer> initData(int j) {
		java.util.List<java.lang.Integer> list = new java.util.ArrayList<java.lang.Integer>();
		for (int i = 1; i <= j; i++) {
			list.add(i);
		}
		return list;
	}

	private static java.util.List<java.lang.String> addAll(java.util.List<java.lang.String> ls1, java.util.List<java.lang.String> ls2) {
		ls1.addAll(ls2);
		return ls1;
	}

	private static java.util.List<java.lang.String> retainAll(java.util.List<java.lang.String> ls1, java.util.List<java.lang.String> ls2) {
		java.lang.System.out.println((("ls1:" + ls1) + ";ls2:") + ls2);
		ls1.retainAll(ls2);
		return ls1;
	}

	private static java.util.List<java.lang.String> removeAll(java.util.List<java.lang.String> ls1, java.util.List<java.lang.String> ls2) {
		java.lang.System.out.println((("ls1:" + ls1) + ";ls2:") + ls2);
		ls1.removeAll(ls2);
		return ls1;
	}

	private static java.util.List<java.lang.String> andAll(java.util.List<java.lang.String> ls1, java.util.List<java.lang.String> ls2) {
		ls2.removeAll(ls1);
		ls1.addAll(ls2);
		java.lang.System.out.println((ls1 + ";ls2:") + ls2);
		return ls1;
	}
}